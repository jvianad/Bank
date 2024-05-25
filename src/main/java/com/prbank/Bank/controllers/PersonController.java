package com.prbank.Bank.controllers;
import com.prbank.Bank.entities.Person;
import com.prbank.Bank.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("api/v1/persons")
public class PersonController {
    @Autowired
    private PersonService personService;
    @GetMapping
    public ResponseEntity<List<Person>> getPersons(){
        List<Person> allPersons = personService.getPersons();
        if (allPersons.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allPersons);
    }
    @GetMapping("/{idPerson}")
    public ResponseEntity<Person> getPersonById(@PathVariable Long idPerson){
        Person personById = personService.getPersonById(idPerson);
        if (personById == null){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personById);
    }
    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person){
        Person createdPerson = personService.createPerson(person);
        if (createdPerson != null){
            return ResponseEntity.ok(createdPerson);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

