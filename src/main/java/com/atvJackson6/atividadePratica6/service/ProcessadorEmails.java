package com.atvJackson6.atividadePratica6.service;
import com.atvJackson6.atividadePratica6.api.BuscaComentarios;
import com.atvJackson6.atividadePratica6.model.Comentario;
import com.atvJackson6.atividadePratica6.model.ResultadoEmails;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

public class ProcessadorEmails {

    private BuscaComentarios buscaComentarios;
    private ValidadorEmail validadorEmail;
    private ObjectMapper objectMapper;

    public ProcessadorEmails() {
        this.buscaComentarios = new BuscaComentarios();
        this.validadorEmail = new ValidadorEmail();
        this.objectMapper = new ObjectMapper();
    }

    public ResultadoEmails processar() {
        try {
            // 1. Buscar JSON da API
            System.out.println("Buscando comentários da API...");
            String jsonResponse = buscaComentarios.obterComentarios();

            // 2. Converter JSON para array de objetos
            System.out.println("Convertendo JSON para objetos...");
            Comentario[] comentarios = objectMapper.readValue(
                    jsonResponse,
                    Comentario[].class
            );

            // 3. Processar e validar emails
            System.out.println("Validando " + comentarios.length + " emails...");
            List<String> emailsValidos = new ArrayList<>();
            List<String> emailsInvalidos = new ArrayList<>();

            for (Comentario comentario : comentarios) {
                String email = comentario.getEmail();

                if (validadorEmail.isValido(email)) {
                    emailsValidos.add(email);
                } else {
                    emailsInvalidos.add(email);
                }
            }

            // 4. Criar e retornar resultado
            return new ResultadoEmails(
                    comentarios.length,
                    emailsValidos.size(),
                    emailsInvalidos.size(),
                    emailsValidos,
                    emailsInvalidos
            );

        } catch (Exception e) {
            System.err.println("Erro ao processar emails: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}

