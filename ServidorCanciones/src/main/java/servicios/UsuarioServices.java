package servicios;

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
    private Client objUsuarioPeticiones;

    public UsuarioServices() {
        this.endPoint = "http://localhost:4000/api/";
        this.objUsuarioPeticiones = ClientBuilder.newClient().register(new JacksonFeature());
    }

    public boolean existeToken(String token) {
        boolean bandera;

        WebTarget target = this.objUsuarioPeticiones.target(this.endPoint + "usuarios/" + token);
        Builder objRespuesta = target.request(MediaType.APPLICATION_JSON_TYPE);

        bandera = objRespuesta.get(boolean.class);

        return bandera;
    }
}
