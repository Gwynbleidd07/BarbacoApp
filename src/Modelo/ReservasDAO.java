/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Lombo
 */
public class ReservasDAO {

    ArrayList<Reservas> reservas = new ArrayList<Reservas>();

    public ReservasDAO() {
        reservas = listaDeReservas();
    }

    public ArrayList<Reservas> listaReservas() {
        return reservas;
    }

    public void registrarReserva(Reservas misreservas) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into reservas(Fecha, Valor_Reserva, Id_Cliente, Id_Pedido) Values(?, ?, ?, ?);";
            pst = cn.prepareStatement(sql);
            pst.setString(1, misreservas.getFecha());
            pst.setInt(2, misreservas.getValor());
            pst.setString(3, misreservas.getCliente());
            pst.setString(4, misreservas.getPedido());
            pst.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que la reserva ya haya estado registrada en el sistema", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                pst.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Reservas> listaDeReservas() {
        ArrayList<Reservas> misreservas = new ArrayList<Reservas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select reservas.Fecha, reservas.Id_Cliente, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                    + "pedidos.Id, (reservas.Valor_Reserva + pedidos.Valor_Cuenta) as Total  "
                    + "From reservas, personas, clientes, pedidos "
                    + "Where reservas.Id_Cliente = clientes.Id_Cliente "
                    + "And clientes.Id_Cliente = personas.Id "
                    + "And reservas.Id_Pedido = pedidos.Id "
                    + "Group by reservas.Fecha, reservas.Id_Cliente, pedidos.Id, Total "
                    + "Order by pedidos.Id desc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Reservas reserva = new Reservas();
                reserva.setFecha(res.getString("reservas.Fecha"));
                reserva.setCliente(res.getString("reservas.Id_Cliente"));
                reserva.setNombre(res.getString("Nombre"));
                reserva.setPedido(res.getString("pedidos.Id"));
                reserva.setValor(res.getInt("Total"));
                misreservas.add(reserva);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puedo consultar los datos");
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return misreservas;
    }

    public ArrayList<Reservas> listaDeClientes() {
        ArrayList<Reservas> misreservas = new ArrayList<Reservas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select personas.Id, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, personas.Celular "
                    + "From clientes, personas "
                    + "Where personas.Id = clientes.Id_Cliente "
                    + "Group by personas.Id "
                    + "order by personas.Nombre asc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Reservas reserva = new Reservas();
                reserva.setCliente(res.getString("personas.Id"));
                reserva.setNombre(res.getString("Nombre"));
                reserva.setFecha(res.getString("personas.Celular"));
                misreservas.add(reserva);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puedo consultar los datos");
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return misreservas;
    }

    public ArrayList<Reservas> buscarCliente(String busqueda) {
        ArrayList<Reservas> misreservas = new ArrayList<Reservas>();
        String sql = "Select personas.Id, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, personas.Celular "
                + "From clientes, personas "
                + "Where personas.Id = clientes.Id_Cliente "
                + "And personas.Nombre like '%" + busqueda + "%' "
                + "order by personas.Nombre asc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Reservas reserva = new Reservas();
                reserva.setCliente(res.getString("personas.Id"));
                reserva.setNombre(res.getString("Nombre"));
                reserva.setFecha(res.getString("personas.Celular"));
                misreservas.add(reserva);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puedo consultar los datos");
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return misreservas;
    }

    public ArrayList<Reservas> buscarReserva(String busqueda) {
        ArrayList<Reservas> misreservas = new ArrayList<Reservas>();
        String sql = "Select reservas.Fecha, reservas.Id_Cliente, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                + "pedidos.Id, reservas.Valor_Reserva as Total  "
                + "From reservas, personas, clientes, pedidos "
                + "Where reservas.Id_Cliente = clientes.Id_Cliente "
                + "And clientes.Id_Cliente = personas.Id "
                + "And reservas.Id_Pedido = pedidos.Id "
                + "and (reservas.Fecha like '" + busqueda + "%') "
                + "Group by reservas.Fecha, reservas.Id_Cliente, pedidos.Id, Total "
                + "Order by pedidos.Id desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Reservas reserva = new Reservas();
                reserva.setFecha(res.getString("reservas.Fecha"));
                reserva.setCliente(res.getString("reservas.Id_Cliente"));
                reserva.setNombre(res.getString("Nombre"));
                reserva.setPedido(res.getString("pedidos.Id"));
                reserva.setValor(res.getInt("Total"));
                misreservas.add(reserva);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puedo consultar los datos");
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return misreservas;
    }

    public ArrayList<Reservas> buscarTotal(String busqueda) {
        ArrayList<Reservas> misreservas = new ArrayList<Reservas>();
        String sql = "Select sum(Valor_Reserva) as Total "
                + "from reservas "
                + "Where fecha like '" + busqueda + "%';";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Reservas reserva = new Reservas();
                reserva.setValor(res.getInt("Total"));
                misreservas.add(reserva);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puedo consultar los datos");
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return misreservas;
    }

}
