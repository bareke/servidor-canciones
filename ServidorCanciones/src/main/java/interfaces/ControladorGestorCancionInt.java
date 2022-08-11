package interfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import modelos.Cancion;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGestorCancionInt extends Remote {

    //Definicion del primer método remoto
    public boolean registrarCancion(Cancion objCancion, String token) throws RemoteException;

    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
    public ArrayList<Cancion> listarCanciones() throws RemoteException;
}
