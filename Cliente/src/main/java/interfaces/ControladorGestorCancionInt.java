package interfaces;

import cliente.modelos.CancionDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
//Hereda de la clase Remote, lo cual la convierte en interfaz remota
public interface ControladorGestorCancionInt extends Remote {

    //Definicion del primer método remoto
    public boolean registrarCancion(CancionDTO objCancion, String token) throws RemoteException;

    //cada definición del método debe especificar que puede lanzar la excepción java.rmi.RemoteException
    public ArrayList<CancionDTO> listarCanciones() throws RemoteException;
}
