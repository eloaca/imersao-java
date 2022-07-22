package br.com.eloaca.java;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class NASAApi {

    public void buscaMetaDados() {

        var url = "https://api.nasa.gov/EPIC/api/natural?api_key=DEMO_KEY";

        ClienteHttp http = new ClienteHttp();
        var send= http.response(url);

        Gson gson = new Gson();

        Type nasaType = new TypeToken<List<Nasa>>(){}.getType();
        List<Nasa> listaNasa = gson.fromJson(send, nasaType);
    }
}
