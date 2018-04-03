package com.jks.startup.springbootsecurity.model;

import java.util.List;

public class Team {
    private String country;
    private String name;
    private String coach;
    private int rank;
    private List<Player> players;

    public Team() {
    }

    public Team(String country, String name, String coach, int rank, List<Player> players) {
        this.country = country;
        this.name = name;
        this.coach = coach;
        this.rank = rank;
        this.players = players;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoach() {
        return coach;
    }

    public void setCoach(String coach) {
        this.coach = coach;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    @Override
    public String toString() {
        return String.format(
                "Team [country=%s, name=%s, coach=%s, rank=%s, players=%s]",
                country, name, coach, rank, players);
    }
}
