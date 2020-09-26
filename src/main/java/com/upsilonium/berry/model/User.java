package com.upsilonium.berry.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author Yannick Van Ham
 * created on Saturday, 26/09/2020
 */
@Getter
@Setter
@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;
}
