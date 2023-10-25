package com.g90.application.form.other;

import com.formdev.flatlaf.FlatClientProperties;

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
public class MoveItems extends javax.swing.JPanel {

    public MoveItems() {
        initComponents();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        init();
    }
    
    private void init()
    {
        sourceInventoryComboBox.removeAllItems();
        destinationInventoryComboBox.removeAllItems();
        
        // Populate sourceInventoryComboBox and destinationInventoryComboBox with data from your database
        Connection con = javaconnect.connectdb();
        try {
            String query = "SELECT DISTINCT LOCATION FROM LOCATIONS"; // Use DISTINCT to get unique values
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String locationName = rs.getString("LOCATION"); // Change the column name to match your table
                sourceInventoryComboBox.addItem(locationName);
                destinationInventoryComboBox.addItem(locationName);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        BarcodeToMove = new javax.swing.JTextField();
        QuantityToMove = new javax.swing.JTextField();
        sourceInventoryComboBox = new javax.swing.JComboBox<>();
        destinationInventoryComboBox = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BarcodeToMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BarcodeToMoveActionPerformed(evt);
            }
        });

        sourceInventoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        destinationInventoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel1.setText("Barcode: ");

        jLabel2.setText("Quantity To Move: ");

        jLabel3.setText("Source Location:  ");

        jLabel4.setText("Destination Location: ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Move");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sourceInventoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(QuantityToMove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BarcodeToMove, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(183, 183, 183)
                        .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(84, 84, 84)
                        .addComponent(destinationInventoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel5)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BarcodeToMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(sourceInventoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(destinationInventoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(QuantityToMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String barcodeToMove = BarcodeToMove.getText();
        String sourceInventory = sourceInventoryComboBox.getSelectedItem().toString();
        String destinationInventory = destinationInventoryComboBox.getSelectedItem().toString();
        int quantityToMove = Integer.parseInt(QuantityToMove.getText());

        Connection con = javaconnect.connectdb();

        try {
            // Check if the product exists in the source inventory
            String checkDataQuery = "SELECT BARCODE, QUANTITY FROM DATA WHERE BARCODE = ? AND INVENTORY = ?";
            PreparedStatement checkDataStmt = con.prepareStatement(checkDataQuery);
            checkDataStmt.setString(1, barcodeToMove);
            checkDataStmt.setString(2, sourceInventory);
            ResultSet dataResult = checkDataStmt.executeQuery();

            if (dataResult.next()) {
                int existingQuantity = dataResult.getInt("QUANTITY");

                if (existingQuantity < quantityToMove) {
                    JOptionPane.showMessageDialog(null, "You are trying to move more than the quantity currently in the source inventory");
                } else if (existingQuantity == quantityToMove) {
                    // Remove the row from the source inventory
                    String deleteDataQuery = "DELETE FROM DATA WHERE BARCODE = ? AND INVENTORY = ?";
                    PreparedStatement deleteDataStmt = con.prepareStatement(deleteDataQuery);
                    deleteDataStmt.setString(1, barcodeToMove);
                    deleteDataStmt.setString(2, sourceInventory);
                    deleteDataStmt.executeUpdate();
                    
                    // Add the product to the destination inventory
                    String insertDataQuery = "INSERT INTO DATA (BARCODE, INVENTORY, QUANTITY) VALUES (?, ?, ?)";
                    PreparedStatement insertDataStmt = con.prepareStatement(insertDataQuery);
                    insertDataStmt.setString(1, barcodeToMove);
                    insertDataStmt.setString(2, destinationInventory);
                    insertDataStmt.setInt(3, quantityToMove);
                    insertDataStmt.executeUpdate();
                } else {
                    // Update the quantity in the source inventory
                    String updateSourceQuery = "UPDATE DATA SET QUANTITY = QUANTITY - ? WHERE BARCODE = ? AND INVENTORY = ?";
                    PreparedStatement updateSourceStmt = con.prepareStatement(updateSourceQuery);
                    updateSourceStmt.setInt(1, quantityToMove);
                    updateSourceStmt.setString(2, barcodeToMove);
                    updateSourceStmt.setString(3, sourceInventory);
                    updateSourceStmt.executeUpdate();
                    
                    // Check if the product exists in the destination inventory
                    String checkDestinationQuery = "SELECT BARCODE, QUANTITY FROM DATA WHERE BARCODE = ? AND INVENTORY = ?";
                    PreparedStatement checkDestinationStmt = con.prepareStatement(checkDestinationQuery);
                    checkDestinationStmt.setString(1, barcodeToMove);
                    checkDestinationStmt.setString(2, destinationInventory);
                    ResultSet destinationResult = checkDestinationStmt.executeQuery();
                    
                    if (destinationResult.next()) {
                        // Product exists in the destination inventory, update the quantity
                        int destinationQuantity = destinationResult.getInt("QUANTITY");
                        int newDestinationQuantity = destinationQuantity + quantityToMove;

                        // Update the quantity in the destination inventory
                        String updateDestinationQuery = "UPDATE DATA SET QUANTITY = ? WHERE BARCODE = ? AND INVENTORY = ?";
                        PreparedStatement updateDestinationStmt = con.prepareStatement(updateDestinationQuery);
                        updateDestinationStmt.setInt(1, newDestinationQuantity);
                        updateDestinationStmt.setString(2, barcodeToMove);
                        updateDestinationStmt.setString(3, destinationInventory);
                        updateDestinationStmt.executeUpdate();
                    } else {
                        // Product doesn't exist in the destination inventory, insert a new row
                        String insertDataQuery = "INSERT INTO DATA (BARCODE, INVENTORY, QUANTITY) VALUES (?, ?, ?)";
                        PreparedStatement insertDataStmt = con.prepareStatement(insertDataQuery);
                        insertDataStmt.setString(1, barcodeToMove);
                        insertDataStmt.setString(2, destinationInventory);
                        insertDataStmt.setInt(3, quantityToMove);
                        insertDataStmt.executeUpdate();
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "Product Doesn't Exist in the source inventory.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BarcodeToMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BarcodeToMoveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BarcodeToMoveActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarcodeToMove;
    private javax.swing.JTextField QuantityToMove;
    private javax.swing.JComboBox<String> destinationInventoryComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lb;
    private javax.swing.JComboBox<String> sourceInventoryComboBox;
    // End of variables declaration//GEN-END:variables
}
