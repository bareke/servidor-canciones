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

    @GetMapping("/usuarios")
    public List<Usuario> index() {
        return usuarioService.findAll();
    }

    @GetMapping("/usuarios/{email}/{pass}")
    public Usuario iniciarSesion(@PathVariable("email") String email, @PathVariable("pass") String pass) {
        Usuario objUsuario = usuarioService.login(email, pass);

        if (objUsuario != null) {
            System.out.println("Inicio sesion en el servidor " + objUsuario.getEmail());
        } else {
            System.out.println("Usuario o Contraseña invalidas...");
        }

        return objUsuario;
    }

    @GetMapping("/usuarios/{token}")
    public boolean verificarToken(@PathVariable("token") String token) {

        if (usuarioService.checkToken(token)) {
            System.out.println("El token es valido.");

            return true;

        } else {
            System.out.println("Error, el token es invalido.");

            return false;
        }
    }

    @PostMapping("/usuarios")
    public Usuario registrar(@RequestBody Usuario usuario) {
        Usuario objUsuario = usuarioService.register(usuario);

        if (objUsuario != null) {
            System.out.println("Usuario registrado.");
        } else {
            System.out.println("Error, no se pudo registrar el usuario.");
        }

        return objUsuario;
    }

}
