<%-- 
    Document   : showExams
    Created on : Dec 22, 2019, 10:30:22 PM
    Author     : Diaa Mamdouh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <br><br><br><br>
        <div align="center">
        <table border="1">
        <tr>
        <td>exam id</td>
        <td>exam name</td>
        <td>exam topic</td>
        </tr>
<%
    try
    {

    Class.forName("org.mariadb.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/project", "root", "");
    Statement st=conn.createStatement();
    String query="select * from exam";
    ResultSet rs=st.executeQuery(query);
    while (rs.next()){
    %>
    <tr>
    <td><%=rs.getString("exam_id") %></td>
    <td><%=rs.getString("exam_name") %></td>
    <td><%=rs.getString("exam_topic") %></td>
    </tr>
    </div>
    <%}
    
    }
    catch(Exception e)
    {
    System.out.print(e);
    e.printStackTrace();
    }
   
%>
    </body>
</html>
