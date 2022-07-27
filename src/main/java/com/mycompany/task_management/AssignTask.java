/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.task_management;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author login
 */
public class AssignTask extends javax.swing.JFrame {

    boolean isUpdate = false,status=false;
    String simpleDate;
    int role;
    EmployeeClass ManagerData;
    TaskClass taskdata;
    ConnectionClass connectionClass = ConnectionClass.getInstance();
    String name;
    int des;
    int id;
    Date d2= new Date();
    /**
     * Creates new form AssignTask
     */
    public AssignTask() {
        initComponents();
        Date d = new Date();
        SimpleDateFormat frrmatter = new SimpleDateFormat("dd/MMM/yyyy");
        simpleDate = frrmatter.format(d);
        dueDate.setDateFormatString("dd/MMM/yyyy");
        
        
    }

    public AssignTask(int role, EmployeeClass ManagerData) {
        initComponents();
       dueDate.setMinSelectableDate(d2);
        Date d = new Date();
        SimpleDateFormat frrmatter = new SimpleDateFormat("dd/MMM/yyyy");
        simpleDate = frrmatter.format(d);
        this.role = role;
        this.ManagerData = ManagerData;

        if (role == 1) {
            String sql = "SELECT * FROM users WHERE NOT role=?";
            try {
                PreparedStatement ps = connectionClass.connection.prepareStatement(sql);
                ps.setInt(1, 1);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("ID");
                    name = rs.getString("name");
                    des = rs.getInt("role");
                    if (des == 3) {
                        employeeID.addItem(name + "(Employee)id: " + id);
                    }

                }
            } catch (SQLException ex) {
                Logger.getLogger(AssignTask.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (role == 2) {
            String sql = "SELECT * FROM users WHERE  role=?";
            try {
                PreparedStatement ps = connectionClass.connection.prepareStatement(sql);
                ps.setInt(1, 3);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    id = rs.getInt("ID");
                    name = rs.getString("name");
                    des = rs.getInt("role");

                    employeeID.addItem(name + "(Employee)id: " + id);
                }

            } catch (SQLException ex) {
                Logger.getLogger(AssignTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public AssignTask(TaskClass taskdata, EmployeeClass ManagerData) {
        initComponents();
//          boolean check =false;
        if (taskdata.getEmployeeId() == ManagerData.getId()) {
//          check=true;
            view.setVisible(false);
            btn.setVisible(false);
            if(taskdata.getStatus()==0){
            heading.setText("View Task (  Not Done )");}
            else{
                            heading.setText("View Task ( Done )");}

            }
         else {
            view.setText("Delete task ");
            btn.setText("Update Task");
            heading.setText("Update Task");
        }
        switch (ManagerData.getRole()) {
            case 1 -> {
                String sql = "SELECT * FROM users WHERE NOT role=?";
                try {
                    PreparedStatement ps = connectionClass.connection.prepareStatement(sql);
                    ps.setInt(1, 1);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        id = rs.getInt("ID");
                        name = rs.getString("name");
                        des = rs.getInt("role");
                         if (des == 3) {
                            employeeID.addItem(name + "(Employee)id: " + id);
                        }

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(AssignTask.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 2 -> {
                String sql = "SELECT * FROM users WHERE  role=?";
                try {
                    PreparedStatement ps = connectionClass.connection.prepareStatement(sql);
                    ps.setInt(1, 3);
                    ResultSet rs = ps.executeQuery();
                    while (rs.next()) {
                        id = rs.getInt("ID");
                        name = rs.getString("name");
                        des = rs.getInt("role");

                        employeeID.addItem(name + "(Employee)id: " + id);
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(AssignTask.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            default ->
                employeeID.addItem(ManagerData.getName() + "(Employee)id: " + ManagerData.getId());
        }

        dueDate.setMinSelectableDate(d2);
        this.taskdata = taskdata;
        this.ManagerData = ManagerData;
        isUpdate = true;
        title.setText(taskdata.getTitle());
        description.setText(taskdata.getDescription());
        String date = (taskdata.getDueDate());
        try {
            Date dateFinal = new SimpleDateFormat("dd/MMM/yyyy").parse(date);
            System.out.println(dateFinal);
            dueDate.setDate(dateFinal);
        } catch (ParseException ex) {
            System.out.println("insidecatch ");
            Logger.getLogger(AssignTask.class.getName()).log(Level.SEVERE, null, ex);
        }

//
////        name + "(Employee)id: " + id
        try {
            String sql2 = "SELECT name FROM users WHERE ID =?";
            PreparedStatement ps2;
            ps2 = connectionClass.connection.prepareStatement(sql2);
            ps2.setInt(1, taskdata.getEmployeeId());
            ResultSet rs = ps2.executeQuery();
            while (rs.next()) {
                name = rs.getString("name");
//                role = rs.getInt("role");
               
//                if (taskdata.getEmployeeId() == 3) {
                    employeeID.setSelectedItem(name + "(Employee)id: " + taskdata.getEmployeeId());

//                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(AssignTask.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        heading = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        title = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        dueDate = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        employeeID = new javax.swing.JComboBox<>();
        btn = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        view = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 255, 255));

        heading.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        heading.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        heading.setText("Assign task ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(heading, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Task Name : ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Description of the Task :");

        title.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                titleActionPerformed(evt);
            }
        });

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Due Date :");

        dueDate.setDateFormatString("dd/MM/yyyy");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Assign Task to :");

        btn.setText("Assign Task ");
        btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActionPerformed(evt);
            }
        });

        jButton1.setText("Go to Home ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        view.setText("View Assigned Tasks ");
        view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(title)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 332, Short.MAX_VALUE)
                                .addComponent(dueDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(employeeID, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jButton1)
                        .addGap(50, 50, 50)
                        .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(view)))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dueDate, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(employeeID, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(view, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 103, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void titleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_titleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_titleActionPerformed

    private void btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActionPerformed
        SimpleDateFormat Date_Format = new SimpleDateFormat("dd/MMM/yyyy");
        String date = Date_Format.format(dueDate.getDate());
        String employee = (String) employeeID.getSelectedItem();

        if (title.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter name of task  ");
        } else if (description.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter descrption ");
        } else if (date.equals("")) {
            JOptionPane.showMessageDialog(this, "Please choose a due Date  ");
        } else if (employee.equals("")) {
            JOptionPane.showMessageDialog(this, "Please choose a employee to assign task  ");
        }
        if (isUpdate) {
//                String sql = "INSERT INTO tasks (title,description,startDate,dueDate, employeeID ,"
//                    + "managerID) VALUES(?,?,?,?,?,?)";
                String sql = "UPDATE tasks SET title=?,description=?,dueDate=?, employeeID=?, managerID=?, status=?"
                        + "  WHERE ID=?";
            try {
                PreparedStatement ps2 = connectionClass.connection.prepareStatement(sql);
                ps2.setString(1, title.getText());
                ps2.setString(2, description.getText());
//                ps2.setString(3, simpleDate);
                ps2.setString(3, date);
                String emp[] = employee.split(" ");
                int lenght = emp.length;
                int a = Integer.parseInt(emp[lenght - 1]);
                ps2.setInt(4, a);
                ps2.setInt(5, ManagerData.getId());
                ps2.setInt(6,0);
                ps2.setInt(7,taskdata.getId());
                
                ps2.execute();
                JOptionPane.showMessageDialog(this, "updated Task ");

                if (ManagerData.getRole() == 1) {
                    AdminPanel admin = new AdminPanel(ManagerData);
                    admin.setVisible(true);
                    this.dispose();
                } else if (ManagerData.getRole()  == 2) {
                    ManagerPanel manager = new ManagerPanel(ManagerData);
                    manager.setVisible(true);
                    this.dispose();
                }

            } catch (SQLException ex) {
                Logger.getLogger(AssignTask.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
            
        } else {
            String sql = "INSERT INTO tasks (title,description,startDate,dueDate, employeeID ,status ,"
                    + "managerID) VALUES(?,?,?,?,?,?,?)";
            try {
                PreparedStatement ps2 = connectionClass.connection.prepareStatement(sql);
                ps2.setString(1, title.getText());
                ps2.setString(2, description.getText());
                ps2.setString(3, simpleDate);
                ps2.setString(4, date);
                String emp[] = employee.split(" ");
                int lenght = emp.length;
                int a = Integer.parseInt(emp[lenght - 1]);
                ps2.setInt(5, a);
                ps2.setInt(6,0);
                ps2.setInt(7, ManagerData.getId());
                ps2.execute();
                JOptionPane.showMessageDialog(this, "Assigned Task ");

                if (role == 1) {
                    AdminPanel admin = new AdminPanel(ManagerData);
                    admin.setVisible(true);
                    this.dispose();
                } else if (role == 2) {
                    ManagerPanel manager = new ManagerPanel(ManagerData);
                    manager.setVisible(true);
                    this.dispose();
                }

            } catch (SQLException ex) {
                Logger.getLogger(AssignTask.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        switch (ManagerData.getRole()) {
            case 1 -> {
                AdminPanel admin = new AdminPanel(ManagerData);
                admin.setVisible(true);
                this.dispose();
            }
            case 2 -> {
                ManagerPanel manager = new ManagerPanel(ManagerData);
                manager.setVisible(true);
                this.dispose();
            }
            default -> {
                EmployeePanel emp = new EmployeePanel(ManagerData);
                emp.setVisible(true);
                this.dispose();
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewActionPerformed
        if (isUpdate) {
            try {
                String sql = "DELETE FROM tasks WHERE id=?";
                PreparedStatement preparedStatement2 = connectionClass.connection.prepareStatement(sql);
                preparedStatement2.setInt(1, taskdata.getId());
                if (preparedStatement2.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(null, "deleted sucessfully");
                    TaskTable table = new TaskTable(ManagerData.getRole(), ManagerData);
                    table.setVisible(true);
                    this.dispose();
//                switch (ManagerData.getRole()) {
//                    case 2 -> {
//                        TaskTable table = TaskTable(2,ManagerData);
////                        ta
//                    }
//                    case 1 -> {
//                        
//                    }
//                    case 3 -> {
//                        
//                    }
//                    default -> {
//                    }
//                }
                } else {
                    JOptionPane.showMessageDialog(null, " sorry not able to delete");
                }

            } catch (SQLException ex) {
                Logger.getLogger(AddEmployee.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            TaskTable task = new TaskTable(role, ManagerData);

            task.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_viewActionPerformed

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
            java.util.logging.Logger.getLogger(AssignTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AssignTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AssignTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AssignTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AssignTask().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn;
    private javax.swing.JTextArea description;
    private com.toedter.calendar.JDateChooser dueDate;
    private javax.swing.JComboBox<String> employeeID;
    private javax.swing.JLabel heading;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField title;
    private javax.swing.JButton view;
    // End of variables declaration//GEN-END:variables
}
