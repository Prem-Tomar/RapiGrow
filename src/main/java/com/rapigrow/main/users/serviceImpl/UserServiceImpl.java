package com.rapigrow.main.users.serviceImpl;

import com.rapigrow.main.common.exceptions.ResourceNotFoundException;
import com.rapigrow.main.users.dto.UserDto;
import com.rapigrow.main.users.entities.User;
import com.rapigrow.main.users.exceptions.ResourceNotFoundExceptions;
import com.rapigrow.main.users.models.Location;
import com.rapigrow.main.users.repositry.UserRepo;
import com.rapigrow.main.users.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public UserDto createUser(UserDto userDto) {
        User user = this.modelMapper.map(userDto,User.class);
        User savedUser=this.userRepo.save(user);
        return this.modelMapper.map(savedUser,UserDto.class);
    }

    @Override
    public UserDto getUserById(Long Uid) {
        User user=this.userRepo.findById(Uid).orElseThrow(()-> new ResourceNotFoundExceptions("User","User id", Uid));
        return this.modelMapper.map(user,UserDto.class);
    }

    @Override
    public void DeleteUserById(Long uid) {
       User user = this.userRepo.findById(uid).orElseThrow(()-> new ResourceNotFoundExceptions("User","User id", uid));
       this.userRepo.delete(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> user = (List<User>) this.userRepo.findAll();
        List<UserDto> userDtos=user.stream().map(users-> this.modelMapper.map(users,UserDto.class)).collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public UserDto updateUser(UserDto userDto, Long Id) {
        return null;
    }

    @Override
    public Location getUserLocationById(Long Uid) {
        return null;
    }

    @Override
    public List<UserDto> searchUser(String keyword) {
        return null;
    }


}
