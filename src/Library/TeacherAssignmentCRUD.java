package Library;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class TeacherAssignmentCRUD {
    
        public ArrayList<TeacherAssignment> TAList;    
        
        public TeacherAssignmentCRUD() {
            
            this.TAList = new ArrayList<>();
        }
        
        public void createAssignment(TeacherAssignment assignment) {
            
            TAList.add(assignment);
        }
        
        public TeacherAssignment retrieveAssignment(Teacher teacher, Subject subject) {

            for(TeacherAssignment assignment: TAList){
                if(assignment.getTeacher().equals(teacher) && assignment.getSubject().equals(subject)) 
                
                return assignment;            
            
            }
                return null;
        }

        public void updateAssignment(TeacherAssignment oldAssignment, TeacherAssignment newAssignment){
                
            TeacherAssignment tempAssignment = retrieveAssignment(oldAssignment.getTeacher(), oldAssignment.getSubject());
                if(tempAssignment != null){
                    tempAssignment.setTeacher(newAssignment.getTeacher());
                    tempAssignment.setSubject(newAssignment.getSubject());
                }
            }        

        public void deleteAssignment(TeacherAssignment assignment){
                
                boolean found = false;
                    for(int i = 0; i < TAList.size(); i++){
                        found = TAList.get(i).equals(assignment);
                            if (found){
                                TAList.remove(i);
                                    return;
                    }
                }
        }     
 
@Override
       public String toString() {
           
           StringBuilder str = new StringBuilder();
                for (TeacherAssignment assignment : TAList){
                    str.append("Teacher: ").append(assignment.getTeacher().getFname()).append(" ").append(assignment.getTeacher().getLname()).append("\n");
                    str.append("Subject: ").append(assignment.getSubject().getTitlecode()).append("\n\n");
           }
           return str.toString();
       }        
        

}
