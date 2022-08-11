package cliente.controladores;

import interfaces.AdministradorCallbackInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import cliente.modelos.NotificacionDTO;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class AdminitradorCallbackImpl extends UnicastRemoteObject implements AdministradorCallbackInt {

    public AdminitradorCallbackImpl() throws RemoteException {
        super();
    }

    @Override
    public void notificarCancion(NotificacionDTO objNotificacion) throws RemoteException {
        System.out.println(objNotificacion.toString());
    }

}
