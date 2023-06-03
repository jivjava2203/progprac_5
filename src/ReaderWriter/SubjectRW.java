package ReaderWriter;

import Library.Subject;
import Library.SubjectCRUD;
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
public class SubjectRW {
    
    private final String filename;

    public SubjectRW(String filename){
        this.filename = filename;
    }
    //reader
    public void read(SubjectCRUD subject){
        
        try (BufferedReader bufferedreader = new BufferedReader(new FileReader(filename))){
            String line;
                while((line = bufferedreader.readLine()) != null){
                    if(line.isEmpty() || line.isBlank() || line.charAt(0) == ';'){continue;}
                        String[] arr = line.split(";");
                        String titlecode = Sanitize.sanitize(arr[0]);
                        String description = Sanitize.sanitize(arr[1]);
                        String schedule = Sanitize.sanitize(arr[2]);
                        int unit = Integer.parseInt(Sanitize.sanitize(arr[3]));
                        Subject sub = new Subject(titlecode, description, schedule, unit);
                        subject.createSubject(sub);
                }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Reading File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    //writer
    public void write(SubjectCRUD subject){
       
        try (FileWriter filewriter = new FileWriter(filename)) {
            for(Subject sub : subject.subjectlist){
                filewriter.write(
                        Sanitize.sanitize(sub.getTitlecode()) + ";" +
                        Sanitize.sanitize(sub.getDescription()) + ";" + 
                        Sanitize.sanitize(sub.getSched()) + ";" + 
                        sub.getUnit() + System.lineSeparator());
            }
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "Error Updating File!\n" + Arrays.toString(e.getStackTrace()), "Error!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
}
