package servidor.controladores;

import servidor.DTO.Cancion;
import sop_corba.ControladorCancionInt;
import sop_corba.ControladorCancionIntPackage.CancionDTO;
import servidor.utilidades.UtilidadesNSC;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ControladorGestionCancionRespaldo {

    private ControladorCancionInt objRemoto;

    public ControladorGestionCancionRespaldo() {
        String[] vectorDatosLocalizarNS = new String[4];

        vectorDatosLocalizarNS[0] = "-ORBInitialHost";
        vectorDatosLocalizarNS[1] = "localhost";

        vectorDatosLocalizarNS[2] = "-ORBInitialPort";
        vectorDatosLocalizarNS[3] = "2020";

        objRemoto = UtilidadesNSC.obtenerObjRemoto(vectorDatosLocalizarNS, "idObjetoRemoto");
    }

    public void guardarCopia(Cancion cancion) {
        CancionDTO objCancionCorba = new CancionDTO();

        objCancionCorba.audio = cancion.getArrayBytes();
        objCancionCorba.artista = cancion.getArtista();
        objCancionCorba.id = cancion.getId();
        objCancionCorba.titulo = cancion.getTitulo();
        objCancionCorba.tamKB = cancion.getTamKB();

        objRemoto.registrarCancion(objCancionCorba);
    }

}
