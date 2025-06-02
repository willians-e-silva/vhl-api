package com.vhl_test.willians.external.tjsc;

import org.springframework.stereotype.Service;
import br.jus.tjsc.selo.SeloService_Service;
import br.jus.tjsc.selo.SeloService;
import br.jus.tjsc.selo.Exception_Exception;
import br.jus.tjsc.selo.EnteDeclaradoUtilidadePublicaEstadual;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GetEntesDeclaradosUtilidadePublicaEstadual {

    public List<Map<String, Object>> loadData() {
        SeloService_Service service = new SeloService_Service();
        SeloService port = service.getSeloServicePort();

        try {
            List<EnteDeclaradoUtilidadePublicaEstadual> entes = port.getEntesDeclaradosUtilidadePublicaEstadual();

            List<Map<String, Object>> result = new ArrayList<>();
            for (EnteDeclaradoUtilidadePublicaEstadual ente : entes) {
                Map<String, Object> map = new HashMap<>();
                map.put("code", ente.getCdentepub());
                map.put("name", ente.getNomeEntidade());
                map.put("Law", ente.getLei());
                result.add(map);
            }

            return result;

        } catch (Exception_Exception e) {
            throw new RuntimeException("Error in ", e);
        }
    }
}
