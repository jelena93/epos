/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author jelenas
 */
@Entity
@Table(name = "clanarina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clanarina.findAll", query = "SELECT c FROM Clanarina c"),
    @NamedQuery(name = "Clanarina.findByProgramId", query = "SELECT c FROM Clanarina c WHERE c.clanarinaPK.programId = :programId"),
    @NamedQuery(name = "Clanarina.findByBrojClana", query = "SELECT c FROM Clanarina c WHERE c.clanarinaPK.brojClana = :brojClana"),
    @NamedQuery(name = "Clanarina.findByMesec", query = "SELECT c FROM Clanarina c WHERE c.clanarinaPK.mesec = :mesec"),
    @NamedQuery(name = "Clanarina.findByGodina", query = "SELECT c FROM Clanarina c WHERE c.clanarinaPK.godina = :godina"),
    @NamedQuery(name = "Clanarina.findByIznos", query = "SELECT c FROM Clanarina c WHERE c.iznos = :iznos")})
public class Clanarina implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ClanarinaPK clanarinaPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "iznos")
    private int iznos;
    @JoinColumn(name = "broj_clana", referencedColumnName = "broj_clana", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Clan clan;
    @JoinColumn(name = "program_id", referencedColumnName = "program_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Program program;

    public Clanarina() {
    }

    public Clanarina(ClanarinaPK clanarinaPK) {
        this.clanarinaPK = clanarinaPK;
    }

    public Clanarina(ClanarinaPK clanarinaPK, int iznos) {
        this.clanarinaPK = clanarinaPK;
        this.iznos = iznos;
    }

    public Clanarina(int programId, int brojClana, String mesec, int godina) {
        this.clanarinaPK = new ClanarinaPK(programId, brojClana, mesec, godina);
    }

    public ClanarinaPK getClanarinaPK() {
        return clanarinaPK;
    }

    public void setClanarinaPK(ClanarinaPK clanarinaPK) {
        this.clanarinaPK = clanarinaPK;
    }

    public int getIznos() {
        return iznos;
    }

    public void setIznos(int iznos) {
        this.iznos = iznos;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
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
