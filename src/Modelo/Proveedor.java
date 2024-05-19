/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Lombo
 */
public class Proveedor {

    String Id_Proveedor;
    String Nombre;
    String Direccion;
    String Fecha;
    String Descripcion;
    int Valor;
    String Codigo;

    Proveedor() {
        Id_Proveedor = "";
        Nombre = "";
        Direccion = "";
        Fecha = "";
        Descripcion = "";
        Valor = 0;
        Codigo = "";
    }

    public Proveedor(String Id_Proveedor, String Nombre, String Direccion, String Fecha, String Descripcion, int Valor, String Codigo) {
        this.Id_Proveedor = Id_Proveedor;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Fecha = Fecha;
        this.Descripcion = Descripcion;
        this.Valor = Valor;
        this.Codigo = Codigo;
    }

    public Proveedor(String Cedula, String Fecha, String Descripcion, int Valor) {
        this.Id_Proveedor = Cedula;
        this.Fecha = Fecha;
        this.Descripcion = Descripcion;
        this.Valor = Valor;
    }

    public String getId_Proveedor() {
        return Id_Proveedor;
    }

    public void setId_Proveedor(String Id_Proveedor) {
        this.Id_Proveedor = Id_Proveedor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }
}
