package com.prbank.Bank.services;
import com.prbank.Bank.entities.Person;
import com.prbank.Bank.entities.User;
import com.prbank.Bank.repositories.iPersonRepository;
import com.prbank.Bank.repositories.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private iUserRepository userRepository;
    @Autowired
    private iPersonRepository personRepository;
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User createUser(Long idPerson, User user){
        Person person = personRepository.findById(idPerson).orElse(null);
        if (person != null) {
            user.setPerson(person);
            person.setUser(user);
            return userRepository.save(user);
        }
        return null;
    }
}
