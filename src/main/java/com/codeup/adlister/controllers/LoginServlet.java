package com.codeup.adlister.controllers;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "controllers.LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getSession().getAttribute("user") != null) {
            response.sendRedirect("/profile");
            return;
        }
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean validAttempt=false;
        System.out.println("doPost method called!");
        // TODO: find a record in your database that matches the submitted password
        User exist= DaoFactory.getuserDao().findByUsername(username);
        if (exist!=null) {
            // TODO: make sure we find a user with that username
            // TODO: check the submitted password against what you have in your database
            boolean passwordsDoMatch = BCrypt.checkpw(password, exist.getPassword());
            validAttempt = (username.equals(exist.getUsername()) && passwordsDoMatch);
            if (validAttempt) {
                System.out.println("this is the value of the conditional: " + validAttempt);
                // TODO: store the logged in user object in the session, instead of just the username
                request.getSession().setAttribute("user", username);
                response.sendRedirect("/profile");
            } else {
                System.out.println("the condition never became true");
                response.sendRedirect("/login");
            }
        }
        else {
            System.out.println("the condition never became true");
            response.sendRedirect("/login");
        }
    }
}
