package com.company.service.impl;

import com.company.entity.UserEntity;
import com.company.repository.UserRepository;
import com.company.repository.UserRoleRepository;
import com.company.service.UserService;
import com.company.service.dto.UserDto;
import com.company.service.dto.UserSignUpDto;
import com.company.service.exception.HttpStatusCode;
import com.company.service.exception.ResourceNotFoundException;
import com.company.service.exception.ServiceException;
import com.company.service.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public UserDto saveUser(UserDto userDto) {
        UserEntity userEntity = userMapper.toEntity(userDto);
        UserEntity saved = userRepository.save(userEntity);
        return userMapper.toDto(saved);
    }

    @Override
    @Transactional
    public UserDto signUpUser(UserSignUpDto userSignUpDto) {

        if (!userSignUpDto.getPassword().equals(userSignUpDto.getConfirmedPassword())) {
            throw new ServiceException(HttpStatusCode.BAD_REQUEST, "Passwords are not equal.");
        }

        if (!userRoleRepository.existsById(userSignUpDto.getRole().getId())) {
            throw new ServiceException(HttpStatusCode.NOT_FOUND, "Role does not exist! id = " + userSignUpDto.getRole().getId());
        }

        if (userRepository.existsByEmail(userSignUpDto.getEmail())) {
            throw new ServiceException(HttpStatusCode.CONFLICT, "User with email = " + userSignUpDto.getEmail() + " already exist!");
        }

        UserEntity userEntity = userMapper.toEntityFromSignUp(userSignUpDto);
        userEntity.setRole(
                userRoleRepository.getOne(userEntity.getRole().getId())
        );

        UserEntity savedUser = userRepository.save(userEntity);

        return userMapper.toDto(savedUser);
    }

    @Override
    public UserDto findById(Long userId) {
        UserEntity userEntity = getUserEntity(userId);

        return userMapper.toDto(userEntity);
    }

    private UserEntity getUserEntity(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException(HttpStatusCode.NOT_FOUND, "User with id = " + userId + " not found!"));
    }

    @Override
    public List<UserDto> findAll() {
        List<UserEntity> users = userRepository.findAll();

        return userMapper.toDtoList(users);
    }

    @Override
    public void delete(Long userId) {
        UserEntity userEntity = getUserEntity(userId);

        if (userEntity.getRole().getName().equals("ADMIN")) {
            throw new ResourceNotFoundException(HttpStatusCode.BAD_REQUEST, "User with id = " + userId + " is ADMIN!");
        }

        userRepository.delete(userEntity);

    }
}
