/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Laboratorios
 */
@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ap_paterno")
    private String apPaterno;
    @Column(name = "ap_materno")
    private String apMaterno;
    private String nombres;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Direccion> direcciones;

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente() {
    }

    public Cliente(Long id) {
        this.id = id;
    }

    public Cliente(String apPaterno, String apMaterno, String nombres) {
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.nombres = nombres;
    }

    public Cliente(Long id, String apPaterno, String apMaterno, String nombres) {
        this.id = id;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.nombres = nombres;
    }   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public String getApPaterno() {
        return apPaterno;
    }

    public void setApPaterno(String apPaterno) {
        this.apPaterno = apPaterno;
    }

    public String getApMaterno() {
        return apMaterno;
    }

    public void setApMaterno(String apMaterno) {
        this.apMaterno = apMaterno;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", nombres=" + nombres + '}';
    }
    
    

}
