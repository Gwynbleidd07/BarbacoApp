/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.ClientesDAO;
import Modelo.Personas;
import Vista.Cliente;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Andrés Lombo
 */
public class Controlador_Cliente implements ActionListener {

    ClientesDAO modeloCli = new ClientesDAO();
    Cliente vistaCli = new Cliente();
    Menu vistaMe = new Menu();

    Controlador_Cliente(Cliente vistaCliente, ClientesDAO modeloCliente) {
        this.modeloCli = modeloCliente;
        this.vistaCli = vistaCliente;
        vistaCliente.btn_Buscar.addActionListener(this);
        vistaCliente.btn_Cliente.addActionListener(this);
        vistaCliente.btn_Volver.addActionListener(this);
        fechaSistema();
        cargarTablaCliente(vistaCliente.jTable_Cliente);
        try {
            modeloCliente.actualizarEdad();
        } catch (SQLException ex) {
            Logger.getLogger(Controlador_Ventas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void cargarTablaCliente(JTable jTable_Cliente) {
        String[] titulos = {"Cedula", "Nombre", "Edad", "Celular", "F_Ingreso", "Comentarios", "Calificacion"};
        DefaultTableModel modelotabla = new DefaultTableModel(null, titulos) {
            @Override
            public boolean isCellEditable(int row, int column) {
                // Todas las celdas no son editables
                return false;
            }
        };
        String[] registro = new String[7];
        jTable_Cliente.setModel(modelotabla);
        int registros = modeloCli.listaDeClientes().size();
        for (int i = 0; i < registros; i++) {
            registro[0] = modeloCli.listaDeClientes().get(i).getId();
            registro[1] = modeloCli.listaDeClientes().get(i).getNombre();
            registro[2] = String.valueOf(modeloCli.listaDeClientes().get(i).getEdad());
            registro[3] = modeloCli.listaDeClientes().get(i).getCelular();
            registro[4] = modeloCli.listaDeClientes().get(i).getFecha_Ingreso();
            registro[5] = modeloCli.listaDeClientes().get(i).getComentarios();
            registro[6] = String.valueOf(modeloCli.listaDeClientes().get(i).getCalificacion());
            modelotabla.addRow(registro);
        }
        jTable_Cliente.setModel(modelotabla);
    }

    private void busquedaCliente(String busqueda, String busqueda1, String busqueda2, JTable jTable) {
        ArrayList<Personas> clientes = new ArrayList<>();
        clientes = modeloCli.buscarCliente(busqueda, busqueda1, busqueda2);
        if (clientes.size() != 0) {
            String[] titulos = {"Cedula", "Nombre", "Edad", "Celular", "F_Ingreso", "Comentarios", "Calificacion"};
            String[] registro = new String[7];
            DefaultTableModel modeltabla = new DefaultTableModel(null, titulos);
            jTable.setModel(modeltabla);
            int registros = clientes.size();
            DecimalFormat formato = new DecimalFormat("#,###"); // Define el formato deseado
            for (int i = 0; i < registros; i++) {
                registro[0] = clientes.get(i).getId();
                registro[1] = clientes.get(i).getNombre();
                registro[2] = String.valueOf(clientes.get(i).getEdad());
                registro[3] = clientes.get(i).getCelular();
                registro[4] = clientes.get(i).getFecha_Ingreso();
                registro[5] = clientes.get(i).getComentarios();
                registro[6] = String.valueOf(clientes.get(i).getCalificacion());
                modeltabla.addRow(registro);
            }
            jTable.setModel(modeltabla);
        } else {
            JOptionPane.showMessageDialog(null, "No hay datos registrados con lo ingresado");
        }
    }

    public void fechaSistema() {
        LocalDate fechaActual = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); // Define el formato deseado
        String fechaFormateada = fechaActual.format(formatter);
        vistaCli.jTextField_Fecha.setText(fechaFormateada);
    }

    public boolean Vacio() {
        boolean vacio = false;
        if (vistaCli.jTextField_Cedula.getText().length() == 0 || vistaCli.jTextField_Nombre.getText().length() == 0 || vistaCli.jTextField_Apellido.getText().length() == 0
                || vistaCli.jTextField_Celular.getText().length() == 0 || ((JTextField) vistaCli.jDate_Nacimiento.getDateEditor().getUiComponent()).getText().length() == 0
                || vistaCli.jTextField_Fecha.getText().length() == 0 || vistaCli.jTextArea_Comentario.getText().length() == 0 || vistaCli.jTextField_Calificacion.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    public void limpiarEntrada() {

        vistaCli.jTextField_Cedula.setText(null);
        vistaCli.jTextField_Nombre.setText(null);
        vistaCli.jTextField_Apellido.setText(null);
        vistaCli.jTextField_Celular.setText(null);
        vistaCli.jDate_Nacimiento.setDate(null);
        vistaCli.jTextField_Fecha.setText(null);
        vistaCli.jTextArea_Comentario.setText(null);
        vistaCli.jTextField_Calificacion.setText(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaCli.btn_Cliente) {
            String Cedula = vistaCli.jTextField_Cedula.getText();
            String Nombre = vistaCli.jTextField_Nombre.getText();
            String Apellido = vistaCli.jTextField_Apellido.getText();
            String Celular = vistaCli.jTextField_Celular.getText();
            String Fecha_Nacimiento = ((JTextField) vistaCli.jDate_Nacimiento.getDateEditor().getUiComponent()).getText();
            String Fecha = vistaCli.jTextField_Fecha.getText();
            String Comentario = vistaCli.jTextArea_Comentario.getText();
            double Calificacion = Double.parseDouble(vistaCli.jTextField_Calificacion.getText());
            if (Vacio() == false) {
                Personas micliente = new Personas(Cedula, Nombre, Apellido, Celular, Fecha_Nacimiento, Fecha, Comentario, Calificacion);
                modeloCli.registrarCliente(micliente);
                limpiarEntrada();
                fechaSistema();
                cargarTablaCliente(vistaCli.jTable_Cliente);
            }
        }
        if (e.getSource() == vistaCli.btn_Buscar) {
            busquedaCliente(vistaCli.jTextField_Nombre.getText(), vistaCli.jTextArea_Comentario.getText(),
                    vistaCli.jTextField_Fecha.getText(), vistaCli.jTable_Cliente);
        }
        if (e.getSource() == vistaCli.btn_Volver) {
            Controlador_Menu controlador = new Controlador_Menu(vistaMe);
            vistaCli.setVisible(false);
            vistaMe.setVisible(true);
            vistaMe.setLocationRelativeTo(null);
        }
    }
}
