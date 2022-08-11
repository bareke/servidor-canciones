package servidor.servicios;

import servidor.Repositorios.CancionRepository;
import servidor.controladores.ControladorGestorCancionesImpl;
import servidor.utilidades.UtilidadesRegistroS;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ServidorDeObjetos {

    public static void main(String[] args) {

        String[] vectorDatosLocalizarNS = new String[4];

        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        vectorDatosLocalizarNS[1] = "localhost";

        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        vectorDatosLocalizarNS[3] = "2020";

        try {
            CancionRepository objRepository = new CancionRepository();
            ControladorGestorCancionesImpl objRemotoGestionCanciones = new ControladorGestorCancionesImpl(objRepository);

            UtilidadesRegistroS.registrarObjetoRemoto(vectorDatosLocalizarNS, objRemotoGestionCanciones, "idObjetoRemoto");
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace(System.out);
        }
    }

}
