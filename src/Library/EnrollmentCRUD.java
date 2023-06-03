package Library;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class EnrollmentCRUD {
    

    public ArrayList<SubjectEnrolled> enlist;
    
    public EnrollmentCRUD(){
        enlist = new ArrayList<SubjectEnrolled>();
    }
    
    public void createSE(SubjectEnrolled se){
        enlist.add(se);
    }
    
    public SubjectEnrolled retrieveSE(SubjectEnrolled se){
        
        for(SubjectEnrolled s: enlist){
            if(s.equals(se)) return s;
        }
        return null;
    }
    
    public void updateSE(SubjectEnrolled se, SubjectEnrolled newse){
        
        SubjectEnrolled tempSE = retrieveSE(se);
            if(tempSE != null){
                tempSE.setSubject(newse.getSubject());
                tempSE.setStudent(newse.getStudent());
                tempSE.setTeacher(newse.getTeacher());
                tempSE.setGrade(newse.getGrade());
            }
    }
    
    public void deleteSE(SubjectEnrolled se){
        
        boolean found = false;
            for(int i = 0; i < enlist.size() && found != true; i++){
                found = enlist.get(i).equals(se);
                    if (found){
                        enlist.remove(i);
                        return;
                    }
            }
    }
    
    public ArrayList<SubjectEnrolled> getClassList(Subject sub){
        
        ArrayList<SubjectEnrolled> tempCL = new ArrayList<SubjectEnrolled>();
            for(SubjectEnrolled se : enlist){
                if(se.getSubject().equals(sub)) tempCL.add(se);
            }
            return tempCL;
    }
    
    public ArrayList<SubjectEnrolled> getSubjectsEnrolled (Student stud){
        
        ArrayList<SubjectEnrolled> tempCL = new ArrayList<SubjectEnrolled>();
            for(SubjectEnrolled se : enlist){
                if(se.getStudent().equals(stud)) tempCL.add(se);
            }
            return tempCL;
    }
    
    public ArrayList<SubjectEnrolled> getFacultyLoad (Teacher t){
        
        ArrayList<SubjectEnrolled> tempCL = new ArrayList<SubjectEnrolled>();
            for(SubjectEnrolled se : enlist){
                if(se.getTeacher().equals(t)) tempCL.add(se);
        }
        return tempCL;
    }
    
    @Override
    public String toString(){
       
        String str = "";
            for (SubjectEnrolled se: enlist){
                str += (se.getSubject().getTitlecode() + ";" + se.getStudent().getId() + ";" + se.getTeacher().getId() + ";" + se.getGrade() + "\n");
            }
            return str;
    }
        
}
