package co.edu.unicauca.distribuidos.core.services;

import java.util.List;

import co.edu.unicauca.distribuidos.core.models.Usuario;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public interface IUsuarioService {

    public List<Usuario> findAll();

    public Usuario findById(String id);

    public Usuario save(Usuario usuario);

    public Usuario iniciarSesion(String email, String contraseña);

    public boolean existeToken(String token);

    public boolean existeCorreo(String correo);

}
