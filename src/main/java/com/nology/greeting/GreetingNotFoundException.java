package com.nology.greeting;

import javax.persistence.EntityNotFoundException;

// Adding message to exception class
// - Uses getMessage to retrieve it
public class GreetingNotFoundException extends EntityNotFoundException {

    public GreetingNotFoundException() {
        super("Greeting has not been found");
    }
}