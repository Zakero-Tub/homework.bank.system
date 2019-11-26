package com.advance.academy.homework.bank.system.model;

import com.advance.academy.homework.bank.system.model.transaction.Account;
import com.advance.academy.homework.bank.system.model.transaction.Card;
import com.advance.academy.homework.bank.system.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "transactions_history")
public class TransactionHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("saveIns")
    private Account Account;

    @ManyToOne
    @JsonIgnoreProperties("saveIns")
    private Card card;

    @ManyToOne
    @JsonIgnoreProperties("saveIns")
    private Transaction transaction;

}
