package com.example.lsy.mapper;

import com.example.lsy.bean.Bill;
import com.example.lsy.bean.RemarkBean;
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

    int updateBill(@Param("bill") Bill bill);

    int updateRemark(@Param("remark") RemarkBean remark);

    List<RemarkBean> getRemarkByRemarkId(@Param("remarkId") String remarkId);

    int addRemark(@Param("remark") RemarkBean remark);

    Bill getBillIdByRemarkId(@Param("remarkId") String remarkId);

    int saveTableTest(@Param("table") String table,
                      @Param("key") String key,
                      @Param("value") String value);

    List<Bill> getBillByUserKey(@Param("userKey") String userKey);

    int saveTest(@Param("key") String key,
                 @Param("value") String value);

    int updateTest(@Param("key") String key,
                   @Param("value") String value,
                   @Param("id") Integer id);

    Map<String, Object> getTest(@Param("id") Integer id);

    int delTest(@Param("id") Integer id);
}
