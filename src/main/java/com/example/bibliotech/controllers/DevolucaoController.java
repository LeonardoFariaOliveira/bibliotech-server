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

import com.example.bibliotech.dtos.devolucao.CreateDevolucaoDto;
import com.example.bibliotech.dtos.devolucao.UpdateDevolucaoDto;
import com.example.bibliotech.models.Devolucao;
import com.example.bibliotech.services.DevolucaoService;
import com.example.bibliotech.services.EmprestimoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/devolucao")
public class DevolucaoController  {
 
    @Autowired
    DevolucaoService devolucaoService;

    @Autowired
    EmprestimoService emprestimoService;

    @SuppressWarnings("rawtypes")
    @PostMapping()
    public ResponseEntity create(
        @RequestBody @Valid CreateDevolucaoDto body
    ){
        try {

            var emprestimo = this.emprestimoService.getEmprestimoById(body.idEmprestimo());
            if(emprestimo == null){
                
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "Emprestimo não existe"
                );
            
            }

            System.out.println("chegou");
            this.devolucaoService.executeVoidFunctions("create", 0, 
            new Devolucao(
                body.dataDevolucao(),
                body.valorTotal(),
                0.0,
                0,
                emprestimo
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
        @RequestBody @Valid UpdateDevolucaoDto body
    ){

        try {

            this.devolucaoService.executeVoidFunctions("update", id, 
            new Devolucao(
                body.dataDevolucao(),
                body.valorTotal(),
                body.multa(),
                body.atraso()
            ));
    
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

            this.devolucaoService.executeVoidFunctions("delete", id, 
            new Devolucao());
    
            return ResponseEntity.ok("Devolucao excluido");
            
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

            var devolucao = this.devolucaoService.getDevolucaoById(id);
            return ResponseEntity.ok(devolucao);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    
    @SuppressWarnings("rawtypes")
    @GetMapping("")
    public ResponseEntity getDevolucaos(){

        try {

            var devolucoes = this.devolucaoService.getAllDevolucaos();
            return ResponseEntity.ok(devolucoes);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }
    
}
