package com.vhl_test.willians.mapper;

import com.vhl_test.willians.model.EnteDeclaradoUtilidadePublicaEstadual;
import com.vhl_test.willians.dto.EnteDeclaradoUtilidadePublicaEstadualDTO;
import org.springframework.stereotype.Component;

@Component
public class EnteDeclaradoUtilidadePublicaEstadualMapper {

    public EnteDeclaradoUtilidadePublicaEstadualDTO toDto(EnteDeclaradoUtilidadePublicaEstadual entity) {
        if (entity == null) {
            return null;
        }
        EnteDeclaradoUtilidadePublicaEstadualDTO dto = new EnteDeclaradoUtilidadePublicaEstadualDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setCode(entity.getCode());
        dto.setLaw(entity.getLaw());
        return dto;
    }
}
