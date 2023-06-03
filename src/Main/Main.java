
package Main;

import Library.*;
import ReaderWriter.*;

/**
 *
 * @author admin
 */
public class Main {
    
        public static void main(String[] args) {
        //Declare Variables
        SubjectCRUD sblist = new SubjectCRUD();
        StudentCRUD slist = new StudentCRUD();
        TeacherCRUD tlist = new TeacherCRUD();
        EnrollmentCRUD elist = new EnrollmentCRUD();
        TeacherAssignmentCRUD tslist = new TeacherAssignmentCRUD();
        
        EnrollmentRW enrollru = new EnrollmentRW("Enrollment.txt");
        StudentRW studentru = new StudentRW("Student.txt");
        SubjectRW subjectru = new SubjectRW("Subject.txt");
        TeacherRW teacherru = new TeacherRW("Teacher.txt");
        TeacherAssignmentRW tsru = new TeacherAssignmentRW("SubjectTeacher.txt");
        
        //Initialize Variables
        studentru.read(slist);
        subjectru.read(sblist);
        teacherru.read(tlist);
        enrollru.read(elist, sblist, tlist, slist);
        tsru.read(tslist, tlist, sblist);
        
        MainFrame main = new MainFrame(sblist, slist, tlist, elist, enrollru, studentru, subjectru, teacherru, tslist, tsru);
        main.setVisible(true);
    }
    

    
}
