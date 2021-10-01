package com.code.task15.service;

import com.code.task15.model.AgentEntity;
import com.code.task15.repository.AgentRepository;
import com.code.task15.repository.AgentRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@SpringBootTest
public class AgentServiceTest {

    private static final String AGENT_GET_QUERY = "SELECT " +
            "id as id, " +
            "agent_id as agentId, " +
            "user_id as userId, " +
            "active as active, " +
            "create_date as createDate, " +
            "modified_date as modifiedDate " +
            "FROM agent";

    @Test
    public void TestGetMethod() {

        DataSource dataSource = new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:jdbc/schema.sql")
                .addScript("classpath:jdbc/data.sql")
                .build();

        AgentRepositoryImpl agentRepository = new AgentRepositoryImpl(dataSource, AGENT_GET_QUERY);

        Assertions.assertEquals(3, agentRepository.getAgentsData(new BeanPropertyRowMapper<>(AgentEntity.class)).size());
    }
}
