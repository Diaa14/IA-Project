<%-- 
    Document   : showQuestions
    Created on : Dec 23, 2019, 2:50:48 AM
    Author     : Diaa Mamdouh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
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
        <td>question id</td>
        <td>text</td>
        <td>exam id</td>
        </tr>
<%
    try
    {

    Class.forName("org.mariadb.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/project", "root", "");
    Statement st=conn.createStatement();
    String query="select * from question";
    ResultSet rs=st.executeQuery(query);
    while (rs.next()){
    %>
    <tr>
    <td><%=rs.getString("question_id") %></td>
    <td><%=rs.getString("text") %></td>
    <td><%=rs.getString("exam_id") %></td>
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
