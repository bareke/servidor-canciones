package servidor.Repositorios;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import modelos.Cancion;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class CancionRepository implements CancionRepositoryInt {

    private final ArrayList<Cancion> canciones;

    public CancionRepository() {
        this.canciones = new ArrayList();
    }

    private boolean almacenarArchivo(byte array[]) {
        boolean bandera = true;

        try {
            File objFile = new File("misCanciones/cancion_" + (canciones.size() + 1) + ".mp3");
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
    public boolean registrarCancion(Cancion objCancion) {

        boolean bandera;
        objCancion.setId((canciones.size() + 1));
        bandera = this.almacenarArchivo(objCancion.getArrayBytes());
        this.canciones.add(objCancion);
        System.out.println();
        System.out.println("Archivo creado en el servidor de canciones");
        System.out.println("Metadatos del archivo: ");
        System.out.println("Titulo: " + objCancion.getTitulo());
        System.out.println("Artista: " + objCancion.getArtista());
        System.out.println("Tipo: " + objCancion.getTipo());
        System.out.println("Tamaño: " + objCancion.getTamKB());
        System.out.println();

        return bandera;
    }

    @Override
    public ArrayList<Cancion> listarCanciones() {
        return this.canciones;
    }

}
