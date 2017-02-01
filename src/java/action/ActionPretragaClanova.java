/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import util.Util;

public class ActionPretragaClanova implements Action {

    @Override
    public String obradiZahtev(HttpServletRequest request) {
        String strana = Util.STRANA_PRETRAGA_CLANOVA;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Util.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        List clanovi = em.createQuery("SELECT c FROM Clan c").getResultList();
        request.setAttribute("clanovi", clanovi);
        return strana;
    }

}
