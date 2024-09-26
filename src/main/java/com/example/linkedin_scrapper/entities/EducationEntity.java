package com.example.linkedin_scrapper.entities;

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
@Table(name = "educations")
public class EducationEntity {
    @Id
    private Long id;
    private String course;
    private String college;
    private String period;
    private String description;
    @ManyToOne
    private UserEntity user;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}