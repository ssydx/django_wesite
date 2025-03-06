package com.ssydx.data1.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssydx.data1.entity.User;

@Repository
public interface UserDao5 extends JpaRepository<User,Integer> {
    List<User> findByName(String name);
    List<User> findByNameNot(String name);
    List<User> findByAgeLessThan(int age);
    List<User> findByAgeGreaterThanEqual(int age);
    List<User> findByAgeBetween(int start, int end);
    Optional<User> findByAge(int age);
    Iterable<User> findByNameOrAge(String name, int age);
    int countByName(String name);
    User findBynameAndAge(String n, int a);
    List<User> findByNameOrAgeOrGender(String name,int age,char gender);
}
