package com.advance.academy.homework.bank.system.repository;

import com.advance.academy.homework.bank.system.model.transaction.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {
}
