
package edunova.view;

import edunova.controller.ObradaDjelatnik;
import edunova.model.Djelatnik;
import edunova.util.Alati;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import org.apache.commons.validator.routines.EmailValidator;

public class Autorizacija extends javax.swing.JFrame {

    private ObradaDjelatnik obrada;
   
    public Autorizacija() {
        initComponents();
        
        //sav naš kod nakon init components
        obrada = new ObradaDjelatnik();
        setTitle(Alati.NAZIV_APP);
        
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
        txtEmail = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtLozinka = new javax.swing.JPasswordField();
        btnAutoriziraj = new javax.swing.JButton();
        lblEmailPoruka = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Email");

        txtEmail.setText("oper@proces.hr");
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });

        jLabel2.setText("Lozinka");

        txtLozinka.setText("oper");
        txtLozinka.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLozinkaActionPerformed(evt);
            }
        });
        txtLozinka.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtLozinkaKeyPressed(evt);
            }
        });

        btnAutoriziraj.setText("Autoriziraj");
        btnAutoriziraj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutorizirajActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail)
                    .addComponent(txtLozinka)
                    .addComponent(btnAutoriziraj, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEmailPoruka, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmailPoruka, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(txtLozinka, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnAutoriziraj, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtLozinkaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLozinkaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLozinkaActionPerformed

    private void btnAutorizirajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutorizirajActionPerformed
       reset();
        
        var email = txtEmail.getText().trim();
        
        if(email.isEmpty()){
            lblEmailPoruka.setText("Email obavezno");
            postaviGresku(txtEmail);
            return;
        }
        
        
        if(!EmailValidator.getInstance().isValid(email)){
             lblEmailPoruka.setText("Upisani tekst nije email");
             postaviGresku(txtEmail);
             return;
        }

        
        if(txtLozinka.getPassword().length==0){
            postaviGresku(txtLozinka);
            return;
        }
        
        // tu sam spreman ići provjeravati
        Djelatnik o = obrada.autoriziraj(email, new String(txtLozinka.getPassword()));
        
        if(o==null){
            JOptionPane.showMessageDialog(getRootPane(), 
                    "Neispravna kombinacija email i lozinka");
            return;
        }
        
        //ja sam sigran da si logiran i onda idemo dalje
        Djelatnik logiran = new Djelatnik();
        logiran.setIme(o.getIme());
        logiran.setPrezime(o.getPrezime());
        logiran.setUloga(o.getUloga());
        
        Alati.DJELATNIK=logiran;
        
        new Izbornik().setVisible(true);
        dispose();
    }//GEN-LAST:event_btnAutorizirajActionPerformed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
    if(txtEmail.getText().length()>0){
            txtEmail.setBackground(Color.WHITE);
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAutorizirajActionPerformed(null);
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtLozinkaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLozinkaKeyPressed
        if(txtLozinka.getPassword().length>0){
            txtLozinka.setBackground(Color.WHITE);
        }
        
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            btnAutorizirajActionPerformed(null);
        }
    }//GEN-LAST:event_txtLozinkaKeyPressed

    
    private void postaviGresku(JComponent c){
        c.setBackground(Color.RED);
        c.requestFocus();
    }
    
    private void reset(){
        lblEmailPoruka.setText("");
        txtEmail.setBackground(Color.WHITE);
        txtLozinka.setBackground(Color.WHITE);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutoriziraj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblEmailPoruka;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JPasswordField txtLozinka;
    // End of variables declaration//GEN-END:variables

    
}