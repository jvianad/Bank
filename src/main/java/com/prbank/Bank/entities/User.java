package com.prbank.Bank.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Person person;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Account> accounts = new ArrayList<>();
}
