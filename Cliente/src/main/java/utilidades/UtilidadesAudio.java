package utilidades;

import cliente.modelos.Cancion;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class UtilidadesAudio {

    public static Cancion leerMetadatos(String nombreCancion) {
        String[] datosCancion = nombreCancion.split("\\.");

        Cancion objCancion = null;
        try {
            PrintStream obj;
            obj = new PrintStream(new File("archivoSalida.txt"));
            System.setErr(obj);
            File file = new File(nombreCancion);

            if (file.exists()) {
                if ("mp3".equals(datosCancion[1])) {
                    AudioFile f = AudioFileIO.read(file);
                    Tag tag = f.getTag();
                    int tamanio = (int) (file.length() / 1024);
                    String artista = tag.getFirst(FieldKey.ARTIST);
                    String titulo = tag.getFirst(FieldKey.TITLE);
                    String tipo = "mp3";
                    objCancion = new Cancion(tipo, artista, titulo, tamanio);
                } else {
                    System.out.println("Canción no tiene la extensión mp3.");
                }
            } else {
                System.out.println("Canción no existe.");
            }
        } catch (Exception ex) {
            System.out.println("Error al leer los métadatos del archivo.");
        }
        return objCancion;
    }

    public static byte[] obtenerBytesCancion(String nombreCancion) {
        byte[] arrayBytesCancion = null;
        try {
            File file = new File(nombreCancion);
            FileInputStream objFileInputStream = new FileInputStream(file);
            BufferedInputStream objBuffer = new BufferedInputStream(objFileInputStream);
            arrayBytesCancion = new byte[(int) file.length()];
            objBuffer.read(arrayBytesCancion, 0, arrayBytesCancion.length);
        } catch (FileNotFoundException ex) {
            System.out.println("Error, archivo no encontrado");
        } catch (IOException ex) {
            System.out.println("Error al leer los métadatos del archivo");
        }

        return arrayBytesCancion;
    }

}
