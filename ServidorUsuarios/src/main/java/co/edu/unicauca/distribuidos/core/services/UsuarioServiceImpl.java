package co.edu.unicauca.distribuidos.core.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicauca.distribuidos.core.models.Usuario;
import co.edu.unicauca.distribuidos.core.repositories.UsuarioRepository;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private UsuarioRepository servicioAccesoBaseDatos;

    @Override
    public List<Usuario> findAll() {
        return this.servicioAccesoBaseDatos.findAll();
    }

    @Override
    public Usuario findById(String id) {
        return this.servicioAccesoBaseDatos.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return this.servicioAccesoBaseDatos.save(usuario);
    }

    @Override
    public boolean existeCorreo(String correo) {
        return this.servicioAccesoBaseDatos.existeCorreo(correo);
    }

    @Override
    public Usuario iniciarSesion(String correo, String contrasena) {
        return this.servicioAccesoBaseDatos.iniciarSesion(correo, contrasena);
    }

    @Override
    public boolean existeToken(String token) {
        return this.servicioAccesoBaseDatos.existeToken(token);
    }
}
