package com.autopecas.service;


import com.autopecas.entity.Financeiro;
import com.autopecas.repository.FinanceiroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FinanceiroService {
    @Autowired
    private FinanceiroRepository financeiroRepository;

    public Financeiro save(Financeiro financeiro) {
        return financeiroRepository.save(financeiro);
    }

    public List<Financeiro> findAll() {
        return financeiroRepository.findAll();
    }

    public Optional<Financeiro> findById(Long id) {
        return financeiroRepository.findById(id);
    }

    public void deleteById(Long id) {
        financeiroRepository.deleteById(id);
    }
}