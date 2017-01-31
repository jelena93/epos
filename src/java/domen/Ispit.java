/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "ispit")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ispit.findAll", query = "SELECT i FROM Ispit i")
    , @NamedQuery(name = "Ispit.findById", query = "SELECT i FROM Ispit i WHERE i.id = :id")
    , @NamedQuery(name = "Ispit.findByNaziv", query = "SELECT i FROM Ispit i WHERE i.naziv = :naziv")})
public class Ispit implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "naziv")
    private String naziv;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ispit")
    private List<IspitnaPrijava> ispitnaPrijavaList;

    public Ispit() {
    }

    public Ispit(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    @XmlTransient
    public List<IspitnaPrijava> getIspitnaPrijavaList() {
        return ispitnaPrijavaList;
    }

    public void setIspitnaPrijavaList(List<IspitnaPrijava> ispitnaPrijavaList) {
        this.ispitnaPrijavaList = ispitnaPrijavaList;
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
        if (!(object instanceof Ispit)) {
            return false;
        }
        Ispit other = (Ispit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Ispit[ id=" + id + " ]";
    }
    
}
