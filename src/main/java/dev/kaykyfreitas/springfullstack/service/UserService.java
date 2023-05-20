package dev.kaykyfreitas.springfullstack.service;

import dev.kaykyfreitas.springfullstack.dto.UserDto;
import dev.kaykyfreitas.springfullstack.model.UserModel;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    void create(UserDto userDto);

    List<UserModel> findAll();

    void update(UserDto userDto);

    UserModel findById(Long id);

    void delete(Long id);

}
