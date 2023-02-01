package com.company.service.mapper.user;

import com.company.entity.user.ClientEntity;
import com.company.service.dto.user.UserSignUpDto;
import com.company.service.dto.user.ClientDto;
import com.company.service.mapper.core.AbstractMapper;
import com.company.service.mapper.user.config.ClientMapperConfig;
import org.mapstruct.Mapper;

@Mapper(config = ClientMapperConfig.class)
public interface ClientMapper extends AbstractMapper<ClientDto, ClientEntity> {

    ClientEntity toEntityFromSignUp(UserSignUpDto userSignUpDto);

}
