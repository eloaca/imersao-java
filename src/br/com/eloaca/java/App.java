package br.com.eloaca.java;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) throws RuntimeException {

        var url = "https://imdb-api.com/en/API/Top250Movies/k_rf843lgk";
        URI address = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> send;

        try {
            send = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }

        var json = new JsonParser();
        List<Map<String, String>> listaDeFilmes = json.parse(send.body());

        for (Map<String,String> filme : listaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
    }


}
