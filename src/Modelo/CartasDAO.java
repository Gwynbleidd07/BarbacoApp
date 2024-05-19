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
public class CartasDAO {

    ArrayList<Cartas> cartas = new ArrayList<Cartas>();

    public CartasDAO() {
        cartas = listaDeProteina();
        cartas = listaDeAcompañante();
        cartas = listaDeBebida();
        cartas = listaDePostre();
    }

    public ArrayList<Cartas> listaCartas() {
        return cartas;
    }

    public void registrarProteina(Cartas miscartas) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into carta(Cod_Carta, Nombre, Descripcion, Precio) Values(?,?,?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, miscartas.getCodigo());
            pst.setString(2, miscartas.getNombre());
            pst.setString(3, miscartas.getDescripcion());
            pst.setInt(4, miscartas.getPrecio());
            pst.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que la carta ya haya estado registrada en el sistema", "Acceso denegado",
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

    public void registrarAcompañante(Cartas miscartas) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into acompañantes(Cod_Acompañante, Nombre, Precio) Values(?,?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, miscartas.getCodigo());
            pst.setString(2, miscartas.getNombre());
            pst.setInt(3, miscartas.getPrecio());
            pst.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el acompañante ya haya estado registrada en el sistema", "Acceso denegado",
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

    public void registrarBebida(Cartas miscartas) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into bebidas(Cod_Bebida, Nombre, Precio) Values(?,?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, miscartas.getCodigo());
            pst.setString(2, miscartas.getNombre());
            pst.setInt(3, miscartas.getPrecio());
            pst.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que la bebida ya haya estado registrada en el sistema", "Acceso denegado",
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

    public void registrarPostre(Cartas miscartas) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into postres(Cod_Postre, Nombre, Precio) Values(?,?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, miscartas.getCodigo());
            pst.setString(2, miscartas.getNombre());
            pst.setInt(3, miscartas.getPrecio());
            pst.executeUpdate();
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el postre ya haya estado registrada en el sistema", "Acceso denegado",
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

    public ArrayList<Cartas> listaDeProteina() {
        ArrayList<Cartas> miscartas = new ArrayList<Cartas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select * from carta";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Cartas carta = new Cartas();
                carta.setCodigo(res.getString("Cod_Carta"));
                carta.setNombre(res.getString("Nombre"));
                carta.setDescripcion(res.getString("Descripcion"));
                carta.setPrecio(res.getInt("Precio"));
                miscartas.add(carta);
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
        return miscartas;
    }
    
    public ArrayList<Cartas> listaDeAcompañante() {
        ArrayList<Cartas> miscartas = new ArrayList<Cartas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select * from acompañantes";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Cartas carta = new Cartas();
                carta.setCodigo(res.getString("Cod_Acompañante"));
                carta.setNombre(res.getString("Nombre"));
                carta.setPrecio(res.getInt("Precio"));
                miscartas.add(carta);
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
        return miscartas;
    }
    
    public ArrayList<Cartas> listaDeBebida() {
        ArrayList<Cartas> miscartas = new ArrayList<Cartas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select * from bebidas";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Cartas carta = new Cartas();
                carta.setCodigo(res.getString("Cod_Bebida"));
                carta.setNombre(res.getString("Nombre"));
                carta.setPrecio(res.getInt("Precio"));
                miscartas.add(carta);
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
        return miscartas;
    }
    
    public ArrayList<Cartas> listaDePostre() {
        ArrayList<Cartas> miscartas = new ArrayList<Cartas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select * from postres";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Cartas carta = new Cartas();
                carta.setCodigo(res.getString("Cod_Postre"));
                carta.setNombre(res.getString("Nombre"));
                carta.setPrecio(res.getInt("Precio"));
                miscartas.add(carta);
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
        return miscartas;
    }
    
    public boolean actualizarProteina(Cartas cartas) {
        BdConnection conex = new BdConnection();
        boolean respuesta1 = false;
        boolean respuesta = false;
        String sql = "";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conex.getConnection();
            sql = "Update carta set Nombre = ?, Descripcion = ?, Precio = ? where Cod_Carta = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, cartas.getNombre());
            ps.setString(2, cartas.getDescripcion());
            ps.setInt(3, cartas.getPrecio());
            ps.setString(4,cartas.getCodigo());
            respuesta1 = ps.executeUpdate() == 1;

            if (respuesta1 == true) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return respuesta;
    }
    
    public boolean actualizarAcompañante(Cartas cartas) {
        BdConnection conex = new BdConnection();
        boolean respuesta1 = false;
        boolean respuesta = false;
        String sql = "";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conex.getConnection();
            sql = "Update acompañantes set Nombre = ?, Precio = ? where Cod_Acompañante = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, cartas.getNombre());
            ps.setInt(2, cartas.getPrecio());
            ps.setString(3,cartas.getCodigo());
            respuesta1 = ps.executeUpdate() == 1;

            if (respuesta1 == true) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return respuesta;
    }
    
    public boolean actualizarBebida(Cartas cartas) {
        BdConnection conex = new BdConnection();
        boolean respuesta1 = false;
        boolean respuesta = false;
        String sql = "";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conex.getConnection();
            sql = "Update bebidas set Nombre = ?, Precio = ? where Cod_Bebida = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, cartas.getNombre());
            ps.setInt(2, cartas.getPrecio());
            ps.setString(3,cartas.getCodigo());
            respuesta1 = ps.executeUpdate() == 1;

            if (respuesta1 == true) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return respuesta;
    }
    
    public boolean actualizarPostre(Cartas cartas) {
        BdConnection conex = new BdConnection();
        boolean respuesta1 = false;
        boolean respuesta = false;
        String sql = "";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conex.getConnection();
            sql = "Update postres set Nombre = ?, Precio = ? where Cod_Postre = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, cartas.getNombre());
            ps.setInt(2, cartas.getPrecio());
            ps.setString(3,cartas.getCodigo());
            respuesta1 = ps.executeUpdate() == 1;

            if (respuesta1 == true) {
                respuesta = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return respuesta;
    }
}
