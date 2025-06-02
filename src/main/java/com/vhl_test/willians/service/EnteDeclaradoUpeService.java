package com.vhl_test.willians.service;

import com.vhl_test.willians.model.EnteDeclaradoUtilidadePublicaEstadual;
import com.vhl_test.willians.dto.EnteDeclaradoUtilidadePublicaEstadualDTO;
import com.vhl_test.willians.repository.EnteDeclaradoUtilidadePublicaEstadualRepository;
import com.vhl_test.willians.mapper.EnteDeclaradoUtilidadePublicaEstadualMapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnteDeclaradoUpeService {
    private final EnteDeclaradoUtilidadePublicaEstadualRepository repository;
    private final EnteDeclaradoUtilidadePublicaEstadualMapper mapper;

    public EnteDeclaradoUpeService(
            EnteDeclaradoUtilidadePublicaEstadualRepository repository,
            EnteDeclaradoUtilidadePublicaEstadualMapper mapper
    ) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<EnteDeclaradoUtilidadePublicaEstadualDTO> getAll() {
        List<EnteDeclaradoUtilidadePublicaEstadual> entities = repository.findAll();
        return entities.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public List<EnteDeclaradoUtilidadePublicaEstadualDTO> search(String searchText) {
        List<EnteDeclaradoUtilidadePublicaEstadual> entities = repository.findByNameContainingIgnoreCase(searchText);
        return entities.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public List<EnteDeclaradoUtilidadePublicaEstadualDTO> getByCode(int code) {
        List<EnteDeclaradoUtilidadePublicaEstadual> entities = repository.findByCode(code);
        return entities.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }
}
