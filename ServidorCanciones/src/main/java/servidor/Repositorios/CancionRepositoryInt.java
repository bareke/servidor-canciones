package servidor.Repositorios;

import java.util.ArrayList;
import servidor.DTO.Cancion;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public interface CancionRepositoryInt {

    public boolean registrarCancion(Cancion cancion);

    public ArrayList<Cancion> listarCanciones();
}
