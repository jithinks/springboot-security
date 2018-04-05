package com.jks.startup.springbootsecurity.controller;

import com.jks.startup.springbootsecurity.model.Team;
import com.jks.startup.springbootsecurity.model.Topic;
import com.jks.startup.springbootsecurity.service.TeamService;
import com.jks.startup.springbootsecurity.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping
public class RestServiceController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TopicService topicService;

    //http://localhost:1234/startup/team/newzland
    @GetMapping("/team/{teamCountry}")
    public Team findTeam(@PathVariable String teamCountry){
        System.out.println("=========RestController");
        return teamService.getTeam(teamCountry);
    }

    //http://localhost:1234/startup/topic/PivotalSoftware
    //http://localhost:1234/startup/topic/CloudFoundry
    //http://localhost:1234/startup/topic/Spring-Projects
    @GetMapping("/topic/{login}")
    public Topic getTopic(@PathVariable String login) throws InterruptedException, ExecutionException {
        CompletableFuture<Topic> t = topicService.findUser(login);
        return t.get();
    }
}
