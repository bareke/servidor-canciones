package servidor.controladores;

import servidor.interfaces.ControladorGestorCancionInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import servidor.services.UsuarioServices;
import servidor.DTO.Cancion;
import servidor.Repositorios.CancionRepositoryInt;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ControladorGestorCancionesImpl extends UnicastRemoteObject implements ControladorGestorCancionInt {

    private final CancionRepositoryInt objCancionesRepository;
    private final ControladorGestionAdministradoresImpl objReferenciaRemota;

    public ControladorGestorCancionesImpl(CancionRepositoryInt objCancionesRepository,
            ControladorGestionAdministradoresImpl objReferenciaRemota) throws RemoteException {
        super();
        this.objCancionesRepository = objCancionesRepository;
        this.objReferenciaRemota = objReferenciaRemota;
    }

    @Override
    public boolean registrarCancion(Cancion cancion, String token) throws RemoteException {
        boolean bandera = false;
        UsuarioServices objUsuarioService = new UsuarioServices();
        if (!objUsuarioService.ValidarToken(token)) {
            System.out.println("El token no es valido");
            return false;
        }
        System.out.println("El token es valido");

        if (this.objCancionesRepository.registrarCancion(cancion)) {
            bandera = true;
            ControladorGestionCancionRespaldo objRemotoRespaldo = new ControladorGestionCancionRespaldo();
            objRemotoRespaldo.guardarCopia(cancion);
            this.objReferenciaRemota.notificarAdministradores(cancion, objCancionesRepository.listarCanciones().size());
        }
        return bandera;
    }

    @Override
    public ArrayList<Cancion> listarCanciones() throws RemoteException {
        return this.objCancionesRepository.listarCanciones();
    }
}
