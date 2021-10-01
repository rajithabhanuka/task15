package com.code.task15.repository;

import com.code.task15.model.AgentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class AgentRepositoryImpl implements AgentRepository {

    private String queryAgentAll;

    private final DataSource dataSource;

    @Autowired
    public AgentRepositoryImpl(@Qualifier("Datasource") DataSource dataSource,
                               @Value("${query.agent.all}") String queryAgentAll) {
        this.dataSource = dataSource;
        this.queryAgentAll = queryAgentAll;
    }

    @Override
    public List<AgentEntity> getAgentsData(BeanPropertyRowMapper<AgentEntity> mapper) {
        return new JdbcTemplate(dataSource).query(queryAgentAll, mapper);
    }
}
