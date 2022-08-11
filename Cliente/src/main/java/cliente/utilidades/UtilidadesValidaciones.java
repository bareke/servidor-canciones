package cliente.utilidades;

import java.io.File;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class UtilidadesValidaciones {

    public static boolean existe(String Nombre) {
        boolean bandera = false;

        File file = new File(Nombre);

        if (file.exists()) {
            bandera = true;
            System.out.println("Archivo encontrado.");
            String[] newStr = Nombre.split("\\.");
            if ("mp3".equals(newStr[1]) || "MP3".equals(newStr[1])) {
                bandera = true;
            } else {
                System.out.println("Error, el archivo no es MP3");
                bandera = false;
            }
        } else {
            System.out.println("Error, archivo no encontrado");
        }

        return bandera;
    }

}
