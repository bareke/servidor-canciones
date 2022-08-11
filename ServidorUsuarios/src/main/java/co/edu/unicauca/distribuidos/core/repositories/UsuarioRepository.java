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

    private ArrayList<Usuario> listaUsuarios;

    public UsuarioRepository() {
        this.listaUsuarios = new ArrayList<>();
    }

    public List<Usuario> findAll() {
        System.out.println("Invocando a listarclientes");
        return this.listaUsuarios;
    }

    public Usuario findById(String id) {
        System.out.println("Invocando a consultar un cliente");
        Usuario objCliente = null;

        for (Usuario cliente : listaUsuarios) {
            if (cliente.getId() == id) {
                objCliente = cliente;
                break;
            }
        }

        return objCliente;
    }

    public Usuario save(Usuario usuario) {
        System.out.println("Invocando a registrar usuario");

        if (!existeCorreo(usuario.getCorreo())) {
            usuario.setId(UUID.randomUUID().toString());
            usuario.setToken(UUID.randomUUID().toString());
            usuario.setCreateAt(new Date());
            listaUsuarios.add(usuario);
            return usuario;
        } else {
            System.out.println("Ya existe un usuario con el email ingresado");
            return null;
        }
    }

    public Usuario iniciarSesion(String email, String contrasena) {
        System.out.println("Invocando a iniciar sesion");

        Usuario user = null;
        for (Usuario item : listaUsuarios) {
            if (item.getCorreo().equals(email) && item.getContrasena().equals(contrasena)) {
                user = item;
            }
        }
        return user;
    }

    public boolean existeToken(String token) {
        System.out.println("Invocando a existe token");

        for (Usuario item : listaUsuarios) {
            if (item.getToken().equals(token)) {
                return true;
            }
        }
        return false;
    }

    public boolean existeCorreo(String correo) {
        for (Usuario item : listaUsuarios) {
            if (item.getCorreo().equals(correo)) {
                return true;
            }
        }
        return false;
    }

}
