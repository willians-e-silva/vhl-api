package com.vhl_test.willians.repository;

import com.vhl_test.willians.model.EnteDeclaradoUtilidadePublicaEstadual;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface EnteDeclaradoUtilidadePublicaEstadualRepository extends JpaRepository<EnteDeclaradoUtilidadePublicaEstadual, UUID> {
    List<EnteDeclaradoUtilidadePublicaEstadual> findByNameContainingIgnoreCase(String name);
    List<EnteDeclaradoUtilidadePublicaEstadual> findByCode(Integer code);
}
