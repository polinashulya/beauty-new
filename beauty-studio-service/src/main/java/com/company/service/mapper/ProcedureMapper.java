package com.company.service.mapper;

import com.company.entity.ProcedureEntity;
import com.company.service.dto.ProcedureDto;
import com.company.service.mapper.core.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(uses = {CategoryMapper.class})
public interface ProcedureMapper extends AbstractMapper<ProcedureDto, ProcedureEntity> {

}
