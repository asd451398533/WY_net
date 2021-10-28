package com.example.lsy.service.impl;

import com.example.lsy.bean.*;
import com.example.lsy.mapper.TestMapper;
import com.example.lsy.service.TestService;
import com.example.lsy.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Bill> getBillByUserKey(String userKey) {
        return testMapper.getBillByUserKey(userKey);
    }

    @Override
    public List<User> getAllUser() {
        return testMapper.getAllUser();
    }

    @Override
    public int addBill(Bill bill) {
        return testMapper.addBill(bill);
    }

    @Override
    public int updateBill(Bill bill) {
        return testMapper.updateBill(bill);
    }

    @Override
    public List<RemarkBean> getRemarkByRemarkId(String remarkId) {
        return testMapper.getRemarkByRemarkId(remarkId);
    }

    @Override
    public int updateRemark(RemarkBean remark) {
        return testMapper.updateRemark(remark);
    }

    @Override
    public int addImage(ImagesBean Image) {
        return testMapper.addImage(Image);
    }

    @Override
    public int addRemark(RemarkBean remark) {
        return testMapper.addRemark(remark);
    }

    @Override
    public Bill getBillIdByRemarkId(String remarkId) {
        return testMapper.getBillIdByRemarkId(remarkId);
    }

    @Override
    public XT getXTIdByRemarkId(String remarkId) {
        return testMapper.getXTIdByRemarkId(remarkId);
    }

    @Override
    public List<Food> getFoods() {
        return testMapper.getFoods();
    }

    @Override
    public int addFK(FK FK) {
        return testMapper.addFK(FK);
    }

    @Override
    public User findUserByName(String name) {
        return testMapper.findUserByName(name);
    }

    @Override
    public List<XT> getXTByUserKey(String userKey) {
        return testMapper.getXTByUserKey(userKey);
    }

    @Override
    public List<XTRemarkBean> getXTRemarkByRemarkId(String remarkId) {
        return testMapper.getXTRemarkByRemarkId(remarkId);
    }

    @Override
    public int updateXTRemark(XTRemarkBean remark) {
        return testMapper.updateXTRemark(remark);
    }

    @Override
    public int addXTRemark(XTRemarkBean remark) {
        return testMapper.addXTRemark(remark);
    }

    @Override
    public int addXT(XT XT) {
        return testMapper.addXT(XT);
    }

    @Override
    public int updateXT(XT XT) {
        return testMapper.updateXT(XT);
    }

    @Override
    public int testSplitTable() {
        String uuid = null;
        int num = 0;
        for (int i = 0; i < 6; i++) {
            uuid = Utils.generateUUID();
            System.out.println(uuid);
            if (!StringUtils.isEmpty(uuid)) {
                num = Integer.parseInt(String.valueOf(uuid.charAt(0)), 16) % 3;
                testMapper.saveTableTest("test_" + num, uuid, "test");
            }
        }
        return 0;
    }

    @Override
    public int updateTest(String key, String value, Integer id) {
        return testMapper.updateTest(key, value, id);
    }

    @Override
    public int saveTest(String key, String value) {
        return testMapper.saveTest(key, value);
    }

    @Override
    public Map<String, Object> getTest(int id) {
        return testMapper.getTest(id);
    }

    @Override
    public int delTest(int id) {
        return testMapper.delTest(id);
    }
}
