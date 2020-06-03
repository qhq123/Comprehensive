package com.example.ComprehensivePractice.Entity;

import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.DBConnection;

public class LakeTable {

    public JSONArray dobooklake()
    {
        DBConnection d=new DBConnection();
        JSONArray statu=null;
        return statu;
    }

    public JSONArray laketableinf() {
        DBConnection d=new DBConnection();
        JSONArray tableinf=d.selectlaketable();
        return tableinf;
    }
}
