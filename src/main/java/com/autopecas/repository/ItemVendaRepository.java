package com.autopecas.repository;



import com.autopecas.entity.ItemVendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemVendaRepository extends JpaRepository<ItemVendas, Long> {
}