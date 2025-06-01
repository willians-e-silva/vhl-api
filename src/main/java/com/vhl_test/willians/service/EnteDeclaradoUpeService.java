package com.vhl_test.willians.service;

import com.vhl_test.willians.external.tjsc.TjscClient;
import com.vhl_test.willians.mapper.EnteDeclaradoUpeMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EnteDeclaradoUpeService {
    private final TjscClient tjscClient;
    private final EnteDeclaradoUpeMapper enteDeclaradoUpeMapper;

    public EnteDeclaradoUpeService(TjscClient tjscClient, EnteDeclaradoUpeMapper enteDeclaradoUpeMapper) {
        this.tjscClient = tjscClient;
        this.enteDeclaradoUpeMapper = enteDeclaradoUpeMapper;
    }

    private List<Map<String, Object>> loadEnteDeclaradoUpeData() {
        List<Map<String, Object>> entesDeclaradosData = tjscClient.getEntesDeclaradosUtilidadePublicaEstadual();
        return enteDeclaradoUpeMapper.filter(entesDeclaradosData);
    }

    public List<Map<String, Object>> getAll() {
        return loadEnteDeclaradoUpeData();
    }

    public List<Map<String, Object>> search(String searchText) {
        List<Map<String, Object>> response = loadEnteDeclaradoUpeData();

        final String lowerCaseSearchText = searchText.toLowerCase();

        return response.stream()
                .filter(item -> {
                    String name = (String) item.get("name");
                    return name != null && name.toLowerCase().contains(lowerCaseSearchText);
                })
                .collect(Collectors.toList());
    }

    public List<Map<String, Object>> getByCode(int code) {
        List<Map<String, Object>> response = loadEnteDeclaradoUpeData();

        return response.stream()
                .filter(item -> {
                    Object itemCodeObj = item.get("codeEntePub");
                    int itemCode = (Integer) itemCodeObj;
                    return itemCode == code;
                })
                .collect(Collectors.toList());
    }
}