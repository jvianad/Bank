package com.prbank.Bank.repositories;
import com.prbank.Bank.entities.Pocket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface iPocketRepository extends JpaRepository<Pocket,Long> {
}
