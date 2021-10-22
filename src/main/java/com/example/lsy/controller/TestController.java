package com.example.lsy.controller;

import com.example.lsy.bean.*;
import com.example.lsy.service.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/app")
public class TestController {
    private final Log log = LogFactory.getLog(TestController.class);

    @Autowired
    private TestService testService;

    @RequestMapping(value = "/getAllUser", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUser() {
        return testService.getAllUser();
    }


    @RequestMapping(value = "/findUserByName", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public User findUserByName(@RequestBody SingleWorldBean singleWorldBean) {
        log.info("name=>" + singleWorldBean.name);
        User userByName = testService.findUserByName(singleWorldBean.name);
        log.info("USER->" + userByName);
        return userByName;
    }

    @RequestMapping(value = "/addBill", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SimpleReturn addBill(@RequestBody Bill bill) {
        String remarkId = UUID.randomUUID().toString().replace("-", "");
        bill.remarkId = remarkId;
        bill.isDelete = 0;
        int i = testService.addBill(bill);
        if (i == 1) {
            Bill billIdByRemarkId = testService.getBillIdByRemarkId(remarkId);
            if (billIdByRemarkId != null) {
                RemarkBean remarkBean = new RemarkBean();
                remarkBean.remarkId = remarkId;
                remarkBean.billId = billIdByRemarkId.id;
                remarkBean.createTime = billIdByRemarkId.createTime;
                remarkBean.createTimestamp = billIdByRemarkId.createTimestamp;
                remarkBean.updateTime = billIdByRemarkId.updateTime;
                remarkBean.updateTimestamp = billIdByRemarkId.updateTimestamp;
                remarkBean.remark = billIdByRemarkId.remark;
                remarkBean.userKey = billIdByRemarkId.userKey;
                int i1 = testService.addRemark(remarkBean);
                if (i1 == 1) {
                    return new SimpleReturn(200, "");
                }
            }
        }
        return new SimpleReturn(500, "");
    }

    @RequestMapping(value = "/addRemark", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int addRemark(@RequestBody RemarkBean remarkBean) {
        log.info("MMMM" + (remarkBean.remark));
        return testService.addRemark(remarkBean);
    }


}

