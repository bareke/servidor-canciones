package cliente.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

import cliente.modelos.Usuario;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class UsuarioServices {

    private String endPoint;
    private Client objClientePeticiones;

    public UsuarioServices() {
        this.endPoint = "http://localhost:4000/api/usuarios";
        this.objClientePeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public Usuario registrar(Usuario objUsuarioRegistar) {
        Usuario objUsuario;

        WebTarget target = this.objClientePeticiones.target(this.endPoint);
        Entity<Usuario> data = Entity.entity(objUsuarioRegistar, MediaType.APPLICATION_JSON_TYPE);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objUsuario = objPeticion.post(data, Usuario.class);

        return objUsuario;
    }

    public Usuario iniciarSesion(Usuario objUsuarioLogin) {
        Usuario objUsuario;

        WebTarget target = this.objClientePeticiones.target(
                this.endPoint + "/" + objUsuarioLogin.getEmail() + "/" + objUsuarioLogin.getContraseña());

        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        objUsuario = objPeticion.get(Usuario.class);

        return objUsuario;
    }

}
