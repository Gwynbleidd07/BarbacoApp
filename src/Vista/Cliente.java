/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import javax.swing.ImageIcon;

/**
 *
 * @author Andrés Lombo
 */
public class Cliente extends javax.swing.JFrame {

    /**
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
        
        setTitle("Gestion de clientes");

        try {
            setIconImage(new ImageIcon(getClass().getResource("/javax/swing/plaf/metal/icons/ocean/computer.gif")).getImage());
        } catch (Exception e) {
            e.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_Volver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jDate_Nacimiento = new com.toedter.calendar.JDateChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea_Comentario = new javax.swing.JTextArea();
        jTextField_Calificacion = new javax.swing.JTextField();
        jTextField_Celular = new javax.swing.JTextField();
        jTextField_Apellido = new javax.swing.JTextField();
        jTextField_Nombre = new javax.swing.JTextField();
        jTextField_Fecha = new javax.swing.JTextField();
        jTextField_Cedula = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Cliente = new javax.swing.JTable();
        btn_Cliente = new javax.swing.JButton();
        btn_Buscar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(25, 23, 23));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bar_Log.jpg"))); // NOI18N

        btn_Volver.setBackground(new java.awt.Color(25, 23, 23));
        btn_Volver.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        btn_Volver.setForeground(new java.awt.Color(255, 255, 255));
        btn_Volver.setText("Volver");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Volver)
                .addGap(356, 356, 356)
                .addComponent(jLabel1)
                .addContainerGap(408, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_Volver)
                .addContainerGap(74, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cedula");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Apellido");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Celular");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha nacimiento");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Fecha de ingreso");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Comentarios");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Calificacion");

        jDate_Nacimiento.setBackground(new java.awt.Color(255, 255, 255));
        jDate_Nacimiento.setForeground(new java.awt.Color(0, 0, 0));
        jDate_Nacimiento.setDateFormatString("yyyy-MM-dd");
        jDate_Nacimiento.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jTextArea_Comentario.setBackground(new java.awt.Color(255, 255, 255));
        jTextArea_Comentario.setColumns(20);
        jTextArea_Comentario.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextArea_Comentario.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea_Comentario.setLineWrap(true);
        jTextArea_Comentario.setRows(5);
        jTextArea_Comentario.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextArea_Comentario);

        jTextField_Calificacion.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Calificacion.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField_Calificacion.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_Celular.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Celular.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField_Celular.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_Apellido.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Apellido.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField_Apellido.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_Nombre.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Nombre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField_Nombre.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_Fecha.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Fecha.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField_Fecha.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_Cedula.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Cedula.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField_Cedula.setForeground(new java.awt.Color(0, 0, 0));

        jTable_Cliente.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Cliente.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Cliente.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Cliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable_Cliente);

        btn_Cliente.setBackground(new java.awt.Color(0, 0, 0));
        btn_Cliente.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Cliente.setForeground(new java.awt.Color(255, 255, 255));
        btn_Cliente.setText("Agregar cliente");

        btn_Buscar.setBackground(new java.awt.Color(0, 0, 0));
        btn_Buscar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Buscar.setText("Buscar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(btn_Cliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_Buscar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jDate_Nacimiento, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(jTextField_Calificacion)
                                    .addComponent(jTextField_Celular)
                                    .addComponent(jTextField_Apellido)
                                    .addComponent(jTextField_Nombre)
                                    .addComponent(jTextField_Fecha)
                                    .addComponent(jTextField_Cedula))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_Cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jDate_Nacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(32, 32, 32)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(9, 9, 9)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField_Calificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTextField_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_Cliente)
                    .addComponent(btn_Buscar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1210, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Cliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Buscar;
    public javax.swing.JButton btn_Cliente;
    public javax.swing.JButton btn_Volver;
    public com.toedter.calendar.JDateChooser jDate_Nacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public javax.swing.JTable jTable_Cliente;
    public javax.swing.JTextArea jTextArea_Comentario;
    public javax.swing.JTextField jTextField_Apellido;
    public javax.swing.JTextField jTextField_Calificacion;
    public javax.swing.JTextField jTextField_Cedula;
    public javax.swing.JTextField jTextField_Celular;
    public javax.swing.JTextField jTextField_Fecha;
    public javax.swing.JTextField jTextField_Nombre;
    // End of variables declaration//GEN-END:variables
}
