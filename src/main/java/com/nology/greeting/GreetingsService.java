package com.nology.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GreetingsService {
    @Autowired
    GreetingsRepository greetingsRepository;

    Greeting findGreetingById(String id) {
        Greeting greeting = greetingsRepository.findByid(id);
        if (greeting == null) {
            throw new GreetingNotFoundException();
        }
        return greeting;
    }

    Greeting findRandomGreeting() {
        List<Greeting> greetings = greetingsRepository.findAll();
        return greetings.get((int)(Math.random()*greetings.size()));
    }

    void deleteGreetingById(String id) {
        Greeting greeting = findGreetingById(id);
        greetingsRepository.deleteByid(id);
    }

    List<String> findAllGreetingIds() {
        List<Greeting> greetings = greetingsRepository.findAll();
        return greetings.stream().map(Greeting::getId).collect(Collectors.toList());
    }

    void createGreeting(Greeting greeting) {
        greetingsRepository.save(greeting);
    }
}
