package com.rashm1n.controller;

import com.google.gson.Gson;
import com.rashm1n.model.Student;
import com.rashm1n.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/student")
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Student student = new Student("rashmin", 26, "mars");
        String json = new Gson().toJson(student);
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        printWriter.print(json);
        printWriter.flush();
    }
}

@WebServlet("/teacher")
class TeacherController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Teacher teacher = new Teacher("snape", 29, "bsc");
        String json = new Gson().toJson(teacher);
        PrintWriter printWriter = resp.getWriter();
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        printWriter.print(json);
        printWriter.flush();
    }
}
