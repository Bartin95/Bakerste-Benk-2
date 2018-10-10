
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Database.DBConnection;
import Database.Query;
import java.sql.Connection;

/**
 *
 * @author Nicolai Øie
 */
@WebServlet(name = "FetchLearningResources", urlPatterns = {"/fetchLearningResources"})
public class FetchLearningResources extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            
           out.println("<div class=container-fluid>");
       out.println("<div class=row>");
            out.println("<div class=col-md-2></div>");
           out.println("<div class=col-md-8 align=center>");
               out.println("<div class=container>");
               
              out.println("<table class=table table-striped>");
            
            
            out.println("<title>Servlet hentModulFradb</title>");            
            out.println("</head>");
            out.println("<body>");
            out.print("<br><a href=\"hentModul\"><button type=\"button\">Back</button></a>");
             out.print("<br><a href=\"dashboard.jsp\"><button type=\"button\">Back to dashboard</button></a>");
            
            out.println("<h1> Here are the learning resources for the different modules </h1>");
             out.print("<br><a href=\"€\"><button type=\"button\">Publish</button></a>");
            out.println("<h1> Press here to publish them to students </h1>");
            
            
            out.println("<body style='background-color:violet;'>");
            
            out.print("<br><a href=\"createLearningResources\"><button type=\"button\">Upload</button></a>");
            
           
            
            
            // finn ut hvordan det funker
            Connection conn;
            DBConnection login = new DBConnection();
            conn = login.getConnection(out);
            
            Query query = new Query();
            query.printModules(out,conn); 
            
  
                       
            out.println("</body>");
            out.println("</html>");
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
