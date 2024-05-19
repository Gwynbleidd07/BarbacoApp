/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Andrés Lombo
 */
public class Cargo {
    
    private String Codigo;
    private String Nombre;
    private int Valor;

    public Cargo(String Codigo, String Nombre, int Valor) {
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Valor = Valor;
    }
    
    public Cargo() {
        Codigo = "";
        Nombre = "";
        Valor = 0;
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

    public int getValor() {
        return Valor;
    }

    public void setValor(int Valor) {
        this.Valor = Valor;
    }
    
    
    
}
