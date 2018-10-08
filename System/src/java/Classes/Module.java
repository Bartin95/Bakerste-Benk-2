/*
 * 
 */
package Classes;

//import java.sql.Date;

/**
 *
 * @author anette jorgensen
 * @date 3.10.2018
 */
public class Module {
    private int modID;
    private String modTitle;
    private String modDescription;
    private String modRequirements;
    private int modPoints;
    //private Date deadline;

    public Module(int modID, String modTitle, String modDescription, String modRequirements, int modPoints) {
        this.modID = modID;
        this.modTitle = modTitle;
        this.modDescription = modDescription;
        this.modRequirements = modRequirements;
        this.modPoints = modPoints;
    }

    public String getModRequirements() {
        return modRequirements;
    }

    public void setModRequirements(String modRequirements) {
        this.modRequirements = modRequirements;
    }

    public int getModPoints() {
        return modPoints;
    }

    public void setModPoints(int modPoints) {
        this.modPoints = modPoints;
    }

    public int getModID() {
        return modID;
    }

    public void setModID(int modID) {
        this.modID = modID;
    }

    public String getModTitle() {
        return modTitle;
    }

    public void setModTitle(String modTitle) {
        this.modTitle = modTitle;
    }

    public String getModDescription() {
        return modDescription;
    }

    public void setModDescription(String modDescription) {
        this.modDescription = modDescription;
    }
            
    
}
