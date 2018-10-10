/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author anette jorgensen
 */
public class Deliverable {
    private int del_ID;
    private String del_description;
    private String del_feedback;
    private int del_points;
    private String del_status;
    private int mod_ID;

    public Deliverable(int del_ID, String del_description, String del_feedback, int del_points, String del_status, int mod_ID) {
        this.del_ID = del_ID;
        this.del_description = del_description;
        this.del_feedback = del_feedback;
        this.del_points = del_points;
        this.del_status = del_status;
        this.mod_ID = mod_ID;
    }
    
    public int getMod_ID() {
        return mod_ID;
    }

    public void setMod_ID(int mod_ID) {
        this.mod_ID = mod_ID;
    }
   

    public int getDel_ID() {
        return del_ID;
    }

    public void setDel_ID(int del_ID) {
        this.del_ID = del_ID;
    }

    public String getDel_description() {
        return del_description;
    }

    public void setDel_description(String del_description) {
        this.del_description = del_description;
    }

    public String getDel_feedback() {
        return del_feedback;
    }

    public void setDel_feedback(String del_feedback) {
        this.del_feedback = del_feedback;
    }

    public int getDel_points() {
        return del_points;
    }

    public void setDel_points(int del_points) {
        this.del_points = del_points;
    }

    public String getDel_status() {
        return del_status;
    }

    public void setDel_status(String del_status) {
        this.del_status = del_status;
    }
    
}
