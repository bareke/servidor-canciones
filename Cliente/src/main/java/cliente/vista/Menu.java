package cliente.vista;

import interfaces.ControladorGestorCancionInt;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Usuario;
import servicios.UsuarioServices;
import servidor.DTO.CancionDTOO;
import utilidades.UtilidadesAudio;
import utilidades.UtilidadesConsola;
import utilidades.UtilidadesValidaciones;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class Menu {

    private final ControladorGestorCancionInt objRemoto;
    private final UsuarioServices objUsuarioServices = new UsuarioServices();
    private Usuario objUsuario;

    public Menu(ControladorGestorCancionInt objRemoto) {
        this.objRemoto = objRemoto;
    }

    public void ejecutarMenuPrincipal() {
        int opcion = 0;
        do {
            System.out.println();
            System.out.println("===Menu===");
            System.out.println("1. Registrarse en el servidor de usuarios");
            System.out.println("2. Iniciar sesion");
            System.out.println("3. Ingresar y enviar datos de la cancion");
            System.out.println("4. Listar datos de las canciones registradas");
            System.out.println("5. Salir");

            opcion = UtilidadesConsola.leerEntero();

            switch (opcion) {
                case 1:
                    Opcion1();
                    break;
                case 2:
                    Opcion2();
                    break;
                case 3:
                    Opcion3();
                    break;
                case 4:
                    Opcion4();
                    break;
                case 5:
                    System.out.println("Salir...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }

        } while (opcion != 5);
    }

    private void Opcion1() {
        objUsuario = new Usuario();
        System.out.println("\n Registrando usuario");

        System.out.println("Nombre");
        objUsuario.setNombre(UtilidadesConsola.leerCadena());

        System.out.println("Apellido");
        objUsuario.setApellido(UtilidadesConsola.leerCadena());

        System.out.println("Correo");
        objUsuario.setEmail(UtilidadesConsola.leerCadena());

        System.out.println("Contraseña");
        objUsuario.setContraseña(UtilidadesConsola.leerCadena());

        if (objUsuarioServices.registrarUsuario(objUsuario) != null) {
            System.out.println("Registro realizado satisfactoriamente...");
        } else {
            System.out.println("No se pudo realizar el registro...");
        }

    }

    private void Opcion2() {
        System.out.println("\n Iniciar sesion");

        objUsuario = new Usuario();

        System.out.println("Correo");
        objUsuario.setEmail(UtilidadesConsola.leerCadena());

        System.out.println("Contraseña");
        objUsuario.setContraseña(UtilidadesConsola.leerCadena());

        objUsuario = objUsuarioServices.Login(objUsuario);
        if (objUsuario != null) {
            System.out.println("Hola de nuevo " + objUsuario.getNombre());
        } else {
            System.out.println("Correo o contraseña invalida...");
        }

    }

    private void Opcion3() {
        System.out.println("\n Enviar cancion");

        System.out.println("Nombre de la cancion");
        String nombreCancion = UtilidadesConsola.leerCadena();

        if (UtilidadesValidaciones.existe(nombreCancion)) {
            CancionDTOO objCancion = UtilidadesAudio.leerMetadatos(nombreCancion);

            if (objCancion != null) {
                byte[] arrayBytesCancion = UtilidadesAudio.obtenerBytesCancion(nombreCancion);
                objCancion.setArrayBytes(arrayBytesCancion);

                try {
                    if (objRemoto.registrarCancion(objCancion, objUsuario.getToken())) {
                        System.out.println("Registro realizado satisfactoriamente...");
                    } else {
                        System.out.println("No se pudo realizar el registro...");
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void Opcion4() {
        ArrayList<CancionDTOO> canciones = new ArrayList();
        try {
            canciones = objRemoto.listarCanciones();
        } catch (RemoteException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (!canciones.isEmpty()) {
            System.out.println("Lista de canciones");
            System.out.println();

            for (CancionDTOO cancion : canciones) {
                System.out.println("Id: " + cancion.getId());
                System.out.println("Titulo: " + cancion.getTitulo());
                System.out.println("Artista: " + cancion.getArtista());
                System.out.println("Tipo: " + cancion.getTipo());
                System.out.println("Tamaño: " + cancion.getTamKB());
                System.out.println();
            }
        } else {
            System.out.println("No existen canciones en el servidor.");
        }
    }
}
