/**
 * Copyright (c) David L Whitehurst.  All rights reserved.
 * The software in this package is published under the terms of the Apache
 * version 2.0 license, a copy of which has been included with this distribution
 * in the LICENSE file.
 *
 */

package com.dlwhitehurst.tradetx.controller;

import com.dlwhitehurst.tradetx.model.Balance;
import com.dlwhitehurst.tradetx.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class BalanceController {

    @Autowired
    BalanceRepository balanceRepository;

    @GetMapping("/balances")
    public ResponseEntity<List<Balance>> getAllBalances() {
        try {
            List<Balance> balances = new ArrayList<>();

            balances.addAll(balanceRepository.findAll());

            if (balances.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(balances, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/balances/{id}")
    public ResponseEntity<Balance> getBalanceById(@PathVariable("id") long id) {
        Optional<Balance> balanceData = balanceRepository.findById(id);

        if (balanceData.isPresent()) {
            return new ResponseEntity<>(balanceData.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/balances")
    public ResponseEntity<Balance> createBalance(@RequestBody Balance balance) {
        try {
            Balance _balance = balanceRepository
                    .save(balance);
            return new ResponseEntity<>(_balance, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PutMapping("/balances/{id}")
//    public ResponseEntity<Balance> updateBalance(@PathVariable("id") long id, @RequestBody Balance balance) {
//        Optional<Balance> balanceData = balanceRepository.findById(id);
//
//        if (balanceData.isPresent()) {
//            Balance _balance = balanceData.get();
//            _balance.setId(balance.getId());
//            _balance.setTxDate(balance.getTxDate());
//            _balance.setTxId(balance.getTxId());
//            _balance.setTxDescription(balance.getTxDescription());
//            _balance.setTxQuantity(balance.getTxQuantity());
//            _balance.setTxSymbol(balance.getTxSymbol());
//            _balance.setTxPrice(balance.getTxPrice());
//            _balance.setTxCommission(balance.getTxCommission());
//            _balance.setTxAmount(balance.getTxAmount());
//            _balance.setTxRegFee(balance.getTxRegFee());
//            _balance.setTxShortTermRdmFee(balance.getTxShortTermRdmFee());
//            _balance.setTxFundRedemptionFee(balance.getTxFundRedemptionFee());
//            _balance.setTxDeferredSalesCharge(balance.getTxDeferredSalesCharge());
//
//            return new ResponseEntity<>(balanceRepository.save(_balance), HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @DeleteMapping("/balances/{id}")
    public ResponseEntity<HttpStatus> deleteBalance(@PathVariable("id") long id) {
        try {
            balanceRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/balances")
    public ResponseEntity<HttpStatus> deleteAllBalances() {
        try {
            balanceRepository.deleteAll();
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    
}
