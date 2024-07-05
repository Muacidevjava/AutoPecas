package com.autopecas.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

    @Data
    @Entity
    public class Produto{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String descricao;
        private String marca;
        private String codigo;
        private BigDecimal preco;
        private Integer quantidadeEmEstoque;


        // Getters e Setters
    }


