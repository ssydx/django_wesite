package com.springboot.myblog.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Setter
@Getter
@Entity
public class People {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
}
