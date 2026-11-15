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
public class TrazabilidadPanel extends javax.swing.JFrame {

    /**
     * Creates new form TrazabilidadPanel
     */
    public TrazabilidadPanel() {
        initComponents();
        configurarEventos(); // Activa los eventos de la vista
    }

    private void configurarEventos() {
        // Textos por defecto para los campos de filtro
        final String PLACEHOLDER_BUSCAR = "Buscar por lote o producto...";
        final String PLACEHOLDER_FECHA = "Todas las fechas";

        // 1. EVENTOS DE FOCO Y TECLADO EN EL BUSCADOR (txtBuscarTraza)
        txtBuscarTraza.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Resalta el borde y limpia el texto de ayuda al entrar
                txtBuscarTraza.setBorder(BorderFactory.createLineBorder(new Color(27, 79, 114), 2));
                if (txtBuscarTraza.getText().equals(PLACEHOLDER_BUSCAR)) {
                    txtBuscarTraza.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Restaura el borde y devuelve el texto de ayuda si quedó vacío
                txtBuscarTraza.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 205), 1));
                if (txtBuscarTraza.getText().trim().isEmpty()) {
                    txtBuscarTraza.setText(PLACEHOLDER_BUSCAR);
                }
            }
        });

        txtBuscarTraza.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Muestra lo que se va escribiendo en el subtítulo
                String texto = txtBuscarTraza.getText().trim();
                lblSubtituloTraza.setText(texto.isEmpty() ? "Historial completo de movimientos de stock" : "Buscando: " + texto);
            }
        });

        // 2. EVENTOS DE FOCO Y TECLADO EN EL FILTRO DE FECHA (txtFechaFilter)
        txtFechaFilter.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Marca el campo activo y borra el placeholder
                txtFechaFilter.setBorder(BorderFactory.createLineBorder(new Color(27, 79, 114), 2));
                if (txtFechaFilter.getText().equals(PLACEHOLDER_FECHA)) {
                    txtFechaFilter.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Devuelve el borde normal y el texto por defecto si está vacío
                txtFechaFilter.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 205), 1));
                if (txtFechaFilter.getText().trim().isEmpty()) {
                    txtFechaFilter.setText(PLACEHOLDER_FECHA);
                }
            }
        });

        txtFechaFilter.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Actualiza el subtítulo con la fecha escrita
                String fecha = txtFechaFilter.getText().trim();
                lblSubtituloTraza.setText(fecha.isEmpty() ? "Historial completo de movimientos de stock" : "Fecha: " + fecha);
            }
        });

        // 3. EVENTOS DE RATÓN EN LA TABLA Y DESPLEGABLES
        tblTrazabilidad.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambia el cursor a mano sobre la tabla
                tblTrazabilidad.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Devuelve el cursor normal al salir
                tblTrazabilidad.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Al hacer clic en una fila, muestra sus datos arriba
                int fila = tblTrazabilidad.getSelectedRow();
                if (fila != -1) {
                    String producto = tblTrazabilidad.getValueAt(fila, 1).toString();
                    String movimiento = tblTrazabilidad.getValueAt(fila, 2).toString();
                    lblSubtituloTraza.setText("Seleccionado: " + producto + " (" + movimiento + ")");
                }
            }
        });

        cmbOperarioFilter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cursor de mano en el filtro de operario
                cmbOperarioFilter.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Cursor normal al salir
                cmbOperarioFilter.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        cmbTipoMovFilter.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Cursor de mano en el filtro de tipo de movimiento
                cmbTipoMovFilter.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Cursor normal al salir
                cmbTipoMovFilter.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
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
        lblTituloTraza = new javax.swing.JLabel();
        lblSubtituloTraza = new javax.swing.JLabel();
        panelFiltrosTraza = new javax.swing.JPanel();
        txtBuscarTraza = new javax.swing.JTextField();
        cmbOperarioFilter = new javax.swing.JComboBox<>();
        cmbTipoMovFilter = new javax.swing.JComboBox<>();
        txtFechaFilter = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTrazabilidad = new javax.swing.JTable();

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
        btnNavStock.setForeground(new java.awt.Color(174, 174, 178));
        btnNavStock.setText("Stock");
        btnNavStock.setBorderPainted(false);
        btnNavStock.setContentAreaFilled(false);
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
        btnNavTrazabilidad.setForeground(new java.awt.Color(27, 79, 114));
        btnNavTrazabilidad.setText("Trazabilidad");
        btnNavTrazabilidad.setBorderPainted(false);
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

        lblTituloTraza.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTituloTraza.setForeground(new java.awt.Color(28, 28, 30));
        lblTituloTraza.setText("Trazabilidad");

        lblSubtituloTraza.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblSubtituloTraza.setForeground(new java.awt.Color(110, 110, 115));
        lblSubtituloTraza.setText("Historial completo de movimientos de stock");

        panelFiltrosTraza.setBackground(new java.awt.Color(255, 255, 255));

        txtBuscarTraza.setText("Buscar por lote o producto...");

        cmbOperarioFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los operarios" }));

        cmbTipoMovFilter.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los movimientos" }));

        txtFechaFilter.setText("Todas las fechas");

        javax.swing.GroupLayout panelFiltrosTrazaLayout = new javax.swing.GroupLayout(panelFiltrosTraza);
        panelFiltrosTraza.setLayout(panelFiltrosTrazaLayout);
        panelFiltrosTrazaLayout.setHorizontalGroup(
            panelFiltrosTrazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosTrazaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtBuscarTraza, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addComponent(cmbOperarioFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbTipoMovFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtFechaFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        panelFiltrosTrazaLayout.setVerticalGroup(
            panelFiltrosTrazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosTrazaLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(panelFiltrosTrazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtBuscarTraza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFiltrosTrazaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbTipoMovFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFechaFilter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmbOperarioFilter)))
                .addGap(14, 14, 14))
        );

        tblTrazabilidad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"29/09/2026 10:22", "Cable UTP Cat6", "Entrada", "Muelle 1 -> PAS-01-EST-02", "+500 uds", "Carlos M."},
                {"29/09/2026 09:45", "Cinta Embalaje", "Ubicación", "PAS-01 -> PAS-04-EST-02", "100 uds", "Laura P."},
                {"29/09/2026 09:10", "Bobina Film", "Salida", "PAS-02-EST-01 -> Muelle 3", "-50 uds", "Miguel R."},
                {"28/09/2026 17:30", "Caja Cartón L", "Ajuste", "PAS-03-EST-04", "-2 uds", "Ana R."}
            },
            new String [] {
                "Fecha / Hora", "Producto", "Tipo Movimiento", "Origen / Destino", "Cantidad", "Operario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblTrazabilidad);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelFiltrosTraza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 755, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSubtituloTraza)
                    .addComponent(lblTituloTraza))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(lblTituloTraza)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubtituloTraza)
                        .addGap(18, 18, 18)
                        .addComponent(panelFiltrosTraza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavMapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavMapaActionPerformed

    private void btnNavChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavChatActionPerformed

    private void txtBuscarTrazaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarTrazaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarTrazaActionPerformed

    private void txtFechaFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFechaFilterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFechaFilterActionPerformed

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
            java.util.logging.Logger.getLogger(TrazabilidadPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TrazabilidadPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TrazabilidadPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TrazabilidadPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TrazabilidadPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNavAgenda;
    private javax.swing.JButton btnNavAlertas;
    private javax.swing.JButton btnNavChat;
    private javax.swing.JButton btnNavDashboard;
    private javax.swing.JButton btnNavEquipo;
    private javax.swing.JButton btnNavEtiquetas;
    private javax.swing.JButton btnNavMapa;
    private javax.swing.JButton btnNavStock;
    private javax.swing.JButton btnNavTrazabilidad;
    private javax.swing.JComboBox<String> cmbOperarioFilter;
    private javax.swing.JComboBox<String> cmbTipoMovFilter;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblBadgeAlertas;
    private javax.swing.JLabel lblBadgeChat;
    private javax.swing.JLabel lblLogoIconoTexto;
    private javax.swing.JLabel lblLogoSubtitulo;
    private javax.swing.JLabel lblSubtituloTraza;
    private javax.swing.JLabel lblTituloTraza;
    private javax.swing.JLabel lblUsuarioNombre;
    private javax.swing.JLabel lblUsuarioRol;
    private javax.swing.JPanel panelFiltrosTraza;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JTable tblTrazabilidad;
    private javax.swing.JTextField txtBuscarTraza;
    private javax.swing.JTextField txtFechaFilter;
    // End of variables declaration//GEN-END:variables
}
