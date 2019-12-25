/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diaa Mamdouh
 */
@WebServlet(urlPatterns = {"/position"})
public class position extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    String position=request.getParameter("position");
    out.print(position);
    try
    {
    Class.forName("org.mariadb.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/project", "root", "");
    String query = "insert into position (position_name,candidate_id) values ('"+position+"',111)";
    Statement st=conn.createStatement();
    st.executeUpdate(query);
    }
    catch(ClassNotFoundException | SQLException e)
    {
    
    }   catch (InstantiationException ex) {
            Logger.getLogger(position.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(position.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}