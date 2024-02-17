package com.example.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotech.models.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Integer> {
    
}
