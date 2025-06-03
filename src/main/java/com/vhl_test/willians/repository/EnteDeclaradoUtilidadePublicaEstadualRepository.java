package com.vhl_test.willians.repository;

import com.vhl_test.willians.model.EnteDeclaradoUtilidadePublicaEstadual;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

public interface EnteDeclaradoUtilidadePublicaEstadualRepository extends JpaRepository<EnteDeclaradoUtilidadePublicaEstadual, UUID> {
    Page<EnteDeclaradoUtilidadePublicaEstadual> findByNameContainingIgnoreCase(String name, Pageable pageable);
    Optional<EnteDeclaradoUtilidadePublicaEstadual> findByCode(Integer code);
}
