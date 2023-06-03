package ReaderWriter;

import Library.Subject;
import Library.SubjectCRUD;
import Library.Teacher;
import Library.TeacherAssignment;
import Library.TeacherAssignmentCRUD;
import Library.TeacherCRUD;
import Test.Sanitize;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class TeacherAssignmentRW {

    private final String filename;

    public TeacherAssignmentRW(String filename){
        this.filename = filename;
    }
    //reader
    public void read(TeacherAssignmentCRUD tac, TeacherCRUD tc, SubjectCRUD sc){
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = bufferedreader.readLine()) != null){
                if(line.isEmpty() || line.isBlank() || line.charAt(0) == ';'){continue;}
                String[] arr = line.split(";");
                
                Teacher teacher = null;
                Subject subject = null;
                
                int teachid = Integer.parseInt(Sanitize.sanitize(arr[0]));
                for(Teacher t : tc.teacherList){
                    if(t.getId() == teachid) teacher = t;
                }
                
                String subid = Sanitize.sanitize(arr[1]);
                for(Subject sub : sc.subjectlist){
                    if(sub.getTitlecode().equals(subid)) subject = sub;
                }
                
                TeacherAssignment ta = new TeacherAssignment(teacher, subject);
                tac.createAssignment(ta);
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Reading File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);}
    }

    //writer
    public void write(TeacherAssignmentCRUD tac){
        try (FileWriter filewriter = new FileWriter(filename)) {
            for(TeacherAssignment ta : tac.TAList){
                filewriter.write(
                        ta.getTeacher().getId() + ";" + 
                        Sanitize.sanitize(ta.getSubject().getTitlecode()) + System.lineSeparator());}
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Updating File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);}
    }  
}
