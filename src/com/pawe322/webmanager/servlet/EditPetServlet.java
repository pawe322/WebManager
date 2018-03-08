package com.pawe322.webmanager.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pawe322.webmanager.beans.Pet;
import com.pawe322.webmanager.utils.DBUtils;
import com.pawe322.webmanager.utils.MyUtils;

@WebServlet(urlPatterns = { "/editProduct" })
public class EditPetServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditPetServlet() {
        super();
    }
 
    // Show product edit page.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
        String name = (String) request.getParameter("name");
        Pet pet = null;
        String errorString = null;
 
        try {
            pet = DBUtils.findPet(conn, name);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && pet == null) {
            response.sendRedirect(request.getServletPath() + "/productList");
            return;
        }
 
        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", pet);
        RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editPetView.jsp");
        dispatcher.forward(request, response);
    }
 
    // After the user modifies the product information, and click Submit.
    // This method will be executed.
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection conn = MyUtils.getStoredConnection(request);
 
        String name = (String) request.getParameter("name");
        String typeOfAnimal = (String) request.getParameter("typeOfAnimal");
        String ageStr = (String) request.getParameter("age");
        String heightStr = (String) request.getParameter("height");
        int age = 0;
        int height = 0;
        try {
            age = Integer.parseInt(ageStr);
            height = Integer.parseInt(heightStr);
        } catch (Exception e) {
        }
        
        Pet pet = new Pet(name, typeOfAnimal, age, height);
 
        String errorString = null;
 
        try {
            DBUtils.updatePet(conn, pet);
        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
        // Store infomation to request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("pet", pet);
 
        // If error, forward to Edit page.
        if (errorString != null) {
            RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/WEB-INF/views/editPetView.jsp");
            dispatcher.forward(request, response);
        }
        // If everything nice.
        // Redirect to the product listing page.
        else {
            response.sendRedirect(request.getContextPath() + "/petList");
        }
    }
 
}