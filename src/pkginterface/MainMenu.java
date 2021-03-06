/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import javax.swing.JOptionPane;

/**
 *
 * @author waiho
 */
public class MainMenu extends javax.swing.JFrame {

    private static String defineUser;

    /**
     * Creates new form MainMenu
     */
    public MainMenu() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jbtStaff = new javax.swing.JButton();
        jbtBusMaintenance = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jbtTicket = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Pristina", 3, 48)); // NOI18N
        jLabel1.setText("Seri Meju Bus Ticketing System");

        jbtStaff.setText("Staff Maintenance");
        jbtStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtStaffActionPerformed(evt);
            }
        });

        jbtBusMaintenance.setText("Bus Maintenance");
        jbtBusMaintenance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtBusMaintenanceActionPerformed(evt);
            }
        });

        jButton3.setText("Schedule");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jbtTicket.setText("Ticket Transaction");
        jbtTicket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtTicketActionPerformed(evt);
            }
        });

        jButton1.setText("Report Generation");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(jbtTicket)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(174, 174, 174))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(jbtStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jbtBusMaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtBusMaintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(Exit)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtBusMaintenanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtBusMaintenanceActionPerformed
        // TODO add your handling code here:
        try {
            if (defineUser.equals("M")) {
                dispose();
                BusDetails s = new BusDetails();

            } else {
                JOptionPane.showMessageDialog(null, "Only Manager can access to Bus Maintenance!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Only Manager can access to Bus Maintenance!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbtBusMaintenanceActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        // TODO add your handling code here:
        int yesno = JOptionPane.showConfirmDialog(null, "Are you sure to exit?", "Exit Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

        if (yesno == JOptionPane.YES_OPTION) {
            SecurityModule s = new SecurityModule();
            s.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_ExitActionPerformed

    private void jbtStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtStaffActionPerformed
        // TODO add your handling code here:
        try {
            if (defineUser.equals("M")) {
                StaffMaintenance s = new StaffMaintenance();
                s.setVisible(true);
                dispose();

            } else {
                JOptionPane.showMessageDialog(null, "Only Manager can access to Bus Maintenance!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Only Manager can access to Staff Maintenance!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jbtStaffActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        try {
            if (defineUser.equals("M")) {
                dispose();
                BusSchedule s = new BusSchedule();
                s.setVisible(true);

            } else {
                JOptionPane.showMessageDialog(null, "Only Manager can access to Bus Maintenance!", "ERROR!", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Only Manager can access to Bus Schedule Maintenance!", "ERROR!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jbtTicketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtTicketActionPerformed
        // TODO add your handling code here:
        TicketTransaction s = new TicketTransaction();
        s.setVisible(true);
        dispose();


    }//GEN-LAST:event_jbtTicketActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        ReportGeneration s = new ReportGeneration();
        s.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    public void setDefineUser(String defineUser) {
        this.defineUser = defineUser;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton jbtBusMaintenance;
    private javax.swing.JButton jbtStaff;
    private javax.swing.JButton jbtTicket;
    // End of variables declaration//GEN-END:variables
}
