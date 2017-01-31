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
@Table(name = "student")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    , @NamedQuery(name = "Student.findByBrojIndeksa", query = "SELECT s FROM Student s WHERE s.brojIndeksa = :brojIndeksa")
    , @NamedQuery(name = "Student.findByIme", query = "SELECT s FROM Student s WHERE s.ime = :ime")
    , @NamedQuery(name = "Student.findByPrezime", query = "SELECT s FROM Student s WHERE s.prezime = :prezime")
    , @NamedQuery(name = "Student.findByLozinka", query = "SELECT s FROM Student s WHERE s.lozinka = :lozinka")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "broj_indeksa")
    private String brojIndeksa;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "lozinka")
    private String lozinka;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    private List<IspitnaPrijava> ispitnaPrijavaList;

    public Student() {
    }

    public Student(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
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
        hash += (brojIndeksa != null ? brojIndeksa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.brojIndeksa == null && other.brojIndeksa != null) || (this.brojIndeksa != null && !this.brojIndeksa.equals(other.brojIndeksa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Student[ brojIndeksa=" + brojIndeksa + " ]";
    }
    
}
