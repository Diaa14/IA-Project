<%-- 
    Document   : profile
    Created on : Dec 20, 2019, 10:51:18 PM
    Author     : Diaa Mamdouh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile Page</title>
    </head>
    <body>
        <%
        try{
        Class.forName("org.mariadb.jdbc.Driver");
        Connection con =(Connection) DriverManager.getConnection("jdbc:mariadb://localhost/project", "root", "");
        PreparedStatement ps = con.prepareStatement("SELECT  * FROM candidate WHERE username = ?");
        ps.setString(1,request.getParameter("username"));
        ResultSet res = ps.executeQuery();
        if(res.first()){
        out.print("User already exists");
         }
        else{
                out.print("User name is valid");
            }
        }catch (Exception e){
            System.out.println(e);  
        }
         %>   
    </body>
</html>
