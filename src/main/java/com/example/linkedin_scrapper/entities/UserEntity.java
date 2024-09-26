package com.example.linkedin_scrapper.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private Long id;
    @Column(name = "nome")
    private String name;
    @Column(name = "link_profile")
    private String linkProfile;
    @Column(name = "linkedin_id")
    private String linkedinId;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
