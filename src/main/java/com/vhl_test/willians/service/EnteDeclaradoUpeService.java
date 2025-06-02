package com.vhl_test.willians.service;

import com.vhl_test.willians.external.tjsc.GetEntesDeclaradosUtilidadePublicaEstadual;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class EnteDeclaradoUpeService {
    private final GetEntesDeclaradosUtilidadePublicaEstadual getEntesDeclaradosUtilidadePublicaEstadual;

    public EnteDeclaradoUpeService(GetEntesDeclaradosUtilidadePublicaEstadual getEntesDeclaradosUtilidadePublicaEstadual) {
        this.getEntesDeclaradosUtilidadePublicaEstadual = getEntesDeclaradosUtilidadePublicaEstadual;
    }

    private List<Map<String, Object>> loadEnteDeclaradoUpeData() {
        List<Map<String, Object>> entesDeclaradosData = getEntesDeclaradosUtilidadePublicaEstadual.loadData();
        return entesDeclaradosData;
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

                    if (itemCodeObj == null) return false;

                    try {
                        if (itemCodeObj instanceof String) {
                            int itemCode = Integer.parseInt(((String) itemCodeObj).trim());
                            return itemCode == code;
                        } else if (itemCodeObj instanceof Number) {
                            return ((Number) itemCodeObj).intValue() == code;
                        } else {
                            System.out.println("Tipo não esperado: " + itemCodeObj.getClass());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    return false;
                })
                .collect(Collectors.toList());
    }

}