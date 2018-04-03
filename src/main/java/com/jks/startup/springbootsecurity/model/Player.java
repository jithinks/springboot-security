package com.jks.startup.springbootsecurity.model;

public class Player {
    private String number;
    private String name;
    private int matchesPlayed;

    public Player() {
    }

    public Player(String number, String name, int matchesPlayed) {
        this.number = number;
        this.name = name;
        this.matchesPlayed = matchesPlayed;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    @Override
    public String toString() {
        return String.format(
                "Player [number=%s, name=%s, matchesPlayed=%s]",
                number, name, matchesPlayed);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((number == null) ? 0 : number.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)return true;
        if (obj == null)return false;
        if (getClass() != obj.getClass())return false;

        Player other = (Player) obj;
        if (number == null) {
            if (other.number != null) return false;
        } else if (!number.equals(other.number))
            return false;
        return true;
    }
}
