/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Lombo
 */
public class Ventas_AnalisisDAO {

    ArrayList<Ventas_Analisis> ventas = new ArrayList<>();

    public Ventas_AnalisisDAO() {
        ventas = listaDeCartas();
        ventas = listaDeAcompañantes();
        ventas = listaDeBebidas();
        ventas = listaDePostres();
        ventas = listaDeTotal();
    }

    public ArrayList<Ventas_Analisis> listaVentas() {
        return ventas;
    }

    public ArrayList<Ventas_Analisis> listaDeCartas() {
        ArrayList<Ventas_Analisis> miscartas = new ArrayList<Ventas_Analisis>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select carta.Nombre, count(carta_pedido.Cod_Carta) as Vendido "
                    + "from carta, carta_pedido, pedidos "
                    + "where carta.Cod_Carta = carta_pedido.Cod_Carta "
                    + "and carta_pedido.Id_Pedidos = pedidos.Id "
                    + "group by carta.Nombre;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas_Analisis carta = new Ventas_Analisis();
                carta.setNombre(res.getString("carta.Nombre"));
                carta.setVendido(res.getInt("Vendido"));
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

    public ArrayList<Ventas_Analisis> listaDeAcompañantes() {
        ArrayList<Ventas_Analisis> miscartas = new ArrayList<Ventas_Analisis>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select acompañantes.Nombre, count(acompañantes_pedidos.Cod_Acompañante) as Vendido "
                    + "from acompañantes, acompañantes_pedidos, pedidos "
                    + "where acompañantes.Cod_Acompañante = acompañantes_pedidos.Cod_Acompañante "
                    + "and acompañantes_pedidos.Id_Pedidos = pedidos.Id "
                    + "group by acompañantes.Nombre;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas_Analisis carta = new Ventas_Analisis();
                carta.setNombre(res.getString("acompañantes.Nombre"));
                carta.setVendido(res.getInt("Vendido"));
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

    public ArrayList<Ventas_Analisis> listaDeBebidas() {
        ArrayList<Ventas_Analisis> miscartas = new ArrayList<Ventas_Analisis>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select bebidas.Nombre, count(bebidas_pedidos.Cod_Bebida) as Vendido "
                    + "from bebidas, bebidas_pedidos, pedidos "
                    + "where bebidas.Cod_Bebida = bebidas_pedidos.Cod_Bebida "
                    + "and bebidas_pedidos.Id_Pedidos = pedidos.Id "
                    + "group by bebidas.Nombre;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas_Analisis carta = new Ventas_Analisis();
                carta.setNombre(res.getString("bebidas.Nombre"));
                carta.setVendido(res.getInt("Vendido"));
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

    public ArrayList<Ventas_Analisis> listaDePostres() {
        ArrayList<Ventas_Analisis> miscartas = new ArrayList<Ventas_Analisis>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select postres.Nombre, count(postres_pedidos.Cod_Postre) as Vendido "
                    + "from postres, postres_pedidos, pedidos "
                    + "where Postres.Cod_Postre = postres_pedidos.Cod_Postre "
                    + "and postres_pedidos.Id_Pedidos = pedidos.Id "
                    + "group by postres.Nombre;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas_Analisis carta = new Ventas_Analisis();
                carta.setNombre(res.getString("postres.Nombre"));
                carta.setVendido(res.getInt("Vendido"));
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

    public ArrayList<Ventas_Analisis> listaDeTotal() {
        ArrayList<Ventas_Analisis> miscartas = new ArrayList<Ventas_Analisis>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select sum(Valor_Cuenta) as Valor_Cuenta from pedidos";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas_Analisis carta = new Ventas_Analisis();
                carta.setValor(res.getInt("Valor_Cuenta"));
                miscartas.add(carta);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puedo consultar los datos del total");
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

    public ArrayList<Ventas_Analisis> buscarCarta(String busqueda, String busqueda1) {
        ArrayList<Ventas_Analisis> mispedidos = new ArrayList<Ventas_Analisis>();
        String sql = "Select carta.Nombre, count(carta_pedido.Cod_Carta) as Vendido "
                + "from carta, carta_pedido, pedidos "
                + "where carta.Cod_Carta = carta_pedido.Cod_Carta "
                + "and carta_pedido.Id_Pedidos = pedidos.Id "
                + "and pedidos.Fecha >= '" + busqueda + "' and pedidos.Fecha <= '" + busqueda1 + "' "
                + "group by carta.Nombre;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas_Analisis pedido = new Ventas_Analisis();
                pedido.setNombre(res.getString("carta.Nombre"));
                pedido.setVendido(res.getInt("Vendido"));
                mispedidos.add(pedido);
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
        return mispedidos;
    }

    public ArrayList<Ventas_Analisis> buscarAcompañante(String busqueda, String busqueda1) {
        ArrayList<Ventas_Analisis> mispedidos = new ArrayList<Ventas_Analisis>();
        String sql = "Select acompañantes.Nombre, count(acompañantes_pedidos.Cod_Acompañante) as Vendido "
                + "from acompañantes, acompañantes_pedidos, pedidos "
                + "where acompañantes.Cod_Acompañante = acompañantes_pedidos.Cod_Acompañante\n"
                + "and acompañantes_pedidos.Id_Pedidos = pedidos.Id "
                + "and pedidos.Fecha >= '" + busqueda + "' and pedidos.Fecha <= '" + busqueda1 + "' "
                + "group by acompañantes.Nombre;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas_Analisis pedido = new Ventas_Analisis();
                pedido.setNombre(res.getString("acompañantes.Nombre"));
                pedido.setVendido(res.getInt("Vendido"));
                mispedidos.add(pedido);
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
        return mispedidos;
    }

    public ArrayList<Ventas_Analisis> buscarBebida(String busqueda, String busqueda1) {
        ArrayList<Ventas_Analisis> mispedidos = new ArrayList<Ventas_Analisis>();
        String sql = "Select bebidas.Nombre, count(bebidas_pedidos.Cod_Bebida) as Vendido "
                + "from bebidas, bebidas_pedidos, pedidos "
                + "where bebidas.Cod_Bebida = bebidas_pedidos.Cod_Bebida "
                + "and bebidas_pedidos.Id_Pedidos = pedidos.Id "
                + "and pedidos.Fecha >= '" + busqueda + "' and pedidos.Fecha <= '" + busqueda1 + "' "
                + "group by bebidas.Nombre;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas_Analisis pedido = new Ventas_Analisis();
                pedido.setNombre(res.getString("bebidas.Nombre"));
                pedido.setVendido(res.getInt("Vendido"));
                mispedidos.add(pedido);
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
        return mispedidos;
    }

    public ArrayList<Ventas_Analisis> buscarPostre(String busqueda, String busqueda1) {
        ArrayList<Ventas_Analisis> mispedidos = new ArrayList<Ventas_Analisis>();
        String sql = "Select postres.Nombre, count(postres_pedidos.Cod_Postre) as Vendido "
                + "from postres, postres_pedidos, pedidos "
                + "where Postres.Cod_Postre = postres_pedidos.Cod_Postre "
                + "and postres_pedidos.Id_Pedidos = pedidos.Id \n"
                + "and pedidos.Fecha >= '" + busqueda + "' and pedidos.Fecha <= '" + busqueda1 + "' "
                + "group by postres.Nombre;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas_Analisis pedido = new Ventas_Analisis();
                pedido.setNombre(res.getString("postres.Nombre"));
                pedido.setVendido(res.getInt("Vendido"));
                mispedidos.add(pedido);
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
        return mispedidos;
    }

    public ArrayList<Ventas_Analisis> buscarTotal(String busqueda, String busqueda1) {
        ArrayList<Ventas_Analisis> mispedidos = new ArrayList<Ventas_Analisis>();
        String sql = "Select sum(Valor_Cuenta) as Valor_Cuenta "
                + "from pedidos "
                + "where Fecha >= '" + busqueda + "' and Fecha <= '" + busqueda1 + "' ";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas_Analisis pedido = new Ventas_Analisis();
                pedido.setValor(res.getInt("Valor_Cuenta"));
                mispedidos.add(pedido);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puedo consultar los datos del total");
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mispedidos;
    }
}
