package servidor.Repositorios;

import java.util.List;
import sop_corba.ControladorCancionIntPackage.CancionDTO;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public interface CancionRepositoryInt {

    public boolean registrarCancion(CancionDTO cancion);

    public List<CancionDTO> listarCanciones();
}
