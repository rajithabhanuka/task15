package com.code.task15.controller;

import com.code.task15.dto.AgentDto;
import com.code.task15.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping(value = "agents")
public class AgentController {

    private final AgentService agentService;

    @Autowired
    public AgentController(AgentService agentService) {
        this.agentService = agentService;
    }

    @GetMapping
    public ResponseEntity<List<AgentDto>> get() {
        return agentService.getAgentData();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<AgentDto> getAgentByPath(@PathVariable(value = "id") int id) {

        String uri = "http://localhost:8080/agents/find?id=" + id;
        RestTemplate restTemplate = new RestTemplate();
        AgentDto result = restTemplate.getForObject(uri, AgentDto.class);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/find")
    public ResponseEntity<AgentDto> getAgentByQuery(@RequestParam(value = "id") int id) {
        return agentService.getAgentDataById(id);
    }

}
