package com.example.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotech.models.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
    
}
