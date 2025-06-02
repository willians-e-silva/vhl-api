package com.vhl_test.willians.seeders;

import com.vhl_test.willians.external.tjsc.GetEntesDeclaradosUtilidadePublicaEstadual;
import com.vhl_test.willians.model.EnteDeclaradoUtilidadePublicaEstadual;
import com.vhl_test.willians.repository.EnteDeclaradoUtilidadePublicaEstadualRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ApiDataSeeder implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(ApiDataSeeder.class);

    private final GetEntesDeclaradosUtilidadePublicaEstadual externalService;
    private final EnteDeclaradoUtilidadePublicaEstadualRepository repository;

    public ApiDataSeeder(GetEntesDeclaradosUtilidadePublicaEstadual externalService,
                         EnteDeclaradoUtilidadePublicaEstadualRepository repository) {
        this.externalService = externalService;
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (repository.count() > 0) {
            logger.info("Database is not empty");
            logger.info("Seeders will not run");
            return;
        }

        logger.info("Database is empty.");
        logger.info("Running seeders...");

        try {
            List<Map<String, Object>> dadosExternos = externalService.loadData();

            List<EnteDeclaradoUtilidadePublicaEstadual> entidades = dadosExternos.stream()
                    .map(map -> new EnteDeclaradoUtilidadePublicaEstadual(
                            (String) map.get("name"),
                            (Long) map.get("code"),
                            (String) map.get("Law")
                    ))
                    .collect(Collectors.toList());

            repository.saveAll(entidades);
            logger.info("Database populated successfully");
        } catch (Exception e) {
            logger.error("Error while seeding data from external API", e);
        }
    }
}
