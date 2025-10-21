package com.atvJackson6.atividadePratica6;

import com.atvJackson6.atividadePratica6.model.ResultadoEmails;
import com.atvJackson6.atividadePratica6.service.ProcessadorEmails;


public class Main {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   PROCESSADOR DE EMAILS - MARKETING   ║");
        System.out.println("╚════════════════════════════════════════╝\n");

        // Criar processador
        ProcessadorEmails processador = new ProcessadorEmails();

        // Processar emails
        ResultadoEmails resultado = processador.processar();

        if (resultado != null) {
            exibirResultados(resultado);
        } else {
            System.err.println("\n❌ Erro ao processar emails!");
        }
    }

    private static void exibirResultados(ResultadoEmails resultado) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║            RESULTADOS                  ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("📊 Total de comentários: " + resultado.getTotalComentarios());
        System.out.println("✅ E-mails válidos: " + resultado.getEmailsValidos());
        System.out.println("❌ E-mails inválidos: " + resultado.getEmailsInvalidos());

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║     LISTA DE E-MAILS VÁLIDOS          ║");
        System.out.println("╚════════════════════════════════════════╝");

        int count = 1;
        for (String email : resultado.getListaEmailsValidos()) {
            System.out.printf("%3d. %s%n", count, email);
            count++;

            // Mostrar apenas os primeiros 10 (opcional)
            if (count > 10) {
                System.out.println("... e mais " +
                        (resultado.getEmailsValidos() - 10) + " emails");
                break;
            }
        }

        // Exibir inválidos se houver
        if (resultado.getEmailsInvalidos() > 0) {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║    LISTA DE E-MAILS INVÁLIDOS         ║");
            System.out.println("╚════════════════════════════════════════╝");

            count = 1;
            for (String email : resultado.getListaEmailsInvalidos()) {
                System.out.printf("%3d. %s%n", count, email);
                count++;
            }
        }

        System.out.println("\n✨ Processamento concluído com sucesso!");
    }
}