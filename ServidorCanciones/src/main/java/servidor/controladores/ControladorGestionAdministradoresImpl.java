package servidor.controladores;

import servidor.interfaces.AdministradorCallbackInt;
import servidor.interfaces.ControladorGestionAdministradoresInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import servidor.DTO.Cancion;
import servidor.DTO.NotificacionDTO;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ControladorGestionAdministradoresImpl extends UnicastRemoteObject implements ControladorGestionAdministradoresInt {

    private final List<AdministradorCallbackInt> referenciasAdministradores;

    public ControladorGestionAdministradoresImpl() throws RemoteException {
        super();
        this.referenciasAdministradores = new ArrayList();
    }

    @Override
    public void registrarReferenciaRemotaAdministrador(AdministradorCallbackInt objReferencia) throws RemoteException {
        this.referenciasAdministradores.add(objReferencia);
    }

    public void notificarAdministradores(Cancion cancion, int numeroCanciones) throws RemoteException {
        NotificacionDTO objNotificacion = new NotificacionDTO(cancion, numeroCanciones);

        for (AdministradorCallbackInt referencia : referenciasAdministradores) {
            referencia.imprimirCancion(objNotificacion);
        }
    }

}
