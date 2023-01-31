package com.company.service.mapper.user.config;

import com.company.entity.user.ClientEntity;
import com.company.service.dto.user.ClientDto;
import com.company.service.mapper.core.AbstractMapper;
import org.mapstruct.MapperConfig;

@MapperConfig(uses = UserMapperConfig.class)
public interface ClientMapperConfig extends AbstractMapper<ClientDto, ClientEntity> {

}