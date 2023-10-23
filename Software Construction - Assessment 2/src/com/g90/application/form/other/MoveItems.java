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

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Move Items");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        BarcodeToMove.setText("jTextField1");

        QuantityToMove.setText("jTextField2");

        sourceInventoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        destinationInventoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(344, 344, 344)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(QuantityToMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BarcodeToMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sourceInventoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(destinationInventoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(sourceInventoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(destinationInventoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(BarcodeToMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(QuantityToMove, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94)
                .addComponent(jButton1)
                .addGap(130, 130, 130))
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField BarcodeToMove;
    private javax.swing.JTextField QuantityToMove;
    private javax.swing.JComboBox<String> destinationInventoryComboBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lb;
    private javax.swing.JComboBox<String> sourceInventoryComboBox;
    // End of variables declaration//GEN-END:variables
}
