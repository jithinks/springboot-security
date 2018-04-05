package com.jks.startup.springbootsecurity.Util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jks.startup.springbootsecurity.model.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class JsonUtil {

    private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);

    public Topic findUser(String login){
        ObjectMapper m = new ObjectMapper();
        TypeReference<List<Topic>> typeReference= new TypeReference<List<Topic>>(){};
        InputStream inputStream = TypeReference.class.getResourceAsStream("/users.json");

        try{
            List<Topic> topics= m.readValue(inputStream, typeReference);
            for(Topic t: topics){
                if(t.getLogin().equalsIgnoreCase(login)){
                    System.out.println("Found-->"+t);;
                    return t;
                }
            }
        }catch (IOException e){
            logger.error("Unable to get Topic "+e.getMessage());
        }

        return null;
    }
}
