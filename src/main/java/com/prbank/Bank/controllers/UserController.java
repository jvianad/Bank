package com.prbank.Bank.controllers;
import com.prbank.Bank.entities.Person;
import com.prbank.Bank.entities.User;
import com.prbank.Bank.services.PersonService;
import com.prbank.Bank.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getUsers(){
        List<User> allUsers = userService.getUsers();
        if (allUsers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allUsers);
    }
    @PostMapping("/person/{idPerson}/users")
    public ResponseEntity<User> createUser(@PathVariable Long idPerson,@RequestBody User user){
        User createdUser = userService.createUser(idPerson,user);
        if (createdUser != null) {
            return ResponseEntity.ok(createdUser);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
