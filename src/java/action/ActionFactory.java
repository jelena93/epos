/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package action;

import util.Util;

/**
 *
 * @author Jelena
 */
public class ActionFactory {

    public static Action kreirajAkciju(String path) {
        Action akcija = (Action) Util.kreirajAkciju(path);
        return akcija;

    }

}
