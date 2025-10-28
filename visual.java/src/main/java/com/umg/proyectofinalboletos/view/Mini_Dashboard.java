/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.umg.proyectofinalboletos.view;
import com.umg.proyectofinalboletos.service.ReporteService;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author MK
 */

public class Mini_Dashboard extends javax.swing.JFrame {

/**
* Creates new form Dash
*/
    
    int xmouse, ymouse;
    private JPanel[] paneles;
    public Mini_Dashboard() {
        initComponents();
        this.setLocationRelativeTo(null);

//-----------------------------------------------     
// <editor-fold defaultstate="collapsed" desc="Configuraciones de Botones">
paneles = new JPanel[] { btn_det_sale,btn_inv,btn_match,btn_place,btn_sales,btn_usr, btn_report_match, btn_report_user}; 
    Color colorNormal = new Color(65,108,64);  
    Color colorHover = new Color(98,167,97);   
    Color colorSeleccionado = new Color(53,119,52);

        for (JPanel panel : paneles) {
            panel.addMouseListener(new java.awt.event.MouseAdapter() {
                
            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                if (panel.getBackground() != colorSeleccionado) {
                    panel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                    panel.setBackground(colorHover);
                }
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                if (panel.getBackground() != colorSeleccionado) {
                    panel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
                    panel.setBackground(colorNormal);
                }
            }

            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            // Restablecer paneles
                for (JPanel p : paneles) {
                    p.setBackground(colorNormal);
                }
                // Marca el seleccionado
                    panel.setBackground(colorSeleccionado);
            }
            });

        }// </editor-fold>
//-----------------------------------------------    
// <editor-fold defaultstate="collapsed" desc="Pantalla de inicio Dashboard">
Initial_Internal_Frame Init= new Initial_Internal_Frame();
DesktopPane.add(Init);
Init.setVisible(true);
    try{
        
        Init.setSelected(true);
        }catch (java.beans.PropertyVetoException e){
            e.printStackTrace();
        }
// </editor-fold>
//-----------------------------------------------    
}
    
    public static String capitalize(String texto) {if (texto == null || texto.isEmpty()) return texto; return texto.substring(0, 1).toUpperCase() + texto.substring(1);}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        bar = new javax.swing.JPanel();
        exit_cube = new javax.swing.JPanel();
        exit_txt = new javax.swing.JLabel();
        Menu = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        Title_Separator = new javax.swing.JSeparator();
        btn_usr = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btn_place = new javax.swing.JPanel();
        btb_emp_txt = new javax.swing.JLabel();
        btn_match = new javax.swing.JPanel();
        btb_prod_txt = new javax.swing.JLabel();
        btn_sales = new javax.swing.JPanel();
        btb_prov_txt = new javax.swing.JLabel();
        btn_inv = new javax.swing.JPanel();
        btb_client_txt = new javax.swing.JLabel();
        btn_det_sale = new javax.swing.JPanel();
        btb_user_txt = new javax.swing.JLabel();
        btn_report_match = new javax.swing.JPanel();
        btb_user_txt1 = new javax.swing.JLabel();
        btn_report_user = new javax.swing.JPanel();
        btb_user_txt2 = new javax.swing.JLabel();
        DesktopPane = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1202, 751));
        setResizable(false);
        setSize(new java.awt.Dimension(1202, 751));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setPreferredSize(new java.awt.Dimension(1080, 720));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bar.setBackground(new java.awt.Color(255, 255, 255));
        bar.setOpaque(false);
        bar.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                barMouseDragged(evt);
            }
        });
        bar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                barMousePressed(evt);
            }
        });
        bar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        exit_cube.setBackground(new java.awt.Color(65, 108, 64));
        exit_cube.setMaximumSize(new java.awt.Dimension(30, 30));
        exit_cube.setMinimumSize(new java.awt.Dimension(30, 30));
        exit_cube.setPreferredSize(new java.awt.Dimension(30, 30));
        exit_cube.setVerifyInputWhenFocusTarget(false);

        exit_txt.setFont(new java.awt.Font("Roboto Light", 0, 24)); // NOI18N
        exit_txt.setForeground(new java.awt.Color(255, 255, 255));
        exit_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_txt.setText("x");
        exit_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        exit_txt.setPreferredSize(new java.awt.Dimension(18, 44));
        exit_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exit_txtMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exit_txtMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exit_txtMouseExited(evt);
            }
        });

        javax.swing.GroupLayout exit_cubeLayout = new javax.swing.GroupLayout(exit_cube);
        exit_cube.setLayout(exit_cubeLayout);
        exit_cubeLayout.setHorizontalGroup(
            exit_cubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );
        exit_cubeLayout.setVerticalGroup(
            exit_cubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
        );

        bar.add(exit_cube, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 30, 30));

        Background.add(bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, -1));

        Menu.setBackground(new java.awt.Color(65, 108, 64));
        Menu.setMinimumSize(new java.awt.Dimension(180, 720));
        Menu.setPreferredSize(new java.awt.Dimension(170, 720));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("Roboto Black", 0, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGO_ENTERPRISE_NANO.png"))); // NOI18N
        Title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TitleMouseClicked(evt);
            }
        });
        Menu.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 150, 150));

        Title_Separator.setBackground(new java.awt.Color(255, 255, 255));
        Menu.add(Title_Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 150, 10));

        btn_usr.setBackground(new java.awt.Color(65, 108, 64));
        btn_usr.setMaximumSize(new java.awt.Dimension(170, 42));
        btn_usr.setMinimumSize(new java.awt.Dimension(170, 42));
        btn_usr.setPreferredSize(new java.awt.Dimension(170, 42));
        btn_usr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_usrMouseClicked(evt);
            }
        });
        btn_usr.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/account-multiple.png"))); // NOI18N
        jLabel3.setText("Usuarios");
        btn_usr.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        Menu.add(btn_usr, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 220, -1, -1));

        btn_place.setBackground(new java.awt.Color(65, 108, 64));
        btn_place.setMaximumSize(new java.awt.Dimension(170, 42));
        btn_place.setMinimumSize(new java.awt.Dimension(170, 42));
        btn_place.setPreferredSize(new java.awt.Dimension(170, 42));
        btn_place.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_placeMouseClicked(evt);
            }
        });
        btn_place.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btb_emp_txt.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_emp_txt.setForeground(new java.awt.Color(255, 255, 255));
        btb_emp_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home-outline.png"))); // NOI18N
        btb_emp_txt.setText("Localidades");
        btn_place.add(btb_emp_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        Menu.add(btn_place, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 262, -1, -1));

        btn_match.setBackground(new java.awt.Color(65, 108, 64));
        btn_match.setMaximumSize(new java.awt.Dimension(170, 42));
        btn_match.setMinimumSize(new java.awt.Dimension(170, 42));
        btn_match.setPreferredSize(new java.awt.Dimension(170, 42));
        btn_match.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_matchMouseClicked(evt);
            }
        });
        btn_match.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btb_prod_txt.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_prod_txt.setForeground(new java.awt.Color(255, 255, 255));
        btb_prod_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/images.png"))); // NOI18N
        btb_prod_txt.setText("Partidos");
        btn_match.add(btb_prod_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        Menu.add(btn_match, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 304, -1, -1));

        btn_sales.setBackground(new java.awt.Color(65, 108, 64));
        btn_sales.setMaximumSize(new java.awt.Dimension(170, 42));
        btn_sales.setMinimumSize(new java.awt.Dimension(170, 42));
        btn_sales.setPreferredSize(new java.awt.Dimension(170, 42));
        btn_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salesMouseClicked(evt);
            }
        });
        btn_sales.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btb_prov_txt.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_prov_txt.setForeground(new java.awt.Color(255, 255, 255));
        btb_prov_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/file-chart.png"))); // NOI18N
        btb_prov_txt.setText("Ventas");
        btn_sales.add(btb_prov_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        Menu.add(btn_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 388, -1, -1));

        btn_inv.setBackground(new java.awt.Color(65, 108, 64));
        btn_inv.setMaximumSize(new java.awt.Dimension(170, 42));
        btn_inv.setMinimumSize(new java.awt.Dimension(170, 42));
        btn_inv.setPreferredSize(new java.awt.Dimension(170, 42));
        btn_inv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_invMouseClicked(evt);
            }
        });
        btn_inv.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btb_client_txt.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_client_txt.setForeground(new java.awt.Color(255, 255, 255));
        btb_client_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proov.png"))); // NOI18N
        btb_client_txt.setText("Inventario");
        btn_inv.add(btb_client_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        Menu.add(btn_inv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 346, -1, -1));

        btn_det_sale.setBackground(new java.awt.Color(65, 108, 64));
        btn_det_sale.setMaximumSize(new java.awt.Dimension(170, 42));
        btn_det_sale.setPreferredSize(new java.awt.Dimension(170, 42));
        btn_det_sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_det_saleMouseClicked(evt);
            }
        });
        btn_det_sale.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btb_user_txt.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_user_txt.setForeground(new java.awt.Color(255, 255, 255));
        btb_user_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/book-open-page-variant.png"))); // NOI18N
        btb_user_txt.setText("Detalle de Ventas");
        btn_det_sale.add(btb_user_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        Menu.add(btn_det_sale, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, -1, -1));

        btn_report_match.setBackground(new java.awt.Color(65, 108, 64));
        btn_report_match.setMaximumSize(new java.awt.Dimension(170, 42));
        btn_report_match.setPreferredSize(new java.awt.Dimension(170, 42));
        btn_report_match.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_report_matchMouseClicked(evt);
            }
        });
        btn_report_match.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btb_user_txt1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_user_txt1.setForeground(new java.awt.Color(255, 255, 255));
        btb_user_txt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/images.png"))); // NOI18N
        btb_user_txt1.setText("Reporte Partidos");
        btn_report_match.add(btb_user_txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        Menu.add(btn_report_match, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 472, -1, -1));

        btn_report_user.setBackground(new java.awt.Color(65, 108, 64));
        btn_report_user.setMaximumSize(new java.awt.Dimension(170, 42));
        btn_report_user.setPreferredSize(new java.awt.Dimension(170, 42));
        btn_report_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_report_userMouseClicked(evt);
            }
        });
        btn_report_user.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btb_user_txt2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_user_txt2.setForeground(new java.awt.Color(255, 255, 255));
        btb_user_txt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/account-multiple.png"))); // NOI18N
        btb_user_txt2.setText("Reporte Usuarios");
        btn_report_user.add(btb_user_txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 9, -1, -1));

        Menu.add(btn_report_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 514, -1, -1));

        Background.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 750));

        DesktopPane.setBackground(new java.awt.Color(255, 255, 255));
        DesktopPane.setMinimumSize(new java.awt.Dimension(1030, 750));

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1030, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 750, Short.MAX_VALUE)
        );

        Background.add(DesktopPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, -1, -1));

        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 750));

        pack();
    }// </editor-fold>//GEN-END:initComponents

// <editor-fold defaultstate="collapsed" desc="Configuraciones Btn Exit">    
    private void exit_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_txtMouseClicked
        this.dispose();
    }//GEN-LAST:event_exit_txtMouseClicked

    private void exit_txtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_txtMouseEntered
        exit_cube.setBackground(Color.red);
        exit_txt.setForeground(Color.white);
    }//GEN-LAST:event_exit_txtMouseEntered

    private void exit_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_txtMouseExited
        exit_cube.setBackground(new Color(65,108,64));
        exit_txt.setForeground(Color.white);
    }//GEN-LAST:event_exit_txtMouseExited
// </editor-fold>

// <editor-fold defaultstate="collapsed" desc="Configuraciones Barra">
    private void barMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xmouse,y - ymouse);
    }//GEN-LAST:event_barMouseDragged

    private void barMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMousePressed
        xmouse= evt.getX();
        ymouse= evt.getY();
    }//GEN-LAST:event_barMousePressed
// </editor-fold>
    
    private void btn_usrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_usrMouseClicked
        for (javax.swing.JInternalFrame frame : DesktopPane.getAllFrames()) {
            frame.dispose();
        }

        User_View Init= new User_View();
        DesktopPane.add(Init);
        Init.setVisible(true);
            try{
                Init.setSelected(true);
                }catch (java.beans.PropertyVetoException e){
                    e.printStackTrace();
                }
    }//GEN-LAST:event_btn_usrMouseClicked

    private void btn_placeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_placeMouseClicked
        for (javax.swing.JInternalFrame frame : DesktopPane.getAllFrames()) {
            frame.dispose();
        }

        Place_View Init= new Place_View();
        DesktopPane.add(Init);
        Init.setVisible(true);
            try{
                Init.setSelected(true);
                }catch (java.beans.PropertyVetoException e){
                    e.printStackTrace();
                }
    }//GEN-LAST:event_btn_placeMouseClicked

    private void btn_matchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_matchMouseClicked
    for (javax.swing.JInternalFrame frame : DesktopPane.getAllFrames()) {
        frame.dispose();
    }
        
    Matches_View Init= new Matches_View();
    DesktopPane.add(Init);
    Init.setVisible(true);
        try{
            Init.setSelected(true);
            }catch (java.beans.PropertyVetoException e){
                e.printStackTrace();
            }
    }//GEN-LAST:event_btn_matchMouseClicked

    private void btn_salesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_salesMouseClicked
        for (javax.swing.JInternalFrame frame : DesktopPane.getAllFrames()) {
            frame.dispose();
        }

        Sales_View Init= new Sales_View();
        DesktopPane.add(Init);
        Init.setVisible(true);
            try{
                Init.setSelected(true);
                }catch (java.beans.PropertyVetoException e){
                    e.printStackTrace();
                }
    }//GEN-LAST:event_btn_salesMouseClicked

    private void btn_invMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_invMouseClicked
        for (javax.swing.JInternalFrame frame : DesktopPane.getAllFrames()) {
            frame.dispose();
        }

        Ticket_Inventory_View Init= new Ticket_Inventory_View();
        DesktopPane.add(Init);
        Init.setVisible(true);
            try{
                Init.setSelected(true);
                }catch (java.beans.PropertyVetoException e){
                    e.printStackTrace();
                }
    }//GEN-LAST:event_btn_invMouseClicked

    private void btn_det_saleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_det_saleMouseClicked
        for (javax.swing.JInternalFrame frame : DesktopPane.getAllFrames()) {
            frame.dispose();
        }

        Sales_Details_View Init= new Sales_Details_View();
        DesktopPane.add(Init);
        Init.setVisible(true);
            try{
                Init.setSelected(true);
                }catch (java.beans.PropertyVetoException e){
                    e.printStackTrace();
                }
    }//GEN-LAST:event_btn_det_saleMouseClicked

    private void TitleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TitleMouseClicked
    
    for (javax.swing.JInternalFrame frame : DesktopPane.getAllFrames()) {
        frame.dispose();
    }
        
    Initial_Internal_Frame Init= new Initial_Internal_Frame();
    DesktopPane.add(Init);
    Init.setVisible(true);
        try{
            Init.setSelected(true);
            }catch (java.beans.PropertyVetoException e){
                e.printStackTrace();
            }
    }//GEN-LAST:event_TitleMouseClicked

    private void btn_report_matchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_report_matchMouseClicked
        try {
            Map<String, Object> params = new java.util.HashMap<>();

            // Cargar la imagen desde el JAR
            InputStream imagenStream = getClass().getResourceAsStream("/imagenes/Proyecto_nuevo.jpg");
            if (imagenStream == null) {
                throw new FileNotFoundException("No se encontró la imagen en el JAR");
            }
            params.put("IMAGEN_LOGO", imagenStream);

            // Cargar el reporte desde el JAR
            InputStream reporteStream = getClass().getResourceAsStream("/reports/Proyecto_Final_Boletos_Match.jrxml");
            if (reporteStream == null) {
                throw new FileNotFoundException("No se encontró el reporte en el JAR");
            }

            ReporteService.showReport(reporteStream, params);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_report_matchMouseClicked

    private void btn_report_userMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_report_userMouseClicked
        try {
            Map<String, Object> params = new java.util.HashMap<>();

            // Cargar la imagen desde el JAR
            InputStream imagenStream = getClass().getResourceAsStream("/imagenes/Proyecto_nuevo.jpg");
            if (imagenStream == null) {
                throw new FileNotFoundException("No se encontró la imagen en el JAR");
            }
            params.put("IMAGEN_LOGO", imagenStream);

            // Cargar el reporte desde el JAR
            InputStream reporteStream = getClass().getResourceAsStream("/reports/Proyecto_Final_Boletos_Vendor_v2.jrxml");
            if (reporteStream == null) {
                throw new FileNotFoundException("No se encontró el reporte en el JAR");
            }

            ReporteService.showReport(reporteStream, params);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al generar el reporte: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_report_userMouseClicked

    


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
            java.util.logging.Logger.getLogger(Mini_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mini_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mini_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mini_Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mini_Dashboard().setVisible(true);
            }
        });
    }

// <editor-fold defaultstate="collapsed" desc="Declaracion de Variables">
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel Title;
    private javax.swing.JSeparator Title_Separator;
    private javax.swing.JPanel bar;
    private javax.swing.JLabel btb_client_txt;
    private javax.swing.JLabel btb_emp_txt;
    private javax.swing.JLabel btb_prod_txt;
    private javax.swing.JLabel btb_prov_txt;
    private javax.swing.JLabel btb_user_txt;
    private javax.swing.JLabel btb_user_txt1;
    private javax.swing.JLabel btb_user_txt2;
    private javax.swing.JPanel btn_det_sale;
    private javax.swing.JPanel btn_inv;
    private javax.swing.JPanel btn_match;
    private javax.swing.JPanel btn_place;
    private javax.swing.JPanel btn_report_match;
    private javax.swing.JPanel btn_report_user;
    private javax.swing.JPanel btn_sales;
    private javax.swing.JPanel btn_usr;
    private javax.swing.JPanel exit_cube;
    private javax.swing.JLabel exit_txt;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
}
