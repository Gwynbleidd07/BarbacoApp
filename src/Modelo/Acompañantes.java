/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Lombo
 */
public class Acompañantes {
    
    int Factura;
    String Acompañantes;
    int CantidadAcompañantes;

    public Acompañantes(int Factura, String Acompañantes, int CantidadAcompañantes) {
        this.Factura = Factura;
        this.Acompañantes = Acompañantes;
        this.CantidadAcompañantes = CantidadAcompañantes;
    }

    public int getFactura() {
        return Factura;
    }

    public void setFactura(int Factura) {
        this.Factura = Factura;
    }

    public String getAcompañantes() {
        return Acompañantes;
    }

    public void setAcompañantes(String Acompañantes) {
        this.Acompañantes = Acompañantes;
    }

    public int getCantidadAcompañantes() {
        return CantidadAcompañantes;
    }

    public void setCantidadAcompañantes(int CantidadAcompañantes) {
        this.CantidadAcompañantes = CantidadAcompañantes;
    }
    
    
    
}
