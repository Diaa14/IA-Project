<%-- 
    Document   : account
    Created on : Dec 21, 2019, 1:25:21 AM
    Author     : Diaa Mamdouh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.String"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Account Page</title>
        
        <style>
            
            table tr td
            {
                border: 1px solid black;
                margin: 4px;
                background-color: aqua;
            }
         
            
            
            
            
            
         </style>
    </head>
    <body>
        <%String username = (String)session.getAttribute("username"); %>
        <table align="right">
            <tr>
                <td>Welcome <%= username%></td>
                <td><a href="index.html">LogOut</a></td>
                
            </tr>
           
                
            
                
        </table>
                <%
               ArrayList<String> arr=new ArrayList();
    try
    {
     
    Class.forName("org.mariadb.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/project", "root", "");
    Statement st=conn.createStatement();
    String query="select * from exam";
    ResultSet rs=st.executeQuery(query);
     while(rs.next())
          {
         arr.add(rs.getString(2));
          
         
          } 
    %> <form action="exam.jsp">
        <% for(int i=0;i<arr.size();i++)
      {
            %>
                    
   <li><input type="radio" name="exam"  value="<% out.println(arr.get(i));%>"><% out.println(arr.get(i));%></li>
                    
                  

                    
            
       
      <%}%>
      <input type="Submit" value="submit">
    </form> <%
  
    %>
    <% 
    
    }
    catch(Exception e)
    {
    System.out.print(e);
    e.printStackTrace();
    }
   
%>

                
        
    </body>
</html>
