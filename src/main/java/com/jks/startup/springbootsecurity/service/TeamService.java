package com.jks.startup.springbootsecurity.service;

import com.jks.startup.springbootsecurity.model.Player;
import com.jks.startup.springbootsecurity.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TeamService {

    private static List<Team> teams = new ArrayList<>();

    static {
        // Initialize Data
        Player p1 = new Player("11", "Jack", 99);
        Player p2 = new Player("19", "Jill", 50);

        Team t1 = new Team(
                "Newzland",
                "Kiwis",
                "David",
                1,
                Arrays.asList(p1, p2));
        teams.add(t1);
    }

    public Team getTeam(String teamCountry) {
        for (Team t: teams){
            if(t.getCountry().equalsIgnoreCase(teamCountry)){
                return t;
            }
        }
        return null;
    }
}
