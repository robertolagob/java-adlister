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



@WebServlet(name = "controllers.RegisterServlet", urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException {
        request.getRequestDispatcher("/WEB-INF/register.jsp").forward(request,response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        String userName=request.getParameter("username");
        String userEmail=request.getParameter("email");
        String userPassword=request.getParameter("password");
        String userConfirm=request.getParameter("confirm");
        // TODO: ensure the submitted information is valid
        boolean match=userPassword.equalsIgnoreCase(userConfirm);
        User exist=DaoFactory.getuserDao().findByUsername(userName);
        if (exist==null) {
            if (match) {
                // TODO: create a new user based off of the submitted information
                int numberOfRounds = 12;
                String hash = BCrypt.hashpw(userPassword, BCrypt.gensalt(numberOfRounds));
                User usuario = new User(userName, userEmail, hash);
                DaoFactory.getuserDao().insert(usuario);
                // TODO: if a user was successfully created, send them to their profile
                try {
                    request.setAttribute("sessionScope.user",usuario.getUsername());
                    request.getRequestDispatcher("/WEB-INF/profile.jsp").forward(request, response);
                }catch (Exception e){
                    throw new RuntimeException("error redirecting to your profile");
                }

            } else {
                try {
                    response.sendRedirect("/register");
                } catch (Exception e) {
                    throw new RuntimeException("Error redirecting to /register");
                }
            }
        }
        else {
            try {
                response.sendRedirect("/register");
            }catch (Exception e){
                throw  new RuntimeException("Error redirecting to /register");
            }
        }


    }
}
