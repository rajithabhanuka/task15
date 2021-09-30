package com.code.task15.dto;

import com.code.task15.model.AgentEntity;
import com.code.task15.utils.Converter;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

@Data
public class AgentDto {

    private int id;

    private int agentId;

    private int userId;

    private String active;

    LocalDateTime createDate;

    LocalDateTime modifiedDate;

    public AgentEntity toDto() {
        AgentEntity dto = new AgentEntity();
        BeanUtils.copyProperties(this, dto);
        return dto;
    }

}
