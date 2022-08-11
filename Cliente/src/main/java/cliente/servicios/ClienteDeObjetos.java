package cliente.servicios;

import cliente.vista.Menu;
import servidor.interfaces.ControladorGestorCancionInt;

import cliente.utilidades.UtilidadesRegistroC;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ClienteDeObjetos {

    private static ControladorGestorCancionInt objRemoto;

    public static void main(String[] args) {

        int numPuertoRMIRegistry = 2021;
        String direccionIpRMIRegistry = "localhost";

        objRemoto = (ControladorGestorCancionInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "objServicioGestionCanciones");
        Menu objMenu = new Menu(objRemoto);
        objMenu.ejecutarMenuPrincipal();
    }

}
