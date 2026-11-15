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
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author alvarolopez
 */
public class EquipoPanel extends javax.swing.JFrame {

    private final String TEXTO_BUSCAR = "Buscar operario..."; //Texto para que me ayude a saber que esale en buscador cuando este vacioo
    private TableRowSorter<DefaultTableModel> ordenadorTabla; //Un obejto que permite filtar asi laas filas de la tabla en tiempp real

    /**
     * Creates new form EquipoPanel
     */
    public EquipoPanel() {
        initComponents();
        configurarEventos(); // Activa los filtros, buscador y eventos de ratón/teclado
    }

    /**
     * Configura los eventos de ratón, foco y teclado para el buscador, filtros
     * y tabla
     */
    private void configurarEventos() {
        // Pongo el texto gris en el buscador y le doy el foco al abrir la ventana
        txtBuscarEquipo.setForeground(new Color(150, 150, 150));
        SwingUtilities.invokeLater(() -> txtBuscarEquipo.requestFocusInWindow());

        // Conecto el filtro de búsqueda con el modelo de la tabla de operarios
        DefaultTableModel modelo = (DefaultTableModel) tblOperarios.getModel();
        ordenadorTabla = new TableRowSorter<>(modelo);
        tblOperarios.setRowSorter(ordenadorTabla);

        // 1. EVENTOS DEL BUSCADOR DE OPERARIOS (txtBuscarEquipo)
        txtBuscarEquipo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Enfoca la caja de búsqueda al hacer clic izquierdo
                if (e.getButton() == MouseEvent.BUTTON1) {
                    txtBuscarEquipo.requestFocusInWindow();
                }
            }
        });

        txtBuscarEquipo.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                // Pinto borde azul y borro el texto de ayuda si aún está puesto
                txtBuscarEquipo.setBorder(BorderFactory.createLineBorder(new Color(27, 79, 114), 2));
                if (txtBuscarEquipo.getText().equals(TEXTO_BUSCAR)) {
                    txtBuscarEquipo.setText("");
                    txtBuscarEquipo.setForeground(new Color(28, 28, 30));
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                // Devuelvo borde gris y restauro el texto de ayuda si lo dejaron vacío
                txtBuscarEquipo.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 205), 1));
                if (txtBuscarEquipo.getText().trim().isEmpty()) {
                    txtBuscarEquipo.setText(TEXTO_BUSCAR);
                    txtBuscarEquipo.setForeground(new Color(150, 150, 150));
                }
            }
        });

        txtBuscarEquipo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                // Cada vez que sueltan una tecla filtro la tabla por lo que hayan escrito
                String texto = txtBuscarEquipo.getText().trim();
                if (texto.isEmpty() || texto.equals(TEXTO_BUSCAR)) {
                    ordenadorTabla.setRowFilter(null); // Muestra todos si no hay texto
                } else {
                    // (?i) hace que la búsqueda no distinga mayúsculas de minúsculas
                    ordenadorTabla.setRowFilter(RowFilter.regexFilter("(?i)" + texto));
                }
            }
        });

        // 2. EVENTOS PARA LOS BOTONES DE FILTRO (Todos, Fichados, Ausentes)
        JButton[] botonesFiltro = {btnFiltroTodosEquipo, btnFiltroFichados, btnFiltroAusentes};

        for (JButton btn : botonesFiltro) {
            btn.addMouseListener(new MouseAdapter() {
                private boolean clicIniciado = false; // Verifica que el clic empiece dentro del botón

                @Override
                public void mouseEntered(MouseEvent e) {
                    btn.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Pongo mano al pasar por encima
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    // Cancela el clic y devuelve el cursor normal al salir
                    clicIniciado = false;
                    btn.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    // Registra el inicio del clic izquierdo y enfoca el botón
                    if (e.getButton() == MouseEvent.BUTTON1 && btn.isEnabled()) {
                        clicIniciado = true;
                        btn.requestFocusInWindow();
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    // Aplica el filtro si se suelta el clic dentro del botón
                    if (e.getButton() == MouseEvent.BUTTON1 && clicIniciado && btn.isEnabled()) {
                        clicIniciado = false;
                        aplicarFiltroEstado(btn, botonesFiltro); // Cambio colores y filtro la tabla
                    }
                }
            });

            // Eventos de foco para moverse con Tabulador
            btn.addFocusListener(new FocusAdapter() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Resalta el botón enfocado con un borde azul
                    btn.setBorder(BorderFactory.createLineBorder(new Color(27, 79, 114), 2));
                }

                @Override
                public void focusLost(FocusEvent e) {
                    // Quita el borde de selección al perder el foco
                    btn.setBorder(BorderFactory.createEmptyBorder(4, 10, 4, 10));
                }
            });

            // Eventos de teclado para activar filtro con Enter o Espacio
            btn.addKeyListener(new KeyAdapter() {
                private boolean teclaPulsada = false; // Evita repeticiones al mantener pulsada la tecla

                @Override
                public void keyPressed(KeyEvent e) {
                    // Marca que se ha pulsado Enter o Espacio
                    if ((e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE)
                            && !teclaPulsada && btn.isEnabled()) {
                        teclaPulsada = true;
                    }
                }

                @Override
                public void keyReleased(KeyEvent e) {
                    // Activa el filtro al soltar la tecla
                    if ((e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_SPACE)
                            && teclaPulsada && btn.isEnabled()) {
                        teclaPulsada = false;
                        aplicarFiltroEstado(btn, botonesFiltro);
                    }
                }
            });
        }

        // 3. EVENTOS PARA EL BOTÓN "+ AÑADIR MIEMBRO"
        Color colorOriginalBtn = btnAñadirMiembro.getBackground(); // Guarda el color base del botón
        btnAñadirMiembro.addMouseListener(new MouseAdapter() {
            private boolean clicIniciado = false;

            @Override
            public void mouseEntered(MouseEvent e) {
                // Cambia a mano y oscurece el botón al pasar el ratón
                btnAñadirMiembro.setCursor(new Cursor(Cursor.HAND_CURSOR));
                btnAñadirMiembro.setBackground(colorOriginalBtn.darker());
            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Cancela el clic y devuelve el cursor y color originales
                clicIniciado = false;
                btnAñadirMiembro.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                btnAñadirMiembro.setBackground(colorOriginalBtn);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Marca el inicio del clic y da el foco al botón
                if (e.getButton() == MouseEvent.BUTTON1 && btnAñadirMiembro.isEnabled()) {
                    clicIniciado = true;
                    btnAñadirMiembro.requestFocusInWindow();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Activa el modo alta en el subtítulo al soltar el clic
                if (e.getButton() == MouseEvent.BUTTON1 && clicIniciado && btnAñadirMiembro.isEnabled()) {
                    clicIniciado = false;
                    btnAñadirMiembro.setBackground(colorOriginalBtn);
                    lblSubtituloEquipo.setText("Modo alta: introduce los datos del nuevo operario");
                }
            }
        });

        // 4. EVENTO DE CLIC EN LA COLUMNA "ACCIÓN" (Editar) DE LA TABLA
        tblOperarios.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                // Detecta si se hizo clic izquierdo en la columna de editar y muestra el operario
                if (e.getButton() == MouseEvent.BUTTON1) {
                    int fila = tblOperarios.rowAtPoint(e.getPoint());
                    int columna = tblOperarios.columnAtPoint(e.getPoint());
                    if (fila >= 0 && columna == 6) {
                        Object nombre = tblOperarios.getValueAt(fila, 1);
                        if (nombre != null) {
                            lblSubtituloEquipo.setText("Editando ficha del operario: " + nombre);
                        }
                    }
                }
            }
        });
    }

    /**
     * Cambia el aspecto visual del botón de filtro pulsado y filtra la tabla de
     * operarios
     */
    private void aplicarFiltroEstado(JButton botonActivo, JButton[] todosLosBotones) {
        // Apago todos los botones de filtro
        for (JButton b : todosLosBotones) {
            b.setContentAreaFilled(false);
            b.setForeground(new Color(110, 110, 115));
        }

        // Ilumino el botón pulsado en azul
        botonActivo.setContentAreaFilled(true);
        botonActivo.setBackground(new Color(27, 79, 114));
        botonActivo.setForeground(Color.WHITE);

        // Aplico el filtro correspondiente en la columna 4 ("ESTADO FICHAJE")
        if (botonActivo == btnFiltroTodosEquipo) {
            ordenadorTabla.setRowFilter(null);
        } else if (botonActivo == btnFiltroFichados) {
            ordenadorTabla.setRowFilter(RowFilter.regexFilter("Fichado", 4));
        } else if (botonActivo == btnFiltroAusentes) {
            ordenadorTabla.setRowFilter(RowFilter.regexFilter("Ausente", 4));
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
        lblTituloEquipo = new javax.swing.JLabel();
        lblSubtituloEquipo = new javax.swing.JLabel();
        btnAñadirMiembro = new javax.swing.JButton();
        panelFiltrosEquipo = new javax.swing.JPanel();
        scrollTablaEquipo = new javax.swing.JScrollPane();
        tblOperarios = new javax.swing.JTable();
        txtBuscarEquipo = new javax.swing.JTextField();
        btnFiltroTodosEquipo = new javax.swing.JButton();
        btnFiltroFichados = new javax.swing.JButton();
        btnFiltroAusentes = new javax.swing.JButton();

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

        btnNavMapa.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavMapa.setForeground(new java.awt.Color(174, 174, 178));
        btnNavMapa.setText("Mapa de almacén");
        btnNavMapa.setBorderPainted(false);
        btnNavMapa.setContentAreaFilled(false);
        btnNavMapa.setFocusPainted(false);
        btnNavMapa.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavMapa.setPreferredSize(new java.awt.Dimension(200, 44));

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
        btnNavAlertas.setText("Alertas");
        btnNavAlertas.setBorderPainted(false);
        btnNavAlertas.setContentAreaFilled(false);
        btnNavAlertas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavAlertas.setPreferredSize(new java.awt.Dimension(200, 44));

        btnNavEquipo.setFont(new java.awt.Font("SansSerif", 0, 13)); // NOI18N
        btnNavEquipo.setForeground(new java.awt.Color(27, 79, 114));
        btnNavEquipo.setText("👥 Equipo");
        btnNavEquipo.setBorderPainted(false);
        btnNavEquipo.setFocusPainted(false);
        btnNavEquipo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnNavEquipo.setPreferredSize(new java.awt.Dimension(200, 44));
        btnNavEquipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNavEquipoActionPerformed(evt);
            }
        });

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

        lblTituloEquipo.setFont(new java.awt.Font("SansSerif", 1, 22)); // NOI18N
        lblTituloEquipo.setForeground(new java.awt.Color(28, 28, 30));
        lblTituloEquipo.setText("Gestión de equipo");

        lblSubtituloEquipo.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        lblSubtituloEquipo.setForeground(new java.awt.Color(110, 110, 115));
        lblSubtituloEquipo.setText("8 miembros de equipo · 6 activos ahora mismo");

        btnAñadirMiembro.setBackground(new java.awt.Color(27, 79, 114));
        btnAñadirMiembro.setForeground(new java.awt.Color(255, 255, 255));
        btnAñadirMiembro.setText("+ Añadir miembro");

        panelFiltrosEquipo.setBackground(new java.awt.Color(255, 255, 255));

        tblOperarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"AR", "Ana Rodríguez", "Administrador", "Turno Mañana (07:00-15:00)", "Fichado (06:55)", "Almacén Central", "Editar"},
                {"CM", "Carlos Martínez", "Mozo almacén", "Turno Mañana (07:00-15:00)", "Fichado (07:02)", "Zona PAS-02", "Editar"},
                {"LP", "Laura Pérez", "Picking / Preparador", "Turno Mañana (07:00-15:00)", "Fichado (06:58)", "Zona PAS-01 ", "Editar"},
                {"MR", "Miguel Ramírez", "Carretillero", "Turno Mañana (07:00-15:00)", "Fichado (07:10", "Zona Expedición", "Editar"},
                {"JS", "Javier Sánchez", "Mozo almacén", "Turno Tarde (15:00-23:00)", "Ausente", "—", "Editar"},
                {"EG", "Elena Gómez", "Control de Calidad", "Turno Tarde (15:00-23:00)", "Ausente", "—", "Editar"},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "AVATAR", "NOMBRE", "ROL / PUESTO", "TURNO", "ESTADO FICHAJE", "ZONA ASIGNADA", "ACCIÓN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        scrollTablaEquipo.setViewportView(tblOperarios);

        javax.swing.GroupLayout panelFiltrosEquipoLayout = new javax.swing.GroupLayout(panelFiltrosEquipo);
        panelFiltrosEquipo.setLayout(panelFiltrosEquipoLayout);
        panelFiltrosEquipoLayout.setHorizontalGroup(
            panelFiltrosEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosEquipoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(scrollTablaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        panelFiltrosEquipoLayout.setVerticalGroup(
            panelFiltrosEquipoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFiltrosEquipoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(scrollTablaEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        txtBuscarEquipo.setText("Buscar operario...");

        btnFiltroTodosEquipo.setBackground(new java.awt.Color(27, 79, 114));
        btnFiltroTodosEquipo.setForeground(new java.awt.Color(255, 255, 255));
        btnFiltroTodosEquipo.setText("Todos (8)");

        btnFiltroFichados.setForeground(new java.awt.Color(110, 110, 115));
        btnFiltroFichados.setText("Fichados (6)");
        btnFiltroFichados.setContentAreaFilled(false);

        btnFiltroAusentes.setForeground(new java.awt.Color(110, 110, 115));
        btnFiltroAusentes.setText("Ausentes (2)");
        btnFiltroAusentes.setContentAreaFilled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelFiltrosEquipo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTituloEquipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAñadirMiembro)))
                        .addGap(36, 36, 36))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtituloEquipo)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtBuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(btnFiltroTodosEquipo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnFiltroFichados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnFiltroAusentes)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelSidebar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTituloEquipo)
                    .addComponent(btnAñadirMiembro, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSubtituloEquipo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtBuscarEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnFiltroTodosEquipo)
                        .addComponent(btnFiltroFichados)
                        .addComponent(btnFiltroAusentes)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(panelFiltrosEquipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNavMapaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavMapaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavMapaActionPerformed

    private void btnNavChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavChatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavChatActionPerformed

    private void txtBuscarEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarEquipoActionPerformed

    private void btnNavEquipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNavEquipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNavEquipoActionPerformed

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
            java.util.logging.Logger.getLogger(EquipoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EquipoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EquipoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EquipoPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EquipoPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAñadirMiembro;
    private javax.swing.JButton btnFiltroAusentes;
    private javax.swing.JButton btnFiltroFichados;
    private javax.swing.JButton btnFiltroTodosEquipo;
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
    private javax.swing.JLabel lblAvatar;
    private javax.swing.JLabel lblBadgeAlertas;
    private javax.swing.JLabel lblBadgeChat;
    private javax.swing.JLabel lblLogoIconoTexto;
    private javax.swing.JLabel lblLogoSubtitulo;
    private javax.swing.JLabel lblSubtituloEquipo;
    private javax.swing.JLabel lblTituloEquipo;
    private javax.swing.JLabel lblUsuarioNombre;
    private javax.swing.JLabel lblUsuarioRol;
    private javax.swing.JPanel panelFiltrosEquipo;
    private javax.swing.JPanel panelSidebar;
    private javax.swing.JScrollPane scrollTablaEquipo;
    private javax.swing.JTable tblOperarios;
    private javax.swing.JTextField txtBuscarEquipo;
    // End of variables declaration//GEN-END:variables
}
