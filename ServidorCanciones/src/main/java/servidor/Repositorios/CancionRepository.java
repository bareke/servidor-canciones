package servidor.Repositorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import servidor.DTO.Cancion;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class CancionRepository implements CancionRepositoryInt {

    private final ArrayList<Cancion> listaCanciones;

    public CancionRepository() {
        this.listaCanciones = new ArrayList();
    }

    private boolean almacenarCancion(byte array[]) {
        boolean bandera = true;

        try {
            File objFile = new File("misCanciones/cancion_" + (listaCanciones.size() + 1) + ".mp3");
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
    public boolean registrarCancion(Cancion cancion) {

        boolean bandera;
        cancion.setId(listaCanciones.size() + 1);
        bandera = this.almacenarCancion(cancion.getArrayBytes());
        this.listaCanciones.add(cancion);

        System.out.println();
        System.out.println("Cancion registrada en el servidor");

        System.out.println("Datos de la cancion: ");
        System.out.println();

        System.out.println("titulo: " + cancion.getTitulo());
        System.out.println("Artista: " + cancion.getArtista());
        System.out.println("Tipo: " + cancion.getTipo());
        System.out.println("tamaño: " + cancion.getTamKB() + " KB");
        System.out.println();
        return bandera;
    }

    @Override
    public ArrayList<Cancion> listarCanciones() {
        return this.listaCanciones;
    }

}
