package com.example.ComprehensivePractice.Entity;

import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.DBConnection;

public class TakeTable {

    public JSONArray dobooktake()
    {
        DBConnection d=new DBConnection();
        JSONArray statu = null;
        return statu;
    }

    public JSONArray taketableinf(String userid) {
        DBConnection d=new DBConnection();
        JSONArray tableinf=d.selecttaketable(userid);
        return tableinf;
    }
}
