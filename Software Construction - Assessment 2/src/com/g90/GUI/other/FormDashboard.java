package com.g90.gui.other;
//package com.g90.application.form.other;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import raven.toast.Notifications;


public class FormDashboard extends javax.swing.JPanel {

    public FormDashboard() {
        setLayout(new BorderLayout());

//        initComponents();
        // Bar chart
        DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
        barDataset.addValue(85, "Sales", "B2B");
        barDataset.addValue(74, "Sales", "B2C");
        barDataset.addValue(67, "Support", "B2C");
        JFreeChart barChart = ChartFactory.createBarChart(
                "Sales and Support Stats",
                "Type",
                "Percentage",
                barDataset
        );

        ChartPanel barChartPanel = new ChartPanel(barChart);
        barChartPanel.setBackground(Color.red);

        // Pie chart
        DefaultPieDataset pieDataset = new DefaultPieDataset();
        pieDataset.setValue("B2B Sales", 85);
        pieDataset.setValue("B2C Sales", 74);
        pieDataset.setValue("B2C Support", 67);
        JFreeChart pieChart = ChartFactory.createPieChart("Sales Distribution", pieDataset);
        ChartPanel pieChartPanel = new ChartPanel(pieChart);

        // Creating a central panel for the charts
        JPanel centerPanel = new JPanel(new GridLayout(2, 1)); // This will hold both charts
        centerPanel.setBackground(Color.BLACK);
        centerPanel.add(barChartPanel);
        centerPanel.add(pieChartPanel);

        // Adding the charts to the central part of the BorderLayout
        add(centerPanel, BorderLayout.CENTER);

        lb = new javax.swing.JLabel();
        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Dashboard");
        lb.putClientProperty(FlatClientProperties.STYLE, "font:$h1.font");

        jButton1 = new javax.swing.JButton();
        jButton1.setText("Show Notifications Test");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        // Adding the label and button to the NORTH part of the BorderLayout
        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(lb, BorderLayout.CENTER);
        topPanel.add(jButton1, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);
        

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        lb.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb.setText("Dashboard");

        jButton1.setText("Show Notifications Test");
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
                .addContainerGap()
                .addComponent(lb, javax.swing.GroupLayout.DEFAULT_SIZE, 625, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jButton1)))
                .addContainerGap(417, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Hello sample message");
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lb;
    // End of variables declaration//GEN-END:variables
}
