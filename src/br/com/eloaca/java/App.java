package br.com.eloaca.java;

public class App {

    public static void main(String[] args) throws Exception {

        var imdbApi = new IMDBApi();
        var nasaApi = new NASAApi();

        imdbApi.buscaTopFilmes();
        nasaApi.buscaMetaDados();
    }
}
