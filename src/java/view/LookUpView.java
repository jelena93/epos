/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import util.Util;

/**
 *
 * @author student1
 */
public class LookUpView {

    public static String getView(String ime) {
        String view = Util.getUrl(ime);
        
//        if (ime.equalsIgnoreCase("pocetna")) {
//            view = "/WEB-INF/pocetna.jsp";
//        }
//        if (ime.equalsIgnoreCase("prijavi_se")) {
//            view = "/prijavi_se.jsp";
//        }
        return view;
    }
}
