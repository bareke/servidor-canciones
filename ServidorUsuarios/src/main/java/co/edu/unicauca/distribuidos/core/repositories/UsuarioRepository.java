package co.edu.unicauca.distribuidos.core.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.models.Usuario;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
@Service
public class UsuarioRepository {

    private ArrayList<Usuario> usuarios;

    public UsuarioRepository() {
        this.usuarios = new ArrayList<>();
        this.cargarUsuarios();
    }

    public List<Usuario> findAll() {
        System.out.println("Invocando a listar usuarios");

        return this.usuarios;
    }

    public Usuario findById(String id) {
        System.out.println("Invocando a consultar un usuario");

        Usuario objUsuario = null;

        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                objUsuario = usuario;
                break;
            }
        }

        return objUsuario;
    }


    public Usuario register(Usuario usuario) {
        System.out.println("Invocando a registrar usuario");

        if (!checkEmail(usuario.getEmail())) {
            usuario.setId(UUID.randomUUID().toString());
            usuario.setToken(UUID.randomUUID().toString());
            usuario.setCreateAt(new Date());

            usuarios.add(usuario);

            return usuario;
        } else {
            System.out.println("Error, existe un usuario con el mismo correo");

            return null;
        }
    }

    public Usuario login(String email, String contraseña) {
        System.out.println("Invocando a iniciar sesion");

        Usuario usuario = null;
        for (Usuario item : usuarios) {
            if (item.getEmail().equals(email) && item.getContraseña().equals(contraseña)) {
                usuario = item;
            }
        }
        return usuario;
    }

    public boolean checkEmail(String email) {
        System.out.println("Invocando a verificar correo");

        for (Usuario item : usuarios) {
            if (item.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkToken(String token) {
        System.out.println("Invocando a verificar token");

        for (Usuario item : usuarios) {
            if (item.getToken().equals(token)) {
                return true;
            }
        }
        return false;
    }

    private void cargarUsuarios() {
        Usuario objUsuario = new Usuario(UUID.randomUUID().toString(), "Daniel", "Paz", "danielpaz@unicauca.edu.co", new Date(), UUID.randomUUID().toString(), "java");
        this.usuarios.add(objUsuario);
    }

}
