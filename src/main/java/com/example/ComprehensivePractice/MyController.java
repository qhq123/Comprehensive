package com.example.ComprehensivePractice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyController {
    @RequestMapping("/login")
    public String login(){
        return "html/login.html";
    }

    @RequestMapping("/a")
    public String a(){ return "html/a.html"; }

    @RequestMapping("/b")
    public String b(){ return "html/b.html"; }

    @RequestMapping("/c")
    public String c(){ return "html/c.html"; }

    @RequestMapping("/a2success")
    public String success(){
        return "html/a2success.html";
    }
}
