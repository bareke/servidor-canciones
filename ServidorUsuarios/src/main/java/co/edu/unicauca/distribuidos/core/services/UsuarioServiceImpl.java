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
    public Usuario register(Usuario nuevoUsuario) {
        return this.servicioAccesoBaseDatos.register(nuevoUsuario);
    }

    @Override
    public Usuario login(String email, String contraseña) {
        return this.servicioAccesoBaseDatos.login(email, contraseña);
    }

    @Override
    public boolean checkToken(String token) {
        return this.servicioAccesoBaseDatos.checkToken(token);
    }

    @Override
    public boolean checkEmail(String email) {
        return this.servicioAccesoBaseDatos.checkEmail(email);
    }

}
