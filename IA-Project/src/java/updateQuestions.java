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
@WebServlet(urlPatterns = {"/updateQuestions"})
public class updateQuestions extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
    int exam_id=Integer.parseInt(request.getParameter("exam_id"));
    String first_question=request.getParameter("first_question");
    String second_question=request.getParameter("second_question");
    String third_question=request.getParameter("third_question");
    String forth_question=request.getParameter("forth_question");
    String fifth_question=request.getParameter("fifth_question");
    try
    {
        Class.forName("org.mariadb.jdbc.Driver");
        Connection conn2 = DriverManager.getConnection("jdbc:mariadb://localhost/project", "root", "");
        Statement st1=conn2.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
        st1.executeUpdate("update question set text='"+first_question+"'where exam_id='"+exam_id+"'");
        st1.executeUpdate("update question set text='"+second_question+"'where exam_id='"+exam_id+"'");
        st1.executeUpdate("update question set text='"+third_question+"'where exam_id='"+exam_id+"'");
        st1.executeUpdate("update question set text='"+forth_question+"'where exam_id='"+exam_id+"'");
        st1.executeUpdate("update question set text='"+fifth_question+"'where exam_id='"+exam_id+"'");
        
        
    
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
