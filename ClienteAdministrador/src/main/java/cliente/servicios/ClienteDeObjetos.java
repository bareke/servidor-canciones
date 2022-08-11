package cliente.servicios;

import cliente.controladores.AdminitradorCallbackImpl;
import interfaces.ControladorGestionAdministradoresInt;
import java.rmi.RemoteException;
import cliente.utilidades.UtilidadesRegistroC;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ClienteDeObjetos {

    private static ControladorGestionAdministradoresInt objRemoto;

    public static void main(String[] args) throws RemoteException {

        int numPuertoRMIRegistry = 2021;
        String direccionIpRMIRegistry = "localhost";
        System.out.println("Cliente Administrador conectado en " + direccionIpRMIRegistry + " con puerto " + numPuertoRMIRegistry);

        objRemoto = (ControladorGestionAdministradoresInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,
                numPuertoRMIRegistry, "objServicioGestionAdministradores");
        AdminitradorCallbackImpl objRemotoAdmin = new AdminitradorCallbackImpl();
        objRemoto.registrarReferenciaRemotaAdministrador(objRemotoAdmin);

        System.out.println("Esperando notificaciones...");
    }

}
