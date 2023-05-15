package com.dlwhitehurst.tradetx.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "positions", uniqueConstraints = { @UniqueConstraint(columnNames = { "id" }) })
public class Position {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "pos_date")
    private String posDate;

    @NotBlank
    @Column(name = "pos_symbol")
    private String posSymbol;

    @NotBlank
    @Column(name = "pos_qty")
    private String posQuantity;

    @NotBlank
    @Column(name = "pos_cost")
    private String posCost;

    @NotBlank
    @Column(name = "pos_market")
    private String posMarket;

}
