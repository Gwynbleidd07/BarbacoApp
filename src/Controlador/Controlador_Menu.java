/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.CartasDAO;
import Modelo.ClientesDAO;
import Modelo.InventariosDAO;
import Modelo.PersonalDAO;
import Modelo.ProveedorDAO;
import Modelo.ReservasDAO;
import Modelo.VentasDAO;
import Vista.Carta;
import Vista.Cliente;
import Vista.Inventario;
import Vista.Menu;
import Vista.Personal;
import Vista.Proveedores;
import Vista.Reserva;
import Vista.Venta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Andrés Lombo
 */
public class Controlador_Menu implements ActionListener {

    Menu vistaMenu = new Menu();
    Personal vistaPersonal = new Personal();
    Venta vistaVenta = new Venta();
    Proveedores vistaProveedor = new Proveedores();
    Inventario vistaInventario = new Inventario();
    Carta vistaCarta = new Carta();
    Reserva vistaReserva = new Reserva();
    Cliente vistaCliente = new Cliente();

    PersonalDAO modeloPersonal = new PersonalDAO();
    VentasDAO modeloVenta = new VentasDAO();
    ProveedorDAO modeloProveedor = new ProveedorDAO();
    InventariosDAO modeloInventario = new InventariosDAO();
    CartasDAO modeloCarta = new CartasDAO();
    ReservasDAO modeloReserva = new ReservasDAO();
    ClientesDAO modeloCliente = new ClientesDAO();

    public Controlador_Menu(Menu vistaMenu) {
        this.vistaMenu = vistaMenu;
        vistaMenu.Btn_Personal.addActionListener(this);
        vistaMenu.btn_Ventas.addActionListener(this);
        vistaMenu.btn_Proveedores.addActionListener(this);
        vistaMenu.btn_Inventarios.addActionListener(this);
        vistaMenu.btn_Carta.addActionListener(this);
        vistaMenu.btn_Reservas.addActionListener(this);
        vistaMenu.btn_Cliente.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaMenu.Btn_Personal) {
            Controlador_Personal controlador = new Controlador_Personal(vistaPersonal, modeloPersonal);
            vistaMenu.setVisible(false);
            vistaPersonal.setVisible(true);
            vistaPersonal.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaMenu.btn_Ventas) {
            Controlador_Ventas controlador = new Controlador_Ventas(vistaVenta, modeloVenta);
            vistaMenu.setVisible(false);
            vistaVenta.setVisible(true);
            vistaVenta.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaMenu.btn_Proveedores) {
            Controlador_Proveedor controlador = new Controlador_Proveedor(vistaProveedor, modeloProveedor);
            vistaMenu.setVisible(false);
            vistaProveedor.setVisible(true);
            vistaProveedor.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaMenu.btn_Inventarios) {
            Controlador_Inventario controlador = new Controlador_Inventario(vistaInventario, modeloInventario);
            vistaMenu.setVisible(false);
            vistaInventario.setVisible(true);
            vistaInventario.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaMenu.btn_Carta) {
            Controlador_Cartas controlador = new Controlador_Cartas(vistaCarta, modeloCarta);
            vistaMenu.setVisible(false);
            vistaCarta.setVisible(true);
            vistaCarta.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaMenu.btn_Reservas) {
            Controlador_Reserva controlador = new Controlador_Reserva(vistaReserva, modeloReserva);
            vistaMenu.setVisible(false);
            vistaReserva.setVisible(true);
            vistaReserva.setLocationRelativeTo(null);
        }
        if (e.getSource() == vistaMenu.btn_Cliente) {
            Controlador_Cliente controlador = new Controlador_Cliente(vistaCliente, modeloCliente);
            vistaMenu.setVisible(false);
            vistaCliente.setVisible(true);
            vistaCliente.setLocationRelativeTo(null);
        }
    }
}
