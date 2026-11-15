/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.stockscan.view.pages;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Vista principal de gestión de inventario y stock (StockScan SGA).
 *
 * @author alvarolopez
 */
public class StockPanel extends javax.swing.JFrame {

    /**
     * Creates new form StockPanel
     */
    public StockPanel() {
        initComponents();
        configurarEventos(); // Activa los eventos de esta pantalla
    }

    private void configurarEventos() {
        // Texto por defecto para el buscador
        final String PLACEHOLDER = "Buscar por nombre o código...";

        // 1. EVENTOS DE FOCO Y TECLADO EN EL BUSCADOR (txtBuscarStock)
        txtBuscarStock.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Resalta el borde y borra el texto de ayuda al entrar
                txtBuscarStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(27, 79, 114), 2));
                if (txtBuscarStock.getText().equals(PLACEHOLDER)) {
                    txtBuscarStock.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Restaura el borde y vuelve a poner el texto de ayuda si está vacío
                txtBuscarStock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(200, 200, 205), 1));
                if (txtBuscarStock.getText().trim().isEmpty()) {
                    txtBuscarStock.setText(PLACEHOLDER);
                }
            }
        });

        txtBuscarStock.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Muestra en el subtítulo lo que se va escribiendo
                String texto = txtBuscarStock.getText().trim();
                lblSubtituloStock.setText(texto.isEmpty() ? "8 productos · 4 alertas" : "Buscando: " + texto);
            }
        });

        // 2. EVENTOS DE RATÓN EN "+ AÑADIR PRODUCTO"
        btnAñadirProducto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambia el cursor a mano y oscurece el botón al pasar por encima
                btnAñadirProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btnAñadirProducto.setBackground(new java.awt.Color(20, 60, 88));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Devuelve el cursor y el color original al salir
                btnAñadirProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                btnAñadirProducto.setBackground(new java.awt.Color(27, 79, 114));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Actualiza el subtítulo al hacer clic izquierdo
                if (e.getButton() == MouseEvent.BUTTON1) {
                    lblSubtituloStock.setText("Nuevo producto seleccionado");
                }
            }
        });

        // 3. EVENTOS DE RATÓN EN LOS BOTONES DE FILTRO DE CATEGORÍA
        javax.swing.JButton[] botonesFiltro = {
            btnFiltroTodos, btnFiltroFerreteria, btnFiltroElectronica,
            btnFiltroEPI, btnFiltroConsumibles, btnFiltroEmbalaje
        };

        for (javax.swing.JButton btn : botonesFiltro) {
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Pone el cursor de mano sobre cada filtro
                    btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Devuelve el cursor normal al salir
                    btn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        // Desmarca todos los botones de filtro
                        for (javax.swing.JButton b : botonesFiltro) {
                            b.setContentAreaFilled(false);
                            b.setForeground(new java.awt.Color(110, 110, 115));
                        }
                        // Pinta el filtro pulsado y muestra su nombre arriba
                        btn.setContentAreaFilled(true);
                        btn.setBackground(new java.awt.Color(27, 79, 114));
                        btn.setForeground(java.awt.Color.WHITE);
                        lblSubtituloStock.setText("Categoría: " + btn.getText());
                    }
                }
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollTablaStock = new javax.swing.JScrollPane();
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
        jLabel1 = new javax.swing.JLabel();
        lblTituloStock = new javax.swing.JLabel();
        lblSubtituloStock = new javax.swing.JLabel();
        btnAñadirProducto = new javax.swing.JButton();
        panelBarraFiltros = new javax.swing.JPanel();
        txtBuscarStock = new javax.swing.JTextField();
        btnFiltroTodos = new javax.swing.JButton();
        btnFiltroElectronica = new javax.swing.JButton();
        btnFiltroFerreteria = new javax.swing.JButton();
        btnFiltroEPI = new javax.swing.JButton();
        btnFiltroConsumibles = new javax.swing.JButton();
        btnFiltroEmbalaje = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductosStock = new javax.swing.JTable();

        scrollTablaStock.setPreferredSize(new java.awt.Dimension(730, 440));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(32767, 32767));
        setMinimumSize(new java.awt.Dimension(900, 600));
        setPreferredSize(new java.awt.Dimension(1000, 620));

        panelSidebar.setBackground(new java.awt.Color(18, 30, 43));
        panelSidebar.setPreferredSize(new java.awt.Dimension(220, 600));

        lblLogoIconoTexto.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblLogoIconoTexto.setForeground(new java.awt.Color(255, 255, 255));
        lblLogoIconoTexto.setText("StockScan");

        lblLogoSubtitulo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblLogoSubtitulo.setForeground(new java.awt.Color(174, 174, 178));
        lblLogoSubtitulo.setText("Almacen Central");

        btnNavDashboard.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavDashboard.setForeground(new java.awt.Color(174, 174, 178));
        btnNavDashboard.setText("Dashboard");
        btnNavDashboard.setBorderPainted(false);
        btnNavDashboard.setContentAreaFilled(false);
        btnNavDashboard.setFocusPainted(false);
        btnNavDashboard.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavDashboard.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavMapa.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavMapa.setForeground(new java.awt.Color(174, 174, 178));
        btnNavMapa.setText("Mapa de almacen");
        btnNavMapa.setBorderPainted(false);
        btnNavMapa.setContentAreaFilled(false);
        btnNavMapa.setFocusPainted(false);
        btnNavMapa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavMapa.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavStock.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavStock.setForeground(new java.awt.Color(27, 79, 114));
        btnNavStock.setText("Stock");
        btnNavStock.setBorderPainted(false);
        btnNavStock.setFocusPainted(false);
        btnNavStock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavStock.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavEtiquetas.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavEtiquetas.setForeground(new java.awt.Color(174, 174, 178));
        btnNavEtiquetas.setText("Etiquetas");
        btnNavEtiquetas.setBorderPainted(false);
        btnNavEtiquetas.setContentAreaFilled(false);
        btnNavEtiquetas.setFocusPainted(false);
        btnNavEtiquetas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavEtiquetas.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavTrazabilidad.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavTrazabilidad.setForeground(new java.awt.Color(174, 174, 178));
        btnNavTrazabilidad.setText("Trazabilidad");
        btnNavTrazabilidad.setBorderPainted(false);
        btnNavTrazabilidad.setContentAreaFilled(false);
        btnNavTrazabilidad.setFocusPainted(false);
        btnNavTrazabilidad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavTrazabilidad.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavAlertas.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavAlertas.setForeground(new java.awt.Color(174, 174, 178));
        btnNavAlertas.setText("Alertas");
        btnNavAlertas.setBorderPainted(false);
        btnNavAlertas.setContentAreaFilled(false);
        btnNavAlertas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavAlertas.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavEquipo.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavEquipo.setForeground(new java.awt.Color(174, 174, 178));
        btnNavEquipo.setText("Equipo");
        btnNavEquipo.setBorderPainted(false);
        btnNavEquipo.setContentAreaFilled(false);
        btnNavEquipo.setFocusPainted(false);
        btnNavEquipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavEquipo.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavAgenda.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavAgenda.setForeground(new java.awt.Color(174, 174, 178));
        btnNavAgenda.setText("Agenda");
        btnNavAgenda.setBorderPainted(false);
        btnNavAgenda.setContentAreaFilled(false);
        btnNavAgenda.setDefaultCapable(false);
        btnNavAgenda.setFocusPainted(false);
        btnNavAgenda.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavAgenda.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavChat.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavChat.setForeground(new java.awt.Color(174, 174, 178));
        btnNavChat.setText("Chat");
        btnNavChat.setBorderPainted(false);
        btnNavChat.setContentAreaFilled(false);
        btnNavChat.setFocusPainted(false);
        btnNavChat.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavChat.setPreferredSize(new java.awt.Dimension(200, 44));

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
        lblUsuarioNombre.setText("Ana Rodriguez");

        lblUsuarioRol.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        lblUsuarioRol.setForeground(new java.awt.Color(174, 174, 178));
        lblUsuarioRol.setText("Admin");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/stockscan/view/pages/Logo.png"))); // NOI18N

        javax.swing.GroupLayout panelSidebarLayout = new javax.swing.GroupLayout(panelSidebar);
        panelSidebar.setLayout(panelSidebarLayout);
        panelSidebarLayout.setHorizontalGroup(
            panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSidebarLayout.createSequentialGroup()
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnNavAgenda, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelSidebarLayout.createSequentialGroup()
                            .addGap(28, 28, 28)
                            .addComponent(jLabel1)
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
                .addGap(33, 33, 33)
                .addGroup(panelSidebarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogoIconoTexto)
                    .addComponent(jLabel1))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblTituloStock.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTituloStock.setForeground(new java.awt.Color(28, 28, 30));
        lblTituloStock.setText("Stock");

        lblSubtituloStock.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblSubtituloStock.setForeground(new java.awt.Color(110, 110, 115));
        lblSubtituloStock.setText("8 productos · 4 alertas");

        btnAñadirProducto.setBackground(new java.awt.Color(27, 79, 114));
        btnAñadirProducto.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnAñadirProducto.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadirProducto.setText("+ Añadir producto");
        btnAñadirProducto.setPreferredSize(new java.awt.Dimension(140, 36));

        panelBarraFiltros.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscarStock.setText("Buscar por nombre o código...");

        btnFiltroTodos.setBackground(new java.awt.Color(27, 79, 114));
        btnFiltroTodos.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltroTodos.setText("Todos");

        btnFiltroElectronica.setForeground(new java.awt.Color(110, 110, 115));
        btnFiltroElectronica.setText("Electrónica");
        btnFiltroElectronica.setContentAreaFilled(false);

        btnFiltroFerreteria.setForeground(new java.awt.Color(110, 110, 115));
        btnFiltroFerreteria.setText("Ferretería");
        btnFiltroFerreteria.setContentAreaFilled(false);

        btnFiltroEPI.setForeground(new java.awt.Color(110, 110, 115));
        btnFiltroEPI.setText("EPI");
        btnFiltroEPI.setContentAreaFilled(false);

        btnFiltroConsumibles.setForeground(new java.awt.Color(110, 110, 115));
        btnFiltroConsumibles.setText("Consumibles");
        btnFiltroConsumibles.setContentAreaFilled(false);

        btnFiltroEmbalaje.setForeground(new java.awt.Color(110, 110, 115));
        btnFiltroEmbalaje.setText("Embalaje");
        btnFiltroEmbalaje.setContentAreaFilled(false);

        javax.swing.GroupLayout panelBarraFiltrosLayout = new javax.swing.GroupLayout(panelBarraFiltros);
        panelBarraFiltros.setLayout(panelBarraFiltrosLayout);
        panelBarraFiltrosLayout.setHorizontalGroup(
            panelBarraFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBarraFiltrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltroTodos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltroFerreteria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltroElectronica, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltroEPI, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltroConsumibles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFiltroEmbalaje)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelBarraFiltrosLayout.setVerticalGroup(
            panelBarraFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBarraFiltrosLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(panelBarraFiltrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltroTodos)
                    .addComponent(btnFiltroElectronica)
                    .addComponent(btnFiltroFerreteria)
                    .addComponent(btnFiltroEPI)
                    .addComponent(btnFiltroConsumibles)
                    .addComponent(btnFiltroEmbalaje))
                .addContainerGap())
        );

        tblProductosStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"PRD-0041", "Tornillo M8 inox. 25mm", "Ferretería", "PAS-02-EST-04", "340 [OK] En stock", "100", "|||||", "Editar"},
                {"PRD-0087", "Cable UTP Cat6 (caja 305m)", "Electrónica", "PAS-01-EST-02", "8 [BAJO] Stock bajo", "20", "||", "Editar"},
                {"PRD-0123", "Guante de nitrilo talla M", "EPI", "PAS-03-EST-01", "0 [SIN STOCK] Sin stock", "50", "|", "Editar"},
                {"PRD-0156", "Cinta adhesiva embalaje 48mm", "Consumibles", "PAS-01-EST-05", "62 [OK] En stock", "30", "||||", "Editar"},
                {"PRD-0201", "Caja cartón 40x30x25cm", "Embalaje", "PAS-04-EST-02", "187 [OK] En stock", "100", "|||||", "Editar"},
                {"PRD-0234", "Precinto 25mm x 66m transparente", "Consumibles", "PAS-01-EST-04", "12 [BAJO] Stock bajo", "40", "||", "Editar"},
                {"PRD-0267", "Brida plástico 200mm negra", "Ferretería", "PAS-02-EST-01", "580 [OK] En stock", "200", "|||||", "Editar"},
                {"PRD-0301", "Disco duro 2TB SATA", "Electrónica", "PAS-05-EST-03", "4 [BAJO] Stock bajo", "10", "|", "Editar"}
            },
            new String [] {
                "CÓDIGO", "NOMBRE", "CATEGORÍA", "UBICACIÓN", "STOCK ACTUAL", "MÍNIMO", "NIVEL", "ACCIÓN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProductosStock);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblSubtituloStock)
                                .addGap(38, 622, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTituloStock)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAñadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(53, 53, 53))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelBarraFiltros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloStock)
                    .addComponent(btnAñadirProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtituloStock)
                .addGap(28, 28, 28)
                .addComponent(panelBarraFiltros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelSidebar, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavMapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavMapaActionPerformed

    private void btnNavChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavChatActionPerformed

    private void txtBuscarStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarStockActionPerformed

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
            java.util.logging.Logger.getLogger(StockPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StockPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StockPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StockPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StockPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirProducto;
    private javax.swing.JButton btnFiltroConsumibles;
    private javax.swing.JButton btnFiltroEPI;
    private javax.swing.JButton btnFiltroElectronica;
    private javax.swing.JButton btnFiltroEmbalaje;
    private javax.swing.JButton btnFiltroFerreteria;
    private javax.swing.JButton btnFiltroTodos;
    private javax.swing.JButton btnNavAgenda;
    private javax.swing.JButton btnNavAlertas;
    private javax.swing.JButton btnNavChat;
    private javax.swing.JButton btnNavDashboard;
    private javax.swing.JButton btnNavEquipo;
    private javax.swing.JButton btnNavEtiquetas;
    private javax.swing.JButton btnNavMapa;
    private javax.swing.JButton btnNavStock;
    private javax.swing.JButton btnNavTrazabilidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblBadgeAlertas;
    private javax.swing.JLabel lblBadgeChat;
    private javax.swing.JLabel lblLogoIconoTexto;
    private javax.swing.JLabel lblLogoSubtitulo;
    private javax.swing.JLabel lblSubtituloStock;
    private javax.swing.JLabel lblTituloStock;
    private javax.swing.JLabel lblUsuarioNombre;
    private javax.swing.JLabel lblUsuarioRol;
    private javax.swing.JPanel panelBarraFiltros;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JScrollPane scrollTablaStock;
    private javax.swing.JTable tblProductosStock;
    private javax.swing.JTextField txtBuscarStock;
    // End of variables declaration//GEN-END:variables
}
