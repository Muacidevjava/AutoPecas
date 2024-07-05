package com.autopecas.service;


import com.autopecas.entity.Estoque;
import com.autopecas.repository.EstoqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstoqueService {
    @Autowired
    private EstoqueRepository estoqueRepository;

    public Estoque save(Estoque estoque) {
        return estoqueRepository.save(estoque);
    }

    public List<Estoque> findAll() {
        return estoqueRepository.findAll();
    }

    public Optional<Estoque> findById(Long id) {
        return estoqueRepository.findById(id);
    }

    public void deleteById(Long id) {
        estoqueRepository.deleteById(id);
    }
}
