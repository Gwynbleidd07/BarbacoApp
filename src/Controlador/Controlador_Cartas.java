/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Cartas;
import Modelo.CartasDAO;
import Vista.Carta;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés Lombo
 */
public class Controlador_Cartas implements ActionListener {

    CartasDAO modeloCar = new CartasDAO();
    Carta vistaCar = new Carta();
    Menu vistaMe = new Menu();

    Controlador_Cartas(Carta vistaCarta, CartasDAO modeloCarta) {
        this.modeloCar = modeloCarta;
        this.vistaCar = vistaCarta;
        vistaCarta.btn_Carta1.addActionListener(this);
        vistaCarta.btn_Acompañante1.addActionListener(this);
        vistaCarta.btn_Bebida1.addActionListener(this);
        vistaCarta.btn_Postre1.addActionListener(this);
        vistaCarta.btn_Carta2.addActionListener(this);
        vistaCarta.btn_Acompañante2.addActionListener(this);
        vistaCarta.btn_Bebida2.addActionListener(this);
        vistaCarta.btn_Postre2.addActionListener(this);
        vistaCarta.btn_Volver1.addActionListener(this);
        vistaCarta.jTable_Carta1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaCar.jTable_Carta1.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaCarta.jTextField_Codigo.setEditable(false);
                    vistaCarta.jTextField_Codigo.setText(String.valueOf(vistaCarta.jTable_Carta1.getValueAt(seleccionado, 0)));
                    vistaCarta.jTextField_Nombre.setText(String.valueOf(vistaCarta.jTable_Carta1.getValueAt(seleccionado, 1)));
                    vistaCarta.jTextArea_Descripcion.setText(String.valueOf(vistaCarta.jTable_Carta1.getValueAt(seleccionado, 2)));
                    String precioString = String.valueOf(vistaCarta.jTable_Carta1.getValueAt(seleccionado, 3));
                    String precioNumerico = precioString.replaceAll("[^\\d]", "");
                    vistaCarta.jTextField_Precio.setText(precioNumerico);
                }
            }
        });
        vistaCarta.jTable_Acompañante1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaCar.jTable_Acompañante1.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    limpiarEntrada();
                    vistaCarta.jTextField_Codigo.setEditable(false);
                    vistaCarta.jTextField_Codigo.setText(String.valueOf(vistaCarta.jTable_Acompañante1.getValueAt(seleccionado, 0)));
                    vistaCarta.jTextField_Nombre.setText(String.valueOf(vistaCarta.jTable_Acompañante1.getValueAt(seleccionado, 1)));
                    String precioString = String.valueOf(vistaCarta.jTable_Acompañante1.getValueAt(seleccionado, 2));
                    String precioNumerico = precioString.replaceAll("[^\\d]", "");
                    vistaCarta.jTextField_Precio.setText(precioNumerico);
                }
            }
        });
        vistaCarta.jTable_Bebida1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaCar.jTable_Bebida1.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    limpiarEntrada();
                    vistaCarta.jTextField_Codigo.setEditable(false);
                    vistaCarta.jTextField_Codigo.setText(String.valueOf(vistaCarta.jTable_Bebida1.getValueAt(seleccionado, 0)));
                    vistaCarta.jTextField_Nombre.setText(String.valueOf(vistaCarta.jTable_Bebida1.getValueAt(seleccionado, 1)));
                    String precioString = String.valueOf(vistaCarta.jTable_Bebida1.getValueAt(seleccionado, 2));
                    String precioNumerico = precioString.replaceAll("[^\\d]", "");
                    vistaCarta.jTextField_Precio.setText(precioNumerico);
                }
            }
        });
        vistaCarta.jTable_Postre1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaCar.jTable_Postre1.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    limpiarEntrada();
                    vistaCarta.jTextField_Codigo.setEditable(false);
                    vistaCarta.jTextField_Codigo.setText(String.valueOf(vistaCarta.jTable_Postre1.getValueAt(seleccionado, 0)));
                    vistaCarta.jTextField_Nombre.setText(String.valueOf(vistaCarta.jTable_Postre1.getValueAt(seleccionado, 1)));
                    String precioString = String.valueOf(vistaCarta.jTable_Postre1.getValueAt(seleccionado, 2));
                    String precioNumerico = precioString.replaceAll("[^\\d]", "");
                    vistaCarta.jTextField_Precio.setText(precioNumerico);
                }
            }
        });
        cargarTablaCarta(vistaCar.jTable_Carta1);
        cargarTablaAcompañante(vistaCar.jTable_Acompañante1);
        cargarTablaBebida(vistaCar.jTable_Bebida1);
        cargarTablaPostre(vistaCar.jTable_Postre1);
    }

    private void cargarTablaCarta(JTable jTable) {
        String[] titulos = {"Codigo", "Nombre", "Descripcion", "Cantidad"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[4];
        jTable.setModel(modelotabla);
        int registros = modeloCar.listaDeProteina().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloCar.listaDeProteina().get(i).getCodigo();
            registro[1] = modeloCar.listaDeProteina().get(i).getNombre();
            registro[2] = modeloCar.listaDeProteina().get(i).getDescripcion();
            registro[3] = formato.format(modeloCar.listaDeProteina().get(i).getPrecio());
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
        int registros = modeloCar.listaDeAcompañante().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloCar.listaDeAcompañante().get(i).getCodigo();
            registro[1] = modeloCar.listaDeAcompañante().get(i).getNombre();
            registro[2] = formato.format(modeloCar.listaDeAcompañante().get(i).getPrecio());
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
        int registros = modeloCar.listaDeBebida().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloCar.listaDeBebida().get(i).getCodigo();
            registro[1] = modeloCar.listaDeBebida().get(i).getNombre();
            registro[2] = formato.format(modeloCar.listaDeBebida().get(i).getPrecio());
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
        int registros = modeloCar.listaDePostre().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloCar.listaDePostre().get(i).getCodigo();
            registro[1] = modeloCar.listaDePostre().get(i).getNombre();
            registro[2] = formato.format(modeloCar.listaDePostre().get(i).getPrecio());
            modelotabla.addRow(registro);
        }
        jTable.setModel(modelotabla);
    }

    public boolean validarCodigo() {
        boolean existe = false;
        int tamaño = modeloCar.listaCartas().size();
        for (int i = 0; i < tamaño; i++) {
            String Codigo = modeloCar.listaCartas().get(i).getCodigo();
            if (vistaCar.jTextField_Codigo.getText().equals(Codigo)) {
                existe = true;
                i = tamaño;
                JOptionPane.showMessageDialog(null, "Ya existe una cargo con datos similares");
            }
        }
        return existe;
    }

    public boolean Vacio() {
        boolean vacio = false;
        if (vistaCar.jTextField_Codigo.getText().length() == 0 || vistaCar.jTextField_Nombre.getText().length() == 0 || vistaCar.jTextArea_Descripcion.getText().length() == 0
                || vistaCar.jTextField_Precio.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    public boolean Vacio1() {
        boolean vacio = false;
        if (vistaCar.jTextField_Codigo.getText().length() == 0 || vistaCar.jTextField_Nombre.getText().length() == 0
                || vistaCar.jTextField_Precio.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    public void limpiarEntrada() {
        vistaCar.jTextField_Codigo.setText(null);
        vistaCar.jTextField_Nombre.setText(null);
        vistaCar.jTextArea_Descripcion.setText(null);
        vistaCar.jTextField_Precio.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCar.btn_Carta1) {
            String Codigo = vistaCar.jTextField_Codigo.getText();
            String Nombre = vistaCar.jTextField_Nombre.getText();
            String Descripcion = vistaCar.jTextArea_Descripcion.getText();
            int Precio = Integer.parseInt(vistaCar.jTextField_Precio.getText());
            if (Vacio() == false) {
                Cartas micarta = new Cartas(Codigo, Nombre, Descripcion, Precio);
                modeloCar.registrarProteina(micarta);
                limpiarEntrada();
                cargarTablaCarta(vistaCar.jTable_Carta1);
            }
        }
        if (e.getSource() == vistaCar.btn_Acompañante1) {
            String Codigo = vistaCar.jTextField_Codigo.getText();
            String Nombre = vistaCar.jTextField_Nombre.getText();
            int Precio = Integer.parseInt(vistaCar.jTextField_Precio.getText());
            if (Vacio() == false) {
                Cartas micarta = new Cartas(Codigo, Nombre, Precio);
                modeloCar.registrarAcompañante(micarta);
                limpiarEntrada();
                cargarTablaAcompañante(vistaCar.jTable_Acompañante1);
            }
        }
        if (e.getSource() == vistaCar.btn_Bebida1) {
            String Codigo = vistaCar.jTextField_Codigo.getText();
            String Nombre = vistaCar.jTextField_Nombre.getText();
            int Precio = Integer.parseInt(vistaCar.jTextField_Precio.getText());
            if (Vacio() == false) {
                Cartas micarta = new Cartas(Codigo, Nombre, Precio);
                modeloCar.registrarBebida(micarta);
                limpiarEntrada();
                cargarTablaAcompañante(vistaCar.jTable_Bebida1);
            }
        }
        if (e.getSource() == vistaCar.btn_Postre1) {
            String Codigo = vistaCar.jTextField_Codigo.getText();
            String Nombre = vistaCar.jTextField_Nombre.getText();
            int Precio = Integer.parseInt(vistaCar.jTextField_Precio.getText());
            if (Vacio() == false) {
                Cartas micarta = new Cartas(Codigo, Nombre, Precio);
                modeloCar.registrarPostre(micarta);
                limpiarEntrada();
                cargarTablaAcompañante(vistaCar.jTable_Postre1);
            }
        }
        if (e.getSource() == vistaCar.btn_Carta2) {
            String Nombre = vistaCar.jTextField_Nombre.getText();
            String Descripcion = vistaCar.jTextArea_Descripcion.getText();
            int Precio = Integer.parseInt(vistaCar.jTextField_Precio.getText());
            String Codigo = vistaCar.jTextField_Codigo.getText();
            if (Vacio1() == false) {
                Cartas micarta = new Cartas(Codigo, Nombre, Descripcion, Precio);
                if (modeloCar.actualizarProteina(micarta) == true) {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente \n los datos de la proteina");
                    limpiarEntrada();
                    cargarTablaCarta(vistaCar.jTable_Carta1);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido actualizar \n los datos de la proteina");
                }
            }
        }
        if (e.getSource() == vistaCar.btn_Acompañante2) {
            String Nombre = vistaCar.jTextField_Nombre.getText();
            int Precio = Integer.parseInt(vistaCar.jTextField_Precio.getText());
            String Codigo = vistaCar.jTextField_Codigo.getText();
            if (Vacio1() == false) {
                Cartas micarta = new Cartas(Codigo, Nombre, Precio);
                if (modeloCar.actualizarAcompañante(micarta) == true) {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente \n los datos del acompañante");
                    limpiarEntrada();
                    cargarTablaAcompañante(vistaCar.jTable_Acompañante1);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido actualizar \n los datos del acompañante");
                }
            }
        }
        if (e.getSource() == vistaCar.btn_Bebida2) {
            String Nombre = vistaCar.jTextField_Nombre.getText();
            int Precio = Integer.parseInt(vistaCar.jTextField_Precio.getText());
            String Codigo = vistaCar.jTextField_Codigo.getText();
            if (Vacio1() == false) {
                Cartas micarta = new Cartas(Codigo, Nombre, Precio);
                if (modeloCar.actualizarBebida(micarta) == true) {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente \n los datos de la Bebida");
                    limpiarEntrada();
                    cargarTablaBebida(vistaCar.jTable_Bebida1);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido actualizar \n los datos de la Bebida");
                }
            }
        }
        if (e.getSource() == vistaCar.btn_Postre2) {
            String Nombre = vistaCar.jTextField_Nombre.getText();
            int Precio = Integer.parseInt(vistaCar.jTextField_Precio.getText());
            String Codigo = vistaCar.jTextField_Codigo.getText();
            if (Vacio1() == false) {
                Cartas micarta = new Cartas(Codigo, Nombre, Precio);
                if (modeloCar.actualizarPostre(micarta) == true) {
                    JOptionPane.showMessageDialog(null, "Se ha actualizado correctamente \n los datos del Postre");
                    limpiarEntrada();
                    cargarTablaPostre(vistaCar.jTable_Postre1);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha podido actualizar \n los datos del Postre");
                }
            }
        }
        if (e.getSource() == vistaCar.btn_Volver1) {
            Controlador_Menu controlador = new Controlador_Menu(vistaMe);
            vistaCar.setVisible(false);
            vistaMe.setVisible(true);
            vistaMe.setLocationRelativeTo(null);
        }
    }
}
