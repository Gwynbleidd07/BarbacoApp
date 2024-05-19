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
public class InventariosDAO {

    ArrayList<Inventarios> inventarios = new ArrayList<Inventarios>();

    public InventariosDAO() {
        inventarios = listaDeCarta();
        inventarios = listaDeAcompañante();
        inventarios = listaDeBebida();
        inventarios = listaDePostre();
    }

    public ArrayList<Inventarios> listaInventarios() {
        return inventarios;
    }

    public void registrarCarta(Inventarios misinventarios) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into inventario_carta(Cod_Carta, Cantidad) Values(?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, misinventarios.getCodigo());
            pst.setInt(2, misinventarios.getCantidad());
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

    public void registrarAcompañante(Inventarios misinventarios) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into inventario_acompañantes(Cod_Acompañante, Cantidad) Values(?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, misinventarios.getCodigo());
            pst.setInt(2, misinventarios.getCantidad());
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

    public void registrarBebida(Inventarios misinventarios) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into inventario_bebidas(Cod_bebida, Cantidad) Values(?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, misinventarios.getCodigo());
            pst.setInt(2, misinventarios.getCantidad());
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

    public void registrarPostre(Inventarios misinventarios) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into inventario_postres(Cod_Postre, Cantidad) Values(?,?)";
            pst = cn.prepareStatement(sql);
            pst.setString(1, misinventarios.getCodigo());
            pst.setInt(2, misinventarios.getCantidad());
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

    public ArrayList<Inventarios> listaDeCarta() {
        ArrayList<Inventarios> misinventarios = new ArrayList<Inventarios>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "SELECT inventario_carta.Cod_Carta, carta.Nombre, inventario_carta.Cantidad "
                    + "From inventario_carta, carta "
                    + "Where inventario_carta.Cod_Carta = carta.Cod_Carta;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Inventarios inventario = new Inventarios();
                inventario.setCodigo(res.getString("inventario_carta.Cod_Carta"));
                inventario.setNombre(res.getString("carta.Nombre"));
                inventario.setCantidad(res.getInt("inventario_carta.Cantidad"));
                misinventarios.add(inventario);
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
        return misinventarios;
    }

    public ArrayList<Inventarios> listaDeAcompañante() {
        ArrayList<Inventarios> misinventarios = new ArrayList<Inventarios>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "SELECT inventario_acompañantes.Cod_Acompañante, acompañantes.Nombre, inventario_acompañantes.Cantidad "
                    + "From inventario_acompañantes, acompañantes "
                    + "Where inventario_acompañantes.Cod_Acompañante = acompañantes.Cod_Acompañante;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Inventarios inventario = new Inventarios();
                inventario.setCodigo(res.getString("inventario_acompañantes.Cod_Acompañante"));
                inventario.setNombre(res.getString("acompañantes.Nombre"));
                inventario.setCantidad(res.getInt("inventario_acompañantes.Cantidad"));
                misinventarios.add(inventario);
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
        return misinventarios;
    }

    public ArrayList<Inventarios> listaDeBebida() {
        ArrayList<Inventarios> misinventarios = new ArrayList<Inventarios>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select inventario_bebidas.Cod_Bebida, bebidas.Nombre, inventario_bebidas.Cantidad "
                    + "from inventario_bebidas, bebidas "
                    + "Where inventario_bebidas.Cod_Bebida = bebidas.Cod_Bebida;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Inventarios inventario = new Inventarios();
                inventario.setCodigo(res.getString("inventario_bebidas.Cod_Bebida"));
                inventario.setNombre(res.getString("bebidas.Nombre"));
                inventario.setCantidad(res.getInt("inventario_bebidas.Cantidad"));
                misinventarios.add(inventario);
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
        return misinventarios;
    }

    public ArrayList<Inventarios> listaDePostre() {
        ArrayList<Inventarios> misinventarios = new ArrayList<Inventarios>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select inventario_postres.Cod_Postre, postres.Nombre, inventario_postres.Cantidad "
                    + "from inventario_postres, postres "
                    + "where inventario_postres.Cod_Postre = postres.Cod_Postre;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Inventarios inventario = new Inventarios();
                inventario.setCodigo(res.getString("inventario_postres.Cod_Postre"));
                inventario.setNombre(res.getString("postres.Nombre"));
                inventario.setCantidad(res.getInt("inventario_postres.Cantidad"));
                misinventarios.add(inventario);
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
        return misinventarios;
    }

    public boolean actualizarCarta(Inventarios inventarios) {
        BdConnection conex = new BdConnection();
        boolean respuesta1 = false;
        boolean respuesta = false;
        String sql = "";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conex.getConnection();
            sql = "Update inventario_carta set Cantidad = Cantidad + ? where Cod_Carta = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, inventarios.getCantidad());
            ps.setString(2, inventarios.getCodigo());
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

    public boolean actualizarAcompañante(Inventarios inventarios) {
        BdConnection conex = new BdConnection();
        boolean respuesta1 = false;
        boolean respuesta = false;
        String sql = "";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conex.getConnection();
            sql = "Update inventario_acompañantes set Cantidad = Cantidad + ? where Cod_Acompañante = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, inventarios.getCantidad());
            ps.setString(2, inventarios.getCodigo());
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

    public boolean actualizarBebida(Inventarios inventarios) {
        BdConnection conex = new BdConnection();
        boolean respuesta1 = false;
        boolean respuesta = false;
        String sql = "";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conex.getConnection();
            sql = "Update inventario_bebidas set Cantidad = Cantidad + ? where Cod_Bebida = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, inventarios.getCantidad());
            ps.setString(2, inventarios.getCodigo());
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

    public boolean actualizarPostre(Inventarios inventarios) {
        BdConnection conex = new BdConnection();
        boolean respuesta1 = false;
        boolean respuesta = false;
        String sql = "";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conex.getConnection();
            sql = "Update inventario_postres set Cantidad = Cantidad + ? where Cod_Postre = ?;";
            ps = con.prepareStatement(sql);
            ps.setInt(1, inventarios.getCantidad());
            ps.setString(2, inventarios.getCodigo());
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

    public ArrayList<Inventarios> listaDeCodigoElemento() {
        ArrayList<Inventarios> misinventarios = new ArrayList<Inventarios>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "SELECT DISTINCT Cod_Carta, '1' as Orden "
                    + "FROM Carta "
                    + "UNION ALL "
                    + "SELECT DISTINCT Cod_Acompañante, '2' as Orden "
                    + "FROM Acompañantes "
                    + "UNION ALL "
                    + "SELECT DISTINCT Cod_Bebida, '3' as Orden "
                    + "FROM bebidas "
                    + "UNION ALL "
                    + "SELECT DISTINCT Cod_Postre, '4' as Orden "
                    + "FROM postres "
                    + "ORDER BY Orden;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Inventarios inventario = new Inventarios();
                inventario.setCodigo(res.getString("Cod_Carta"));
                inventario.setCantidad(res.getInt("Orden"));
                misinventarios.add(inventario);
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
        return misinventarios;
    }

    public void actualizarCantidades() throws SQLException {
        actualizarInventarioCarta();
        actualizarInventarioAcompañantes();
        actualizarInventarioBebidas();
        actualizarInventarioPostres();
    }

    private void actualizarInventarioCarta() throws SQLException {
        String sql = "UPDATE inventario_carta ic "
                + "JOIN ( "
                + "    SELECT cp.Cod_Carta, SUM(cp.Cantidad) AS Cantidad_Pedida "
                + "    FROM carta_pedido cp "
                + "    JOIN pedidos p ON cp.Id_Pedidos = p.Id "
                + "    WHERE p.Estado != 'Finalizado' " // Condición agregada
                + "    GROUP BY cp.Cod_Carta "
                + ") AS carta_pedidos ON ic.Cod_Carta = carta_pedidos.Cod_Carta "
                + "SET ic.Cantidad = ic.Cantidad - carta_pedidos.Cantidad_Pedida;";
        ejecutarUpdate(sql);
    }

    private void actualizarInventarioAcompañantes() throws SQLException {
        String sql = "UPDATE inventario_acompañantes ia "
                + "JOIN ( "
                + "    SELECT ap.Cod_Acompañante, SUM(ap.Cantidad) AS Cantidad_Pedida "
                + "    FROM acompañantes_pedidos ap "
                + "    JOIN pedidos p ON ap.Id_Pedidos = p.Id "
                + "    WHERE p.Estado != 'Finalizado' " // Condición agregada
                + "    GROUP BY ap.Cod_Acompañante "
                + ") AS acompañantes_pedidos ON ia.Cod_Acompañante = acompañantes_pedidos.Cod_Acompañante "
                + "SET ia.Cantidad = ia.Cantidad - acompañantes_pedidos.Cantidad_Pedida;";
        ejecutarUpdate(sql);
    }

    private void actualizarInventarioBebidas() throws SQLException {
        String sql = "UPDATE inventario_bebidas ib "
                + "JOIN ( "
                + "    SELECT bp.Cod_Bebida, SUM(bp.Cantidad) AS Cantidad_Pedida "
                + "    FROM bebidas_pedidos bp "
                + "    JOIN pedidos p ON bp.Id_Pedidos = p.Id "
                + "    WHERE p.Estado != 'Finalizado' " // Condición agregada
                + "    GROUP BY bp.Cod_Bebida "
                + ") AS bebidas_pedidos ON ib.Cod_Bebida = bebidas_pedidos.Cod_Bebida "
                + "SET ib.Cantidad = ib.Cantidad - bebidas_pedidos.Cantidad_Pedida;";
        ejecutarUpdate(sql);
    }

    private void actualizarInventarioPostres() throws SQLException {
        String sql = "UPDATE inventario_postres ip "
                + "JOIN ( "
                + "    SELECT pp.Cod_Postre, SUM(pp.Cantidad) AS Cantidad_Pedida "
                + "    FROM postres_pedidos pp "
                + "    JOIN pedidos p ON pp.Id_Pedidos = p.Id "
                + "    WHERE p.Estado != 'Finalizado' " // Condición agregada
                + "    GROUP BY pp.Cod_Postre "
                + ") AS postres_pedidos ON ip.Cod_Postre = postres_pedidos.Cod_Postre "
                + "SET ip.Cantidad = ip.Cantidad - postres_pedidos.Cantidad_Pedida;";
        ejecutarUpdate(sql);
    }

    private void ejecutarUpdate(String sql) throws SQLException {
        BdConnection bdConnection = new BdConnection();
        Connection connection = bdConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);
        } finally {
            if (statement != null) {
                statement.close();
            }
            bdConnection.desconectar();
        }
    }
}
