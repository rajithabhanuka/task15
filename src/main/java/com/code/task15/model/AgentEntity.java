package com.code.task15.model;

import com.code.task15.dto.AgentDto;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class AgentEntity{

    private int id;

    private int agentId;

    private int userId;

    private String active;

    LocalDateTime createDate;

    LocalDateTime modifiedDate;

    public AgentDto toDto() {
        AgentDto dto = new AgentDto();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }

}
