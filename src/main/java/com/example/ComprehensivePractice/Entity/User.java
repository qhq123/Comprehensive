package com.example.ComprehensivePractice.Entity;

import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.DBConnection;

public class User {

    public JSONArray userinf(String userid,String pass)
    {
        DBConnection d=new DBConnection();
        JSONArray userinf=d.selectuser(userid,pass);
        return userinf;
    }
}
