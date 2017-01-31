/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jelena
 */
public class ActionPocetna implements Action {

    @Override
    public String obradiZahtev(HttpServletRequest request) {
        return "pocetna";
    }

}
