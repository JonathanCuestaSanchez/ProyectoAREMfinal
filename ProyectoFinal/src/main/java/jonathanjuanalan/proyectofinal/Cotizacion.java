/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jonathanjuanalan.proyectofinal;

import javax.json.*;
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
    int temp=0;
    int tmp2=0;
    int tmp3=120;
    String cotizacion = "La cotizacion es de: ";
    
    @RequestMapping(method = RequestMethod.GET, value = "/cotizacion")
    public ResponseEntity<?> cotizacion(@RequestParam("cliente") String cliente, @RequestParam("estaciones") int estaciones, @RequestParam("sistema") String sistema,
    @RequestParam("personal") int personal,@RequestParam("ciudad") String ciudad, @RequestParam("inventario") String inventario,
    @RequestParam("software") String software, @RequestParam("transacciones") int transacciones ){
        if (sistema.equals("Windows")){
            temp=200000;            
        }else if (sistema.equals("Linux")){
            temp=100000;
        }else if (sistema.equals("Mac")){
            temp=300000;
        }else {
            temp=350000;
        }
        if (!ciudad.equals("Bogota")){
            tmp2=3000000;
        }
        if (transacciones>500){
            tmp3=140;
        }else{
            tmp3=200;
        }
            JsonObject cotizacion = (JsonObject) Json.createObjectBuilder()
		.add("Nombre del cotizante", cliente)
                .add("Valor por sistema operativo", temp)
		.add("Estaciones", Json.createObjectBuilder().add("Costo fijo",1000000)
                        .add("N estaciones", estaciones)
                        .add("Costo con sistema operativo",(1000000+temp))
                        .add("Total", (1000000+temp)* estaciones))
                 .add("Valor de capacitacion", Json.createObjectBuilder()
                         .add("Valor de capacitacion por persona", 150000)
                         .add("numero de personas", personal)
                         .add("Total", personal*150000))
                 .add("Costos adicionales", Json.createObjectBuilder()
                         .add("Fuera de bogota",tmp2)
                         .add("Valor por transaccion", tmp2))
                 .add("Total de implementacion",((1000000+temp)* estaciones)+ (personal*150000));        
        
        System.out.println("Entro a la clase cotizacion "+ estaciones + transacciones);
        return new ResponseEntity<>(cotizacion,HttpStatus.OK);
    }
}
