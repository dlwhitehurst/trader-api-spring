CREATE DATABASE IF NOT EXISTS `trade-tx`;

USE `trade-tx`;

UNLOCK TABLES;

-- ##########################################################################################################
-- POSITIONS
-- ##########################################################################################################

DROP TABLE IF EXISTS `positions`;
CREATE TABLE `positions` (
    `id`                   bigint(19) unsigned NOT NULL AUTO_INCREMENT,
    `pos_date`             varchar(20) NOT NULL,
    `pos_symbol`           varchar(20) NOT NULL,
    `pos_qty`              varchar(20) NOT NULL,
    `pos_cost`             varchar(20) NOT NULL,
    `pos_market`           varchar(20) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `positions` WRITE;
INSERT INTO `positions` (
    pos_date,
    pos_symbol,
    pos_qty,
    pos_cost,
    pos_market
) VALUES (
    '01/01/2000',
    'AAPL',
    '100',
    '$21,000.00',
    '$22,322.78'
);
UNLOCK TABLES;

-- ##########################################################################################################
-- BALANCES
-- ##########################################################################################################

DROP TABLE IF EXISTS `balances`;
CREATE TABLE `balances` (
    `id`                        bigint(19) unsigned NOT NULL AUTO_INCREMENT,
    `bal_date`                  varchar(20) NOT NULL,
    `bal_account`               varchar(32) NOT NULL,
    `bal_account_value`         varchar(32) NOT NULL,
    `bal_account_value_prior`   varchar(32) NOT NULL,
    `bal_cash_value`            varchar(32) NOT NULL,
    `bal_cash_value_prior`      varchar(32) NOT NULL,
    `bal_stock_value`           varchar(32) NOT NULL,
    `bal_stock_value_prior`     varchar(32) NOT NULL,
    `bal_option_value`          varchar(32) NOT NULL,
    `bal_option_value_prior`    varchar(32) NOT NULL,
    `bal_fund_value`            varchar(32) NOT NULL,
    `bal_fund_value_prior`      varchar(32) NOT NULL,
    `bal_bond_value`            varchar(32) NOT NULL,
    `bal_bond_value_prior`      varchar(32) NOT NULL,
    `bal_trade_available`       varchar(32) NOT NULL,
    `bal_options_available`     varchar(32) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `balances` WRITE;
INSERT INTO `balances` (
    bal_date,
    bal_account,
    bal_account_value,
    bal_account_value_prior,
    bal_cash_value,
    bal_cash_value_prior,
    bal_stock_value,
    bal_stock_value_prior,
    bal_option_value,
    bal_option_value_prior,
    bal_fund_value,
    bal_fund_value_prior,
    bal_bond_value,
    bal_bond_value_prior,
    bal_trade_available,
    bal_options_available) VALUES (
    '01/01/2000',
    '1234',
    '$10,000',
    '$9,999',
    '$10,000','$9,999',
    '$0','$0',
    '$0','$0',
    '$0','$0',
    '$0','$0',
    '$10,000','$10,000'
);
UNLOCK TABLES;

-- ##########################################################################################################
-- TRANSACTIONS
-- ##########################################################################################################

DROP TABLE IF EXISTS `transactions`;

CREATE TABLE `transactions` (
    `id`                            bigint(19) unsigned NOT NULL AUTO_INCREMENT,
    `tx_date`                       varchar(20) NOT NULL,
    `tx_id`                         varchar(40) NOT NULL,
    `tx_description`                varchar(80) NOT NULL,
    `tx_quantity`                   varchar(20) NOT NULL,
    `tx_symbol`                     varchar(60) NOT NULL,
    `tx_price`                      varchar(20) NOT NULL,
    `tx_commission`                 varchar(10) NOT NULL,
    `tx_amount`                     varchar(20) NOT NULL,
    `tx_regulatory_fee`             varchar(10) NOT NULL,
    `tx_short_term_rdm_fee`         varchar(10) NOT NULL,
    `tx_fund_redemption_fee`        varchar(10) NOT NULL,
    `tx_deferred_sales_charge`      varchar(10) NOT NULL,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `transactions` WRITE;
INSERT INTO `transactions` (`tx_date`, `tx_id`,`tx_description`, `tx_quantity`, `tx_symbol`,
                            `tx_price`, `tx_commission`, `tx_amount`, `tx_regulatory_fee`,
                            `tx_short_term_rdm_fee`, `tx_fund_redemption_fee`,
                            `tx_deferred_sales_charge`) VALUES (
        '11/22/1963',
        '49252224461',
        'Bought 100 X @ 10.25',
        '80', 'ERO', '18.08', '0.00','1446.38','0.02','0.00','0.00','0.00');
UNLOCK TABLES;
