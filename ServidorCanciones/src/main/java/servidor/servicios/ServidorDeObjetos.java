package servidor.servicios;

import java.rmi.RemoteException;
import servidor.Repositorios.CancionRepository;
import servidor.controladores.ControladorGestionAdministradoresImpl;
import servidor.controladores.ControladorGestorCancionesImpl;
import utilidades.UtilidadesRegistroS;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ServidorDeObjetos {

    public static void main(String args[]) throws RemoteException {

        int numPuertoRMIRegistryServidorCanciones = 2021;
        String direccionIpRMIRegistryServidorCanciones = "localhost";

        System.out.println("Servidor Canciones conectado en " + direccionIpRMIRegistryServidorCanciones + " con puerto " + numPuertoRMIRegistryServidorCanciones);

        CancionRepository objRepository = new CancionRepository();
        ControladorGestionAdministradoresImpl objRemotoGestionAdministradores = new ControladorGestionAdministradoresImpl();
        ControladorGestorCancionesImpl objRemotoGestionCanciones = new ControladorGestorCancionesImpl(
                objRepository, objRemotoGestionAdministradores);

        try {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistryServidorCanciones);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoGestionCanciones, direccionIpRMIRegistryServidorCanciones,
                    numPuertoRMIRegistryServidorCanciones, "objServicioGestionCanciones");
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoGestionAdministradores, direccionIpRMIRegistryServidorCanciones,
                    numPuertoRMIRegistryServidorCanciones, "objServicioGestionAdministradores");
        } catch (Exception e) {
            System.err.println("No fue posible Arrancar el NS o Registrar el objeto remoto" + e.getMessage());
        }

    }
}
