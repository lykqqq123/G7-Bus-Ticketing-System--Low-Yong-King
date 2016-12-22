/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

import control.PaymentDetailsControl;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author waiho
 */
public class ReportYearlyProfitEarn extends javax.swing.JFrame {

    /**
     * Creates new form ReportMonthlyProfitEarn
     */
    public ReportYearlyProfitEarn() {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public ReportYearlyProfitEarn(int year) {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);

        PaymentDetailsControl pdControl = new PaymentDetailsControl();
        ResultSet rs = pdControl.retrieveRecord();
        SimpleDateFormat df = new SimpleDateFormat("d-M-yyyy");

        double Jan = 0.0;
        double Feb = 0.0;
        double March = 0.0;
        double Apr = 0.0;
        double May = 0.0;
        double June = 0.0;
        double July = 0.0;
        double Aug = 0.0;
        double Sep = 0.0;
        double Oct = 0.0;
        double Nov = 0.0;
        double Dec = 0.0;
        double total = 0.0;

        try {
            String tempPID = null;
            while (rs.next()) {
                Date date = df.parse(rs.getString(3));
                if (date.getYear() + 1900 == year) {
                    if (date.getMonth() == 0) {
                        if(!rs.getString(2).equals(tempPID)){
                            Jan += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 1) {
                        if(!rs.getString(2).equals(tempPID)){
                            Feb += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 2) {
                        if(!rs.getString(2).equals(tempPID)){
                            March += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 3) {
                        if(!rs.getString(2).equals(tempPID)){
                            Apr += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 4) {
                        if(!rs.getString(2).equals(tempPID)){
                            May += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 5) {
                        if(!rs.getString(2).equals(tempPID)){
                            June += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 6) {
                        if(!rs.getString(2).equals(tempPID)){
                            July += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 7) {
                        if(!rs.getString(2).equals(tempPID)){
                            Aug += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 8) {
                        if(!rs.getString(2).equals(tempPID)){
                            Sep += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 9) {
                        if(!rs.getString(2).equals(tempPID)){
                            Oct += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 10) {
                        if(!rs.getString(2).equals(tempPID)){
                            Nov += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    } else if (date.getMonth() == 11) {
                        if(!rs.getString(2).equals(tempPID)){
                            Dec += rs.getDouble(6);
                            total += rs.getDouble(6);
                            tempPID = rs.getString(2);
                        }
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReportYearlyProfitEarn.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ReportYearlyProfitEarn.class.getName()).log(Level.SEVERE, null, ex);
        }
        jTable1.setValueAt("January", 0, 0);jTable1.setValueAt(Jan, 0, 1);
        jTable1.setValueAt("February", 1, 0);jTable1.setValueAt(Feb, 1, 1);
        jTable1.setValueAt("March", 2, 0);jTable1.setValueAt(March, 2, 1);
        jTable1.setValueAt("April", 3, 0);jTable1.setValueAt(Apr, 3, 1);
        jTable1.setValueAt("May", 4, 0);jTable1.setValueAt(May, 4, 1);
        jTable1.setValueAt("June", 5, 0);jTable1.setValueAt(June, 5, 1);
        jTable1.setValueAt("July", 6, 0);jTable1.setValueAt(July, 6, 1);
        jTable1.setValueAt("August", 7, 0);jTable1.setValueAt(Aug, 7, 1);
        jTable1.setValueAt("September", 8, 0);jTable1.setValueAt(Sep, 8, 1);
        jTable1.setValueAt("October", 9, 0);jTable1.setValueAt(Oct, 9, 1);
        jTable1.setValueAt("November", 10, 0);jTable1.setValueAt(Nov, 10, 1);
        jTable1.setValueAt("December", 11, 0);jTable1.setValueAt(Dec, 11, 1);
        jTextField1.setText(""+total);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton1 = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        jRadioButton1.setText("jRadioButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Pristina", 3, 48)); // NOI18N
        jLabel1.setText("Monthly Profit Earn Report");

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Month", "Total Amount()"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel2.setText("Total :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(96, 96, 96))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ReportGeneration();        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(ReportYearlyProfitEarn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportYearlyProfitEarn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportYearlyProfitEarn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportYearlyProfitEarn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportYearlyProfitEarn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
