package com.example.lsy.service;

import com.example.lsy.bean.Bill;
import com.example.lsy.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TestService {

    List<User> getAllUser();

    int addBill(Bill bill);

    User findUserByName(String name);

    int testSplitTable();

    int saveTest(String key, String vlaue);

    int updateTest(String key, String vlaue, Integer id);

    Map<String, Object> getTest(int id);

    int delTest(int id);
}
