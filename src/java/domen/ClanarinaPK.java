/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Jelena
 */
@Embeddable
public class ClanarinaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "program_id")
    private int programId;
    @Basic(optional = false)
    @Column(name = "broj_clana")
    private int brojClana;
    @Basic(optional = false)
    @Column(name = "mesec")
    private String mesec;
    @Basic(optional = false)
    @Column(name = "godina")
    private int godina;

    public ClanarinaPK() {
    }

    public ClanarinaPK(int programId, int brojClana, String mesec, int godina) {
        this.programId = programId;
        this.brojClana = brojClana;
        this.mesec = mesec;
        this.godina = godina;
    }

    public int getProgramId() {
        return programId;
    }

    public void setProgramId(int programId) {
        this.programId = programId;
    }

    public int getBrojClana() {
        return brojClana;
    }

    public void setBrojClana(int brojClana) {
        this.brojClana = brojClana;
    }

    public String getMesec() {
        return mesec;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) programId;
        hash += (int) brojClana;
        hash += (mesec != null ? mesec.hashCode() : 0);
        hash += (int) godina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ClanarinaPK)) {
            return false;
        }
        ClanarinaPK other = (ClanarinaPK) object;
        if (this.programId != other.programId) {
            return false;
        }
        if (this.brojClana != other.brojClana) {
            return false;
        }
        if ((this.mesec == null && other.mesec != null) || (this.mesec != null && !this.mesec.equals(other.mesec))) {
            return false;
        }
        if (this.godina != other.godina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.ClanarinaPK[ programId=" + programId + ", brojClana=" + brojClana + ", mesec=" + mesec + ", godina=" + godina + " ]";
    }
    
}
