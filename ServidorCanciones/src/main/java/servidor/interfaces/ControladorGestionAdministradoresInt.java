package servidor.interfaces;

import java.rmi.RemoteException;
import java.rmi.Remote;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public interface ControladorGestionAdministradoresInt extends Remote {

    public void registrarReferenciaRemotaAdministrador(AdministradorCallbackInt objReferencia) throws RemoteException;
}
