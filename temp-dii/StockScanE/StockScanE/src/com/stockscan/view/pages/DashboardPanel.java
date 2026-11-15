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
import javax.swing.JPanel;

/**
 *
 * @author alvarolopez
 */
public class DashboardPanel extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    public DashboardPanel() {
        initComponents();
        configurarEventos(); // Activa los eventos de ratón, foco y teclado
    }

    /**
     * Configura los eventos de ratón, foco y teclado para los filtros de la
     * gráfica, las tarjetas de resumen y la lista de actividad reciente
     */
    private void configurarEventos() {
        // 1. BOTONES DE FILTRO DE LA GRÁFICA (Día, Semana, Mes)
        JButton[] botonesFiltro = {btnFiltroDia, btnFiltroSemana, btnFiltroMes};

        for (JButton btn : botonesFiltro) {
            btn.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Pone cursor de mano al pasar sobre el filtro
                    btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Devuelve el cursor normal al salir
                    btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Enfoca el botón y actualiza la gráfica al hacer clic izquierdo
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        btn.requestFocusInWindow();
                        cambiarPeriodoGrafica(btn, botonesFiltro);
                    }
                }
            });

            btn.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Marca el filtro con borde azul cuando tiene el foco
                    btn.setBorder(BorderFactory.createLineBorder(new Color(27, 79, 114), 2));
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Quita el borde azul al perder el foco
                    btn.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
                }
            });

            btn.addKeyListener(new KeyAdapter() {
                @Override
                public void keyReleased(KeyEvent e) {
                    // Cambia el periodo de la gráfica al pulsar Enter o Espacio
                    if (e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE) {
                        cambiarPeriodoGrafica(btn, botonesFiltro);
                    }
                }
            });
        }

        // 2. TARJETAS DE RESUMEN SUPERIORES
        JPanel[] tarjetas = {panelCardStock, panelCardMov, jPanel3, jPanel4};
        String[] detallesTarjetas = {
            "Stock Bajo: 12 productos por debajo del mínimo configurado.",
            "Movimientos de Hoy: 142 entradas, 86 salidas y 20 traspasos internos.",
            "Operarios Activos: 6 trabajadores en turno de mañana y 2 pendientes.",
            "Valoración Total: 84.200 € calculados según precio medio de compra."
        };

        for (int i = 0; i < tarjetas.length; i++) {
            final JPanel tarjeta = tarjetas[i];
            final String mensajeDetalle = detallesTarjetas[i];

            tarjeta.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    // Cambia el cursor y resalta el borde de la tarjeta al pasar por encima
                    tarjeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
                    tarjeta.setBorder(BorderFactory.createLineBorder(new Color(27, 79, 114), 1));
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Devuelve el cursor y quita el borde al salir
                    tarjeta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                    tarjeta.setBorder(null);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Muestra el detalle de la tarjeta en el subtítulo al hacer clic
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        lblSubtituloDashboard.setText(mensajeDetalle);
                    }
                }
            });
        }

        // 3. LISTA DE ACTIVIDAD RECIENTE
        lstActividades.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // Muestra arriba el movimiento seleccionado al hacer clic
                if (e.getButton() == MouseEvent.BUTTON1) {
                    String seleccionado = lstActividades.getSelectedValue();
                    if (seleccionado != null) {
                        lblSubtituloDashboard.setText("Actividad seleccionada: " + seleccionado);
                    }
                }
            }
        });
    }

    /**
     * Pinta el botón del periodo activo y actualiza los contadores de la
     * gráfica
     */
    private void cambiarPeriodoGrafica(JButton botonActivo, JButton[] todosLosBotones) {
        for (JButton b : todosLosBotones) {
            b.setBackground(new Color(240, 242, 245));
            b.setForeground(new Color(110, 110, 115));
        }

        botonActivo.setBackground(new Color(27, 79, 114));
        botonActivo.setForeground(Color.WHITE);

        if (botonActivo == btnFiltroDia) {
            lblMetricEntradas.setText("Entradas: 142");
            lblMetricSalidas.setText("Salidas: 86");
            lblMetricTraspasos.setText("Traspasos: 20");
        } else if (botonActivo == btnFiltroSemana) {
            lblMetricEntradas.setText("Entradas: 890");
            lblMetricSalidas.setText("Salidas: 615");
            lblMetricTraspasos.setText("Traspasos: 112");
        } else if (botonActivo == btnFiltroMes) {
            lblMetricEntradas.setText("Entradas: 3.420");
            lblMetricSalidas.setText("Salidas: 2.890");
            lblMetricTraspasos.setText("Traspasos: 430");
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
        lblTituloDashboard = new javax.swing.JLabel();
        lblSubtituloDashboard = new javax.swing.JLabel();
        panelCardStock = new javax.swing.JPanel();
        lblCard1Titulo = new javax.swing.JLabel();
        lblCard1Icono = new javax.swing.JLabel();
        lblCard1Subtexto = new javax.swing.JLabel();
        lblCard1Valor1 = new javax.swing.JLabel();
        panelCardMov = new javax.swing.JPanel();
        lblCard2Titulo = new javax.swing.JLabel();
        lblCard2Valor = new javax.swing.JLabel();
        lblCard2Icono = new javax.swing.JLabel();
        lblCard2Subtexto = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblCard3Valor = new javax.swing.JLabel();
        lblCard3Titulo = new javax.swing.JLabel();
        lblCard3Icono = new javax.swing.JLabel();
        lblCard3Subtexto = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblCard4Valor = new javax.swing.JLabel();
        lblCard4Titulo = new javax.swing.JLabel();
        lblCard4Icono = new javax.swing.JLabel();
        lblCard4Subtexto = new javax.swing.JLabel();
        panelGraficoActividad = new javax.swing.JPanel();
        lblTituloGrafico = new javax.swing.JLabel();
        btnFiltroDia = new javax.swing.JButton();
        btnFiltroSemana = new javax.swing.JButton();
        btnFiltroMes = new javax.swing.JButton();
        panelAreaDibujoGrafica = new javax.swing.JPanel();
        lblMetricEntradas = new javax.swing.JLabel();
        lblMetricSalidas = new javax.swing.JLabel();
        lblMetricTraspasos = new javax.swing.JLabel();
        panelActividadReciente = new javax.swing.JPanel();
        lblTituloActividad = new javax.swing.JLabel();
        scrollActividad = new javax.swing.JScrollPane();
        lstActividades = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 247, 250));
        setMinimumSize(new java.awt.Dimension(1000, 600));

        panelSidebar.setBackground(new java.awt.Color(18, 30, 43));
        panelSidebar.setPreferredSize(new java.awt.Dimension(220, 600));

        lblLogoIconoTexto.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblLogoIconoTexto.setForeground(new java.awt.Color(255, 255, 255));
        lblLogoIconoTexto.setText("StockScan");

        lblLogoSubtitulo.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        lblLogoSubtitulo.setForeground(new java.awt.Color(174, 174, 178));
        lblLogoSubtitulo.setText("Almacén Central");

        btnNavDashboard.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavDashboard.setForeground(new java.awt.Color(27, 79, 114));
        btnNavDashboard.setText("📊 Dashboard");
        btnNavDashboard.setBorderPainted(false);
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
        btnNavEtiquetas.setForeground(new java.awt.Color(174, 174, 178));
        btnNavEtiquetas.setText("🏷️ Etiquetas");
        btnNavEtiquetas.setBorderPainted(false);
        btnNavEtiquetas.setContentAreaFilled(false);
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

        lblTituloDashboard.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTituloDashboard.setForeground(new java.awt.Color(28, 28, 30));
        lblTituloDashboard.setText("Panel de control");
        lblTituloDashboard.setLocation(new java.awt.Point(240, 20));

        lblSubtituloDashboard.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblSubtituloDashboard.setForeground(new java.awt.Color(110, 110, 115));
        lblSubtituloDashboard.setText("Lunes, 29 septiembre 2026 · Almacén Central");

        panelCardStock.setBackground(new java.awt.Color(255, 255, 255));
        panelCardStock.setPreferredSize(new java.awt.Dimension(170, 95));

        lblCard1Titulo.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblCard1Titulo.setForeground(new java.awt.Color(110, 110, 115));
        lblCard1Titulo.setText("Stock bajo");

        lblCard1Icono.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblCard1Icono.setText("⚠");

        lblCard1Subtexto.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        lblCard1Subtexto.setForeground(new java.awt.Color(231, 76, 60));
        lblCard1Subtexto.setText("+3 respecto a ayer");

        lblCard1Valor1.setFont(new java.awt.Font("Helvetica Neue", 1, 28)); // NOI18N
        lblCard1Valor1.setForeground(new java.awt.Color(28, 28, 30));
        lblCard1Valor1.setText("12");

        javax.swing.GroupLayout panelCardStockLayout = new javax.swing.GroupLayout(panelCardStock);
        panelCardStock.setLayout(panelCardStockLayout);
        panelCardStockLayout.setHorizontalGroup(
            panelCardStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardStockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCardStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardStockLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblCard1Valor1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelCardStockLayout.createSequentialGroup()
                        .addGroup(panelCardStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelCardStockLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(lblCard1Subtexto)
                                .addGap(0, 59, Short.MAX_VALUE))
                            .addGroup(panelCardStockLayout.createSequentialGroup()
                                .addComponent(lblCard1Titulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblCard1Icono)))
                        .addContainerGap())))
        );
        panelCardStockLayout.setVerticalGroup(
            panelCardStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardStockLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCardStockLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCard1Titulo)
                    .addComponent(lblCard1Icono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCard1Valor1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCard1Subtexto)
                .addContainerGap())
        );

        panelCardMov.setBackground(new java.awt.Color(255, 255, 255));
        panelCardMov.setPreferredSize(new java.awt.Dimension(170, 95));

        lblCard2Titulo.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblCard2Titulo.setForeground(new java.awt.Color(110, 110, 115));
        lblCard2Titulo.setText("Movimientos hoy");

        lblCard2Valor.setFont(new java.awt.Font("Helvetica Neue", 1, 28)); // NOI18N
        lblCard2Valor.setForeground(new java.awt.Color(28, 28, 30));
        lblCard2Valor.setText("248");

        lblCard2Icono.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblCard2Icono.setText("📈");

        lblCard2Subtexto.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        lblCard2Subtexto.setForeground(new java.awt.Color(39, 174, 96));
        lblCard2Subtexto.setText("+18% desde las 06:00");

        javax.swing.GroupLayout panelCardMovLayout = new javax.swing.GroupLayout(panelCardMov);
        panelCardMov.setLayout(panelCardMovLayout);
        panelCardMovLayout.setHorizontalGroup(
            panelCardMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardMovLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCardMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelCardMovLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblCard2Valor)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelCardMovLayout.createSequentialGroup()
                        .addComponent(lblCard2Titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(lblCard2Icono)
                        .addContainerGap())))
            .addGroup(panelCardMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelCardMovLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(lblCard2Subtexto)
                    .addContainerGap(61, Short.MAX_VALUE)))
        );
        panelCardMovLayout.setVerticalGroup(
            panelCardMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCardMovLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelCardMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCard2Titulo)
                    .addComponent(lblCard2Icono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCard2Valor)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(panelCardMovLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCardMovLayout.createSequentialGroup()
                    .addContainerGap(81, Short.MAX_VALUE)
                    .addComponent(lblCard2Subtexto)
                    .addContainerGap()))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(170, 95));

        lblCard3Valor.setFont(new java.awt.Font("Helvetica Neue", 1, 28)); // NOI18N
        lblCard3Valor.setForeground(new java.awt.Color(28, 28, 30));
        lblCard3Valor.setText("6/8");

        lblCard3Titulo.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblCard3Titulo.setForeground(new java.awt.Color(110, 110, 115));
        lblCard3Titulo.setText("Operarios activos");

        lblCard3Icono.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblCard3Icono.setText("👥");

        lblCard3Subtexto.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        lblCard3Subtexto.setForeground(new java.awt.Color(110, 110, 115));
        lblCard3Subtexto.setText("fichados ahora mismo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblCard3Titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(lblCard3Icono))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCard3Valor)
                            .addComponent(lblCard3Subtexto))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCard3Titulo)
                    .addComponent(lblCard3Icono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCard3Valor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCard3Subtexto)
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setPreferredSize(new java.awt.Dimension(170, 95));

        lblCard4Valor.setFont(new java.awt.Font("Helvetica Neue", 1, 28)); // NOI18N
        lblCard4Valor.setForeground(new java.awt.Color(28, 28, 30));
        lblCard4Valor.setText("84.2€");

        lblCard4Titulo.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblCard4Titulo.setForeground(new java.awt.Color(110, 110, 115));
        lblCard4Titulo.setText("Valor stock estimado");

        lblCard4Icono.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        lblCard4Icono.setText("📦");

        lblCard4Subtexto.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        lblCard4Subtexto.setForeground(new java.awt.Color(110, 110, 115));
        lblCard4Subtexto.setText("basado en costes medios");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblCard4Titulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(lblCard4Icono))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCard4Valor)
                            .addComponent(lblCard4Subtexto))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCard4Titulo)
                    .addComponent(lblCard4Icono))
                .addGap(6, 6, 6)
                .addComponent(lblCard4Valor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCard4Subtexto)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        panelGraficoActividad.setBackground(new java.awt.Color(255, 255, 255));

        lblTituloGrafico.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblTituloGrafico.setForeground(new java.awt.Color(28, 28, 30));
        lblTituloGrafico.setText("Actividad — movimientos");

        btnFiltroDia.setBackground(new java.awt.Color(214, 234, 248));
        btnFiltroDia.setFont(new java.awt.Font("Helvetica Neue", 1, 11)); // NOI18N
        btnFiltroDia.setForeground(new java.awt.Color(27, 79, 114));
        btnFiltroDia.setText("Día");

        btnFiltroSemana.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        btnFiltroSemana.setForeground(new java.awt.Color(110, 110, 115));
        btnFiltroSemana.setText("Semana");
        btnFiltroSemana.setContentAreaFilled(false);

        btnFiltroMes.setFont(new java.awt.Font("Helvetica Neue", 0, 11)); // NOI18N
        btnFiltroMes.setForeground(new java.awt.Color(110, 110, 115));
        btnFiltroMes.setText("Mes");
        btnFiltroMes.setContentAreaFilled(false);

        javax.swing.GroupLayout panelAreaDibujoGraficaLayout = new javax.swing.GroupLayout(panelAreaDibujoGrafica);
        panelAreaDibujoGrafica.setLayout(panelAreaDibujoGraficaLayout);
        panelAreaDibujoGraficaLayout.setHorizontalGroup(
            panelAreaDibujoGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelAreaDibujoGraficaLayout.setVerticalGroup(
            panelAreaDibujoGraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        lblMetricEntradas.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblMetricEntradas.setForeground(new java.awt.Color(39, 174, 96));
        lblMetricEntradas.setText("Entradas: 48");

        lblMetricSalidas.setFont(new java.awt.Font("Helvetica Neue", 0, 12)); // NOI18N
        lblMetricSalidas.setForeground(new java.awt.Color(231, 76, 60));
        lblMetricSalidas.setText("Salidas: 32");

        lblMetricTraspasos.setForeground(new java.awt.Color(142, 68, 173));
        lblMetricTraspasos.setText("Traspasos: 18");

        javax.swing.GroupLayout panelGraficoActividadLayout = new javax.swing.GroupLayout(panelGraficoActividad);
        panelGraficoActividad.setLayout(panelGraficoActividadLayout);
        panelGraficoActividadLayout.setHorizontalGroup(
            panelGraficoActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGraficoActividadLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(panelGraficoActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGraficoActividadLayout.createSequentialGroup()
                        .addGroup(panelGraficoActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(panelAreaDibujoGrafica, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(panelGraficoActividadLayout.createSequentialGroup()
                                .addComponent(lblTituloGrafico)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                                .addComponent(btnFiltroDia, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltroSemana)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltroMes, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))
                    .addGroup(panelGraficoActividadLayout.createSequentialGroup()
                        .addComponent(lblMetricEntradas)
                        .addGap(66, 66, 66)
                        .addComponent(lblMetricSalidas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMetricTraspasos)
                        .addGap(92, 92, 92))))
        );
        panelGraficoActividadLayout.setVerticalGroup(
            panelGraficoActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGraficoActividadLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(panelGraficoActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloGrafico)
                    .addComponent(btnFiltroDia)
                    .addComponent(btnFiltroSemana)
                    .addComponent(btnFiltroMes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelAreaDibujoGrafica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelGraficoActividadLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMetricEntradas)
                    .addComponent(lblMetricSalidas)
                    .addComponent(lblMetricTraspasos))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        panelActividadReciente.setBackground(new java.awt.Color(255, 255, 255));
        panelActividadReciente.setPreferredSize(new java.awt.Dimension(272, 360));

        lblTituloActividad.setFont(new java.awt.Font("Helvetica Neue", 1, 14)); // NOI18N
        lblTituloActividad.setForeground(new java.awt.Color(28, 28, 30));
        lblTituloActividad.setText("Actividad reciente");

        lstActividades.setBorder(null);
        lstActividades.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lstActividades.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "🔵 CM  Carlos M.  • Entrada  +48 (10:21)", "🟠 LP  Laura P.   • Salida   -5  (10:41)", "🟣 MR  Miguel R.  • Traspaso x20 (10:55)", "🟡 CM  Carlos M.  • Picking  -10 (11:02)", "🟢 AR  Ana R.     • Entrada +100 (11:18)" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstActividades.setSelectionBackground(new java.awt.Color(245, 247, 250));
        scrollActividad.setViewportView(lstActividades);

        javax.swing.GroupLayout panelActividadRecienteLayout = new javax.swing.GroupLayout(panelActividadReciente);
        panelActividadReciente.setLayout(panelActividadRecienteLayout);
        panelActividadRecienteLayout.setHorizontalGroup(
            panelActividadRecienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActividadRecienteLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lblTituloActividad)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelActividadRecienteLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollActividad)
                .addContainerGap())
        );
        panelActividadRecienteLayout.setVerticalGroup(
            panelActividadRecienteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelActividadRecienteLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblTituloActividad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrollActividad)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTituloDashboard)
                            .addComponent(lblSubtituloDashboard)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelGraficoActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelActividadReciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(panelCardStock, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(panelCardMov, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTituloDashboard)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblSubtituloDashboard)
                        .addGap(32, 32, 32)
                        .addComponent(panelCardStock, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelCardMov, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelGraficoActividad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelActividadReciente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavChatActionPerformed

    private void btnNavMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavMapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavMapaActionPerformed

    private void btnNavDashboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavDashboardActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavDashboardActionPerformed

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
            java.util.logging.Logger.getLogger(DashboardPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltroDia;
    private javax.swing.JButton btnFiltroMes;
    private javax.swing.JButton btnFiltroSemana;
    private javax.swing.JButton btnNavAgenda;
    private javax.swing.JButton btnNavAlertas;
    private javax.swing.JButton btnNavChat;
    private javax.swing.JButton btnNavDashboard;
    private javax.swing.JButton btnNavEquipo;
    private javax.swing.JButton btnNavEtiquetas;
    private javax.swing.JButton btnNavMapa;
    private javax.swing.JButton btnNavStock;
    private javax.swing.JButton btnNavTrazabilidad;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblBadgeAlertas;
    private javax.swing.JLabel lblBadgeChat;
    private javax.swing.JLabel lblCard1Icono;
    private javax.swing.JLabel lblCard1Subtexto;
    private javax.swing.JLabel lblCard1Titulo;
    private javax.swing.JLabel lblCard1Valor1;
    private javax.swing.JLabel lblCard2Icono;
    private javax.swing.JLabel lblCard2Subtexto;
    private javax.swing.JLabel lblCard2Titulo;
    private javax.swing.JLabel lblCard2Valor;
    private javax.swing.JLabel lblCard3Icono;
    private javax.swing.JLabel lblCard3Subtexto;
    private javax.swing.JLabel lblCard3Titulo;
    private javax.swing.JLabel lblCard3Valor;
    private javax.swing.JLabel lblCard4Icono;
    private javax.swing.JLabel lblCard4Subtexto;
    private javax.swing.JLabel lblCard4Titulo;
    private javax.swing.JLabel lblCard4Valor;
    private javax.swing.JLabel lblLogoIconoTexto;
    private javax.swing.JLabel lblLogoSubtitulo;
    private javax.swing.JLabel lblMetricEntradas;
    private javax.swing.JLabel lblMetricSalidas;
    private javax.swing.JLabel lblMetricTraspasos;
    private javax.swing.JLabel lblSubtituloDashboard;
    private javax.swing.JLabel lblTituloActividad;
    private javax.swing.JLabel lblTituloDashboard;
    private javax.swing.JLabel lblTituloGrafico;
    private javax.swing.JLabel lblUsuarioNombre;
    private javax.swing.JLabel lblUsuarioRol;
    private javax.swing.JList<String> lstActividades;
    private javax.swing.JPanel panelActividadReciente;
    private javax.swing.JPanel panelAreaDibujoGrafica;
    private javax.swing.JPanel panelCardMov;
    private javax.swing.JPanel panelCardStock;
    private javax.swing.JPanel panelGraficoActividad;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JScrollPane scrollActividad;
    // End of variables declaration//GEN-END:variables
}
