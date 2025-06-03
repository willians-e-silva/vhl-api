package com.vhl_test.willians.controller;

import com.vhl_test.willians.service.EnteDeclaradoUpeService;
import com.vhl_test.willians.dto.EnteDeclaradoUtilidadePublicaEstadualDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;

import java.util.List;

@RestController
@RequestMapping(path = "/EntesDeclaradosUPE")
public class EntesDeclaradosUpeController {

    private final EnteDeclaradoUpeService enteDeclaradoUpeService;

    public EntesDeclaradosUpeController(EnteDeclaradoUpeService enteDeclaradoUpeService) {
        this.enteDeclaradoUpeService = enteDeclaradoUpeService;
    }

    @GetMapping("/getAll")
    public List<EnteDeclaradoUtilidadePublicaEstadualDTO> getAllEntesDeclaradosUPE(
            @PageableDefault(size = 10) Pageable pageable) {
        return enteDeclaradoUpeService.getAll(pageable);
    }

    @GetMapping("/search")
    public List<EnteDeclaradoUtilidadePublicaEstadualDTO> searchEntesDeclaradosUPE(
            @RequestParam String searchText,
            @PageableDefault(size = 10) Pageable pageable) {
        return enteDeclaradoUpeService.search(searchText, pageable);
    }

    @GetMapping("/getByCode")
    public EnteDeclaradoUtilidadePublicaEstadualDTO getByCodeEntesDeclaradosUPE(
            @RequestParam Integer code) {
        return enteDeclaradoUpeService.getByCode(code);
    }
}