package Main;

import EnrollmentFrames.EnrollStudent;
import Library.*;
import ReaderWriter.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author admin
 */
public class ClassList extends javax.swing.JFrame {

    SubjectCRUD sblist;
    StudentCRUD slist;
    TeacherCRUD tlist;
    EnrollmentCRUD elist;
    
    EnrollmentRW enrollru;
    StudentRW studentru;
    SubjectRW subjectru;
    TeacherRW teacherru;
    
    Teacher teach;
    Subject sub;
    
    public ClassList(SubjectCRUD sblist, StudentCRUD slist, TeacherCRUD tlist, EnrollmentCRUD elist, EnrollmentRW enrollru, StudentRW studentru, SubjectRW subjectru, TeacherRW teacherru, Teacher teach, Subject sub) {
        

        this.sblist = sblist;
        this.slist = slist;
        this.tlist = tlist;
        this.elist = elist;
        this.enrollru = enrollru;
        this.studentru = studentru;
        this.teacherru = teacherru;
        this.teach = teach;
        this.sub = sub;
        
        
        initComponents();
        
 
        jButton1.setEnabled(false);
        
         jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // Check if a row is selected
                if(jTable1.getSelectedRow() != -1){
                    // Enable the buttons
     
                }
            }
        });

        populateJTable(elist, jTable1);
        
        jTable1.getModel().addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {

                int row = e.getFirstRow();
                int column = e.getColumn();
                TableModel model = (TableModel)e.getSource();
                if(row >= 0 && column >= 0 && row < model.getRowCount() && column < model.getColumnCount()) {
                    Object data = model.getValueAt(row, column);

                    SubjectEnrolled temp = null;
                    if (row != -1) {
                        for (SubjectEnrolled enroll : elist.enlist) {
                            if(((String)jTable1.getModel().getValueAt(row, 0)).equalsIgnoreCase(enroll.getStudent().getCname())){
                                temp = enroll;
                                break;
                            }
                        }
                        if(temp != null) {
                            temp.setGrade(Double.parseDouble((String) data));
                            enrollru.write(elist);
                        }
                    }
                }
            }
        });


    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText(sub.getTitlecode().toUpperCase());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText(sub.getDescription());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Schedule: " + sub.getSched());
        jLabel4.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Student", "Course", "Year Level", "Grade"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton3.setText("Add Student");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setText("Remove Student");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(109, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addGap(18, 18, 18))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 117, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 69, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EnrollStudent enroll = new EnrollStudent(slist, elist, enrollru, teach, sub);
        enroll.setVisible(true);
        enroll.addWindowListener(new WindowAdapter(){
            public void windowClosed(WindowEvent e) {
                jTable1.clearSelection();
                jButton1.setEnabled(false);
                refreshTable();
            }
        });
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if(selectedRow != -1){
            int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Drop Student", JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
            if(response == JOptionPane.YES_OPTION){
                SubjectEnrolled se = null;
                for(SubjectEnrolled enroll : elist.enlist){
                    if(teach == enroll.getTeacher()){
                        String student = (String) jTable1.getValueAt(selectedRow, 0);
                        if (student.equalsIgnoreCase(enroll.getStudent().getCname())) {
                            String titlecode = sub.getTitlecode();
                            if(enroll.getSubject().getTitlecode().equalsIgnoreCase(titlecode)){
                                se = enroll;
                            }
                        }
                    }
                }
                elist.deleteSE(elist.retrieveSE(se));
                enrollru.write(elist);
            }
            refreshTable();
            jTable1.clearSelection();
            jButton1.setEnabled(false);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

        public void populateJTable(EnrollmentCRUD elist, JTable yourJTable) {
        DefaultTableModel model = (DefaultTableModel) yourJTable.getModel();

        model.fireTableDataChanged();
   
        model.setRowCount(0);

        for (SubjectEnrolled enroll : elist.enlist) {
            if(teach == enroll.getTeacher() && sub == enroll.getSubject()){
            Object[] rowData = {
                enroll.getStudent().getCname(),
                enroll.getStudent().getCourse(),
                enroll.getStudent().getYearlevel(),
                enroll.getGrade()
            };
            model.addRow(rowData);
            }
        }
        
        model.fireTableDataChanged();
    }

    public void refreshTable() {

        populateJTable(elist, jTable1);
    }
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
