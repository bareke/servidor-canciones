package servidor.servicios;

import servidor.DTO.CancionDTOO;
import sop_corba.ControladorCancionIntOperations;
import sop_corba.ControladorCancionIntPackage.CancionDTO;
import utilidades.UtilidadesNSC;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ClienteDeObjectos {

    private static ControladorCancionIntOperations objRemoto;

    public ClienteDeObjectos() {

        String[] vectorDatosLocalizarNS = new String[4];

        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        vectorDatosLocalizarNS[1] = "localhost";

        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        vectorDatosLocalizarNS[3] = "2020";

        objRemoto = UtilidadesNSC.obtenerObjRemoto(vectorDatosLocalizarNS, "idObjetoRemoto");
    }

    public static ControladorCancionIntOperations obtenerReferenciaRemota() {
        return objRemoto;
    }
}
