/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import domen.Clan;
import domen.Clanarina;
import domen.ClanarinaPK;
import domen.Korisnik;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import util.Util;

public class ActionClan implements Action {

    @Override
    public String obradiZahtev(HttpServletRequest request) {
        String strana = Util.STRANA_CLAN;
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(Util.PERSISTENCE_UNIT_NAME);
        EntityManager em = emf.createEntityManager();
        int brojClana = Integer.parseInt(request.getParameter("brojClana"));
        Clan clan = em.find(Clan.class, brojClana);
        if (clan == null) {
            em.close();
            emf.close();
            return Util.STRANA_PRETRAGA_CLANOVA;
        }
        String akcija = request.getParameter("akcija");
        String poruka = "";
        if (akcija != null && akcija.equalsIgnoreCase("obrisi")) {
            em.getTransaction().begin();
            em.remove(clan);
            em.getTransaction().commit();
            em.close();
            emf.close();
            return Util.STRANA_PRETRAGA_CLANOVA;
        }
        if (akcija != null && akcija.equalsIgnoreCase("izmeni")) {
            String ime = request.getParameter("ime");
            String prezime = request.getParameter("prezime");
            String kontakt = request.getParameter("kontakt");
            String adresa = request.getParameter("adresa");
            em.getTransaction().begin();
            clan.setIme(ime);
            clan.setPrezime(prezime);
            clan.setKontakt(kontakt);
            clan.setAdresa(adresa);
            em.getTransaction().commit();
            poruka = "Uspesno sacuvan clan";
        }
        if (akcija != null && akcija.equalsIgnoreCase("clanarina")) {
            int iznos = Integer.parseInt(request.getParameter("iznos"));
            Date datumUplate = new Date();
            int mesec;
            int godina;
            if (clan.getClanarinaList().isEmpty()) {
                LocalDate localDate = datumUplate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                mesec = localDate.getMonthValue();
                godina = localDate.getYear();
            } else {
                Clanarina poslednjaClanarina = clan.getClanarinaList().get(clan.getClanarinaList().size() - 1);
                if (poslednjaClanarina.getClanarinaPK().getMesec() == 12) {
                    mesec = 1;
                    godina = poslednjaClanarina.getClanarinaPK().getGodina() + 1;
                } else {
                    mesec = poslednjaClanarina.getClanarinaPK().getMesec() + 1;
                    godina = poslednjaClanarina.getClanarinaPK().getGodina();
                }
            }
            Korisnik k = (Korisnik) request.getSession().getAttribute(Util.ULOGOVAN);
            ClanarinaPK cpk = new ClanarinaPK(clan.getBrojClana(), mesec, godina);
            Clanarina c = new Clanarina(cpk, datumUplate, iznos, k.getUsername());
            em.getTransaction().begin();
            clan.getClanarinaList().add(c);
            em.getTransaction().commit();
            poruka = "Uspesno sacuvana clanarina";
        }
        request.setAttribute("poruka", poruka);

        em.close();
        emf.close();
        request.setAttribute("clan", clan);
        return strana;
    }
}
