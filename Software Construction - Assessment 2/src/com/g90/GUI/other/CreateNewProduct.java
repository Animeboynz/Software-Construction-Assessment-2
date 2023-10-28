package com.g90.gui.other;

import com.formdev.flatlaf.FlatClientProperties;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import com.g90.GUI.Application;
import com.g90.GUI.javaconnect;
import raven.toast.Notifications;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.LayoutManager;

/**
 *
 * @author Raven
 */
public class CreateNewProduct extends javax.swing.JPanel {
    
    public CreateNewProduct() {
        initComponents();
        //javaconnect.connectdb();
        loadTable();
        lb.putClientProperty(FlatClientProperties.STYLE, ""
                + "font:$h1.font");
        init();
    }
    
    private void init() {
        NewProductBarcode.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Barcode");
        NewProductName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Product Name");
        NewProductPrice.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Product Price");
    }
    
    private void loadTable()
    {
        
        try{
            Connection con=javaconnect.connectdb();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM PRODUCTS";
            ResultSet rs = st.executeQuery(sql);
            
            DefaultTableModel tblModel = (DefaultTableModel)jTable1.getModel();
            tblModel.setRowCount(0);
            while(rs.next())
            {
                String Barcode = rs.getString("BARCODE");
                String Name = rs.getString("NAME");
                String Price = rs.getString("PRICE");
                
                String tbData[] = {Barcode, Name, Price};
                //System.out.println(tbData[1]);
                tblModel.addRow(tbData);
            }
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        NewProductName = new javax.swing.JTextField();
        NewProductBarcode = new javax.swing.JTextField();
        NewProductPrice = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        RemoveProductBarcode = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Product Manager");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Barcode", "Name", "Price"
            }
        ));
        jTable1.setColumnSelectionAllowed(true);
        jTable1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTable1);
        jTable1.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        NewProductName.setText("Product Name");

        NewProductBarcode.setText("Barcode");
        NewProductBarcode.setToolTipText("");
        NewProductBarcode.setAutoscrolls(false);
        NewProductBarcode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewProductBarcodeActionPerformed(evt);
            }
        });

        NewProductPrice.setText("Product Price");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Add Product");

        jLabel2.setText("Remove Product");

        RemoveProductBarcode.setText("Barcode");

        jButton2.setText("Remove");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 848, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(RemoveProductBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(NewProductBarcode)
                                        .addComponent(NewProductName)
                                        .addComponent(NewProductPrice)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 1007, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(NewProductBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NewProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(RemoveProductBarcode, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(96, Short.MAX_VALUE))
        );

        jButton1.getAccessibleContext().setAccessibleName("Add Product to DB");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Connection con = javaconnect.connectdb();
        PreparedStatement ps = null;
        String insertQuery = "INSERT INTO PRODUCTS (BARCODE, NAME, PRICE) VALUES (?, ?, ?)";

        try {
            ps = con.prepareStatement(insertQuery);
            ps.setString(1, NewProductBarcode.getText());
            ps.setString(2, NewProductName.getText());
            ps.setDouble(3, Double.parseDouble(NewProductPrice.getText()));

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                // Data inserted successfully
                // You may want to display a success message or update the UI
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "New Product added to the Database");
                loadTable();
            } else {
                // Handle the case where no rows were affected (insert failed)
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            // Close resources (ps, con, rs if used) in a finally block
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // Handle any potential exceptions while closing resources
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void NewProductBarcodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewProductBarcodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewProductBarcodeActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Connection con = javaconnect.connectdb();
        PreparedStatement ps = null;
        String deleteQuery = "DELETE FROM PRODUCTS WHERE BARCODE = ?";

        try {
            String barcodeToDelete = RemoveProductBarcode.getText(); // Assuming you have a text field named BarcodeToDelete

            if (barcodeToDelete.isEmpty()) {
                // Handle the case where the user didn't provide a barcode
                JOptionPane.showMessageDialog(null, "Please enter a barcode to delete.");
                return;
            }

            ps = con.prepareStatement(deleteQuery);
            ps.setString(1, barcodeToDelete);

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                // Data deleted successfully
                // You may want to display a success message or update the UI
                Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Product with barcode '" + barcodeToDelete + "' deleted from the Database");
                loadTable();
            } else {
                // Handle the case where no rows were affected (delete failed)
                JOptionPane.showMessageDialog(null, "No product with barcode '" + barcodeToDelete + "' found in the database.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            // Close resources (ps, con, rs if used) in a finally block
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                // Handle any potential exceptions while closing resources
                JOptionPane.showMessageDialog(null, e);
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField NewProductBarcode;
    private javax.swing.JTextField NewProductName;
    private javax.swing.JTextField NewProductPrice;
    private javax.swing.JTextField RemoveProductBarcode;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
