package com.prbank.Bank.repositories;
import com.prbank.Bank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface iAccountRepository extends JpaRepository<Account,Long> {
}
