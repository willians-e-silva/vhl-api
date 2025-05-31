package com.vhl_test.willians.mapper;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class EnteDeclaradoUpeMapper {
    public List<Map<String, Object>> filter(List<Map<String, Object>> data) {
        return data.stream().map(item -> {
            Map<String, Object> filtered = new HashMap<>();
            filtered.put("lei", item.get("lei"));
            filtered.put("codigoComarca", item.get("cdcomarca"));
            filtered.put("codigoEntePub", item.get("cdentepub"));
            filtered.put("nomeComarcaEntidade", item.get("nomeComarcaEntidade"));
            return filtered;
        }).collect(Collectors.toList());
    }
}
