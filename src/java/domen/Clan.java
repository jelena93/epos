/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Jelena
 */
@Entity
@Table(name = "clan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clan.findAll", query = "SELECT c FROM Clan c")
    , @NamedQuery(name = "Clan.findByBrojClana", query = "SELECT c FROM Clan c WHERE c.brojClana = :brojClana")
    , @NamedQuery(name = "Clan.findByDatumUclanjenja", query = "SELECT c FROM Clan c WHERE c.datumUclanjenja = :datumUclanjenja")
    , @NamedQuery(name = "Clan.findByIme", query = "SELECT c FROM Clan c WHERE c.ime = :ime")
    , @NamedQuery(name = "Clan.findByPrezime", query = "SELECT c FROM Clan c WHERE c.prezime = :prezime")
    , @NamedQuery(name = "Clan.findByKontakt", query = "SELECT c FROM Clan c WHERE c.kontakt = :kontakt")
    , @NamedQuery(name = "Clan.findByAdresa", query = "SELECT c FROM Clan c WHERE c.adresa = :adresa")})
public class Clan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "broj_clana")
    private Integer brojClana;
    @Column(name = "datum_uclanjenja")
    @Temporal(TemporalType.DATE)
    private Date datumUclanjenja;
    @Column(name = "ime")
    private String ime;
    @Column(name = "prezime")
    private String prezime;
    @Column(name = "kontakt")
    private String kontakt;
    @Column(name = "adresa")
    private String adresa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clan")
    private List<Clanarina> clanarinaList;

    public Clan() {
    }

    public Clan(Integer brojClana) {
        this.brojClana = brojClana;
    }

    public Integer getBrojClana() {
        return brojClana;
    }

    public void setBrojClana(Integer brojClana) {
        this.brojClana = brojClana;
    }

    public Date getDatumUclanjenja() {
        return datumUclanjenja;
    }

    public void setDatumUclanjenja(Date datumUclanjenja) {
        this.datumUclanjenja = datumUclanjenja;
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

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    @XmlTransient
    public List<Clanarina> getClanarinaList() {
        return clanarinaList;
    }

    public void setClanarinaList(List<Clanarina> clanarinaList) {
        this.clanarinaList = clanarinaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brojClana != null ? brojClana.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clan)) {
            return false;
        }
        Clan other = (Clan) object;
        if ((this.brojClana == null && other.brojClana != null) || (this.brojClana != null && !this.brojClana.equals(other.brojClana))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.Clan[ brojClana=" + brojClana + " ]";
    }
    
}
