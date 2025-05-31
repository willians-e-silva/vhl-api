package com.vhl_test.willians.service;
import com.vhl_test.willians.external.tjsc.TjscClient;
import com.vhl_test.willians.mapper.EnteDeclaradoUpeMapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EnteDeclaradoUpeService {
    private final TjscClient tjscClient;
    private final EnteDeclaradoUpeMapper enteDeclaradoUpeMapper;

    public EnteDeclaradoUpeService(TjscClient tjscClient, EnteDeclaradoUpeMapper enteDeclaradoUpeMapper) {
        this.tjscClient = tjscClient;
        this.enteDeclaradoUpeMapper = enteDeclaradoUpeMapper;
    }

    public List<Map<String, Object>> getEntesDeclarados() {
        List<Map<String, Object>> entesDeclaradosData;
        entesDeclaradosData = tjscClient.getEntesDeclaradosUtilidadePublicaEstadual();
        List<Map<String, Object>> response;
        response = enteDeclaradoUpeMapper.filter(entesDeclaradosData);
        return response;
    }
}

git init
git add README.md
git commit -m "Created api | added getEnteDeclarado route | added Tjsc as external service | added"
git branch -M main
git remote add origin git@github.com:willians-e-silva/vhl-api.git
git push -u origin main