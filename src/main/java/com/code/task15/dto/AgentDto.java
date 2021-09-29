package com.code.task15.dto;

import com.code.task15.utils.Converter;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgentDto implements Converter {

    private int id;

    private int agentId;

    private int userId;

    private String active;

    LocalDateTime createDate;

    LocalDateTime modifiedDate;

}
