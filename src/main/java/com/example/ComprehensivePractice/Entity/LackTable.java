package com.example.ComprehensivePractice.Entity;

import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.DBConnection;

public class LackTable {

    public JSONArray dobooklack(String bookid,String count)
    {
        DBConnection d=new DBConnection();
        JSONArray statu=d.insertbooklack(bookid,count);
        return statu;
    }

    public JSONArray lacktableinf() {
        DBConnection d=new DBConnection();
        JSONArray tableinf=d.selectlacktable();
        return tableinf;
    }
}
