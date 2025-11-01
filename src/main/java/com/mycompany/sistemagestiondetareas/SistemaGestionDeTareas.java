/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.sistemagestiondetareas;

import com.mycompany.sistemagestiondetareas.util.ConexionBD;
import com.mycompany.sistemagestiondetareas.vista.Login;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class SistemaGestionDeTareas {

    /**
     * Método principal que inicia la aplicación.
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Configura el aspecto visual para que coincida con el sistema operativo
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ex) {
            // Si falla la configuración, se usa el look and feel por defecto
        }
        
        // Agrega un hook para cerrar la conexión a la base de datos cuando la aplicación termina
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {
                ConexionBD.cerrarConexion();
                System.out.println("Conexión a la base de datos cerrada correctamente");
            }
        });
        
        // Inicia la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }
}
