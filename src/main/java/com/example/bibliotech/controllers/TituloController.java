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

import com.example.bibliotech.dtos.titulo.CreateTituloDto;
import com.example.bibliotech.models.Titulo;
import com.example.bibliotech.services.AreaService;
import com.example.bibliotech.services.TituloService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/titulo")
public class TituloController  {
 
    @Autowired
    TituloService tituloService;

    @Autowired
    AreaService areaService;

    @SuppressWarnings("rawtypes")
    @PostMapping()
    public ResponseEntity create(
        @RequestBody @Valid CreateTituloDto body
    ){
        try {

            var area = this.areaService.getAreaById(body.areaId());
            this.tituloService.executeVoidFunctions("create", 0, 
            new Titulo(body.nome(), body.prazo(), body.isbn(), body.edicao(), body.ano(), area ));
    
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
        @RequestBody @Valid CreateTituloDto body
    ){

        try {

            this.tituloService.executeVoidFunctions("update", id, 
            new Titulo(body.nome(), body.prazo(), body.isbn(), body.edicao(), body.ano()));
    
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

            this.tituloService.executeVoidFunctions("delete", id, 
            new Titulo());
    
            return ResponseEntity.ok("Titulo excluido");
            
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

            var titulo = this.tituloService.getTituloById(id);
  
            return ResponseEntity.ok(titulo);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    
    @SuppressWarnings("rawtypes")
    @GetMapping("")
    public ResponseEntity getTitulos(){

        try {

            var titulos = this.tituloService.getAllTitulos();
            return ResponseEntity.ok(titulos);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }
    
}
