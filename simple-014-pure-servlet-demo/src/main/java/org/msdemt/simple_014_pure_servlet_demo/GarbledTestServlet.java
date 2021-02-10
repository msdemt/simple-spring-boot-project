package org.msdemt.simple_014_pure_servlet_demo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class GarbledTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String encoding = req.getCharacterEncoding();
        System.out.println("encoding: " + encoding);
        String name = req.getParameter("name");
        System.out.println("get name: " + name);
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("default characterEncoding: " + req.getCharacterEncoding());
        req.setCharacterEncoding("UTF-8");  //注释该行，输出的name是乱码
        String name = req.getParameter("name");
        System.out.println("post name: " + name);

        //response 中文乱码
        resp.setContentType("text/html;charset=utf-8"); //注释该行，响应到浏览器的中文是乱码
        PrintWriter writer = resp.getWriter();
        writer.println("你好，世界");
    }
}
