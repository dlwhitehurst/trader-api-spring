/**
 * Copyright (c) David L Whitehurst.  All rights reserved.
 * The software in this package is published under the terms of the Apache
 * version 2.0 license, a copy of which has been included with this distribution
 * in the LICENSE file.
 *
 */

package com.dlwhitehurst.tradetx.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "transactions", uniqueConstraints = { @UniqueConstraint(columnNames = { "tx_id" }) })
public class Transaction {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "tx_date")
    private String txDate;

    @NotBlank
    @Column(name = "tx_id")
    private String txId;

    @Column(name = "tx_description")
    private String txDescription;

    @Column(name = "tx_quantity")
    private String txQuantity;

    @Column(name = "tx_symbol")
    private String txSymbol;

    @Column(name = "tx_price")
    private String txPrice;

    @Column(name = "tx_commission")
    private String txCommission;

    @Column(name = "tx_amount")
    private String txAmount;

    @Column(name = "tx_regulatory_fee")
    private String txRegFee;

    @Column(name = "tx_short_term_rdm_fee")
    private String txShortTermRdmFee;

    @Column(name = "tx_fund_redemption_fee")
    private String txFundRedemptionFee;

    @Column(name = "tx_deferred_sales_charge")
    private String txDeferredSalesCharge;

    //DATE,TRANSACTION ID,DESCRIPTION,QUANTITY,SYMBOL,PRICE,COMMISSION,AMOUNT,
    // REG FEE,SHORT-TERM RDM FEE,FUND REDEMPTION FEE, DEFERRED SALES CHARGE
    //04/04/2023,49252224461,Sold 80 ERO @ 18.08,80,ERO,18.08,0.00,1446.38,0.02,,,

}

