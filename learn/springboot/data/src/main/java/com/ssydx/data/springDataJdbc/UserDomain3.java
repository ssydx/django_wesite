package com.ssydx.data.springDataJdbc;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Table("USER_INFO")
public class UserDomain3 {
    @Id
    private Integer id;
    @NonNull
    @Column("NAME")
    private String userName;
    @NonNull
    private String desc;
    @NonNull
    private Double score;
}
