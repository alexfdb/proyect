package com;
import java.util.Objects;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class Departamento {
 
    private int id;
    private String nombre;

    /**
     * Constructor por defecto.
     */
    public Departamento() {
    }

    /**
     * Constructor general.
     * @param id id del departamento.
     * @param nombre nombre del departamento.
     */
    public Departamento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Departamento)) {
            return false;
        }
        Departamento departamento = (Departamento) o;
        return id == departamento.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nombre='" + getNombre() + "'" +
            "}";
    }    
    
}