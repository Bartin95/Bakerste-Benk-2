/*
 * This class handles all queries to the database
 */
package Database;

import Classes.Module;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author anette jorgensen
 */
public class ModQuery {
    Connection conn;
    Statement stmt;
    
       
    /**
     * This method will add a module to the database
     * 
     * @author Anette Jørgensen
     * @param m - Module object
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
     * This method will retrive all module-details from the database, store the
     * information in module-ojects and add the objects to a linked list.
     * 
     * @author Anette Jørgensen
     * @param conn
     * @param out
     * @return - returns a linked list
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
     * This method will get all module details for one individual module.
     * 
     * @author Anette Jørgensen
     * @param id - module ID
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
     * This method will add the edited information to the database
     * 
     * @author Anette Jørgensen
     * @param id - module ID
     * @param title - module title
     * @param description - module description
     * @param req - learning requirements for the module
     * @param points - total points possible for the module
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
     * This method will delete a module from the database
     * 
     * @author Anette Jørgensen
     * @param id - module ID
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
      
  
   
}

