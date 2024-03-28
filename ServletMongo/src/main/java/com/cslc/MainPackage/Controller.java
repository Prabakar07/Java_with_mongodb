package com.cslc.MainPackage;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserData ud = new UserData();
        ud.storeUserCredentials(req.getParameter("user_name"), req.getParameter("user_password"));
        resp.getOutputStream().println("User Inserted");
    }
}