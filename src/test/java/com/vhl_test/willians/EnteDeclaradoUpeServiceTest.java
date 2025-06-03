package com.vhl_test.willians;

import com.vhl_test.willians.dto.EnteDeclaradoUtilidadePublicaEstadualDTO;
import com.vhl_test.willians.exception.EntityNotFoundException;
import com.vhl_test.willians.mapper.EnteDeclaradoUtilidadePublicaEstadualMapper;
import com.vhl_test.willians.model.EnteDeclaradoUtilidadePublicaEstadual;
import com.vhl_test.willians.repository.EnteDeclaradoUtilidadePublicaEstadualRepository;
import com.vhl_test.willians.exception.ServiceException;

import com.vhl_test.willians.service.EnteDeclaradoUpeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.data.domain.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class EnteDeclaradoUpeServiceTest {

    @Mock
    private EnteDeclaradoUtilidadePublicaEstadualRepository repository;

    @Mock
    private EnteDeclaradoUtilidadePublicaEstadualMapper mapper;

    @InjectMocks
    private EnteDeclaradoUpeService service;

    private EnteDeclaradoUtilidadePublicaEstadual entity;
    private EnteDeclaradoUtilidadePublicaEstadualDTO dto;
    private Pageable pageable;

    @BeforeEach
    void setup() {
        entity = new EnteDeclaradoUtilidadePublicaEstadual();
        dto = new EnteDeclaradoUtilidadePublicaEstadualDTO();
        pageable = PageRequest.of(0, 10);
    }

    @Test
    void getAll_shouldReturnListOfDTOs() {
        Page<EnteDeclaradoUtilidadePublicaEstadual> page = new PageImpl<>(List.of(entity));
        when(repository.findAll(pageable)).thenReturn(page);
        when(mapper.toDto(entity)).thenReturn(dto);

        List<EnteDeclaradoUtilidadePublicaEstadualDTO> result = service.getAll(pageable);

        assertEquals(1, result.size());
        assertEquals(dto, result.getFirst());
    }

    @Test
    void search_shouldReturnListOfDTOsWhenFound() {
        Page<EnteDeclaradoUtilidadePublicaEstadual> page = new PageImpl<>(List.of(entity));
        when(repository.findByNameContainingIgnoreCase("teste", pageable)).thenReturn(page);
        when(mapper.toDto(entity)).thenReturn(dto);

        List<EnteDeclaradoUtilidadePublicaEstadualDTO> result = service.search("teste", pageable);

        assertEquals(1, result.size());
        assertEquals(dto, result.getFirst());
    }

    @Test
    void search_shouldReturnThrowEntityNotFoundExceptionWhenNotFound() {
        Page<EnteDeclaradoUtilidadePublicaEstadual> emptyPage = new PageImpl<>(Collections.emptyList());
        when(repository.findByNameContainingIgnoreCase("nada", pageable)).thenReturn(emptyPage);

        assertThrows(EntityNotFoundException.class, () -> service.search("nada", pageable));
    }

    @Test
    void getByCode_shouldReturnDTOWhenFound() {
        when(repository.findByCode(123)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);

        EnteDeclaradoUtilidadePublicaEstadualDTO result = service.getByCode(123);

        assertEquals(dto, result);
    }

    @Test
    void getByCode_shouldThrownEntityNotFoundExceptionWhenNotFound() {
        when(repository.findByCode(999)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.getByCode(999));
    }

    @Test
    void getAll_shouldThrowServiceException_whenRepositoryThrows() {
        when(repository.findAll(pageable)).thenThrow(new RuntimeException("DB error"));

        ServiceException exception = assertThrows(ServiceException.class, () -> service.getAll(pageable));
        assertTrue(exception.getMessage().contains("Error fetching all entities"));
    }

    @Test
    void getAll_shouldThrowServiceException_whenMapperThrows() {
        Page<EnteDeclaradoUtilidadePublicaEstadual> page = new PageImpl<>(List.of(entity));
        when(repository.findAll(pageable)).thenReturn(page);
        when(mapper.toDto(entity)).thenThrow(new RuntimeException("Mapping error"));

        ServiceException exception = assertThrows(ServiceException.class, () -> service.getAll(pageable));
        assertTrue(exception.getMessage().contains("Error fetching all entities"));
    }
}
