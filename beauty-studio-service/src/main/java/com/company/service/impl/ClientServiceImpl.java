package com.company.service.impl;

import com.company.entity.user.ClientEntity;
import com.company.entity.user.UserRoles;
import com.company.repository.ClientRepository;
import com.company.repository.UserRoleRepository;
import com.company.service.ClientService;
import com.company.service.dto.user.UserSignUpDto;
import com.company.service.dto.user.ClientDto;
import com.company.service.exception.HttpStatusCode;
import com.company.service.exception.ResourceNotFoundException;
import com.company.service.exception.ServiceException;
import com.company.service.mapper.user.ClientMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {

    private final ClientMapper clientMapper;
    private final ClientRepository clientRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    @Transactional
    public ClientDto signUpClient(UserSignUpDto userSignUpDto) {

        if (!userSignUpDto.getPassword().equals(userSignUpDto.getConfirmedPassword())) {
            throw new ServiceException(HttpStatusCode.BAD_REQUEST, "Passwords are not equal.");
        }

        if (clientRepository.existsByEmail(userSignUpDto.getEmail())) {
            throw new ServiceException(HttpStatusCode.CONFLICT, "User with email = " + userSignUpDto.getEmail() + " already exist!");
        }

        ClientEntity clientEntity = clientMapper.toEntityFromSignUp(userSignUpDto);
        clientEntity.setRole(
                userRoleRepository.getByName(UserRoles.CLIENT_ROLE.name())
        );

        ClientEntity savedClient = clientRepository.save(clientEntity);

        return clientMapper.toDto(savedClient);

    }

    @Override
    public ClientDto findById(Long clientId) {
        ClientEntity clientEntity = getClientEntity(clientId);

        return clientMapper.toDto(clientEntity);
    }

    @Override
    public List<ClientDto> findAll() {
        List<ClientEntity> clients = clientRepository.findAll();

        return clientMapper.toDtoList(clients);
    }

    @Override
    public void delete(Long clientId) {
        ClientEntity clientEntity = getClientEntity(clientId);

        clientRepository.delete(clientEntity);
    }

    private ClientEntity getClientEntity(Long clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpStatusCode.NOT_FOUND, "Client with id = " + clientId + " not found!"));
    }

}