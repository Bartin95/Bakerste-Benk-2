/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import java.io.Serializable;

/**
 *
 * @author anette jorgensen
 */
public class Module implements Serializable{
    
    private String id;
    private String title;
    private String description;
    
    public Module(){
    }
    
    public Module (String id,String title,String description){
        this.id = id;
        this.title = title;
        this.description = description;
    }
                

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
    
}
