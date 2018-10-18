/*
 * Redirected to this servlet from the index page. 
 *  
 *  
 */
package servlets;

import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nicolai Øie
 */
@WebServlet(name = "hentModul", urlPatterns = {"/hentModul"})
public class hentModul extends HttpServlet {

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
            out.println("<title>Servlet hentModul</title>");            
            out.println("</head>");
            out.println("<body>");
            
    
        out.println("<h1><b> Se moduler og læringsmål <b>  </h1>");
    
        
        out.println("<form action=\"hentModulFradb\" method=\"post\">");
        
        out.println("<input type=\"Submit\" name=\"valg\" value=\"Learning Resources\">");   
        
        
        out.println("<h1><b> Endre læringsmål <b>  </h1>");
    
        
        out.println("<form action=\"CreateLearningResourcesServlet\" method=\"post\">");
        
        out.println("<input type=\"Submit\" name=\"valg\" value=\" Edit Learning Resources\">");    
        
        
       
    
                   
            out.println("<h1> Trykk her for å endre, og HER for å publisere </h1>");
            // legg til funksjon for endring, og fiks på design
            
              out.println("<input type=\"Submit\" name=\"valg\" value=\"Endre i database\">");  
            
            
            
            
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