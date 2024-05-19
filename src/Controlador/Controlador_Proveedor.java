/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.Personas;
import Modelo.Proveedor;
import Modelo.ProveedorDAO;
import Vista.C_Proveedor;
import Vista.Menu;
import Vista.Proveedores;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
public class Controlador_Proveedor implements ActionListener {

    ProveedorDAO modeloPro = new ProveedorDAO();
    Proveedores vistaPro = new Proveedores();
    Menu vistaMe = new Menu();
    C_Proveedor vistaCpro = new C_Proveedor();

    Controlador_Proveedor(C_Proveedor vistaCProveedor, ProveedorDAO modeloCProveedor) {
        this.modeloPro = modeloCProveedor;
        this.vistaCpro = vistaCProveedor;
        vistaCProveedor.btn_Volver.addActionListener(this);
        vistaCProveedor.btn_Proveedor.addActionListener(this);

        cargarTablaProveedor(vistaCProveedor.jTable_Proveedor);
    }

    Controlador_Proveedor(Proveedores vistaProveedores, ProveedorDAO modeloProveedor) {
        this.modeloPro = modeloProveedor;
        this.vistaPro = vistaProveedores;
        vistaProveedores.btn_Volver.addActionListener(this);
        vistaProveedores.btn_Buscar.addActionListener(this);
        vistaProveedores.btn_Carta.addActionListener(this);
        vistaProveedores.btn_Acompañante.addActionListener(this);
        vistaProveedores.btn_Bebida.addActionListener(this);
        vistaProveedores.btn_Postre.addActionListener(this);
        vistaProveedores.btn_Servicio.addActionListener(this);
        vistaProveedores.btn_Crear.addActionListener(this);
        vistaProveedores.jTable_Proveedor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int seleccionado = vistaPro.jTable_Proveedor.rowAtPoint(e.getPoint());
                if (seleccionado >-1) {
                    vistaProveedores.jTextField_Proveedor.setText(String.valueOf(vistaProveedores.jTable_Proveedor.getValueAt(seleccionado, 0)));
                }
            }
        });

        cargarTablaProveedor(vistaProveedores.jTable_Proveedor);
        cargarTablaCarta(vistaProveedores.jTable_Carta);
        cargarTablaAcompañante(vistaProveedores.jTable_Acompañante);
        cargarTablaBebida(vistaProveedores.jTable_Bebida);
        cargarTablaPostre(vistaProveedores.jTable_Postre);
        cargarTablaServicio(vistaProveedores.jTable_Servicios);
        cargarTablaValor(vistaProveedores.jTable_Valores);
    }

    private void cargarTablaProveedor(JTable jTable_Proveedor) {
        String[] titulos = {"Cedula", "Nombre", "Celular", "Direccion"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[4];
        jTable_Proveedor.setModel(modelotabla);
        int registros = modeloPro.listaDeProveedor().size();
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloPro.listaDeProveedor().get(i).getId();
            registro[1] = modeloPro.listaDeProveedor().get(i).getNombre();
            registro[2] = modeloPro.listaDeProveedor().get(i).getCelular();
            registro[3] = modeloPro.listaDeProveedor().get(i).getComentarios();
            modelotabla.addRow(registro);
        }
        jTable_Proveedor.setModel(modelotabla);
    }

    private void cargarTablaCarta(JTable jTable_Carta) {
        String[] titulos = {"Cedula", "Nombre", "Fecha", "Descripcion", "Valor"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Carta.setModel(modelotabla);
        int registros = modeloPro.listaDeCarta().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloPro.listaDeCarta().get(i).getId_Proveedor();
            registro[1] = modeloPro.listaDeCarta().get(i).getNombre();
            registro[2] = modeloPro.listaDeCarta().get(i).getFecha();
            registro[3] = modeloPro.listaDeCarta().get(i).getDescripcion();
            registro[4] = formato.format(modeloPro.listaDeCarta().get(i).getValor());
            modelotabla.addRow(registro);
        }
        jTable_Carta.setModel(modelotabla);
    }

    private void cargarTablaAcompañante(JTable jTable_Acompañante) {
        String[] titulos = {"Cedula", "Nombre", "Fecha", "Descripcion", "Valor"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Acompañante.setModel(modelotabla);
        int registros = modeloPro.listaDeAcompañante().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloPro.listaDeAcompañante().get(i).getId_Proveedor();
            registro[1] = modeloPro.listaDeAcompañante().get(i).getNombre();
            registro[2] = modeloPro.listaDeAcompañante().get(i).getFecha();
            registro[3] = modeloPro.listaDeAcompañante().get(i).getDescripcion();
            registro[4] = formato.format(modeloPro.listaDeAcompañante().get(i).getValor());
            modelotabla.addRow(registro);
        }
        jTable_Acompañante.setModel(modelotabla);
    }

    private void cargarTablaBebida(JTable jTable_Bebida) {
        String[] titulos = {"Cedula", "Nombre", "Fecha", "Descripcion", "Valor"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Bebida.setModel(modelotabla);
        int registros = modeloPro.listaDeBebida().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloPro.listaDeBebida().get(i).getId_Proveedor();
            registro[1] = modeloPro.listaDeBebida().get(i).getNombre();
            registro[2] = modeloPro.listaDeBebida().get(i).getFecha();
            registro[3] = modeloPro.listaDeBebida().get(i).getDescripcion();
            registro[4] = formato.format(modeloPro.listaDeBebida().get(i).getValor());
            modelotabla.addRow(registro);
        }
        jTable_Bebida.setModel(modelotabla);
    }

    private void cargarTablaPostre(JTable jTable_Postre) {
        String[] titulos = {"Cedula", "Nombre", "Fecha", "Descripcion", "Valor"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Postre.setModel(modelotabla);
        int registros = modeloPro.listaDePostre().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloPro.listaDePostre().get(i).getId_Proveedor();
            registro[1] = modeloPro.listaDePostre().get(i).getNombre();
            registro[2] = modeloPro.listaDePostre().get(i).getFecha();
            registro[3] = modeloPro.listaDePostre().get(i).getDescripcion();
            registro[4] = formato.format(modeloPro.listaDePostre().get(i).getValor());
            modelotabla.addRow(registro);
        }
        jTable_Postre.setModel(modelotabla);
    }

    private void cargarTablaServicio(JTable jTable_Servicios) {
        String[] titulos = {"Id", "Fecha", "Descripcion", "Valor"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[4];
        jTable_Servicios.setModel(modelotabla);
        int registros = modeloPro.listaDeServicio().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloPro.listaDeServicio().get(i).getId_Proveedor();
            registro[1] = modeloPro.listaDeServicio().get(i).getFecha();
            registro[2] = modeloPro.listaDeServicio().get(i).getDescripcion();
            registro[3] = formato.format(modeloPro.listaDeServicio().get(i).getValor());
            modelotabla.addRow(registro);
        }
        jTable_Servicios.setModel(modelotabla);
    }

    private void cargarTablaValor(JTable jTable_Valores) {
        String[] titulos = {"Valor"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[5];
        jTable_Valores.setModel(modelotabla);
        int registros = modeloPro.listaDeTotal().size();
        DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
        for (int i = 0; i < registros; i++) {
            registro[0] = formato.format(modeloPro.listaDeTotal().get(i).getValor());
            modelotabla.addRow(registro);
        }
        jTable_Valores.setModel(modelotabla);
    }

    public boolean Vacio() {
        boolean vacio = false;
        if (vistaPro.jTextField_Proveedor.getText().length() == 0 || vistaPro.jDate_Fecha.getDate() == null || vistaPro.jTextField_Descripcion.getText().length() == 0
                || vistaPro.jTextField_Valor.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    public boolean Vacio1() {
        boolean vacio = false;
        if (vistaCpro.jT_Cedula.getText().length() == 0 || vistaCpro.jT_Apellido.getText().length() == 0 || vistaCpro.jDate_Fecha.getDate() == null
                || vistaCpro.jT_Celular.getText().length() == 0 || vistaCpro.jT_DIreccion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    public boolean Vacio2() {
        boolean vacio = false;
        if (vistaPro.jTextField_Proveedor.getText().length() == 0 || vistaPro.jDate_Fecha.getDate() == null || vistaPro.jTextField_Descripcion.getText().length() == 0
                || vistaPro.jTextField_Valor.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias, excepto el elemento");
            vacio = true;
        }
        return vacio;
    }

    public void limpiarEntrada() {
        vistaPro.jTextField_Proveedor.setText(null);
        vistaPro.jDate_Fecha.setDate(null);
        vistaPro.jTextField_Descripcion.setText(null);
        vistaPro.jTextField_Valor.setText(null);
    }

    public void limpiarEntrada1() {
        vistaCpro.jT_Cedula.setText(null);
        vistaCpro.jT_Apellido.setText(null);
        vistaCpro.jDate_Fecha.setDate(null);
        vistaCpro.jT_Celular.setText(null);
        vistaCpro.jT_DIreccion.setText(null);
    }

    public boolean validarPersona() {
        boolean existe = false;
        int tamaño = modeloPro.listaPersona().size();
        for (int i = 0; i < tamaño; i++) {
            String Id = modeloPro.listaPersona().get(i).getId();
            if (vistaCpro.jT_Cedula.getText().equals(Id)) {
                existe = true;
                i = tamaño;
                JOptionPane.showMessageDialog(null, "Ya existe un proveedor con datos similares");
            }
        }
        return existe;
    }

    private void buscarCarta(String busqueda, String busqueda1, JTable jTable) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        proveedores = modeloPro.buscarCarta(busqueda, busqueda1);
        if (proveedores.size() != 0) {
            String[] titulos = {"Cedula", "Nombre", "Fecha", "Descripcion", "Valor"};
            String[] registro = new String[5];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable.setModel(modeltabla);
            int registros = proveedores.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = proveedores.get(i).getId_Proveedor();
                registro[1] = proveedores.get(i).getNombre();
                registro[2] = proveedores.get(i).getFecha();
                registro[3] = proveedores.get(i).getDescripcion();
                registro[4] = formato.format(proveedores.get(i).getValor());
                modeltabla.addRow(registro);
            }
            jTable.setModel(modeltabla);
        } else {
            DefaultTableModel modelVacia = new DefaultTableModel();
            jTable.setModel(modelVacia);
        }
    }

    private void buscarAcompañante(String busqueda, String busqueda1, JTable jTable) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        proveedores = modeloPro.buscarAcompañante(busqueda, busqueda1);
        if (proveedores.size() != 0) {
            String[] titulos = {"Cedula", "Nombre", "Fecha", "Descripcion", "Valor"};
            String[] registro = new String[5];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable.setModel(modeltabla);
            int registros = proveedores.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = proveedores.get(i).getId_Proveedor();
                registro[1] = proveedores.get(i).getNombre();
                registro[2] = proveedores.get(i).getFecha();
                registro[3] = proveedores.get(i).getDescripcion();
                registro[4] = formato.format(proveedores.get(i).getValor());
                modeltabla.addRow(registro);
            }
            jTable.setModel(modeltabla);
        } else {
            DefaultTableModel modelVacia = new DefaultTableModel();
            jTable.setModel(modelVacia);
        }
    }

    private void buscarBebida(String busqueda, String busqueda1, JTable jTable) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        proveedores = modeloPro.buscarBebida(busqueda, busqueda1);
        if (proveedores.size() != 0) {
            String[] titulos = {"Cedula", "Nombre", "Fecha", "Descripcion", "Valor"};
            String[] registro = new String[5];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable.setModel(modeltabla);
            int registros = proveedores.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = proveedores.get(i).getId_Proveedor();
                registro[1] = proveedores.get(i).getNombre();
                registro[2] = proveedores.get(i).getFecha();
                registro[3] = proveedores.get(i).getDescripcion();
                registro[4] = formato.format(proveedores.get(i).getValor());
                modeltabla.addRow(registro);
            }
            jTable.setModel(modeltabla);
        } else {
            DefaultTableModel modelVacia = new DefaultTableModel();
            jTable.setModel(modelVacia);
        }
    }

    private void buscarPostre(String busqueda, String busqueda1, JTable jTable) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        proveedores = modeloPro.buscarPostre(busqueda, busqueda1);
        if (proveedores.size() != 0) {
            String[] titulos = {"Cedula", "Nombre", "Fecha", "Descripcion", "Valor"};
            String[] registro = new String[5];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable.setModel(modeltabla);
            int registros = proveedores.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = proveedores.get(i).getId_Proveedor();
                registro[1] = proveedores.get(i).getNombre();
                registro[2] = proveedores.get(i).getFecha();
                registro[3] = proveedores.get(i).getDescripcion();
                registro[4] = formato.format(proveedores.get(i).getValor());
                modeltabla.addRow(registro);
            }
            jTable.setModel(modeltabla);
        } else {
            DefaultTableModel modelVacia = new DefaultTableModel();
            jTable.setModel(modelVacia);
        }
    }

    private void buscarServicio(String busqueda, String busqueda1, JTable jTable) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        proveedores = modeloPro.buscarServicio(busqueda, busqueda1);
        if (proveedores.size() != 0) {
            String[] titulos = {"Cedula", "Fecha", "Descripcion", "Valor"};
            String[] registro = new String[4];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable.setModel(modeltabla);
            int registros = proveedores.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = proveedores.get(i).getId_Proveedor();
                registro[1] = proveedores.get(i).getFecha();
                registro[2] = proveedores.get(i).getDescripcion();
                registro[3] = formato.format(proveedores.get(i).getValor());
                modeltabla.addRow(registro);
            }
            jTable.setModel(modeltabla);
        } else {
            DefaultTableModel modelVacia = new DefaultTableModel();
            jTable.setModel(modelVacia);
        }
    }

    private void buscarTotal(String busqueda, JTable jTable) {
        ArrayList<Proveedor> proveedores = new ArrayList<>();
        proveedores = modeloPro.buscarTotal(busqueda);
        if (proveedores.size() != 0) {
            String[] titulos = {"Valor"};
            String[] registro = new String[1];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable.setModel(modeltabla);
            int registros = proveedores.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = formato.format(proveedores.get(i).getValor());
                modeltabla.addRow(registro);
            }
            jTable.setModel(modeltabla);
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos registrados con lo ingresado");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCpro.btn_Proveedor) {
            String Id = vistaCpro.jT_Cedula.getText();
            String Nombre = vistaCpro.jT_Nombre.getText();
            String Apellido = vistaCpro.jT_Apellido.getText();
            String Celular = vistaCpro.jT_Celular.getText();
            String Fecha = ((JTextField) vistaCpro.jDate_Fecha.getDateEditor().getUiComponent()).getText();
            String Direccion = vistaCpro.jT_DIreccion.getText();
            if (Vacio1() == false) {
                if (validarPersona() == false) {
                    Personas miproveedor = new Personas(Id, Nombre, Apellido, Celular, Fecha, Direccion);
                    modeloPro.registrarProveedor(miproveedor);
                    limpiarEntrada1();
                    cargarTablaProveedor(vistaCpro.jTable_Proveedor);
                    cargarTablaProveedor(vistaPro.jTable_Proveedor);
                }
            }
        }
        if (e.getSource() == vistaPro.btn_Carta) {
            if (Vacio() == false) {
                String Cedula = vistaPro.jTextField_Proveedor.getText();
                String Fecha = ((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText();
                String Descripcion = vistaPro.jTextField_Descripcion.getText();
                int Valor = Integer.parseInt(vistaPro.jTextField_Valor.getText());
                Proveedor miproveedor = new Proveedor(Cedula, Fecha, Descripcion, Valor);
                modeloPro.registrarCarta(miproveedor);
                limpiarEntrada();
                cargarTablaCarta(vistaPro.jTable_Carta);
                cargarTablaValor(vistaPro.jTable_Valores);
            }
        }
        if (e.getSource() == vistaPro.btn_Acompañante) {
            String Cedula = vistaPro.jTextField_Proveedor.getText();
            String Fecha = ((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText();
            String Descripcion = vistaPro.jTextField_Descripcion.getText();
            int Valor = Integer.parseInt(vistaPro.jTextField_Valor.getText());
            if (Vacio() == false) {
                Proveedor miproveedor = new Proveedor(Cedula, Fecha, Descripcion, Valor);
                modeloPro.registrarAcompañante(miproveedor);
                limpiarEntrada();
                cargarTablaAcompañante(vistaPro.jTable_Acompañante);
                cargarTablaValor(vistaPro.jTable_Valores);
            }
        }
        if (e.getSource() == vistaPro.btn_Bebida) {
            String Cedula = vistaPro.jTextField_Proveedor.getText();
            String Fecha = ((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText();
            String Descripcion = vistaPro.jTextField_Descripcion.getText();
            int Valor = Integer.parseInt(vistaPro.jTextField_Valor.getText());
            if (Vacio() == false) {
                Proveedor miproveedor = new Proveedor(Cedula, Fecha, Descripcion, Valor);
                modeloPro.registrarBebida(miproveedor);
                limpiarEntrada();
                cargarTablaBebida(vistaPro.jTable_Bebida);
                cargarTablaValor(vistaPro.jTable_Valores);
            }
        }
        if (e.getSource() == vistaPro.btn_Postre) {
            String Cedula = vistaPro.jTextField_Proveedor.getText();
            String Fecha = ((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText();
            String Descripcion = vistaPro.jTextField_Descripcion.getText();
            int Valor = Integer.parseInt(vistaPro.jTextField_Valor.getText());
            if (Vacio() == false) {
                Proveedor miproveedor = new Proveedor(Cedula, Fecha, Descripcion, Valor);
                modeloPro.registrarPostre(miproveedor);
                limpiarEntrada();
                cargarTablaPostre(vistaPro.jTable_Postre);
                cargarTablaValor(vistaPro.jTable_Valores);
            }
        }
        if (e.getSource() == vistaPro.btn_Servicio) {
            String Cedula = vistaPro.jTextField_Proveedor.getText();
            String Fecha = ((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText();
            String Descripcion = vistaPro.jTextField_Descripcion.getText();
            int Valor = Integer.parseInt(vistaPro.jTextField_Valor.getText());
            if (Vacio2() == false) {
                Proveedor miproveedor = new Proveedor(Cedula, Fecha, Descripcion, Valor);
                modeloPro.registrarServicios(miproveedor);
                limpiarEntrada();
                cargarTablaServicio(vistaPro.jTable_Servicios);
                cargarTablaValor(vistaPro.jTable_Valores);
            }
        }
        if (e.getSource() == vistaPro.btn_Buscar) {
            buscarCarta(vistaPro.jTextField_Descripcion.getText(), ((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText(), vistaPro.jTable_Carta);
            buscarAcompañante(vistaPro.jTextField_Descripcion.getText(), ((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText(), vistaPro.jTable_Acompañante);
            buscarBebida(vistaPro.jTextField_Descripcion.getText(), ((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText(), vistaPro.jTable_Bebida);
            buscarPostre(vistaPro.jTextField_Descripcion.getText(), ((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText(), vistaPro.jTable_Postre);
            buscarServicio(vistaPro.jTextField_Descripcion.getText(), ((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText(), vistaPro.jTable_Servicios);
            buscarTotal(((JTextField) vistaPro.jDate_Fecha.getDateEditor().getUiComponent()).getText(), vistaPro.jTable_Valores);
            limpiarEntrada();
        }
        if (e.getSource() == vistaPro.btn_Volver) {
            Controlador_Menu controlador = new Controlador_Menu(vistaMe);
            vistaPro.setVisible(false);
            vistaMe.setVisible(true);
            vistaMe.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaPro.btn_Crear) {
            Controlador_Proveedor controlador = new Controlador_Proveedor(vistaCpro, modeloPro);
            vistaPro.setVisible(false);
            vistaCpro.setVisible(true);
            vistaCpro.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaCpro.btn_Volver) {
            Controlador_Proveedor controlador = new Controlador_Proveedor(vistaPro, modeloPro);
            vistaCpro.setVisible(false);
            vistaPro.setVisible(true);
            vistaPro.setLocationRelativeTo(null);
        }
    }
}
