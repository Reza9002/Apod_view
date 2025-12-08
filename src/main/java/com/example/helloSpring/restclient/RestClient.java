package com.example.helloSpring.restclient;

import com.example.helloSpring.model.Apod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

public class RestClient {


    private static final String API_KEY  = "DEMO_KEY";

    private static final String URL = "https://api.nasa.gov/planetary/apod?api_key="+API_KEY+"&date=";
    private static RestTemplate template = new RestTemplate(); // Erstellt eine statische Instanz von RestTemplate, die für HTTP-Anfragen verwendet wird.

    public static Apod createApod(LocalDate date) {
        ResponseEntity<Apod> response = template.getForEntity(URL + date, Apod.class);
        return response.getBody();
    }

}

// Diese Methode gibt ein Apod-Objekt zurück, das die Daten für das angegebene Datum enthält.
// Führt eine GET-Anfrage an die NASA API durch, um die Daten für das angegebene Datum abzurufen.
// Die Antwort wird als ResponseEntity<Apod> gespeichert, wobei Apod.class angibt, dass die Antwort in ein Apod-Objekt umgewandelt wird.
// Gibt den Body der Antwort zurück, der das Apod-Objekt enthält.