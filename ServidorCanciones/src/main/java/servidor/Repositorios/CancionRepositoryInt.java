package servidor.Repositorios;

import java.util.ArrayList;
import modelos.Cancion;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public interface CancionRepositoryInt {

    public boolean registrarCancion(Cancion objCancion);

    public ArrayList<Cancion> listarCanciones();
}
