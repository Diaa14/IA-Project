/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

/**
 *
 * @author Diaa Mamdouh
 */
@WebServlet(urlPatterns = {"/SignUpValidate"})
@MultipartConfig
public class SignUpValidate extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String _username=request.getParameter("username");
            String _email=request.getParameter("email");
            String _mobile=request.getParameter("mobile");
            String _Pass=request.getParameter("Pass");
           
            
           
            InputStream  inputstream=null;
            Part filepart=request.getPart("Upload");
            if(filepart!=null)
            {
            inputstream=filepart.getInputStream();
            }
            
            
            try{
            Class.forName("org.mariadb.jdbc.Driver").newInstance();
            String url="jdbc:mariadb://localhost:3306/project";
            String username="root";
            String password="";
            Connection conn;
            conn = DriverManager.getConnection(url, username, password);
            
             
            String query="INSERT INTO candidate (username,email,mobile,password,cv,Approvment,aPosition) values (?,?,?,?,?,?,?)";
            PreparedStatement st=conn.prepareStatement(query);
            st.setString(1,_username);
            st.setString(2,_email);
            st.setString(3,_mobile);
            st.setString(4,_Pass);
            if (inputstream !=null){
                st.setBlob(5, inputstream);
            }
            st.setString(6, "");
            st.setString(7, "");
            int i=st.executeUpdate();
            if (i>0){
                System.out.println("Inserted");
            }
             
            
            System.out.println("Inserted Successfully");
            HttpSession SData = request.getSession(true);
            SData.setAttribute("username", _username);
            response.sendRedirect("account.jsp");
            }
            catch(IOException | ClassNotFoundException | IllegalAccessException | InstantiationException | NumberFormatException | SQLException e)
            {
            System.out.print(e);
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
