package br.com.simulavoz;

import java.text.Normalizer;
import java.util.Locale;

final class ReplyService {
    private static final String MENU = """
            Olá! Sou o bot do SimulaVoz DETRAN.
            Digite uma opção:
            1. Conhecer o projeto
            2. Ver uma questão de exemplo
            3. Saber como responder
            """.stripTrailing();

    String replyTo(String message) {
        var command = Normalizer.normalize(message.strip().toLowerCase(Locale.ROOT), Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "");

        return switch (command) {
            case "oi", "ola", "menu" -> MENU;
            case "1" -> "O SimulaVoz é um projeto universitário de acessibilidade para quem estuda "
                    + "para a prova teórica de trânsito. Digite 2 para ver uma questão de exemplo.";
            case "2" -> """
                    Questão de exemplo
                    O que o condutor deve fazer diante de um semáforo vermelho?
                    A. Parar antes da linha de retenção.
                    B. Acelerar para liberar o cruzamento.
                    C. Buzinar e seguir.
                    Digite A, B ou C para responder.
                    """.stripTrailing();
            case "3" -> "Digite 2 para ler a questão e responda com A, B ou C. Digite menu para voltar.";
            case "a" -> "Resposta correta! O condutor deve parar antes da linha de retenção. Digite menu para voltar.";
            case "b", "c" -> "A resposta correta é A. O condutor deve parar antes da linha de retenção. "
                    + "Digite menu para voltar.";
            default -> "Não reconheci essa opção. Digite menu para ver os comandos.";
        };
    }
}
