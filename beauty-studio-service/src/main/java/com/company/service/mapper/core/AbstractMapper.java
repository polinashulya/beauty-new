package com.company.service.mapper.core;

import com.company.entity.core.AbstractEntity;
import com.company.service.dto.AbstractDto;

import java.util.List;


public interface AbstractMapper<D extends AbstractDto, E extends AbstractEntity> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDtoList(List<E> entities);

}
