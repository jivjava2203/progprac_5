package ReaderWriter;

import Library.Teacher;
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
public class TeacherRW {
    
    private final String filename;

    public TeacherRW(String filename){
        this.filename = filename;
    }
    //reader
    public void read(TeacherCRUD teacher){
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = bufferedreader.readLine()) != null){
                if(line.isEmpty() || line.isBlank() || line.charAt(0) == ';'){continue;}
                String[] arr = line.split(";");
                String fname = Sanitize.sanitize(arr[0]);
                String lname = Sanitize.sanitize(arr[1]);
                String address = Sanitize.sanitize(arr[2]);
                int id = Integer.parseInt(Sanitize.sanitize(arr[3]));
                String rank = Sanitize.sanitize(arr[4]);
                String designation = Sanitize.sanitize(arr[5]);
                Teacher t = new Teacher(fname, lname, address, id, rank, designation);
                teacher.teacherCreate(t);
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Reading File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    //writer
    public void write(TeacherCRUD teacher){
        try (FileWriter filewriter = new FileWriter(filename)) {
            for(Teacher t : teacher.teacherList){
                filewriter.write(
                        Sanitize.sanitize(t.getFname()) + ";" + 
                        Sanitize.sanitize(t.getLname()) + ";" + 
                        Sanitize.sanitize(t.getAddress()) + ";" + t.getId() + ";" + 
                        Sanitize.sanitize(t.getRank()) + ";" + 
                        Sanitize.sanitize(t.getDesignation()) + System.lineSeparator());
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Updating File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);}
    }    
    
}
