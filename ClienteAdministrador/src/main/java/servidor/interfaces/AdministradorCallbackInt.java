package servidor.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.NotificacionDTO;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public interface AdministradorCallbackInt extends Remote {

    public void imprimirCancion(NotificacionDTO objNotificacion) throws RemoteException;
}
