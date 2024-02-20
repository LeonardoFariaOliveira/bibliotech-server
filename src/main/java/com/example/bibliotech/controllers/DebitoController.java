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

import com.example.bibliotech.dtos.debito.CreateDebitoDto;
import com.example.bibliotech.models.Debito;
import com.example.bibliotech.services.AlunoService;
import com.example.bibliotech.services.DebitoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/debito")
public class DebitoController  {
 
    @Autowired
    DebitoService debitoService;

    @Autowired
    AlunoService alunoService;

    @SuppressWarnings("rawtypes")
    @PostMapping()
    public ResponseEntity create(
        @RequestBody @Valid CreateDebitoDto body
    ){
        try {

            var aluno = this.alunoService.getAlunoById(body.matricula());
            if(aluno == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "Aluno não existe"
                );
            }

    
            this.debitoService.executeVoidFunctions("create", 0, 
            new Debito(
                body.valor(), new Date(), aluno
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
        @RequestBody @Valid CreateDebitoDto body
    ){

        try {

            this.debitoService.executeVoidFunctions("update", id, 
            new Debito(body.valor(), new Date()));
    
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

            this.debitoService.executeVoidFunctions("delete", id, 
            new Debito());
    
            return ResponseEntity.ok("Debito excluido");
            
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

            var debito = this.debitoService.getDebitoById(id);
            return ResponseEntity.ok(debito);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    
    @SuppressWarnings("rawtypes")
    @GetMapping("")
    public ResponseEntity getDebitos(){

        try {

            var debitos = this.debitoService.getAllDebitos();
            return ResponseEntity.ok(debitos);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }
    
}
