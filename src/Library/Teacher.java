package Library;

import java.util.Objects;
/**
 *
 * @author admin
 */
public class Teacher extends Person {
    
    String rank, designation;
    
    public Teacher() {
        
        super();
        this.rank = "";
        this.designation = "";
        
    }
    
    public Teacher(String fname, String lname, String address, int id, String rank, String designation) {
         
            super(fname, lname, address,id);
            this.rank = rank; 
            this.designation = designation;
    }
    
//setters
    
    public void setRank(String rank) {
        
            this.rank = rank;
    }
    public void setDesignation(String designation) {
        
            this.designation = designation;
    }
    
//getters
    
    public String getRank() {
        
            return rank;
    }
    public String getDesignation() {
        
            return designation;
    }
    
    @Override
    public boolean equals(Object obj) {
        
        if (this == obj) {
            return true;
        }
            if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Teacher teacher = (Teacher) obj;
            return  Objects.equals(super.getFname(), teacher.getFname()) &&
                    Objects.equals(super.getLname(), teacher.getLname()) &&
                    Objects.equals(super.getAddress(), teacher.getAddress()) &&
                    Objects.equals(super.getId(), teacher.getId()) &&
                    Objects.equals(rank, teacher.rank) &&
                    Objects.equals(designation, teacher.designation);
    }
@Override
    public int hashCode() {
        
        return Objects.hash(super.getFname(), super.getLname(), super.getAddress(), super.getId(), rank, designation);
    }
        
}