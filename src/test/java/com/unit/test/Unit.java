package com.unit.test;
import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.DBConnection;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Unit {
    DBConnection db = new DBConnection();
    JSONArray result = new JSONArray();

    @Test//(enabled=false)
    public void T_selectuser() {
        String t1;
        String t2;

        //a1-1
        result = db.selectuser("a1","a1");
        //System.out.println(result.getJSONObject(0));
        t1 = result.getJSONObject(0).getString("type");
        t2 = result.getJSONObject(0).getString("userid");
        Assert.assertEquals("a",t1);
        Assert.assertEquals("a1",t2);

        //b1-1
        result = db.selectuser("b1","b1");
        //System.out.println(result.getJSONObject(0));
        t1 = result.getJSONObject(0).getString("type");
        t2 = result.getJSONObject(0).getString("userid");
        Assert.assertEquals("b",t1);
        Assert.assertEquals("b1",t2);

        //c1-1
        result = db.selectuser("c1","c1");
        //System.out.println(result.getJSONObject(0));
        t1 = result.getJSONObject(0).getString("type");
        t2 = result.getJSONObject(0).getString("userid");
        Assert.assertEquals("c",t1);
        Assert.assertEquals("c1",t2);

        //wu-0
        result = db.selectuser("d","d");
        //System.out.println(result.getJSONObject(0));
        t1 = result.getJSONObject(0).getString("type");
        Assert.assertEquals("wu",t1);

        //wu-0
        result = db.selectuser("c1","d");
        //System.out.println(result.getJSONObject(0));
        t1 = result.getJSONObject(0).getString("type");
        Assert.assertEquals("wp",t1);
    }

    @Test//(enabled=false)
    public void T_insertbook() {
        String t1;
        String t2;
        String t3;

        //wc2-0
        result = db.insertbookorder("a0101","a1","0");
        //System.out.println(result);
        t1 = result.getJSONObject(0).getString("statu");
        Assert.assertEquals("wc2",t1);

        //wn-0
        result = db.insertbookorder("a01","a1","1");
        //System.out.println(result);
        t1 = result.getJSONObject(0).getString("statu");
        Assert.assertEquals("wn",t1);

        //t-1
        result = db.insertbookorder("a0101","a1","1");
        //System.out.println(result);
        t1 = result.getJSONObject(0).getString("statu");
        t2 = result.getJSONObject(0).getString("tprice");
        t3 = result.getJSONObject(0).getString("title");
        Assert.assertEquals("t",t1);
        Assert.assertEquals("70.2",t2);
        Assert.assertEquals("马克思主义哲学原理（合订本）",t3);
    }

    @Test//(enabled=false)
    public void T_selectordertable() {
        String t1;
        String t2;
        String t3;
        String t4;
        String t5;
        String t6;

        result = db.selectordertable("a2");
        System.out.println(result);
        t1 = result.getJSONObject(0).getString("orderid");
        t2 = result.getJSONObject(0).getString("bookid");
        t3 = result.getJSONObject(0).getString("buydate");
        t4 = result.getJSONObject(0).getString("buyerid");
        t5 = result.getJSONObject(0).getString("count");
        t6 = result.getJSONObject(0).getString("tprice");
        Assert.assertEquals("2",t1);
        Assert.assertEquals("a0101",t2);
        Assert.assertEquals("2020-06-03",t3);
        Assert.assertEquals("a2",t4);
        Assert.assertEquals("1",t5);
        Assert.assertEquals("70.20",t6);

        t1 = result.getJSONObject(1).getString("orderid");
        t2 = result.getJSONObject(1).getString("bookid");
        t3 = result.getJSONObject(1).getString("buydate");
        t4 = result.getJSONObject(1).getString("buyerid");
        t5 = result.getJSONObject(1).getString("count");
        t6 = result.getJSONObject(1).getString("tprice");
        Assert.assertEquals("20200601180550a1",t1);
        Assert.assertEquals("a0101",t2);
        Assert.assertEquals("2020-06-01",t3);
        Assert.assertEquals("a2",t4);
        Assert.assertEquals("1",t5);
        Assert.assertEquals("70.20",t6);
    }

    @Test//(enabled=false)
    public void T_selecttaketable() {
        String t1;
        String t2;
        String t3;
        String t4;
        String t5;
        String t6;

        result = db.selecttaketable("a2");
        System.out.println(result);
        t1 = result.getJSONObject(0).getString("takeid");
        t2 = result.getJSONObject(0).getString("buyerid");
        t3 = result.getJSONObject(0).getString("takedate");
        t4 = result.getJSONObject(0).getString("buyid");
        t5 = result.getJSONObject(0).getString("buydate");
        t6 = result.getJSONObject(0).getString("sellerid");
        Assert.assertEquals("0",t1);
        Assert.assertEquals("a2",t2);
        Assert.assertEquals("2020-06-01",t3);
        Assert.assertEquals("20200601180550a1",t4);
        Assert.assertEquals("2020-06-01",t5);
        Assert.assertEquals("b1",t6);
    }
}
