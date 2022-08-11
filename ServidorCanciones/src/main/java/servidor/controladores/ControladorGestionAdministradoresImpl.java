package servidor.controladores;

import interfaces.AdministradorCallbackInt;
import interfaces.ControladorGestionAdministradoresInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import modelos.Cancion;
import modelos.NotificacionDTO;

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

    public void notificarAdministradores(Cancion objCancion, int nCanciones) throws RemoteException {
        NotificacionDTO objNotificacion = new NotificacionDTO(objCancion, nCanciones);
        for (AdministradorCallbackInt referencia : referenciasAdministradores) {
            referencia.notificarCancion(objNotificacion);
        }
    }

}
