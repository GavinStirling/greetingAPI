package com.nology.greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

// Gives functionality of a rest controller
// - Set up end points -> URLs -> Match them with a method
// - A request foes to that endpoint the methods is called -> Returns is the response

@RestController
@CrossOrigin
public class GreetingsController {

    @Autowired
    GreetingsRepository greetingsRepository;

    @Autowired
    GreetingsService greetingsService;

    // Catch an exception and send back an error message
    @ExceptionHandler
    public ResponseEntity<String> handleExceptions(Exception exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    // ResponseEntity -> Makes a custom response
    // - Set status code -> HTTP status -> Status codes stored
    // - Provide body/data needed
    @GetMapping("/greeting/{id}")
    public ResponseEntity<Greeting> getGreetingById(@PathVariable String id){
        Greeting greeting = greetingsService.findGreetingById(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(greeting);
    }

    @GetMapping("/greetings")
    public ResponseEntity<List<Greeting>> getGreetings(){
        List<Greeting> greetings = greetingsRepository.findAll();
        return ResponseEntity.status(HttpStatus.FOUND).body(greetings);
    }

    @GetMapping("/random")
    public ResponseEntity<Greeting> getRandomGreeting(){
        Greeting greeting = greetingsService.findRandomGreeting();
        return ResponseEntity.status(HttpStatus.FOUND).body(greeting);
    }

    @GetMapping("/greeting-ids")
    public ResponseEntity<List<String>> getGreetingIds(){
        List<String> ids = greetingsService.findAllGreetingIds();
        return ResponseEntity.status(HttpStatus.FOUND).body(ids);
    }

    // CREATE A ENDPOINT TO DELETE A GREETING
    // TO DELETE THE GREETING -> SEND THE GREETING TO DELETE IN THE REQUEST
    // @DeleteMapping
    @DeleteMapping("/greeting/{id}")
    @Transactional
    public ResponseEntity<String> deleteGreetingById(@PathVariable String id){
        greetingsService.deleteGreetingById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Greeting deleted");
    }

    // CREATE -> POST
    // @RequestBody -> EXTRACT DATA FROM BODY OF REQUEST
    // - IF JSON OBJECT MATCHES Greeting FIELDS SPRING CAN TURN IT INTO A Greeting OBJECT FOR YOU TO USE
    @PostMapping("/greeting")
    @Transactional
    public ResponseEntity<String> createGreeting(@RequestBody Greeting greeting){
        greetingsService.createGreeting(greeting);
        return ResponseEntity.status(HttpStatus.CREATED).body("Created greeting with ID: " + greeting.getId());
    }

    // UPDATE -> PUT
    // - YOU CAN GET ACCESS TO MULTIPLE BITS OF INFORMATION E.G. REQUEST BODY & PATH VARIABLE
    @PutMapping("/greeting/{id}")
    @Transactional
    public ResponseEntity<String> updateGreeting(@RequestBody Greeting newGreeting, @PathVariable String id){
        greetingsService.createGreeting(newGreeting);
        return ResponseEntity.status(HttpStatus.OK).body("Updated greeting with ID: " + newGreeting.getId());
    }
}

//    @GetMapping("/")
//    public String helloWorld(){
//        return "Hello world!";
//    }
//
//    @GetMapping("/rob")
//    public String helloRob(){
//        return "THIS IS EXCITING!!!!";
//    }


    // DAY ONE
//    private List<String> greetings = Arrays.asList("Hello", "Hi", "Howdy", "Heya", "Awe", "Kunjani");
//
//    // Get Request
//    // ("/") -> URL that runs this method
//    @GetMapping("/")
//    public String helloWorld(){
//        return "Hello World!";
//    }
//
//    @GetMapping("/rob")
//    public String helloRob(){
//        return "This is EXCITING!";
//    }
//
//    // Request Param -> Query Params
//    // http://localhost:8080/greeting?name=Gavin
//    // @RequestParam -> ? Something -> Get Values -> Parameters have to match
//    @GetMapping("/greeting")
//    public String getCustomGreeting (@RequestParam String name) {
//        return "Hello " + name;
//    }
//
//    // Path Variable
//    // This is when extra information is needed from the URL/endpoint
////    @GetMapping("/greeting/{id}")
////    public String getGreetingById (@PathVariable String id) {
////        return "ID: " + id;
////    }
//
//    // Can return any types
//    // Springs converts to JSON
//    @GetMapping("/greetings")
//    public List<String> getGreetings () {
//        return greetings;
//    }
//
//    @GetMapping("/random-greeting")
//    public String getRandomGreeting () {
//        return greetings.get((int) (Math.random()* greetings.size()));
//    }
//
//    @GetMapping("/greeting/{index}")
//    public String getGreetingByIndex (@PathVariable int index) {
//        return greetings.get(index);
//    }