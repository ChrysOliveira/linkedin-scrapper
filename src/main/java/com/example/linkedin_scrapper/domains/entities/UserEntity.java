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
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
