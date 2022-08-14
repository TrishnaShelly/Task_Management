/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.task_management;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author login
 */
public class View extends javax.swing.JFrame {

    EmployeeClass data;
    ConnectionClass con = ConnectionClass.getInstance();

    /**
     * Creates new form View
     */
    public View() {
        initComponents();
    }

    public View(EmployeeClass data) {
        initComponents();
        this.data = data;
        name.setText(data.getName());
        password.setText(data.getPassword());
        email.setText(data.getEmail());
        address.setText(data.getAddress());
        age.setText(String.valueOf(data.getAge()));
        number.setText(data.getContactNumber());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        passwordq = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        number = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        password1 = new javax.swing.JLabel();
        button1 = new com.mycompany.task_management.Button();
        button2 = new com.mycompany.task_management.Button();

        jLabel12.setText("Name;");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        passwordq.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setText("Name;");

        name.setText("Name;");

        jLabel4.setText("Contact Number ");

        jLabel5.setText("Address");

        address.setText("Name;");

        age.setText("Name;");

        number.setText("Name;");

        jLabel9.setText("Password:");

        jLabel10.setText("Email:");

        email.setText("Name;");

        jLabel14.setText("Age:");

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(0, 153, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("YOUR PROFILE ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        password1.setText("jLabel3");

        button1.setBackground(new java.awt.Color(0, 153, 0));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Change Password");
        button1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(0, 153, 0));
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("Go To Home");
        button2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout passwordqLayout = new javax.swing.GroupLayout(passwordq);
        passwordq.setLayout(passwordqLayout);
        passwordqLayout.setHorizontalGroup(
            passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(passwordqLayout.createSequentialGroup()
                .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordqLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(passwordqLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(50, 50, 50))
                            .addGroup(passwordqLayout.createSequentialGroup()
                                .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(passwordqLayout.createSequentialGroup()
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(passwordqLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(password1)
                                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(passwordqLayout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)))
                .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordqLayout.createSequentialGroup()
                        .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(passwordqLayout.createSequentialGroup()
                                .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(age, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(address, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)))
                            .addGroup(passwordqLayout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(number, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(110, 110, 110))
                    .addGroup(passwordqLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        passwordqLayout.setVerticalGroup(
            passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(passwordqLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70)
                .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(password1)
                .addGap(29, 29, 29)
                .addGroup(passwordqLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(passwordq);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void passwordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordKeyTyped
        password1.setVisible(false);
        char ch = evt.getKeyChar();
        int length = password.getText().length();

        if (length > 0 && length < 5) {
            password1.setVisible(true);
            password1.setText("weak password");
        } else if (length >= 5 && length <= 8) {
            password1.setVisible(true);
            password1.setText("average password");

        } else if (length > 8) {

            password1.setVisible(true);
            password1.setText("strong password");

        }        // TODO add your handling code here:
    }//GEN-LAST:event_passwordKeyTyped

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
 if (data.getRole() == 2) {
            ManagerPanel manager = new ManagerPanel(data);
            manager.setVisible(true);
            this.dispose();
        } else if (data.getRole() == 3) {
            EmployeePanel manager = new EmployeePanel(data);
            manager.setVisible(true);
            this.dispose();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_button2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
  if (password.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "please enter password");
        } else {
            String str = "UPDATE users SET password=? WHERE ID=?";
            try {
                PreparedStatement ps = con.connection.prepareStatement(str);
                ps.setString(1, password.getText());
                ps.setInt(2, data.getId());
                ps.execute();
                JOptionPane.showMessageDialog(this, "updated password sucessfully");

            } catch (SQLException ex) {
                Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    /**
     * @param args the JOptionPane.showMA line arguments
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
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel address;
    private javax.swing.JLabel age;
    private com.mycompany.task_management.Button button1;
    private com.mycompany.task_management.Button button2;
    private javax.swing.JLabel email;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel number;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel password1;
    private javax.swing.JPanel passwordq;
    // End of variables declaration//GEN-END:variables
}
