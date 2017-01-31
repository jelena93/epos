/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Jelena
 */
public class ActionPrijava implements Action {

    @Override
    public String obradiZahtev(HttpServletRequest request) {
        String strana;
        String ime = request.getParameter("korisnickoIme");
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("KarateKlubPU");
//        EntityManager em = emf.createEntityManager();
//
//        Korisnik k = em.find(Korisnik.class, ime);
//        if (k != null) {
////            strana = Util.getProperty(Util.POCETNA);
            strana = "pocetna";
//            HttpSession sesija = request.getSession(true);
//            sesija.setAttribute("ulogovan_korisnik", k);
//        } else {
//            strana = Util.getProperty(Util.PRIJAVA);
//            strana = "prijava";
//        }
//        System.out.println(strana);
//        em.close();
//        emf.close();
        return strana;
    }

}
