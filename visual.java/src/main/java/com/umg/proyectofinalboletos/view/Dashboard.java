/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.umg.proyectofinalboletos.view;
import java.awt.Color;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;
import com.umg.proyectofinalboletos.service.ReporteService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Map;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author MK
 */

public class Dashboard extends javax.swing.JFrame {

/**
* Creates new form Dash
*/
    
    int xmouse, ymouse;
    private JPanel[] paneles;
    public Dashboard() {
        initComponents();
        this.setLocationRelativeTo(null);
//-----------------------------------------------
// <editor-fold defaultstate="collapsed" desc="Fecha">
LocalDate actualdate = LocalDate.now();
    String dayweek = capitalize(actualdate.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        int daymonth = actualdate.getDayOfMonth();
        String month = capitalize(actualdate.getMonth().getDisplayName(TextStyle.FULL, new Locale("es", "ES")));
        int year = actualdate.getYear();
        String mensaje = "Hoy es " + dayweek + " " + daymonth + " de " + month + " de " + year;
    fecha.setText(mensaje);
// </editor-fold>
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
        windows = new javax.swing.JLabel();
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
        Sub_Header = new javax.swing.JPanel();
        fecha = new javax.swing.JLabel();
        Header = new javax.swing.JPanel();
        mini_message = new javax.swing.JLabel();
        DesktopPane = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 720));

        Background.setBackground(new java.awt.Color(255, 255, 255));

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

        windows.setFont(new java.awt.Font("Roboto Light", 0, 36)); // NOI18N
        windows.setForeground(new java.awt.Color(255, 255, 255));
        windows.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        windows.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/windows.png"))); // NOI18N
        windows.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        windows.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                windowsMouseClicked(evt);
            }
        });
        bar.add(windows, new org.netbeans.lib.awtextra.AbsoluteConstraints(1230, 5, -1, -1));

        exit_cube.setBackground(new java.awt.Color(65, 108, 64));
        exit_cube.setMinimumSize(new java.awt.Dimension(50, 50));
        exit_cube.setPreferredSize(new java.awt.Dimension(44, 44));
        exit_cube.setVerifyInputWhenFocusTarget(false);

        exit_txt.setFont(new java.awt.Font("Roboto Light", 0, 36)); // NOI18N
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
            .addComponent(exit_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        exit_cubeLayout.setVerticalGroup(
            exit_cubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(exit_txt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        bar.add(exit_cube, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Menu.setBackground(new java.awt.Color(65, 108, 64));
        Menu.setPreferredSize(new java.awt.Dimension(250, 720));
        Menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Title.setFont(new java.awt.Font("Roboto Black", 0, 36)); // NOI18N
        Title.setForeground(new java.awt.Color(255, 255, 255));
        Title.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        Title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGO_ENTERPRISE_MICRO.png"))); // NOI18N
        Title.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TitleMouseClicked(evt);
            }
        });
        Menu.add(Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 55, -1, 190));

        Title_Separator.setBackground(new java.awt.Color(255, 255, 255));
        Menu.add(Title_Separator, new org.netbeans.lib.awtextra.AbsoluteConstraints(15, 245, 220, 10));

        btn_usr.setBackground(new java.awt.Color(65, 108, 64));
        btn_usr.setPreferredSize(new java.awt.Dimension(0, 60));
        btn_usr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_usrMouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/account-multiple.png"))); // NOI18N
        jLabel3.setText("Usuarios");

        javax.swing.GroupLayout btn_usrLayout = new javax.swing.GroupLayout(btn_usr);
        btn_usr.setLayout(btn_usrLayout);
        btn_usrLayout.setHorizontalGroup(
            btn_usrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_usrLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addGap(130, 130, 130))
        );
        btn_usrLayout.setVerticalGroup(
            btn_usrLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_usrLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18))
        );

        Menu.add(btn_usr, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 250, -1));

        btn_place.setBackground(new java.awt.Color(65, 108, 64));
        btn_place.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_placeMouseClicked(evt);
            }
        });

        btb_emp_txt.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_emp_txt.setForeground(new java.awt.Color(255, 255, 255));
        btb_emp_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/home-outline.png"))); // NOI18N
        btb_emp_txt.setText("Localidades");

        javax.swing.GroupLayout btn_placeLayout = new javax.swing.GroupLayout(btn_place);
        btn_place.setLayout(btn_placeLayout);
        btn_placeLayout.setHorizontalGroup(
            btn_placeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_placeLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btb_emp_txt)
                .addGap(116, 116, 116))
        );
        btn_placeLayout.setVerticalGroup(
            btn_placeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_placeLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btb_emp_txt)
                .addGap(18, 18, 18))
        );

        Menu.add(btn_place, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 250, -1));

        btn_match.setBackground(new java.awt.Color(65, 108, 64));
        btn_match.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_matchMouseClicked(evt);
            }
        });

        btb_prod_txt.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_prod_txt.setForeground(new java.awt.Color(255, 255, 255));
        btb_prod_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/images.png"))); // NOI18N
        btb_prod_txt.setText("Partidos");

        javax.swing.GroupLayout btn_matchLayout = new javax.swing.GroupLayout(btn_match);
        btn_match.setLayout(btn_matchLayout);
        btn_matchLayout.setHorizontalGroup(
            btn_matchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_matchLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btb_prod_txt)
                .addGap(122, 122, 122))
        );
        btn_matchLayout.setVerticalGroup(
            btn_matchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_matchLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btb_prod_txt)
                .addGap(18, 18, 18))
        );

        Menu.add(btn_match, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 250, -1));

        btn_sales.setBackground(new java.awt.Color(65, 108, 64));
        btn_sales.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_salesMouseClicked(evt);
            }
        });

        btb_prov_txt.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_prov_txt.setForeground(new java.awt.Color(255, 255, 255));
        btb_prov_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/file-chart.png"))); // NOI18N
        btb_prov_txt.setText("Ventas");

        javax.swing.GroupLayout btn_salesLayout = new javax.swing.GroupLayout(btn_sales);
        btn_sales.setLayout(btn_salesLayout);
        btn_salesLayout.setHorizontalGroup(
            btn_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_salesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btb_prov_txt)
                .addGap(106, 106, 106))
        );
        btn_salesLayout.setVerticalGroup(
            btn_salesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_salesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btb_prov_txt)
                .addGap(18, 18, 18))
        );

        Menu.add(btn_sales, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 510, 250, -1));

        btn_inv.setBackground(new java.awt.Color(65, 108, 64));
        btn_inv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_invMouseClicked(evt);
            }
        });

        btb_client_txt.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_client_txt.setForeground(new java.awt.Color(255, 255, 255));
        btb_client_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/proov.png"))); // NOI18N
        btb_client_txt.setText("Inventario");

        javax.swing.GroupLayout btn_invLayout = new javax.swing.GroupLayout(btn_inv);
        btn_inv.setLayout(btn_invLayout);
        btn_invLayout.setHorizontalGroup(
            btn_invLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_invLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btb_client_txt)
                .addGap(134, 134, 134))
        );
        btn_invLayout.setVerticalGroup(
            btn_invLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_invLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btb_client_txt)
                .addGap(18, 18, 18))
        );

        Menu.add(btn_inv, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 450, 250, -1));

        btn_det_sale.setBackground(new java.awt.Color(65, 108, 64));
        btn_det_sale.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_det_saleMouseClicked(evt);
            }
        });

        btb_user_txt.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_user_txt.setForeground(new java.awt.Color(255, 255, 255));
        btb_user_txt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/book-open-page-variant.png"))); // NOI18N
        btb_user_txt.setText("Detalle de Ventas");

        javax.swing.GroupLayout btn_det_saleLayout = new javax.swing.GroupLayout(btn_det_sale);
        btn_det_sale.setLayout(btn_det_saleLayout);
        btn_det_saleLayout.setHorizontalGroup(
            btn_det_saleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_det_saleLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btb_user_txt)
                .addGap(131, 131, 131))
        );
        btn_det_saleLayout.setVerticalGroup(
            btn_det_saleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_det_saleLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btb_user_txt)
                .addGap(18, 18, 18))
        );

        Menu.add(btn_det_sale, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 570, 250, -1));

        btn_report_match.setBackground(new java.awt.Color(65, 108, 64));
        btn_report_match.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_report_matchMouseClicked(evt);
            }
        });

        btb_user_txt1.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_user_txt1.setForeground(new java.awt.Color(255, 255, 255));
        btb_user_txt1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/images.png"))); // NOI18N
        btb_user_txt1.setText("Reporte Partidos");

        javax.swing.GroupLayout btn_report_matchLayout = new javax.swing.GroupLayout(btn_report_match);
        btn_report_match.setLayout(btn_report_matchLayout);
        btn_report_matchLayout.setHorizontalGroup(
            btn_report_matchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_report_matchLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btb_user_txt1)
                .addGap(131, 131, 131))
        );
        btn_report_matchLayout.setVerticalGroup(
            btn_report_matchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_report_matchLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btb_user_txt1)
                .addGap(18, 18, 18))
        );

        Menu.add(btn_report_match, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 630, 250, -1));

        btn_report_user.setBackground(new java.awt.Color(65, 108, 64));
        btn_report_user.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_report_userMouseClicked(evt);
            }
        });

        btb_user_txt2.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        btb_user_txt2.setForeground(new java.awt.Color(255, 255, 255));
        btb_user_txt2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/account-multiple.png"))); // NOI18N
        btb_user_txt2.setText("Reporte Usuarios");

        javax.swing.GroupLayout btn_report_userLayout = new javax.swing.GroupLayout(btn_report_user);
        btn_report_user.setLayout(btn_report_userLayout);
        btn_report_userLayout.setHorizontalGroup(
            btn_report_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_report_userLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(btb_user_txt2)
                .addGap(131, 131, 131))
        );
        btn_report_userLayout.setVerticalGroup(
            btn_report_userLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_report_userLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btb_user_txt2)
                .addGap(18, 18, 18))
        );

        Menu.add(btn_report_user, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 690, 250, -1));

        Sub_Header.setBackground(new java.awt.Color(98, 167, 97));
        Sub_Header.setPreferredSize(new java.awt.Dimension(830, 100));

        fecha.setFont(new java.awt.Font("Roboto Light", 0, 36)); // NOI18N
        fecha.setForeground(new java.awt.Color(255, 255, 255));
        fecha.setText("Hoy es ______ -- de _____ de -----");

        javax.swing.GroupLayout Sub_HeaderLayout = new javax.swing.GroupLayout(Sub_Header);
        Sub_Header.setLayout(Sub_HeaderLayout);
        Sub_HeaderLayout.setHorizontalGroup(
            Sub_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sub_HeaderLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(fecha)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        Sub_HeaderLayout.setVerticalGroup(
            Sub_HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Sub_HeaderLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(fecha)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        Header.setBackground(new java.awt.Color(255, 255, 255));

        mini_message.setBackground(new java.awt.Color(204, 204, 204));
        mini_message.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        mini_message.setForeground(new java.awt.Color(153, 153, 153));
        mini_message.setText("Gooooooooolaaaaaaaaazooooooo!!!!!!!!!!");

        javax.swing.GroupLayout HeaderLayout = new javax.swing.GroupLayout(Header);
        Header.setLayout(HeaderLayout);
        HeaderLayout.setHorizontalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HeaderLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mini_message)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        HeaderLayout.setVerticalGroup(
            HeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, HeaderLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(mini_message)
                .addGap(15, 15, 15))
        );

        DesktopPane.setBackground(new java.awt.Color(255, 255, 255));
        DesktopPane.setPreferredSize(new java.awt.Dimension(1030, 750));

        javax.swing.GroupLayout DesktopPaneLayout = new javax.swing.GroupLayout(DesktopPane);
        DesktopPane.setLayout(DesktopPaneLayout);
        DesktopPaneLayout.setHorizontalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        DesktopPaneLayout.setVerticalGroup(
            DesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout BackgroundLayout = new javax.swing.GroupLayout(Background);
        Background.setLayout(BackgroundLayout);
        BackgroundLayout.setHorizontalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, 1280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(Menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGap(250, 250, 250)
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Sub_Header, javax.swing.GroupLayout.DEFAULT_SIZE, 1030, Short.MAX_VALUE)
                    .addComponent(DesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        BackgroundLayout.setVerticalGroup(
            BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BackgroundLayout.createSequentialGroup()
                .addGroup(BackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(BackgroundLayout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(Sub_Header, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addComponent(DesktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(Menu, javax.swing.GroupLayout.DEFAULT_SIZE, 920, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// <editor-fold defaultstate="collapsed" desc="Configuraciones Btn Exit">    
    private void exit_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_txtMouseClicked
        System.exit(0);
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

    private void windowsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_windowsMouseClicked
        JFrame ventanaFlotante = new Mini_Dashboard();
        ventanaFlotante.setSize(1202, 751);
        ventanaFlotante.setLocationRelativeTo(this); // centra respecto al Dashboard
        ventanaFlotante.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // solo se cierra la ventana, no todo
        ventanaFlotante.setVisible(true);
    }//GEN-LAST:event_windowsMouseClicked

    private void btn_report_matchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_report_matchMouseClicked
        try {
            Map<String, Object> params = new HashMap<>();

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
            Map<String, Object> params = new HashMap<>();

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

// <editor-fold defaultstate="collapsed" desc="Declaracion de Variables">
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JDesktopPane DesktopPane;
    private javax.swing.JPanel Header;
    private javax.swing.JPanel Menu;
    private javax.swing.JPanel Sub_Header;
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
    private javax.swing.JLabel fecha;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel mini_message;
    private javax.swing.JLabel windows;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
}
