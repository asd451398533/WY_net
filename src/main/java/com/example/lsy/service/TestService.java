package com.example.lsy.service;

import com.example.lsy.bean.Bill;
import com.example.lsy.bean.RemarkBean;
import com.example.lsy.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface TestService {

    List<Bill> getBillByUserKey(@Param("userKey") String userKey);

    List<User> getAllUser();

    int addBill(Bill bill);

    int updateBill(Bill bill);

    List<RemarkBean> getRemarkByRemarkId( String remarkId);

    int updateRemark( RemarkBean remark);

    int addRemark(RemarkBean remark);

    Bill getBillIdByRemarkId(String remarkId);

    User findUserByName(String name);

    int testSplitTable();

    int saveTest(String key, String vlaue);

    int updateTest(String key, String vlaue, Integer id);

    Map<String, Object> getTest(int id);

    int delTest(int id);
}
