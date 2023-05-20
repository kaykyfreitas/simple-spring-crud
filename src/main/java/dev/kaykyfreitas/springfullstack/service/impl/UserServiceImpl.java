package dev.kaykyfreitas.springfullstack.service.impl;

import dev.kaykyfreitas.springfullstack.dto.UserDto;
import dev.kaykyfreitas.springfullstack.exception.NotFoundException;
import dev.kaykyfreitas.springfullstack.model.UserModel;
import dev.kaykyfreitas.springfullstack.repository.UserRepository;
import dev.kaykyfreitas.springfullstack.service.FileService;
import dev.kaykyfreitas.springfullstack.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final FileService fileService;

    @Override
    public void create(UserDto userDto) {
        fileService.create(userDto.photo());
        userRepository.save(new UserModel(userDto.name(), userDto.email(), userDto.phone(), userDto.birth()));
    }

    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public void update(UserDto user) {
        final var foundedUser = userRepository.findById(user.id())
                        .orElseThrow(() -> new NotFoundException("File not found."));
        foundedUser.setName(user.name());
        foundedUser.setEmail(user.email());
        foundedUser.setPhone(user.phone());
        foundedUser.setBirth(user.birth());
        userRepository.save(foundedUser);
    }

    @Override
    public UserModel findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundException("File not found."));
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
