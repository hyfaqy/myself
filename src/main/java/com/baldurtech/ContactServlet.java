package com.baldurtech;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ContactServlet extends HttpServlet{
    public void doGet(HttpServletRequest request,HttpServletResponse response)
        throws IOException,ServletException{
        
        response.getWriter().println("ContactList");
        response.getWriter().println("Get contact by id " + request.getParameter("contactId"));
        
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        String sql = "select * from contact";
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/test?user=root&password=");
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            
            resultSet.next();
            response.getWriter().println(resultSet.getString("name"));
        } catch(SQLException sqle) {
            response.getWriter().println("Can not connect Database.");
            sqle.printStackTrace();
        }
        
        
    }
}