package com.advance.academy.homework.bank.system.model.transaction;

import com.advance.academy.homework.bank.system.model.TransactionHistory;
import com.advance.academy.homework.bank.system.model.enums.TransactionType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "transactions")
public class Transaction implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private TransactionType type;

    @Column(name = "amount")
    private Long amount;

    @Column(name = "currency")
    private Long currency;

    @Column(name = "reason")
    private String reason;

    @Column(name = "date_created")
    private Instant dateCreated;

    @Column(name = "data_updated")
    private Instant dataUpdated;

    @OneToMany(mappedBy = "transaction")
    private Set<TransactionHistory> saveIns = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "transaction_transaction",
            joinColumns = @JoinColumn(name = "transaction_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "transaction_id", referencedColumnName = "id"))
    private Set<Transaction> transactions = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("transactions")
    private Account bAccount;

    @ManyToMany(mappedBy = "transactions")
    @JsonIgnore
    private Set<Transaction> transactionhistories = new HashSet<>();
}
