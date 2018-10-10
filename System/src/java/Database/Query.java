/*
 * This class handles all queries to the database
 */
package Database;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author anette
 */
public class Query {
    Connection conn;
    Statement stmt;
    
    /**
     * This method will add a new module to the database
     * NB for now, it will only add module ID, title and a description
     * 
     * 
     * @param id - the id of the module
     * @param title - module title
     * @param description - a description of the module topic
     * @param out
     * @param conn 
     */
    public void newModule(String id,String title,String description, PrintWriter out, Connection conn) {
        PreparedStatement newModule;
        out.println(" Create module " + id);
        
        try {
            String ins = "insert into canvas.modules(id,title, moduledescription) values(?,?,?)";
            newModule = conn.prepareStatement(ins);
            
            newModule.setString(1,id);
            newModule.setString(2,title);
            newModule.setString(3, description);
            
            out.println(newModule);
            newModule.executeUpdate();
        }
        catch (SQLException ex) {
            out.println("New module not created" + ex);
        }
    }
    
    public void printModuleDetails(PrintWriter out, Connection conn){
        
        String MODULE ="<li><a href='modules?id=%s&title=%s&description=%s'>%s %s %s</a> </li>";       
       
        PreparedStatement getModules;
        
        try {
                      
            getModules = conn.prepareStatement("select* from modules order by ?");
            getModules.setString(1,"id");
            
            ResultSet rset = getModules.executeQuery();
            
                        
            out.println("The modules are:" + "<br>");
           
            while(rset.next()){
                String id = rset.getString("id");
                String title = rset.getString ("title");
                String description = rset.getString("moduledescription");               
                
                out.format(MODULE,id,title,description,id,title,description);
            }
           
        }
        catch (SQLException ex) {
            out.println("No success retrieving from DB " + ex);
        }
    }
    
   
    //printer ut learning resources 
   public void printResources(PrintWriter out, Connection conn)
    { 
         String strSelect = "select * from modulerlearning";

         System.out.println("Here are the learning resources for the modules: " + strSelect); // Echo For debugging
 
         try {
             
             stmt = conn.createStatement();   
             ResultSet rset = stmt.executeQuery(strSelect);
 
            
                
                out.println("Her er modulene, og deres læringsmål, trykk her for å endre:" +"<br>");
                int rowCount = 0;
                while(rset.next()) {   
                    String resources = rset.getString("resources");
                    out.println(rowCount +": " + resources + ", " +"<br>");
                    ++rowCount;
                 }  
         }     
         catch (SQLException ex) {
                out.println("Db funker desverre ikke" +ex);
         }
   }    
    
    
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

