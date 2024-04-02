package com.cslc.MainPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Controller extends HttpServlet {
    
    private final UserData ud = new UserData();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        
        if ("insert".equals(action)) {
            insertUser(req, resp);
        } else if ("delete".equals(action)) {
            deleteUser(req, resp);
        } else if ("update".equals(action)) {
            updateUser(req, resp);
        } else {
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            out.println("Invalid action");
        }
    }

    private void insertUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user_name");
        String userPassword = req.getParameter("user_password");

        if (userName != null && userPassword != null) {
            ud.insertUser(userName, userPassword);
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            out.println("User inserted successfully");
        } else {
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            out.println("Invalid user data");
        }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("user_id_name");

        if (userId != null) {
            ud.deleteUser(userId);
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            out.println("User deleted successfully");
        } else {
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            out.println("Invalid user ID");
        }
    }
    
    private void updateUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userId = req.getParameter("user_id_update");
        String userName = req.getParameter("user_name_update");
        String userPassword = req.getParameter("user_password_update");

        if (userId != null && userName != null && userPassword != null) {
            PrintWriter out = resp.getWriter();
            resp.setContentType("text/plain");
            out.print(ud.updateUser(userId, userName, userPassword));

        } else {
            resp.setContentType("text/plain");
            PrintWriter out = resp.getWriter();
            out.println("Invalid user data");
        }
    }
    
}
