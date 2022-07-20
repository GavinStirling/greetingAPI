package com.nology.greeting;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class GreetingsRepository {

    private final List<Greeting> greetings = new ArrayList<>();

    public int getSize() {
        return greetings.size();
    }

    // Create
    public void addGreetings(Greeting greeting) {
        greetings.add(greeting);
    }

    // Read
    public Greeting getGreetingFromId(String id) {
        for (Greeting greeting: greetings) {
            if(greeting.getId().equals(id)){
                return greeting;
            }
        }
        // Using the exception class -> Break out of the code -> Handle the error/exception
        throw new GreetingNotFoundException();
    }

    public List<Greeting> getAllGreetings() {
        return greetings;
    }

    public Greeting getRandomGreeting() {
        Random rand = new Random();
        return greetings.get(rand.nextInt(greetings.size()));
    }

    // Delete
    public void deleteGreeting(String id) {
        for (int i = 0; i < greetings.size(); i++) {
            if(greetings.get(i).getId().equals(id)){
                greetings.remove(i);
                return;
            }
        }
        throw new GreetingNotFoundException();
    }

    // Create
    public String createGreeting(Greeting greeting) {
        greetings.add(greeting);
        return "Greeting added";
    }

    // Update
    public void UpdateGreeting(Greeting newGreeting, String id) {
        for (int i = 0; i < greetings.size(); i++) {
            if(greetings.get(i).getId().equals(id)){
                greetings.set(i, newGreeting);
                return;
            }
        }
        throw new GreetingNotFoundException();
    }
}
