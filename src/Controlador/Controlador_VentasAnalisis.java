/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.VentasDAO;
import Modelo.Ventas_Analisis;
import Modelo.Ventas_AnalisisDAO;
import Vista.Venta;
import Vista.VentasAnalisis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés Lombo
 */
public class Controlador_VentasAnalisis implements ActionListener {

    Ventas_AnalisisDAO modeloVen = new Ventas_AnalisisDAO();
    VentasAnalisis vistaVen = new VentasAnalisis();
    Venta vistaVent = new Venta();
    VentasDAO modeloVent = new VentasDAO();

    Controlador_VentasAnalisis(VentasAnalisis vistaVenta, Ventas_AnalisisDAO modeloVentas) {
        this.modeloVen = modeloVentas;
        this.vistaVen = vistaVenta;
        vistaVen.btn_Buscar.addActionListener(this);
        vistaVen.btn_Volver.addActionListener(this);
        cargarTablaCarta(vistaVenta.jTable_Carta);
        cargarTablaAcompañante(vistaVenta.jTable_Acompañantes);
        cargarTablaBebida(vistaVenta.jTable_Bebidas);
        cargarTablaPostre(vistaVenta.jTable_Postres);
        cargarTablaTotal(vistaVenta.jTable_Venta);
    }

    private void cargarTablaCarta(JTable jTable_Carta) {
        String[] titulos = {"Nombre", "Vendidos"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[2];
        jTable_Carta.setModel(modelotabla);
        int registros = modeloVen.listaDeCartas().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = String.valueOf(modeloVen.listaDeCartas().get(i).getNombre());
            registro[1] = String.valueOf(modeloVen.listaDeCartas().get(i).getVendido());
            modelotabla.addRow(registro);
        }
        jTable_Carta.setModel(modelotabla);
    }
    
    private void cargarTablaAcompañante(JTable jTable_Acompañantes) {
        String[] titulos = {"Nombre", "Vendidos"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[2];
        jTable_Acompañantes.setModel(modelotabla);
        int registros = modeloVen.listaDeAcompañantes().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = String.valueOf(modeloVen.listaDeAcompañantes().get(i).getNombre());
            registro[1] = String.valueOf(modeloVen.listaDeAcompañantes().get(i).getVendido());
            modelotabla.addRow(registro);
        }
        jTable_Acompañantes.setModel(modelotabla);
    }

    private void cargarTablaBebida(JTable jTable_Bebidas) {
        String[] titulos = {"Nombre", "Vendidos"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[2];
        jTable_Bebidas.setModel(modelotabla);
        int registros = modeloVen.listaDeBebidas().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = String.valueOf(modeloVen.listaDeBebidas().get(i).getNombre());
            registro[1] = String.valueOf(modeloVen.listaDeBebidas().get(i).getVendido());
            modelotabla.addRow(registro);
        }
        jTable_Bebidas.setModel(modelotabla);
    }

    private void cargarTablaPostre(JTable jTable_Postres) {
        String[] titulos = {"Nombre", "Vendidos"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[2];
        jTable_Postres.setModel(modelotabla);
        int registros = modeloVen.listaDePostres().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = String.valueOf(modeloVen.listaDePostres().get(i).getNombre());
            registro[1] = String.valueOf(modeloVen.listaDePostres().get(i).getVendido());
            modelotabla.addRow(registro);
        }
        jTable_Postres.setModel(modelotabla);
    }

    private void cargarTablaTotal(JTable jTable_Venta) {
        String[] titulos = {"Nombre"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[1];
        jTable_Venta.setModel(modelotabla);
        int registros = modeloVen.listaDeTotal().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = formato.format(modeloVen.listaDeTotal().get(i).getValor());
            modelotabla.addRow(registro);
        }
        jTable_Venta.setModel(modelotabla);
    }

    private void busquedaCarta(String busqueda, String busqueda1, JTable jTable_Carta) {
        ArrayList<Ventas_Analisis> pedidos = new ArrayList<>();
        pedidos = modeloVen.buscarCarta(busqueda, busqueda1);
        if (pedidos.size() != 0) {
            String[] titulos = {"Nombre", "Vendidos"};
            String[] registro = new String[2];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_Carta.setModel(modeltabla);
            int registros = pedidos.size();
            for (int i = 0; i < registros; i++) {
                registro[0] = pedidos.get(i).getNombre();
                registro[1] = String.valueOf(pedidos.get(i).getVendido());
                modeltabla.addRow(registro);
            }
            jTable_Carta.setModel(modeltabla);
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos registrados con el dato ingresado");
        }
    }
    
    private void busquedaAcompañante(String busqueda, String busqueda1, JTable jTable_Acompañante) {
        ArrayList<Ventas_Analisis> pedidos = new ArrayList<>();
        pedidos = modeloVen.buscarAcompañante(busqueda, busqueda1);
        if (pedidos.size() != 0) {
            String[] titulos = {"Nombre", "Vendidos"};
            String[] registro = new String[2];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_Acompañante.setModel(modeltabla);
            int registros = pedidos.size();
            for (int i = 0; i < registros; i++) {
                registro[0] = pedidos.get(i).getNombre();
                registro[1] = String.valueOf(pedidos.get(i).getVendido());
                modeltabla.addRow(registro);
            }
            jTable_Acompañante.setModel(modeltabla);
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos registrados con el dato ingresado");
        }
    }

    private void busquedaBebida(String busqueda, String busqueda1, JTable jTable_Bebida) {
        ArrayList<Ventas_Analisis> pedidos = new ArrayList<>();
        pedidos = modeloVen.buscarBebida(busqueda, busqueda1);
        if (pedidos.size() != 0) {
            String[] titulos = {"Nombre", "Vendidos"};
            String[] registro = new String[2];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_Bebida.setModel(modeltabla);
            int registros = pedidos.size();
            for (int i = 0; i < registros; i++) {
                registro[0] = pedidos.get(i).getNombre();
                registro[1] = String.valueOf(pedidos.get(i).getVendido());
                modeltabla.addRow(registro);
            }
            jTable_Bebida.setModel(modeltabla);
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos registrados con el dato ingresado");
        }
    }

    private void busquedaPostre(String busqueda, String busqueda1, JTable jTable_Postre) {
        ArrayList<Ventas_Analisis> pedidos = new ArrayList<>();
        pedidos = modeloVen.buscarPostre(busqueda, busqueda1);
        if (pedidos.size() != 0) {
            String[] titulos = {"Nombre", "Vendidos"};
            String[] registro = new String[2];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_Postre.setModel(modeltabla);
            int registros = pedidos.size();
            for (int i = 0; i < registros; i++) {
                registro[0] = pedidos.get(i).getNombre();
                registro[1] = String.valueOf(pedidos.get(i).getVendido());
                modeltabla.addRow(registro);
            }
            jTable_Postre.setModel(modeltabla);
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos registrados con el dato ingresado");
        }
    }

    private void busquedaTotal(String busqueda, String busqueda1, JTable jTable_Venta) {
        ArrayList<Ventas_Analisis> pedidos = new ArrayList<>();
        pedidos = modeloVen.buscarTotal(busqueda, busqueda1);
        if (pedidos.size() != 0) {
            String[] titulos = {"Valor"};
            String[] registro = new String[1];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_Venta.setModel(modeltabla);
            int registros = pedidos.size();
            DecimalFormat formato = new DecimalFormat("#,###");
            for (int i = 0; i < registros; i++) {
                registro[0] = formato.format(pedidos.get(i).getValor());
                modeltabla.addRow(registro);
            }
            jTable_Venta.setModel(modeltabla);
        } else {
            JOptionPane.showMessageDialog(null, "No hay pedidos registrados con el dato ingresado del total");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaVen.btn_Buscar) {
            busquedaCarta(((JTextField) vistaVen.jDate_Inicio.getDateEditor().getUiComponent()).getText(),
                    ((JTextField) vistaVen.jDate_Fin.getDateEditor().getUiComponent()).getText(), vistaVen.jTable_Carta);
            busquedaAcompañante(((JTextField) vistaVen.jDate_Inicio.getDateEditor().getUiComponent()).getText(),
                    ((JTextField) vistaVen.jDate_Fin.getDateEditor().getUiComponent()).getText(), vistaVen.jTable_Acompañantes);
            busquedaBebida(((JTextField) vistaVen.jDate_Inicio.getDateEditor().getUiComponent()).getText(),
                    ((JTextField) vistaVen.jDate_Fin.getDateEditor().getUiComponent()).getText(), vistaVen.jTable_Bebidas);
            busquedaPostre(((JTextField) vistaVen.jDate_Inicio.getDateEditor().getUiComponent()).getText(),
                    ((JTextField) vistaVen.jDate_Fin.getDateEditor().getUiComponent()).getText(), vistaVen.jTable_Postres);
            busquedaTotal(((JTextField) vistaVen.jDate_Inicio.getDateEditor().getUiComponent()).getText(),
                    ((JTextField) vistaVen.jDate_Fin.getDateEditor().getUiComponent()).getText(), vistaVen.jTable_Venta);
        }
        if (e.getSource() == vistaVen.btn_Volver) {
            Controlador_Ventas controlador = new Controlador_Ventas(vistaVent, modeloVent);
            vistaVen.setVisible(false);
            vistaVent.setVisible(true);
            vistaVent.setLocationRelativeTo(null);
        }
    }
}
