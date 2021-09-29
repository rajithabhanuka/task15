package com.code.task15.model;

import com.code.task15.utils.Converter;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AgentEntity implements Converter {

    private int id;

    private int agentId;

    private int userId;

    private String active;

    LocalDateTime createDate;

    LocalDateTime modifiedDate;

}
