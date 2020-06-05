package com.example.ComprehensivePractice.Entity;

import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.DBConnection;

public class TakeTable {

    public JSONArray dobooktake(String orderid,String sellerid,String takedate,String bookid,String count)
    {
        DBConnection d=new DBConnection();
        JSONArray statu=d.insertbooktake(orderid,sellerid,takedate,bookid,count);
        return statu;
    }

    public JSONArray taketableinf(String userid) {
        DBConnection d=new DBConnection();
        JSONArray tableinf=d.selecttaketable(userid);
        return tableinf;
    }

    public JSONArray confirmtake(String buyid) {
        DBConnection d=new DBConnection();
        JSONArray statu=d.updatetake(buyid);
        return statu;
    }
}
