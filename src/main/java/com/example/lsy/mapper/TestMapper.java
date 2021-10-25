package com.example.lsy.mapper;

import com.example.lsy.bean.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TestMapper {

    List<User> getAllUser();

    User findUserByName(@Param("name") String name);

    int addBill(@Param("bill") Bill bill);

    int addXT(@Param("XT") XT XT);

    int updateXT(@Param("XT") XT XT);

    int updateBill(@Param("bill") Bill bill);

    int updateRemark(@Param("remark") RemarkBean remark);


    List<RemarkBean> getRemarkByRemarkId(@Param("remarkId") String remarkId);
    List<XTRemarkBean> getXTRemarkByRemarkId(@Param("remarkId") String remarkId);

    int addRemark(@Param("remark") RemarkBean remark);

    int updateXTRemark(@Param("remark") XTRemarkBean remark);
    int addXTRemark(@Param("remark") XTRemarkBean remark);

    Bill getBillIdByRemarkId(@Param("remarkId") String remarkId);
    XT getXTIdByRemarkId(@Param("remarkId") String remarkId);

    int saveTableTest(@Param("table") String table,
                      @Param("key") String key,
                      @Param("value") String value);

    List<Bill> getBillByUserKey(@Param("userKey") String userKey);
    List<XT> getXTByUserKey(@Param("userKey") String userKey);

    int saveTest(@Param("key") String key,
                 @Param("value") String value);

    int updateTest(@Param("key") String key,
                   @Param("value") String value,
                   @Param("id") Integer id);

    Map<String, Object> getTest(@Param("id") Integer id);

    int delTest(@Param("id") Integer id);
}
