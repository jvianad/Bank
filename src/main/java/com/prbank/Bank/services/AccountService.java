package com.prbank.Bank.services;
import com.prbank.Bank.entities.Account;
import com.prbank.Bank.entities.User;
import com.prbank.Bank.repositories.iAccountRepository;
import com.prbank.Bank.repositories.iUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class AccountService {
    @Autowired
    private iAccountRepository accountRepository;
    @Autowired
    private iUserRepository userRepository;
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    public Account findByAccountNumber(String accountNumber){
        return accountRepository.findByAccountNumber(accountNumber);
    }
    public Account createAccount(Long idUser, Account account){
        User accUser = userRepository.findById(idUser).orElse(null);
        if (accUser!=null){
            account.setUser(accUser);
            return accountRepository.save(account);
        }
        return null;
    }
}
