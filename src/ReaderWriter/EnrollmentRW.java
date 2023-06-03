
package ReaderWriter;

import Library.EnrollmentCRUD;
import Library.Student;
import Test.Sanitize;
import Library.StudentCRUD;
import Library.Subject;
import Library.SubjectCRUD;
import Library.SubjectEnrolled;
import Library.Teacher;
import Library.TeacherCRUD;
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
public class EnrollmentRW {
    
    
    private final String filename;

    public EnrollmentRW(String filename){
        this.filename = filename;
    }
    //reader
    public void read(EnrollmentCRUD enrollment, SubjectCRUD subc, TeacherCRUD tc, StudentCRUD sc){
       
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))){
            String line;
                while((line = bufferedreader.readLine()) != null){
                    if(line.isEmpty() || line.isBlank() || line.charAt(0) == ';'){continue;}
                        String[] arr = line.split(";");
                
                Subject subject = null;
                Student student = null;
                Teacher teacher = null;
                
                String subid = Sanitize.sanitize(arr[0]);
                    for(Subject sub : subc.subjectlist) {
                        if(sub.getTitlecode().equals(subid)) subject = sub;
                    }
                    
                int studId = Integer.parseInt(Sanitize.sanitize(arr[1]));
                    for(Student stud : sc.studentList) {
                        if(stud.getId() == studId) student = stud;
                    }
                
                int teachId = Integer.parseInt(Sanitize.sanitize(arr[2]));
                    for(Teacher t : tc.teacherList) {
                        if(t.getId() == teachId) teacher = t;
                    }
                
                Double grade = Double.valueOf(Sanitize.sanitize(arr[3]));
                
                SubjectEnrolled se = new SubjectEnrolled(subject, student, teacher, grade);
                enrollment.createSE(se);
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Reading File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    //writer
    public void write(EnrollmentCRUD enrollment){
        
        try (FileWriter filewriter = new FileWriter(filename)) {
            for(SubjectEnrolled se : enrollment.enlist){
                filewriter.write(
                        Sanitize.sanitize(se.getSubject().getTitlecode()) + ";" + 
                        se.getStudent().getId() + ";" + 
                        se.getTeacher().getId() + ";" + 
                        se.getGrade() + System.lineSeparator());
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Updating File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
        
    
}
