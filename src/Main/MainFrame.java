package Main;

import Admin.Admin;
import Admin.FacultyDataViewer;
import EnrollmentFrames.FacultyLoad;
import Library.*;
import ReaderWriter.*;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class MainFrame extends javax.swing.JFrame {

    SubjectCRUD sblist;
    StudentCRUD slist;
    TeacherCRUD tlist;
    EnrollmentCRUD elist;
    TeacherAssignmentCRUD tslist;
    
    EnrollmentRW enrollru;
    StudentRW studentru;
    SubjectRW subjectru;
    TeacherRW teacherru;
    TeacherAssignmentRW tsru;
    Student stud;
    
    
    
    public MainFrame(SubjectCRUD sblist, StudentCRUD slist, TeacherCRUD tlist, EnrollmentCRUD elist, EnrollmentRW enrollru, StudentRW studentru, SubjectRW subjectru, TeacherRW teacherru, TeacherAssignmentCRUD tslist, TeacherAssignmentRW tsru) {
  
     
        //Initialize Variables
        this.sblist = sblist;
        this.slist = slist;
        this.tlist = tlist;
        this.elist = elist;
        this.enrollru = enrollru;
        this.studentru = studentru;
        this.teacherru = teacherru;
        this.subjectru = subjectru;
        this.tslist = tslist;
        this.tsru = tsru;
        
                
        initComponents();
    }
    
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        TButton = new javax.swing.JButton();
        SButton = new javax.swing.JButton();
        AButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        TButton.setText("Teacher");
        TButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TButtonActionPerformed(evt);
            }
        });

        SButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        SButton.setText("Student");
        SButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SButtonActionPerformed(evt);
            }
        });

        AButton.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        AButton.setText("Admin");
        AButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AButtonActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Segoe UI Emoji", 1, 14)); // NOI18N
        jLabel1.setText("University Enlisment System");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(85, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(82, 82, 82))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AButton)
                    .addComponent(SButton)
                    .addComponent(TButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {AButton, SButton, TButton});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TButton)
                .addGap(26, 26, 26)
                .addComponent(SButton)
                .addGap(26, 26, 26)
                .addComponent(AButton)
                .addGap(93, 93, 93))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {AButton, SButton, TButton});

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    

    private void TButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TButtonActionPerformed
                
        LogIn login = new LogIn(sblist, slist, tlist, elist, enrollru, studentru, subjectru, teacherru, "Teacher", tslist, tsru);
        login.setVisible(true);
    }//GEN-LAST:event_TButtonActionPerformed

    private void SButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SButtonActionPerformed
        LogIn login = new LogIn(sblist, slist, tlist, elist, enrollru, studentru, subjectru, teacherru, "Student", tslist, tsru);
        login.setVisible(true);    
        
    }//GEN-LAST:event_SButtonActionPerformed

    private void AButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AButtonActionPerformed
        LogIn login = new LogIn(sblist, slist, tlist, elist, enrollru, studentru, subjectru, teacherru, "Admin", tslist, tsru);
        login.setVisible(true);
    }//GEN-LAST:event_AButtonActionPerformed

    /**
     * @param args the command line arguments
     */

  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AButton;
    private javax.swing.JButton SButton;
    private javax.swing.JButton TButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
