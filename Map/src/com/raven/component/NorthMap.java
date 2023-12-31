/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.raven.component;

/**
 *
 * @author ADMIN
 */
public class NorthMap extends javax.swing.JPanel {

    /**
     * Creates new form North
     */
    public NorthMap() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Shop = new javax.swing.JLabel();
        Water1 = new javax.swing.JLabel();
        Water2 = new javax.swing.JLabel();
        Water3 = new javax.swing.JLabel();
        Water4 = new javax.swing.JLabel();
        Hospital = new javax.swing.JLabel();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Shop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/shop-01_270x270.png"))); // NOI18N
        Shop.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Water1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/water-01_135x270.png"))); // NOI18N
        Water1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Water2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/water-01_135x270.png"))); // NOI18N
        Water2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Water3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/water-01_135x270.png"))); // NOI18N
        Water3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Water4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/water-01_135x270.png"))); // NOI18N
        Water4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        Hospital.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/hospital-01_270x270.png"))); // NOI18N
        Hospital.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Shop)
                .addGap(0, 0, 0)
                .addComponent(Water4)
                .addGap(0, 0, 0)
                .addComponent(Water1)
                .addGap(0, 0, 0)
                .addComponent(Water2)
                .addGap(0, 0, 0)
                .addComponent(Water3)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(Hospital)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Shop)
                    .addComponent(Water1)
                    .addComponent(Water2)
                    .addComponent(Water3)
                    .addComponent(Water4)
                    .addComponent(Hospital))
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Hospital;
    private javax.swing.JLabel Shop;
    private javax.swing.JLabel Water1;
    private javax.swing.JLabel Water2;
    private javax.swing.JLabel Water3;
    private javax.swing.JLabel Water4;
    // End of variables declaration//GEN-END:variables
}
