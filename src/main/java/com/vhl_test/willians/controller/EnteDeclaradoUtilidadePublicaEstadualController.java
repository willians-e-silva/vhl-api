package com.vhl_test.willians.controller;

import com.vhl_test.willians.service.EnteDeclaradoUtilidadePublicaEstadualService;
import com.vhl_test.willians.dto.EnteDeclaradoUtilidadePublicaEstadualDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/EntesDeclaradosUPE")
public class EnteDeclaradoUtilidadePublicaEstadualController {

    private final EnteDeclaradoUtilidadePublicaEstadualService enteDeclaradoUtilidadePublicaEstadualService;

    public EnteDeclaradoUtilidadePublicaEstadualController(EnteDeclaradoUtilidadePublicaEstadualService enteDeclaradoUtilidadePublicaEstadualService) {
        this.enteDeclaradoUtilidadePublicaEstadualService = enteDeclaradoUtilidadePublicaEstadualService;
    }

    @GetMapping("/getAll")
    public List<EnteDeclaradoUtilidadePublicaEstadualDTO> getAllEnteDeclaradoUtilidadePublicaEstadual(
            @PageableDefault(size = 10) Pageable pageable) {
        return enteDeclaradoUtilidadePublicaEstadualService.getAll(pageable);
    }

    @GetMapping("/search")
    public List<EnteDeclaradoUtilidadePublicaEstadualDTO> searchEnteDeclaradoUtilidadePublicaEstadual(
            @RequestParam String searchText,
            @PageableDefault(size = 10) Pageable pageable) {
        return enteDeclaradoUtilidadePublicaEstadualService.search(searchText, pageable);
    }

    @GetMapping("/getByCode")
    public EnteDeclaradoUtilidadePublicaEstadualDTO getByCodeEnteDeclaradoUtilidadePublicaEstadual(
            @RequestParam Integer code) {
        return enteDeclaradoUtilidadePublicaEstadualService.getByCode(code);
    }

    @GetMapping("/getById")
    public EnteDeclaradoUtilidadePublicaEstadualDTO getByUuidEnteDeclaradoUtilidadePublicaEstadual(
            @RequestParam UUID id) {
        return enteDeclaradoUtilidadePublicaEstadualService.getById(id);
    }
}