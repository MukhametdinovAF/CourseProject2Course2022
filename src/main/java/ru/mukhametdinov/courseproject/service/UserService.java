package ru.mukhametdinov.courseproject.service;

import ru.mukhametdinov.courseproject.dto.UserDto;
import ru.mukhametdinov.courseproject.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
