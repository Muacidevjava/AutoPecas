package com.autopecas.service;

import com.autopecas.entity.Venda;
import com.autopecas.repository.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Optional<Venda> findById(Long id) {
        return vendaRepository.findById(id);
    }

    public void deleteById(Long id) {
        vendaRepository.deleteById(id);
    }
}