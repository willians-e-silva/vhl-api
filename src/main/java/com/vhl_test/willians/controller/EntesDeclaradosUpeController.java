package com.vhl_test.willians.controller;

import com.vhl_test.willians.service.EnteDeclaradoUpeService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @GetMapping("/")
    public List<Map<String, Object>> getEntesDeclaradosUPE() {
        List<Map<String, Object>> response;
        response = enteDeclaradoUpeService.getEntesDeclarados();
        return response;
    }
}