package com.jks.startup.springbootsecurity.service;

import com.jks.startup.springbootsecurity.Util.JsonUtil;
import com.jks.startup.springbootsecurity.model.Topic;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class TopicService {

    @Async
    public CompletableFuture<Topic> findUser(String login) {
        JsonUtil jsonUtil = new JsonUtil();
        return CompletableFuture.completedFuture(jsonUtil.findUser(login));
    }
}
