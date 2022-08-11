package cliente.servicios;

import cliente.controladores.AdminitradorCallbackImpl;
import servidor.interfaces.ControladorGestionAdministradoresInt;
import java.rmi.RemoteException;

import utilidades.UtilidadesRegistroC;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ClienteDeObjetos {

    private static ControladorGestionAdministradoresInt objRemoto;

    public static void main(String[] args) throws RemoteException {

        int numPuertoRMIRegistry = 2021;
        String direccionIpRMIRegistry = "localhost";

        objRemoto = (ControladorGestionAdministradoresInt) UtilidadesRegistroC.obtenerObjRemoto(direccionIpRMIRegistry,
                numPuertoRMIRegistry, "objServicioGestionAdministradores");
        AdminitradorCallbackImpl objRemotoAdmin = new AdminitradorCallbackImpl();
        objRemoto.registrarReferenciaRemotaAdministrador(objRemotoAdmin);

        System.out.println("Cliente Administrador listo y esperando notificaciones");
    }

}
