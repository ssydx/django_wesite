package com.ssydx.data.springDataJpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

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
@Table(name = "user_info")
@Entity(name = "User4")
@NamedQuery(name = "UserDomain4.namedQuery1", query = "select u from User4 u where u.id=:id")
public class UserDomain4 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NonNull
    @Column(name = "name", unique = true, length = 5)
    private String user_name;
    @NonNull
    @Column(nullable = false, unique = true)
    private String desc;
    @NonNull
    private Double score;
}
