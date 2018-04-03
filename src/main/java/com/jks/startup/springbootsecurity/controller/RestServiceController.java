package com.jks.startup.springbootsecurity.controller;

import com.jks.startup.springbootsecurity.model.Team;
import com.jks.startup.springbootsecurity.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class RestServiceController {

    @Autowired
    private TeamService teamService;

    //http://localhost:8080/startup/team/newzland
    @GetMapping("/{teamCountry}")
    public Team findTeam(@PathVariable String teamCountry){
        System.out.println("=========RestController");
        return teamService.getTeam(teamCountry);
    }
}
