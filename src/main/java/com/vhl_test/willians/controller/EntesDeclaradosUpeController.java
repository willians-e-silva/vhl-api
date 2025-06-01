package com.vhl_test.willians.controller;

import com.vhl_test.willians.service.EnteDeclaradoUpeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/EntesDeclaradosUPE")
public class EntesDeclaradosUpeController {

    private final EnteDeclaradoUpeService enteDeclaradoUpeService;

    public EntesDeclaradosUpeController(EnteDeclaradoUpeService enteDeclaradoUpeService) {
        this.enteDeclaradoUpeService = enteDeclaradoUpeService;
    }

    @GetMapping("/getAll")
    public List<Map<String, Object>> getAllEntesDeclaradosUPE() {
        return enteDeclaradoUpeService.getAll();
    }

    @GetMapping("/search")
    public List<Map<String, Object>> searchEntesDeclaradosUPE(
            @RequestParam String searchText) {
        return enteDeclaradoUpeService.search(searchText);
    }

    @GetMapping("/getByCode")
    public List<Map<String, Object>> getByCodeEntesDeclaradosUPE(
            @RequestParam Integer code) {
        return enteDeclaradoUpeService.getByCode(code);
    }
}