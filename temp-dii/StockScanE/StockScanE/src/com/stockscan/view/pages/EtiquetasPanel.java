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
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.SwingUtilities;

/**
 *
 * @author alvarolopez
 */
public class EtiquetasPanel extends javax.swing.JFrame {

    private final String TEXTO_BUSCAR = "🔍 Buscar...";

    /**
     * Creates new form EtiquetasPanel
     */
    public EtiquetasPanel() {
        initComponents();
        configurarEventos(); // Activa los eventos de esta vista
    }

    private void configurarEventos() {
        // Pone el texto gris por defecto y da el foco inicial al buscador
        txtBuscarEtiquetas.setForeground(new Color(150, 150, 150));
        SwingUtilities.invokeLater(() -> txtBuscarEtiquetas.requestFocusInWindow());

        // Agrupa todos los checkboxes para aplicarles los mismos eventos
        JCheckBox[] checkboxes = {
            chkProducto1, hkProducto2, chkProducto3,
            chkProducto4, jCheckBox5, chkProducto6, chkProducto7
        };

        // 1. BUSCADOR DE PRODUCTOS (Foco, Ratón y Teclado en tiempo real)
        txtBuscarEtiquetas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Da el foco al buscador al hacer clic izquierdo
                if (e.getButton() == MouseEvent.BUTTON1) {
                    txtBuscarEtiquetas.requestFocusInWindow();
                }
            }
        });

        txtBuscarEtiquetas.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Resalta el borde y limpia el texto de ayuda al entrar
                txtBuscarEtiquetas.setBorder(BorderFactory.createLineBorder(new Color(27, 79, 114), 2));
                if (txtBuscarEtiquetas.getText().equals(TEXTO_BUSCAR)) {
                    txtBuscarEtiquetas.setText("");
                    txtBuscarEtiquetas.setForeground(new Color(28, 28, 30));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Restaura el borde y devuelve el texto de ayuda si quedó vacío
                txtBuscarEtiquetas.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 205), 1));
                if (txtBuscarEtiquetas.getText().trim().isEmpty()) {
                    txtBuscarEtiquetas.setText(TEXTO_BUSCAR);
                    txtBuscarEtiquetas.setForeground(new Color(150, 150, 150));
                }
            }
        });

        txtBuscarEtiquetas.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Filtra los checkboxes visibles según lo que se escribe
                String filtro = txtBuscarEtiquetas.getText().trim().toLowerCase();
                boolean sinFiltro = filtro.isEmpty() || filtro.equals(TEXTO_BUSCAR.toLowerCase());
                for (JCheckBox chk : checkboxes) {
                    chk.setVisible(sinFiltro || chk.getText().toLowerCase().contains(filtro));
                }
            }
        });

        // 2. CHECKBOXES DE SELECCIÓN DE PRODUCTOS (Ratón, Foco y Teclado)
        for (JCheckBox chk : checkboxes) {
            chk.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Pone el cursor de mano sobre cada casilla
                    chk.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Devuelve el cursor normal al salir
                    chk.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Actualiza la vista previa al marcar o desmarcar con clic
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        actualizarVistaPrevia(checkboxes);
                    }
                }
            });

            chk.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Cambia el texto a azul cuando tiene el foco
                    chk.setForeground(new Color(27, 79, 114));
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Devuelve el color oscuro al perder el foco
                    chk.setForeground(new Color(28, 28, 30));
                }
            });

            chk.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    // Actualiza la vista previa si se marca con Espacio o Enter
                    if (e.getKeyCode() == KeyEvent.VK_SPACE || e.getKeyCode() == KeyEvent.VK_ENTER) {
                        actualizarVistaPrevia(checkboxes);
                    }
                }
            });
        }

        // 3. BOTÓN EXPORTAR PDF Y BOTONES "QUITAR" DE LAS TARJETAS
        JButton[] botones = {btnExportarPDF, btnQuitar1, btnQuitar2};
        for (JButton btn : botones) {
            Color colorOriginal = btn.getBackground(); // Guarda el color base del botón
            btn.addMouseListener(new MouseAdapter() {
                private boolean clicIniciado = false; // Controla que el clic empiece dentro

                @Override
                public void mouseEntered(MouseEvent e) {
                    // Cambia el cursor y oscurece el botón de exportar
                    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    if (btn == btnExportarPDF) {
                        btn.setBackground(colorOriginal.darker());
                    }
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Cancela el clic y devuelve el aspecto normal al salir
                    clicIniciado = false;
                    btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    if (btn == btnExportarPDF) {
                        btn.setBackground(colorOriginal);
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    // Marca el inicio del clic izquierdo y da foco al botón
                    if (e.getButton() == MouseEvent.BUTTON1 && btn.isEnabled()) {
                        clicIniciado = true;
                        btn.requestFocusInWindow();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Ejecuta la acción correspondiente al soltar el clic dentro
                    if (e.getButton() == MouseEvent.BUTTON1 && clicIniciado && btn.isEnabled()) {
                        clicIniciado = false;
                        if (btn == btnExportarPDF) {
                            btn.setBackground(colorOriginal);
                            lblSubtituloEtiquetas.setText("PDF generado y listo para imprimir");
                        } else if (btn == btnQuitar1) {
                            chkProducto1.setSelected(false);
                            actualizarVistaPrevia(checkboxes);
                        } else if (btn == btnQuitar2) {
                            hkProducto2.setSelected(false);
                            actualizarVistaPrevia(checkboxes);
                        }
                    }
                }
            });
        }
    }

    /**
     * Cuenta los productos marcados y muestra u oculta sus tarjetas de etiqueta
     */
    private void actualizarVistaPrevia(JCheckBox[] checkboxes) {
        int seleccionados = 0;
        for (JCheckBox chk : checkboxes) {
            if (chk.isSelected()) {
                seleccionados++;
            }
        }
        jPanel1.setVisible(chkProducto1.isSelected());
        panelEtiquetaCard2.setVisible(hkProducto2.isSelected());
        lblSubtituloEtiquetas.setText(seleccionados + " productos seleccionados");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSidebar = new javax.swing.JPanel();
        lblLogoIconoTexto = new javax.swing.JLabel();
        lblLogoSubtitulo = new javax.swing.JLabel();
        btnNavDashboard = new javax.swing.JButton();
        btnNavMapa = new javax.swing.JButton();
        btnNavStock = new javax.swing.JButton();
        btnNavEtiquetas = new javax.swing.JButton();
        btnNavTrazabilidad = new javax.swing.JButton();
        btnNavAlertas = new javax.swing.JButton();
        btnNavEquipo = new javax.swing.JButton();
        btnNavAgenda = new javax.swing.JButton();
        btnNavChat = new javax.swing.JButton();
        lblBadgeAlertas = new javax.swing.JLabel();
        lblBadgeChat = new javax.swing.JLabel();
        lblAvatar = new javax.swing.JLabel();
        lblUsuarioNombre = new javax.swing.JLabel();
        lblUsuarioRol = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lblTituloEtiquetas = new javax.swing.JLabel();
        lblSubtituloEtiquetas = new javax.swing.JLabel();
        btnExportarPDF = new javax.swing.JButton();
        panelSeleccionProductos = new javax.swing.JPanel();
        lblHeaderSeleccionar = new javax.swing.JLabel();
        txtBuscarEtiquetas = new javax.swing.JTextField();
        chkProducto1 = new javax.swing.JCheckBox();
        chkProducto3 = new javax.swing.JCheckBox();
        chkProducto4 = new javax.swing.JCheckBox();
        hkProducto2 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        chkProducto6 = new javax.swing.JCheckBox();
        chkProducto7 = new javax.swing.JCheckBox();
        panelVistaPrevia = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lblEtiqueta1Marca = new javax.swing.JLabel();
        lblEtiqueta1Ubic = new javax.swing.JLabel();
        lblEtiqueta1Nombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblEtiqueta1CodigoText = new javax.swing.JLabel();
        btnQuitar1 = new javax.swing.JButton();
        panelEtiquetaCard2 = new javax.swing.JPanel();
        lblEtiqueta2Marca = new javax.swing.JLabel();
        lblEtiqueta2Ubic = new javax.swing.JLabel();
        lblEtiqueta2Nombre = new javax.swing.JLabel();
        lblEtiqueta2Barcode = new javax.swing.JLabel();
        lblEtiqueta2CodigoText = new javax.swing.JLabel();
        btnQuitar2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(32767, 32767));
        setMinimumSize(new java.awt.Dimension(900, 600));

        panelSidebar.setBackground(new java.awt.Color(18, 30, 43));
        panelSidebar.setPreferredSize(new java.awt.Dimension(220, 600));

        lblLogoIconoTexto.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblLogoIconoTexto.setForeground(new java.awt.Color(255, 255, 255));
        lblLogoIconoTexto.setText("StockScan");

        lblLogoSubtitulo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblLogoSubtitulo.setForeground(new java.awt.Color(174, 174, 178));
        lblLogoSubtitulo.setText("Almacén Central");

        btnNavDashboard.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavDashboard.setForeground(new java.awt.Color(174, 174, 178));
        btnNavDashboard.setText("📊 Dashboard");
        btnNavDashboard.setBorderPainted(false);
        btnNavDashboard.setContentAreaFilled(false);
        btnNavDashboard.setFocusPainted(false);
        btnNavDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavDashboard.setPreferredSize(new java.awt.Dimension(200, 44));
        btnNavDashboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavDashboardActionPerformed(evt);
            }
        });

        btnNavMapa.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavMapa.setForeground(new java.awt.Color(174, 174, 178));
        btnNavMapa.setText("🗺️ Mapa de almacén");
        btnNavMapa.setBorderPainted(false);
        btnNavMapa.setContentAreaFilled(false);
        btnNavMapa.setFocusPainted(false);
        btnNavMapa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavMapa.setPreferredSize(new java.awt.Dimension(200, 44));
        btnNavMapa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavMapaActionPerformed(evt);
            }
        });

        btnNavStock.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavStock.setForeground(new java.awt.Color(174, 174, 178));
        btnNavStock.setText("📦 Stock");
        btnNavStock.setBorderPainted(false);
        btnNavStock.setContentAreaFilled(false);
        btnNavStock.setFocusPainted(false);
        btnNavStock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavStock.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavEtiquetas.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavEtiquetas.setForeground(new java.awt.Color(27, 79, 114));
        btnNavEtiquetas.setText("🏷️ Etiquetas");
        btnNavEtiquetas.setBorderPainted(false);
        btnNavEtiquetas.setFocusPainted(false);
        btnNavEtiquetas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavEtiquetas.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavTrazabilidad.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavTrazabilidad.setForeground(new java.awt.Color(174, 174, 178));
        btnNavTrazabilidad.setText("📈 Trazabilidad");
        btnNavTrazabilidad.setBorderPainted(false);
        btnNavTrazabilidad.setContentAreaFilled(false);
        btnNavTrazabilidad.setFocusPainted(false);
        btnNavTrazabilidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavTrazabilidad.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavAlertas.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavAlertas.setForeground(new java.awt.Color(174, 174, 178));
        btnNavAlertas.setText("⚠️ Alertas");
        btnNavAlertas.setBorderPainted(false);
        btnNavAlertas.setContentAreaFilled(false);
        btnNavAlertas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavAlertas.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavEquipo.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavEquipo.setForeground(new java.awt.Color(174, 174, 178));
        btnNavEquipo.setText("👥 Equipo");
        btnNavEquipo.setBorderPainted(false);
        btnNavEquipo.setContentAreaFilled(false);
        btnNavEquipo.setFocusPainted(false);
        btnNavEquipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavEquipo.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavAgenda.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavAgenda.setForeground(new java.awt.Color(174, 174, 178));
        btnNavAgenda.setText("📅 Agenda");
        btnNavAgenda.setBorderPainted(false);
        btnNavAgenda.setContentAreaFilled(false);
        btnNavAgenda.setDefaultCapable(false);
        btnNavAgenda.setFocusPainted(false);
        btnNavAgenda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavAgenda.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavChat.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavChat.setForeground(new java.awt.Color(174, 174, 178));
        btnNavChat.setText("💬 Chat");
        btnNavChat.setBorderPainted(false);
        btnNavChat.setContentAreaFilled(false);
        btnNavChat.setFocusPainted(false);
        btnNavChat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavChat.setPreferredSize(new java.awt.Dimension(200, 44));
        btnNavChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavChatActionPerformed(evt);
            }
        });

        lblBadgeAlertas.setBackground(new java.awt.Color(231, 76, 60));
        lblBadgeAlertas.setFont(new java.awt.Font("Helvetica Neue", 1, 11)); // NOI18N
        lblBadgeAlertas.setForeground(new java.awt.Color(255, 255, 255));
        lblBadgeAlertas.setText("12");
        lblBadgeAlertas.setOpaque(true);
        lblBadgeAlertas.setPreferredSize(new java.awt.Dimension(22, 22));

        lblBadgeChat.setBackground(new java.awt.Color(231, 76, 60));
        lblBadgeChat.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lblBadgeChat.setForeground(new java.awt.Color(255, 255, 255));
        lblBadgeChat.setText("3");
        lblBadgeChat.setOpaque(true);
        lblBadgeChat.setPreferredSize(new java.awt.Dimension(22, 22));

        lblAvatar.setBackground(new java.awt.Color(243, 156, 18));
        lblAvatar.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lblAvatar.setForeground(new java.awt.Color(255, 255, 255));
        lblAvatar.setText("AR");
        lblAvatar.setOpaque(true);
        lblAvatar.setPreferredSize(new java.awt.Dimension(32, 32));

        lblUsuarioNombre.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lblUsuarioNombre.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioNombre.setText("Ana Rodríguez");

        lblUsuarioRol.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        lblUsuarioRol.setForeground(new java.awt.Color(174, 174, 178));
        lblUsuarioRol.setText("Admin");

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/stockscan/view/pages/Logo.png"))); // NOI18N

        javax.swing.GroupLayout panelSidebarLayout = new javax.swing.GroupLayout(panelSidebar);
        panelSidebar.setLayout(panelSidebarLayout);
        panelSidebarLayout.setHorizontalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNavAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSidebarLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addComponent(jLabel16)
                            .addGap(18, 18, 18)
                            .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblLogoSubtitulo)
                                .addComponent(lblLogoIconoTexto)))
                        .addGroup(panelSidebarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnNavDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNavMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelSidebarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnNavStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnNavEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(panelSidebarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnNavTrazabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(panelSidebarLayout.createSequentialGroup()
                                    .addComponent(btnNavAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(lblBadgeAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(panelSidebarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnNavEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(panelSidebarLayout.createSequentialGroup()
                            .addGap(16, 16, 16)
                            .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblUsuarioNombre)
                                .addComponent(lblUsuarioRol)))
                        .addGroup(panelSidebarLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnNavChat, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(lblBadgeChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSidebarLayout.setVerticalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblLogoIconoTexto)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblLogoSubtitulo)
                .addGap(18, 18, 18)
                .addComponent(btnNavDashboard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNavMapa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNavStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNavEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNavTrazabilidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNavAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBadgeAlertas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNavEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNavAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNavChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblBadgeChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblAvatar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSidebarLayout.createSequentialGroup()
                        .addComponent(lblUsuarioNombre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuarioRol)))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        lblTituloEtiquetas.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTituloEtiquetas.setForeground(new java.awt.Color(28, 28, 30));
        lblTituloEtiquetas.setText("Generador de etiquetas");

        lblSubtituloEtiquetas.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblSubtituloEtiquetas.setForeground(new java.awt.Color(110, 110, 115));
        lblSubtituloEtiquetas.setText("2 productos seleccionados");

        btnExportarPDF.setBackground(new java.awt.Color(27, 79, 114));
        btnExportarPDF.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        btnExportarPDF.setForeground(new java.awt.Color(255, 255, 255));
        btnExportarPDF.setText("📥 Exportar PDF");

        panelSeleccionProductos.setBackground(new java.awt.Color(255, 255, 255));

        lblHeaderSeleccionar.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblHeaderSeleccionar.setText("Seleccionar productos");

        txtBuscarEtiquetas.setText("🔍 Buscar...");

        chkProducto1.setSelected(true);
        chkProducto1.setText("Tornillo M8 inox. 25mm");

        chkProducto3.setText("Guante de nitrilo talla M");

        chkProducto4.setText("Cinta adhesiva embalaje 48mm");

        hkProducto2.setSelected(true);
        hkProducto2.setText("Cable UTP Cat6 (caja 305m)");

        jCheckBox5.setText("Caja cartón 40×30×25cm");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox5ActionPerformed(evt);
            }
        });

        chkProducto6.setText("Precinto 25mm × 66m");

        chkProducto7.setText("Brida plástico 200mm");

        javax.swing.GroupLayout panelSeleccionProductosLayout = new javax.swing.GroupLayout(panelSeleccionProductos);
        panelSeleccionProductos.setLayout(panelSeleccionProductosLayout);
        panelSeleccionProductosLayout.setHorizontalGroup(
            panelSeleccionProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeleccionProductosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelSeleccionProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkProducto7)
                    .addComponent(chkProducto6)
                    .addComponent(jCheckBox5)
                    .addComponent(hkProducto2)
                    .addComponent(chkProducto4)
                    .addComponent(chkProducto3)
                    .addComponent(chkProducto1)
                    .addComponent(txtBuscarEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHeaderSeleccionar))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        panelSeleccionProductosLayout.setVerticalGroup(
            panelSeleccionProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSeleccionProductosLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblHeaderSeleccionar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscarEtiquetas, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(chkProducto1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hkProducto2)
                .addGap(18, 18, 18)
                .addComponent(chkProducto3)
                .addGap(18, 18, 18)
                .addComponent(chkProducto4)
                .addGap(18, 18, 18)
                .addComponent(jCheckBox5)
                .addGap(18, 18, 18)
                .addComponent(chkProducto6)
                .addGap(18, 18, 18)
                .addComponent(chkProducto7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelVistaPrevia.setBackground(new java.awt.Color(245, 247, 250));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 236, 240)));

        lblEtiqueta1Marca.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        lblEtiqueta1Marca.setText("STOCKSCAN");

        lblEtiqueta1Ubic.setBackground(new java.awt.Color(18, 30, 43));
        lblEtiqueta1Ubic.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblEtiqueta1Ubic.setForeground(new java.awt.Color(18, 30, 43));
        lblEtiqueta1Ubic.setText("LOC EST -04");

        lblEtiqueta1Nombre.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lblEtiqueta1Nombre.setText("Tornillo M8 inox. 25mm");

        jLabel1.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        jLabel1.setText("||||| |||| |||||||| ||||");

        lblEtiqueta1CodigoText.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        lblEtiqueta1CodigoText.setText("PRD-0041-PAS02EST04");

        btnQuitar1.setForeground(new java.awt.Color(231, 76, 60));
        btnQuitar1.setText("Quitar");
        btnQuitar1.setContentAreaFilled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEtiqueta1Marca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEtiqueta1Ubic, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(lblEtiqueta1Nombre)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblEtiqueta1CodigoText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(btnQuitar1)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEtiqueta1Marca)
                    .addComponent(lblEtiqueta1Ubic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEtiqueta1Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEtiqueta1CodigoText)
                    .addComponent(btnQuitar1))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        panelEtiquetaCard2.setBackground(new java.awt.Color(255, 255, 255));
        panelEtiquetaCard2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(232, 236, 240)));

        lblEtiqueta2Marca.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        lblEtiqueta2Marca.setText("STOCKSCAN");

        lblEtiqueta2Ubic.setBackground(new java.awt.Color(18, 30, 43));
        lblEtiqueta2Ubic.setFont(new java.awt.Font("Helvetica Neue", 1, 13)); // NOI18N
        lblEtiqueta2Ubic.setForeground(new java.awt.Color(18, 30, 43));
        lblEtiqueta2Ubic.setText("LOC EST-02");

        lblEtiqueta2Nombre.setFont(new java.awt.Font("Helvetica Neue", 1, 12)); // NOI18N
        lblEtiqueta2Nombre.setText("Cable UTP Cat6 (caja 305m)");

        lblEtiqueta2Barcode.setFont(new java.awt.Font("Monospaced", 1, 13)); // NOI18N
        lblEtiqueta2Barcode.setText("||||| |||| |||||||| ||||");

        lblEtiqueta2CodigoText.setFont(new java.awt.Font("Helvetica Neue", 0, 10)); // NOI18N
        lblEtiqueta2CodigoText.setText("PRD-0087-PAS01EST02");

        btnQuitar2.setForeground(new java.awt.Color(231, 76, 60));
        btnQuitar2.setText("Quitar");
        btnQuitar2.setContentAreaFilled(false);

        javax.swing.GroupLayout panelEtiquetaCard2Layout = new javax.swing.GroupLayout(panelEtiquetaCard2);
        panelEtiquetaCard2.setLayout(panelEtiquetaCard2Layout);
        panelEtiquetaCard2Layout.setHorizontalGroup(
            panelEtiquetaCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEtiquetaCard2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEtiquetaCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelEtiquetaCard2Layout.createSequentialGroup()
                        .addComponent(lblEtiqueta2Marca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblEtiqueta2Ubic, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelEtiquetaCard2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(panelEtiquetaCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblEtiqueta2Barcode)
                            .addComponent(lblEtiqueta2Nombre)
                            .addGroup(panelEtiquetaCard2Layout.createSequentialGroup()
                                .addComponent(lblEtiqueta2CodigoText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(btnQuitar2)))))
                .addContainerGap())
        );
        panelEtiquetaCard2Layout.setVerticalGroup(
            panelEtiquetaCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEtiquetaCard2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelEtiquetaCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEtiqueta2Marca)
                    .addComponent(lblEtiqueta2Ubic))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEtiqueta2Nombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblEtiqueta2Barcode, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelEtiquetaCard2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEtiqueta2CodigoText)
                    .addComponent(btnQuitar2))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout panelVistaPreviaLayout = new javax.swing.GroupLayout(panelVistaPrevia);
        panelVistaPrevia.setLayout(panelVistaPreviaLayout);
        panelVistaPreviaLayout.setHorizontalGroup(
            panelVistaPreviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVistaPreviaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelVistaPreviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelEtiquetaCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(108, Short.MAX_VALUE))
        );
        panelVistaPreviaLayout.setVerticalGroup(
            panelVistaPreviaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelVistaPreviaLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelEtiquetaCard2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblSubtituloEtiquetas)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(panelSeleccionProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(panelVistaPrevia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblTituloEtiquetas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(40, 40, 40))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloEtiquetas)
                    .addComponent(btnExportarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtituloEtiquetas)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelVistaPrevia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelSeleccionProductos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavDashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavDashboardActionPerformed

    private void btnNavMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavMapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavMapaActionPerformed

    private void btnNavChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavChatActionPerformed

    private void jCheckBox5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox5ActionPerformed

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
            java.util.logging.Logger.getLogger(EtiquetasPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EtiquetasPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EtiquetasPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EtiquetasPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EtiquetasPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExportarPDF;
    private javax.swing.JButton btnNavAgenda;
    private javax.swing.JButton btnNavAlertas;
    private javax.swing.JButton btnNavChat;
    private javax.swing.JButton btnNavDashboard;
    private javax.swing.JButton btnNavEquipo;
    private javax.swing.JButton btnNavEtiquetas;
    private javax.swing.JButton btnNavMapa;
    private javax.swing.JButton btnNavStock;
    private javax.swing.JButton btnNavTrazabilidad;
    private javax.swing.JButton btnQuitar1;
    private javax.swing.JButton btnQuitar2;
    private javax.swing.JCheckBox chkProducto1;
    private javax.swing.JCheckBox chkProducto3;
    private javax.swing.JCheckBox chkProducto4;
    private javax.swing.JCheckBox chkProducto6;
    private javax.swing.JCheckBox chkProducto7;
    private javax.swing.JCheckBox hkProducto2;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblBadgeAlertas;
    private javax.swing.JLabel lblBadgeChat;
    private javax.swing.JLabel lblEtiqueta1CodigoText;
    private javax.swing.JLabel lblEtiqueta1Marca;
    private javax.swing.JLabel lblEtiqueta1Nombre;
    private javax.swing.JLabel lblEtiqueta1Ubic;
    private javax.swing.JLabel lblEtiqueta2Barcode;
    private javax.swing.JLabel lblEtiqueta2CodigoText;
    private javax.swing.JLabel lblEtiqueta2Marca;
    private javax.swing.JLabel lblEtiqueta2Nombre;
    private javax.swing.JLabel lblEtiqueta2Ubic;
    private javax.swing.JLabel lblHeaderSeleccionar;
    private javax.swing.JLabel lblLogoIconoTexto;
    private javax.swing.JLabel lblLogoSubtitulo;
    private javax.swing.JLabel lblSubtituloEtiquetas;
    private javax.swing.JLabel lblTituloEtiquetas;
    private javax.swing.JLabel lblUsuarioNombre;
    private javax.swing.JLabel lblUsuarioRol;
    private javax.swing.JPanel panelEtiquetaCard2;
    private javax.swing.JPanel panelSeleccionProductos;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JPanel panelVistaPrevia;
    private javax.swing.JTextField txtBuscarEtiquetas;
    // End of variables declaration//GEN-END:variables
}
