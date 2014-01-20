/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.travelling.UI;

import com.travelling.entity.CbrCategory;

/**
 *
 * @author Stefan
 */
public class PreferenceBox extends javax.swing.JPanel {

    /**
     * Creates new form PreferenceBox
     */
    public PreferenceBox() {
        initComponents();
    }
    
    private CbrCategory category;
    
    public PreferenceBox(CbrCategory cat) {
        this();
        catName.setText(cat.getName());
        catValue.setText( slider.getValue() + "%" );
        category = cat;
    }
    
    public CbrCategory getCategory() { 
        return category;
    }
    
    public double getValue() {
        return slider.getValue() / 100.;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        catName = new javax.swing.JLabel();
        slider = new javax.swing.JSlider();
        catValue = new javax.swing.JLabel();

        catName.setText("Category:");

        slider.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderStateChanged(evt);
            }
        });

        catValue.setText("value");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(catName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(catValue)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(catName)
                    .addComponent(catValue))
                .addGap(18, 18, 18)
                .addComponent(slider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void sliderStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderStateChanged
        catValue.setText(slider.getValue()+"%");
    }//GEN-LAST:event_sliderStateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel catName;
    private javax.swing.JLabel catValue;
    private javax.swing.JSlider slider;
    // End of variables declaration//GEN-END:variables
}