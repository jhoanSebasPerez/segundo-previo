package com.perez.simpledemo.controllers;

import com.perez.simpledemo.dao.UserDAO;
import com.perez.simpledemo.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/")
public class LoginServlet extends HttpServlet {

    private UserDAO userDao = new UserDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if(!userDao.userExistsByUsername(username)){
            request.setAttribute("error", "User does not exist");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }else{
            User user = userDao.getUserByUsername(username);
            if(!user.getPass().equals(password)){
                request.setAttribute("error", "Incorrect password");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }else{
                request.getSession().setAttribute("username", user.getUsername());
                try {
                    response.sendRedirect(request.getContextPath() + "/movimientos");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
