package servidor.controladores;

import servidor.servicios.ClienteDeObjectos;
import interfaces.ControladorGestorCancionInt;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import modelos.Cancion;
import servicios.UsuarioServices;
import servidor.Repositorios.CancionRepositoryInt;
import sop_corba.ControladorCancionIntOperations;
import sop_corba.ControladorCancionIntPackage.CancionDTO;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class ControladorGestorCancionesImpl extends UnicastRemoteObject implements ControladorGestorCancionInt {

    private final CancionRepositoryInt objCancionesRepository;
    private final ControladorGestionAdministradoresImpl objReferenciaRemota;

    public ControladorGestorCancionesImpl(CancionRepositoryInt objCancionesRepository,
            ControladorGestionAdministradoresImpl objReferenciaRemota) throws RemoteException {
        super();
        this.objCancionesRepository = objCancionesRepository;
        this.objReferenciaRemota = objReferenciaRemota;
    }

    @Override
    public boolean registrarCancion(Cancion objCancion, String token) throws RemoteException {
        boolean bandera = false;
        UsuarioServices objUsuarioService = new UsuarioServices();

        if (objUsuarioService.existeToken(token)) {
            System.out.println("Token valido");

            if (this.objCancionesRepository.registrarCancion(objCancion)) {
                bandera = true;
                ClienteDeObjectos clienteObjetos = new ClienteDeObjectos();
                ControladorCancionIntOperations servidorRespaldo = ClienteDeObjectos.obtenerReferenciaRemota();

                CancionDTO objCancionDTO = new CancionDTO(objCancion.getId(), objCancion.getArtista(), objCancion.getTitulo(), objCancion.getTipo(), objCancion.getTamKB(), objCancion.getArrayBytes());
                objCancionDTO.artista = objCancion.getArtista();
                objCancionDTO.titulo = objCancion.getTitulo();
                objCancionDTO.tipo = objCancion.getTipo();
                objCancionDTO.tamKB = objCancion.getTamKB();
                objCancionDTO.audio = objCancion.getArrayBytes();

                servidorRespaldo.registrarCancion(objCancionDTO);
                this.objReferenciaRemota.notificarAdministradores(objCancion, objCancionesRepository.listarCanciones().size());

                System.out.println("Registro realizado satisfactoriamente...");
            } else {
                System.out.println("No se pudo realizar el registro...");
            }
        } else {
            System.out.println("Error, el token no es valido");
        }

        return bandera;
    }

    @Override
    public ArrayList<Cancion> listarCanciones() throws RemoteException {
        return this.objCancionesRepository.listarCanciones();
    }
}
