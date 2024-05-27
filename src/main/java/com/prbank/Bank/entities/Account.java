package com.prbank.Bank.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAccount;
    @Column(nullable = false)
    private String accountType;
    @Column(unique = true, nullable = false)
    private String accountNumber;
    @Column(nullable = false)
    private Double accountInitialBalance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idUser")
    @JsonBackReference
    private User user;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Pocket> pockets = new ArrayList<>();

    public Account() {
    }

    public Account(Long idAccount, String accountType, String accountNumber, Double accountInitialBalance) {
        this.idAccount = idAccount;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.accountInitialBalance = accountInitialBalance;
    }
    public Long getIdAccount() {
        return idAccount;
    }
    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getAccountInitialBalance() {
        return accountInitialBalance;
    }

    public void setAccountInitialBalance(Double accountInitialBalance) {
        this.accountInitialBalance = accountInitialBalance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Pocket> getPockets() {
        return pockets;
    }

    public void setPockets(List<Pocket> pockets) {
        this.pockets = pockets;
    }
}
