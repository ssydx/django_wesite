package com.ssydx.elasticsearch.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "user_info",createIndex = true)
public class User {
    @Id
    private Integer id;
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String name;
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private String desc;
    @Field(analyzer = "ik_max_word", searchAnalyzer = "ik_smart")
    private Double score;
}
