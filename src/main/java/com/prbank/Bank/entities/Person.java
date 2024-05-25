package com.prbank.Bank.entities;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPerson;
    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String address;
    @Column(nullable = false, length = 10)
    private Long cellphoneNumber;
    @OneToOne(mappedBy = "person", cascade = CascadeType.ALL)
    @JsonManagedReference
    private User user;
    public Person() {
    }
    public Person(Long idPerson, String name, String lastName, String address, Long cellphoneNumber, User user) {
        this.idPerson = idPerson;
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.cellphoneNumber = cellphoneNumber;
        this.user = user;
    }
    public Long getIdPerson() {
        return idPerson;
    }
    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Long getCellphoneNumber() {
        return cellphoneNumber;
    }
    public void setCellphoneNumber(Long cellphoneNumber) {
        this.cellphoneNumber = cellphoneNumber;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
        if (user != null) {
            user.setPerson(this);
        }
    }
}
