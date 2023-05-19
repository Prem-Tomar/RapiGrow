package com.rapigrow.main.users.repositry;

import com.rapigrow.main.users.entities.SampleUser;
import org.springframework.data.repository.CrudRepository;

public interface SampleUserRepo extends CrudRepository<SampleUser,Long> {
}
