package com.springboot.myblog.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
public class SubmitArticleQuery {
    private String title;
    private String headline;
    private String content;
    private String author;
}
