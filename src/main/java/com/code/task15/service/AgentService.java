package com.code.task15.service;

import com.code.task15.dto.AgentDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AgentService {

    ResponseEntity<List<AgentDto>> getAgentData();
}
