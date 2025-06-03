package com.vhl_test.willians;

import com.vhl_test.willians.dto.EnteDeclaradoUtilidadePublicaEstadualDTO;
import com.vhl_test.willians.exception.EntityNotFoundException;
import com.vhl_test.willians.mapper.EnteDeclaradoUtilidadePublicaEstadualMapper;
import com.vhl_test.willians.model.EnteDeclaradoUtilidadePublicaEstadual;
import com.vhl_test.willians.repository.EnteDeclaradoUtilidadePublicaEstadualRepository;
import com.vhl_test.willians.exception.ServiceException;

import com.vhl_test.willians.service.EnteDeclaradoUtilidadePublicaEstadualService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.springframework.data.domain.*;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(org.mockito.junit.jupiter.MockitoExtension.class)
public class EnteDeclaradoUtilidadePublicaEstadualServiceTest extends AbstractPostgresContainerTest {

    @Mock
    private EnteDeclaradoUtilidadePublicaEstadualRepository repository;

    @Mock
    private EnteDeclaradoUtilidadePublicaEstadualMapper mapper;

    @InjectMocks
    private EnteDeclaradoUtilidadePublicaEstadualService service;

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
    @DisplayName("Should get all EnteDeclaradoUtilidadePublicaEstadual and return DTOs list")
    void getAll_shouldReturnListOfDTOs() {
        Page<EnteDeclaradoUtilidadePublicaEstadual> page = new PageImpl<>(List.of(entity));
        when(repository.findAll(pageable)).thenReturn(page);
        when(mapper.toDto(entity)).thenReturn(dto);

        List<EnteDeclaradoUtilidadePublicaEstadualDTO> result = service.getAll(pageable);

        assertEquals(1, result.size());
        assertEquals(dto, result.getFirst());
    }

    @Test
    @DisplayName("Should get all EnteDeclaradoUtilidadePublicaEstadual and return error exception")
    void getAll_shouldThrowServiceException_whenRepositoryThrows() {
        when(repository.findAll(pageable)).thenThrow(new RuntimeException("DB error"));

        ServiceException exception = assertThrows(ServiceException.class, () -> service.getAll(pageable));
        assertTrue(exception.getMessage().contains("Error fetching all entities"));
    }

    @Test
    @DisplayName("Should get all EnteDeclaradoUtilidadePublicaEstadual and return exception error")
    void getAll_shouldThrowServiceException_whenMapperThrows() {
        Page<EnteDeclaradoUtilidadePublicaEstadual> page = new PageImpl<>(List.of(entity));
        when(repository.findAll(pageable)).thenReturn(page);
        when(mapper.toDto(entity)).thenThrow(new RuntimeException("Mapping error"));

        ServiceException exception = assertThrows(ServiceException.class, () -> service.getAll(pageable));
        assertTrue(exception.getMessage().contains("Error fetching all entities"));
    }

    @Test
    @DisplayName("Should search EnteDeclaradoUtilidadePublicaEstadual by name and return DTOs list when found")
    void search_shouldReturnListOfDTOsWhenFound() {
        Page<EnteDeclaradoUtilidadePublicaEstadual> page = new PageImpl<>(List.of(entity));
        when(repository.findByNameContainingIgnoreCase("UNIÃO DAS ASSOCIAÇÕES DOS AGRICULTORES", pageable)).thenReturn(page);
        when(mapper.toDto(entity)).thenReturn(dto);

        List<EnteDeclaradoUtilidadePublicaEstadualDTO> result = service.search("UNIÃO DAS ASSOCIAÇÕES DOS AGRICULTORES", pageable);

        assertEquals(1, result.size());
        assertEquals(dto, result.getFirst());
    }

    @Test
    @DisplayName("Should search EnteDeclaradoUtilidadePublicaEstadual by name and return not found exception")
    void search_shouldReturnThrowEntityNotFoundExceptionWhenNotFound() {
        Page<EnteDeclaradoUtilidadePublicaEstadual> emptyPage = new PageImpl<>(Collections.emptyList());
        when(repository.findByNameContainingIgnoreCase("UNIÃO DAS ASSOCIAÇÕES DOS AGRICULTORES", pageable)).thenReturn(emptyPage);
        assertThrows(EntityNotFoundException.class, () -> service.search("UNIÃO DAS ASSOCIAÇÕES DOS AGRICULTORES", pageable));
    }

    @Test
    @DisplayName("Should search EnteDeclaradoUtilidadePublicaEstadual by name and return exception error")
    void search_shouldThrowServiceException_whenMapperThrows() {
        Page<EnteDeclaradoUtilidadePublicaEstadual> page = new PageImpl<>(List.of(entity));
        when(repository.findByNameContainingIgnoreCase("UNIÃO DAS ASSOCIAÇÕES DOS AGRICULTORES", pageable)).thenReturn(page);
        when(mapper.toDto(entity)).thenThrow(new RuntimeException("Mapping error"));
        ServiceException exception = assertThrows(ServiceException.class, () -> service.search("UNIÃO DAS ASSOCIAÇÕES DOS AGRICULTORES", pageable));
        assertTrue(exception.getMessage().contains("Error searching entities with name"));
    }

    @Test
    @DisplayName("Should search EnteDeclaradoUtilidadePublicaEstadual by code and return dto")
    void getByCode_shouldReturnDTOWhenFound() {
        when(repository.findByCode(123)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);

        EnteDeclaradoUtilidadePublicaEstadualDTO result = service.getByCode(123);

        assertEquals(dto, result);
    }

    @Test
    @DisplayName("Should search EnteDeclaradoUtilidadePublicaEstadual by code and return not found exception")
    void getByCode_shouldThrownEntityNotFoundExceptionWhenNotFound() {
        when(repository.findByCode(999)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.getByCode(999));
    }

    @Test
    @DisplayName("Should search EnteDeclaradoUtilidadePublicaEstadual by code and return exception error")
    void getByCode_shouldThrowServiceException_whenMapperThrows() {
        when(repository.findByCode(999)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenThrow(new RuntimeException("Mapping error"));

        ServiceException exception = assertThrows(ServiceException.class, () -> service.getByCode(999));
        assertTrue(exception.getMessage().contains("Error fetching entity with code"));
    }

    @Test
    @DisplayName("Should search EnteDeclaradoUtilidadePublicaEstadual by id and return dto")
    void getById_shouldReturnDTOWhenFound() {
        UUID id = UUID.fromString("c56a4180-65aa-42ec-a945-5fd21dec0538");

        when(repository.findById(id)).thenReturn(Optional.of(entity));
        when(mapper.toDto(entity)).thenReturn(dto);

        EnteDeclaradoUtilidadePublicaEstadualDTO result = service.getById(id);

        assertEquals(dto, result);
    }

    @Test
    @DisplayName("Should search EnteDeclaradoUtilidadePublicaEstadual by id and return not found exception")
    void getById_shouldThrowEntityNotFoundExceptionWhenNotFound() {
        UUID id = UUID.fromString("c56a4180-65aa-42ec-a945-5fd21dec0538");

        when(repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(EntityNotFoundException.class, () -> service.getById(id));
    }

    @Test
    @DisplayName("Should search EnteDeclaradoUtilidadePublicaEstadual by id and return exception error")
    void getById_shouldThrowServiceException_whenMapperThrows() {
        UUID id = UUID.fromString("c56a4180-65aa-42ec-a945-5fd21dec0538");

        when(repository.findById(id)).thenReturn(Optional.of(entity)); // CORRIGIDO
        when(mapper.toDto(entity)).thenThrow(new RuntimeException("Mapping error"));

        ServiceException exception = assertThrows(ServiceException.class, () -> service.getById(id));
        assertTrue(exception.getMessage().contains("Error fetching entity with id"));
    }
}
