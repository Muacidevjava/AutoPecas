package com.autopecas.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

    @Data
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


