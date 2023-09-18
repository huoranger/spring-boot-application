package com.huoranger.entity;

import jakarta.persistence.*;
import lombok.Data;

@Table(name = "user")
@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String datasource;

}
