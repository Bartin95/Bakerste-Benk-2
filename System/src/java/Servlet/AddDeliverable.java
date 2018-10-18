/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Classes.Deliverable;
import Database.DBConnection;
import Database.DelivQuery;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *This servlet retrieves data from the form "addDeliv" in the AddDeliverable.jsp
 * The data is stored in the database. 
 * 
 * @author anette jorgensen
 * @date 9.10.2018
 */
@WebServlet(name = "CreateDeliverableServlet", urlPatterns = {"/addDeliv"})
public class AddDeliverable extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            String idTemp = request.getParameter("del_id");
            int del_id = Integer.parseInt(idTemp);
            
            String mTemp = request.getParameter("mod_id");
            int mod_id = Integer.parseInt(mTemp);
            
            String del_description = request.getParameter("description");
            String feedback = request.getParameter("feedback");
            String pointTemp = request.getParameter("points");
            int points = Integer.parseInt(pointTemp);
            String status = request.getParameter("status");
            
            Deliverable d = new Deliverable(del_id,del_description,feedback,points,status,mod_id);
            
            DBConnection tool = new DBConnection();
            DelivQuery q = new DelivQuery();
            Connection conn = tool.getConnection(out);
            
            q.addDeliverable(d, out, conn);
           // response.sendRedirect("AllPost");
            tool.commit();
            tool.close();
            
            
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddDeliverable.class.getName()).log(Level.SEVERE, null, ex);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(AddDeliverable.class.getName()).log(Level.SEVERE, null, ex);
        }
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
