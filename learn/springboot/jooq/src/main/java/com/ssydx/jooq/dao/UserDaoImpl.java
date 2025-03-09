package com.ssydx.jooq.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.InsertSetStep;
import org.jooq.InsertValuesStep2;
import org.jooq.InsertValuesStepN;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static com.ssydx.jooq.domain.Tables.USER_INFO;

import com.ssydx.jooq.domain.tables.records.UserInfoRecord;

@Repository
public class UserDaoImpl implements UserDao {
    @Autowired
    private DSLContext create;
    
    @Override
    public int insert(UserInfoRecord userInfoRecord) {
        return create.insertInto(USER_INFO, USER_INFO.NAME,USER_INFO.AGE).values(userInfoRecord.getName(), userInfoRecord.getAge()).execute();
    }
    @Override
    public List<UserInfoRecord> select() {
        return create.selectFrom(USER_INFO).fetch();
    }
    public void insertTest() {
        // 相当于insert into tbname，对字段没有类型检查
        InsertSetStep<UserInfoRecord> record1 = create.insertInto(USER_INFO);
        // 相当于insert into tbname(colname1,...)，不超过22个时有字段类型检查，超过后则没有，具体见源码
        InsertValuesStep2<UserInfoRecord, String, Integer> record2 = create.insertInto(USER_INFO, USER_INFO.NAME,USER_INFO.AGE);
        InsertValuesStepN record11 = record1.values(null,"ssydx",30);
    }
}
