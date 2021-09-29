package com.code.task15.repository;

import com.code.task15.model.AgentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class AgentRepositoryImpl implements AgentRepository {


    private static final String AGENT_GET_QUERY = "SELECT " +
            "id as id, " +
            "agent_id as agentId, " +
            "user_id as userId, " +
            "active as active, " +
            "create_date as createDate, " +
            "modified_date as modifiedDate " +
            "FROM agent";

    private final DataSource dataSource;

    @Autowired
    public AgentRepositoryImpl(@Qualifier("Datasource") DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<AgentEntity> getAgentsData(BeanPropertyRowMapper<AgentEntity> mapper) {
        return new JdbcTemplate(dataSource).query(AGENT_GET_QUERY, mapper);
    }
}
