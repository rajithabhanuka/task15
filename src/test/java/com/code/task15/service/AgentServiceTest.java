package com.code.task15.service;

import com.code.task15.dto.AgentDto;
import com.code.task15.model.AgentEntity;
import com.code.task15.repository.AgentRepository;
import com.code.task15.repository.AgentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@SpringBootTest
public class AgentServiceTest {

    @Test
    public void TestGetMethod() {
        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:jdbc/schema.sql")
                .addScript("classpath:jdbc/data.sql")
                .build();

        AgentRepositoryImpl agentRepository = new AgentRepositoryImpl(dataSource);

        Assertions.assertEquals(2, agentRepository.getAgentsData(new BeanPropertyRowMapper<>(AgentEntity.class)).size());
    }
}
