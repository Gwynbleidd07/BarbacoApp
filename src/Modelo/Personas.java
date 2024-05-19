/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Lombo
 */
public class Personas {

    private String Id;
    private String Nombre;
    private String Apellido;
    private String Celular;
    private String Fecha_Nacimiento;
    private String Usuario;
    private String Contraseña;
    private String Fecha_Ingreso;
    private String Fecha;
    private String Comentarios;
    private double Calificacion;
    private int N_Horas;
    private String Direccion;
    private String Cargo;
    private String Codigo;
    private int Valor;
    private int Edad;

    public Personas(String Id, String Nombre, String Apellido, String Celular, String Fecha_Nacimiento, String Usuario, String Contraseña, String Fecha_Ingreso, String Fecha, String Comentarios, double Calificacion, int N_Horas, String Direccion, String Cargo, String Codigo, int Valor, int Edad) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Celular = Celular;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Fecha_Ingreso = Fecha_Ingreso;
        this.Fecha = Fecha;
        this.Comentarios = Comentarios;
        this.Calificacion = Calificacion;
        this.N_Horas = N_Horas;
        this.Direccion = Direccion;
        this.Cargo = Cargo;
        this.Codigo = Codigo;
        this.Valor = Valor;
        this.Edad = Edad;
    }

    public Personas() {
        Id = "";
        Nombre = "";
        Apellido = "";
        Celular = "";
        Fecha_Nacimiento = "";
        Usuario = "";
        Contraseña = "";
        Fecha_Ingreso = "";
        Fecha = "";
        Comentarios = "";
        Calificacion = 0;
        N_Horas = 0;
        Direccion = "";
        Cargo = "";
        Codigo = "";
        Valor = 0;
        Edad = 0;
    }

    public Personas(String Cedula, String Fecha1, int Horas, String CodigoCargo) {
        this.Id = Cedula;
        this.Fecha = Fecha1;
        this.N_Horas = Horas;
        this.Codigo = CodigoCargo;
        
    }

    public Personas(String Id, String Nombre, String Apellido, String Celular, String Fecha_N, String Comentario, double Calificacion) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Celular = Celular;
        this.Fecha_Nacimiento = Fecha_N;
        this.Comentarios = Comentario;
        this.Calificacion = Calificacion;
    }

    public Personas(String Id, String Nombre, String Apellido, String Celular, String Fecha, String Direccion) {
        this.Id = Id;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Celular = Celular;
        this.Fecha_Nacimiento = Fecha;
        this.Comentarios = Direccion;
    }

    public Personas(String Cedula, String Nombre, String Apellido, String Celular, String Fecha_Nacimiento, String Fecha, String Comentario, double Calificacion) {
        this.Id = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Celular = Celular;
        this.Fecha_Nacimiento = Fecha_Nacimiento;
        this.Fecha_Ingreso = Fecha;   
        this.Comentarios = Comentario;
        this.Calificacion = Calificacion;
    }

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getFecha_Nacimiento() {
        return Fecha_Nacimiento;
    }

    public void setFecha_Nacimiento(String Fecha_Nacimiento) {
        this.Fecha_Nacimiento = Fecha_Nacimiento;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public String getFecha_Ingreso() {
        return Fecha_Ingreso;
    }

    public void setFecha_Ingreso(String Fecha_Ingreso) {
        this.Fecha_Ingreso = Fecha_Ingreso;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String Comentarios) {
        this.Comentarios = Comentarios;
    }

    public double getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(double Calificacion) {
        this.Calificacion = Calificacion;
    }

    public int getN_Horas() {
        return N_Horas;
    }

    public void setN_Horas(int N_Horas) {
        this.N_Horas = N_Horas;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    } 

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }
    

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }    
}
