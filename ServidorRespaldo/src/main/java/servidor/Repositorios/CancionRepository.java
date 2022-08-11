package servidor.Repositorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import sop_corba.ControladorCancionIntPackage.CancionDTO;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class CancionRepository implements CancionRepositoryInt {

    private final ArrayList<CancionDTO> listaCanciones;

    public CancionRepository() {
        this.listaCanciones = new ArrayList();
    }

    @Override
    public List<CancionDTO> listarCanciones() {
        System.out.println("Listando canciones");
        return this.listaCanciones;
    }

    private boolean almacenarArchivo(byte array[]) {
        int varIncremento = listaCanciones.size() + 1;
        boolean bandera = true;
        try {
            File objFile = new File("misCanciones/copiaCancion_" + varIncremento + ".mp3");
            OutputStream output = new FileOutputStream(objFile);
            output.write(array);
        } catch (FileNotFoundException ex) {
            bandera = false;
        } catch (IOException ex) {
            bandera = false;
        }

        return bandera;
    }

    @Override
    public boolean registrarCancion(CancionDTO cancion) {

        boolean bandera;
        cancion.id = (this.listaCanciones.size());
        bandera = this.almacenarArchivo(cancion.getAudio());
        this.listaCanciones.add(cancion);

        System.out.println();
        System.out.println("Cancion registrada en el servidor");

        System.out.println();
        System.out.println("Metadatos del archivo: ");
        System.out.println("titulo: " + cancion.getTitulo());
        System.out.println("Artista: " + cancion.getArtista());
        System.out.println("tamano en KB: " + cancion.getTamKB());

        return bandera;
    }

}
