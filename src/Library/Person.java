package Library;

/**
 *
 * @author jivin javap
 */
public class Person {
    
    private String fname, lname, address;
    private int id;
   
    Person() {
        this.fname = "";
        this.lname ="";
        this.address = "";
        this.id = 0;
    }
    
    Person(String fname, String lname, String address, int id) {
         
            this.fname = fname;
            this.lname = lname;
            this.address = address; 
            this.id = id;
    }
    
//setters    
    public void setFname(String fname) {
        
        this.fname = fname;
    }
    public void setLname(String lname) {
        
        this.lname = lname;
    }
    public void setAddress(String address) {
        
        this.address = address;
    }
    public void setId(int id) {
        
        this.id = id;
    }

//getters
    
    public String getFname() {
        
        return fname;
    } 
    public String getLname() {
        
        return lname;
    } 
    public String getAddress() {
        
        return address;
    } 
    public int getId() {
        
        return id;
    } 
    
@Override
    public String toString() {
        
        return "First Name: " + fname + "/n" + 
               "Last Name: " + lname+ "/n" + 
               "Address: " + address + "/n" + 
               "ID: " + id + "/n"; 
    }
   
    
}
