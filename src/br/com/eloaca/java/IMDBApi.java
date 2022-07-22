package br.com.eloaca.java;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.List;

public class IMDBApi {

    public void buscaTopFilmes() throws IOException {

        //var url = "https://imdb-api.com/en/API/Top250Movies/k_rf843lgk";
        var url = "https://raw.githubusercontent.com/alura-cursos/imersao-java/api/TopMovies.json";

        ClienteHttp http = new ClienteHttp();
        var send= http.response(url);

        List<Movie> listaFilme = jsonToListaDeFilmes(send);

        InputStream urlImage;
        var nomeImage = "";

        var geradoraDeFigurinhas = new GeradoraDeFigurinhas();

        for (int i = 0; i < 10; i++) {
            nomeImage = listaFilme.get(i).title;
            urlImage = new URL(listaFilme.get(i).image).openStream();
            geradoraDeFigurinhas.gerador(urlImage, "ELOA", nomeImage);
        }
    }

    private List<Movie> jsonToListaDeFilmes(String send){
        Gson gson = new Gson();
        Type movieType = new TypeToken<List<Movie>>(){}.getType();

        char c = send.charAt(0);
        var x = 0;

        while (c != '['){
            c = send.charAt(x);
            x++;
        }
        send = send.substring(x-1);
        x = 0;

        while (c != ']') {
            c = send.charAt(x);
            x++;
        }
        send = send.substring(0, x);

        return gson.fromJson(send, movieType);
    }
}
