package com.community.community.Dao;

import com.community.community.Dtos.LoginDto;
import com.community.community.Dtos.UserDto;
import com.community.community.Models.Users;

public interface UsersDao {
    Users createUser(UserDto userDto);
    Users loginUser(LoginDto loginDto);



}
