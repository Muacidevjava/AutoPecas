package com.autopecas.controller;

import com.autopecas.entity.Estoque;
import com.autopecas.service.EstoqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estoques")
public class EstoqueController {
    @Autowired
    private EstoqueService estoqueService;

    @GetMapping
    public List<Estoque> findAll() {
        return estoqueService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Estoque> findById(@PathVariable Long id) {
        Optional<Estoque> estoque = estoqueService.findById(id);
        if (estoque.isPresent()) {
            return ResponseEntity.ok(estoque.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Estoque save(@RequestBody Estoque estoque) {
        return estoqueService.save(estoque);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Estoque> update(@PathVariable Long id, @RequestBody Estoque estoque) {
        Optional<Estoque> existingEstoque = estoqueService.findById(id);
        if (existingEstoque.isPresent()) {
            estoque.setId(id);
            return ResponseEntity.ok(estoqueService.save(estoque));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Estoque> estoque = estoqueService.findById(id);
        if (estoque.isPresent()) {
            estoqueService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}