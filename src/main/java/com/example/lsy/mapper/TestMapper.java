package com.example.lsy.mapper;

import com.example.lsy.bean.Bill;
import com.example.lsy.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {

    List<User> getAllUser();

    User findUserByName(@Param("name") String name);

    int addBill(@Param("bill") Bill bill);


    int saveTableTest(@Param("table") String table,
                      @Param("key") String key,
                      @Param("value") String value);

    int saveTest(@Param("key") String key,
                 @Param("value") String value);

    int updateTest(@Param("key") String key,
                   @Param("value") String value,
                   @Param("id") Integer id);

    Map<String, Object> getTest(@Param("id") Integer id);

    int delTest(@Param("id") Integer id);
}
