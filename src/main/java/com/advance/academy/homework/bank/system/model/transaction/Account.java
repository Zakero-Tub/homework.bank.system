package com.advance.academy.homework.bank.system.model.transaction;

import com.advance.academy.homework.bank.system.model.Customer;
import com.advance.academy.homework.bank.system.model.TransactionHistory;
import com.advance.academy.homework.bank.system.model.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "accounts")
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private AccountType type;

    @Column(name = "iban")
    private String iban;

    @Column(name = "currency")
    private Long currency;

    @Column(name = "balance")
    private Long balance;

    @OneToMany(mappedBy = "Account")
    private Set<Transaction> transactions = new HashSet<>();

    @OneToMany(mappedBy = "Account")
    private Set<Card> cards = new HashSet<>();

    @OneToMany(mappedBy = "Account")
    private Set<TransactionHistory> saveIns = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("createdBies")
    private Customer customer;


}
