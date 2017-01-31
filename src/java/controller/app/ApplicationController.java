/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.app;

import action.Action;
import action.ActionFactory;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Jelena
 */
public class ApplicationController {

    public String obradiZahtev(String path, HttpServletRequest request) {
        Action akcija = ActionFactory.kreirajAkciju(path);
        return akcija.obradiZahtev(request);
    }
}
