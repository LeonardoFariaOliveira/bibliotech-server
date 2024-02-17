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

import com.example.bibliotech.dtos.reserva.CreateReservaDto;
import com.example.bibliotech.models.Aluno;
import com.example.bibliotech.models.Livro;
import com.example.bibliotech.models.Reserva;
import com.example.bibliotech.services.AlunoService;
import com.example.bibliotech.services.ReservaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/reserva")
public class ReservaController  {
 
    @Autowired
    ReservaService reservaService;

    @Autowired
    AlunoService alunoService;

    @SuppressWarnings("rawtypes")
    @PostMapping()
    public ResponseEntity create(
        @RequestBody @Valid CreateReservaDto body
    ){
        try {

            var aluno = this.alunoService.getAlunoById(body.matricula());
            if(aluno == null){
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                    "Aluno não existe"
                );
            }

            this.reservaService.executeVoidFunctions("create", 0, 
            new Reserva(body.data(), new Livro(), aluno));
    
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
        @RequestBody @Valid CreateReservaDto body
    ){

        try {



            this.reservaService.executeVoidFunctions("update", id, 
            new Reserva(body.data(), new Livro(), new Aluno()));
    
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

            this.reservaService.executeVoidFunctions("delete", id, 
            new Reserva());
    
            return ResponseEntity.ok("Reserva excluida");
            
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

            var reserva = this.reservaService.getReservaById(id);
            return ResponseEntity.ok(reserva);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }

    
    @SuppressWarnings("rawtypes")
    @GetMapping("")
    public ResponseEntity getReservas(){

        try {

            var reservas = this.reservaService.getAllReservas();
            return ResponseEntity.ok(reservas);
            
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    e
            );
        }


    }
    
}
