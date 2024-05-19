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
public class ProveedorDAO {

    ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
    ArrayList<Personas> personas = new ArrayList<Personas>();

    public ProveedorDAO() {
        personas = listaDeProveedor();
        proveedores = listaDeCarta();
        proveedores = listaDeAcompañante();
        proveedores = listaDeBebida();
        proveedores = listaDePostre();
        proveedores = listaDeServicio();
        proveedores = listaDeTotal();
    }

    public ArrayList<Proveedor> listaProveedor() {
        return proveedores;
    }

    public ArrayList<Personas> listaPersona() {
        return personas;
    }

    public void registrarProveedor(Personas misproveedores) {
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
            pst.setString(1, misproveedores.getId());
            pst.setString(2, misproveedores.getNombre());
            pst.setString(3, misproveedores.getApellido());
            pst.setString(4, misproveedores.getCelular());
            pst.setString(5, misproveedores.getFecha_Nacimiento());
            pst.executeUpdate();

            sql1 = "Insert into proveedores(Id, Direccion) "
                    + "Values(?,?);";
            pst1 = cn.prepareStatement(sql1);
            pst1.setString(1, misproveedores.getId());
            pst1.setString(2, misproveedores.getComentarios());
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(null, "El proveedor  Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
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

    public void registrarCarta(Proveedor misproveedores) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into proveedor_carta(Id_Proveedor, Fecha, Descripcion, Valor) Values(?,?,?,?);";
            pst = cn.prepareStatement(sql);
            pst.setString(1, misproveedores.getId_Proveedor());
            pst.setString(2, misproveedores.getFecha());
            pst.setString(3, misproveedores.getDescripcion());
            pst.setInt(4, misproveedores.getValor());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "La carta y/o entrada Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el pedido ya haya estado registrada en el sistema", "Acceso denegado",
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

    public void registrarAcompañante(Proveedor misproveedores) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into proveedor_acompañantes(Id_Proveedor, Fecha, Descripcion, Valor) Values(?,?,?,?);";
            pst = cn.prepareStatement(sql);
            pst.setString(1, misproveedores.getId_Proveedor());
            pst.setString(2, misproveedores.getFecha());
            pst.setString(3, misproveedores.getDescripcion());
            pst.setInt(4, misproveedores.getValor());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "El Acompañante Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el pedido ya haya estado registrada en el sistema", "Acceso denegado",
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

    public void registrarBebida(Proveedor misproveedores) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into proveedor_bebidas(Id_Proveedor, Fecha, Descripcion, Valor) Values(?,?,?,?);";
            pst = cn.prepareStatement(sql);
            pst.setString(1, misproveedores.getId_Proveedor());
            pst.setString(2, misproveedores.getFecha());
            pst.setString(3, misproveedores.getDescripcion());
            pst.setInt(4, misproveedores.getValor());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "La bebida Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el pedido ya haya estado registrada en el sistema", "Acceso denegado",
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

    public void registrarPostre(Proveedor misproveedores) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into proveedores_postres(Id_Proveedor, Fecha, Descripcion, Valor) Values(?,?,?,?);";
            pst = cn.prepareStatement(sql);
            pst.setString(1, misproveedores.getId_Proveedor());
            pst.setString(2, misproveedores.getFecha());
            pst.setString(3, misproveedores.getDescripcion());
            pst.setInt(4, misproveedores.getValor());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Los postres Se han registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el pedido ya haya estado registrada en el sistema", "Acceso denegado",
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

    public void registrarServicios(Proveedor misproveedores) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "Insert into proveedor_servicios(Id_Proveedor, Fecha, Descripcion, Valor) Values(?,?,?,?);";
            pst = cn.prepareStatement(sql);
            pst.setString(1, misproveedores.getId_Proveedor());
            pst.setString(2, misproveedores.getFecha());
            pst.setString(3, misproveedores.getDescripcion());
            pst.setInt(4, misproveedores.getValor());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "El servicio Se ha registrado correctamente");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error "
                    + "No se ha registrado correctamente, puede que el pedido ya haya estado registrada en el sistema", "Acceso denegado",
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

    public ArrayList<Personas> listaDeProveedor() {
        ArrayList<Personas> misproveedores = new ArrayList<Personas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select personas.Id, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, personas.Celular, proveedores.Direccion "
                    + "from proveedores, personas "
                    + "where personas.Id = proveedores.Id;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Personas proveedor = new Personas();
                proveedor.setId(res.getString("personas.Id"));
                proveedor.setNombre(res.getString("Nombre"));
                proveedor.setCelular(res.getString("personas.Celular"));
                proveedor.setComentarios(res.getString("proveedores.Direccion"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> listaDeCarta() {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select proveedor_carta.Id_Proveedor, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                    + "proveedor_carta.Fecha, proveedor_carta.Descripcion, proveedor_carta.Valor "
                    + "from proveedor_carta, personas "
                    + "where proveedor_carta.Id_Proveedor = personas.Id "
                    + "and (proveedor_carta.Descripcion != 0 or proveedor_carta.Valor != 0)";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(res.getString("proveedor_carta.Id_Proveedor"));
                proveedor.setNombre(res.getString("Nombre"));
                proveedor.setFecha(res.getString("proveedor_carta.Fecha"));
                proveedor.setDescripcion(res.getString("proveedor_carta.Descripcion"));
                proveedor.setValor(res.getInt("proveedor_carta.Valor"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> listaDeAcompañante() {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select proveedor_acompañantes.Id_Proveedor, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                    + "proveedor_acompañantes.Fecha, proveedor_acompañantes.Descripcion, proveedor_acompañantes.Valor "
                    + "from proveedor_acompañantes, personas "
                    + "where proveedor_acompañantes.Id_Proveedor = personas.Id;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(res.getString("proveedor_acompañantes.Id_Proveedor"));
                proveedor.setNombre(res.getString("Nombre"));
                proveedor.setFecha(res.getString("proveedor_acompañantes.Fecha"));
                proveedor.setDescripcion(res.getString("proveedor_acompañantes.Descripcion"));
                proveedor.setValor(res.getInt("proveedor_acompañantes.Valor"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> listaDeBebida() {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select proveedor_bebidas.Id_Proveedor, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                    + "proveedor_bebidas.Fecha, proveedor_bebidas.Descripcion, proveedor_bebidas.Valor "
                    + "from proveedor_bebidas, personas "
                    + "where proveedor_bebidas.Id_Proveedor = personas.Id;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(res.getString("proveedor_bebidas.Id_Proveedor"));
                proveedor.setNombre(res.getString("Nombre"));
                proveedor.setFecha(res.getString("proveedor_bebidas.Fecha"));
                proveedor.setDescripcion(res.getString("proveedor_bebidas.Descripcion"));
                proveedor.setValor(res.getInt("proveedor_bebidas.Valor"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> listaDePostre() {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select proveedores_postres.Id_Proveedor, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                    + "proveedores_postres.Fecha, proveedores_postres.Descripcion, proveedores_postres.Valor "
                    + "from proveedores_postres, personas "
                    + "where proveedores_postres.Id_Proveedor = personas.Id;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(res.getString("proveedores_postres.Id_Proveedor"));
                proveedor.setNombre(res.getString("Nombre"));
                proveedor.setFecha(res.getString("proveedores_postres.Fecha"));
                proveedor.setDescripcion(res.getString("proveedores_postres.Descripcion"));
                proveedor.setValor(res.getInt("proveedores_postres.Valor"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> listaDeServicio() {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select proveedor_servicios.Id_Proveedor, proveedor_servicios.Fecha, proveedor_servicios.Descripcion, "
                    + "proveedor_servicios.Valor "
                    + "from proveedor_servicios;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(res.getString("proveedor_servicios.Id_Proveedor"));
                proveedor.setFecha(res.getString("proveedor_servicios.Fecha"));
                proveedor.setDescripcion(res.getString("proveedor_servicios.Descripcion"));
                proveedor.setValor(res.getInt("proveedor_servicios.Valor"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> listaDeTotal() {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "SELECT SUM(Valor) as Total "
                    + "FROM ( "
                    + "    SELECT SUM(Valor) as Valor "
                    + "    FROM proveedor_carta "
                    + "    UNION ALL "
                    + "    SELECT SUM(Valor) as Valor "
                    + "    FROM proveedor_acompañantes "
                    + "    UNION ALL "
                    + "    SELECT SUM(Valor) as Valor "
                    + "    FROM proveedor_bebidas "
                    + "    UNION ALL "
                    + "    SELECT SUM(Valor) as Valor "
                    + "    FROM proveedores_postres "
                    + "    UNION ALL "
                    + "    SELECT SUM(Valor) as Valor "
                    + "    FROM proveedor_servicios "
                    + ") as Subquery;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setValor(res.getInt("Total"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> buscarCarta(String busqueda, String busqueda1) {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        String sql = "Select proveedor_carta.Id_Proveedor, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                + "proveedor_carta.Fecha, proveedor_carta.Descripcion, proveedor_carta.Valor "
                + "from proveedor_carta, personas "
                + "where proveedor_carta.Id_Proveedor = personas.Id "
                + "and proveedor_carta.Descripcion like '" + busqueda + "%' and proveedor_carta.Fecha like '" + busqueda1 + "%' ";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(res.getString("proveedor_carta.Id_Proveedor"));
                proveedor.setNombre(res.getString("Nombre"));
                proveedor.setFecha(res.getString("proveedor_carta.Fecha"));
                proveedor.setDescripcion(res.getString("proveedor_carta.Descripcion"));
                proveedor.setValor(res.getInt("proveedor_carta.Valor"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> buscarAcompañante(String busqueda, String busqueda1) {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        String sql = "Select proveedor_acompañantes.Id_Proveedor, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                + "proveedor_acompañantes.Fecha, proveedor_acompañantes.Descripcion, proveedor_acompañantes.Valor "
                + "from proveedor_acompañantes, personas "
                + "where proveedor_acompañantes.Id_Proveedor = personas.Id "
                + "and proveedor_acompañantes.Descripcion like '" + busqueda + "%' "
                + "and proveedor_acompañantes.Fecha like '" + busqueda1 + "%';";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(res.getString("proveedor_acompañantes.Id_Proveedor"));
                proveedor.setNombre(res.getString("Nombre"));
                proveedor.setFecha(res.getString("proveedor_acompañantes.Fecha"));
                proveedor.setDescripcion(res.getString("proveedor_acompañantes.Descripcion"));
                proveedor.setValor(res.getInt("proveedor_acompañantes.Valor"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> buscarBebida(String busqueda, String busqueda1) {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        String sql = "Select proveedor_bebidas.Id_Proveedor, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                + "proveedor_bebidas.Fecha, proveedor_bebidas.Descripcion, proveedor_bebidas.Valor "
                + "from proveedor_bebidas, personas "
                + "where proveedor_bebidas.Id_Proveedor = personas.Id "
                + "and proveedor_bebidas.Descripcion like '" + busqueda + "%' and proveedor_bebidas.Fecha like '" + busqueda1 + "%';";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(res.getString("proveedor_bebidas.Id_Proveedor"));
                proveedor.setNombre(res.getString("Nombre"));
                proveedor.setFecha(res.getString("proveedor_bebidas.Fecha"));
                proveedor.setDescripcion(res.getString("proveedor_bebidas.Descripcion"));
                proveedor.setValor(res.getInt("proveedor_bebidas.Valor"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> buscarPostre(String busqueda, String busqueda1) {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        String sql = "Select proveedores_postres.Id_Proveedor, concat(personas.Nombre, ' ', personas.Apellido) as Nombre, "
                + "proveedores_postres.Fecha, proveedores_postres.Descripcion, proveedores_postres.Valor "
                + "from proveedores_postres, personas "
                + "where proveedores_postres.Id_Proveedor = personas.Id "
                + "and proveedores_postres.Descripcion like '" + busqueda + "%' and proveedores_postres.Fecha like '" + busqueda1 + "%';";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(res.getString("proveedores_postres.Id_Proveedor"));
                proveedor.setNombre(res.getString("Nombre"));
                proveedor.setFecha(res.getString("proveedores_postres.Fecha"));
                proveedor.setDescripcion(res.getString("proveedores_postres.Descripcion"));
                proveedor.setValor(res.getInt("proveedores_postres.Valor"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> buscarServicio(String busqueda, String busqueda1) {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        String sql = "Select proveedor_servicios.Id_Proveedor, proveedor_servicios.Fecha, proveedor_servicios.Descripcion, "
                + "proveedor_servicios.Valor "
                + "from proveedor_servicios "
                + "where proveedor_servicios.Descripcion like '" + busqueda + "%' and proveedor_servicios.Fecha like '" + busqueda1 + "%';";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setId_Proveedor(res.getString("proveedor_servicios.Id_Proveedor"));
                proveedor.setFecha(res.getString("proveedor_servicios.Fecha"));
                proveedor.setDescripcion(res.getString("proveedor_servicios.Descripcion"));
                proveedor.setValor(res.getInt("proveedor_servicios.Valor"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }

    public ArrayList<Proveedor> buscarTotal(String busqueda) {
        ArrayList<Proveedor> misproveedores = new ArrayList<Proveedor>();
        String sql = "SELECT SUM(Valor) as Total "
                + "FROM ( "
                + "    SELECT SUM(Valor) as Valor "
                + "    FROM proveedor_carta  "
                + "    WHERE Fecha LIKE '" + busqueda + "%' "
                + "    UNION ALL "
                + "    SELECT SUM(Valor) as Valor "
                + "    FROM proveedor_acompañantes "
                + "    WHERE Fecha LIKE '" + busqueda + "%' "
                + "    UNION ALL "
                + "    SELECT SUM(Valor) as Valor "
                + "    FROM proveedor_bebidas "
                + "    WHERE Fecha LIKE '" + busqueda + "%' "
                + "    UNION ALL "
                + "    SELECT SUM(Valor) as Valor "
                + "    FROM proveedores_postres "
                + "    WHERE Fecha LIKE '" + busqueda + "%' "
                + "    UNION ALL "
                + "    SELECT SUM(Valor) as Valor "
                + "    FROM proveedor_servicios "
                + "    WHERE Fecha LIKE '" + busqueda + "%' "
                + ") as Subquery;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Proveedor proveedor = new Proveedor();
                proveedor.setValor(res.getInt("Total"));
                misproveedores.add(proveedor);
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
        return misproveedores;
    }
}
