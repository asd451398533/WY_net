package com.example.lsy.service;

import com.example.lsy.bean.*;
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

    List<RemarkBean> getRemarkByRemarkId(String remarkId);

    int updateRemark(RemarkBean remark);

    int addRemark(RemarkBean remark);

    Bill getBillIdByRemarkId(String remarkId);

    XT getXTIdByRemarkId(String remarkId);

    User findUserByName(String name);

    List<XT> getXTByUserKey(String userKey);

    List<XTRemarkBean> getXTRemarkByRemarkId(String remarkId);

    int updateXTRemark(XTRemarkBean remark);

    int addXTRemark(XTRemarkBean remark);

    int addXT(XT XT);

    int updateXT(XT XT);

    int testSplitTable();

    int saveTest(String key, String vlaue);

    int updateTest(String key, String vlaue, Integer id);

    Map<String, Object> getTest(int id);

    int delTest(int id);
}
