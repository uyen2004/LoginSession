package com.uyen.crm.controller;

import com.uyen.crm.model.Users;
import com.uyen.crm.service.LoginService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "loginPage", urlPatterns = "/login")
public class LoginPage extends HttpServlet {
    private LoginService loginService = new LoginService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        boolean isLogin = loginService.checkLogin(email, password);
        if(isLogin == true){
            HttpSession httpSession = req.getSession();
            httpSession.setAttribute("isLogin", true);
            httpSession.setMaxInactiveInterval(5*60);

        }
        req.getRequestDispatcher("/webapp/login.html").forward(req, resp);
    }
}
