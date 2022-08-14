/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.task_management;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author login
 */
public class UsersTAble extends javax.swing.JFrame {

    ConnectionClass connectionClass = ConnectionClass.getInstance();
    ArrayList<EmployeeClass> userData = new ArrayList<>();
    int selectedRow;
    int role;
    EmployeeClass adminData = new EmployeeClass();

    /**
     * Creates new form UsersTAble
     */
    public UsersTAble() {
        initComponents();
        createTable();
    }

    public UsersTAble(EmployeeClass adminData) {
        initComponents();
        createTable();
        this.adminData = adminData;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new com.mycompany.task_management.TableDark();
        jPanel2 = new javax.swing.JPanel();
        button1 = new com.mycompany.task_management.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        button1.setText("Go To Home");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(63, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE)
                .addGap(26, 26, 26)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jScrollPane3.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
AdminPanel admin = new AdminPanel(adminData);
        admin.setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
 try {
            // TODO add your handling code here:
            DefaultTableModel dtm = (DefaultTableModel) table.getModel();
            selectedRow = table.getSelectedRow();
            String i = dtm.getValueAt(selectedRow, 0).toString();
            //            System.out.println("ID is " + i);

            EmployeeClass data = new EmployeeClass();
            data.setId(Integer.parseInt(dtm.getValueAt(selectedRow, 0).toString()));
            data.setName(dtm.getValueAt(selectedRow, 1).toString());
            data.setEmail(dtm.getValueAt(selectedRow, 2).toString());
            String role = dtm.getValueAt(selectedRow, 3).toString();
            if (role.equals("Admin")) {
                data.setRole(1);
            } else if (role.equals("Manager")) {
                data.setRole(2);
            } else if (role.equals("Employee")) {
                data.setRole(3);
            }
            data.setJoiningDate(dtm.getValueAt(selectedRow, 4).toString());

            String sql = "SELECT * FROM users WHERE ID=? ";
            PreparedStatement ps = connectionClass.connection.prepareStatement(sql);
            ps.setInt(1, data.getId());
            //            ps.setInt(2, 1);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                data.setAge(rs.getInt("age"));
                data.setAddress(rs.getString("Address"));
                data.setPassword(rs.getString("password"));
                data.setContactNumber(rs.getString("contactNumber"));
                //                data.setAdharNumber(rs.getString("adharNumber"));

            }
            AddEmployee employee = new AddEmployee( adminData,data ,false);
            employee.setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(UsersTAble.class.getName()).log(Level.SEVERE, null, ex);
        }            // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(UsersTAble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UsersTAble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UsersTAble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UsersTAble.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UsersTAble().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.mycompany.task_management.Button button1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private com.mycompany.task_management.TableDark table;
    // End of variables declaration//GEN-END:variables

    public void createTable() {
        String statement = "SELECT * FROM users";
        try {
            PreparedStatement ps = connectionClass.connection.prepareStatement(statement);
            ResultSet resultSet = ps.executeQuery();
            
            String[] headerName = {"ID", "Name", "emailId", "Role", "Joining Date"};
            DefaultTableModel model = new DefaultTableModel(null, headerName);
          table.setModel(model);
            while (resultSet.next()) {
                EmployeeClass data = new EmployeeClass();
                data.setId(resultSet.getInt("ID"));
                data.setName(resultSet.getString("name"));
//                    data.setLastName(resultSet.getString("LastName"));
                data.setEmail(resultSet.getString("email"));
                data.setRole(resultSet.getInt("role"));
                data.setJoiningDate(resultSet.getString("joiningDate"));
//                                        data.setFullname(data.getFirstName(), data.getLastName());
//
                userData.add(data);
            }

            Object[] row = new Object[5];
            for (int i = 0; i < userData.size(); i++) {
                row[0] = userData.get(i).getId();
                row[1] = userData.get(i).getName();
                row[2] = userData.get(i).getEmail();
//                row[3] = userData.get(i).getRole();
                role = userData.get(i).getRole();
                switch (role) {
                    case 1:
                        row[3] = "Admin";
                        break;
                    case 2:
                        row[3] = "Manager";
                        break;
                    case 3:
                        row[3] = "Employee";
                        break;
                    default:
                        break;
                }

                row[4] = userData.get(i).getJoiningDate();
                model.addRow(row);
//                    }

            }

        } catch (SQLException ex) {
            Logger.getLogger(EmployeeTable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
