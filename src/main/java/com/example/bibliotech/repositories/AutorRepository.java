package com.example.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotech.models.Autor;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Integer> {
    
}
