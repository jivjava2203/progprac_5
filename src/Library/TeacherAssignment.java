package Library;

/**
 *
 * @author admin
 */
public class TeacherAssignment {
    
       private Teacher teacher;
       private Subject subject;
    
        public TeacherAssignment(Teacher teacher, Subject subject) {
            
            this.teacher = teacher;
            this.subject = subject;
        }
        
        public void setTeacher(Teacher teacher) {
            
            this.teacher = teacher;
        }
        public void setSubject(Subject subject) {
            
            this.subject = subject;
        }
        
        public Teacher getTeacher() {
            
            return teacher;
        }
        public Subject getSubject() {
            
            return subject;
        }


@Override
    public String toString() {
       
        return "TeachingAssignment{" +
                    "teacher= " + teacher +
                            ", subject= " + subject +
                '}';
    }        

}
        

