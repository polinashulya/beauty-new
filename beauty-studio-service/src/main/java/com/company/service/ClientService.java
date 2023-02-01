package com.company.service;

import com.company.service.dto.user.UserSignUpDto;
import com.company.service.dto.user.ClientDto;

import java.util.List;

public interface ClientService {

    ClientDto signUpClient(UserSignUpDto userSignUpDto);

    ClientDto findById(Long clientId);

    List<ClientDto> findAll();

    void delete(Long clientId);

}
