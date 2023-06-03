
package Library;

import java.util.ArrayList;

/**
 *
 * @author admin
 */
public class SubjectCRUD {
    
    public ArrayList<Subject> subjectlist;
    
    public SubjectCRUD(){
       
        subjectlist = new ArrayList<Subject>();
    }
    
    public void createSubject(Subject subject){
        
        subjectlist.add(subject);
    }
    
    public Subject retrieveSubject(Subject subject){
        
        for(Subject s: subjectlist){
            if(s.equals(subject)) return s;
        }
        return null;
    }
    
    public void updateSubject(Subject subject, Subject newsubject){
       
        Subject tempSubject = retrieveSubject(subject);
            if(tempSubject != null){
                tempSubject.setTitlecode(newsubject.getTitlecode());
                tempSubject.setDescription(newsubject.getDescription());
                tempSubject.setSched(newsubject.getSched());
                tempSubject.setUnit(newsubject.getUnit());

            }
    }
    
    public void deleteSubject(Subject subject){
        
        boolean found = false;
            for(int i = 0; i < subjectlist.size() && found != true; i++){
                found = subjectlist.get(i).equals(subject);
                    if (found){
                        subjectlist.remove(i);
                        return;
                    }
            }
    }
    
    @Override
    public String toString(){
        
        String str = "";
            for (Subject subject: subjectlist){
                str += (subject.getTitlecode() + ";" + subject.getDescription() + ";" + subject.getSched() + ";" + subject.getUnit() + "\n");
            }
            return str;
        }    
}
