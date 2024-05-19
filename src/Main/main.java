/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Controlador.Controlador_Login;
import Modelo.PersonasDAO;
import Vista.Login;

/**
 *
 * @author Andrés Lombo
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PersonasDAO modeloPersona = new PersonasDAO();
        Login vistaLogin = new Login();
        Controlador_Login controlador = new Controlador_Login(modeloPersona, vistaLogin);
        vistaLogin.setVisible(true);
        vistaLogin.setLocationRelativeTo(null);
    }

}
