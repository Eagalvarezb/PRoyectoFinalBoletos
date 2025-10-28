/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.umg.proyectofinalboletos.view;


import java.awt.Color;
import com.umg.proyectofinalboletos.service.*;
/**
 * @author MK
 */
public class Login_View extends javax.swing.JFrame {

    int xmouse, ymouse;
    public Login_View() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Background = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Semi_Background = new javax.swing.JLabel();
        bar = new javax.swing.JPanel();
        exit_cube = new javax.swing.JPanel();
        exit_txt = new javax.swing.JLabel();
        Iniicio_Sesion = new javax.swing.JLabel();
        User_Field = new javax.swing.JLabel();
        User_txt = new javax.swing.JTextField();
        Separator_User = new javax.swing.JSeparator();
        Pass_Field = new javax.swing.JLabel();
        Password_txt = new javax.swing.JPasswordField();
        Separator_Password = new javax.swing.JSeparator();
        loginbtn = new javax.swing.JPanel();
        loginbtntxt = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1080, 720));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Background.setBackground(new java.awt.Color(255, 255, 255));
        Background.setPreferredSize(new java.awt.Dimension(1080, 720));
        Background.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setBackground(new java.awt.Color(255, 255, 255));
        Logo.setForeground(new java.awt.Color(255, 255, 255));
        Logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/LOGO_ENTERPRISE_MINI.png"))); // NOI18N
        Logo.setMaximumSize(new java.awt.Dimension(270, 270));
        Logo.setMinimumSize(new java.awt.Dimension(270, 270));
        Logo.setPreferredSize(new java.awt.Dimension(400, 400));
        Background.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 170, -1, -1));

        Semi_Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icon.png"))); // NOI18N
        Background.add(Semi_Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 500, 720));

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

        exit_cube.setBackground(new java.awt.Color(255, 255, 255));
        exit_cube.setMinimumSize(new java.awt.Dimension(50, 50));
        exit_cube.setPreferredSize(new java.awt.Dimension(50, 50));

        exit_txt.setFont(new java.awt.Font("Roboto Light", 0, 48)); // NOI18N
        exit_txt.setForeground(new java.awt.Color(0, 0, 0));
        exit_txt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        exit_txt.setText("x");
        exit_txt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
            .addComponent(exit_txt, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );
        exit_cubeLayout.setVerticalGroup(
            exit_cubeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(exit_cubeLayout.createSequentialGroup()
                .addComponent(exit_txt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout barLayout = new javax.swing.GroupLayout(bar);
        bar.setLayout(barLayout);
        barLayout.setHorizontalGroup(
            barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barLayout.createSequentialGroup()
                .addComponent(exit_cube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1030, Short.MAX_VALUE))
        );
        barLayout.setVerticalGroup(
            barLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barLayout.createSequentialGroup()
                .addComponent(exit_cube, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        Background.add(bar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        Iniicio_Sesion.setFont(new java.awt.Font("Roboto Black", 0, 48)); // NOI18N
        Iniicio_Sesion.setForeground(new java.awt.Color(0, 0, 0));
        Iniicio_Sesion.setText("INICIAR SESION");
        Background.add(Iniicio_Sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        User_Field.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        User_Field.setForeground(new java.awt.Color(0, 0, 0));
        User_Field.setText("USUARIO");
        Background.add(User_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));

        User_txt.setBackground(new java.awt.Color(255, 255, 255));
        User_txt.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        User_txt.setText("Ingrese su Usuario");
        User_txt.setBorder(null);
        User_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                User_txtMousePressed(evt);
            }
        });
        Background.add(User_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 460, 29));

        Separator_User.setForeground(new java.awt.Color(0, 0, 0));
        Background.add(Separator_User, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 360, 460, 20));

        Pass_Field.setFont(new java.awt.Font("Roboto Medium", 0, 24)); // NOI18N
        Pass_Field.setForeground(new java.awt.Color(0, 0, 0));
        Pass_Field.setText("CONTRASEÑA");
        Background.add(Pass_Field, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, -1, -1));

        Password_txt.setBackground(new java.awt.Color(255, 255, 255));
        Password_txt.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        Password_txt.setText("**********");
        Password_txt.setBorder(null);
        Password_txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                Password_txtMousePressed(evt);
            }
        });
        Background.add(Password_txt, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 460, 29));

        Separator_Password.setForeground(new java.awt.Color(0, 0, 0));
        Background.add(Separator_Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 460, 20));

        loginbtn.setBackground(new java.awt.Color(98, 167, 97));
        loginbtn.setForeground(new java.awt.Color(255, 255, 255));
        loginbtn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        loginbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                loginbtnMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                loginbtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                loginbtnMouseExited(evt);
            }
        });

        loginbtntxt.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        loginbtntxt.setForeground(new java.awt.Color(255, 255, 255));
        loginbtntxt.setText("ENTRAR");

        javax.swing.GroupLayout loginbtnLayout = new javax.swing.GroupLayout(loginbtn);
        loginbtn.setLayout(loginbtnLayout);
        loginbtnLayout.setHorizontalGroup(
            loginbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginbtnLayout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addComponent(loginbtntxt)
                .addContainerGap(45, Short.MAX_VALUE))
        );
        loginbtnLayout.setVerticalGroup(
            loginbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, loginbtnLayout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(loginbtntxt)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        Background.add(loginbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, -1, -1));

        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

// <editor-fold defaultstate="collapsed" desc="Button config">
    private void barMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMousePressed
    xmouse= evt.getX();
    ymouse= evt.getY();
    }//GEN-LAST:event_barMousePressed

    private void barMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_barMouseDragged
        int x = evt.getXOnScreen();
        int y = evt.getYOnScreen();
        this.setLocation(x - xmouse,y - ymouse);
    }//GEN-LAST:event_barMouseDragged

    private void exit_txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_txtMouseClicked
    System.exit(0);
    }//GEN-LAST:event_exit_txtMouseClicked

    private void exit_txtMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_txtMouseEntered
    exit_cube.setBackground(Color.red);
    exit_txt.setForeground(Color.white);
    }//GEN-LAST:event_exit_txtMouseEntered

    private void exit_txtMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exit_txtMouseExited
    exit_cube.setBackground(Color.white);
    exit_txt.setForeground(Color.black);
    }//GEN-LAST:event_exit_txtMouseExited

    private void loginbtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseEntered
    loginbtn.setBackground(new Color(65,108,64));
    loginbtntxt.setForeground(Color.WHITE);    
    }//GEN-LAST:event_loginbtnMouseEntered

    private void loginbtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseExited
    loginbtn.setBackground(new Color(98,167,97));
    loginbtntxt.setForeground(Color.WHITE);    
    }//GEN-LAST:event_loginbtnMouseExited
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="login action performed">
    private void loginbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_loginbtnMouseClicked
    String usuario = User_txt.getText();
    String contrasena = new String(Password_txt.getPassword());

    LoginService service = new LoginService();
    service.login(usuario, contrasena, this);
    }//GEN-LAST:event_loginbtnMouseClicked
// </editor-fold>
    
// <editor-fold defaultstate="collapsed" desc="TXT area config">
    private void User_txtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_User_txtMousePressed
    if (User_txt.getText().equals("Ingrese su Usuario")){
        User_txt.setText("");
        User_txt.setForeground(Color.BLACK);
    }
    if(String.valueOf(Password_txt.getPassword()).isEmpty()){
        Password_txt.setText("**********");
        Password_txt.setForeground(new Color(204,204,204));
    }
    }//GEN-LAST:event_User_txtMousePressed

    private void Password_txtMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Password_txtMousePressed
    if(String.valueOf(Password_txt.getPassword()).equals("**********")){
        Password_txt.setText("");
        Password_txt.setForeground(Color.BLACK);
    }
    if(User_txt.getText().isEmpty()){
        User_txt.setText("Ingrese su Usuario");
        User_txt.setForeground(new Color(204,204,204));
    }
    }//GEN-LAST:event_Password_txtMousePressed
// </editor-fold>
    
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
            java.util.logging.Logger.getLogger(Login_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login_View.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login_View().setVisible(true);
            }
        });
    }
    
// <editor-fold defaultstate="collapsed" desc="Variable declaration">
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Background;
    private javax.swing.JLabel Iniicio_Sesion;
    private javax.swing.JLabel Logo;
    private javax.swing.JLabel Pass_Field;
    private javax.swing.JPasswordField Password_txt;
    private javax.swing.JLabel Semi_Background;
    private javax.swing.JSeparator Separator_Password;
    private javax.swing.JSeparator Separator_User;
    private javax.swing.JLabel User_Field;
    private javax.swing.JTextField User_txt;
    private javax.swing.JPanel bar;
    private javax.swing.JPanel exit_cube;
    private javax.swing.JLabel exit_txt;
    private javax.swing.JPanel loginbtn;
    private javax.swing.JLabel loginbtntxt;
    // End of variables declaration//GEN-END:variables
}
// </editor-fold>