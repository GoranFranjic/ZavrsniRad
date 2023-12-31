/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package edunova.view;

import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import edunova.model.Djelatnik;
import edunova.util.HibernateUtil;

/**
 *
 * @author goran
 */
public class ProzorDjelatnik extends javax.swing.JFrame {

    /**
     * Creates new form ProzorDjelatnik
     */
    public ProzorDjelatnik() {
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

        jLabel1 = new javax.swing.JLabel();
        ime = new javax.swing.JTextField();
        spremi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ime");

        ime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imeActionPerformed(evt);
            }
        });
        ime.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                imeKeyPressed(evt);
            }
        });

        spremi.setText("Spremi");
        spremi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spremiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ime, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(spremi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(spremi)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void imeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_imeKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            spremiActionPerformed(null);
        }
    }//GEN-LAST:event_imeKeyPressed

    private void imeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_imeActionPerformed

    private void spremiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spremiActionPerformed
       
        // Unos podataka iz korisničkog sučelja
        String imeDjelatnika = ime.getText();

        // Stvaranje objekta Djelatnik
        Djelatnik djelatnik = new Djelatnik();
        djelatnik.setIme(imeDjelatnika);

        // Spremanje objekta u bazu podataka pomoću Hibernatea
        try {
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            try (Session session = sessionFactory.openSession()) {
                session.beginTransaction();
                session.save(djelatnik); // Spremi djelatnika u bazu podataka
                session.getTransaction().commit();
            }

            JOptionPane.showMessageDialog(this, "Djelatnik uspješno spremljen u bazu.");
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(this, "Greška prilikom spremanja djelatnika: " + e.getMessage());
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProzorDjelatnik().setVisible(true);
            }
        });
    
        
    }//GEN-LAST:event_spremiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField ime;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton spremi;
    // End of variables declaration//GEN-END:variables
}
