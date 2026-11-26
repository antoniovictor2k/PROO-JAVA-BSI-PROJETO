package br.com.simulavoz;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.WaitUntilState;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

final class WhatsAppBot {
    private static final String WEB_URL = "https://web.whatsapp.com";
    private final ReplyService replyService;

    WhatsAppBot(ReplyService replyService) {
        this.replyService = replyService;
    }

    void run() {
        System.out.println("Abrindo o WhatsApp Web. Na primeira execução, aguarde o download do navegador.");
        var profile = Path.of(".whatsapp-session", "chromium").toAbsolutePath();
        try (var playwright = Playwright.create();
             var context = playwright.chromium().launchPersistentContext(profile,
                     new BrowserType.LaunchPersistentContextOptions().setHeadless(false))) {
            var page = context.pages().isEmpty() ? context.newPage() : context.pages().getFirst();
            page.exposeBinding("simulaVozReply", (source, args) -> {
                if (source.frame() != page.mainFrame() || !source.frame().url().startsWith(WEB_URL + "/")) {
                    throw new IllegalStateException("Origem de mensagem inesperada.");
                }
                return replyService.replyTo((String) args[0]);
            });
            page.onConsoleMessage(message -> {
                if (message.text().startsWith("[SimulaVoz] ")) {
                    System.out.println(message.text());
                }
            });
            // Registra o atendimento também quando a página recarrega após o pareamento.
            var connector = resource("/vendor/wa-js-4.8.2/wppconnect-wa.js") + "\n"
                    + resource("/whatsapp-listener.js");
            page.addInitScript("""
                    if (window === window.top && location.origin === 'https://web.whatsapp.com') {
                        // Os módulos de mensagens só estão disponíveis na tela de conversas.
                        const observer = new MutationObserver(() => {
                            if (document.querySelector('#pane-side, [data-testid="chat-list"]')) {
                                observer.disconnect();
                                startConnector();
                            }
                        });
                        observer.observe(document, {childList: true, subtree: true});
                        function startConnector() {
                    """ + connector + "\n}\n}");
            page.navigate(WEB_URL, new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
            System.out.println("Se o WhatsApp pedir o vínculo, escaneie o QR mostrado no navegador.");
            page.waitForClose(new Page.WaitForCloseOptions().setTimeout(0), () -> {});
        }
    }

    private static String resource(String path) {
        try (var stream = WhatsAppBot.class.getResourceAsStream(path)) {
            if (stream == null) {
                throw new IllegalStateException("Recurso ausente na compilação: " + path);
            }
            return new String(stream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException error) {
            throw new UncheckedIOException("Falha ao carregar o conector do navegador.", error);
        }
    }
}
