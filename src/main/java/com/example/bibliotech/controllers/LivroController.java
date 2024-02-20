package com.example.bibliotech.controllers;

import java.util.ArrayList;

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

import com.example.bibliotech.dtos.livro.CreateLivroDto;
import com.example.bibliotech.dtos.livro.UpdateLivroDto;
import com.example.bibliotech.models.Autor;
import com.example.bibliotech.models.Livro;
import com.example.bibliotech.models.Titulo;
import com.example.bibliotech.services.AreaService;
import com.example.bibliotech.services.AutorService;
import com.example.bibliotech.services.LivroService;
import com.example.bibliotech.services.TituloService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/livro")
public class LivroController  {
 
    @Autowired
    LivroService livroService;

    @Autowired
    TituloService tituloService;

    @Autowired
    AreaService areaService;

    @Autowired
    AutorService autorService;

    @SuppressWarnings("rawtypes")
    @PostMapping()
    public ResponseEntity create(
        @RequestBody @Valid CreateLivroDto body
    ){
        try {

            var autor = this.autorService.getAutorByNome(body.nomeAutor());
            if(autor == null){
                autor = new Autor(body.nomeAutor(), " ", "mestre", new ArrayList<Titulo>());
            }
            this.autorService.executeVoidFunctions("create", 0, autor);

            var area = this.areaService.getAreaById(body.areaId());
            if(area == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "Area não existe"
                );
            }
            var titulo = new Titulo(body.nome(), body.prazo(), body.isbn(), body.edicao(), body.ano(), area, autor );
            this.tituloService.executeVoidFunctions("create", 0, titulo);

            this.livroService.executeVoidFunctions("create", 0, 
            new Livro(true, body.dataPrevista(), titulo));
    
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
        @RequestBody @Valid UpdateLivroDto body
    ){

        try {

            var titulo = this.tituloService.getTituloById(body.tituloId());

            this.livroService.executeVoidFunctions("update", id, 
            new Livro(body.disponivel(), body.dataPrevista(),  titulo));
    
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

            this.livroService.executeVoidFunctions("delete", id, 
            new Livro());
    
            return ResponseEntity.ok("Livro excluido");
            
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

            var livro = this.livroService.getLivroById(id);
            return ResponseEntity.ok(livro);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    
    @SuppressWarnings("rawtypes")
    @GetMapping("")
    public ResponseEntity getLivros(){

        try {

            var livros = this.livroService.getAllLivros();
            return ResponseEntity.ok(livros);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }
    
}
