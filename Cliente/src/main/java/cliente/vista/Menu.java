package cliente.vista;

import servidor.interfaces.ControladorGestorCancionInt;
import java.rmi.RemoteException;
import java.util.ArrayList;
import cliente.modelos.Usuario;
import cliente.services.UsuarioServices;
import servidor.DTO.Cancion;
import cliente.utilidades.UtilidadesAudio;
import cliente.utilidades.UtilidadesConsola;
import cliente.utilidades.UtilidadesValidaciones;

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
        System.out.println("\n Registrar usuario");

        objUsuario = new Usuario();

        System.out.println("Nombre");
        objUsuario.setNombre(UtilidadesConsola.leerCadena());

        System.out.println("Apellido");
        objUsuario.setApellido(UtilidadesConsola.leerCadena());

        System.out.println("Correo");
        objUsuario.setEmail(UtilidadesConsola.leerCadena());

        System.out.println("Contraseña");
        objUsuario.setContraseña(UtilidadesConsola.leerCadena());

        if (objUsuarioServices.registrar(objUsuario) == null) {
            System.out.println("Error, no se pudo registrar el usuario");
            return;
        }
        System.out.println("Usuario registrado con exito");
    }

    private void Opcion2() {
        System.out.println("\n Iniciar sesion");

        objUsuario = new Usuario();

        System.out.println("Correo");
        objUsuario.setEmail(UtilidadesConsola.leerCadena());

        System.out.println("Contraseña");
        objUsuario.setContraseña(UtilidadesConsola.leerCadena());

        objUsuario = objUsuarioServices.iniciarSesion(objUsuario);

        if (objUsuario != null) {
            System.out.println("Inicio sesion como " + objUsuario.getNombre());
        } else {
            System.out.println("Error, correo o contraseña invalida");
        }

    }

    private void Opcion3() {
        System.out.println("\n Registrar cancion");

        String nombre = UtilidadesConsola.leerCadena();

        if (UtilidadesValidaciones.existe(nombre)) {

            Cancion objCancion = UtilidadesAudio.leerMetadatos(nombre);
            byte[] arrayBytesCancion = UtilidadesAudio.obtenerBytesCancion(nombre);
            objCancion.setArrayBytes(arrayBytesCancion);
            boolean respuesta = false;

            try {
                respuesta = objRemoto.registrarCancion(objCancion, objUsuario.getToken());
            } catch (RemoteException ex) {
                System.out.println(ex.getMessage());
            }

            if (respuesta) {
                System.out.println("Registro realizado satisfactoriamente");
            } else {
                System.out.println("Error, no se pudo realizar el registro");
            }
        }

    }

    private void Opcion4() {
        ArrayList<Cancion> canciones = new ArrayList<>();

        try {
            canciones = objRemoto.listarCanciones();
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
        }

        if (!canciones.isEmpty()) {
            System.out.println("Lista de canciones:");
            System.out.println();

            for (Cancion cancion : canciones) {
                System.out.println("Id: " + cancion.getId());
                System.out.println("Titulo: " + cancion.getTitulo());
                System.out.println("Artista: " + cancion.getArtista());
                System.out.println("Tipo: " + cancion.getTipo());
                System.out.println("Tamaño: " + cancion.getTamKB() + " KB");
                System.out.println();
            }
        } else {
            System.out.println("No hay canciones registradas");
        }
    }

}
