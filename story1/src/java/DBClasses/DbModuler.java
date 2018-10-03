
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
 * @author Nicolai Øie
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
 
            
                // FINN UT HVORDMAN MAN ENDRER LIVE I SIDEN!
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
   
public void newLearningResource(String Moduler,String resources,PrintWriter out, Connection conn) {
        PreparedStatement newLearningResource;
        out.println(" Create Learning resources " + Moduler);
        
        try {
            String ins = "insert into prac1.modulerlearning(Moduler,resources) values(?,?)";
            newLearningResource = conn.prepareStatement(ins);
            
            newLearningResource.setString(1,Moduler);
            newLearningResource.setString(2,resources);
            
            
            out.println(newLearningResource);
            newLearningResource.executeUpdate();
        }
        catch (SQLException ex) {
            out.println("New learning resource not created" + ex);
        }
    }
}

    
