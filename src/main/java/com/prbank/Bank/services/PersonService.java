package com.prbank.Bank.services;
import com.prbank.Bank.entities.Person;
import com.prbank.Bank.repositories.iPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PersonService {
    @Autowired
    private iPersonRepository personRepository;
    public List<Person> getPersons(){
        return personRepository.findAll();
    }
    public Person getPersonById(Long idPerson){
        return personRepository.findById(idPerson).get();
    }
    public Person createPerson(Person person){
        return personRepository.save(person);
    }
}
