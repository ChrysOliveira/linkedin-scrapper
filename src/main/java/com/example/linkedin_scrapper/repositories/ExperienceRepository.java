package com.example.linkedin_scrapper.repositories;

import com.example.linkedin_scrapper.domains.entities.ExperienceEntity;
import com.example.linkedin_scrapper.domains.entities.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface ExperienceRepository extends CrudRepository<ExperienceEntity, Long> {
}
