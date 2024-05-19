/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Inventarios;
import Modelo.InventariosDAO;
import Vista.Inventario;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés Lombo
 */
public class Controlador_Inventario implements ActionListener {

    InventariosDAO modeloInv = new InventariosDAO();
    Inventario vistaInv = new Inventario();
    Menu vistaMe = new Menu();

    Controlador_Inventario(Inventario vistaInventario, InventariosDAO modeloInventarios) {
        this.modeloInv = modeloInventarios;
        this.vistaInv = vistaInventario;
        vistaInventario.btn_Carta1.addActionListener(this);
        vistaInventario.btn_Acompañante1.addActionListener(this);
        vistaInventario.btn_Bebida1.addActionListener(this);
        vistaInventario.btn_Postre1.addActionListener(this);
        vistaInventario.btn_Carta2.addActionListener(this);
        vistaInventario.btn_Acompañante2.addActionListener(this);
        vistaInventario.btn_Bebida2.addActionListener(this);
        vistaInventario.btn_Postre2.addActionListener(this);
        vistaInventario.btn_Volver1.addActionListener(this);
        vistaInventario.jTable_Carta1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaInv.jTable_Carta1.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaInventario.jComboBox_Proveedor.setSelectedItem(String.valueOf(vistaInventario.jTable_Carta1.getValueAt(seleccionado, 0)));
                    vistaInventario.jTextField_Cantidad.setText(String.valueOf(vistaInventario.jTable_Carta1.getValueAt(seleccionado, 2)));
                }
            }
        });
        vistaInventario.jTable_Acompañante1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaInv.jTable_Acompañante1.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaInventario.jComboBox_Proveedor.setSelectedItem(String.valueOf(vistaInventario.jTable_Acompañante1.getValueAt(seleccionado, 0)));
                    vistaInventario.jTextField_Cantidad.setText(String.valueOf(vistaInventario.jTable_Acompañante1.getValueAt(seleccionado, 2)));
                }
            }
        });
        vistaInventario.jTable_Bebida1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaInv.jTable_Bebida1.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaInventario.jComboBox_Proveedor.setSelectedItem(String.valueOf(vistaInventario.jTable_Bebida1.getValueAt(seleccionado, 0)));
                    vistaInventario.jTextField_Cantidad.setText(String.valueOf(vistaInventario.jTable_Bebida1.getValueAt(seleccionado, 2)));
                }
            }
        });
        vistaInventario.jTable_Postre1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaInv.jTable_Postre1.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaInventario.jComboBox_Proveedor.setSelectedItem(String.valueOf(vistaInventario.jTable_Postre1.getValueAt(seleccionado, 0)));
                    vistaInventario.jTextField_Cantidad.setText(String.valueOf(vistaInventario.jTable_Postre1.getValueAt(seleccionado, 2)));
                }
            }
        });
        cargarTablaCarta(vistaInventario.jTable_Carta1);
        cargarTablaAcompañante(vistaInventario.jTable_Acompañante1);
        cargarTablaBebida(vistaInventario.jTable_Bebida1);
        cargarTablaPostre(vistaInventario.jTable_Postre1);
        cargarElemento(vistaInventario.jComboBox_Proveedor);
    }

    private void cargarTablaCarta(JTable jTable) {
        String[] titulos = {"Codigo", "Nombre", "Cantidad"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[3];
        jTable.setModel(modelotabla);
        int registros = modeloInv.listaDeCarta().size();
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloInv.listaDeCarta().get(i).getCodigo();
            registro[1] = modeloInv.listaDeCarta().get(i).getNombre();
            registro[2] = String.valueOf(modeloInv.listaDeCarta().get(i).getCantidad());
            modelotabla.addRow(registro);
        }
        jTable.setModel(modelotabla);
    }

    private void cargarTablaAcompañante(JTable jTable) {
        String[] titulos = {"Codigo", "Nombre", "Cantidad"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[3];
        jTable.setModel(modelotabla);
        int registros = modeloInv.listaDeAcompañante().size();
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloInv.listaDeAcompañante().get(i).getCodigo();
            registro[1] = modeloInv.listaDeAcompañante().get(i).getNombre();
            registro[2] = String.valueOf(modeloInv.listaDeAcompañante().get(i).getCantidad());
            modelotabla.addRow(registro);
        }
        jTable.setModel(modelotabla);
    }

    private void cargarTablaBebida(JTable jTable) {
        String[] titulos = {"Codigo", "Nombre", "Cantidad"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[3];
        jTable.setModel(modelotabla);
        int registros = modeloInv.listaDeBebida().size();
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloInv.listaDeBebida().get(i).getCodigo();
            registro[1] = modeloInv.listaDeBebida().get(i).getNombre();
            registro[2] = String.valueOf(modeloInv.listaDeBebida().get(i).getCantidad());
            modelotabla.addRow(registro);
        }
        jTable.setModel(modelotabla);
    }

    private void cargarTablaPostre(JTable jTable) {
        String[] titulos = {"Codigo", "Nombre", "Cantidad"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[3];
        jTable.setModel(modelotabla);
        int registros = modeloInv.listaDePostre().size();
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloInv.listaDePostre().get(i).getCodigo();
            registro[1] = modeloInv.listaDePostre().get(i).getNombre();
            registro[2] = String.valueOf(modeloInv.listaDePostre().get(i).getCantidad());
            modelotabla.addRow(registro);
        }
        jTable.setModel(modelotabla);
    }

    public boolean Vacio() {
        boolean vacio = false;
        if (vistaInv.jComboBox_Proveedor.getSelectedItem().equals("Seleccione un elemento") || vistaInv.jTextField_Cantidad.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    public void limpiarEntrada() {
        vistaInv.jComboBox_Proveedor.setSelectedItem(null);
        vistaInv.jTextField_Cantidad.setText(null);
    }

    private void cargarElemento(JComboBox<String> cargarElemento) {
        DefaultComboBoxModel modeloE = new DefaultComboBoxModel();
        cargarElemento.setModel(modeloE);
        int tamaño = this.modeloInv.listaDeCodigoElemento().size();
        modeloE.addElement("Seleccione un elemento");
        for (int i = 0; i < tamaño; i++) {
            modeloE.addElement(modeloInv.listaDeCodigoElemento().get(i).getCodigo());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaInv.btn_Carta1) {
            String Codigo = (String) vistaInv.jComboBox_Proveedor.getSelectedItem();
            int Cantidad = Integer.parseInt(vistaInv.jTextField_Cantidad.getText());
            if (Vacio() == false) {
                Inventarios miinvetario = new Inventarios(Codigo, Cantidad);
                modeloInv.registrarCarta(miinvetario);
                limpiarEntrada();
                cargarTablaCarta(vistaInv.jTable_Carta1);
            }
        }
        if (e.getSource() == vistaInv.btn_Acompañante1) {
            String Codigo = (String) vistaInv.jComboBox_Proveedor.getSelectedItem();
            int Cantidad = Integer.parseInt(vistaInv.jTextField_Cantidad.getText());
            if (Vacio() == false) {
                Inventarios miinvetario = new Inventarios(Codigo, Cantidad);
                modeloInv.registrarAcompañante(miinvetario);
                limpiarEntrada();
                cargarTablaAcompañante(vistaInv.jTable_Acompañante1);
            }
        }
        if (e.getSource() == vistaInv.btn_Bebida1) {
            String Codigo = (String) vistaInv.jComboBox_Proveedor.getSelectedItem();
            int Cantidad = Integer.parseInt(vistaInv.jTextField_Cantidad.getText());
            if (Vacio() == false) {
                Inventarios miinvetario = new Inventarios(Codigo, Cantidad);
                modeloInv.registrarBebida(miinvetario);
                limpiarEntrada();
                cargarTablaBebida(vistaInv.jTable_Bebida1);
            }
        }
        if (e.getSource() == vistaInv.btn_Postre1) {
            String Codigo = (String) vistaInv.jComboBox_Proveedor.getSelectedItem();
            int Cantidad = Integer.parseInt(vistaInv.jTextField_Cantidad.getText());
            if (Vacio() == false) {
                Inventarios miinvetario = new Inventarios(Codigo, Cantidad);
                modeloInv.registrarPostre(miinvetario);
                limpiarEntrada();
                cargarTablaPostre(vistaInv.jTable_Postre1);
            }
        }
        if (e.getSource() == vistaInv.btn_Carta2) {
            int Cantidad = Integer.parseInt(vistaInv.jTextField_Cantidad.getText());
            String Codigo = (String) vistaInv.jComboBox_Proveedor.getSelectedItem();
            if (Vacio() == false) {
                Inventarios miinventario = new Inventarios(Codigo, Cantidad);
                if (modeloInv.actualizarCarta(miinventario) == true) {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente \n los datos de la carta");
                    limpiarEntrada();
                    cargarTablaCarta(vistaInv.jTable_Carta1);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido actualizar \n los datos de la carta");

                }
            }
        }
        if (e.getSource() == vistaInv.btn_Acompañante2) {
            int Cantidad = Integer.parseInt(vistaInv.jTextField_Cantidad.getText());
            String Codigo = (String) vistaInv.jComboBox_Proveedor.getSelectedItem();
            if (Vacio() == false) {
                Inventarios miinventario = new Inventarios(Codigo, Cantidad);
                if (modeloInv.actualizarAcompañante(miinventario) == true) {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente \n los datos del Acompañante");
                    limpiarEntrada();
                    cargarTablaAcompañante(vistaInv.jTable_Acompañante1);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido actualizar \n los datos del Acompañante");

                }
            }
        }
        if (e.getSource() == vistaInv.btn_Bebida2) {
            int Cantidad = Integer.parseInt(vistaInv.jTextField_Cantidad.getText());
            String Codigo = (String) vistaInv.jComboBox_Proveedor.getSelectedItem();
            if (Vacio() == false) {
                Inventarios miinventario = new Inventarios(Codigo, Cantidad);
                if (modeloInv.actualizarBebida(miinventario) == true) {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente \n los datos de la Bebida");
                    limpiarEntrada();
                    cargarTablaBebida(vistaInv.jTable_Bebida1);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido actualizar \n los datos de la Bebida");

                }
            }
        }
        if (e.getSource() == vistaInv.btn_Postre2) {
            int Cantidad = Integer.parseInt(vistaInv.jTextField_Cantidad.getText());
            String Codigo = (String) vistaInv.jComboBox_Proveedor.getSelectedItem();
            if (Vacio() == false) {
                Inventarios miinventario = new Inventarios(Codigo, Cantidad);
                if (modeloInv.actualizarPostre(miinventario) == true) {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente \n los datos del Postre");
                    limpiarEntrada();
                    cargarTablaPostre(vistaInv.jTable_Postre1);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido actualizar \n los datos del Postre");

                }
            }
        }
        if (e.getSource() == vistaInv.btn_Volver1) {
            Controlador_Menu controlador = new Controlador_Menu(vistaMe);
            vistaInv.setVisible(false);
            vistaMe.setVisible(true);
            vistaMe.setLocationRelativeTo(null);
        }
    }
}
