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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "clanarina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clanarina.findAll", query = "SELECT c FROM Clanarina c")
    , @NamedQuery(name = "Clanarina.findByBrojClana", query = "SELECT c FROM Clanarina c WHERE c.clanarinaPK.brojClana = :brojClana")
    , @NamedQuery(name = "Clanarina.findByMesec", query = "SELECT c FROM Clanarina c WHERE c.clanarinaPK.mesec = :mesec")
    , @NamedQuery(name = "Clanarina.findByGodina", query = "SELECT c FROM Clanarina c WHERE c.clanarinaPK.godina = :godina")
    , @NamedQuery(name = "Clanarina.findByDatumUplate", query = "SELECT c FROM Clanarina c WHERE c.datumUplate = :datumUplate")
    , @NamedQuery(name = "Clanarina.findByIznos", query = "SELECT c FROM Clanarina c WHERE c.iznos = :iznos")
    , @NamedQuery(name = "Clanarina.findByKorisnik", query = "SELECT c FROM Clanarina c WHERE c.korisnik = :korisnik")})
public class Clanarina implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClanarinaPK clanarinaPK;
    @Column(name = "datum_uplate")
    @Temporal(TemporalType.DATE)
    private Date datumUplate;
    @Column(name = "iznos")
    private Integer iznos;
    @Size(max = 20)
    @Column(name = "korisnik")
    private String korisnik;
    @JoinColumn(name = "broj_clana", referencedColumnName = "broj_clana", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clan clan;

    public Clanarina() {
    }

    public Clanarina(ClanarinaPK clanarinaPK, Date datumUplate, Integer iznos, String korisnik) {
        this.clanarinaPK = clanarinaPK;
        this.datumUplate = datumUplate;
        this.iznos = iznos;
        this.korisnik = korisnik;
    }

   

    public ClanarinaPK getClanarinaPK() {
        return clanarinaPK;
    }

    public void setClanarinaPK(ClanarinaPK clanarinaPK) {
        this.clanarinaPK = clanarinaPK;
    }

    public Date getDatumUplate() {
        return datumUplate;
    }

    public void setDatumUplate(Date datumUplate) {
        this.datumUplate = datumUplate;
    }

    public Integer getIznos() {
        return iznos;
    }

    public void setIznos(Integer iznos) {
        this.iznos = iznos;
    }

    public String getKorisnik() {
        return korisnik;
    }

    public void setKorisnik(String korisnik) {
        this.korisnik = korisnik;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (clanarinaPK != null ? clanarinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clanarina)) {
            return false;
        }
        Clanarina other = (Clanarina) object;
        if ((this.clanarinaPK == null && other.clanarinaPK != null) || (this.clanarinaPK != null && !this.clanarinaPK.equals(other.clanarinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Clanarina[ clanarinaPK=" + clanarinaPK + " ]";
    }
    
}
