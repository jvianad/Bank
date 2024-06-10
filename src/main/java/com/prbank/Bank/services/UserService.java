package com.prbank.Bank.services;
import com.prbank.Bank.entities.User;
import com.prbank.Bank.repositories.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserService {
    @Autowired
    private iUserRepository userRepository;
    public List<User> getUsers(){
        return userRepository.findAll();
    }
    public User createUser(User user){
        return userRepository.save(user);
    }
}
