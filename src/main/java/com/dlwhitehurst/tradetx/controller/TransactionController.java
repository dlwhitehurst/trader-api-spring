/**
 * Copyright (c) David L Whitehurst.  All rights reserved.
 * The software in this package is published under the terms of the Apache
 * version 2.0 license, a copy of which has been included with this distribution
 * in the LICENSE file.
 *
 */

package com.dlwhitehurst.tradetx.controller;

import com.dlwhitehurst.tradetx.model.Transaction;
import com.dlwhitehurst.tradetx.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    @Autowired
    TransactionRepository transactionRepository;

    @GetMapping("/transactions")
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        try {
            List<Transaction> transactions = new ArrayList<>();

            transactions.addAll(transactionRepository.findAll());

            if (transactions.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(transactions, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/transactions/{id}")
    public ResponseEntity<Transaction> getTransactionById(@PathVariable("id") long id) {
        Optional<Transaction> transactionData = transactionRepository.findById(id);

        if (transactionData.isPresent()) {
            return new ResponseEntity<>(transactionData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/transactions")
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        try {
            Transaction _transaction = transactionRepository
                    .save(transaction);
            return new ResponseEntity<>(_transaction, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/transactions/{id}")
    public ResponseEntity<Transaction> updateTransaction(@PathVariable("id") long id, @RequestBody Transaction transaction) {
        Optional<Transaction> transactionData = transactionRepository.findById(id);

        if (transactionData.isPresent()) {
            Transaction _transaction = transactionData.get();
            _transaction.setId(transaction.getId());
            _transaction.setTxDate(transaction.getTxDate());
            _transaction.setTxId(transaction.getTxId());
            _transaction.setTxDescription(transaction.getTxDescription());
            _transaction.setTxQuantity(transaction.getTxQuantity());
            _transaction.setTxSymbol(transaction.getTxSymbol());
            _transaction.setTxPrice(transaction.getTxPrice());
            _transaction.setTxCommission(transaction.getTxCommission());
            _transaction.setTxAmount(transaction.getTxAmount());
            _transaction.setTxRegFee(transaction.getTxRegFee());
            _transaction.setTxShortTermRdmFee(transaction.getTxShortTermRdmFee());
            _transaction.setTxFundRedemptionFee(transaction.getTxFundRedemptionFee());
            _transaction.setTxDeferredSalesCharge(transaction.getTxDeferredSalesCharge());

            return new ResponseEntity<>(transactionRepository.save(_transaction), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/transactions/{id}")
    public ResponseEntity<HttpStatus> deleteTransaction(@PathVariable("id") long id) {
        try {
            transactionRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/transactions")
    public ResponseEntity<HttpStatus> deleteAllTransactions() {
        try {
            transactionRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}