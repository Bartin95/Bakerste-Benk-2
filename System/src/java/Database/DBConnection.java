/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author anette jorgensen
 */
public class DBConnection {
    Connection conn;
    Statement st;
    
    /**
     * This method get the connection to the database
     * @author Anette Jørgensen
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
     * This method closes the connection to the database.
     * 
     * @author Anette Jørgensen
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
     * This method commits data to the database
     * @author Anette Jørgensen
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
