package com.prbank.Bank.services;
import com.prbank.Bank.entities.Account;
import com.prbank.Bank.entities.Pocket;
import com.prbank.Bank.entities.User;
import com.prbank.Bank.repositories.iAccountRepository;
import com.prbank.Bank.repositories.iPocketRepository;
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
    @Autowired
    private iPocketRepository pocketRepository;
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
    public String deposit(String accountNumber,double amount){
        Account accToDeposit = accountRepository.findByAccountNumber(accountNumber);
        if (accToDeposit == null){
            throw new RuntimeException("Account not found");
        }
        double newBalance = accToDeposit.getAccountInitialBalance() + amount;
        accToDeposit.setAccountInitialBalance(newBalance);
        accountRepository.save(accToDeposit);
        return "Deposito Realizado";
    }
    public void deleteAccount(Long idAccount){
        Account accountToDelete = accountRepository.findById(idAccount).orElse(null);
        if (accountToDelete==null){
            throw new RuntimeException("Account not found");
        }
        accountRepository.delete(accountToDelete);
    }
    public void deleteAccountPocket(Long idAccount, Long idPocket){
        Account account = accountRepository.findById(idAccount).orElse(null);
        Pocket pocketToDelete = pocketRepository.findById(idPocket).orElse(null);

        if (!account.getPockets().contains(pocketToDelete)){
            throw new RuntimeException("Bolsillo no pertenece a esta cuenta");
        }
        if (pocketToDelete.getPocketInitialBalance()>0){
            throw new RuntimeException("Para eliminar el bolsillo, debe tener saldo 0.0");
        }
        account.getPockets().remove(pocketToDelete);
        pocketRepository.delete(pocketToDelete);
    }
}
