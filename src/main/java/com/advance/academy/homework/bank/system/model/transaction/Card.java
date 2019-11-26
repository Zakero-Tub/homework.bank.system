package com.advance.academy.homework.bank.system.model.transaction;

import com.advance.academy.homework.bank.system.model.TransactionHistory;
import com.advance.academy.homework.bank.system.model.enums.CardType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cards")
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "type")
    private CardType type;

    @Column(name = "currency")
    private Long currency;

    @OneToMany(mappedBy = "card")
    private Set<TransactionHistory> saveIns = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties("cards")
    private Account Account;
}
