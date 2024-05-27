package com.prbank.Bank.controllers;
import com.prbank.Bank.entities.Account;
import com.prbank.Bank.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/v1")
public class AccountController {
    @Autowired
    private AccountService accountService;
    @GetMapping("/accounts")
    public ResponseEntity<List<Account>> getAccounts(){
        List<Account> allAccounts = accountService.getAllAccounts();
        if (allAccounts.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allAccounts);
    }
    @PostMapping("/user/{idUser}/accounts")
    public ResponseEntity<Account> createAccount(@PathVariable Long idUser, @RequestBody Account account){
        Account createdAccount = accountService.createAccount(idUser, account);
        if (createdAccount != null){
            return ResponseEntity.ok(createdAccount);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
