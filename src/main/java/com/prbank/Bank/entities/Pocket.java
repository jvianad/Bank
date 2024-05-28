package com.prbank.Bank.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
@Entity
@Table(name = "pockets")
public class Pocket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPocket;
    @Column(nullable = false)
    private String pocketName;
    @Column(unique = true, nullable = false)
    private String pocketNumber;
    @Column(nullable = false)
    private Double pocketInitialBalance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idAccount")
    @JsonBackReference
    private Account account;
    public Pocket() {
    }
    public Long getIdPocket() {
        return idPocket;
    }
    public String getPocketName() {
        return pocketName;
    }
    public void setPocketName(String pocketName) {
        this.pocketName = pocketName;
    }
    public String getPocketNumber() {
        return pocketNumber;
    }
    public void setPocketNumber(String pocketNumber) {
        this.pocketNumber = pocketNumber;
    }
    public Double getPocketInitialBalance() {
        return pocketInitialBalance;
    }
    public void setPocketInitialBalance(Double pocketInitialBalance) {
        this.pocketInitialBalance = pocketInitialBalance;
    }
    public Account getAccount() {
        return account;
    }
    public void setAccount(Account account) {
        this.account = account;
    }
}
