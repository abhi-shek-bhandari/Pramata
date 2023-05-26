package com.community.community.DaoImpl;

import com.community.community.Dao.UsersDao;
import com.community.community.Dtos.LoginDto;
import com.community.community.Dtos.UserDto;
import com.community.community.Exceptions.UserException;
import com.community.community.Models.Users;
import com.community.community.Repo.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDaoImpl implements UsersDao {

    private UsersRepo usersRepo;

    @Autowired
    public void setUsersRepo(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }

    @Override
    public Users createUser(UserDto userDto) {
        return this.usersRepo.save(this.dtoToUsers(userDto));
    }

    @Override
    public Users loginUser(LoginDto loginDto) {
        Users user = this.usersRepo.findByEmail(loginDto.getEmail()).orElseThrow(()-> new UserException("Invalid Email Address"));
        if (!user.getPassword().equals(loginDto.getPassword())) throw new UserException("Invalid Email or Password");
        return user;
    }

    Users dtoToUsers(UserDto userDto){
        Users users = new Users();
        users.setName(userDto.getName());
        users.setEmail(userDto.getEmail());
        users.setPassword(userDto.getPassword());
        return users;
    }
}
