package co.edu.unicauca.distribuidos.core.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicauca.distribuidos.core.models.Usuario;
import co.edu.unicauca.distribuidos.core.services.IUsuarioService;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
@RestController
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuario/{id}")
    public Usuario show(@PathVariable String id) {
        Usuario objUsuario = null;
        objUsuario = usuarioService.findById(id);
        return objUsuario;
    }

    @GetMapping("/usuarios/{correo}/{contrasena}")
    public Usuario iniciarSesion(@PathVariable("correo") String correo, @PathVariable("contrasena") String contrasena) {
        Usuario objUsuario = usuarioService.iniciarSesion(correo, contrasena);

        if (objUsuario == null) {
            System.out.println("Usuario o Contraseña invalidas...");
            return objUsuario;
        }
        System.out.println("Bienvenido: " + objUsuario.getCorreo());
        return objUsuario;
    }

    @GetMapping("/usuarios/{token}")
    public boolean ValidarToken(@PathVariable("token") String token) {
        if (usuarioService.existeToken(token)) {

            System.out.println("Token valido");
            return true;

        } else {
            System.out.println("Token invalido");
            return false;
        }
    }

    @GetMapping("/usuarios")
    public List<Usuario> index() {
        return usuarioService.findAll();
    }

    @PostMapping("/usuarios")
    public Usuario registrar(@RequestBody Usuario nuevoUsuario) {
        Usuario objUsuario = usuarioService.save(nuevoUsuario);
        if (objUsuario == null) {
            System.out.println("No se pudo registrar el usuario.");
            return objUsuario;
        }
        System.out.println("Usuario registrado con éxito.");
        return objUsuario;
    }

}
