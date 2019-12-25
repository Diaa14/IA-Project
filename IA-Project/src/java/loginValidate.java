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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Diaa Mamdouh
 */
@WebServlet(urlPatterns = {"/loginValidate"})
public class loginValidate extends HttpServlet {

protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
response.setContentType("text/html;charset=UTF-8");
try (PrintWriter out = response.getWriter()) {
        String username=request.getParameter("username");
        String Pass=request.getParameter("Pass");
            try{
                if(username!=null){
                    Class.forName("org.mariadb.jdbc.Driver").newInstance();
                    Connection con=DriverManager.getConnection("jdbc:mariadb://localhost/project","root","");
                    String query="Select * from candidate where username=? and password=?";
                    PreparedStatement st=con.prepareStatement(query);
                    st.setString(1,username);
                    st.setString(2,Pass);
                    ResultSet rs=st.executeQuery();
                    if(rs.next()){
                        System.out.println("Inserted Successfully");
                        HttpSession SData = request.getSession(true);
                        SData.setAttribute("username", username);
                        response.sendRedirect("account.jsp");
                    }else{
                    
                        out.println("The ID or Password is not correct..Please Try Again");
                        response.sendRedirect("login.jsp");
                    }
                        
                }

                
            }
            catch(Exception e){
                out.println("Exception :"+e.getMessage());
            }        }
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
