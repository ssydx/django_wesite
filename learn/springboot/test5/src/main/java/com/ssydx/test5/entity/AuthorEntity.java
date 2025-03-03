package com.ssydx.test5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@Entity
public class AuthorEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Byte age;
}
