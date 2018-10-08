/*
 * This class handles all queries to the database
 */
package Database;

import Classes.Module;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author anette jorgensen
 */
public class Query {
    Connection conn;
    Statement stmt;
    
       
    /**
     * 
     * 
     * @param m
     * @param out
     * @param conn
     * @throws SQLException 
     */
    
    public void addModule(Module m, PrintWriter out, Connection conn) throws SQLException{
        PreparedStatement ps;
        try {
            String ins = "insert into modules(mod_ID, mod_title, mod_description, mod_req,mod_point) values(?,?,?,?,?)";
            ps = conn.prepareStatement(ins);
            
            ps.setInt(1,m.getModID());
            ps.setString(2,m.getModTitle());
            ps.setString (3,m.getModDescription());
            ps.setString(4,m.getModRequirements());
            ps.setInt(5, m.getModPoints());
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            out.println("New module not added" + ex);
        }
        
    }
   
    /**
     * This method handles ...
     * @param conn
     * @param out
     * @return
     * @throws SQLException 
     */
    public List<Module> getAll(Connection conn, PrintWriter out) throws SQLException{
        List<Module> ls = new LinkedList<>();
       PreparedStatement ps;
                      
        try {
            ps = conn.prepareStatement("select* from modules");
            ResultSet rset = ps.executeQuery();
                       
            
            while(rset.next()){
                Module m = new Module(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4),rset.getInt(5));
                ls.add(m);
            }
        }
        catch (SQLException ex){
            out.println("No modules found" + ex);
        }
        return ls;
    }
    
    /**
     * COMMENT
     * @param id
     * @param conn
     * @param out
     * @return 
     */
    public List<Module> getModById(int id, Connection conn, PrintWriter out){
        List<Module> ls = new LinkedList<>();
        PreparedStatement ps;
                      
        try {
            ps = conn.prepareStatement("select* from modules where mod_ID = " + id);
            ResultSet rset = ps.executeQuery();
                       
            
            while(rset.next()){
                Module m = new Module(rset.getInt(1),rset.getString(2),rset.getString(3),rset.getString(4), rset.getInt(5));
                ls.add(m);
            }
        }
        catch (SQLException ex){
            out.println("No module found" + ex);
        }
        return ls;
    }
    
    /**
     * 
     * @param id
     * @param title
     * @param description
     * @param req
     * @param points
     * @param out
     * @param conn 
     */
    public void editModule(int id, String title, String description, String req, int points, PrintWriter out, Connection conn){
        PreparedStatement ps;
        try {
            String ins = "update modules set mod_ID = ?,mod_title=?, mod_description=?, mod_req=?, mod_point=? where mod_ID = ?";
            ps = conn.prepareStatement(ins);
            
            ps.setInt(1,id);
            ps.setString(2,title);
            ps.setString (3,description);
            ps.setString(4,req);
            ps.setInt(5,points);
            ps.setInt(6,id);
            ps.executeUpdate();
        }
        catch (SQLException ex) {
            out.println("Module not edited" + ex);
        }
        
    }
    
    /**
     * 
     * @param id
     * @param conn
     * @param out
     * @throws SQLException 
     */    
    public void deleteModule(int id, Connection conn, PrintWriter out) throws SQLException{
        PreparedStatement ps;
        try{
            String ins = "delete from modules where mod_ID = ?";
            ps = conn.prepareStatement(ins);
            
            ps.setInt(1, id);
            ps.executeUpdate();
        }
        catch (SQLException ex){
            out.println ("Module not deleted" + ex);
        }
    }     
      
  
    //printer ut learning resources 
    public void printLearningResources(PrintWriter out, Connection conn)
    { 
         String strSelect = "select * from modulerlearning";
         // 

         System.out.println("Her er læringsmålene for modulene: " + strSelect); // Echo For debugging
 
         try {
             
             stmt = conn.createStatement();   
             ResultSet rset = stmt.executeQuery(strSelect);
 
            
                // FINN UT HVORDMAN MAN ENDRER LIVE I SIDEN!
                out.println("Her er læringsmålene, trykk her for å endre:" +"<br>");
                int rowCount = 0;
                while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                    String resources = rset.getString("resources");
                    out.println(rowCount +": " + resources + ", " +"<br>");
                    ++rowCount;
                 }  // end while
         } // end catch     
         catch (SQLException ex) {
                out.println("Db funker desverre ikke" +ex);
         }
   }
    
    /**
     * Akka bakka
     * @param out 
     */
    
    public void printUsers(PrintWriter out) {
        String strSelect = "select * from users";

        System.out.println();
        out.println();

        try {

            ResultSet rset = stmt.executeQuery(strSelect);

            // Step 4: Process the ResultSet by scrolling the cursor forward via next().
            //  For each row, retrieve the contents of the cells with getXxx(columnName).
            int rowCount = 0;
            while (rset.next()) {   // Move the cursor to the next row, return false if no more row
                String fname = rset.getString("fname");
                String lname = rset.getString("lname");
                String cus_email = rset.getString("cus_email");
                String cus_phone = rset.getString("cus_phone");
                String user_ID = rset.getString("user_ID");

                out.println("<tr><td> <a href=\"" + user_ID + "#\">" + fname + " " + lname + "</a></td><td> " + cus_email + "</td><td>" + cus_phone + "</td></tr>");
                ++rowCount;
            }  // end while
            out.println("Number of students: " + rowCount);
        } // end catch     
        catch (SQLException ex) {
            out.println("Not from DB " + ex);
        }
    }
    
}

