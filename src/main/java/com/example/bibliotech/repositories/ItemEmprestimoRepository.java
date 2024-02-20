package com.example.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotech.models.ItemEmprestimo;

@Repository
public interface ItemEmprestimoRepository extends JpaRepository<ItemEmprestimo, Integer> {
    
}
