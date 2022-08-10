package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import servidor.DTO.NotificacionDTO;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface AdministradorCallbackInt extends Remote {

    public void notificarCancion(NotificacionDTO objNotificacion) throws RemoteException;
}
