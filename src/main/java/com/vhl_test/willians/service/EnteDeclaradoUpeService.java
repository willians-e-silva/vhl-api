package com.vhl_test.willians.service;

import com.vhl_test.willians.model.EnteDeclaradoUtilidadePublicaEstadual;
import com.vhl_test.willians.dto.EnteDeclaradoUtilidadePublicaEstadualDTO;
import com.vhl_test.willians.repository.EnteDeclaradoUtilidadePublicaEstadualRepository;
import com.vhl_test.willians.mapper.EnteDeclaradoUtilidadePublicaEstadualMapper;

import com.vhl_test.willians.exception.EntityNotFoundException;
import com.vhl_test.willians.exception.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

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

    public List<EnteDeclaradoUtilidadePublicaEstadualDTO> getAll(Pageable pageable) {
        try {
            Page<EnteDeclaradoUtilidadePublicaEstadual> entities = repository.findAll(pageable);
            return entities.map(mapper::toDto).getContent();
        } catch (Exception error) {
            throw new ServiceException("Error fetching all entities", error);
        }
    }

    public List<EnteDeclaradoUtilidadePublicaEstadualDTO> search(String searchText, Pageable pageable) {
        try {
            Page<EnteDeclaradoUtilidadePublicaEstadual> entities = repository.findByNameContainingIgnoreCase(searchText, pageable);
            List<EnteDeclaradoUtilidadePublicaEstadualDTO> dtos = entities.map(mapper::toDto).getContent();

            if (dtos.isEmpty()) {
                throw new EntityNotFoundException("No entities found matching name: " + searchText);
            }

            return dtos;
        } catch (EntityNotFoundException error) {
            throw error;
        } catch (Exception error) {
            throw new ServiceException("Error searching entities with name: " + searchText, error);
        }
    }

    public EnteDeclaradoUtilidadePublicaEstadualDTO getByCode(int code) {
        try {
            return repository.findByCode(code)
                    .map(mapper::toDto)
                    .orElseThrow(() -> new EntityNotFoundException("No entities found matching code: " + code));
        } catch (EntityNotFoundException error) {
            throw error;
        } catch (Exception error) {
            throw new ServiceException("Error fetching entity with code: " + code, error);
        }
    }
}
