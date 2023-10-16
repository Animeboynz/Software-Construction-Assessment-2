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
public class RemoveItems extends javax.swing.JPanel {

    public RemoveItems() {
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
        BarcodeToRemove = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        QuantityToRemove = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Remove Items");

        BarcodeToRemove.setText("jTextField1");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        QuantityToRemove.setText("jTextField2");

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
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BarcodeToRemove)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(QuantityToRemove)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 631, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(BarcodeToRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(QuantityToRemove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String barcodeToRemove = BarcodeToRemove.getText();
String inventoryValue = jComboBox1.getSelectedItem().toString();

Connection con = javaconnect.connectdb();

try {
    // Check if the product already exists in PRODUCTS table
    String checkProductQuery = "SELECT BARCODE FROM PRODUCTS WHERE BARCODE = ?";
    PreparedStatement checkProductStmt = con.prepareStatement(checkProductQuery);
    checkProductStmt.setString(1, barcodeToRemove);
    ResultSet productResult = checkProductStmt.executeQuery();

    if (productResult.next()) {
        // Product exists, check if it exists in DATA table
        String checkDataQuery = "SELECT BARCODE, QUANTITY FROM DATA WHERE BARCODE = ? AND INVENTORY = ?";
        PreparedStatement checkDataStmt = con.prepareStatement(checkDataQuery);
        checkDataStmt.setString(1, barcodeToRemove);
        checkDataStmt.setString(2, inventoryValue);
        ResultSet dataResult = checkDataStmt.executeQuery();

        if (dataResult.next()) {
            int existingQuantity = dataResult.getInt("QUANTITY");
            int quantityToRemove = Integer.parseInt(QuantityToRemove.getText());

            if (existingQuantity < quantityToRemove) {
                JOptionPane.showMessageDialog(null, "You are trying to remove more than the quantity currently in the Inventory");
            } else if (existingQuantity == quantityToRemove) {
                // Remove the row from DATA table
                String deleteDataQuery = "DELETE FROM DATA WHERE BARCODE = ? AND INVENTORY = ?";
                PreparedStatement deleteDataStmt = con.prepareStatement(deleteDataQuery);
                deleteDataStmt.setString(1, barcodeToRemove);
                deleteDataStmt.setString(2, inventoryValue);
                deleteDataStmt.executeUpdate();
            } else {
                // Update the quantity in the DATA table
                String updateDataQuery = "UPDATE DATA SET QUANTITY = QUANTITY - ? WHERE BARCODE = ? AND INVENTORY = ?";
                PreparedStatement updateDataStmt = con.prepareStatement(updateDataQuery);
                updateDataStmt.setInt(1, quantityToRemove);
                updateDataStmt.setString(2, barcodeToRemove);
                updateDataStmt.setString(3, inventoryValue);
                updateDataStmt.executeUpdate();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Product Doesn't Exist in this Inventory.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Product Doesn't Exist.");
    }
} catch (SQLException ex) {
    JOptionPane.showMessageDialog(null, ex);
}

    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarcodeToRemove;
    private javax.swing.JTextField QuantityToRemove;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
