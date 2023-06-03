package Library;

import java.util.Objects;

/**
 *
 * @author admin
 */
public class Subject {
    
    private String titlecode, description, sched;
    private int unit;
   
    public Subject() {
        this.titlecode = "";
        this.description ="";
        this.sched = "";
        this.unit = 0;
    }
    
    public Subject(String titlecode, String description, String sched, int unit) {
         
            this.titlecode = titlecode;
            this.description= description;
            this.sched= sched; 
            this.unit = unit;
    }
    
//setters    
    public void setTitlecode(String titlecode) {
        
        this.titlecode = titlecode;
    }
    public void setDescription(String description) {
        
        this.description = description;
    }
    public void setSched(String sched) {
        
        this.sched = sched;
    }
    public void setUnit(int unit) {
        
        this.unit = 0;
    }

//getters
    
    public String getTitlecode() {
        
        return titlecode;
    } 
    public String getDescription() {
        
        return description;
    } 
    public String getSched() {
        
        return sched;
    } 
    public int getUnit() {
        
        return unit;
    } 
    
@Override
    public String toString() {
       
        return "Title code: " + titlecode + "\n" +
                "Description: " + description + "\n" +
                "Schedule: " + sched + "\n" +
                "Unit: " + unit + "\n";
    }

@Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Subject subject = (Subject) obj;
             return Objects.equals(getTitlecode(), subject.getTitlecode()) &&
                    Objects.equals(getDescription(), subject.getDescription()) &&
                    Objects.equals(getSched(), subject.getSched()) &&
                    Objects.equals(getUnit(), subject.getUnit());
    }
@Override
    public int hashCode() {
        
        return Objects.hash(getTitlecode(), getDescription(), getSched(), getUnit());
    }    
    
    
    
}
