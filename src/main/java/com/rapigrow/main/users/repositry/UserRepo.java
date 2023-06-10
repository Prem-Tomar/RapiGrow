package com.rapigrow.main.users.repositry;

import com.rapigrow.main.users.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User,Long> {
}
