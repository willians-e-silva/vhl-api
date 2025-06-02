package com.vhl_test.willians.dto;

import java.util.UUID;

public class EnteDeclaradoUtilidadePublicaEstadualDTO {

    private UUID id;
    private String name;
    private Long code;
    private String law;

    public EnteDeclaradoUtilidadePublicaEstadualDTO() {
    }

    public EnteDeclaradoUtilidadePublicaEstadualDTO(UUID id, String name, Long code, String law) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.law = law;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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