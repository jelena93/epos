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
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import util.Util;

public class ActionPrijava implements Action {

    @Override
    public String obradiZahtev(HttpServletRequest request) {
        String strana;
        String username = request.getParameter("username");
        String lozinka = request.getParameter("lozinka");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Util.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT k FROM Korisnik k WHERE k.username=:u AND k.lozinka=:l");
        query.setParameter("u", username);
        query.setParameter("l", lozinka);
        List ls = query.getResultList();
        if (!ls.isEmpty()) {
            strana = Util.STRANA_POCETNA;
            HttpSession sesija = request.getSession(true);
            sesija.setAttribute(Util.ULOGOVAN, ls.get(0));
        } else {
            strana = Util.getUrl(Util.STRANA_PRIJAVA);
        }
        em.close();
        emf.close();
        return strana;
    }

}
