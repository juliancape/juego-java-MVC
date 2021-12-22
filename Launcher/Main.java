package Launcher;

import Controlador.Controler;
import Modelo.Operacion;
import Vista.Ventana;

/**
 *@author Daniel Velasquez y Julian Cardenas
 * @since 12-08-2021
 * @version 1.0
 */
public class Main {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        Ventana v = new Ventana();
        Operacion a = new Operacion(v);
        
       Controler c = new Controler(a,v);
	  Operacion f= new Operacion(v);
	  
	  
    }
    
}
