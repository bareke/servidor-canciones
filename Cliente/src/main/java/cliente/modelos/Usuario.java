package cliente.modelos;

import java.util.Date;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class Usuario {

    private String id;
    private String nombre;
    private String apellido;
    private String email;
    private Date createAt;
    private String token;
    private String contraseña;

    public Usuario() {
    }

    public Usuario(String id, String nombre, String apellido, String email,
            Date createAt, String token, String contraseña) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.createAt = createAt;
        this.token = token;
        this.contraseña = contraseña;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

}
