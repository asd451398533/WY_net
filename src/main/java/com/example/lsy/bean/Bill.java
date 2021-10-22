package com.example.lsy.bean;

public class Bill {
    public int id;

    public double money;

    public String userKey;

    public String remarkId;

    public String remark;

    public String categoryImage;

    /// 类型 1支出 2收入
    public int type;

    /// 是否已删除 0没有 1删除
    public int isDelete;

    public long createTimestamp;

    public String createTime;

    public long updateTimestamp;

    public String updateTime;
}
