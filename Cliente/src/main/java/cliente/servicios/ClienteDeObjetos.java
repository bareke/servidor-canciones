package cliente.servicios;

import cliente.vista.Menu;
import interfaces.ControladorGestorCancionInt;
import utilidades.UtilidadesRegistroC;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ClienteDeObjetos {

    private static ControladorGestorCancionInt objRemoto;

    public static void main(String[] args) {

        int numPuertoRMIRegistry = 2021;
        String direccionIpRMIRegistry = "localhost";
        System.out.println("Cliente conectado en " + direccionIpRMIRegistry + " con puerto " + numPuertoRMIRegistry);

        objRemoto = (ControladorGestorCancionInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry, numPuertoRMIRegistry, "objServicioGestionCanciones");
        Menu objMenu = new Menu(objRemoto);
        objMenu.ejecutarMenuPrincipal();

    }

}
