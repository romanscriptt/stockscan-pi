/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.stockscan.view.pages;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

/**
 *
 * @author alvarolopez
 */
public class Login extends javax.swing.JFrame {

    private final String TEXTO_EMAIL = "operario1@stockscan.io";

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        configurarEventos(); // Activa los eventos del login
    }

    private void configurarEventos() {
        // 1. EVENTOS DE FOCO Y TECLADO EN LOS CAMPOS DE TEXTO
        txtEmail.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Resalta el borde y limpia el correo de ejemplo al entrar
                txtEmail.setBorder(BorderFactory.createLineBorder(new Color(27, 79, 114), 2));
                if (txtEmail.getText().equals("operario1@stockscan.io")) {
                    txtEmail.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Devuelve el borde normal al salir del campo
                txtEmail.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 205), 1));
            }
        });

        jPasswordField1.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Resalta el borde y borra el texto por defecto de la contraseña
                jPasswordField1.setBorder(BorderFactory.createLineBorder(new Color(27, 79, 114), 2));
                if (String.valueOf(jPasswordField1.getPassword()).equals("jPasswordField1")) {
                    jPasswordField1.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Restaura el borde gris al salir
                jPasswordField1.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 205), 1));
            }
        });

        // Al pulsar Enter en la contraseña se activa el botón
        jPasswordField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Confirma el acceso en verde al pulsar Enter
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    lblSubtituloLogin.setForeground(new Color(39, 174, 96));
                    lblSubtituloLogin.setText("Acceso iniciado correctamente");
                }
            }
        });

        // 2. EVENTOS DE RATÓN, FOCO Y TECLADO EN EL BOTÓN INICIAR SESIÓN
        Color colorOriginal = btnIniciarSesion.getBackground(); // Guarda el color base para restaurarlo

        btnIniciarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Pone cursor de mano y oscurece el botón al pasar por encima
                btnIniciarSesion.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnIniciarSesion.setBackground(colorOriginal.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Devuelve el cursor y el color normal al salir
                btnIniciarSesion.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                btnIniciarSesion.setBackground(colorOriginal);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Muestra el mensaje de acceso correcto al hacer clic izquierdo
                if (e.getButton() == MouseEvent.BUTTON1) {
                    lblSubtituloLogin.setForeground(new Color(39, 174, 96));
                    lblSubtituloLogin.setText("Acceso iniciado correctamente");
                }
            }
        });

        btnIniciarSesion.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Pinta un borde blanco cuando el botón tiene el foco
                btnIniciarSesion.setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
                btnIniciarSesion.setBorderPainted(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Oculta el borde al perder el foco
                btnIniciarSesion.setBorderPainted(false);
            }
        });

        btnIniciarSesion.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Inicia sesión al pulsar Enter o Espacio con el botón enfocado
                if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                    lblSubtituloLogin.setForeground(new Color(39, 174, 96));
                    lblSubtituloLogin.setText("Acceso iniciado correctamente");
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogoTexto = new javax.swing.JLabel();
        lblLogoSubtitulo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblTituloLogin = new javax.swing.JLabel();
        lblEmail = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        btnIniciarSesion = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        lblSubtituloLogin = new javax.swing.JLabel();
        lblSeguridad = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(18, 30, 43));

        jPanel1.setBackground(new java.awt.Color(18, 30, 43));

        lblLogoTexto.setFont(new java.awt.Font("Helvetica Neue", 1, 32)); // NOI18N
        lblLogoTexto.setForeground(new java.awt.Color(255, 255, 255));
        lblLogoTexto.setText("StockScan");

        lblLogoSubtitulo.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblLogoSubtitulo.setForeground(new java.awt.Color(174, 174, 178));
        lblLogoSubtitulo.setText("Sistema de gestión de almacenes");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/stockscan/view/pages/Logo.png"))); // NOI18N

        lblTituloLogin.setFont(new java.awt.Font("Helvetica Neue", 1, 24)); // NOI18N
        lblTituloLogin.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloLogin.setText("Iniciar sesión");

        lblEmail.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lblEmail.setForeground(new java.awt.Color(255, 255, 255));
        lblEmail.setText("Correo electrónico");

        jPasswordField1.setText("jPasswordField1");

        btnIniciarSesion.setBackground(new java.awt.Color(27, 79, 114));
        btnIniciarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnIniciarSesion.setText("Iniciar sesión");
        btnIniciarSesion.setBorderPainted(false);

        txtEmail.setBackground(new java.awt.Color(245, 247, 250));
        txtEmail.setText("operario1@stockscan.io");

        lblPassword.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Contraseña");

        lblSubtituloLogin.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblSubtituloLogin.setForeground(new java.awt.Color(110, 110, 115));
        lblSubtituloLogin.setText("Introduce tus credenciales para acceder");

        lblSeguridad.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        lblSeguridad.setForeground(new java.awt.Color(39, 174, 96));
        lblSeguridad.setText("🔒 Conexión segura y cifrada");

        jButton1.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("¿Olvidaste tu contraseña?");
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblEmail)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(lblPassword)
                        .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                        .addComponent(jPasswordField1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(416, 416, 416)
                .addComponent(lblLogoTexto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(401, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblSubtituloLogin)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblLogoSubtitulo)
                            .addGap(382, 382, 382))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(btnIniciarSesion)
                            .addGap(430, 430, 430))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(lblSeguridad)
                            .addGap(413, 413, 413))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jButton1)
                            .addGap(402, 402, 402)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(415, 415, 415)
                .addComponent(lblTituloLogin)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(470, 470, 470))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLogoTexto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblLogoSubtitulo)
                .addGap(18, 18, 18)
                .addComponent(lblTituloLogin)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSubtituloLogin)
                .addGap(27, 27, 27)
                .addComponent(lblEmail)
                .addGap(18, 18, 18)
                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnIniciarSesion)
                .addGap(18, 18, 18)
                .addComponent(lblSeguridad)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(109, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciarSesion;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JLabel lblEmail;
    private javax.swing.JLabel lblLogoSubtitulo;
    private javax.swing.JLabel lblLogoTexto;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblSeguridad;
    private javax.swing.JLabel lblSubtituloLogin;
    private javax.swing.JLabel lblTituloLogin;
    private javax.swing.JTextField txtEmail;
    // End of variables declaration//GEN-END:variables
}
