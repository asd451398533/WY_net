package com.example.lsy.controller;

import com.example.lsy.bean.*;
import com.example.lsy.service.TestService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
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

    @RequestMapping(value = "/addXT", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SimpleReturn addBill(@RequestBody XT xt) {
        if (xt.id > 0) {
            int i = testService.updateXT(xt);
            if (i == 1) {
                return new SimpleReturn(200, "");
            }
            return new SimpleReturn(500, "");
        }
        String remarkId = UUID.randomUUID().toString().replace("-", "");
        xt.remarkId = remarkId;
        xt.isDelete = 0;
        int i = testService.addXT(xt);
        if (i == 1) {
            XT billIdByRemarkId = testService.getXTIdByRemarkId(remarkId);
            if (billIdByRemarkId != null) {
                XTRemarkBean remarkBean = new XTRemarkBean();
                remarkBean.remarkId = remarkId;
                remarkBean.xtId = billIdByRemarkId.id;
                remarkBean.createTime = billIdByRemarkId.createTime;
                remarkBean.createTimestamp = billIdByRemarkId.createTimestamp;
                remarkBean.updateTime = billIdByRemarkId.updateTime;
                remarkBean.updateTimestamp = billIdByRemarkId.updateTimestamp;
                remarkBean.remark = billIdByRemarkId.remark;
                remarkBean.userKey = billIdByRemarkId.userKey;
                int i1 = testService.addXTRemark(remarkBean);
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


    @RequestMapping(value = "/addXTRemark", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public SimpleReturn addXTRemark(@RequestBody XTRemarkBean remarkBean) {
        if (remarkBean.id > 0) {
            int i = testService.updateXTRemark(remarkBean);
            if (i == 1) {
                return new SimpleReturn(200, "");
            }
            return new SimpleReturn(500, "");
        }
        log.info("MMMM" + (remarkBean.remark));
        int i = testService.addXTRemark(remarkBean);
        if (i == 1) {
            return new SimpleReturn(200, "");
        }
        return new SimpleReturn(500, "");
    }


    @RequestMapping(value = "/getBillByUserKey", method = RequestMethod.GET)
    @ResponseBody
    public List<Bill> getBillByUserKey(@RequestParam("userKey") String userKey) {
        log.info("name=>" + userKey);
        return testService.getBillByUserKey(userKey);
    }

    @RequestMapping(value = "/getXTByUserKey", method = RequestMethod.GET)
    @ResponseBody
    public List<XT> getXTByUserKey(@RequestParam("userKey") String userKey) {
        log.info("name=>" + userKey);
        return testService.getXTByUserKey(userKey);
    }

    @RequestMapping(value = "/getRemarkByRemarkId", method = RequestMethod.GET)
    @ResponseBody
    public List<RemarkBean> getRemarkByRemarkId(@RequestParam("remarkId") String remarkId) {
        log.info("name=>" + remarkId);
        List<RemarkBean> remarkByRemarkId = testService.getRemarkByRemarkId(remarkId);
        log.info("billByUserKey->" + remarkByRemarkId);
        return remarkByRemarkId;
    }

    @RequestMapping(value = "/getXTRemarkByRemarkId", method = RequestMethod.GET)
    @ResponseBody
    public List<XTRemarkBean> getXTRemarkByRemarkId(@RequestParam("remarkId") String remarkId) {
        log.info("name=>" + remarkId);
        List<XTRemarkBean> remarkByRemarkId = testService.getXTRemarkByRemarkId(remarkId);
        log.info("billByUserKey->" + remarkByRemarkId);
        return remarkByRemarkId;
    }

    private static final String UPLOAD_DIR = "/Users/linyusheng/Downloads/";

    @ResponseBody
    @RequestMapping("/upload")
    public SimpleReturn fileUpload(@RequestParam("file") MultipartFile files,
                                   String id,
                                   String userKey,
                                   String createTimestamp,
                                   String createTime
    ) throws IOException {
        File pathFile = new File(UPLOAD_DIR);
        if (!pathFile.exists()) {
            pathFile.mkdirs();
        }
        //上传文件地址
        UUID uuid = UUID.randomUUID();
        File serverFile = new File(pathFile, uuid + "_" + files.getOriginalFilename());
        files.transferTo(serverFile);

        log.info("PATH -> " + serverFile.getAbsolutePath());
        ImagesBean imagesBean = new ImagesBean();
        imagesBean.name = serverFile.getName();
        imagesBean.path = serverFile.getAbsolutePath();
        imagesBean.isDelete = 0;
        imagesBean.userKey = userKey;
        imagesBean.createTime = createTime;
        imagesBean.createTimestamp = createTimestamp;
        int i = testService.addImage(imagesBean);
        if (i == 1) {
            return new SimpleReturn(200, serverFile.getAbsolutePath());
        }
        return new SimpleReturn(500, serverFile.getAbsolutePath());
    }

    @RequestMapping(value = "/download")
    public String downloads(HttpServletResponse response, HttpServletRequest request) throws Exception {
        //要下载的图片地址
        String path = UPLOAD_DIR;

        String fileName = request.getParameter("fileName");
        log.info("FILE NAME -> " + fileName);

        //1、设置response 响应头
        response.reset(); //设置页面不缓存,清空buffer
        response.setCharacterEncoding("UTF-8"); //字符编码
        response.setContentType("multipart/form-data"); //二进制传输数据
        //设置响应头
        response.setHeader("Content-Disposition",
                "attachment;fileName=" + URLEncoder.encode(fileName, "UTF-8"));

        File file = new File(path, fileName);
        //2、 读取文件--输入流
        InputStream input = new FileInputStream(file);
        //3、 写出文件--输出流
        OutputStream out = response.getOutputStream();

        byte[] buff = new byte[1024];
        int index = 0;
        //4、执行 写出操作
        while ((index = input.read(buff)) != -1) {
            out.write(buff, 0, index);
            out.flush();
        }
        out.close();
        input.close();
        return null;
    }
}

