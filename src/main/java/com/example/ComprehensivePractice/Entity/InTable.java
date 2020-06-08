package com.example.ComprehensivePractice.Entity;

import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.DBConnection;

public class InTable {

    public JSONArray dobookin(String bookid, String incount,String inerid)
    {
        DBConnection d=new DBConnection();
        JSONArray statu=d.insertbookin(bookid,incount,inerid);
        return statu;
    }

    public JSONArray intableinf() {
        DBConnection d=new DBConnection();
        JSONArray tableinf=d.selectintable();
        return tableinf;
    }
}
