package com.advance.academy.homework.bank.system.repository;

import com.advance.academy.homework.bank.system.model.transaction.Transaction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends CrudRepository<Transaction, Integer> {
}
