package com.ssydx.data.springDataJdbc;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.query.ListQueryByExampleExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
// 继承自定义接口
public interface UserDao3 extends ListCrudRepository<UserDomain3,Integer>,UserCustomDao3,ListQueryByExampleExecutor<UserDomain3>,ListPagingAndSortingRepository<UserDomain3,Integer> {
    // 方法名生成查询，不支持生成增删改
    public List<UserDomain3> findByUserName(String name);
    // Query注解，不支持无名注解
    @Query("select * from user_info")
    public List<UserDomain3> myfindAll();
    // Query命名注解
    @Query("select * from user_info where score=:score")
    public List<UserDomain3> myfindByScoreUseName(@Param("score") Double score);
    // Query命名增删改注解
    @Modifying
    @Query("delete from user_info where name=:name")
    public void deleteByScore(@Param("name") String name);

    @Query("select * from user_info where desc like concat('%', :desc, '%')")
    public List<UserDomain3> test(@Param("desc") String desc);
}
