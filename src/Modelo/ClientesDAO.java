/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.awt.event.ActionEvent;
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
public class ClientesDAO {

    ArrayList<Personas> clientes = new ArrayList<>();

    public ClientesDAO() {
        clientes = listaDeClientes();
    }

    public ArrayList<Personas> listaCliente() {
        return clientes;
    }

    public void registrarCliente(Personas mipersona) {
        String sql = "";
        String sql1 = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        try {
            sql = "Insert Into Personas(Id, Nombre, Apellido, Celular, F_Nacimiento) "
                    + "Values(?,?,?,?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, mipersona.getId());
            pst.setString(2, mipersona.getNombre());
            pst.setString(3, mipersona.getApellido());
            pst.setString(4, mipersona.getCelular());
            pst.setString(5, mipersona.getFecha_Nacimiento());
            pst.executeUpdate();

            sql1 = "Insert into clientes(Id_Cliente, F_Ingreso, Comentarios, Calificacion) "
                    + "Values(?, ?, ?, ?);";
            pst1 = cn.prepareStatement(sql1);
            pst1.setString(1, mipersona.getId());
            pst1.setString(2, mipersona.getFecha_Ingreso());
            pst1.setString(3, mipersona.getComentarios());
            pst1.setString(4, String.valueOf(mipersona.getCalificacion()));
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(null, "El cliente\n Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error\n"
                    + "No se ha registrado correctamente, puede que la persona ya haya estado registrada en el sistema", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                pst.close();
                pst1.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Personas> listaDeClientes() {
        ArrayList<Personas> mispersonas = new ArrayList<Personas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "SELECT personas.Id, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                    + "personas.Edad, "
                    + "personas.Celular, clientes.F_Ingreso, clientes.Comentarios, clientes.Calificacion "
                    + "FROM clientes, personas "
                    + "where personas.Id = clientes.Id_Cliente "
                    + "Order by clientes.F_Ingreso desc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Personas persona = new Personas();
                persona.setId(res.getString("personas.Id"));
                persona.setNombre(res.getString("Nombre"));
                persona.setEdad(res.getInt("personas.Edad"));
                persona.setCelular(res.getString("personas.Celular"));
                persona.setFecha_Ingreso(res.getString("clientes.F_Ingreso"));
                persona.setComentarios(res.getString("clientes.Comentarios"));
                persona.setCalificacion(res.getDouble("clientes.Calificacion"));
                mispersonas.add(persona);
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
        return mispersonas;
    }

    public ArrayList<Personas> buscarCliente(String busqueda, String busqueda1, String busqueda2) {
        ArrayList<Personas> mispersonas = new ArrayList<Personas>();
        String sql = "SELECT personas.Id, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                + "personas.Edad, "
                + "personas.Celular, clientes.F_Ingreso, clientes.Comentarios, clientes.Calificacion "
                + "FROM clientes, personas "
                + "where personas.Id = clientes.Id_Cliente "
                + "And (personas.Nombre like '%" + busqueda + "%' and personas.Edad like '" + busqueda1 + "%' "
                + "and clientes.F_Ingreso like '" + busqueda2 + "%') "
                + "Order by clientes.F_Ingreso desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Personas persona = new Personas();
                persona.setId(res.getString("personas.Id"));
                persona.setNombre(res.getString("Nombre"));
                persona.setEdad(res.getInt("personas.Edad"));
                persona.setCelular(res.getString("personas.Celular"));
                persona.setFecha_Ingreso(res.getString("clientes.F_Ingreso"));
                persona.setComentarios(res.getString("clientes.Comentarios"));
                persona.setCalificacion(res.getDouble("clientes.Calificacion"));
                mispersonas.add(persona);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mispersonas;
    }

    public void actualizarEdad() throws SQLException {
        BdConnection bdConnection = new BdConnection();
        Connection connection = bdConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "UPDATE personas\n"
                    + "SET Edad = ROUND(DATEDIFF(CURDATE(), F_Nacimiento) / 365.25);";
            statement.executeUpdate(sql);
        } finally {
            // Asegúrate de cerrar la conexión y la declaración en caso de excepción
            if (statement != null) {
                statement.close();
            }
            bdConnection.desconectar(); // Cierra la conexión después de su uso
        }
    }
}
