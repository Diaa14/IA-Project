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
@WebServlet(urlPatterns = {"/updateExam"})
public class updateExam extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    try (PrintWriter out = response.getWriter()) {
    String exam_name=request.getParameter("exam_name");
    String exam_topic=request.getParameter("exam_topic");
    String NewExam_name=request.getParameter("NewExam_name");
    String NewExam_topic=request.getParameter("NewExam_topic");
    try
    {

    Class.forName("org.mariadb.jdbc.Driver");
    Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/project", "root", "");
    String query="update exam set exam_name=?,exam_topic=? where exam_name='"+exam_name+"' and exam_topic='"+exam_topic+"'" ; 
    PreparedStatement st=conn.prepareStatement(query);
    st.setString(1,NewExam_name);
    st.setString(2, NewExam_topic);
    int i=st.executeUpdate();
    if (i>0){
    out.println("Data is successfully updated!");
    response.sendRedirect("HR.jsp");
    }
    else{
        out.println("Data is not successfully updated!");
    }
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
