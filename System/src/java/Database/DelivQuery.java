/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Classes.Deliverable;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

/**
 *This class handles all queries to database for the deliverable data
 * 
 * @author anett
 */
public class DelivQuery {
    Connection conn;
    Statement stmt;
    
    public void addDeliverable(Deliverable d, PrintWriter out, Connection conn) throws SQLException  {
        PreparedStatement ps;
        try {
            String ins = "insert into deliverables(del_ID, del_description, del_feedback, del_points, del_status,  mod_ID) values (?,?,?,?,?,?)";
            ps = conn.prepareStatement(ins);
            
            ps.setInt(1,d.getDel_ID());
            ps.setString(2,d.getDel_description());
            ps.setString(3,d.getDel_feedback());
            ps.setInt(4,d.getDel_points());
            ps.setString(5,d.getDel_status());
            ps.setInt(6,d.getMod_ID());
            ps.executeUpdate();
        }
        catch(SQLException ex){
            out.println("New deliverable not added" + ex);
        }
    }
    
    public List <Deliverable> getAllDel(Connection conn, PrintWriter out) throws SQLException {
        List<Deliverable> ls = new LinkedList<>();
        PreparedStatement ps;
        
        try {
            ps = conn.prepareStatement("select * from deliverables");
            ResultSet rset = ps.executeQuery();
            
            while(rset.next()){
                Deliverable d = new Deliverable(rset.getInt(1), rset.getString(2),rset.getString(3), rset.getInt(4), rset.getString(5), rset.getInt(6));
                ls.add(d);
            }
        }
        catch(SQLException ex) {
            out.println("No deliverable found" + ex);
        }
        return ls;
    }
}
                    
            
        
    
    
    
