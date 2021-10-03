package com.code.task15.service;

import com.code.task15.dto.AgentDto;
import com.code.task15.exception.ResourceNotFoundException;
import com.code.task15.model.AgentEntity;
import com.code.task15.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AgentServiceImpl implements AgentService {

    private final AgentRepository agentRepository;

    @Autowired
    public AgentServiceImpl(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    @Override
    public ResponseEntity<List<AgentDto>> getAgentData() {

        List<AgentEntity> agentEntities = agentRepository.getAgentsData(
                new BeanPropertyRowMapper<>(AgentEntity.class));

        List<AgentDto> agentDtos = agentEntities.stream().map(s -> s.toDto())
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(agentDtos);
    }

    @Override
    public ResponseEntity<AgentDto> getAgentDataById(int id) {

        AgentEntity entity = agentRepository.getById(id, new BeanPropertyRowMapper<>(AgentEntity.class));

        if (entity == null) {
            new ResourceNotFoundException("Agent not found!", "agent id", "" + id);
        }

        return ResponseEntity.status(HttpStatus.OK).body(entity.toDto());
    }
}
