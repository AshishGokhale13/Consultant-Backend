package com.mbpatil.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mbpatil.models.Transactions;

public interface TransactionsRepository extends JpaRepository<Transactions, Long>{

}
