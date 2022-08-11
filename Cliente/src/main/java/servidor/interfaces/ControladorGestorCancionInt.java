package servidor.interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import servidor.DTO.Cancion;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public interface ControladorGestorCancionInt extends Remote {

    public boolean registrarCancion(Cancion objCancion, String token) throws RemoteException;

    public ArrayList<Cancion> listarCanciones() throws RemoteException;
}
