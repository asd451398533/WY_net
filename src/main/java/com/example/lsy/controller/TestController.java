package com.example.lsy.controller;

import com.example.lsy.bean.*;
import com.example.lsy.service.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
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
        if (bill.id > 0) {
            int i = testService.updateBill(bill);
            if (i == 1) {
                return new SimpleReturn(200, "");
            }
            return new SimpleReturn(500, "");
        }
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
    public SimpleReturn addRemark(@RequestBody RemarkBean remarkBean) {
        if (remarkBean.id > 0) {
            int i = testService.updateRemark(remarkBean);
            if (i == 1) {
                return new SimpleReturn(200, "");
            }
            return new SimpleReturn(500, "");
        }
        log.info("MMMM" + (remarkBean.remark));
        int i = testService.addRemark(remarkBean);
        if (i == 1) {
            return new SimpleReturn(200, "");
        }
        return new SimpleReturn(500, "");
    }


    @RequestMapping(value = "/getBillByUserKey", method = RequestMethod.GET)
    @ResponseBody
    public List<Bill> getBillByUserKey(@RequestParam("userKey") String userKey) {
        log.info("name=>" + userKey);
        List<Bill> billByUserKey = testService.getBillByUserKey(userKey);
        billByUserKey.sort(new Comparator<Bill>() {
            @Override
            public int compare(Bill o1, Bill o2) {
                return (int) (o2.updateTimestamp - o1.updateTimestamp);
            }
        });
        log.info("billByUserKey->" + billByUserKey);
        return billByUserKey;
    }

    @RequestMapping(value = "/getRemarkByRemarkId", method = RequestMethod.GET)
    @ResponseBody
    public List<RemarkBean> getRemarkByRemarkId(@RequestParam("remarkId") String remarkId) {
        log.info("name=>" + remarkId);
        List<RemarkBean> remarkByRemarkId = testService.getRemarkByRemarkId(remarkId);
        remarkByRemarkId.sort(new Comparator<RemarkBean>() {
            @Override
            public int compare(RemarkBean o1, RemarkBean o2) {
                return (int) (o2.updateTimestamp - o1.updateTimestamp);
            }
        });
        log.info("billByUserKey->" + remarkByRemarkId);
        return remarkByRemarkId;
    }
}

