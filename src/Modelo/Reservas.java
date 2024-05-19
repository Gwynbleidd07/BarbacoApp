/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Lombo
 */
public class Reservas {
    
    String Fecha;
    int Valor;
    String Cliente;
    String Pedido;
    String Nombre;
    
    Reservas() {
        Fecha = "";
        Valor = 0;
        Cliente = "";
        Pedido = "";
        Nombre = "";
    }

    public Reservas(String Fecha, int Valor, String Cliente, String Pedido) {
        this.Fecha = Fecha;
        this.Valor = Valor;
        this.Cliente = Cliente;
        this.Pedido = Pedido;
    }
    
    public Reservas(String Fecha, String Cliente, String Nombre, String Pedido, int Valor) {
        this.Fecha = Fecha;
        this.Cliente = Cliente;
        this.Nombre = Nombre;
        this.Pedido = Pedido;
        this.Valor = Valor;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }

    public String getCliente() {
        return Cliente;
    }

    public void setCliente(String Cliente) {
        this.Cliente = Cliente;
    }

    public String getPedido() {
        return Pedido;
    }

    public void setPedido(String Pedido) {
        this.Pedido = Pedido;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
}
