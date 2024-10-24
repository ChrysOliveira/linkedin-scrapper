package com.example.linkedin_scrapper.repositories;

import com.example.linkedin_scrapper.domains.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
