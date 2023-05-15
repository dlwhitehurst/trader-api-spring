package com.dlwhitehurst.tradetx.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "balances", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class Balance {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "bal_date")
    private String balDate;

    @NotBlank
    @Column(name = "bal_account")
    private String balAccount;

    @NotBlank
    @Column(name = "bal_account_value")
    private String balAccountValue;

    @NotBlank
    @Column(name = "bal_account_value_prior")
    private String balAccountValuePrior;

    // CASH CASH CASH CASH
    @NotBlank
    @Column(name = "bal_cash_value")
    private String balCashValue;

    @NotBlank
    @Column(name = "bal_cash_value_prior")
    private String balCashValuePrior;

    // POSITION POSITION POSITION
    @NotBlank
    @Column(name = "bal_stock_value")
    private String balStockValue;

    @NotBlank
    @Column(name = "bal_stock_value_prior")
    private String balStockValuePrior;

    @NotBlank
    @Column(name = "bal_option_value")
    private String balOptionValue;

    @NotBlank
    @Column(name = "bal_option_value_prior")
    private String balOptionValuePrior;

    @NotBlank
    @Column(name = "bal_fund_value")
    private String balFundValue;

    @NotBlank
    @Column(name = "bal_fund_value_prior")
    private String balFundValuePrior;

    @NotBlank
    @Column(name = "bal_bond_value")
    private String balBondValue;

    @NotBlank
    @Column(name = "bal_bond_value_prior")
    private String balBondValuePrior;

    // AVAILABLE AVAILABLE AVAILABLE
    @NotBlank
    @Column(name = "bal_trade_available")
    private String balTradeAvailable;

    @NotBlank
    @Column(name = "bal_options_available")
    private String balOptionsAvailable;

}
