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
public class Proveedores extends javax.swing.JFrame {

    /**
     * Creates new form Proveedores
     */
    public Proveedores() {
        initComponents();
        
        setTitle("Cuentas de proveedores");

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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_Volver = new javax.swing.JButton();
        btn_Crear = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Carta = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Servicios = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Postre = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_Acompañante = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_Bebida = new javax.swing.JTable();
        jDate_Fecha = new com.toedter.calendar.JDateChooser();
        jTextField_Descripcion = new javax.swing.JTextField();
        jTextField_Valor = new javax.swing.JTextField();
        btn_Carta = new javax.swing.JButton();
        btn_Acompañante = new javax.swing.JButton();
        btn_Bebida = new javax.swing.JButton();
        btn_Postre = new javax.swing.JButton();
        btn_Servicio = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_Proveedor = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable_Valores = new javax.swing.JTable();
        btn_Buscar = new javax.swing.JButton();
        jTextField_Proveedor = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(25, 23, 23));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bar_Log.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 0, -1, 97));

        btn_Volver.setBackground(new java.awt.Color(25, 23, 23));
        btn_Volver.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        btn_Volver.setForeground(new java.awt.Color(255, 255, 255));
        btn_Volver.setText("Volver");
        jPanel2.add(btn_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_Crear.setBackground(new java.awt.Color(25, 23, 23));
        btn_Crear.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        btn_Crear.setForeground(new java.awt.Color(255, 255, 255));
        btn_Crear.setText("Proveedor");
        jPanel2.add(btn_Crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 10, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Cedula proveedor");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Descripcion");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Valor");

        jTable_Carta.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Carta.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Carta.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Carta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_Carta);

        jTable_Servicios.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Servicios.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Servicios.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Servicios.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable_Servicios);

        jTable_Postre.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Postre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Postre.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Postre.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable_Postre);

        jTable_Acompañante.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Acompañante.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Acompañante.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Acompañante.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable_Acompañante);

        jTable_Bebida.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Bebida.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Bebida.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Bebida.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable_Bebida);

        jDate_Fecha.setBackground(new java.awt.Color(255, 255, 255));
        jDate_Fecha.setForeground(new java.awt.Color(0, 0, 0));
        jDate_Fecha.setDateFormatString("YYYY-MM-dd");
        jDate_Fecha.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N

        jTextField_Descripcion.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Descripcion.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField_Descripcion.setForeground(new java.awt.Color(0, 0, 0));

        jTextField_Valor.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Valor.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField_Valor.setForeground(new java.awt.Color(0, 0, 0));

        btn_Carta.setBackground(new java.awt.Color(0, 0, 0));
        btn_Carta.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Carta.setForeground(new java.awt.Color(255, 255, 255));
        btn_Carta.setText("Cargar proteina");

        btn_Acompañante.setBackground(new java.awt.Color(0, 0, 0));
        btn_Acompañante.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Acompañante.setForeground(new java.awt.Color(255, 255, 255));
        btn_Acompañante.setText("Cargar acompañantes");

        btn_Bebida.setBackground(new java.awt.Color(0, 0, 0));
        btn_Bebida.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Bebida.setForeground(new java.awt.Color(255, 255, 255));
        btn_Bebida.setText("Cargar bebida");

        btn_Postre.setBackground(new java.awt.Color(0, 0, 0));
        btn_Postre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Postre.setForeground(new java.awt.Color(255, 255, 255));
        btn_Postre.setText("Cargar postre");

        btn_Servicio.setBackground(new java.awt.Color(0, 0, 0));
        btn_Servicio.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Servicio.setForeground(new java.awt.Color(255, 255, 255));
        btn_Servicio.setText("Cargar servicio");

        jTable_Proveedor.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Proveedor.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Proveedor.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Proveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable_Proveedor);

        jTable_Valores.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Valores.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTable_Valores.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Valores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(jTable_Valores);

        btn_Buscar.setBackground(new java.awt.Color(0, 0, 0));
        btn_Buscar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Buscar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Buscar.setText("Buscar");

        jTextField_Proveedor.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Proveedor.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jTextField_Proveedor.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_Carta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_Buscar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextField_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextField_Valor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jTextField_Descripcion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jDate_Fecha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_Acompañante)
                            .addComponent(btn_Bebida)
                            .addComponent(btn_Postre)
                            .addComponent(btn_Servicio))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addGap(176, 176, 176))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField_Proveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jDate_Fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Descripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Valor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(37, 37, 37)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_Carta)
                            .addComponent(btn_Buscar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Acompañante)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Bebida)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Postre)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_Servicio))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(298, 298, 298))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1238, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 785, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Proveedores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Proveedores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Acompañante;
    public javax.swing.JButton btn_Bebida;
    public javax.swing.JButton btn_Buscar;
    public javax.swing.JButton btn_Carta;
    public javax.swing.JButton btn_Crear;
    public javax.swing.JButton btn_Postre;
    public javax.swing.JButton btn_Servicio;
    public javax.swing.JButton btn_Volver;
    public com.toedter.calendar.JDateChooser jDate_Fecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    public javax.swing.JTable jTable_Acompañante;
    public javax.swing.JTable jTable_Bebida;
    public javax.swing.JTable jTable_Carta;
    public javax.swing.JTable jTable_Postre;
    public javax.swing.JTable jTable_Proveedor;
    public javax.swing.JTable jTable_Servicios;
    public javax.swing.JTable jTable_Valores;
    public javax.swing.JTextField jTextField_Descripcion;
    public javax.swing.JTextField jTextField_Proveedor;
    public javax.swing.JTextField jTextField_Valor;
    // End of variables declaration//GEN-END:variables
}
