/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import domen.Clan;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import util.Util;

public class ActionUnosClana implements Action {
    
    @Override
    public String obradiZahtev(HttpServletRequest request) {
        String strana = Util.STRANA_UNOS_CLANA;
        if (request.getMethod().equalsIgnoreCase("post")) {
            String ime = request.getParameter("ime");
            String prezime = request.getParameter("prezime");
            String kontakt = request.getParameter("kontakt");
            String adresa = request.getParameter("adresa");
            EntityManagerFactory emf = Persistence.createEntityManagerFactory(Util.PERSISTENCE_UNIT_NAME);
            EntityManager em = emf.createEntityManager();
            Clan clan = new Clan(new Date(), ime, prezime, kontakt, adresa);
            em.persist(clan);
        }
        
        return strana;
    }
    
}
