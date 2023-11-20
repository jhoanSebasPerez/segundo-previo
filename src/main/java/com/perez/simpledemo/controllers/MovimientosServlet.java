package com.perez.simpledemo.controllers;

import com.perez.simpledemo.dao.BillDAO;
import com.perez.simpledemo.dao.UserDAO;
import com.perez.simpledemo.models.Bill;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/movimientos")
public class MovimientosServlet extends HttpServlet {

    private BillDAO billDAO = new BillDAO();
    private UserDAO userDAO = new UserDAO();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = (String) request.getSession().getAttribute("username");
        Integer userId = userDAO.getUserByUsername(username).getId();

        List<Bill> billsFromUser = billDAO.getBillsByUserId(userId);

        request.setAttribute("bills", billsFromUser);
        request.getRequestDispatcher("/movimientos.jsp").forward(request, response);
    }
}
