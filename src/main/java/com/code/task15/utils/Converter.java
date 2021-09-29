package com.code.task15.utils;

import org.springframework.beans.BeanUtils;

public interface Converter {

    default <T> T toDto(Class<T> type) {
        T dto = BeanUtils.instantiateClass(type);
        BeanUtils.copyProperties(this, dto);
        return dto;
    }

    default <T> T toEntity(Class<T> type) {
        T entity = BeanUtils.instantiateClass(type);
        BeanUtils.copyProperties(this, entity);
        return entity;
    }
}
