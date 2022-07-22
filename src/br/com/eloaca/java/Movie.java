package br.com.eloaca.java;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Movie {

    @JsonProperty("id")
    String id;

    @JsonProperty("rank")
    Long rank;
    @JsonProperty("title")
    String title;

    @JsonProperty("fullTitle")
    String fullTitle;

    @JsonProperty("year")
    Integer year;

    @JsonProperty("image")
    String image;

    @JsonProperty("crew")
    String crew;

    @JsonProperty("imDbRating")
    Double imDbRating;

    @JsonProperty("imDbRatingCount")
    Long imDbRatingCount;
}
