package Controladores;

import Vista.KahootApp;

import javax.swing.JOptionPane;

public class ErrorHandler {

    public static void cerrarPrograma(RuntimeException excepcion){
        JOptionPane.showMessageDialog(null, "Error: " + excepcion.getMessage() + " Pulse ok para cerrar el programa.");
        KahootApp.getStage().close();
    }

}
