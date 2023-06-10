package com.rapigrow.main.users.service;

import com.rapigrow.main.users.dto.UserDto;
import com.rapigrow.main.users.entities.User;
import com.rapigrow.main.users.models.Location;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
         UserDto createUser(UserDto userDto);
         UserDto getUserById(Long Uid);
         void DeleteUserById(Long uid);
         List<UserDto> getAllUsers();
         UserDto updateUser(UserDto userDto,Long Id);

         Location getUserLocationById(Long Uid);
          List<UserDto> searchUser(String keyword);

}
