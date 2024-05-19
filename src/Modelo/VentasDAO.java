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
public class VentasDAO {

    ArrayList<Personas> empleados = new ArrayList<>();
    ArrayList<Ventas> ventas = new ArrayList<>();

    public VentasDAO() {
        empleados = listaDeEmpleados();
        ventas = listaDePedidos();
        ventas = listaDeCarta();
        ventas = listaDeAcompañantes();
        ventas = listaDeBebidas();
        ventas = listaDePostres();
    }

    public ArrayList<Personas> listaEmpleado() {
        return empleados;
    }

    public ArrayList<Ventas> listaVentas() {
        return ventas;
    }

    public void registrarPedido(Ventas misventas) {
        String sql = "";
        String sql1 = "";
        String sql2 = "";
        String sql3 = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        PreparedStatement pst1 = null;
        PreparedStatement pst2 = null;
        PreparedStatement pst3 = null;
        try {
            sql = " Insert into pedidos(Id, Fecha, Id_Mesa, Id_Mesero) Values (?, ?, ?, ?);";
            pst = cn.prepareStatement(sql);
            pst.setInt(1, misventas.getFactura());
            pst.setString(2, misventas.getFecha());
            pst.setString(3, misventas.getMesa());
            pst.setString(4, misventas.getMesero());
            pst.executeUpdate();

            sql1 = "Insert into carta_pedido(Id_Pedidos, Cod_Carta, Cantidad) Values (?, ?, ?);";
            pst1 = cn.prepareStatement(sql1);
            pst1.setInt(1, misventas.getFactura());
            pst1.setString(2, misventas.getCarta());
            pst1.setInt(3, misventas.getCantidadCarta());
            pst1.executeUpdate();

            sql2 = "Insert into acompañantes_pedidos(Id_Pedidos, Cod_Acompañante, Cantidad) Values (?, ?, ?);";
            pst2 = cn.prepareStatement(sql2);
            pst2.setInt(1, misventas.getFactura());
            pst2.setString(2, misventas.getAcompañantes());
            pst2.setInt(3, misventas.getCantidadAcompañantes());
            pst2.executeUpdate();

            sql3 = "Insert into bebidas_pedidos(Id_Pedidos, Cod_Bebida, Cantidad) Values (?, ?, ?);";
            pst3 = cn.prepareStatement(sql3);
            pst3.setInt(1, misventas.getFactura());
            pst3.setString(2, misventas.getBebidas());
            pst3.setInt(3, misventas.getCantidadBebidas());
            pst3.executeUpdate();

            JOptionPane.showMessageDialog(null, "El pedido  Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el pedido ya haya estado registrada en el sistema", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                pst.close();
                pst1.close();
                pst2.close();
                pst3.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void registrarCarta(Ventas misventas) {
        String sql1 = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst1 = null;
        try {
            sql1 = "Insert into carta_pedido(Id_Pedidos, Cod_Carta, Cantidad) Values (?, ?, ?);";
            pst1 = cn.prepareStatement(sql1);
            pst1.setInt(1, misventas.getFactura());
            pst1.setString(2, misventas.getCarta());
            pst1.setInt(3, misventas.getCantidadCarta());
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(null, "El plato  Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el pedido no este estado registrado en el sistema", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                pst1.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void registrarAcompañantes(Acompañantes misventas) {
        String sql2 = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst2 = null;
        try {
            sql2 = "Insert into acompañantes_pedidos(Id_Pedidos, Cod_Acompañante, Cantidad) Values (?, ?, ?);";
            pst2 = cn.prepareStatement(sql2);
            pst2.setInt(1, misventas.getFactura());
            pst2.setString(2, misventas.getAcompañantes());
            pst2.setInt(3, misventas.getCantidadAcompañantes());
            pst2.executeUpdate();
            JOptionPane.showMessageDialog(null, "El acompañante  Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el pedido no este estado registrado en el sistema", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                pst2.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void registrarBebidas(Bebidas misbebidas) {
        String sql3 = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst3 = null;
        try {
            sql3 = "Insert into bebidas_pedidos(Id_Pedidos, Cod_Bebida, Cantidad) Values (?, ?, ?);";
            pst3 = cn.prepareStatement(sql3);
            pst3.setInt(1, misbebidas.getFactura());
            pst3.setString(2, misbebidas.getBebidas());
            pst3.setInt(3, misbebidas.getCantidadBebidas());
            pst3.executeUpdate();
            JOptionPane.showMessageDialog(null, "La bebida  Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el pedido no este estado registrado en el sistema", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                pst3.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void registrarPostre(Postres misventas) {
        String sql4 = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst4 = null;
        try {
            sql4 = "Insert into postres_pedidos(Id_Pedidos, Cod_Postre, Cantidad) Values (?, ?, ?);";
            pst4 = cn.prepareStatement(sql4);
            pst4.setInt(1, misventas.getFactura());
            pst4.setString(2, misventas.getPostres());
            pst4.setInt(3, misventas.getCantidadPostres());
            pst4.executeUpdate();
            JOptionPane.showMessageDialog(null, "El postre  Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que la persona ya haya estado registrada en el sistema", "Acceso denegado",
                    JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                pst4.close();
                cn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Personas> listaDeEmpleados() {
        ArrayList<Personas> misempleados = new ArrayList<Personas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "SELECT personas.Id, CONCAT(personas.Nombre, ' ', personas.Apellido) AS Nombres  "
                    + "FROM Personas, personal, cargo, cargo_personal "
                    + "WHERE personas.Id = personal.Id_Personal "
                    + "AND cargo.Codigo = cargo_personal.Cod_Cargo "
                    + "AND cargo_personal.Id_Personal = personal.Id_Personal "
                    + "AND (cargo.Nombre = 'Mesero') "
                    + "ORDER BY personas.Nombre asc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Personas empleado = new Personas();
                empleado.setId(res.getString("personas.Id"));
                empleado.setNombre(res.getString("Nombres"));
                misempleados.add(empleado);
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
        return misempleados;
    }

    public ArrayList<Ventas> listaDePedidos() {
        ArrayList<Ventas> mispedidos = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select pedidos.Id, pedidos.Fecha, pedidos.Id_Mesa, personas.Nombre, pedidos.Valor_Cuenta "
                    + "From pedidos, personas, personal "
                    + "Where personas.Id = personal.Id_Personal "
                    + "And personal.Id_Personal = pedidos.Id_Mesero "
                    + "Order by pedidos.Id desc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas pedido = new Ventas();
                pedido.setFactura(res.getInt("pedidos.Id"));
                pedido.setFecha(res.getString("pedidos.Fecha"));
                pedido.setMesa(res.getString("pedidos.Id_Mesa"));
                pedido.setMesero(res.getString("personas.Nombre"));
                pedido.setValorCuenta(res.getInt("pedidos.Valor_Cuenta"));
                mispedidos.add(pedido);
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
        return mispedidos;
    }
    
    public ArrayList<Ventas> listaDePedidos1() {
        ArrayList<Ventas> mispedidos = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select pedidos.Id, pedidos.Fecha, pedidos.Id_Mesa, personas.Nombre, pedidos.Valor_Cuenta "
                    + "From pedidos, personas, personal, reservas "
                    + "Where personas.Id = personal.Id_Personal "
                    + "And personal.Id_Personal = pedidos.Id_Mesero "
                    + "And pedidos.Id = reservas.Id_Pedido "
                    + "Order by pedidos.Id desc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas pedido = new Ventas();
                pedido.setFactura(res.getInt("pedidos.Id"));
                pedido.setFecha(res.getString("pedidos.Fecha"));
                pedido.setMesa(res.getString("pedidos.Id_Mesa"));
                pedido.setMesero(res.getString("personas.Nombre"));
                pedido.setValorCuenta(res.getInt("pedidos.Valor_Cuenta"));
                mispedidos.add(pedido);
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
        return mispedidos;
    }

    public ArrayList<Ventas> listaDeCarta() {
        ArrayList<Ventas> miscartas = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select carta_pedido.Id_Pedidos, carta.Nombre, "
                    + "Sum(carta_pedido.Cantidad) as Cantidad, carta.Precio, "
                    + "Sum(carta.Precio * carta_pedido.Cantidad) As Valor "
                    + "From carta_pedido, carta "
                    + "where carta.Cod_Carta = carta_pedido.Cod_Carta "
                    + "Group by carta_pedido.Id, carta.Precio "
                    + "Order by carta_pedido.Id_Pedidos desc";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas carta = new Ventas();
                carta.setFactura(res.getInt("carta_pedido.Id_Pedidos"));
                carta.setCarta(res.getString("carta.Nombre"));
                carta.setCantidadCarta(res.getInt("Cantidad"));
                carta.setPrecio(res.getInt("carta.Precio"));
                carta.setValorCuenta(res.getInt("Valor"));
                miscartas.add(carta);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se puedo consultar los datos de Carta");
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

    public ArrayList<Ventas> listaDeAcompañantes() {
        ArrayList<Ventas> misacompañantes = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "SELECT acompañantes_pedidos.Id_Pedidos, acompañantes.Nombre, acompañantes_pedidos.Cantidad, "
                    + "       acompañantes.Precio, SUM(acompañantes.Precio * acompañantes_pedidos.Cantidad) AS Valor "
                    + "FROM acompañantes_pedidos "
                    + "JOIN acompañantes ON acompañantes_pedidos.Cod_Acompañante = acompañantes.Cod_Acompañante "
                    + "JOIN pedidos ON acompañantes_pedidos.Id_Pedidos = pedidos.Id "
                    + "JOIN Personal ON pedidos.Id_Mesero = Personal.Id_Personal "
                    + "JOIN Personas ON Personal.Id_Personal = Personas.Id "
                    + "GROUP BY acompañantes_pedidos.Id_Pedidos, acompañantes.Nombre, acompañantes_pedidos.Cantidad, acompañantes.Precio "
                    + "ORDER BY acompañantes_pedidos.Id_Pedidos desc";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas acompañante = new Ventas();
                acompañante.setFactura(res.getInt("acompañantes_pedidos.Id_Pedidos"));
                acompañante.setAcompañantes(res.getString("acompañantes.Nombre"));
                acompañante.setCantidadAcompañantes(res.getInt("Cantidad"));
                acompañante.setPrecio(res.getInt("acompañantes.Precio"));
                acompañante.setValorCuenta(res.getInt("Valor"));
                misacompañantes.add(acompañante);
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
        return misacompañantes;
    }

    public ArrayList<Ventas> listaDeBebidas() {
        ArrayList<Ventas> misbebidas = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select bebidas_pedidos.Id_Pedidos, Bebidas.Nombre, Sum(Bebidas_Pedidos.Cantidad) As Cantidad, "
                    + "bebidas.Precio, Sum(bebidas_pedidos.Cantidad * bebidas.Precio) As Valor "
                    + "From pedidos, bebidas, bebidas_pedidos "
                    + "Where pedidos.Id = bebidas_pedidos.Id_Pedidos "
                    + "And bebidas.Cod_Bebida = bebidas_pedidos.Cod_Bebida  "
                    + "Group by pedidos.Id, Bebidas.Nombre, bebidas.Precio "
                    + "Order by pedidos.Id desc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas bebida = new Ventas();
                bebida.setFactura(res.getInt("bebidas_pedidos.Id_Pedidos"));
                bebida.setBebidas(res.getString("Bebidas.Nombre"));
                bebida.setCantidadBebidas(res.getInt("Cantidad"));
                bebida.setPrecio(res.getInt("bebidas.Precio"));
                bebida.setValorCuenta(res.getInt("Valor"));
                misbebidas.add(bebida);
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
        return misbebidas;

    }

    public ArrayList<Ventas> listaDePostres() {
        ArrayList<Ventas> mispostres = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select postres_pedidos.Id_Pedidos, postres.Nombre, SUM(postres_pedidos.Cantidad) as Cantidad, "
                    + "postres.Precio, Sum(postres_pedidos.Cantidad * postres.Precio) as Valor "
                    + "From pedidos, postres, postres_pedidos "
                    + "Where pedidos.Id = postres_pedidos.Id_Pedidos "
                    + "And postres.Cod_Postre = postres_pedidos.Cod_Postre "
                    + "Group By Pedidos.Id, Fecha, postres.Nombre, postres.Precio  "
                    + "Order by postres_pedidos.Id_Pedidos desc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas postre = new Ventas();
                postre.setFactura(res.getInt("postres_pedidos.Id_Pedidos"));
                postre.setPostre(res.getString("postres.Nombre"));
                postre.setCantidadPostre(res.getInt("Cantidad"));
                postre.setPrecio(res.getInt("postres.Precio"));
                postre.setValorCuenta(res.getInt("Valor"));
                mispostres.add(postre);
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
        return mispostres;
    }

    public int buscarUltimoId() {
        String sql = "SELECT MAX(id) as Ultimo FROM pedidos;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        int ultimoId = 0;
        try {
            Statement st = conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                ultimoId = res.getInt("Ultimo") + 1;
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
        return ultimoId;
    }
    
    public int buscarUltimoId1() {
        String sql = "SELECT MAX(id) as Ultimo FROM pedidos;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        int ultimoId = 0;
        try {
            Statement st = conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            if (res.next()) {
                ultimoId = res.getInt("Ultimo");
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
        return ultimoId;
    }

    public ArrayList<Ventas> buscarFactura(String busqueda) {
        ArrayList<Ventas> mispedidos = new ArrayList<Ventas>();
        String sql = "Select pedidos.Id, pedidos.Fecha, pedidos.Id_Mesa, personas.Nombre, pedidos.Valor_Cuenta "
                + "From pedidos, personas, personal "
                + "Where personas.Id = personal.Id_Personal "
                + "And personal.Id_Personal = pedidos.Id_Mesero "
                + "And pedidos.Id like '" + busqueda + "%' "
                + " Order by pedidos.Id desc";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas pedido = new Ventas();
                pedido.setFactura(res.getInt("pedidos.Id"));
                pedido.setFecha(res.getString("pedidos.Fecha"));
                pedido.setMesa(res.getString("pedidos.Id_Mesa"));
                pedido.setMesero(res.getString("personas.Nombre"));
                pedido.setValorCuenta(res.getInt("pedidos.Valor_Cuenta"));
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

    public ArrayList<Ventas> buscarCarta1(String busqueda) {
        ArrayList<Ventas> miscartas = new ArrayList<Ventas>();
        String sql = "Select carta_pedido.Id_Pedidos, carta.Nombre, "
                + "Sum(carta_pedido.Cantidad) as Cantidad, carta.Precio, "
                + "Sum(carta.Precio * carta_pedido.Cantidad) As Valor "
                + "From carta_pedido, carta, pedidos, personas, personal "
                + "where carta.Cod_Carta = carta_pedido.Cod_Carta "
                + "And pedidos.Id = carta_pedido.Id_Pedidos "
                + "And personas.Id = personal.Id_Personal "
                + "And personal.Id_Personal = pedidos.Id_Mesero "
                + "And pedidos.Id like '" + busqueda + "%' "
                + "Group by carta_pedido.Id, carta.Precio "
                + "Order by carta_pedido.Id desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas carta = new Ventas();
                carta.setFactura(res.getInt("carta_pedido.Id_Pedidos"));
                carta.setCarta(res.getString("carta.Nombre"));
                carta.setCantidadCarta(res.getInt("Cantidad"));
                carta.setPrecio(res.getInt("carta.Precio"));
                carta.setValorCuenta(res.getInt("Valor"));
                miscartas.add(carta);
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
        return miscartas;
    }

    public ArrayList<Ventas> buscarAcompañantes1(String busqueda) {
        ArrayList<Ventas> misacompañantes = new ArrayList<Ventas>();
        String sql = "SELECT acompañantes_pedidos.Id_Pedidos, acompañantes.Nombre, acompañantes_pedidos.Cantidad, acompañantes.Precio, "
                + "SUM(acompañantes.Precio * acompañantes_pedidos.Cantidad) AS Valor "
                + "FROM acompañantes_pedidos "
                + "JOIN acompañantes ON acompañantes_pedidos.Cod_Acompañante = acompañantes.Cod_Acompañante "
                + "JOIN pedidos ON acompañantes_pedidos.Id_Pedidos = pedidos.Id  "
                + "JOIN Personal ON pedidos.Id_Mesero = Personal.Id_Personal "
                + "JOIN Personas ON Personal.Id_Personal = Personas.Id "
                + "WHERE pedidos.Id LIKE '" + busqueda + "%' "
                + "GROUP BY acompañantes_pedidos.Id_Pedidos, acompañantes.Nombre, acompañantes_pedidos.Cantidad, acompañantes.Precio "
                + "ORDER BY acompañantes_pedidos.Id_Pedidos desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas acompañante = new Ventas();
                acompañante.setFactura(res.getInt("acompañantes_pedidos.Id_Pedidos"));
                acompañante.setAcompañantes(res.getString("acompañantes.Nombre"));
                acompañante.setCantidadAcompañantes(res.getInt("acompañantes_pedidos.Cantidad"));
                acompañante.setPrecio(res.getInt("acompañantes.Precio"));
                acompañante.setValorCuenta(res.getInt("Valor"));
                misacompañantes.add(acompañante);
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
        return misacompañantes;
    }

    public ArrayList<Ventas> buscarBebidas1(String busqueda) {
        ArrayList<Ventas> misbebidas = new ArrayList<Ventas>();
        String sql = "Select bebidas_pedidos.Id_Pedidos, Bebidas.Nombre, Sum(Bebidas_Pedidos.Cantidad) As Cantidad, "
                + "bebidas.Precio, Sum(bebidas_pedidos.Cantidad * bebidas.Precio) As Valor "
                + "From pedidos, bebidas, bebidas_pedidos, personas, personal "
                + "Where pedidos.Id = bebidas_pedidos.Id_Pedidos "
                + "And bebidas.Cod_Bebida = bebidas_pedidos.Cod_Bebida "
                + "And personas.Id = personal.Id_Personal "
                + "And personal.Id_Personal = pedidos.Id_Mesero "
                + "And pedidos.Id like '" + busqueda + "%' "
                + "Group by pedidos.Id, Bebidas.Nombre, bebidas.Precio "
                + "Order by pedidos.Id desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas bebida = new Ventas();
                bebida.setFactura(res.getInt("bebidas_pedidos.Id_Pedidos"));
                bebida.setBebidas(res.getString("Bebidas.Nombre"));
                bebida.setCantidadBebidas(res.getInt("Cantidad"));
                bebida.setPrecio(res.getInt("bebidas.Precio"));
                bebida.setValorCuenta(res.getInt("Valor"));
                misbebidas.add(bebida);
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
        return misbebidas;
    }

    public ArrayList<Ventas> buscarPostres1(String busqueda) {
        ArrayList<Ventas> mispostres = new ArrayList<Ventas>();
        String sql = "Select postres_pedidos.Id_Pedidos, postres.Nombre, SUM(postres_pedidos.Cantidad) as Cantidad, "
                + "postres.Precio, Sum(postres_pedidos.Cantidad * postres.Precio) as Valor "
                + "From pedidos, postres, postres_pedidos, personas, personal "
                + "Where pedidos.Id = postres_pedidos.Id_Pedidos "
                + "And postres.Cod_Postre = postres_pedidos.Cod_Postre "
                + "And personas.Id = personal.Id_Personal "
                + "And personal.Id_Personal = pedidos.Id_Mesero "
                + "And pedidos.Id like '" + busqueda + "%' "
                + "Group By Pedidos.Id, Fecha, postres.Nombre, postres.Precio  "
                + "Order by postres_pedidos.Id_Pedidos desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas postre = new Ventas();
                postre.setFactura(res.getInt("postres_pedidos.Id_Pedidos"));
                postre.setPostre(res.getString("postres.Nombre"));
                postre.setCantidadPostre(res.getInt("Cantidad"));
                postre.setPrecio(res.getInt("postres.Precio"));
                postre.setValorCuenta(res.getInt("Valor"));
                mispostres.add(postre);
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
        return mispostres;
    }

    public ArrayList<Ventas> buscarPedido(String busqueda, String busqueda1, String busqueda2) {
        ArrayList<Ventas> mispedidos = new ArrayList<Ventas>();
        String sql = "Select pedidos.Id, pedidos.Fecha, pedidos.Id_Mesa, personas.Nombre, pedidos.Valor_Cuenta "
                + "From pedidos, personas, personal "
                + "Where personas.Id = personal.Id_Personal "
                + "And personal.Id_Personal = pedidos.Id_Mesero "
                + "And (pedidos.Fecha like '" + busqueda + "%' "
                + "And pedidos.Id_Mesa like '" + busqueda1 + "%' "
                + "And personas.Nombre like '" + busqueda2 + "%' "
                + " Order by pedidos.Id desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas pedido = new Ventas();
                pedido.setFactura(res.getInt("pedidos.Id"));
                pedido.setFecha(res.getString("pedidos.Fecha"));
                pedido.setMesa(res.getString("pedidos.Id_Mesa"));
                pedido.setMesero(res.getString("personas.Nombre"));
                pedido.setValorCuenta(res.getInt("pedidos.Valor_Cuenta"));
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

    public ArrayList<Ventas> buscarCarta(String busqueda, String busqueda1, String busqueda2, String busqueda3) {
        ArrayList<Ventas> miscartas = new ArrayList<Ventas>();
        String sql = "Select carta_pedido.Id_Pedidos, carta.Nombre, Sum(carta_pedido.Cantidad) as Cantidad, carta.Precio, Sum(carta.Precio * carta_pedido.Cantidad) As Valor "
                + "From carta_pedido, carta, pedidos, personas, personal "
                + "where carta.Cod_Carta = carta_pedido.Cod_Carta "
                + "And pedidos.Id = carta_pedido.Id_Pedidos "
                + "And personas.Id = personal.Id_Personal "
                + "And personal.Id_Personal = pedidos.Id_Mesero "
                + "And (pedidos.Id like '" + busqueda + "% "
                + "and pedidos.Fecha like '" + busqueda1 + "% "
                + "and pedidos.Id_Mesa like '" + busqueda2 + "% "
                + "and personas.Nombre like '" + busqueda3 + "%) "
                + "Group by carta_pedido.Id, carta.Precio "
                + "Order by carta_pedido.Id desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas carta = new Ventas();
                carta.setFactura(res.getInt("carta_pedido.Id_Pedidos"));
                carta.setCarta(res.getString("carta.Nombre"));
                carta.setCantidadCarta(res.getInt("Cantidad"));
                carta.setPrecio(res.getInt("carta.Precio"));
                carta.setValorCuenta(res.getInt("Valor"));
                miscartas.add(carta);
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
        return miscartas;
    }

    public ArrayList<Ventas> buscarAcompañantes(String busqueda, String busqueda1, String busqueda2, String busqueda3) {
        ArrayList<Ventas> misacompañantes = new ArrayList<Ventas>();
        String sql = "SELECT acompañantes_pedidos.Id_Pedidos, acompañantes.Nombre, acompañantes_pedidos.Cantidad, acompañantes.Precio "
                + "SUM(acompañantes.Precio * acompañantes_pedidos.Cantidad) AS Valor "
                + "FROM acompañantes_pedidos "
                + "JOIN acompañantes ON acompañantes_pedidos.Cod_Acompañante = acompañantes.Cod_Acompañante "
                + "JOIN pedidos ON acompañantes_pedidos.Id_Pedidos = pedidos.Id  "
                + "JOIN Personal ON pedidos.Id_Mesero = Personal.Id_Personal "
                + "JOIN Personas ON Personal.Id_Personal = Personas.Id "
                + "WHERE pedidos.Id LIKE '" + busqueda + "%' "
                + "AND personas.Nombre LIKE '" + busqueda1 + "%' "
                + "AND pedidos.Fecha LIKE '" + busqueda2 + "%' "
                + "AND pedidos.Id_Mesa LIKE '" + busqueda3 + "%' "
                + "GROUP BY acompañantes_pedidos.Id_Pedidos, acompañantes.Nombre, acompañantes_pedidos.Cantidad "
                + "ORDER BY acompañantes_pedidos.Id_Pedidos desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas acompañante = new Ventas();
                acompañante.setFactura(res.getInt("acompañantes_pedidos.Id_Pedidos"));
                acompañante.setAcompañantes(res.getString("acompañantes.Nombre"));
                acompañante.setCantidadAcompañantes(res.getInt("acompañantes_pedidos.Cantidad"));
                acompañante.setPrecio(res.getInt("acompañantes.Precio"));
                acompañante.setValorCuenta(res.getInt("Valor"));
                misacompañantes.add(acompañante);
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
        return misacompañantes;
    }

    public ArrayList<Ventas> buscarBebida(String busqueda, String busqueda1, String busqueda2, String busqueda3) {
        ArrayList<Ventas> misbebidas = new ArrayList<Ventas>();
        String sql = "Select bebidas_pedidos.Id_Pedidos, Bebidas.Nombre, Sum(Bebidas_Pedidos.Cantidad) As Cantidad, "
                + "bebidas.Precio, Sum(bebidas_pedidos.Cantidad * bebidas.Precio) As Valor "
                + "From pedidos, bebidas, bebidas_pedidos, personas, personal "
                + "Where pedidos.Id = bebidas_pedidos.Id_Pedidos "
                + "And bebidas.Cod_Bebida = bebidas_pedidos.Cod_Bebida "
                + "And personas.Id = personal.Id_Personal "
                + "And personal.Id_Personal = pedidos.Id_Mesero "
                + "And ( pedidos.Id like '" + busqueda + "%' "
                + "and pedidos.Fecha like '" + busqueda1 + "%' "
                + "and pedidos.Id_Mesa like '" + busqueda2 + "%' "
                + "and personas.Nombre like '" + busqueda3 + "%')  "
                + "Group by pedidos.Id, Bebidas.Nombre, bebidas.Precio "
                + "Order by pedidos.Id desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas bebida = new Ventas();
                bebida.setFactura(res.getInt("bebidas_pedidos.Id_Pedidos"));
                bebida.setBebidas(res.getString("Bebidas.Nombre"));
                bebida.setCantidadBebidas(res.getInt("Cantidad"));
                bebida.setPrecio(res.getInt("bebidas.Precio"));
                bebida.setValorCuenta(res.getInt("Valor"));
                misbebidas.add(bebida);
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
        return misbebidas;
    }

    public ArrayList<Ventas> buscarPostre(String busqueda, String busqueda1, String busqueda2, String busqueda3) {
        ArrayList<Ventas> mispostres = new ArrayList<Ventas>();
        String sql = "Select postres_pedidos.Id_Pedidos, postres.Nombre, SUM(postres_pedidos.Cantidad) as Cantidad, "
                + "postres.Precio, Sum(postres_pedidos.Cantidad * postres.Precio) as Valor "
                + "From pedidos, postres, postres_pedidos, personas, personal "
                + "Where pedidos.Id = postres_pedidos.Id_Pedidos "
                + "And postres.Cod_Postre = postres_pedidos.Cod_Postre "
                + "And personas.Id = personal.Id_Personal "
                + "And personal.Id_Personal = pedidos.Id_Mesero "
                + "And ( pedidos.Id like '" + busqueda + "%' "
                + "and pedidos.Fecha like '" + busqueda1 + "%' "
                + "and pedidos.Id_Mesa like '" + busqueda2 + "%' "
                + "and personas.Nombre like '" + busqueda3 + "%')  "
                + "Group By Pedidos.Id, Fecha, postres.Nombre, postres.Precio  "
                + "Order by postres_pedidos.Id_Pedidos desc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas postre = new Ventas();
                postre.setFactura(res.getInt("postres_pedidos.Id_Pedidos"));
                postre.setPostre(res.getString("postres.Nombre"));
                postre.setCantidadPostre(res.getInt("Cantidad"));
                postre.setPrecio(res.getInt("postres.Precio"));
                postre.setValorCuenta(res.getInt("Valor"));
                mispostres.add(postre);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha registrado postres para el pedido ingresado");
        } finally {
            try {
                conect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return mispostres;
    }

    public ArrayList<Ventas> listaDeCodigoCarta() {
        ArrayList<Ventas> miscartas = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select Cod_Carta from Carta "
                    + "Order by Cod_Carta asc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas venta = new Ventas();
                venta.setCarta(res.getString("Cod_Carta"));
                miscartas.add(venta);
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

    public ArrayList<Ventas> listaDeCodigoMesa() {
        ArrayList<Ventas> miscartas = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select Id from Mesa;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas venta = new Ventas();
                venta.setMesa(res.getString("Id"));
                miscartas.add(venta);
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

    public ArrayList<Ventas> listaDeCodigoAcompañantes() {
        ArrayList<Ventas> miscartas = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select Cod_Acompañante from Acompañantes;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas venta = new Ventas();
                venta.setAcompañantes(res.getString("Cod_Acompañante"));
                miscartas.add(venta);
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

    public ArrayList<Ventas> listaDeCodigoBebidas() {
        ArrayList<Ventas> miscartas = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select Cod_Bebida from Bebidas;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas venta = new Ventas();
                venta.setBebidas(res.getString("Cod_Bebida"));
                miscartas.add(venta);
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

    public ArrayList<Ventas> listaDeCodigoPostres() {
        ArrayList<Ventas> miscartas = new ArrayList<Ventas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select Cod_Postre from Postres;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Ventas venta = new Ventas();
                venta.setPostre(res.getString("Cod_Postre"));
                miscartas.add(venta);
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

    public ArrayList<Ventas> buscarVentaPedido(String busqueda, String busqueda1, String busqueda2) {
        ArrayList<Ventas> misventas = new ArrayList<Ventas>();
        String sql = "Select pedidos.Id, pedidos.Fecha, pedidos.Id_Mesa, personas.Nombre, "
                + "pedidos.Valor_Cuenta "
                + "From pedidos, personas, personal "
                + "Where personas.Id = personal.Id_Personal "
                + "And personal.Id_Personal = pedidos.Id_Mesero "
                + "And (pedidos.Id like '" + busqueda + "%' "
                + "and pedidos.Fecha like '" + busqueda1 + "%' "
                + "and personas.Nombre like '" + busqueda2 + "%')"
                + "Order by pedidos.Id, pedidos.Fecha asc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas pedido = new Ventas();
                pedido.setFactura(res.getInt("pedidos.Id"));
                pedido.setFecha(res.getString("pedidos.Fecha"));
                pedido.setMesa(res.getString("pedidos.Id_Mesa"));
                pedido.setMesero(res.getString("personas.Nombre"));
                pedido.setValorCuenta(res.getInt("pedidos.Valor_Cuenta"));
                misventas.add(pedido);
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
        return misventas;
    }
    
    public ArrayList<Ventas> buscarFecha(String busqueda) {
        ArrayList<Ventas> misventas = new ArrayList<Ventas>();
        String sql = "Select pedidos.Id, pedidos.Fecha, pedidos.Id_Mesa, personas.Nombre, "
                + "pedidos.Valor_Cuenta "
                + "From pedidos, personas, personal "
                + "Where personas.Id = personal.Id_Personal "
                + "And personal.Id_Personal = pedidos.Id_Mesero "
                + "and pedidos.Fecha like '%" + busqueda + "%')"
                + "Order by pedidos.Id, pedidos.Fecha asc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Ventas pedido = new Ventas();
                pedido.setFactura(res.getInt("pedidos.Id"));
                pedido.setFecha(res.getString("pedidos.Fecha"));
                pedido.setMesa(res.getString("pedidos.Id_Mesa"));
                pedido.setMesero(res.getString("personas.Nombre"));
                pedido.setValorCuenta(res.getInt("pedidos.Valor_Cuenta"));
                misventas.add(pedido);
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
        return misventas;
    }

    public void actualizarPedidos() throws SQLException {
        BdConnection bdConnection = new BdConnection();
        Connection connection = bdConnection.getConnection();
        Statement statement = null;
        try {
            statement = connection.createStatement();
            String sql = "UPDATE pedidos "
                    + "JOIN ( "
                    + "    SELECT Id, SUM(Total_Pagar) AS Total_Pagar "
                    + "    FROM ( "
                    + "        SELECT pedidos.Id, SUM(carta_pedido.Cantidad * carta.Precio) AS Total_Pagar "
                    + "        FROM pedidos, carta, carta_pedido "
                    + "        WHERE pedidos.Id = carta_pedido.Id_Pedidos "
                    + "        AND carta.Cod_Carta = carta_pedido.Cod_Carta "
                    + "        AND pedidos.Estado != 'Finalizado' "
                    + "        GROUP BY Id_Pedidos "
                    + "        UNION ALL "
                    + "        SELECT pedidos.Id, SUM(bebidas_pedidos.Cantidad * bebidas.Precio) AS Total_Pagar "
                    + "        FROM pedidos, bebidas, bebidas_pedidos "
                    + "        WHERE pedidos.Id = bebidas_pedidos.Id_Pedidos "
                    + "        AND bebidas.Cod_Bebida = bebidas_pedidos.Cod_Bebida "
                    + "        AND pedidos.Estado != 'Finalizado' "
                    + "        GROUP BY pedidos.Id "
                    + "        UNION ALL "
                    + "        SELECT pedidos.Id, SUM(acompañantes_pedidos.Cantidad * acompañantes.Precio) as Total_Pagar "
                    + "        FROM pedidos, acompañantes, acompañantes_pedidos "
                    + "        WHERE pedidos.Id = acompañantes_pedidos.Id_Pedidos "
                    + "        AND acompañantes.Cod_Acompañante = acompañantes_pedidos.Cod_Acompañante "
                    + "        AND pedidos.Estado != 'Finalizado' "
                    + "        GROUP BY pedidos.Id "
                    + "        UNION ALL "
                    + "        SELECT pedidos.Id, SUM(postres_pedidos.Cantidad * postres.Precio) as Total_Pagar "
                    + "        FROM pedidos, postres, postres_pedidos "
                    + "        WHERE pedidos.Id = postres_pedidos.Id_Pedidos "
                    + "        AND postres.Cod_Postre = postres_pedidos.Cod_Postre "
                    + "        AND pedidos.Estado != 'Finalizado' "
                    + "        GROUP BY pedidos.Id "
                    + "    ) AS CombinedResults "
                    + "    GROUP BY Id "
                    + ") AS ResultadosConsulta "
                    + "ON pedidos.Id = ResultadosConsulta.Id "
                    + "SET pedidos.Valor_Cuenta = ResultadosConsulta.Total_Pagar, "
                    + "pedidos.Estado = 'Finalizado';";
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
