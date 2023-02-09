package david.barre.poointerfaces.modelo;

import java.util.Objects;

public class Cliente extends BaseEntity {
    private String nombre;
    private String apellido;


    public Cliente(String nombre, String apellido) {
        super();
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    @Override
    public String toString() {
        return
                "id: " + id + "\n" +
                        "nombre: " + nombre + ' ' +
                        apellido;
    }


}
