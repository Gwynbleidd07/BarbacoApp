/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Lombo
 */
public class Inventarios {
   String Codigo;
   String Nombre;
   int Cantidad;
   
   public Inventarios() {
       Codigo = "";
       Nombre = "";
       Cantidad = 0;
   }

    public Inventarios(String Codigo, String Nombre, int Cantidad) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
    }

    public Inventarios(String Codigo, int Cantidad) {
        this.Codigo = Codigo;
        this.Cantidad = Cantidad;
    }

    public String getCodigo() {
        return Codigo;
    }

    public void setCodigo(String Codigo) {
        this.Codigo = Codigo;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }
   
   
}
