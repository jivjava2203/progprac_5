package Library;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class TeacherCRUD {
  
    public ArrayList <Teacher> teacherList = new ArrayList();
        
    public TeacherCRUD() {
        teacherList = new ArrayList();
    }
    
    public void teacherCreate(Teacher teacher) {
        
        teacherList.add(teacher);
    }
    
    public Teacher teacherRetrieve(Teacher teacher) {
        
        for (Teacher t : teacherList) {
                if (t.equals(teacher)) return t;
        }
        return null;
    }
    
    public void teacherUpdate (Teacher teacher, Teacher newTeacher) {
        
        Teacher tempTeacher = teacherRetrieve(teacher);
            if (tempTeacher != null) {
                tempTeacher.setFname(newTeacher.getFname()); 
                tempTeacher.setLname(newTeacher.getLname());
                tempTeacher.setAddress(newTeacher.getAddress());
                tempTeacher.setId(newTeacher.getId());
                tempTeacher.setRank(newTeacher.getRank());
                tempTeacher.setDesignation(newTeacher.getDesignation());
            }
    }      
    
    public void teacherDelete(Teacher teacher) {
        
        boolean found = false;
            for (int i = 0; i < teacherList.size() && found !=true; i++) {
                found = teacherList.get(i).equals(teacher);
                    if (found) {
                       teacherList.remove(i);
                        return;
                    }
            }
    }
    
@Override
    public String toString(){
        String str = "";
            for (Teacher teacher: teacherList){
                str += (teacher.getFname() + ";" + teacher.getLname() + ";" + teacher.getAddress() + ";" + teacher.getId() + teacher.getRank() + teacher.getDesignation() + "\n" );
            }
            return str;
    }    
    
}
