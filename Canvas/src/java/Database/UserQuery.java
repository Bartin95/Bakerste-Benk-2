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
}
        
    
    
   
   