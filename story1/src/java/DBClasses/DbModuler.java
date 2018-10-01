
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

JDBC JNDI DataSource Servlet
 */
package DBClasses;

import java.io.PrintWriter;
import java.sql.*; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/**
 *
 * @author hallgeir
 */
public class DbModuler {
    Statement stmt;
    
    public void printModules(PrintWriter out, Connection conn)
    { 
         String strSelect = "select * from modulerlearning";

         System.out.println("Her er modulene og læringsmål: " + strSelect); // Echo For debugging
         
         
        
 
         try {
             
             stmt = conn.createStatement();   
             ResultSet rset = stmt.executeQuery(strSelect);
 
                // Step 4: Process the ResultSet by scrolling the cursor forward via next().
                //  For each row, retrieve the contents of the cells with getXxx(columnName).
                // FINN UT HVORDMAN MAN ENDRER LIVE I SIDEN!
                out.println("Her er modulene, og deres læringsmål, trykk her for å endre:" +"<br>");
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
   
}// slutt 
    
