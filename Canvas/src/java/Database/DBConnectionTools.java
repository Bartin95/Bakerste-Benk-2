/*
 * This class contains all methods needed to handle the database-
 * connection. 
 */
package Database;

import java.io.PrintWriter;
import java.sql.*; 
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author anette jorgensen
 * @date 9.09.2018
 */
public class DBConnectionTools {
    Connection conn;
    Statement st;
    
    /**
     * Some sort of comment
     * @param out
     * @return 
     */
    
    public Connection getConnection(PrintWriter out){
        try {
            Context cont = new InitialContext();
            DataSource ds =(DataSource)cont.lookup("java:comp/env/jdbc/localhostDS");
            conn = ds.getConnection();
            return conn;
        }
        catch(SQLException ex) {
            out.println("Not connected to database" + ex);
        }
        catch(NamingException nex){
            out.println("Not correct naming" + nex);
        }
        return null;
        }
    
    /**
     * Some comment about code below
     */
    
    public void close() {
        try {
            conn.close();
        }
        catch (SQLException ex) {
            System.out.println("Database not closed" + ex);
        }
    }
    
    
    /**
     * Some comment on code below
     */
    public void commit(){
        try {
            conn.commit();
        }
        catch (SQLException ex){
            System.out.println("Commit not successful" + ex);
        }
    }
        
        
        
                
    
    
   
    
    
    
    
}
