package com.ssydx.data.springDataJpa;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "test")
@Entity
public class UserDomain41 {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @NonNull
    @Column(nullable = false, name = "name", unique = true, length = 5)
    private String user_name;
    @NonNull
    @Column(columnDefinition = "TEXT")
    private String desc;
    @NonNull
    // @Column(precision = 5,scale = 2)
    private Double score;
    @Column
    private Integer age;
    @Column
    private Boolean bool;
    @Column
    private BigDecimal price;
    @Column
    private Date date;
    @Column
    private Time time;
    @Column
    private float fl;
    @Column
    private Timestamp stamp;
    @Column
    private byte[] bt;
}
