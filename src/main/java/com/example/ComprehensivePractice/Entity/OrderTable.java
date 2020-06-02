package com.example.ComprehensivePractice.Entity;

import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.DBConnection;

public class OrderTable {

    public JSONArray dobookorder(String booknum, String ordernum,String count)
    {
        DBConnection d=new DBConnection();
        JSONArray statu=d.insertbookorder(booknum,ordernum,count);
        return statu;
    }

    public JSONArray ordertableinf(String userid) {
        DBConnection d=new DBConnection();
        JSONArray tableinf=d.selectordertable(userid);
        return tableinf;
    }
}
