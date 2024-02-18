package com.example.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotech.models.Devolucao;

@Repository
public interface DevolucaoRepository extends JpaRepository<Devolucao, Integer> {
    
}
