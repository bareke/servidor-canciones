package cliente.controladores;

import servidor.interfaces.AdministradorCallbackInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import servidor.DTO.NotificacionDTO;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class AdminitradorCallbackImpl extends UnicastRemoteObject implements AdministradorCallbackInt {

    public AdminitradorCallbackImpl() throws RemoteException {
        super();
    }

    @Override
    public void imprimirCancion(NotificacionDTO objNotificacion) throws RemoteException {
        System.out.println(objNotificacion.toString());
    }

}
