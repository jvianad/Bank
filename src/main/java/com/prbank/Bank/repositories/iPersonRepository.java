package com.prbank.Bank.repositories;
import com.prbank.Bank.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface iPersonRepository extends JpaRepository<Person,Long> {
}
