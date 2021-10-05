package com.code.task15.service;


import com.code.task15.model.AgentEntity;
import com.code.task15.repository.AgentRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.util.ReflectionTestUtils;

import javax.sql.DataSource;

@RunWith(MockitoJUnitRunner.class)
public class AgentServiceMockitoTest {

    @Mock
    JdbcTemplate jdbcTemplate;

    DataSource dataSource;

    @Before
    public void testSetup() {
        dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:jdbc/schema.sql")
                .addScript("classpath:jdbc/data.sql")
                .build();
    }

    private static final String AGENT_BY_ID = "SELECT id as id, " +
            "agent_id as agentId, user_id as userId, active as active, " +
            "create_date as createDate, modified_date as modifiedDate FROM agent WHERE id = ?;";

    @Test
    public void testData() {

        AgentEntity entity = new AgentEntity();
        entity.setId(1);
        entity.setAgentId(2);
        entity.setActive("Created");

        AgentRepositoryImpl agentRepository = new AgentRepositoryImpl();
        agentRepository.setQueryById(AGENT_BY_ID);

        ReflectionTestUtils.setField(agentRepository, "jdbcTemplate", jdbcTemplate);
        Mockito.when(jdbcTemplate.queryForObject(Mockito.anyString(),
                        Mockito.any(BeanPropertyRowMapper.class) , Mockito.anyInt()))
                .thenReturn(entity);

        Assertions.assertEquals("Created", agentRepository.getById(1, new BeanPropertyRowMapper<>(AgentEntity.class)).getActive());

    }
}
