package servidor.Repositorios;

import java.util.ArrayList;
import sop_corba.ControladorCancionIntPackage.CancionDTO;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public interface CancionRepositoryInt {

    public boolean registrarCancion(CancionDTO objCancion);

    public ArrayList<CancionDTO> listarCanciones();
}
