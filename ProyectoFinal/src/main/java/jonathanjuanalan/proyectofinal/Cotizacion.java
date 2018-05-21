/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonathanjuanalan.proyectofinal;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author 2108616
 */
@RestController
@RequestMapping(value = "/cotizaciones")
public class Cotizacion {
    int contn = 3000000;
    String cotizacion = "La cotizacion es de: ";
    
    @RequestMapping(method = RequestMethod.GET, value = "/cotizacion")
    public ResponseEntity<?> cotizacion(@RequestParam("cliente") String cliente, @RequestParam("estaciones") int estaciones, @RequestParam("sistema") String sistema,
    @RequestParam("personal") String personal,@RequestParam("ciudad") String ciudad, @RequestParam("inventario") String inventario,
    @RequestParam("software") String software, @RequestParam("transacciones") String transacciones ){
         JsonObject cotizacion = Json.createObjectBuilder()
		.add("Nombre del cotizante", cliente)
		.add("Estaciones", Json.createObjectBuilder().add("Costo",1000000)
                        .add("N estaciones", estaciones)
                        .add("Total", estaciones*1000000));        
        
        System.out.println("Entro a la clase cotizacion "+ estaciones + transacciones);
        return new ResponseEntity<>(cotizacion,HttpStatus.OK);
    }
}
