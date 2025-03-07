package com.ssydx.datajpa.dao;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ssydx.datajpa.domain.User;

import jakarta.transaction.Transactional;

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
    
    @Transactional
    int deleteByName(String name);

    @Query("select u from User u where u.name like ?1")
    List<User> findByNamwJPQL(String name);

    @Modifying
    @Transactional
    @Query("insert into User u(name,age,gender) values(?1,?2,?3)")
    int saveJPQL(String name, int age, char gender);

    @Query("select u from User u where u.age >= :age")
    List<User> findByAgeJPQL(@Param("age") int age);

    @Query(value = "select * from user_info where gender = :gender",nativeQuery = true)
    List<User> findByGenderSQL(@Param("gender") char gender);

    // 命名查询
    List<User> findJPQL(@Param("name") String name);
    List<User> findSQL(String name);

}
