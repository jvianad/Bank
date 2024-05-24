package com.prbank.Bank.entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Table(name = "pockets")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Account account;
}
