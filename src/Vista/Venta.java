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
public class Venta extends javax.swing.JFrame {

    /**
     * Creates new form Ventas
     */
    public Venta() {
        initComponents();
        
        setTitle("Registros de ventas");

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
        btn_Analisis = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jT_Factura = new javax.swing.JTextField();
        jT_IdMesero = new javax.swing.JTextField();
        jT_CantidadCarta = new javax.swing.JTextField();
        jT_CantidadAcompañantes = new javax.swing.JTextField();
        jT_CantidadBebida = new javax.swing.JTextField();
        jT_CantidadPostre = new javax.swing.JTextField();
        jCombo_Mesa = new javax.swing.JComboBox<>();
        jCombo_Carta = new javax.swing.JComboBox<>();
        jCombo_Acompañantes = new javax.swing.JComboBox<>();
        jCombo_Bebida = new javax.swing.JComboBox<>();
        jCombo_Postre = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Empleado = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable_Cuenta = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable_Carta = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable_Bebidas = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTable_Acompañantes = new javax.swing.JTable();
        btn_Limpiar = new javax.swing.JButton();
        btn_CargarPedido = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTable_Postres = new javax.swing.JTable();
        btn_Pagar = new javax.swing.JButton();
        jT_Fecha = new javax.swing.JTextField();
        btn_CargarCarta = new javax.swing.JButton();
        btn_CargarAcompañante = new javax.swing.JButton();
        btn_CargarBebida = new javax.swing.JButton();
        btn_CargarPostre = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(25, 23, 23));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Bar_Log.jpg"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, -1, 97));

        btn_Volver.setBackground(new java.awt.Color(25, 23, 23));
        btn_Volver.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        btn_Volver.setForeground(new java.awt.Color(255, 255, 255));
        btn_Volver.setText("Volver");
        jPanel2.add(btn_Volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btn_Analisis.setBackground(new java.awt.Color(25, 23, 23));
        btn_Analisis.setFont(new java.awt.Font("Calibri", 1, 16)); // NOI18N
        btn_Analisis.setForeground(new java.awt.Color(255, 255, 255));
        btn_Analisis.setText("Analisis");
        jPanel2.add(btn_Analisis, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1250, 100));

        jLabel2.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("N° Factura");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 126, -1, -1));

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Fecha");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 165, -1, -1));

        jLabel4.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("N° Mesa");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Mesero");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 257, -1, -1));

        jLabel6.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Carta");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 304, -1, -1));

        jLabel7.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Cantidad");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 351, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Acompañantes");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 398, -1, -1));

        jLabel9.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Cantidad");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 445, -1, -1));

        jLabel10.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Bebida");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 492, -1, -1));

        jLabel11.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Cantidad");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 539, -1, -1));

        jLabel12.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Postre");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 586, -1, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Cantidad");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 633, -1, -1));

        jT_Factura.setBackground(new java.awt.Color(255, 255, 255));
        jT_Factura.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jT_Factura.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jT_Factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 118, 150, -1));

        jT_IdMesero.setBackground(new java.awt.Color(255, 255, 255));
        jT_IdMesero.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jT_IdMesero.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jT_IdMesero, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 249, 150, -1));

        jT_CantidadCarta.setBackground(new java.awt.Color(255, 255, 255));
        jT_CantidadCarta.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jT_CantidadCarta.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jT_CantidadCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 343, 150, -1));

        jT_CantidadAcompañantes.setBackground(new java.awt.Color(255, 255, 255));
        jT_CantidadAcompañantes.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jT_CantidadAcompañantes.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jT_CantidadAcompañantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 437, 150, -1));

        jT_CantidadBebida.setBackground(new java.awt.Color(255, 255, 255));
        jT_CantidadBebida.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jT_CantidadBebida.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jT_CantidadBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 531, 150, -1));

        jT_CantidadPostre.setBackground(new java.awt.Color(255, 255, 255));
        jT_CantidadPostre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jT_CantidadPostre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jT_CantidadPostre, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 625, 150, -1));

        jCombo_Mesa.setBackground(new java.awt.Color(255, 255, 255));
        jCombo_Mesa.setEditable(true);
        jCombo_Mesa.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jCombo_Mesa.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jCombo_Mesa, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 202, 150, -1));

        jCombo_Carta.setBackground(new java.awt.Color(255, 255, 255));
        jCombo_Carta.setEditable(true);
        jCombo_Carta.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jCombo_Carta.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jCombo_Carta, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 296, 150, -1));

        jCombo_Acompañantes.setBackground(new java.awt.Color(255, 255, 255));
        jCombo_Acompañantes.setEditable(true);
        jCombo_Acompañantes.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jCombo_Acompañantes.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jCombo_Acompañantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 390, 150, -1));

        jCombo_Bebida.setBackground(new java.awt.Color(255, 255, 255));
        jCombo_Bebida.setEditable(true);
        jCombo_Bebida.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jCombo_Bebida.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jCombo_Bebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 484, 150, -1));

        jCombo_Postre.setBackground(new java.awt.Color(255, 255, 255));
        jCombo_Postre.setEditable(true);
        jCombo_Postre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jCombo_Postre.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jCombo_Postre, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 578, 150, -1));

        jTable_Empleado.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Empleado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable_Empleado.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Empleado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_Empleado);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 230, 120));

        jTable_Cuenta.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Cuenta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable_Cuenta.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Cuenta.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable_Cuenta);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 630, 700, 80));

        jTable_Carta.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Carta.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        jScrollPane3.setViewportView(jTable_Carta);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 110, 700, 120));

        jTable_Bebidas.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Bebidas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable_Bebidas.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Bebidas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable_Bebidas);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 380, 700, 150));

        jTable_Acompañantes.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Acompañantes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable_Acompañantes.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Acompañantes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(jTable_Acompañantes);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 230, 700, 150));

        btn_Limpiar.setBackground(new java.awt.Color(0, 0, 0));
        btn_Limpiar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Limpiar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Limpiar.setText("Limpiar");
        jPanel1.add(btn_Limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 670, -1, -1));

        btn_CargarPedido.setBackground(new java.awt.Color(0, 0, 0));
        btn_CargarPedido.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_CargarPedido.setForeground(new java.awt.Color(255, 255, 255));
        btn_CargarPedido.setText("Cargar pedido");
        jPanel1.add(btn_CargarPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 670, -1, -1));

        jTable_Postres.setBackground(new java.awt.Color(255, 255, 255));
        jTable_Postres.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTable_Postres.setForeground(new java.awt.Color(0, 0, 0));
        jTable_Postres.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(jTable_Postres);

        jPanel1.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 530, 700, 100));

        btn_Pagar.setBackground(new java.awt.Color(0, 0, 0));
        btn_Pagar.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_Pagar.setForeground(new java.awt.Color(255, 255, 255));
        btn_Pagar.setText("Pagar");
        jPanel1.add(btn_Pagar, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 670, -1, -1));

        jT_Fecha.setBackground(new java.awt.Color(255, 255, 255));
        jT_Fecha.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        jT_Fecha.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(jT_Fecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 159, 150, -1));

        btn_CargarCarta.setBackground(new java.awt.Color(0, 0, 0));
        btn_CargarCarta.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_CargarCarta.setForeground(new java.awt.Color(255, 255, 255));
        btn_CargarCarta.setText("Cargar carta");
        jPanel1.add(btn_CargarCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        btn_CargarAcompañante.setBackground(new java.awt.Color(0, 0, 0));
        btn_CargarAcompañante.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_CargarAcompañante.setForeground(new java.awt.Color(255, 255, 255));
        btn_CargarAcompañante.setText("Cargar acompañante");
        jPanel1.add(btn_CargarAcompañante, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        btn_CargarBebida.setBackground(new java.awt.Color(0, 0, 0));
        btn_CargarBebida.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_CargarBebida.setForeground(new java.awt.Color(255, 255, 255));
        btn_CargarBebida.setText("Cargar bebida");
        jPanel1.add(btn_CargarBebida, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 480, -1, -1));

        btn_CargarPostre.setBackground(new java.awt.Color(0, 0, 0));
        btn_CargarPostre.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btn_CargarPostre.setForeground(new java.awt.Color(255, 255, 255));
        btn_CargarPostre.setText("Cargar Postre");
        jPanel1.add(btn_CargarPostre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 580, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Venta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Venta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_Analisis;
    public javax.swing.JButton btn_CargarAcompañante;
    public javax.swing.JButton btn_CargarBebida;
    public javax.swing.JButton btn_CargarCarta;
    public javax.swing.JButton btn_CargarPedido;
    public javax.swing.JButton btn_CargarPostre;
    public javax.swing.JButton btn_Limpiar;
    public javax.swing.JButton btn_Pagar;
    public javax.swing.JButton btn_Volver;
    public javax.swing.JComboBox<String> jCombo_Acompañantes;
    public javax.swing.JComboBox<String> jCombo_Bebida;
    public javax.swing.JComboBox<String> jCombo_Carta;
    public javax.swing.JComboBox<String> jCombo_Mesa;
    public javax.swing.JComboBox<String> jCombo_Postre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    public javax.swing.JTextField jT_CantidadAcompañantes;
    public javax.swing.JTextField jT_CantidadBebida;
    public javax.swing.JTextField jT_CantidadCarta;
    public javax.swing.JTextField jT_CantidadPostre;
    public javax.swing.JTextField jT_Factura;
    public javax.swing.JTextField jT_Fecha;
    public javax.swing.JTextField jT_IdMesero;
    public javax.swing.JTable jTable_Acompañantes;
    public javax.swing.JTable jTable_Bebidas;
    public javax.swing.JTable jTable_Carta;
    public javax.swing.JTable jTable_Cuenta;
    public javax.swing.JTable jTable_Empleado;
    public javax.swing.JTable jTable_Postres;
    // End of variables declaration//GEN-END:variables
}