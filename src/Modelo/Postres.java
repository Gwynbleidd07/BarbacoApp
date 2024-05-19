/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Lombo
 */
public class Postres {
    
    int Factura;
    String Postres;
    int CantidadPostres;

    public Postres(int Factura, String Postres, int CantidadPostres) {
        this.Factura = Factura;
        this.Postres = Postres;
        this.CantidadPostres = CantidadPostres;
    }

    public int getFactura() {
        return Factura;
    }

    public void setFactura(int Factura) {
        this.Factura = Factura;
    }

    public String getPostres() {
        return Postres;
    }

    public void setPostres(String Acompañantes) {
        this.Postres = Acompañantes;
    }

    public int getCantidadPostres() {
        return CantidadPostres;
    }

    public void setCantidadPostres(int CantidadAcompañantes) {
        this.CantidadPostres = CantidadAcompañantes;
    }  
}
