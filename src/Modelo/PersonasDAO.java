/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Lombo
 */
public class PersonasDAO {

    ArrayList<Personas> personas = new ArrayList<>();

//    public PersonasDAO() {
//        personas = listaDePersonas();
//    }
    public ArrayList<Personas> listaPersona() {
        return personas;
    }

    public int Validar(String l_Usuario, String l_Contraseña) {
        BdConnection conex = new BdConnection();
        int resultado = 0;
        try {
            PreparedStatement consulta = conex.getConnection().prepareStatement(
                    "Select * from usuarios where Usuario = ? and Contraseña = ?");
            consulta.setString(1, l_Usuario);
            consulta.setString(2, l_Contraseña);
            ResultSet res = consulta.executeQuery();

            while (res.next()) {
                resultado++;
            }
            res.close();
            consulta.close();
            conex.desconectar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudo consultar el usuario");
        }
        return resultado;
    }

    public void registrarPersona(Personas miPersona) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            personas.add(miPersona);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron agregar los datos");
        }
        try {
            sql = "Insert Into Personas(id, nombre, apellido, celular, f_nacimiento) "
                    + "Values(?,?,?,?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, miPersona.getId());
            pst.setString(2, miPersona.getNombre());
            pst.setString(3, miPersona.getApellido());
            pst.setString(4, miPersona.getCelular());
            pst.setString(5, miPersona.getFecha_Nacimiento());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "La Persona\n Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error:\n"
                    + "No se ha registrado correctamente", "Acceso denegado",
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

    public boolean validarPersona(String IdPersona) {
        boolean existe = false;
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select * from Personas where id=?";
            ps = con.prepareStatement(sql);
            ps.setString(1, IdPersona);
            ResultSet res = ps.executeQuery();
            if (res.absolute(1)) {
                existe = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return existe;
    }
}

//    public ArrayList<Personas> listaDePersonas() {
//        
//    }
