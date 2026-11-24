package br.com.simulavoz;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public final class BotApplication {
    public static void main(String[] args) {
        var replyService = new ReplyService();

        if (args.length == 0) {
            new WhatsAppBot(replyService).run();
            return;
        }

        if (args.length == 1 && args[0].equals("--console")) {
            System.out.println("Modo de teste do SimulaVoz. Digite uma mensagem ou use Ctrl+D para sair.");
            try (var input = new Scanner(System.in, StandardCharsets.UTF_8)) {
                while (input.hasNextLine()) {
                    System.out.println(replyService.replyTo(input.nextLine()));
                }
            }
            return;
        }

        throw new IllegalArgumentException("Execute sem argumentos para usar o WhatsApp ou use --console.");
    }
}
