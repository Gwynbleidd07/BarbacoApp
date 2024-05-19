/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Lombo
 */
public class Bebidas {
    
    int Factura;
    String Bebidas;
    int CantidadBebidas;

    public Bebidas(int Factura, String Bebidas, int CantidadBebidas) {
        this.Factura = Factura;
        this.Bebidas = Bebidas;
        this.CantidadBebidas = CantidadBebidas;
    }

    public int getFactura() {
        return Factura;
    }

    public void setFactura(int Factura) {
        this.Factura = Factura;
    }

    public String getBebidas() {
        return Bebidas;
    }

    public void setBebidas(String Bebidas) {
        this.Bebidas = Bebidas;
    }

    public int getCantidadBebidas() {
        return CantidadBebidas;
    }

    public void setCantidadBebidas(int CantidadBebidas) {
        this.CantidadBebidas = CantidadBebidas;
    }   
}
