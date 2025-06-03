package com.vhl_test.willians;

import com.vhl_test.willians.model.EnteDeclaradoUtilidadePublicaEstadual;
import com.vhl_test.willians.repository.EnteDeclaradoUtilidadePublicaEstadualRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.data.domain.PageRequest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class EnteDeclaradoUtilidadePublicaEstadualRepositoryTest extends AbstractPostgresContainerTest {

    @Autowired
    private EnteDeclaradoUtilidadePublicaEstadualRepository repository;

    @Test
    @DisplayName("Should save and search by name ignoring case sensitivity")
    void findByNameContainingIgnoreCase() {
        EnteDeclaradoUtilidadePublicaEstadual entity = new EnteDeclaradoUtilidadePublicaEstadual();
        entity.setName("UNIÃO DAS ASSOCIAÇÕES DOS AGRICULTORES");
        entity.setCode(123L);
        repository.save(entity);

        var page = repository.findByNameContainingIgnoreCase("UNIÃO DAS ASSOCIAÇÕES DOS AGRICULTORES", PageRequest.of(0, 10));
        assertThat(page.getTotalElements()).isGreaterThan(0);
    }

    @Test
    @DisplayName("Should search by exact code")
    void findByCode() {
        EnteDeclaradoUtilidadePublicaEstadual entity = new EnteDeclaradoUtilidadePublicaEstadual();
        entity.setName("UNIÃO DAS ASSOCIAÇÕES DOS AGRICULTORES");
        entity.setCode(999L);
        repository.save(entity);

        Optional<EnteDeclaradoUtilidadePublicaEstadual> found = repository.findByCode(999);
        assertThat(found).isPresent();
        assertThat(found.get().getName()).isEqualTo("UNIÃO DAS ASSOCIAÇÕES DOS AGRICULTORES");
    }
}
