package com.prbank.Bank.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;
    @Column(nullable = false,length = 15)
    private String username;
    @Column(nullable = false,length = 20)
    private String password;
    @Column(nullable = false,unique = true)
    private String email;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idPerson")
    @JsonBackReference
    private Person person;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();
    public User() {
    }
    public User(Long idUser, String username, String password, String email, List<Account> accounts) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.email = email;
        this.accounts = accounts;
    }
    public Long getIdUser() {
        return idUser;
    }
    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
    public List<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
