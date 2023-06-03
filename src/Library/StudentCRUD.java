package Library;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class StudentCRUD {
    
    public ArrayList <Student> studentList = new ArrayList();
        
    public StudentCRUD() {
        studentList = new ArrayList();
    }
    
    public void studentCreate(Student student) {
        
        studentList.add(student);
    }
    
    public Student studentRetrieve(Student student) {
        
        for (Student s : studentList) {
                if (s.equals(student)) return s;
        }
        return null;
    }
    
    public void studentUpdate (Student student, Student newStudent) {
        
        Student tempStudent = studentRetrieve(student);
            if (tempStudent != null) {
                tempStudent.setFname(newStudent.getFname()); 
                tempStudent.setLname(newStudent.getLname());
                tempStudent.setAddress(newStudent.getAddress());
                tempStudent.setId(newStudent.getId());
                tempStudent.setCourse(newStudent.getCourse());
                tempStudent.setYearlevel(newStudent.getYearlevel());
            }
    }      
    
    public void studentDelete(Student student) {
        
        boolean found = false;
            for (int i = 0; i < studentList.size() && found !=true; i++) {
                found = studentList.get(i).equals(student);
                    if (found) {
                       studentList.remove(i);
                        return;
                    }
            }
    }
    
@Override
    public String toString(){
        String str = "";
            for (Student student: studentList){
                str += (student.getFname() + ";" + student.getLname() + ";" + student.getAddress() + ";" + student.getId() + student.getCourse() + student.getYearlevel() + "\n" );
            }
            return str;
    }
           
}
