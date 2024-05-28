package com.prbank.Bank.services;
import com.prbank.Bank.entities.Account;
import com.prbank.Bank.entities.Pocket;
import com.prbank.Bank.repositories.iAccountRepository;
import com.prbank.Bank.repositories.iPocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class PocketService {
    @Autowired
    private iAccountRepository accountRepository;
    @Autowired
    private iPocketRepository pocketRepository;
    public List<Pocket> getAllPockets(){
        return pocketRepository.findAll();
    }
    public Pocket createPocket(Long idAccount, Pocket pocket){
        Account acc = accountRepository.findById(idAccount).orElse(null);
        if (acc == null) {
            throw new RuntimeException("Main account not found");
        }

        pocket.setAccount(acc);

        if(pocket.getPocketInitialBalance() > acc.getAccountInitialBalance()){
            throw new RuntimeException("Initial pocket balance cannot be greater than the account balance");
        }

        double newBalance = acc.getAccountInitialBalance() - pocket.getPocketInitialBalance();
        acc.setAccountInitialBalance(newBalance);

        pocketRepository.save(pocket);
        accountRepository.save(acc);
        return pocket;
    }
}
