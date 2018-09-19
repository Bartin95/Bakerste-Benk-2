/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import java.io.PrintWriter;
import java.sql.*; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author glenn
 */
public class Tools {
    Connection conn; 
    Statement stmt;
    
     public void printUsers(PrintWriter out)
    { 
         String strSelect = "select * from users";


         
         System.out.println();
         out.println();
         
         try {
             
                ResultSet rset = stmt.executeQuery(strSelect);
 
                // Step 4: Process the ResultSet by scrolling the cursor forward via next().
                //  For each row, retrieve the contents of the cells with getXxx(columnName).
                out.println("Students in class:" +"<br>");
                int rowCount = 0;
                while(rset.next()) {   // Move the cursor to the next row, return false if no more row
                    String fname = rset.getString("fname");
                    String lname = rset.getString("lname");
                    String  cus_email  = rset.getString("cus_email");
                    out.println(rowCount +": " + fname + ", " + lname + ", " + cus_email +"<br>");
                    ++rowCount;
                 }  // end while
                 out.println("Number of students: " + rowCount);
         } // end catch     
         catch (SQLException ex) {
                out.println("Ikke hentet fra DB " +ex);
         }
   }
    
    
   // @Resource DataSource LocalhostDS;
    public void loggInn2(PrintWriter out) {
        try {
         // Step 1: Allocate a database 'Connection' object
         Context cont = new InitialContext();
         DataSource ds = (DataSource)cont.lookup("java:comp/env/jdbc/localhostDS");  
         //DataSource ds = (DataSource)cont.lookup("jdbc/LocalhostDS");
         conn =  ds.getConnection();
 
         // Step 2: Allocate a 'Statement' object in the Connection
         stmt = conn.createStatement();
        }
        catch (SQLException ex ) {
            out.println("Not connected to database " +ex);
        }
        catch (NamingException nex) {
            out.println("Not correct naming" + nex);
        }
            
            
    }
    
}
