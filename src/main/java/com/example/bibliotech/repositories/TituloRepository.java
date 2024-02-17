package com.example.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotech.models.Titulo;

@Repository
public interface TituloRepository extends JpaRepository<Titulo, Integer> {
    
}
