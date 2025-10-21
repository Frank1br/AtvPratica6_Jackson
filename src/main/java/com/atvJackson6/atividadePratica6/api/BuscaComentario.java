package com.atvJackson6.atividadePratica6.api;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
public class BuscaComentario {
    public String obterComentarios() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String url = "https://jsonplaceholder.typicode.com/comments";

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
