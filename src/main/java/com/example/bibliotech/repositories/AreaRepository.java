package com.example.bibliotech.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bibliotech.models.Area;

@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
    
}
