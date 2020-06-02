package com.example.ComprehensivePractice.Entity;

import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.DBConnection;


public class BookTable {

    public JSONArray booktableinf()
    {
        DBConnection d=new DBConnection();
        JSONArray tableinf=d.selectbooktable();
        return tableinf;
    }

}
