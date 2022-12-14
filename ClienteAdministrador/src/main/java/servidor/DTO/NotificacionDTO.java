package servidor.DTO;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class NotificacionDTO implements Serializable {

    private Cancion objCancion;
    private int cantidadCanciones;
    LocalDate fecheHoy;

    public NotificacionDTO(Cancion objCancion, int cantidadCanciones) {
        this.objCancion = objCancion;
        this.cantidadCanciones = cantidadCanciones;
        this.fecheHoy = LocalDate.now();
    }

    public Cancion getObjCancion() {
        return objCancion;
    }

    public void setObjCancion(Cancion objCancion) {
        this.objCancion = objCancion;
    }

    public int getCantidadCanciones() {
        return cantidadCanciones;
    }

    public void setCantidadCanciones(int cantidadCanciones) {
        this.cantidadCanciones = cantidadCanciones;
    }

    @Override
    public String toString() {
        return "\nNotificación\n"
                + "Una nueva canción se ha registrado"
                + "\nId: " + objCancion.getId()
                + "\nTitulo: " + objCancion.getTitulo()
                + "\nArtista: " + objCancion.getArtista()
                + "\nTipo: " + objCancion.getTipo()
                + "\nTamaño: " + objCancion.getTamKB() + " KB"
                + "\nFecha de registro de la canción en el servidor: " + fecheHoy
                + "\nCantidad de canciones registradas: " + cantidadCanciones;
    }

}
