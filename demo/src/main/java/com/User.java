package com;

import java.sql.Date;
import java.util.Objects;

/**
 * @author alexfdb
 * @version 1.0.0
 */
public class User {

    private int id;
    private int idDepartamento;
    private String nombre;
    private Date fecha;
    private float sueldo;

    /**
     * Constructor por defecto.
     */
    public User() {
    }

    /**
     * Constructor general.
     * @param id id del usuario.
     * @param idDepartamento id del departamento del usuario.
     * @param nombre nombre del usuario.
     * @param fecha fecha del usuario.
     * @param sueldo sueldo del usuario.
     */
    public User(int id, int idDepartamento, String nombre, Date fecha, float sueldo) {
        this.id = id;
        this.idDepartamento = idDepartamento;
        this.nombre = nombre;
        this.fecha = fecha;
        this.sueldo = sueldo;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDepartamento() {
        return this.idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public float getSueldo() {
        return this.sueldo;
    }

    public void setSueldo(float sueldo) {
        this.sueldo = sueldo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", idDepartamento='" + getIdDepartamento() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", fecha='" + getFecha() + "'" +
            ", sueldo='" + getSueldo() + "'" +
            "}";
    }
    
}