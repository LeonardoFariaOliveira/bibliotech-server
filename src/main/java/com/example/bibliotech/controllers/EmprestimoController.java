package com.example.bibliotech.controllers;

import java.util.Date;

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

import com.example.bibliotech.dtos.emprestimo.CreateEmprestimoDto;
import com.example.bibliotech.dtos.emprestimo.UpdateEmprestimoDto;
import com.example.bibliotech.models.Devolucao;
import com.example.bibliotech.models.Emprestimo;
import com.example.bibliotech.services.AlunoService;
import com.example.bibliotech.services.DebitoService;
import com.example.bibliotech.services.EmprestimoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/emprestimo")
public class EmprestimoController  {
 
    @Autowired
    EmprestimoService emprestimoService;

    @Autowired
    AlunoService alunoService;

    @Autowired
    DebitoService debitoService;

    @SuppressWarnings("rawtypes")
    @PostMapping()
    public ResponseEntity create(
        @RequestBody @Valid CreateEmprestimoDto body
    ){
        try {

            var aluno = this.alunoService.getAlunoById(body.matricula());
            if(aluno == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "Aluno não existe"
                );
            }

            var debito = this.debitoService.getDebitoByAluno(aluno);

            if(!(debito == null)){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "Aluno não pode emprestar pois possui debitos"
                );
            }

            this.emprestimoService.executeVoidFunctions("create", 0, 
            new Emprestimo(
                new Date(),
                0.0,
                aluno,
                body.itensEmprestimo(),
                new Devolucao(
                    body.dataDevolucao(),
                    body.valorTotal(),
                    0.0,
                    0
                )
            ));
    
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
        @RequestBody @Valid UpdateEmprestimoDto body
    ){

        try {

            this.emprestimoService.executeVoidFunctions("update", id, 
            new Emprestimo(new Date(), body.multa()));
    
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

            this.emprestimoService.executeVoidFunctions("delete", id, 
            new Emprestimo());
    
            return ResponseEntity.ok("Emprestimo excluido");
            
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

            var emprestimo = this.emprestimoService.getEmprestimoById(id);
            return ResponseEntity.ok(emprestimo);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    
    @SuppressWarnings("rawtypes")
    @GetMapping("")
    public ResponseEntity getEmprestimos(){

        try {

            var emprestimos = this.emprestimoService.getAllEmprestimos();
            return ResponseEntity.ok(emprestimos);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }
    
}
