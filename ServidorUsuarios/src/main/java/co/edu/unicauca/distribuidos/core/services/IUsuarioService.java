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

    public Usuario register(Usuario nuevoUsuario);

    public Usuario login(String email, String contraseña);

    public boolean checkToken(String token);

    public boolean checkEmail(String email);

}
