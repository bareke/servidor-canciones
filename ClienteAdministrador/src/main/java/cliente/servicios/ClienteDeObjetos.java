package cliente.servicios;

import cliente.controladores.AdminitradorCallbackImpl;
import interfaces.ControladorGestionAdministradoresInt;
import java.rmi.RemoteException;
import utilidades.UtilidadesConsola;
import utilidades.UtilidadesRegistroC;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ClienteDeObjetos {

    private static ControladorGestionAdministradoresInt objRemoto;

    public static void main(String[] args) throws RemoteException {

        int numPuertoRMIRegistry = 0;
        String direccionIpRMIRegistry = "";

        System.out.println("Cual es el la dirección ip donde se encuentra  el rmiregistry ");
        direccionIpRMIRegistry = UtilidadesConsola.leerCadena();
        System.out.println("Cual es el número de puerto por el cual escucha el rmiregistry ");
        numPuertoRMIRegistry = UtilidadesConsola.leerEntero();

        objRemoto = (ControladorGestionAdministradoresInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,
                numPuertoRMIRegistry, "objServicioGestionAdministradores");
        AdminitradorCallbackImpl objRemotoAdmin = new AdminitradorCallbackImpl();
        objRemoto.registrarReferenciaRemotaAdministrador(objRemotoAdmin);

        System.out.println("Esperando notificaciones...");
    }

}
