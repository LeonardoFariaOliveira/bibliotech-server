package com.example.bibliotech.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bibliotech.dtos.aluno.CreateAlunoDto;
import com.example.bibliotech.models.Aluno;
import com.example.bibliotech.services.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/aluno")
public class AlunoController  {
 
    @Autowired
    AlunoService alunoService;

    @SuppressWarnings("rawtypes")
    @PostMapping()
    public ResponseEntity create(
        @RequestBody @Valid CreateAlunoDto body
    ){
        try {
            System.out.println("chegou");
            this.alunoService.executeVoidFunctions("create", 0, 
            new Aluno(body.nome(), body.cpf(), body.endereco()));
    
            return ResponseEntity.ok("Criado");
    
            
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
            
        }

    }

    @SuppressWarnings("rawtypes")
    @PatchMapping("{id}")
    public ResponseEntity update(@PathVariable(value = "id") int id,
        @RequestBody @Valid CreateAlunoDto body
    ){

        try {

            this.alunoService.executeVoidFunctions("update", id, 
            new Aluno(body.nome(), body.cpf(), body.endereco()));
    
            return ResponseEntity.ok("Ok");
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    @SuppressWarnings("rawtypes")
    @DeleteMapping("{id}")
    public ResponseEntity delete(@PathVariable(value = "id") int id
    ){

        try {

            this.alunoService.executeVoidFunctions("delete", id, 
            new Aluno());
    
            return ResponseEntity.ok("Aluno excluido");
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    @SuppressWarnings("rawtypes")
    @GetMapping("{id}")
    public ResponseEntity getById(@PathVariable(value = "id") int id
    ){

        try {

            var aluno = this.alunoService.getAlunoById(id);
            return ResponseEntity.ok(aluno);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    
    @SuppressWarnings("rawtypes")
    @GetMapping("")
    public ResponseEntity getAlunos(){

        try {

            var alunos = this.alunoService.getAllAlunos();
            return ResponseEntity.ok(alunos);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }
    
}
