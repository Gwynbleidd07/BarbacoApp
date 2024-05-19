/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Lombo
 */
public class Ventas {

    int Factura;
    String Fecha;
    String Mesa;
    String Mesero;
    String Carta;
    int CantidadCarta;
    String Acompañantes;
    int CantidadAcompañantes;
    String Bebidas;
    int CantidadBebidas;
    String Postre;
    int CantidadPostre;
    int ValorCuenta;
    int Precio;

    public Ventas() {
        Factura = 0;
        Fecha = "";
        Mesa = "";
        Mesero = "";
        Carta = "";
        CantidadCarta = 0;
        Acompañantes = "";
        CantidadAcompañantes = 0;
        Bebidas = "";
        CantidadBebidas = 0;
        Postre = "";
        CantidadPostre = 0;
        ValorCuenta = 0;
        Precio = 0;
    }

    public Ventas(int Factura, String Fecha, String Mesa, String Mesero, String Carta, int CantidadCarta, String Acompañantes, int CantidadAcompañantes, String Bebidas, int CantidadBebidas, String Postre, int CantidadPostre, int ValorCuenta, int Precio) {
        this.Factura = Factura;
        this.Fecha = Fecha;
        this.Mesa = Mesa;
        this.Mesero = Mesero;
        this.Carta = Carta;
        this.CantidadCarta = CantidadCarta;
        this.Acompañantes = Acompañantes;
        this.CantidadAcompañantes = CantidadAcompañantes;
        this.Bebidas = Bebidas;
        this.CantidadBebidas = CantidadBebidas;
        this.Postre = Postre;
        this.CantidadPostre = CantidadPostre;
        this.ValorCuenta = ValorCuenta;
        this.Precio = Precio;
    }

    public Ventas(int Factura, String Fecha, String Mesa, String Mesero, String Carta, int CantidadCarta, String Acompañante, int CantidadAcompañante, String Bebida, int CantidadBebida) {
        this.Factura = Factura;
        this.Fecha = Fecha;
        this.Mesa = Mesa;
        this.Mesero = Mesero;
        this.Carta = Carta;
        this.CantidadCarta = CantidadCarta;
        this.Acompañantes = Acompañante;
        this.CantidadAcompañantes = CantidadAcompañante;
        this.Bebidas = Bebida;
        this.CantidadBebidas = CantidadBebida;

    }

    public Ventas(int Factura, String Carta, int CantidadCarta) {
        this.Factura = Factura;
        this.Carta = Carta;
        this.CantidadCarta = CantidadCarta;
    }

    public int getFactura() {
        return Factura;
    }

    public void setFactura(int Factura) {
        this.Factura = Factura;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public String getMesa() {
        return Mesa;
    }

    public void setMesa(String Mesa) {
        this.Mesa = Mesa;
    }

    public String getMesero() {
        return Mesero;
    }

    public void setMesero(String Mesero) {
        this.Mesero = Mesero;
    }

    public String getCarta() {
        return Carta;
    }

    public void setCarta(String Carta) {
        this.Carta = Carta;
    }

    public int getCantidadCarta() {
        return CantidadCarta;
    }

    public void setCantidadCarta(int CantidadCarta) {
        this.CantidadCarta = CantidadCarta;
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

    public String getPostre() {
        return Postre;
    }

    public void setPostre(String Postre) {
        this.Postre = Postre;
    }

    public int getCantidadPostre() {
        return CantidadPostre;
    }

    public void setCantidadPostre(int CantidadPostre) {
        this.CantidadPostre = CantidadPostre;
    }

    public int getValorCuenta() {
        return ValorCuenta;
    }

    public void setValorCuenta(int ValorCuenta) {
        this.ValorCuenta = ValorCuenta;
    }

    public int getPrecio() {
        return Precio;
    }

    public void setPrecio(int Precio) {
        this.Precio = Precio;
    }
}
