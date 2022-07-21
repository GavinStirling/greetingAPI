package com.nology.greeting;

import org.springframework.data.jpa.repository.JpaRepository;

// <ReturnType> [operation]By[attribute]([parameter])

// JpaRepository needs the following:
// -> Type/Class that it is storing
// -> Type of the ID/Primary Key
public interface GreetingsRepository extends JpaRepository<Greeting, String> {

    Greeting findByid(String id);

    String deleteByid(String id);

}
