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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Diaa Mamdouh
 */
@WebServlet(urlPatterns = {"/addAnswers"})
public class addAnswers extends HttpServlet {

    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
    String exam_id=request.getParameter("exam_id");
    String question_id=request.getParameter("question_id");
    String first_answer=request.getParameter("first_answer");
    int correct1=Integer.parseInt(request.getParameter("correct1"));
    String second_answer=request.getParameter("second_answer");
    int correct2=Integer.parseInt(request.getParameter("correct2"));
    String third_answer=request.getParameter("third_answer");
    int correct3=Integer.parseInt(request.getParameter("correct3"));
    
    
    try
    {
        
        Class.forName("org.mariadb.jdbc.Driver");
        Connection conn2 = DriverManager.getConnection("jdbc:mariadb://localhost/project", "root", "");
        Statement st1=conn2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        st1.executeUpdate("insert into answer (text,correct,question_id,exam_id) values ('"+first_answer+"','"+correct1+"','"+question_id+"','"+exam_id+"')");
        st1.executeUpdate("insert into answer (text,correct,question_id,exam_id) values ('"+second_answer+"','"+correct2+"','"+question_id+"','"+exam_id+"')");
        st1.executeUpdate("insert into answer (text,correct,question_id,exam_id) values ('"+third_answer+"','"+correct3+"','"+question_id+"','"+exam_id+"')");
        
        
    
    response.sendRedirect("HR.jsp");
    }
    catch(Exception e)
    {
    System.out.print(e);
    e.printStackTrace();
    }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
