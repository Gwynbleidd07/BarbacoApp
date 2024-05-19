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
public class PersonalDAO {

    ArrayList<Personas> personas = new ArrayList<>();
    ArrayList<Cargo> cargos = new ArrayList<>();

    public PersonalDAO() {
        personas = listaDePersonas();
        cargos = listaDeCargos();
    }

    public ArrayList<Personas> listaPersona() {
        return personas;
    }

    public ArrayList<Cargo> listaCargo() {
        return cargos;
    }

    public void registrarEmpleado(Personas mipersona) {
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

            sql1 = "Insert into Personal(Id_Personal, Comentario, Calificacion) "
                    + "Values(?,?,?);";
            pst1 = cn.prepareStatement(sql1);
            pst1.setString(1, mipersona.getId());
            pst1.setString(2, mipersona.getComentarios());
            pst1.setString(3, String.valueOf(mipersona.getCalificacion()));
            pst1.executeUpdate();
            JOptionPane.showMessageDialog(null, "El empleado\n Se ha registrado correctamente");
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

    public void registrarPersonaCargo(Personas mipersona) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            sql = "insert into cargo_personal(Id_Personal, Fecha, N_Horas, Cod_Cargo) "
                    + "values (?, ?, ?, ?);";
            pst = cn.prepareStatement(sql);
            pst.setString(1, mipersona.getId());
            pst.setString(2, mipersona.getFecha());
            pst.setInt(3, mipersona.getN_Horas());
            pst.setString(4, mipersona.getCodigo());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "La persona se registro a la reunion con exito");
        } catch (SQLException | NumberFormatException e) {
            System.out.print(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error\n"
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

    public void registrarCargo(Cargo micargo) {
        String sql = "";
        BdConnection bdConnection = new BdConnection();
        Connection cn = bdConnection.getConnection();
        PreparedStatement pst = null;
        try {
            cargos.add(micargo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se pudieron agregar los datos");
        }
        try {
            sql = "Insert into Cargo(Codigo, Nombre, Valor_Hora) "
                    + "Values (?, ?, ?);";
            pst = cn.prepareStatement(sql);
            pst.setString(1, micargo.getCodigo());
            pst.setString(2, micargo.getNombre());
            pst.setInt(3, micargo.getValor());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "La reunión\n Se ha registrado correctamente");
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

    public ArrayList<Personas> listaDePersonas() {
        ArrayList<Personas> mispersonas = new ArrayList<Personas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select personas.Id, personas.Nombre, personas.Apellido, personas.Celular, personas.F_Nacimiento, "
                    + "Round(DATEDIFF(CURDATE(), F_Nacimiento) / 365.25) AS Edad, personal.Comentario, personal.Calificacion "
                    + "from personas, personal "
                    + "where personas.id = personal.id_personal "
                    + "Order by personas.Nombre asc";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Personas persona = new Personas();
                persona.setId(res.getString("personas.Id"));
                persona.setNombre(res.getString("personas.Nombre"));
                persona.setApellido(res.getString("personas.Apellido"));
                persona.setCelular(res.getString("personas.Celular"));
                persona.setFecha_Nacimiento(res.getString("personas.F_Nacimiento"));
                persona.setEdad(res.getInt("Edad"));
                persona.setComentarios(res.getString("personal.Comentario"));
                persona.setCalificacion(res.getDouble("personal.Calificacion"));
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

    public ArrayList<Personas> listadePersonaCargo() {
        ArrayList<Personas> mispersonas = new ArrayList<Personas>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "SELECT cargo_personal.Id_Personal, Personas.Nombre, Personas.Apellido, cargo_personal.Fecha, "
                    + "cargo.Nombre, cargo_personal.N_Horas, sum(cargo.Valor_hora * cargo_Personal.N_Horas) as Valor "
                    + "FROM cargo_personal, personas, personal, cargo "
                    + "where personas.id = personal.Id_Personal "
                    + "and cargo_personal.Id_Personal = personal.Id_Personal "
                    + "and cargo.Codigo = cargo_personal.Cod_Cargo "
                    + "Group by cargo_personal.Id_Personal, Personas.Nombre, Personas.Apellido, cargo_personal.Fecha, cargo.nombre, cargo_personal.N_Horas "
                    + "Order by cargo_personal.fecha, personas.Nombre asc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Personas persona = new Personas();
                persona.setId(res.getString("cargo_personal.Id_Personal"));
                persona.setNombre(res.getString("Personas.Nombre"));
                persona.setApellido(res.getString("Personas.Apellido"));
                persona.setFecha(res.getString("cargo_personal.Fecha"));
                persona.setCargo(res.getString("cargo.nombre"));
                persona.setN_Horas(res.getInt("cargo_personal.N_Horas"));
                persona.setValor(res.getInt("Valor"));
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

    public ArrayList<Cargo> listaDeCargos() {
        ArrayList<Cargo> miscargos = new ArrayList<Cargo>();
        BdConnection cn = new BdConnection();
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = cn.getConnection();
            String sql = "Select * from Cargo "
                    + "order by Nombre asc;";
            ps = con.prepareStatement(sql);
            ResultSet res = ps.executeQuery();
            while (res.next()) {
                Cargo cargo = new Cargo();
                cargo.setCodigo(res.getString("Codigo"));
                cargo.setNombre(res.getString("Nombre"));
                cargo.setValor(res.getInt("Valor_Hora"));
                miscargos.add(cargo);
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
        return miscargos;
    }

    public boolean ActualizarEmpleado(Personas empleado) {
        BdConnection conex = new BdConnection();
        boolean respuesta1 = false;
        boolean respuesta2 = false;
        boolean respuesta = false;
        String sql = "";
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = conex.getConnection();
            sql = "Update personas Set Nombre = ?, Apellido = ?, Celular = ?, F_Nacimiento = ? "
                    + "Where Id = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApellido());
            ps.setString(3, empleado.getCelular());
            ps.setString(4, empleado.getFecha_Nacimiento());
            ps.setString(5, empleado.getId());
            respuesta1 = ps.executeUpdate() == 1;
            
            sql = "UPDATE personal SET Comentario = ?, Calificacion = ?  "
                    + "WHERE Id_Personal = ?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, empleado.getComentarios());
            ps.setDouble(2, empleado.getCalificacion());
            ps.setString(3, empleado.getId());
            respuesta2 = ps.executeUpdate() == 1;

            if (respuesta1 == true && respuesta2 == true) {
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

    public ArrayList<Personas> buscarTotal(String busqueda, String busqueda1, String busqueda2, String busqueda3) {
        ArrayList<Personas> mispersonas = new ArrayList<Personas>();
        String sql = "SELECT sum(cargo.Valor_hora * cargo_Personal.N_Horas) as Valor "
                + "FROM cargo_personal, personas, personal, cargo "
                + "where personas.id = personal.Id_Personal "
                + "and cargo_personal.Id_Personal = personal.Id_Personal "
                + "and cargo.Codigo = cargo_personal.Cod_Cargo "
                + "and (personas.Nombre like '" + busqueda + "%' and personas.Apellido like '" + busqueda1 + "%' "
                + "and cargo_personal.fecha like '" + busqueda2 + "%' and cargo.Codigo like '" + busqueda3 + "%');";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Personas persona = new Personas();
                persona.setValor(res.getInt("Valor"));
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

    public ArrayList<Personas> buscarPersonal(String busqueda) {
        ArrayList<Personas> mispersonas = new ArrayList<Personas>();
        String sql = "Select personas.Id, personas.Nombre, personas.Apellido, personas.Celular, personas.F_Nacimiento, "
                + "Round(DATEDIFF(CURDATE(), F_Nacimiento) / 365.25) AS Edad, personal.Comentario, personal.Calificacion "
                + "from personas, personal "
                + "where personas.id = personal.id_personal "
                + "and (Nombre like '" + busqueda + "%' or Apellido like '" + busqueda + "%' "
                + "or Celular like '" + busqueda + "%')"
                + "Order by personas.Nombre asc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Personas persona = new Personas();
                persona.setId(res.getString("personas.Id"));
                persona.setNombre(res.getString("personas.Nombre"));
                persona.setApellido(res.getString("personas.Apellido"));
                persona.setCelular(res.getString("personas.Celular"));
                persona.setFecha_Nacimiento(res.getString("personas.F_Nacimiento"));
                persona.setEdad(res.getInt("Edad"));
                persona.setComentarios(res.getString("personal.Comentario"));
                persona.setCalificacion(res.getDouble("personal.Calificacion"));
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

    public ArrayList<Personas> buscarPersonalCargo(String busqueda, String busqueda1, String busqueda2, String busqueda3, String busqueda4) {
        ArrayList<Personas> mispersonas = new ArrayList<Personas>();
        String sql = "SELECT cargo_personal.Id_Personal, Personas.Nombre, Personas.Apellido, cargo_personal.Fecha, "
                + "cargo.Nombre, cargo_personal.N_Horas, sum(cargo.Valor_hora * cargo_Personal.N_Horas) as Valor "
                + "FROM cargo_personal, personas, personal, cargo "
                + "where personas.id = personal.Id_Personal "
                + "and cargo_personal.Id_Personal = personal.Id_Personal "
                + "and cargo.Codigo = cargo_personal.Cod_Cargo "
                + "and (cargo_personal.Id_Personal like '" + busqueda + "%' and Personas.Nombre like '" + busqueda1 + "%' and Personas.Apellido like '" + busqueda2 + "%' "
                + "and cargo_personal.Fecha like '" + busqueda3 + "%' and cargo_personal.Cod_Cargo like '" + busqueda4 + "%') "
                + "Group by cargo_personal.Id_Personal, Personas.Nombre, Personas.Apellido, cargo_personal.Fecha, cargo.nombre, cargo_personal.N_Horas "
                + "Order by cargo_personal.fecha, personas.Nombre asc;";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Personas persona = new Personas();
                persona.setId(res.getString("cargo_personal.Id_Personal"));
                persona.setNombre(res.getString("Personas.Nombre"));
                persona.setApellido(res.getString("Personas.Apellido"));
                persona.setFecha(res.getString("cargo_personal.Fecha"));
                persona.setCargo(res.getString("cargo.nombre"));
                persona.setN_Horas(res.getInt("cargo_personal.N_Horas"));
                persona.setValor(res.getInt("Valor"));
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

    public ArrayList<Cargo> buscarCargo(String busqueda) {
        ArrayList<Cargo> miscargos = new ArrayList<Cargo>();
        String sql = "Select * from Cargo where nombre like '" + busqueda + "%'";
        BdConnection conn = new BdConnection();
        Connection conect = conn.getConnection();
        try {
            Statement st = (Statement) conect.createStatement();
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                Cargo cargos = new Cargo();
                cargos.setCodigo(res.getString("Codigo"));
                cargos.setNombre(res.getString("Nombre"));
                cargos.setValor(res.getInt("Valor_Hora"));
                miscargos.add(cargos);
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
        return miscargos;
    }

}
