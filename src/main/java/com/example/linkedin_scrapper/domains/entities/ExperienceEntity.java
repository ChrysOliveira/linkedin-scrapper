package com.example.linkedin_scrapper.domains.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "experiences")
public class ExperienceEntity {
    @Id
    private Long id;
    private String company;
    private String workload;
    private String period;
    private String location;
    private String description;
    @ManyToOne
    private UserEntity user;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}