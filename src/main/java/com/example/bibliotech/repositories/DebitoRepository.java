package com.example.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotech.models.Aluno;
import com.example.bibliotech.models.Debito;
import java.util.Optional;


@Repository
public interface DebitoRepository extends JpaRepository<Debito, Integer> {
    Optional<Debito> findByAluno(Aluno aluno); 
}
