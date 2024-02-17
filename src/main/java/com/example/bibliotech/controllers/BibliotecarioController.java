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

import com.example.bibliotech.dtos.bibliotecario.CreateBibliotecarioDto;
import com.example.bibliotech.dtos.bibliotecario.LoginBibliotecarioDto;
import com.example.bibliotech.models.Bibliotecario;
import com.example.bibliotech.models.User;
import com.example.bibliotech.services.BibliotecarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/bibliotecario")
public class BibliotecarioController  {
 
    @Autowired
    BibliotecarioService bibliotecarioService;

    @SuppressWarnings("rawtypes")
    @PostMapping()
    public ResponseEntity create(
        @RequestBody @Valid CreateBibliotecarioDto body
    ){
        try {

            this.bibliotecarioService.executeVoidFunctions("create", 0, 
            new Bibliotecario(body.nome(), body.email(), body.senha(), 
                    new Bibliotecario(
                        new User()
                    )
                )
            );
    
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
        @RequestBody @Valid CreateBibliotecarioDto body
    ){

        try {

            this.bibliotecarioService.executeVoidFunctions("update", id, 
            new Bibliotecario(body.nome(), body.email(), body.senha(), 
                    new Bibliotecario(
                        new User()
                    )
                )
            );
    
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

            this.bibliotecarioService.executeVoidFunctions("delete", id, 
            new Bibliotecario(
                new Bibliotecario(
                    new User()
                )
            ));
    
            return ResponseEntity.ok("Bibliotecario excluido");
            
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

            var bibliotecario = this.bibliotecarioService.getBibliotecarioById(id);
            return ResponseEntity.ok(bibliotecario);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    
    @SuppressWarnings("rawtypes")
    @GetMapping("")
    public ResponseEntity getBibliotecarios(){

        try {

            var bibliotecarios = this.bibliotecarioService.getAllBibliotecarios();
            return ResponseEntity.ok(bibliotecarios);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    @SuppressWarnings("rawtypes")
    @GetMapping("auth")
    public ResponseEntity getByEmail(@RequestBody @Valid LoginBibliotecarioDto body
    ){

        try {

            var bibliotecario = this.bibliotecarioService.getBibliotecarioByEmail(body.email());
            if(bibliotecario.getSenha().equals(body.senha()))
                return ResponseEntity.ok(bibliotecario);
            else
                return ResponseEntity.status(400).body("Email ou senha invalidos");
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                e
            );
        }


    }
    
}
