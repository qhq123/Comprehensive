package com.example.ComprehensivePractice.Servlet;

import com.alibaba.fastjson.JSONArray;
import com.example.ComprehensivePractice.Entity.BookTable;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet(name = "BookTableServlet", urlPatterns = "/BookTableServlet")
public class BookTableServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookTableServlet() {
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
        BookTable booktable=new BookTable();
        JSONArray res=booktable.booktableinf();
        String str= res.toJSONString();
        //System.out.println(str);
        PrintWriter write=response.getWriter();
        write.println(str);
        write.flush();
    }

}
