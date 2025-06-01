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
            filtered.put("law", item.get("lei"));
            filtered.put("codeComarca", item.get("cdcomarca"));
            filtered.put("codeEntePub", item.get("cdentepub"));
            filtered.put("name", item.get("nomeComarcaEntidade"));
            return filtered;
        }).collect(Collectors.toList());
    }
}
