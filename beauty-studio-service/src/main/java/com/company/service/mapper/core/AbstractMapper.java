package com.company.service.mapper.core;

import com.company.entity.core.AbstractBaseBean;
import com.company.service.dto.core.AbstractBaseDto;

import java.util.List;


public interface AbstractMapper<D extends AbstractBaseDto, E extends AbstractBaseBean> {

    D toDto(E entity);

    E toEntity(D dto);

    List<D> toDtoList(List<E> entities);

}
