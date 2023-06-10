package com.rapigrow.main.users.repositry;

import com.rapigrow.main.users.entities.Job;
import org.springframework.data.repository.CrudRepository;

public interface JobRepo extends CrudRepository<Job,Long> {
}
