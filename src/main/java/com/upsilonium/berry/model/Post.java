package com.upsilonium.berry.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

/**
 * @author Yannick Van Ham
 * created on Saturday, 26/09/2020
 */
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column
    private String title;

    @Lob
    @Column
    @NotEmpty
    private String content;

    @Column
    private Instant creationTimestamp;

    @Column
    private Instant updateTimestamp;

    @Column
    @NotBlank
    private String username;
}