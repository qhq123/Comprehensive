package com.example.ComprehensivePractice.Servlet;

import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.Entity.TakeTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet(name = "DoTakeServlet", urlPatterns = "/DoTakeServlet")
public class DoTakeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoTakeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder("");
        try
        {
            br = request.getReader();
            String str;
            while ((str = br.readLine()) != null)
            {
                sb.append(str);
            }
            br.close();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            if (null != br)
            {
                try
                {
                    br.close();
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
        //System.out.println(sb.toString());
        JSONArray ja = JSONArray.parseArray(sb.toString());
        String orderid=ja.getJSONObject(0).getString("orderid");
        String sellerid=ja.getJSONObject(0).getString("sellerid");
        String takedate=ja.getJSONObject(0).getString("takedate");
        String bookid=ja.getJSONObject(0).getString("bookid");
        String count=ja.getJSONObject(0).getString("count");
        TakeTable taketable=new TakeTable();
        JSONArray res= taketable.dobooktake(orderid,sellerid,takedate,bookid,count);
        String str= res.toJSONString();
        //System.out.println(str);
        PrintWriter write=response.getWriter();
        write.println(str);
        write.flush();
    }

}

