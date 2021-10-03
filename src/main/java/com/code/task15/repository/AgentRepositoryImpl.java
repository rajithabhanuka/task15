package com.code.task15.repository;

import com.code.task15.model.AgentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class AgentRepositoryImpl implements AgentRepository {

    private String queryAgentAll;

    private String queryById;

    private final DataSource dataSource;

    @Autowired
    public AgentRepositoryImpl(@Qualifier("Datasource") DataSource dataSource,
                               @Value("${query.agent.all}") String queryAgentAll,
                               @Value("${query.agent.by.id}") String queryById) {
        this.dataSource = dataSource;
        this.queryAgentAll = queryAgentAll;
        this.queryById = queryById;
    }


    @Override
    public List<AgentEntity> getAgentsData(BeanPropertyRowMapper<AgentEntity> mapper) {
        return new JdbcTemplate(dataSource).query(queryAgentAll, mapper);
    }

    @Override
    public AgentEntity getById(int id, BeanPropertyRowMapper<AgentEntity> mapper) {
        return new JdbcTemplate(dataSource).queryForObject(queryById, mapper, id);
    }
}
