package com.prbank.Bank.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name = "accounts")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private User user;
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Pocket> pockets = new ArrayList<>();
}
