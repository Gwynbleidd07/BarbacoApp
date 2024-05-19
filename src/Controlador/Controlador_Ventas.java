/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Acompañantes;
import Modelo.Bebidas;
import Modelo.InventariosDAO;
import Modelo.Postres;
import Modelo.Ventas;
import Modelo.VentasDAO;
import Modelo.Ventas_AnalisisDAO;
import Vista.Menu;
import Vista.Venta;
import Vista.VentasAnalisis;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés Lombo
 */
public class Controlador_Ventas implements ActionListener {

    VentasDAO modeloVen = new VentasDAO();
    Venta vistaVen = new Venta();
    Menu vistaMe = new Menu();
    VentasAnalisis vistaVent = new VentasAnalisis();
    Ventas_AnalisisDAO modeloVent = new Ventas_AnalisisDAO();
    InventariosDAO modeloInv = new InventariosDAO();

    Controlador_Ventas(Venta vistaVenta, VentasDAO modeloVentas) {
        this.modeloVen = modeloVentas;
        this.vistaVen = vistaVenta;
        vistaVenta.btn_CargarAcompañante.addActionListener(this);
        vistaVenta.btn_CargarBebida.addActionListener(this);
        vistaVenta.btn_CargarCarta.addActionListener(this);
        vistaVenta.btn_CargarPedido.addActionListener(this);
        vistaVenta.btn_CargarPostre.addActionListener(this);
        vistaVenta.btn_Limpiar.addActionListener(this);
        vistaVenta.btn_Pagar.addActionListener(this);
        vistaVenta.btn_Volver.addActionListener(this);
        vistaVenta.btn_Analisis.addActionListener(this);
        vistaVenta.jT_Fecha.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                busquedaFacturaFecha(vistaVen.jT_Fecha.getText(), vistaVen.jTable_Cuenta);
            }

            private void busquedaFacturaFecha(String busqueda, JTable jTable_Cuenta) {
                ArrayList<Ventas> ventas = new ArrayList<>();
                ventas = modeloVen.buscarFecha(busqueda);
                if (ventas.size() != 0) {
                    String[] titulos = {"N° Factura", "Fecha", "Mesa", "Mesero", "Valor a pagar"};
                    String[] registro = new String[5];
                    DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
                    jTable_Cuenta.setModel(modeltabla);
                    int registros = ventas.size();
                    DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
                    for (int i = 0; i < registros; i++) {
                        registro[0] = String.valueOf(ventas.get(i).getFactura());
                        registro[1] = ventas.get(i).getFecha();
                        registro[2] = ventas.get(i).getMesa();
                        registro[3] = ventas.get(i).getMesero();
                        registro[4] = formato.format(ventas.get(i).getValorCuenta());
                        modeltabla.addRow(registro);
                    }
                    jTable_Cuenta.setModel(modeltabla);
                } else {
                    DefaultTableModel modelVacia = new DefaultTableModel();
                    jTable_Cuenta.setModel(modelVacia);
                }
            }
        });
        vistaVenta.jT_Factura.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                busquedaFactura(vistaVen.jT_Factura.getText(), vistaVen.jTable_Cuenta);
                busquedaFacturaCarta(vistaVen.jT_Factura.getText(), vistaVen.jTable_Carta);
                busquedaFacturaAcompañante(vistaVen.jT_Factura.getText(), vistaVen.jTable_Acompañantes);
                busquedaFacturaBebida(vistaVen.jT_Factura.getText(), vistaVen.jTable_Bebidas);
                busquedaFacturaPostre(vistaVen.jT_Factura.getText(), vistaVen.jTable_Postres);
            }

            private void busquedaFactura(String busqueda, JTable jTable_Cuenta) {
                ArrayList<Ventas> ventas = new ArrayList<>();
                ventas = modeloVen.buscarFactura(busqueda);
                if (ventas.size() != 0) {
                    String[] titulos = {"N° Factura", "Fecha", "Mesa", "Mesero", "Valor a pagar"};
                    String[] registro = new String[5];
                    DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
                    jTable_Cuenta.setModel(modeltabla);
                    int registros = ventas.size();
                    DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
                    for (int i = 0; i < registros; i++) {
                        registro[0] = String.valueOf(ventas.get(i).getFactura());
                        registro[1] = ventas.get(i).getFecha();
                        registro[2] = ventas.get(i).getMesa();
                        registro[3] = ventas.get(i).getMesero();
                        registro[4] = formato.format(ventas.get(i).getValorCuenta());
                        modeltabla.addRow(registro);
                    }
                    jTable_Cuenta.setModel(modeltabla);
                } else {
                    DefaultTableModel modelVacia = new DefaultTableModel();
                    jTable_Cuenta.setModel(modelVacia);
                }
            }

            private void busquedaFacturaCarta(String busqueda, JTable jTable_Carta) {
                ArrayList<Ventas> cartas = new ArrayList<>();
                cartas = modeloVen.buscarCarta1(busqueda);
                if (cartas.size() != 0) {
                    String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Valor cuenta"};
                    String[] registro = new String[5];
                    DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
                    jTable_Carta.setModel(modeltabla);
                    int registros = cartas.size();
                    DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
                    for (int i = 0; i < registros; i++) {
                        registro[0] = String.valueOf(cartas.get(i).getFactura());
                        registro[1] = cartas.get(i).getCarta();
                        registro[2] = String.valueOf(cartas.get(i).getCantidadCarta());
                        registro[3] = formato.format(cartas.get(i).getPrecio());
                        registro[4] = formato.format(cartas.get(i).getValorCuenta());
                        modeltabla.addRow(registro);
                    }
                    jTable_Carta.setModel(modeltabla);
                } else {
                    DefaultTableModel modelVacia = new DefaultTableModel();
                    jTable_Carta.setModel(modelVacia);
                }
            }

            private void busquedaFacturaAcompañante(String busqueda, JTable jTable_Acompañantes) {
                ArrayList<Ventas> acompañantes = new ArrayList<>();
                acompañantes = modeloVen.buscarAcompañantes1(busqueda);
                if (acompañantes.size() != 0) {
                    String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Total"};
                    String[] registro = new String[5];
                    DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
                    jTable_Acompañantes.setModel(modeltabla);
                    int registros = acompañantes.size();
                    DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
                    for (int i = 0; i < registros; i++) {
                        registro[0] = String.valueOf(acompañantes.get(i).getFactura());
                        registro[1] = acompañantes.get(i).getAcompañantes();
                        registro[2] = String.valueOf(acompañantes.get(i).getCantidadAcompañantes());
                        registro[3] = formato.format(acompañantes.get(i).getPrecio());
                        registro[4] = formato.format(acompañantes.get(i).getValorCuenta());
                        modeltabla.addRow(registro);
                    }
                    jTable_Acompañantes.setModel(modeltabla);
                } else {
                    DefaultTableModel modelVacia = new DefaultTableModel();
                    jTable_Acompañantes.setModel(modelVacia);
                }
            }

            private void busquedaFacturaBebida(String busqueda, JTable jTable_Bebidas) {
                ArrayList<Ventas> bebidas = new ArrayList<>();
                bebidas = modeloVen.buscarBebidas1(busqueda);
                if (bebidas.size() != 0) {
                    String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Total"};
                    String[] registro = new String[5];
                    DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
                    jTable_Bebidas.setModel(modeltabla);
                    int registros = bebidas.size();
                    DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
                    for (int i = 0; i < registros; i++) {
                        registro[0] = String.valueOf(bebidas.get(i).getFactura());
                        registro[1] = bebidas.get(i).getBebidas();
                        registro[2] = String.valueOf(bebidas.get(i).getCantidadBebidas());
                        registro[3] = formato.format(bebidas.get(i).getPrecio());
                        registro[4] = formato.format(bebidas.get(i).getValorCuenta());
                        modeltabla.addRow(registro);
                    }
                    jTable_Bebidas.setModel(modeltabla);
                } else {
                    DefaultTableModel modelVacia = new DefaultTableModel();
                    jTable_Bebidas.setModel(modelVacia);
                }
            }

            private void busquedaFacturaPostre(String busqueda, JTable jTable_Postres) {
                ArrayList<Ventas> postres = new ArrayList<>();
                postres = modeloVen.buscarPostres1(busqueda);
                if (postres.size() != 0) {
                    String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Total"};
                    String[] registro = new String[5];
                    DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
                    jTable_Postres.setModel(modeltabla);
                    int registros = postres.size();
                    DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
                    for (int i = 0; i < registros; i++) {
                        registro[0] = String.valueOf(postres.get(i).getFactura());
                        registro[1] = postres.get(i).getPostre();
                        registro[2] = String.valueOf(postres.get(i).getCantidadPostre());
                        registro[3] = formato.format(postres.get(i).getPrecio());
                        registro[4] = formato.format(postres.get(i).getValorCuenta());
                        modeltabla.addRow(registro);
                    }
                    jTable_Postres.setModel(modeltabla);
                } else {
                    DefaultTableModel modelVacia = new DefaultTableModel();
                    jTable_Postres.setModel(modelVacia);
                }
            }
        });
        vistaVen.jTable_Carta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaVen.jTable_Carta.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaVenta.jT_Factura.setText(String.valueOf(vistaVenta.jTable_Carta.getValueAt(seleccionado, 0)));
                    busquedaFactura(vistaVen.jT_Factura.getText(), vistaVen.jTable_Cuenta);
                    busquedaFacturaCarta(vistaVen.jT_Factura.getText(), vistaVen.jTable_Carta);
                    busquedaFacturaAcompañante(vistaVen.jT_Factura.getText(), vistaVen.jTable_Acompañantes);
                    busquedaFacturaBebida(vistaVen.jT_Factura.getText(), vistaVen.jTable_Bebidas);
                    busquedaFacturaPostre(vistaVen.jT_Factura.getText(), vistaVen.jTable_Postres);
                }
            }
        });
        vistaVen.jTable_Acompañantes.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaVen.jTable_Acompañantes.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaVenta.jT_Factura.setText(String.valueOf(vistaVenta.jTable_Acompañantes.getValueAt(seleccionado, 0)));
                    busquedaFactura(vistaVen.jT_Factura.getText(), vistaVen.jTable_Cuenta);
                    busquedaFacturaCarta(vistaVen.jT_Factura.getText(), vistaVen.jTable_Carta);
                    busquedaFacturaAcompañante(vistaVen.jT_Factura.getText(), vistaVen.jTable_Acompañantes);
                    busquedaFacturaBebida(vistaVen.jT_Factura.getText(), vistaVen.jTable_Bebidas);
                    busquedaFacturaPostre(vistaVen.jT_Factura.getText(), vistaVen.jTable_Postres);
                }
            }
        });
        vistaVen.jTable_Bebidas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaVen.jTable_Bebidas.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaVenta.jT_Factura.setText(String.valueOf(vistaVenta.jTable_Bebidas.getValueAt(seleccionado, 0)));
                    busquedaFactura(vistaVen.jT_Factura.getText(), vistaVen.jTable_Cuenta);
                    busquedaFacturaCarta(vistaVen.jT_Factura.getText(), vistaVen.jTable_Carta);
                    busquedaFacturaAcompañante(vistaVen.jT_Factura.getText(), vistaVen.jTable_Acompañantes);
                    busquedaFacturaBebida(vistaVen.jT_Factura.getText(), vistaVen.jTable_Bebidas);
                    busquedaFacturaPostre(vistaVen.jT_Factura.getText(), vistaVen.jTable_Postres);
                }
            }
        });
        vistaVen.jTable_Postres.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaVen.jTable_Postres.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaVenta.jT_Factura.setText(String.valueOf(vistaVenta.jTable_Postres.getValueAt(seleccionado, 0)));
                    busquedaFactura(vistaVen.jT_Factura.getText(), vistaVen.jTable_Cuenta);
                    busquedaFacturaCarta(vistaVen.jT_Factura.getText(), vistaVen.jTable_Carta);
                    busquedaFacturaAcompañante(vistaVen.jT_Factura.getText(), vistaVen.jTable_Acompañantes);
                    busquedaFacturaBebida(vistaVen.jT_Factura.getText(), vistaVen.jTable_Bebidas);
                    busquedaFacturaPostre(vistaVen.jT_Factura.getText(), vistaVen.jTable_Postres);
                }
            }
        });
        vistaVen.jTable_Cuenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaVen.jTable_Cuenta.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaVenta.jT_Factura.setText(String.valueOf(vistaVenta.jTable_Cuenta.getValueAt(seleccionado, 0)));
                    busquedaFactura(vistaVen.jT_Factura.getText(), vistaVen.jTable_Cuenta);
                    busquedaFacturaCarta(vistaVen.jT_Factura.getText(), vistaVen.jTable_Carta);
                    busquedaFacturaAcompañante(vistaVen.jT_Factura.getText(), vistaVen.jTable_Acompañantes);
                    busquedaFacturaBebida(vistaVen.jT_Factura.getText(), vistaVen.jTable_Bebidas);
                    busquedaFacturaPostre(vistaVen.jT_Factura.getText(), vistaVen.jTable_Postres);
                }
            }
        });
        vistaVen.jTable_Empleado.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaVen.jTable_Empleado.rowAtPoint(e.getPoint());
                if (seleccionado > -1) {
                    vistaVenta.jT_IdMesero.setText(String.valueOf(vistaVenta.jTable_Empleado.getValueAt(seleccionado, 0)));
                }
            }
        });
        vistaVen.jT_Fecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validarYConvertirFecha();
            }

            private void validarYConvertirFecha() {
                String fechaIngresada = vistaVen.jT_Fecha.getText();
                SimpleDateFormat formatoEntrada = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat formatoSalida = new SimpleDateFormat("yyyy-MM-dd");

                try {
                    Date fecha = formatoEntrada.parse(fechaIngresada);
                    String fechaConvertida = formatoSalida.format(fecha);

                    // Actualizar el JTextField con la fecha convertida
                    vistaVen.jT_Fecha.setText(fechaConvertida);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto. Use dd-MM-yyyy", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cargarUltimoIdFactura(vistaVenta.jT_Factura);
        cargarMesa(vistaVenta.jCombo_Mesa);
        cargarCarta(vistaVenta.jCombo_Carta);
        cargarAcompañantes(vistaVenta.jCombo_Acompañantes);
        cargarBebidas(vistaVenta.jCombo_Bebida);
        cargarPostres(vistaVenta.jCombo_Postre);
        cargarTablaEmpleado(vistaVenta.jTable_Empleado);
//        cargarTablaCarta(vistaVenta.jTable_Carta);
//        cargarTablaAcompañantes(vistaVenta.jTable_Acompañantes);
//        cargarTablaBebidas(vistaVenta.jTable_Bebidas);
//        cargarTablaPostres(vistaVenta.jTable_Postres);
//        cargarTablaCuenta(vistaVenta.jTable_Cuenta);
        fechaSistema();
    }

    private void busquedaFactura(String busqueda, JTable jTable_Cuenta) {
        ArrayList<Ventas> ventas = new ArrayList<>();
        ventas = modeloVen.buscarFactura(busqueda);
        if (ventas.size() != 0) {
            String[] titulos = {"N° Factura", "Fecha", "Mesa", "Mesero", "Valor a pagar"};
            String[] registro = new String[5];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_Cuenta.setModel(modeltabla);
            int registros = ventas.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = String.valueOf(ventas.get(i).getFactura());
                registro[1] = ventas.get(i).getFecha();
                registro[2] = ventas.get(i).getMesa();
                registro[3] = ventas.get(i).getMesero();
                registro[4] = formato.format(ventas.get(i).getValorCuenta());
                modeltabla.addRow(registro);
            }
            jTable_Cuenta.setModel(modeltabla);
        } else {
            DefaultTableModel modelVacia = new DefaultTableModel();
            jTable_Cuenta.setModel(modelVacia);
        }
    }

    private void busquedaFacturaCarta(String busqueda, JTable jTable_Carta) {
        ArrayList<Ventas> cartas = new ArrayList<>();
        cartas = modeloVen.buscarCarta1(busqueda);
        if (cartas.size() != 0) {
            String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Valor cuenta"};
            String[] registro = new String[5];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_Carta.setModel(modeltabla);
            int registros = cartas.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = String.valueOf(cartas.get(i).getFactura());
                registro[1] = cartas.get(i).getCarta();
                registro[2] = String.valueOf(cartas.get(i).getCantidadCarta());
                registro[3] = formato.format(cartas.get(i).getPrecio());
                registro[4] = formato.format(cartas.get(i).getValorCuenta());
                modeltabla.addRow(registro);
            }
            jTable_Carta.setModel(modeltabla);
        } else {
            DefaultTableModel modelVacia = new DefaultTableModel();
            jTable_Carta.setModel(modelVacia);
        }
    }

    private void busquedaFacturaAcompañante(String busqueda, JTable jTable_Acompañantes) {
        ArrayList<Ventas> acompañantes = new ArrayList<>();
        acompañantes = modeloVen.buscarAcompañantes1(busqueda);
        if (acompañantes.size() != 0) {
            String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Total"};
            String[] registro = new String[5];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_Acompañantes.setModel(modeltabla);
            int registros = acompañantes.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = String.valueOf(acompañantes.get(i).getFactura());
                registro[1] = acompañantes.get(i).getAcompañantes();
                registro[2] = String.valueOf(acompañantes.get(i).getCantidadAcompañantes());
                registro[3] = formato.format(acompañantes.get(i).getPrecio());
                registro[4] = formato.format(acompañantes.get(i).getValorCuenta());
                modeltabla.addRow(registro);
            }
            jTable_Acompañantes.setModel(modeltabla);
        } else {
            DefaultTableModel modelVacia = new DefaultTableModel();
            jTable_Acompañantes.setModel(modelVacia);
        }
    }

    private void busquedaFacturaBebida(String busqueda, JTable jTable_Bebidas) {
        ArrayList<Ventas> bebidas = new ArrayList<>();
        bebidas = modeloVen.buscarBebidas1(busqueda);
        if (bebidas.size() != 0) {
            String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Total"};
            String[] registro = new String[5];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_Bebidas.setModel(modeltabla);
            int registros = bebidas.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = String.valueOf(bebidas.get(i).getFactura());
                registro[1] = bebidas.get(i).getBebidas();
                registro[2] = String.valueOf(bebidas.get(i).getCantidadBebidas());
                registro[3] = formato.format(bebidas.get(i).getPrecio());
                registro[4] = formato.format(bebidas.get(i).getValorCuenta());
                modeltabla.addRow(registro);
            }
            jTable_Bebidas.setModel(modeltabla);
        } else {
            DefaultTableModel modelVacia = new DefaultTableModel();
            jTable_Bebidas.setModel(modelVacia);
        }
    }

    private void busquedaFacturaPostre(String busqueda, JTable jTable_Postres) {
        ArrayList<Ventas> postres = new ArrayList<>();
        postres = modeloVen.buscarPostres1(busqueda);
        if (postres.size() != 0) {
            String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Total"};
            String[] registro = new String[5];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable_Postres.setModel(modeltabla);
            int registros = postres.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = String.valueOf(postres.get(i).getFactura());
                registro[1] = postres.get(i).getPostre();
                registro[2] = String.valueOf(postres.get(i).getCantidadPostre());
                registro[3] = formato.format(postres.get(i).getPrecio());
                registro[4] = formato.format(postres.get(i).getValorCuenta());
                modeltabla.addRow(registro);
            }
            jTable_Postres.setModel(modeltabla);
        } else {
            DefaultTableModel modelVacia = new DefaultTableModel();
            jTable_Postres.setModel(modelVacia);
        }
    }

    private void cargarMesa(JComboBox<String> cargarMesa) {
        DefaultComboBoxModel modeloE = new DefaultComboBoxModel();
        cargarMesa.setModel(modeloE);
        int tamaño = this.modeloVen.listaDeCodigoMesa().size();
        modeloE.addElement("Seleccione una mesa");
        for (int i = 0; i < tamaño; i++) {
            modeloE.addElement(modeloVen.listaDeCodigoMesa().get(i).getMesa());
        }
    }

    private void cargarCarta(JComboBox<String> cargarCarta) {
        DefaultComboBoxModel modeloE = new DefaultComboBoxModel();
        cargarCarta.setModel(modeloE);
        int tamaño = this.modeloVen.listaDeCodigoCarta().size();
        modeloE.addElement("Seleccione un plato");
        for (int i = 0; i < tamaño; i++) {
            modeloE.addElement(modeloVen.listaDeCodigoCarta().get(i).getCarta());
        }
    }

    private void cargarAcompañantes(JComboBox<String> cargarAcompañantes) {
        DefaultComboBoxModel modeloE = new DefaultComboBoxModel();
        cargarAcompañantes.setModel(modeloE);
        int tamaño = this.modeloVen.listaDeCodigoAcompañantes().size();
        modeloE.addElement("Seleccione un acompañante");
        for (int i = 0; i < tamaño; i++) {
            modeloE.addElement(modeloVen.listaDeCodigoAcompañantes().get(i).getAcompañantes());
        }
    }

    private void cargarBebidas(JComboBox<String> cargarBebida) {
        DefaultComboBoxModel modeloE = new DefaultComboBoxModel();
        cargarBebida.setModel(modeloE);
        int tamaño = this.modeloVen.listaDeCodigoBebidas().size();
        modeloE.addElement("Seleccione una bebida");
        for (int i = 0; i < tamaño; i++) {
            modeloE.addElement(modeloVen.listaDeCodigoBebidas().get(i).getBebidas());
        }
    }

    private void cargarPostres(JComboBox<String> CargarPostre) {
        DefaultComboBoxModel modeloE = new DefaultComboBoxModel();
        CargarPostre.setModel(modeloE);
        int tamaño = this.modeloVen.listaDeCodigoPostres().size();
        modeloE.addElement("Seleccione un postre");
        for (int i = 0; i < tamaño; i++) {
            modeloE.addElement(modeloVen.listaDeCodigoPostres().get(i).getPostre());
        }
    }

    private void cargarUltimoIdFactura(JTextField jT_Factura) {
        // Obtener el último ID registrado y sumarle uno
        int ultimoId = modeloVen.buscarUltimoId();

        // Mostrar el último ID + 1 en el JTextField
        jT_Factura.setText(String.valueOf(ultimoId));
    }

    private void cargarTablaEmpleado(JTable jTable_Empleado) {
        String[] titulos = {"Cedula", "Nombres"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[2];
        jTable_Empleado.setModel(modelotabla);
        int registros = modeloVen.listaDeEmpleados().size();
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloVen.listaDeEmpleados().get(i).getId();
            registro[1] = modeloVen.listaDeEmpleados().get(i).getNombre();
            modelotabla.addRow(registro);
        }
        jTable_Empleado.setModel(modelotabla);
    }

    private void cargarTablaCarta(JTable jTable_Carta) {
        String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Valor cuenta"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Carta.setModel(modelotabla);
        int registros = modeloVen.listaDeCarta().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = String.valueOf(modeloVen.listaDeCarta().get(i).getFactura());
            registro[1] = modeloVen.listaDeCarta().get(i).getCarta();
            registro[2] = String.valueOf(modeloVen.listaDeCarta().get(i).getCantidadCarta());
            registro[3] = formato.format(modeloVen.listaDeCarta().get(i).getPrecio());
            registro[4] = formato.format(modeloVen.listaDeCarta().get(i).getValorCuenta());
            modelotabla.addRow(registro);
        }
        jTable_Carta.setModel(modelotabla);
    }

    private void cargarTablaAcompañantes(JTable jTable_Acompañantes) {
        String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Total"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Acompañantes.setModel(modelotabla);
        int registros = modeloVen.listaDeAcompañantes().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = String.valueOf(modeloVen.listaDeAcompañantes().get(i).getFactura());
            registro[1] = modeloVen.listaDeAcompañantes().get(i).getAcompañantes();
            registro[2] = String.valueOf(modeloVen.listaDeAcompañantes().get(i).getCantidadAcompañantes());
            registro[3] = formato.format(modeloVen.listaDeAcompañantes().get(i).getPrecio());
            registro[4] = formato.format(modeloVen.listaDeAcompañantes().get(i).getValorCuenta());
            modelotabla.addRow(registro);
        }
        jTable_Acompañantes.setModel(modelotabla);
    }

    private void cargarTablaBebidas(JTable jTable_Bebidas) {
        String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Total"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Bebidas.setModel(modelotabla);
        int registros = modeloVen.listaDeBebidas().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = String.valueOf(modeloVen.listaDeBebidas().get(i).getFactura());
            registro[1] = modeloVen.listaDeBebidas().get(i).getBebidas();
            registro[2] = String.valueOf(modeloVen.listaDeBebidas().get(i).getCantidadBebidas());
            registro[3] = formato.format(modeloVen.listaDeBebidas().get(i).getPrecio());
            registro[4] = formato.format(modeloVen.listaDeBebidas().get(i).getValorCuenta());
            modelotabla.addRow(registro);
        }
        jTable_Bebidas.setModel(modelotabla);
    }

    private void cargarTablaPostres(JTable jTable_Postres) {
        String[] titulos = {"N° Factura", "Nombre", "Cantidad", "Precio", "Total"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Postres.setModel(modelotabla);
        int registros = modeloVen.listaDePostres().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = String.valueOf(modeloVen.listaDePostres().get(i).getFactura());
            registro[1] = modeloVen.listaDePostres().get(i).getPostre();
            registro[2] = String.valueOf(modeloVen.listaDePostres().get(i).getCantidadPostre());
            registro[3] = formato.format(modeloVen.listaDePostres().get(i).getPrecio());
            registro[4] = formato.format(modeloVen.listaDePostres().get(i).getValorCuenta());
            modelotabla.addRow(registro);
        }
        jTable_Postres.setModel(modelotabla);
    }

    private void cargarTablaCuenta(JTable jTable_Cuenta) {
        String[] titulos = {"N° Factura", "Fecha", "Mesa", "Mesero", "Valor cuenta"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Cuenta.setModel(modelotabla);
        int registros = modeloVen.listaDePedidos().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = String.valueOf(modeloVen.listaDePedidos().get(i).getFactura());
            registro[1] = modeloVen.listaDePedidos().get(i).getFecha();
            registro[2] = modeloVen.listaDePedidos().get(i).getMesa();
            registro[3] = modeloVen.listaDePedidos().get(i).getMesero();
            registro[4] = formato.format(modeloVen.listaDePedidos().get(i).getValorCuenta());
            modelotabla.addRow(registro);
        }
        jTable_Cuenta.setModel(modelotabla);
    }

    public boolean validarPedido() {
        boolean existe = false;
        int tamaño = modeloVen.listaVentas().size();
        for (int i = 0; i < tamaño; i++) {
            int Factura = modeloVen.listaVentas().get(i).getFactura();
            if (vistaVen.jT_Factura.getText().equals(Factura)) {
                existe = true;
                i = tamaño;
                JOptionPane.showMessageDialog(null, "Ya existe un pedido con datos similares");
            }
        }
        return existe;
    }

    private boolean VaciocargarPedido() {
        boolean vacio = false;
        if (vistaVen.jT_Factura.getText().length() == 0 || vistaVen.jT_Fecha.getText().length() == 0
                || vistaVen.jCombo_Mesa.getSelectedItem().equals("Seleccione una mesa") || vistaVen.jT_IdMesero.getText().length() == 0
                || vistaVen.jCombo_Carta.getSelectedItem().equals("Seleccione un plato")
                || vistaVen.jT_CantidadCarta.getText().length() == 0 || vistaVen.jCombo_Acompañantes.getSelectedItem().equals("Seleecione un acompañante")
                || vistaVen.jT_CantidadAcompañantes.getText().length() == 0 || vistaVen.jCombo_Bebida.getSelectedItem().equals("Seleccione una bebida")
                || vistaVen.jT_CantidadBebida.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    public void limpiarEntradaPedido() {
        vistaVen.jCombo_Mesa.setSelectedItem("Seleccione una mesa");
        vistaVen.jT_IdMesero.setText(null);
        vistaVen.jCombo_Carta.setSelectedItem("Seleccione un plato");
        vistaVen.jT_CantidadCarta.setText(null);
        vistaVen.jCombo_Acompañantes.setSelectedItem("Seleecione un acompañante");
        vistaVen.jT_CantidadAcompañantes.setText(null);
        vistaVen.jCombo_Bebida.setSelectedItem("Seleccione una bebida");
        vistaVen.jT_CantidadBebida.setText(null);
        vistaVen.jCombo_Postre.setSelectedItem("Seleccione un postre");
        vistaVen.jT_CantidadPostre.setText(null);
    }

    public void limpiarTodp() {
        vistaVen.jT_Factura.setText(null);
        vistaVen.jCombo_Mesa.setSelectedItem("Seleccione una mesa");
        vistaVen.jT_IdMesero.setText(null);
        vistaVen.jCombo_Carta.setSelectedItem("Seleccione un plato");
        vistaVen.jT_CantidadCarta.setText(null);
        vistaVen.jCombo_Acompañantes.setSelectedItem("Seleecione un acompañante");
        vistaVen.jT_CantidadAcompañantes.setText(null);
        vistaVen.jCombo_Bebida.setSelectedItem("Seleccione una bebida");
        vistaVen.jT_CantidadBebida.setText(null);
        vistaVen.jCombo_Postre.setSelectedItem("Seleccione un postre");
        vistaVen.jT_CantidadPostre.setText(null);
    }

    public void fechaSistema() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

// Formatear la fecha como una cadena
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Define el formato deseado
        String fechaFormateada = fechaActual.format(formatter);

// Establecer la fecha formateada en el JTextField
        vistaVen.jT_Fecha.setText(fechaFormateada);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaVen.btn_CargarPedido) {
            int Factura = Integer.parseInt(vistaVen.jT_Factura.getText());
            String Fecha = vistaVen.jT_Fecha.getText();
            String Mesa = (String) vistaVen.jCombo_Mesa.getSelectedItem();
            String Mesero = vistaVen.jT_IdMesero.getText();
            String Carta = (String) vistaVen.jCombo_Carta.getSelectedItem();
            int CantidadCarta = Integer.parseInt(vistaVen.jT_CantidadCarta.getText());
            String Acompañante = (String) vistaVen.jCombo_Acompañantes.getSelectedItem();
            int CantidadAcompañante = Integer.parseInt(vistaVen.jT_CantidadAcompañantes.getText());
            String Bebida = (String) vistaVen.jCombo_Bebida.getSelectedItem();
            int CantidadBebida = Integer.parseInt(vistaVen.jT_CantidadBebida.getText());
            if (VaciocargarPedido() == false) {
                if (validarPedido() == false) {
                    Ventas miventa = new Ventas(Factura, Fecha, Mesa, Mesero, Carta, CantidadCarta, Acompañante, CantidadAcompañante, Bebida, CantidadBebida);
                    modeloVen.registrarPedido(miventa);
                    limpiarEntradaPedido();
//                    cargarTablaCarta(vistaVen.jTable_Carta);
//                    cargarTablaAcompañantes(vistaVen.jTable_Acompañantes);
//                    cargarTablaBebidas(vistaVen.jTable_Bebidas);
                    cargarTablaCuenta(vistaVen.jTable_Cuenta);
                }
            }
        }
        if (e.getSource() == vistaVen.btn_CargarCarta) {
            int Factura = Integer.parseInt(vistaVen.jT_Factura.getText());
            String Carta = (String) vistaVen.jCombo_Carta.getSelectedItem();
            int CantidadCarta = Integer.parseInt(vistaVen.jT_CantidadCarta.getText());
            Ventas miventa = new Ventas(Factura, Carta, CantidadCarta);
            modeloVen.registrarCarta(miventa);
            limpiarEntradaPedido();
            busquedaFacturaCarta(vistaVen.jT_Factura.getText(), vistaVen.jTable_Carta);

        }
        if (e.getSource() == vistaVen.btn_CargarAcompañante) {
            int Factura = Integer.parseInt(vistaVen.jT_Factura.getText());
            String Acompañante = (String) vistaVen.jCombo_Acompañantes.getSelectedItem();
            int CantidadAcompañante = Integer.parseInt(vistaVen.jT_CantidadAcompañantes.getText());
            Acompañantes miventa = new Acompañantes(Factura, Acompañante, CantidadAcompañante);
            modeloVen.registrarAcompañantes(miventa);
            limpiarEntradaPedido();
            busquedaFacturaAcompañante(vistaVen.jT_Factura.getText(), vistaVen.jTable_Acompañantes);
        }
        if (e.getSource() == vistaVen.btn_CargarBebida) {
            int Factura = Integer.parseInt(vistaVen.jT_Factura.getText());
            String Bebida = (String) vistaVen.jCombo_Bebida.getSelectedItem();
            int CantidadBebida = Integer.parseInt(vistaVen.jT_CantidadBebida.getText());
            Bebidas miventa = new Bebidas(Factura, Bebida, CantidadBebida);
            modeloVen.registrarBebidas(miventa);
            limpiarEntradaPedido();
            busquedaFacturaBebida(vistaVen.jT_Factura.getText(), vistaVen.jTable_Bebidas);
        }
        if (e.getSource() == vistaVen.btn_CargarPostre) {
            int Factura = Integer.parseInt(vistaVen.jT_Factura.getText());
            String Postre = (String) vistaVen.jCombo_Postre.getSelectedItem();
            int CantidadPostre = Integer.parseInt(vistaVen.jT_CantidadPostre.getText());
            Postres miventa = new Postres(Factura, Postre, CantidadPostre);
            modeloVen.registrarPostre(miventa);
            limpiarEntradaPedido();
            busquedaFacturaPostre(vistaVen.jT_Factura.getText(), vistaVen.jTable_Postres);
        }
        if (e.getSource() == vistaVen.btn_Pagar) {
            try {
                modeloInv.actualizarCantidades();
                modeloVen.actualizarPedidos();                
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
            busquedaFactura(vistaVen.jT_Factura.getText(), vistaVen.jTable_Cuenta);
        }
        if (e.getSource() == vistaVen.btn_Volver) {
            Controlador_Menu controlador = new Controlador_Menu(vistaMe);
            vistaVen.setVisible(false);
            vistaMe.setVisible(true);
            vistaMe.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaVen.btn_Analisis) {
            Controlador_VentasAnalisis controlador = new Controlador_VentasAnalisis(vistaVent, modeloVent);
            vistaVen.setVisible(false);
            vistaVent.setVisible(true);
            vistaVent.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaVen.btn_Limpiar) {
            limpiarTodp();
            cargarUltimoIdFactura(vistaVen.jT_Factura);
            cargarTablaCuenta(vistaVen.jTable_Cuenta);
        }
    }
}
