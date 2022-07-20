package com.nology.greeting;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.io.*;

@Component
public class GreetingsInitialiser {
    private final GreetingsRepository greetingsRepository;

    @Value("classpath:greetings.json")
    private Resource resourceFile;

    @Autowired
    public GreetingsInitialiser(GreetingsRepository greetingsRepository) {
        this.greetingsRepository = greetingsRepository;
    }

    @PostConstruct
    public void init() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader(resourceFile.getFile())) {
            Object obj = jsonParser.parse(reader);

            JSONArray jsonArray = (JSONArray) obj;

            for (Object greeting : jsonArray) {
                JSONObject greetingJSON = (JSONObject) greeting;

                String id = (String) greetingJSON.get("id");
                String createdBy = (String) greetingJSON.get("createdBy");
                String greetingStr = (String) greetingJSON.get("greeting");
                String originCountry = (String) greetingJSON.get("originCountry");
                String nationality = (String) greetingJSON.get("nationality");

                greetingsRepository.addGreetings(new Greeting(id, createdBy, greetingStr, originCountry, nationality));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}