package edu.coderhouse.Proyecto_Pre_entrega.entities;

import jakarta.persistence.*;
import java.util.Objects;

@Entity
@Table(name="Domicilio")
public class Domicilio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;

    @Column(name="CALLE")
    private String calle;

    @Column(name="NUM_INTERNO")
    private String numInterno;

    @Column(name="NUM_EXTERNO")
    private String numExterno;

    @Column(name="COLONIA")
    private String colonia;

    @Column(name="CP")
    private String cp;

    @Column(name="CIUDAD")
    private String ciudad;

    @Column(name="ESTADO")
    private String estado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumInterno() {
        return numInterno;
    }

    public void setNumInterno(String numInterno) {
        this.numInterno = numInterno;
    }

    public String getNumExterno() {
        return numExterno;
    }

    public void setNumExterno(String numExterno) {
        this.numExterno = numExterno;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Domicilio() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Domicilio domicilio = (Domicilio) o;
        return Objects.equals(calle, domicilio.calle) && Objects.equals(numInterno, domicilio.numInterno) && Objects.equals(numExterno, domicilio.numExterno) && Objects.equals(colonia, domicilio.colonia) && Objects.equals(cp, domicilio.cp) && Objects.equals(ciudad, domicilio.ciudad) && Objects.equals(estado, domicilio.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(calle, numInterno, numExterno, colonia, cp, ciudad, estado);
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", calle='" + calle + '\'' +
                ", numInterno='" + numInterno + '\'' +
                ", numExterno='" + numExterno + '\'' +
                ", colonia='" + colonia + '\'' +
                ", cp='" + cp + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}
