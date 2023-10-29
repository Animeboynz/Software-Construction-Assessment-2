package com.g90.gui.other;

import com.formdev.flatlaf.FlatClientProperties;
import com.g90.GUI.javaconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class AddItems extends javax.swing.JPanel {

    public AddItems() {
        initComponents();
        //lb.putClientProperty(FlatClientProperties.STYLE, "" + "font:$h1.font");
        init();
    }
    
    private void init()
    {
        jComboBox1.removeAllItems(); // Clear existing items to avoid duplicates
        String query = "SELECT DISTINCT LOCATION FROM LOCATIONS"; // Use DISTINCT to get unique values
        Connection con = javaconnect.connectdb();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String locationName = rs.getString("LOCATION"); // Change the column name to match your table
                jComboBox1.addItem(locationName);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox<>();
        BarcodeToAdd = new javax.swing.JTextField();
        QuantityToAdd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        jComboBox1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BarcodeToAdd.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        BarcodeToAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarcodeToAddActionPerformed(evt);
            }
        });

        QuantityToAdd.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        QuantityToAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuantityToAddActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jButton1.setText("Confirm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Barcode:  ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Choose Location: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Quantity to Add:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(230, 230, 230)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(QuantityToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 227, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(BarcodeToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BarcodeToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(QuantityToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(96, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       String barcodeToAdd = BarcodeToAdd.getText();
        String inventoryValue = jComboBox1.getSelectedItem().toString();

        Connection con = javaconnect.connectdb();

        try {
            // Check if the product already exists in PRODUCTS table
            String checkProductQuery = "SELECT BARCODE FROM PRODUCTS WHERE BARCODE = ?";
            PreparedStatement checkProductStmt = con.prepareStatement(checkProductQuery);
            checkProductStmt.setString(1, barcodeToAdd);
            ResultSet productResult = checkProductStmt.executeQuery();

            if (productResult.next()) {
                // Product exists, check if it exists in DATA table
                String checkDataQuery = "SELECT BARCODE, QUANTITY FROM DATA WHERE BARCODE = ? AND INVENTORY = ?";
                PreparedStatement checkDataStmt = con.prepareStatement(checkDataQuery);
                checkDataStmt.setString(1, barcodeToAdd);
                checkDataStmt.setString(2, inventoryValue);
                ResultSet dataResult = checkDataStmt.executeQuery();

                if (dataResult.next()) {
                    // Product exists in DATA table, update the quantity
                    int existingQuantity = dataResult.getInt("QUANTITY");
                    int quantityToAdd = Integer.parseInt(QuantityToAdd.getText());

                    // Calculate the new quantity
                    int newQuantity = existingQuantity + quantityToAdd;

                    // Update the quantity in the DATA table
                    String updateDataQuery = "UPDATE DATA SET QUANTITY = ? WHERE BARCODE = ? AND INVENTORY = ?";
                    PreparedStatement updateDataStmt = con.prepareStatement(updateDataQuery);
                    updateDataStmt.setInt(1, newQuantity);
                    updateDataStmt.setString(2, barcodeToAdd);
                    updateDataStmt.setString(3, inventoryValue);
                    updateDataStmt.executeUpdate();
                } else {
                    // Product doesn't exist in DATA table, insert a new row
                    String insertDataQuery = "INSERT INTO DATA (BARCODE, INVENTORY, QUANTITY) VALUES (?, ?, ?)";
                    PreparedStatement insertDataStmt = con.prepareStatement(insertDataQuery);
                    insertDataStmt.setString(1, barcodeToAdd);
                    insertDataStmt.setString(2, inventoryValue);
                    insertDataStmt.setInt(3, Integer.parseInt(QuantityToAdd.getText()));
                    insertDataStmt.executeUpdate();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Product Doesn't Exist. Add it first before trying to add it to an Inventory");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void BarcodeToAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarcodeToAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarcodeToAddActionPerformed

    private void QuantityToAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuantityToAddActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuantityToAddActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarcodeToAdd;
    private javax.swing.JTextField QuantityToAdd;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
