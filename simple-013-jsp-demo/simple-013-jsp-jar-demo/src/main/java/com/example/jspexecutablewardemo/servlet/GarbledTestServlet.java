package com.example.jspexecutablewardemo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/test6")
public class GarbledTestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String characterEncoding = req.getCharacterEncoding();
        System.out.println("default encoding: " + characterEncoding);
        String name = req.getParameter("name");
        System.out.println("get name: " + name);
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String characterEncoding = req.getCharacterEncoding();
        System.out.println("default encoding: " + characterEncoding);
        String name = req.getParameter("name");
        System.out.println("post name: " + name);

    }
}
