package com.autopecas.controller;

import com.autopecas.entity.Financeiro;
import com.autopecas.service.FinanceiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/financeiro")
public class FinanceiroController {
    @Autowired
    private FinanceiroService financeiroService;

    @GetMapping
    public List<Financeiro> findAll() {
        return financeiroService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Financeiro> findById(@PathVariable Long id) {
        Optional<Financeiro> financeiro = financeiroService.findById(id);
        if (financeiro.isPresent()) {
            return ResponseEntity.ok(financeiro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Financeiro save(@RequestBody Financeiro financeiro) {
        return financeiroService.save(financeiro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Financeiro> update(@PathVariable Long id, @RequestBody Financeiro financeiro) {
        Optional<Financeiro> existingFinanceiro = financeiroService.findById(id);
        if (existingFinanceiro.isPresent()) {
            financeiro.setId(id);
            return ResponseEntity.ok(financeiroService.save(financeiro));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Financeiro> financeiro = financeiroService.findById(id);
        if (financeiro.isPresent()) {
            financeiroService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}