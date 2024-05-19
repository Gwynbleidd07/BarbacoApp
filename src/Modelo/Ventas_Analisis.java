/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Lombo
 */
public class Ventas_Analisis {
    
    String Nombre;
    int Vendido;
    int Valor;
    
    Ventas_Analisis() {
        Nombre = "";
        Vendido = 0;
        Valor = 0;
    }

    public Ventas_Analisis(String Nombre, int Vendido, int Valor) {
        this.Nombre = Nombre;
        this.Vendido = Vendido;
        this.Valor = Valor;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getVendido() {
        return Vendido;
    }

    public void setVendido(int Vendido) {
        this.Vendido = Vendido;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }  
}
