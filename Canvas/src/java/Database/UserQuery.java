/*
 *This class handles all queries with regards to queries to the database
 */
package Database;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author anette jorgensen
 */
public class UserQuery {
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
            String ins = "insert into 202.modules(id,title, moduledescription) values(?,?,?)";
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
                
                
               
            }
        }
        catch (SQLException ex) {
            out.println("No success retrieving from DB " + ex);
        }
    }
}
           
            
           
       
    

            
        
    

        
    
    
   
   