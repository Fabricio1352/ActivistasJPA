/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Set;
import javax.persistence.*;

/**
 *
 * @author Laboratorios
 */
@Entity
@Table(name = "activista")
public class Activista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombres;
    @Column(name = "ap_paterno")
    private String apPaterno;
    @Column(name = "ap_materno")
    private String apMaterno;
    @Column(name = "telefono", unique = true)
    private String telefono;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Calendar fechaInicioLabores;

    @ManyToMany
    @JoinTable(
            name = "activistasdelprograma",
            joinColumns = @JoinColumn(name = "idActivista"),
            inverseJoinColumns = @JoinColumn(name = "idProblema")
    )
    Set<Problema> activistasProblemas;

    public Activista() {
    }

    public Activista(Long id) {
        this.id = id;
    }

    public Activista(Long id, String nombres, String apPaterno, String apMaterno, String telefono, Calendar fechaInicioLabores) {
        this.id = id;
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.telefono = telefono;
        this.fechaInicioLabores = fechaInicioLabores;
    }

    public Activista(String nombres, String apPaterno, String apMaterno, String telefono, Calendar fechaInicioLabores) {
        this.nombres = nombres;
        this.apPaterno = apPaterno;
        this.apMaterno = apMaterno;
        this.telefono = telefono;
        this.fechaInicioLabores = fechaInicioLabores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Calendar getFechaInicioLabores() {
        return fechaInicioLabores;
    }

    public void setFechaInicioLabores(Calendar fechaInicioLabores) {
        this.fechaInicioLabores = fechaInicioLabores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public Set<Problema> getActivistasProblemas() {
        return activistasProblemas;
    }

    public void setActivistasProblemas(Set<Problema> activistasProblemas) {
        this.activistasProblemas = activistasProblemas;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Activista)) {
            return false;
        }
        Activista other = (Activista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Activista{" + "id=" + id + ", nombres=" + nombres + ", apPaterno=" + apPaterno + ", apMaterno=" + apMaterno + ", telefono=" + telefono + ", fechaInicioLabores=" + fechaInicioLabores + ", activistasProblemas=" + activistasProblemas + '}';
    }


}
