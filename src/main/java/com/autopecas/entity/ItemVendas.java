package com.autopecas.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;


    @Entity
    public class ItemVendas {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "produto_id")
        private Produto produto;

        private Integer quantidade;
        private BigDecimal precoUnitario;
        private BigDecimal precoTotal;

        // Getters e Setters
    }


