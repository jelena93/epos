/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jelena
 */
public class Util {

    public static Properties propUrl = new Properties();
    public static Properties propKlasa = new Properties();

    public static String getUrl(String key) {
        try {
            System.out.println("Key for url: " + key);
            InputStream in = Util.class.getClassLoader().getResourceAsStream("resources/url.properties");
            propUrl.load(in);
            String value = propUrl.getProperty(key);
            System.out.println("Value for url: " + value);
            return value;
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Object kreirajAkciju(String key) {
        System.out.println("key=" + key);
        Object obj = null;
        try {
            InputStream in = Util.class.getClassLoader().getResourceAsStream("resources/action.properties");
            propKlasa.load(in);
            String klasa = propKlasa.getProperty(key);
            System.out.println("klasa=" + klasa);
            obj = Class.forName(klasa).getConstructor().newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }

}