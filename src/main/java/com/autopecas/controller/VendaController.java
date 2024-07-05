package com.autopecas.controller;

import com.autopecas.entity.Venda;
import com.autopecas.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/vendas")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @GetMapping
    public List<Venda> findAll() {
        return vendaService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Venda> findById(@PathVariable Long id) {
        Optional<Venda> venda = vendaService.findById(id);
        if (venda.isPresent()) {
            return ResponseEntity.ok(venda.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Venda save(@RequestBody Venda venda) {
        return vendaService.save(venda);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Venda> update(@PathVariable Long id, @RequestBody Venda venda) {
        Optional<Venda> existingVenda = vendaService.findById(id);
        if (existingVenda.isPresent()) {
            venda.setId(id);
            return ResponseEntity.ok(vendaService.save(venda));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Optional<Venda> venda = vendaService.findById(id);
        if (venda.isPresent()) {
            vendaService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
