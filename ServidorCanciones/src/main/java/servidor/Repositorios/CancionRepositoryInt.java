package servidor.Repositorios;

import java.util.ArrayList;
import servidor.DTO.CancionDTOO;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public interface CancionRepositoryInt {

    public boolean registrarCancion(CancionDTOO objCancion);

    public ArrayList<CancionDTOO> listarCanciones();
}
