/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Diaa Mamdouh
 */
@WebServlet(name = "validateHR", urlPatterns = {"/validateHR"})
public class validateHR extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String _username=request.getParameter("username");
            String _Pass=request.getParameter("Pass");
            try{
                if(_username!=null){
                    Class.forName("org.mariadb.jdbc.Driver").newInstance();
                    Connection con=DriverManager.getConnection("jdbc:mariadb://localhost:3306/project","root","");
                    String query="Select * from HR where username=? and Pass=?";
                    PreparedStatement st=con.prepareStatement(query);
                    st.setString(1,_username);
                    st.setString(2,_Pass);
                    ResultSet rs=st.executeQuery();
                    if(rs.next()){
                    HttpSession SData = request.getSession(true);
                    if (SData.isNew()==false){
                        SData.invalidate();
                        SData=request.getSession(true);
                    }
                    SData.setAttribute("username", _username);
                    SData.setAttribute("Pass", _Pass);
                    response.sendRedirect("HR.jsp");
                    }
                    else{
                        out.println("The ID or Password is not correct..Please Try Again");
                        response.sendRedirect("HRlogin.jsp");
                    }
                        
                }

                
            }
            catch(Exception e){
                out.println("Exception :"+e.getMessage());
            }
        }
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
}
