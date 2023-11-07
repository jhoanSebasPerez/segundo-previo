package com.perez.simpledemo.controllers;

import com.perez.simpledemo.dao.UserDAO;
import com.perez.simpledemo.models.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class UserServlet extends HttpServlet{

    private UserDAO userDAO;

    @Override
    public void init(){
        this.userDAO = new UserDAO();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/update":
                showUpdateForm(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                break;
            default:
                showAllUsers(request, response);
                break;
        }
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User newUser = User.builder()
                .name(name)
                .email(email)
                .country(country)
                .build();

        String action = request.getParameter("action");

        if(action.equals("update")){
            int id = Integer.parseInt(request.getParameter("id"));
            newUser.setId(id);
            userDAO.update(newUser);

        }else{
            userDAO.save(newUser);
        }

        response.sendRedirect(request.getContextPath() + "/");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        userDAO.delete(id);
        response.sendRedirect(request.getContextPath() + "/");
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userDAO.getUserById(id);
        request.setAttribute("user", user);
        request.getRequestDispatcher("/user-form.jsp").forward(request, response);
    }

    private void showAllUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = userDAO. getAllUsers();
        request.setAttribute("users", users);
        request.getRequestDispatcher("/users.jsp").forward(request, response);
    }
}
