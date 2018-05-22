/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonathanjuanalan.servidorpr2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 2108616
 */
public class Cotizacion implements Interfaz {

    @Override
    public String getURLResult(String info) {
        System.out.println(info);
        URL rapi = null;
        String res = "";
        try {
            String[] tmp = info.split("\\?");
            rapi = new URL("https://proyectofinalarem.herokuapp.com/cotizaciones/cotizacion?" + tmp[1]);
        } catch (MalformedURLException ex) {
            Logger.getLogger(Cotizacion.class.getName()).log(Level.SEVERE, null, ex);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(rapi.openStream()))) {
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                res += inputLine;
            }
        } catch (IOException x) {
            System.err.println(x);
        }

        return res;
    }
}
