/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.PersonasDAO;
import Vista.Login;
import Vista.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Andrés Lombo
 */
public class Controlador_Login implements ActionListener {
    
    PersonasDAO modeloPersona = new PersonasDAO();
    Login vistaLogin = new Login();
    Menu vistaMenu = new Menu();
    
    public Controlador_Login(PersonasDAO modeloPer, Login vistaLo) {
        this.modeloPersona = modeloPer;
        this.vistaLogin = vistaLo;
        vistaLo.btn_Continuar.addActionListener(this);
    }
    
    public void validarInicio(String usuario, String contrasenia) {
        int registro = modeloPersona.Validar(usuario, contrasenia);
        if (registro == 0) {
            JOptionPane.showMessageDialog(null, "Sus datos son incorrectos, reviselos");
        } else {
            JOptionPane.showMessageDialog(null, "Bienvenido Sr(a) " + usuario);
            Controlador_Menu controlador = new Controlador_Menu(vistaMenu);
            vistaLogin.setVisible(false);
            vistaMenu.setVisible(true);
            vistaMenu.setLocationRelativeTo(null);
        }
    }
    
    private boolean Vacio() {
        boolean vacio = false;
        if (vistaLogin.Usuario_Login.getText().length() == 0 || vistaLogin.Password_Usuario.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "No se pueden dejar casillas vacias");
            vacio = true;
        }
        return vacio;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if (e.getSource() == vistaLogin.btn_Continuar) {
            if (Vacio() == false) {
                String usuario = vistaLogin.Usuario_Login.getText();
                String contrasenia = new String (vistaLogin.Password_Usuario.getPassword());
                validarInicio(usuario, contrasenia);
            }
        }
    }
   
}
