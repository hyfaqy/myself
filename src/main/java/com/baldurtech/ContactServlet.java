package com.baldurtech;

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ContactServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response)
		throws IOException,ServletException{
        if(request.getParameter("contactId") == null) {
            response.getWriter().println("Get all contacts.");
        } else {
            response.getWriter().println("Get contact by id:" + request.getParameter("contactId"));
     //       resultSet = statement.executeQuery("select * from contact where id = " + request.getParameter("contactId"));
            response.getWriter().println("Get contact by id:" + request.getParameter("contactId"));	
        
            try {
                Class.forName("com.sql.jdbc.Driver").newInstance();
            } catch (Exception ex){
                //handle the error
            }
            
            Connection connection = null;
            Statement statement = null;
            ResultSet resultSet = null;
            
            try {
            
                connection = DriverManager.getConnection("jdbc:mysql://localhost/baldurcontacts?user=baldurtech&password=");
                statement = connection.createStatement();
          
                if(resultSet.next()){
                    response.getWriter().println("Name:" + resultSet.getString("name"));
                    response.getWriter().println("Mobile:" + resultSet.getString("mobile"));
                    response.getWriter().println("Vpmn" + resultSet.getString("vpmn"));
                    response.getWriter().println("HomeAddress:" + resultSet.getString("home_address"));
                    response.getWriter().println("OfficeAddress:" + resultSet.getString("office_address"));
                    response.getWriter().println("Memo:" + resultSet.getString("memo"));
                    response.getWriter().println("Job:" + resultSet.getString("job"));
                    response.getWriter().println("JobLevel:" + resultSet.getString("job_level"));
                    response.getWriter().println("Email:" + resultSet.getString("email"));
                } else {
                    response.getWriter().println("Sorry,cantact can not founs!");
                }
            } catch(SQLException sqle) {
                response.getWriter().println("cannot connection DB");
                response.getWriter().println(sqle.getMessage());
                sqle.printStackTrace();
            }
            
            if (resultSet != null) {
                try {
                    resultSet.close();
                }catch (Exception ex){
                
                }
            }
            
            if (statement != null) {
                try {
                    statement.close();
                }catch (Exception ex){
                
                } 
                
            }
            
            if (connection != null) {
                try {
                    connection.close();
                }catch (Exception ex){
            
                } 
                
            }
        }
        
        
    }
}