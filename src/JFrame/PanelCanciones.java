/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import java.awt.BorderLayout;
import java.io.IOException;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import manjarprogramacion.Metodos;

/**
 *
 * @author oracle
 */
public class PanelCanciones extends javax.swing.JFrame {

    /**
     * Creates new form PanelCanciones
     */
    static int contador = 0;
        ImageIcon imagen2 = new ImageIcon(this.getClass().getResource("/imagenes_contador/2.png"));
        ImageIcon imagen3 = new ImageIcon(this.getClass().getResource("/imagenes_contador/3.png"));
        ImageIcon imagen4 = new ImageIcon(this.getClass().getResource("/imagenes_contador/4.png"));
        ImageIcon imagen5 = new ImageIcon(this.getClass().getResource("/imagenes_contador/5.png"));
    
    public PanelCanciones() {
        initComponents();
        ((JPanel) getContentPane()).setOpaque(false);
        ImageIcon imagen_fondo = new ImageIcon(this.getClass().getResource("/fondo_decorado/img_pc.png"));
       
        JLabel fondo = new JLabel();
        fondo.setIcon(imagen_fondo);
        getLayeredPane().add(fondo, JLayeredPane.FRAME_CONTENT_LAYER);
        fondo.setBounds(0, 0, imagen_fondo.getIconWidth(), imagen_fondo.getIconHeight());
        this.add(fondo, BorderLayout.CENTER);
        this.setSize(fondo.getWidth(), fondo.getHeight());
        this.setLocationRelativeTo(null);
     
    }
    
    
    Metodos obx_metodos = new Metodos();
    IntroScore obx_score = new IntroScore();

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jToggleButton2 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_contador/1.png"))); // NOI18N

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jToggleButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_botones/Normal2.png"))); // NOI18N
        jToggleButton2.setBorderPainted(false);
        jToggleButton2.setContentAreaFilled(false);
        jToggleButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jToggleButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton2.setIconTextGap(-3);
        jToggleButton2.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_botones/Ultimo2.png"))); // NOI18N
        jToggleButton2.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes_botones/Medio2.png"))); // NOI18N
        jToggleButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jToggleButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(474, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jToggleButton2)
                        .addGap(80, 80, 80))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addComponent(jToggleButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        //Variable donde se guarda el texto que introduces
        
        String nombre;
        nombre = jTextField1.getText();
        //Comparación
        obx_metodos.sonidoMenu("button");
        obx_metodos.comprobarCampeon(nombre);
        jTextField1.setText(null);
        obx_metodos.leerArchivo(obx_metodos.generarNumero());

        contador(contador);
        
        if (contador > 4) {
            setVisible(false);
            
            obx_score.setVisible(true);
            obx_score.jLabel2.setText(obx_metodos.devolverPuntuacion());

            contador = 0;

        }

    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        obx_metodos.sonidoMenu("button");
        obx_metodos.sonido();
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    public void contador(int x) {
        
            
        if(this.contador == 0){
            jLabel2.setIcon(imagen2);
        }
        if(this.contador == 1){
            jLabel2.setIcon(imagen3);
        }
        if(this.contador == 2){
            jLabel2.setIcon(imagen4);
        }
        if(this.contador == 3){
            jLabel2.setIcon(imagen5);
        }
        if (contador < 6) {
            contador++;
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
