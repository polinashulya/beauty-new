package com.company.controller.impl;

import com.company.controller.ClientController;
import com.company.service.ClientService;
import com.company.service.dto.user.ClientDto;
import com.company.service.dto.user.UserSignUpDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    @Override
    public ResponseEntity<ClientDto> register(@RequestBody @Valid UserSignUpDto userSignUpDto) {
        ClientDto saved = clientService.signUpClient(userSignUpDto);
        return ResponseEntity.created(
                        URI.create("/api/v1/users/clients/" + saved.getId())
                )
                .body(saved);
    }

    @Override
    public ResponseEntity<ClientDto> findById(@PathVariable("id") Long clientId) {
        ClientDto userDto = clientService.findById(clientId);

        return ResponseEntity.ok(userDto);
    }

    @Override
    public ResponseEntity<List<ClientDto>> findAll() {
        List<ClientDto> users = clientService.findAll();

        return ResponseEntity.ok(users);
    }

    @Override
    public ResponseEntity<Void> delete(@PathVariable("id") Long clientId) {
        clientService.delete(clientId);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}