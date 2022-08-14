/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.task_management;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author login
 */
public class AddEmployee extends javax.swing.JFrame {
     int lenght=0;
    String ch = new String();
    boolean table = true;
    boolean isUpdate = false;
    EmployeeClass employeeData = new EmployeeClass();
    EmployeeClass managerData = new EmployeeClass();

    ConnectionClass con = ConnectionClass.getInstance();
    String simpleDate;
    int role;
    int desti = 1;

    /**
     * Creates new form AddEmployee
     */
    public AddEmployee() {
        initComponents();

    }

    public AddEmployee(int role, int desti) {
        initComponents();
        this.desti = desti;
        this.role = role;
        btnDelete.setVisible(false);
        Date d = new Date();
        SimpleDateFormat frrmatter = new SimpleDateFormat("dd/MM/yyyy");
        simpleDate = frrmatter.format(d);
        switch (role) {
            case 2:
                btnAdd.setText("Add Manager ");
                heading.setText("Add Manager");
//                btnDelete.setText("Delete Manager");
                break;
            case 3:
                btnAdd.setText("Add Foreman ");
                heading.setText("Add ForeMan");
//                btnDelete.setText("Delete Employee");
                break;
            case 1:
                btnAdd.setText("Add Admin ");
                heading.setText("Add Admin");
                btnDelete.setVisible(false);
                break;
            default:
                break;
        }
        name1.setVisible(false);
        email1.setVisible(false);
//        address1.setVisible(false);
//        adhar1.setVisible(false);
        contact1.setVisible(false);
        password1.setVisible(false);
        age1.setVisible(false);
    }

    public AddEmployee(EmployeeClass managerData, EmployeeClass employeeData, boolean table) {
        initComponents();
        this.table = table;
        this.desti = managerData.getRole();
        System.out.println("desti inside  add employee" + desti);
        isUpdate = true;
        this.managerData = managerData;
        this.employeeData = employeeData;
        btnDelete.setVisible(true);
        switch (employeeData.getRole()) {
            case 2 -> {
                btnAdd.setText("Update Manager ");
                heading.setText("Update Manager");
                btnDelete.setText("Delete Manager");
            }
            case 3 -> {
                btnAdd.setText("update ForeMan ");
                heading.setText("Update ForeMan");
                btnDelete.setText("Delete ForeMan");
            }
            case 1 -> {
                btnAdd.setText("update Admin ");
                heading.setText("Update Admin");
                btnDelete.setVisible(false);
            }
            default -> {
            }
        }

        name.setText(employeeData.getName());
        address.setText(employeeData.getAddress());
        contactNumber.setText(employeeData.getContactNumber());
        emailId.setText(employeeData.getEmail());
        age.setText(String.valueOf(employeeData.getAge()));
        password.setText(employeeData.getPassword());
        name1.setVisible(false);
        email1.setVisible(false);
        contact1.setVisible(false);
        password1.setVisible(false);
        age1.setVisible(false);
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////

    public AddEmployee(int role, EmployeeClass managerData) {
        initComponents();
        Date d = new Date();
        SimpleDateFormat frrmatter = new SimpleDateFormat("dd/MM/yyyy");
        simpleDate = frrmatter.format(d);
        desti = managerData.getRole();
        btnDelete.setVisible(false);
        this.role = role;
        switch (role) {
            case 2 -> {
                btnAdd.setText("Add Manager ");
                heading.setText("Add Manager");
//                btnDelete.setText("Delete Manager");
            }
            case 3 -> {
                btnAdd.setText("ADD ForeMan ");
                heading.setText("Add ForeMan");
//                btnDelete.setText("Delete Employee");
            }
            default -> {
            }
        }
//            case 1:
//                btnAdd.setText("Add Admin ");
//                heading.setText("Update Admin");
//                btnDelete.setVisible(false);
//                break;
        this.managerData = managerData;
        name1.setVisible(false);
        email1.setVisible(false);
        contact1.setVisible(false);
        password1.setVisible(false);
        age1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        heading = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        emailId = new javax.swing.JTextField();
        contactNumber = new javax.swing.JTextField();
        age = new javax.swing.JTextField();
        name = new javax.swing.JTextField();
        address = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        name1 = new javax.swing.JLabel();
        contact1 = new javax.swing.JLabel();
        email1 = new javax.swing.JLabel();
        age1 = new javax.swing.JLabel();
        password1 = new javax.swing.JLabel();
        button1 = new com.mycompany.task_management.Button();
        btnDelete = new com.mycompany.task_management.Button();
        btnAdd = new com.mycompany.task_management.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 153, 0));

        heading.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        heading.setForeground(new java.awt.Color(255, 255, 255));
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Add Employee");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setText("Name :");

        jLabel4.setText("Address:");

        jLabel5.setText("Contact number:");

        jLabel6.setText("Age:");

        jLabel7.setText("Password:");

        jLabel8.setText("Email Id:");

        emailId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailIdActionPerformed(evt);
            }
        });
        emailId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailIdKeyTyped(evt);
            }
        });

        contactNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberActionPerformed(evt);
            }
        });
        contactNumber.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactNumberKeyTyped(evt);
            }
        });

        age.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ageKeyTyped(evt);
            }
        });

        name.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                nameKeyTyped(evt);
            }
        });

        password.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                passwordKeyTyped(evt);
            }
        });

        name1.setText("jLabel9");

        contact1.setText("jLabel11");

        email1.setText("jLabel13");
        email1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                email1KeyTyped(evt);
            }
        });

        age1.setText("jLabel14");

        password1.setText("jLabel9");

        button1.setBackground(new java.awt.Color(0, 153, 0));
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("Return To Home ");
        button1.setEffectColor(new java.awt.Color(204, 255, 204));
        button1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(0, 153, 0));
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Delete Emploee");
        btnDelete.setEffectColor(new java.awt.Color(204, 255, 204));
        btnDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 153, 0));
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setText("Add Employee");
        btnAdd.setEffectColor(new java.awt.Color(204, 255, 204));
        btnAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(contactNumber))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(address))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(contact1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(name))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(217, 217, 217)
                                .addComponent(name1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(105, 105, 105)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(emailId))
                            .addComponent(password1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(email1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(age))
                            .addComponent(age1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(password))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(emailId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(name1)
                    .addComponent(email1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(address, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(age, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(age1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(contactNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(contact1)
                    .addComponent(password1))
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addGap(0, 0, 0))
        );

        setSize(new java.awt.Dimension(849, 573));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailIdActionPerformed

    private void nameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nameKeyTyped
        name1.setVisible(false);
        char ch = evt.getKeyChar();
        if (Character.isLetter(ch) || ch == KeyEvent.VK_SPACE || ch == KeyEvent.VK_BACK_SPACE) {
        } else {
            name1.setVisible(true);
            name1.setText("Invalid Character " + ch);
            evt.consume();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_nameKeyTyped

    private void emailIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailIdKeyTyped
        char c = evt.getKeyChar();
        ch = ch + c;

        // TODO add your handling code here:
    }//GEN-LAST:event_emailIdKeyTyped

    private void email1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_email1KeyTyped

        // TODO add your handling code here:
    }//GEN-LAST:event_email1KeyTyped

    private void ageKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ageKeyTyped
        age1.setVisible(false);
        char ch = evt.getKeyChar();
        if (Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE) {
        } else {
            age1.setVisible(true);
            age1.setText("Invalid Character " + ch);
            evt.consume();

        }     // TODO add your handling code here:
    }//GEN-LAST:event_ageKeyTyped

    private void contactNumberKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactNumberKeyTyped
        contact1.setVisible(false);
        char ch = evt.getKeyChar();
        if (Character.isDigit(ch) || ch == KeyEvent.VK_BACK_SPACE) {
            lenght++;
        } else {
            contact1.setVisible(true);
            contact1.setText("Invalid Character " + ch);
            evt.consume();
        } if(lenght==10){
             contact1.setVisible(true);
            contact1.setText("Valid Number ");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberKeyTyped

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

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordKeyTyped

    private void contactNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
if (desti == 2) {
            ManagerPanel manager = new ManagerPanel(managerData);
            manager.setVisible(true);
            this.dispose();
        } else {
            AdminPanel admin = new AdminPanel(managerData);
            admin.setVisible(true);
            this.dispose();
        } // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_button1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
 try {
            // TODO add your handling code here:
            String sql = "DELETE FROM users WHERE id=?";
            PreparedStatement preparedStatement2 = con.connection.prepareStatement(sql);
            preparedStatement2.setInt(1, employeeData.getId());
//            preparedStatement2.execute/();
            if (preparedStatement2.executeUpdate() > 0) {
//                System.out.println("deleted successfully");
                JOptionPane.showMessageDialog(null, "deleted sucessfully");
                System.out.println("desti inside add  delete employeetable" + desti);

                if (desti == 2) {
                    if (table) {
                        EmployeeTable employee = new EmployeeTable(3, managerData);
                        employee.setVisible(true);
                        this.dispose();
                    } else {
                        UsersTAble t = new UsersTAble(managerData);
                        t.setVisible(true);
                        this.dispose();
                    }
//                    this.dispose();
                } else if (desti == 1) {
                    if (table) {
                        EmployeeTable employee = new EmployeeTable(employeeData.getRole(), managerData);
                        employee.setVisible(true);
                        this.dispose();
                    } else {
                        UsersTAble t = new UsersTAble(managerData);
                        t.setVisible(true);
                        this.dispose();
                    }

//                    this.dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, " sorry not able to delete");

//                System.out.println("Sorry don't  deleted");
            }

        } catch (SQLException ex) {
//            System.out.println("exception in addEmployeer delete action " + ex);
            Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
 int num =contactNumber.getText().length();
        if (name.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter name ");
        } else if (address.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter address ");
        } else if (emailId.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter email ");
        } else if (password.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter password ");
        } else if (contactNumber.getText().equals("") && num !=10) {
            JOptionPane.showMessageDialog(this, "Please enter contact number ");
        } else if (age.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Please enter age  ");
        }else if (!isValidEmailID(ch) && !isUpdate) {
            JOptionPane.showMessageDialog(this, "Please enter valid email");

            email1.setVisible(true);
            email1.setText("please enter a valid email");
        } else {
            if (!isUpdate) {

                String sql = "INSERT INTO users (name, joiningDate, age, address, email, password, contactNumber,"
                        + "role) VALUES(?,?,?,?,?,?,?,?)";
                try {
                    PreparedStatement ps = con.connection.prepareStatement(sql);
                    ps.setString(1, name.getText().trim());
                    ps.setString(2, simpleDate);
                    ps.setInt(3, Integer.parseInt(age.getText().trim()));
                    ps.setString(4, address.getText().trim());
                    ps.setString(5, emailId.getText().trim());
                    ps.setString(6, password.getText().trim());
                    ps.setString(7, contactNumber.getText().trim());
                    ps.setInt(8, role);
                    ps.execute();
//                    System.out.println("Added employee sucessfully");
                    JOptionPane.showMessageDialog(null, "added sucessfully");
//                    if (managerData.getRole() == 2) {
                    if (table) {
                        EmployeeTable employee = new EmployeeTable(role, managerData);
                        employee.setVisible(true);
                        this.dispose();
                    } else {
                        UsersTAble employee = new UsersTAble(managerData);
                        employee.setVisible(true);
                        this.dispose();
                    }
////                    this.dispose();
//                    } else if (managerData.getRole() == 1) {,
//                        EmployeeTable employee = new EmployeeTable(employeeData.getRole(), managerData);
//                        employee.setVisible(true);
//                        this.dispose();
////                    this.dispose();
//                    }

                } catch (SQLException ex) {
                    Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                String str = "UPDATE users SET name=?,age=?,address=?,email=?,password=?,contactNumber=? WHERE ID=?";
                try {
                    PreparedStatement ps = con.connection.prepareStatement(str);
                    ps.setString(1, name.getText().trim());
//                ps.setString(2, simpleDate);
                    ps.setInt(2, Integer.parseInt(age.getText().trim()));
                    ps.setString(3, address.getText().trim());
                    ps.setString(4, emailId.getText().trim());
                    ps.setString(5, password.getText().trim());
                    ps.setString(6, contactNumber.getText().trim());
//                    ps.setString(7, a.dharNumber.getText().trim());
                    ps.setInt(7, employeeData.getId());
                    ps.execute();
                    JOptionPane.showMessageDialog(null, "updated sucessfully");

//                    System.out.println("Updated sucessfully");
                   if(table){ if (desti == 2) {
                        EmployeeTable employee = new EmployeeTable(3, managerData);
                        employee.setVisible(true);
                        this.dispose();
//                    this.dispose();
                    } else if (desti == 1) {
                        EmployeeTable employee = new EmployeeTable(employeeData.getRole(), managerData);
                        employee.setVisible(true);
                        this.dispose();
//                    this.dispose();
                    }}
                 else {
                        UsersTAble employee = new UsersTAble(managerData);
                        employee.setVisible(true);
                        this.dispose();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddEmployee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddEmployee().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField address;
    private javax.swing.JTextField age;
    private javax.swing.JLabel age1;
    private com.mycompany.task_management.Button btnAdd;
    private com.mycompany.task_management.Button btnDelete;
    private com.mycompany.task_management.Button button1;
    private javax.swing.JLabel contact1;
    private javax.swing.JTextField contactNumber;
    private javax.swing.JLabel email1;
    private javax.swing.JTextField emailId;
    private javax.swing.JLabel heading;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JLabel name1;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel password1;
    // End of variables declaration//GEN-END:variables
 public boolean isValidEmailID(String email) {

//        System.out.println(email);
        String regex = "^(.+)@(gmail.com)$";
        Pattern ptrn = Pattern.compile(regex);
        Matcher matcher = ptrn.matcher(email);
        return matcher.matches();

    }
}
