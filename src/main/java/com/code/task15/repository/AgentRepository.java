package com.code.task15.repository;

import com.code.task15.model.AgentEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import java.util.List;

public interface AgentRepository {

    List<AgentEntity> getAgentsData(final BeanPropertyRowMapper<AgentEntity> mapper);
}
