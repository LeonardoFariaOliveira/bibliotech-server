package com.example.bibliotech.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotech.models.Aluno;
import com.example.bibliotech.models.Emprestimo;

@Repository
public interface EmprestimoRepository extends JpaRepository<Emprestimo, Integer> {
    public List<Emprestimo> findByOrderByDataEmprestimoDesc();
    public List<Emprestimo> findByAluno(Aluno aluno);
}
