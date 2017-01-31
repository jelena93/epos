/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "ispitna_prijava")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IspitnaPrijava.findAll", query = "SELECT i FROM IspitnaPrijava i")
    , @NamedQuery(name = "IspitnaPrijava.findByPredmetId", query = "SELECT i FROM IspitnaPrijava i WHERE i.ispitnaPrijavaPK.predmetId = :predmetId")
    , @NamedQuery(name = "IspitnaPrijava.findByBrojIndeksa", query = "SELECT i FROM IspitnaPrijava i WHERE i.ispitnaPrijavaPK.brojIndeksa = :brojIndeksa")
    , @NamedQuery(name = "IspitnaPrijava.findByDatumPolaganja", query = "SELECT i FROM IspitnaPrijava i WHERE i.datumPolaganja = :datumPolaganja")
    , @NamedQuery(name = "IspitnaPrijava.findByOcena", query = "SELECT i FROM IspitnaPrijava i WHERE i.ocena = :ocena")})
public class IspitnaPrijava implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected IspitnaPrijavaPK ispitnaPrijavaPK;
    @Column(name = "datum_polaganja")
    @Temporal(TemporalType.DATE)
    private Date datumPolaganja;
    @Column(name = "ocena")
    private Integer ocena;
    @JoinColumn(name = "predmet_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ispit ispit;
    @JoinColumn(name = "broj_indeksa", referencedColumnName = "broj_indeksa", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Student student;

    public IspitnaPrijava() {
    }

    public IspitnaPrijava(IspitnaPrijavaPK ispitnaPrijavaPK) {
        this.ispitnaPrijavaPK = ispitnaPrijavaPK;
    }

    public IspitnaPrijava(int predmetId, String brojIndeksa) {
        this.ispitnaPrijavaPK = new IspitnaPrijavaPK(predmetId, brojIndeksa);
    }

    public IspitnaPrijavaPK getIspitnaPrijavaPK() {
        return ispitnaPrijavaPK;
    }

    public void setIspitnaPrijavaPK(IspitnaPrijavaPK ispitnaPrijavaPK) {
        this.ispitnaPrijavaPK = ispitnaPrijavaPK;
    }

    public Date getDatumPolaganja() {
        return datumPolaganja;
    }

    public void setDatumPolaganja(Date datumPolaganja) {
        this.datumPolaganja = datumPolaganja;
    }

    public Integer getOcena() {
        return ocena;
    }

    public void setOcena(Integer ocena) {
        this.ocena = ocena;
    }

    public Ispit getIspit() {
        return ispit;
    }

    public void setIspit(Ispit ispit) {
        this.ispit = ispit;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (ispitnaPrijavaPK != null ? ispitnaPrijavaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IspitnaPrijava)) {
            return false;
        }
        IspitnaPrijava other = (IspitnaPrijava) object;
        if ((this.ispitnaPrijavaPK == null && other.ispitnaPrijavaPK != null) || (this.ispitnaPrijavaPK != null && !this.ispitnaPrijavaPK.equals(other.ispitnaPrijavaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.IspitnaPrijava[ ispitnaPrijavaPK=" + ispitnaPrijavaPK + " ]";
    }
    
}
