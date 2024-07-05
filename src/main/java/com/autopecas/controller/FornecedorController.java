package com.autopecas.controller;

import com.autopecas.entity.Fornecedor;
import com.autopecas.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/fornecedores")
public class FornecedorController {
    @Autowired
    private FornecedorService fornecedorService;

    @GetMapping
    public List<Fornecedor> findAll() {
        return fornecedorService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> findById(@PathVariable Long id) {
        Optional<Fornecedor> fornecedor = fornecedorService.findById(id);
        if (fornecedor.isPresent()) {
            return ResponseEntity.ok(fornecedor.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Fornecedor save(@RequestBody Fornecedor fornecedor) {
        return fornecedorService.save(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> update(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        Optional<Fornecedor> existingFornecedor = fornecedorService.findById(id);
        if (existingFornecedor.isPresent()) {
            fornecedor.setId(id);
            return ResponseEntity.ok(fornecedorService.save(fornecedor));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Fornecedor> fornecedor = fornecedorService.findById(id);
        if (fornecedor.isPresent()) {
            fornecedorService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}