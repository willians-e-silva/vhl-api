package com.vhl_test.willians.model;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "entes_declarados_utilidade_publica_estadual")
public class EnteDeclaradoUtilidadePublicaEstadual {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Long code;

    @Column(length = 100, nullable = false)
    private String law;

    public EnteDeclaradoUtilidadePublicaEstadual() {
    }

    public EnteDeclaradoUtilidadePublicaEstadual(String name, Long code, String law) {
        this.name = name;
        this.code = code;
        this.law = law;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getLaw() {
        return law;
    }

    public void setLaw(String law) {
        this.law = law;
    }
}
