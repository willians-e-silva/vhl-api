package com.vhl_test.willians.external.tjsc;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TjscClient {
    public List<Map<String, Object>> getEntesDeclaradosUtilidadePublicaEstadual(){
        List<Map<String, Object>> response = new ArrayList<>();

        Map<String, Object> obj1 = new HashMap<>();
        obj1.put("cdcomarca", 1);
        obj1.put("cdentepub", 1565);
        obj1.put("dtLei", "17/09/1975");
        obj1.put("dtLeiExtenso", "LEI Nº 5.133, de 17 de setembro de 1975");
        obj1.put("lei", "5.133");
        obj1.put("nomeComarca", "Abelardo Luz");
        obj1.put("nomeComarcaEntidade", "Abelardo Luz - ASSOCIAÇÃO ATLÉTICA BEIRA RIO ( Lei n. 5.133 de 17/09/1975 )");
        obj1.put("nomeEntidade", "ASSOCIAÇÃO ATLÉTICA BEIRA RIO");
        response.add(obj1);

        Map<String, Object> obj2 = new HashMap<>();
        obj2.put("cdcomarca", 1);
        obj2.put("cdentepub", 2699);
        obj2.put("dtLei", "30/07/2004");
        obj2.put("dtLeiExtenso", "LEI Nº 13.090, de 30 de julho de 2004");
        obj2.put("lei", "13.090");
        obj2.put("nomeComarca", "Abelardo Luz");
        obj2.put("nomeComarcaEntidade", "Abelardo Luz - ASSOCIAÇÃO DE PAIS E AMIGOS DOS EXCEPCIONAIS (APAE) ( Lei n. 13.090 de 30/07/2004 )");
        obj2.put("nomeEntidade", "ASSOCIAÇÃO DE PAIS E AMIGOS DOS EXCEPCIONAIS (APAE)");
        response.add(obj2);

        Map<String, Object> obj3 = new HashMap<>();
        obj3.put("cdcomarca", 1);
        obj3.put("cdentepub", 123);
        obj3.put("dtLei", "08/07/1984");
        obj3.put("dtLeiExtenso", "LEI Nº 6.374, de 08 de julho de 1984");
        obj3.put("lei", "6.374");
        obj3.put("nomeComarca", "Abelardo Luz");
        obj3.put("nomeComarcaEntidade", "Abelardo Luz - ASSOCIAÇÃO DE PAIS E AMIGOS DOS EXCEPCIONAIS (APAE) ( Lei n. 6.374 de 08/07/1984 )");
        obj3.put("nomeEntidade", "ASSOCIAÇÃO DE PAIS E AMIGOS DOS EXCEPCIONAIS (APAE)");
        response.add(obj3);

        return response;
    }
}
