package edu.coderhouse.Proyecto_Pre_entrega.entities;

import jakarta.persistence.*;
import java.util.List;

import java.util.Objects;

@Entity
@Table(name="CLIENTE")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nombre")
    private String nombre;
    @Column(name="apellidoPaterno")
    private String apellidoPaterno;
    @Column(name="apellidoMaterno")
    private String apellidoMaterno;
    @Column(name="claveRegistro")
    private String claveRegistro;
    @ManyToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Domicilio> domicilio;

    public Cliente(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getClaveRegistro() {
        return claveRegistro;
    }

    public void setClaveRegistro(String claveRegistro) {
        this.claveRegistro = claveRegistro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellidoPaterno, cliente.apellidoPaterno) && Objects.equals(apellidoMaterno, cliente.apellidoMaterno) && Objects.equals(claveRegistro, cliente.claveRegistro) && Objects.equals(domicilio, cliente.domicilio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellidoPaterno, apellidoMaterno, claveRegistro, domicilio);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidoPaterno='" + apellidoPaterno + '\'' +
                ", apellidoMaterno='" + apellidoMaterno + '\'' +
                ", claveRegistro='" + claveRegistro + '\'' +
                ", domicilio=" + domicilio +
                '}';
    }
}
