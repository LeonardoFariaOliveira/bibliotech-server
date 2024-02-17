package com.example.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotech.models.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    
}
