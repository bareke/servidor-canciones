package cliente.modelos;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @authors Cristian Collazos, Diego Rojas y Mayerly Camilo
 */
public class NotificacionDTO implements Serializable {

    private CancionDTO objCancion;
    private int cantidadCanciones;
    LocalDate fecheHoy;

    public NotificacionDTO(CancionDTO objCancion, int cantidadCanciones) {
        this.objCancion = objCancion;
        this.cantidadCanciones = cantidadCanciones;
        this.fecheHoy = LocalDate.now();
    }

    public CancionDTO getObjCancion() {
        return objCancion;
    }

    public void setObjCancion(CancionDTO objCancion) {
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