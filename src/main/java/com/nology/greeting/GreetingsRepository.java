package com.nology.greeting;

import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository needs the following:
// -> Type/Class that it is storing
// -> Type of the ID/Primary Key
public interface GreetingsRepository extends JpaRepository<Greeting, String> {

}
