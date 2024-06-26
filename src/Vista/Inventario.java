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
public class Inventario extends javax.swing.JFrame {

    /**
     * Creates new form Inventario
     */
    public Inventario() {
        initComponents();
        
        setTitle("Gestion de inventarios");

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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        btn_Volver1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jTable_Carta1 = new javax.swing.JTable();
        jScrollPane10 = new javax.swing.JScrollPane();
        jTable_Postre1 = new javax.swing.JTable();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable_Acompañante1 = new javax.swing.JTable();
        jScrollPane12 = new javax.swing.JScrollPane();
        jTable_Bebida1 = new javax.swing.JTable();
        jTextField_Cantidad = new javax.swing.JTextField();
        btn_Carta1 = new javax.swing.JButton();
        btn_Acompañante1 = new javax.swing.JButton();
        btn_Bebida1 = new javax.swing.JButton();
        btn_Postre1 = new javax.swing.JButton();
        btn_Carta2 = new javax.swing.JButton();
        btn_Acompañante2 = new javax.swing.JButton();
        btn_Bebida2 = new javax.swing.JButton();
        btn_Postre2 = new javax.swing.JButton();
        jComboBox_Proveedor = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(25, 23, 23));
        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bar_Log.jpg"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, -1, 97));

        btn_Volver1.setBackground(new java.awt.Color(25, 23, 23));
        btn_Volver1.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        btn_Volver1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Volver1.setText("Volver");
        jPanel5.add(btn_Volver1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Codigo elemento");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Cantidad");

        jTable_Carta1.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Carta1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Carta1.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Carta1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(jTable_Carta1);

        jTable_Postre1.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Postre1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Postre1.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Postre1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(jTable_Postre1);

        jTable_Acompañante1.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Acompañante1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Acompañante1.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Acompañante1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(jTable_Acompañante1);

        jTable_Bebida1.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Bebida1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Bebida1.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Bebida1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(jTable_Bebida1);

        jTextField_Cantidad.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Cantidad.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField_Cantidad.setForeground(new java.awt.Color(0, 0, 0));

        btn_Carta1.setBackground(new java.awt.Color(0, 0, 0));
        btn_Carta1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Carta1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Carta1.setText("Cargar Carta");

        btn_Acompañante1.setBackground(new java.awt.Color(0, 0, 0));
        btn_Acompañante1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Acompañante1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Acompañante1.setText("Cargar Acompañante");

        btn_Bebida1.setBackground(new java.awt.Color(0, 0, 0));
        btn_Bebida1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Bebida1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Bebida1.setText("Cargar bebida");

        btn_Postre1.setBackground(new java.awt.Color(0, 0, 0));
        btn_Postre1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Postre1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Postre1.setText("Cargar postre");

        btn_Carta2.setBackground(new java.awt.Color(0, 0, 0));
        btn_Carta2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Carta2.setForeground(new java.awt.Color(255, 255, 255));
        btn_Carta2.setText("Actualizar carta");

        btn_Acompañante2.setBackground(new java.awt.Color(0, 0, 0));
        btn_Acompañante2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Acompañante2.setForeground(new java.awt.Color(255, 255, 255));
        btn_Acompañante2.setText("Actualizar  Acompañante");

        btn_Bebida2.setBackground(new java.awt.Color(0, 0, 0));
        btn_Bebida2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Bebida2.setForeground(new java.awt.Color(255, 255, 255));
        btn_Bebida2.setText("Actualizar bebida");

        btn_Postre2.setBackground(new java.awt.Color(0, 0, 0));
        btn_Postre2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Postre2.setForeground(new java.awt.Color(255, 255, 255));
        btn_Postre2.setText("Actualizar postre");

        jComboBox_Proveedor.setBackground(new java.awt.Color(255, 255, 255));
        jComboBox_Proveedor.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jComboBox_Proveedor.setForeground(new java.awt.Color(0, 0, 0));
        jComboBox_Proveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox_Proveedor.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Carta1)
                            .addComponent(btn_Acompañante1)
                            .addComponent(btn_Bebida1)
                            .addComponent(btn_Postre1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Carta2)
                            .addComponent(btn_Acompañante2)
                            .addComponent(btn_Bebida2)
                            .addComponent(btn_Postre2))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(759, 759, 759))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField_Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBox_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_Carta1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Acompañante1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Bebida1)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Postre1)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane12, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btn_Carta2)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Acompañante2)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Bebida2)
                        .addGap(18, 18, 18)
                        .addComponent(btn_Postre2)))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 1096, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Acompañante1;
    public javax.swing.JButton btn_Acompañante2;
    public javax.swing.JButton btn_Bebida1;
    public javax.swing.JButton btn_Bebida2;
    public javax.swing.JButton btn_Carta1;
    public javax.swing.JButton btn_Carta2;
    public javax.swing.JButton btn_Postre1;
    public javax.swing.JButton btn_Postre2;
    public javax.swing.JButton btn_Volver1;
    public javax.swing.JComboBox<String> jComboBox_Proveedor;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane8;
    public javax.swing.JTable jTable_Acompañante1;
    public javax.swing.JTable jTable_Bebida1;
    public javax.swing.JTable jTable_Carta1;
    public javax.swing.JTable jTable_Postre1;
    public javax.swing.JTextField jTextField_Cantidad;
    // End of variables declaration//GEN-END:variables
}
