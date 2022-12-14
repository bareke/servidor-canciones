package servidor.services;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.jackson.JacksonFeature;

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

    public boolean ValidarToken(String token) {
        boolean tokenValido;

        WebTarget target = this.objClientePeticiones.target(this.endPoint + "/" + token);
        Builder objPeticion = target.request(MediaType.APPLICATION_JSON_TYPE);

        tokenValido = objPeticion.get(boolean.class);

        return tokenValido;
    }
}
