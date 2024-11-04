package com.example.linkedin_scrapper.repositories;

import com.example.linkedin_scrapper.domains.entities.EducationEntity;
import com.example.linkedin_scrapper.domains.entities.ExperienceEntity;
import org.springframework.data.repository.CrudRepository;

public interface EducationRepository extends CrudRepository<EducationEntity, Long> {
}
