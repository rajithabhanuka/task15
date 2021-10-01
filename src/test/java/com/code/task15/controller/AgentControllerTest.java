package com.code.task15.controller;

import com.code.task15.dto.AgentDto;
import com.code.task15.service.AgentService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

@WebMvcTest(AgentController.class)
public class AgentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AgentService service;

    @Test
    public void getTest() throws Exception {

        List<AgentDto> agentDtos = new ArrayList<>();

        AgentDto agentDto = new AgentDto();
        agentDto.setAgentId(10);
        agentDto.setActive("Success");

        agentDtos.add(agentDto);

        Mockito.when(service.getAgentData()).thenReturn(ResponseEntity.ok(agentDtos));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/agents"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("Success")));

    }

    @Test
    public void getAgentByPathTest() throws Exception {

        AgentDto agentDto = new AgentDto();
        agentDto.setAgentId(10);
        agentDto.setActive("Pending");

        Mockito.when(service.getAgentDataById(Mockito.anyInt())).
                thenReturn(ResponseEntity.ok(agentDto));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/agents/find?id=1"))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content()
                        .string(Matchers.containsString("Pending")));

    }
}
