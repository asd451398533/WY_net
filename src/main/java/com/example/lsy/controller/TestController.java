package com.example.lsy.controller;

import com.example.lsy.bean.Bill;
import com.example.lsy.bean.User;
import com.example.lsy.service.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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


    @RequestMapping(value = "/findUserByName", method = RequestMethod.POST)
    @ResponseBody
    public User findUserByName(String name) {
        return testService.findUserByName(name);
    }

    @RequestMapping(value = "/addBill", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public int findUserByName(@RequestBody Bill bill) {
//        System.console().printf("MMMM" + (bill==null));
        log.info("MMMM" + (bill.money));
        return testService.addBill(bill);
    }


}

