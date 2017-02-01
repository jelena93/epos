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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Jelena
 */
@Embeddable
public class ClanarinaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "broj_clana")
    private int brojClana;
    @Basic(optional = false)
    @NotNull
    @Column(name = "mesec")
    private int mesec;
    @Basic(optional = false)
    @NotNull
    @Column(name = "godina")
    private int godina;

    public ClanarinaPK() {
    }

    public ClanarinaPK(int brojClana, int mesec, int godina) {
        this.brojClana = brojClana;
        this.mesec = mesec;
        this.godina = godina;
    }

    public int getBrojClana() {
        return brojClana;
    }

    public void setBrojClana(int brojClana) {
        this.brojClana = brojClana;
    }

    public int getMesec() {
        return mesec;
    }

    public void setMesec(int mesec) {
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
        hash += (int) brojClana;
        hash += (int) mesec;
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
        if (this.brojClana != other.brojClana) {
            return false;
        }
        if (this.mesec != other.mesec) {
            return false;
        }
        if (this.godina != other.godina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.ClanarinaPK[ brojClana=" + brojClana + ", mesec=" + mesec + ", godina=" + godina + " ]";
    }
    
}
