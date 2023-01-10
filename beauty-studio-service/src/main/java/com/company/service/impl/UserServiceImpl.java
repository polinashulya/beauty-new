package com.company.service.impl;

import com.company.entity.UserEntity;
import com.company.entity.UserRoleEntity;
import com.company.repository.UserRepository;
import com.company.repository.UserRoleRepository;
import com.company.service.UserService;
import com.company.service.dto.UserDto;
import com.company.service.dto.UserSignUpDto;
import com.company.service.exception.ResourceNotFoundException;
import com.company.service.exception.ServiceException;
import com.company.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        UserEntity userEntity = userMapper.convertToEntity(userDto);
        UserEntity saved = userRepository.save(userEntity);
        return userMapper.convertToDto(saved);
    }

    @Override
    @Transactional
    public UserDto registrationUser(UserSignUpDto userSignUpDto) {

        if (!userSignUpDto.getPassword().equals(userSignUpDto.getConfirmedPassword())) {
            throw new ServiceException("Passwords are not equal.");
        }

        userRepository.findByEmail(userSignUpDto.getEmail()).ifPresent(user -> {
            throw new ServiceException("User with email = " + user.getEmail() + " already exist!");
        });

        UserRoleEntity userRole = userRoleRepository.findByName(userSignUpDto.getRoleName()).orElseThrow(() -> new ServiceException("Provided Role does not exist"));

        UserEntity userEntity = userMapper.toEntityFromSingUp(userSignUpDto, userRole);

        UserEntity savedUser = userRepository.save(userEntity);

        return userMapper.convertToDto(savedUser);
    }

    @Override
    public UserDto findById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id = " + userId + " not found!"));
        return userMapper.convertToDto(userEntity);
    }
}
