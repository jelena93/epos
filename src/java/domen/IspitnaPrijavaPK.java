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
public class IspitnaPrijavaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "predmet_id")
    private int predmetId;
    @Basic(optional = false)
    @Column(name = "broj_indeksa")
    private String brojIndeksa;

    public IspitnaPrijavaPK() {
    }

    public IspitnaPrijavaPK(int predmetId, String brojIndeksa) {
        this.predmetId = predmetId;
        this.brojIndeksa = brojIndeksa;
    }

    public int getPredmetId() {
        return predmetId;
    }

    public void setPredmetId(int predmetId) {
        this.predmetId = predmetId;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) predmetId;
        hash += (brojIndeksa != null ? brojIndeksa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IspitnaPrijavaPK)) {
            return false;
        }
        IspitnaPrijavaPK other = (IspitnaPrijavaPK) object;
        if (this.predmetId != other.predmetId) {
            return false;
        }
        if ((this.brojIndeksa == null && other.brojIndeksa != null) || (this.brojIndeksa != null && !this.brojIndeksa.equals(other.brojIndeksa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "domen.IspitnaPrijavaPK[ predmetId=" + predmetId + ", brojIndeksa=" + brojIndeksa + " ]";
    }
    
}
