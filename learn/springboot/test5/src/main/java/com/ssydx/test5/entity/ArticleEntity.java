package com.ssydx.test5.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@Entity
@Table(name = "tb2")
public class ArticleEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private AuthorEntity author;
    private String content;
}
