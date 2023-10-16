package com.g90.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;
import com.g90.application.javaconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Raven
 */
public class AddItems extends javax.swing.JPanel {

    public AddItems() {
        initComponents();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
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

        lb = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        BarcodeToAdd = new javax.swing.JTextField();
        QuantityToAdd = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Add Items");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        BarcodeToAdd.setText("jTextField1");

        QuantityToAdd.setText("jTextField2");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BarcodeToAdd)
                            .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(QuantityToAdd)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(332, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(BarcodeToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QuantityToAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(222, Short.MAX_VALUE))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarcodeToAdd;
    private javax.swing.JTextField QuantityToAdd;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
