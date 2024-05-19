/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClientesDAO;
import Modelo.InventariosDAO;
import Modelo.Reservas;
import Modelo.ReservasDAO;
import Modelo.VentasDAO;
import Vista.Cliente;
import Vista.Menu;
import Vista.Reserva;
import Vista.Venta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés Lombo
 */
public class Controlador_Reserva implements ActionListener {

    ReservasDAO modeloRes = new ReservasDAO();
    Reserva vistaRes = new Reserva();
    Menu vistaMe = new Menu();
    VentasDAO modeloVen = new VentasDAO();
    Venta vistaVen = new Venta();
    InventariosDAO modeloInv = new InventariosDAO();
    Cliente vistaCli = new Cliente();
    ClientesDAO modeloCli = new ClientesDAO();
    

    Controlador_Reserva(Reserva vistaReserva, ReservasDAO modeloReserva) {
        this.modeloRes = modeloReserva;
        this.vistaRes = vistaReserva;
        vistaReserva.btn_Buscar.addActionListener(this);
        vistaReserva.btn_Cliente.addActionListener(this);
        vistaReserva.btn_Pagar.addActionListener(this);
        vistaReserva.btn_Pedido.addActionListener(this);
        vistaReserva.btn_Reserva.addActionListener(this);
        vistaReserva.btn_Volver.addActionListener(this);
        vistaReserva.btn_Limpiar.addActionListener(this);
        vistaReserva.jTable_Cliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaRes.jTable_Cliente.rowAtPoint(e.getPoint());
                if (seleccionado > - 1) {
                    vistaReserva.jTextField_Cliente.setText(String.valueOf(vistaReserva.jTable_Cliente.getValueAt(seleccionado, 0)));
                }
            }
        });
        vistaReserva.jTable_Cuenta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaRes.jTable_Cuenta.rowAtPoint(e.getPoint());
                if (seleccionado > - 1) {
                    vistaReserva.jTextField_Factura.setText(String.valueOf(vistaReserva.jTable_Cuenta.getValueAt(seleccionado, 0)));
                }
            }
        });
        vistaReserva.jTextField_Cliente.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                busquedaCliente(vistaRes.jTextField_Cliente.getText(), vistaRes.jTable_Cliente);
            }

            private void busquedaCliente(String busqueda, JTable jTable_Cliente) {
                ArrayList<Reservas> reservas = new ArrayList<>();
                reservas = modeloRes.buscarCliente(busqueda);
                if (reservas.size() != 0) {
                    String[] titulos = {"Cedula", "Nombre", "Celular"};
                    String[] registro = new String[3];
                    DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
                    jTable_Cliente.setModel(modeltabla);
                    int registros = reservas.size();
                    DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
                    for (int i = 0; i < registros; i++) {
                        registro[0] = reservas.get(i).getCliente();
                        registro[1] = reservas.get(i).getNombre();
                        registro[2] = reservas.get(i).getFecha();
                        modeltabla.addRow(registro);
                    }
                    jTable_Cliente.setModel(modeltabla);
                } else {
                    JOptionPane.showMessageDialog(null, "No hay datos registrados con lo ingresado");
                }
            }
        });
        cargarTablaReserva(vistaRes.jTable_Reserva);
        cargarTablaCliente(vistaRes.jTable_Cliente);
        cargarTablaCuenta(vistaRes.jTable_Cuenta);
        cargarUltimoIdFactura(vistaRes.jTextField_Factura);
    }

    public Controlador_Reserva(VentasDAO modeloVentas, Venta vistaVenta) {
        this.modeloVen = modeloVentas;
        this.vistaVen = vistaVenta;
        vistaVen.btn_Volver.addActionListener(this);
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
        int registros = modeloVen.listaDePedidos1().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = String.valueOf(modeloVen.listaDePedidos1().get(i).getFactura());
            registro[1] = modeloVen.listaDePedidos1().get(i).getFecha();
            registro[2] = modeloVen.listaDePedidos1().get(i).getMesa();
            registro[3] = modeloVen.listaDePedidos1().get(i).getMesero();
            registro[4] = formato.format(modeloVen.listaDePedidos1().get(i).getValorCuenta());
            modelotabla.addRow(registro);
        }
        jTable_Cuenta.setModel(modelotabla);
    }

    private void cargarTablaCliente(JTable jTable_Cuenta) {
        String[] titulos = {"Cedula", "Nombre", "Celular"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[3];
        jTable_Cuenta.setModel(modelotabla);
        int registros = modeloRes.listaDeClientes().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloRes.listaDeClientes().get(i).getCliente();
            registro[1] = modeloRes.listaDeClientes().get(i).getNombre();
            registro[2] = modeloRes.listaDeClientes().get(i).getFecha();
            modelotabla.addRow(registro);
        }
        jTable_Cuenta.setModel(modelotabla);
    }

    private void cargarTablaReserva(JTable jTable_Cuenta) {
        String[] titulos = {"Fecha", "Cedula", "Nombre", "N°Factura,", "Total"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Cuenta.setModel(modelotabla);
        int registros = modeloRes.listaDeReservas().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloRes.listaDeReservas().get(i).getFecha();
            registro[1] = modeloRes.listaDeReservas().get(i).getCliente();
            registro[2] = modeloRes.listaDeReservas().get(i).getNombre();
            registro[3] = modeloRes.listaDeReservas().get(i).getPedido();
            registro[4] = formato.format(modeloRes.listaDeReservas().get(i).getValor());
            modelotabla.addRow(registro);
        }
        jTable_Cuenta.setModel(modelotabla);
    }

    public boolean validarReserva() {
        boolean existe = false;
        int tamaño = modeloRes.listaReservas().size();
        for (int i = 0; i < tamaño; i++) {
            String factura = modeloRes.listaReservas().get(i).getPedido();
            if (vistaRes.jTextField_Factura.getText().equals(factura)) {
                existe = true;
                i = tamaño;
                JOptionPane.showMessageDialog(null, "Ya existe una reserva con datos similares");
            }
        }
        return existe;
    }

    private boolean Vacio() {
        boolean vacio = false;
        if (((JTextField) vistaRes.jDate_Fecha.getDateEditor().getUiComponent()).getText().length() == 0
                || vistaRes.jTextField_Valor.getText().length() == 0 || vistaRes.jTextField_Cliente.getText().length() == 0
                || vistaRes.jTextField_Factura.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    public void limpiarEntrada() {
        vistaRes.jDate_Fecha.setDate(null);
        vistaRes.jTextField_Valor.setText(null);
        vistaRes.jTextField_Cliente.setText(null);
        vistaRes.jTextField_Factura.setText(null);
    }

    private void cargarUltimoIdFactura(JTextField jT_Factura) {
        // Obtener el último ID registrado y sumarle uno
        int ultimoId = modeloVen.buscarUltimoId1();

        // Mostrar el último ID + 1 en el JTextField
        jT_Factura.setText(String.valueOf(ultimoId));
    }

    private void busquedaFecha(String busqueda, JTable jTable) {
        ArrayList<Reservas> reservas = new ArrayList<>();
        reservas = modeloRes.buscarReserva(busqueda);
        if (reservas.size() != 0) {
            String[] titulos = {"Fecha", "Cedula", "Nombre", "N°Factura", "Valor reserva"};
            String[] registro = new String[5];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable.setModel(modeltabla);
            int registros = reservas.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = reservas.get(i).getFecha();
                registro[1] = reservas.get(i).getCliente();
                registro[2] = reservas.get(i).getNombre();
                registro[3] = reservas.get(i).getPedido();
                registro[4] = formato.format(reservas.get(i).getValor());
                modeltabla.addRow(registro);
            }
            jTable.setModel(modeltabla);
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos registrados con lo ingresado");
        }
    }

    private void busquedaTotal(String busqueda, JLabel labelValor) {
        ArrayList<Reservas> reservas = modeloRes.buscarTotal(busqueda);

        if (!reservas.isEmpty()) {
            int valorTotal = reservas.get(0).getValor(); // Obtener el valor total

            // Formatear el número antes de establecerlo como texto en el JLabel
            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(0); // Define el número máximo de dígitos fraccionarios
            String valorFormateado = nf.format(valorTotal); // Formatea el número

            // Actualizar el texto del JLabel con el valor total formateado
            labelValor.setText("Valor total de las reservas: " + valorFormateado);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaRes.btn_Pedido) {
            Controlador_Ventas controlador = new Controlador_Ventas(vistaVen, modeloVen);
            vistaRes.setVisible(false);
            vistaVen.setVisible(true);
            vistaVen.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaRes.btn_Volver) {
            Controlador_Menu controlador = new Controlador_Menu(vistaMe);
            vistaRes.setVisible(false);
            vistaMe.setVisible(true);
            vistaMe.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaRes.btn_Reserva) {
            String Fecha = (((JTextField) vistaRes.jDate_Fecha.getDateEditor().getUiComponent()).getText());
            int Valor = Integer.parseInt(vistaRes.jTextField_Valor.getText());
            String Cliente = vistaRes.jTextField_Cliente.getText();
            String Pedido = vistaRes.jTextField_Factura.getText();
            if (Vacio() == false) {
                if (validarReserva() == false) {
                    Reservas mireserva = new Reservas(Fecha, Valor, Cliente, Pedido);
                    modeloRes.registrarReserva(mireserva);
                    limpiarEntrada();
                    cargarTablaCuenta(vistaRes.jTable_Cuenta);
                    cargarTablaReserva(vistaRes.jTable_Reserva);
                }
            }
        }
        if (e.getSource() == vistaRes.btn_Pagar) {
            try {
                modeloInv.actualizarCantidades();
                modeloVen.actualizarPedidos();
            } catch (SQLException ex) {
                Logger.getLogger(Controlador_Ventas.class.getName()).log(Level.SEVERE, null, ex);
            }
            cargarTablaCuenta(vistaRes.jTable_Cuenta);
            cargarTablaReserva(vistaRes.jTable_Reserva);
        }
        if (e.getSource() == vistaRes.btn_Buscar) {
            busquedaFecha(((JTextField) vistaRes.jDate_Fecha.getDateEditor().getUiComponent()).getText(), vistaRes.jTable_Reserva);
            busquedaTotal(((JTextField) vistaRes.jDate_Fecha.getDateEditor().getUiComponent()).getText(), vistaRes.jLabel_Total);
        }
        if (e.getSource() == vistaRes.btn_Limpiar) {
            limpiarEntrada();
            cargarTablaReserva(vistaRes.jTable_Reserva);
            cargarTablaCliente(vistaRes.jTable_Cliente);
            vistaRes.jLabel_Total.setText(null);
            cargarUltimoIdFactura(vistaRes.jTextField_Factura);
        }
        if (e.getSource() == vistaRes.btn_Cliente) {
            Controlador_Cliente controlador = new Controlador_Cliente(vistaCli, modeloCli);
            vistaRes.setVisible(false);
            vistaCli.setVisible(true);
            vistaCli.setLocationRelativeTo(null);
        }
    }
}
