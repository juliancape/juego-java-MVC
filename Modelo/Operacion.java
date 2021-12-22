package Modelo;

import Vista.Ventana;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

/**
 *
 * @author Daniel Velasquez y Julian Cardenas
 * @since 12-08-2021
 * @version 1.0
 * 
 */

public class Operacion {
	 private Ventana ventana = null;
	    //private Timer timer= new Timer();
	    public Operacion(Ventana v){
	        this.ventana=v;
	    }
	    
	    double Angulo;
	    double Altura;
	    double Velocidadi;
	    double Distancia;
	    double Velocidadx;
	    double Velocidady;
	    double Velocidadf;
	    double Tiempo;
	    
	    int a=1;
	    public void operacionPosicionXY(int angulo, int velocidad) {
	    	int puntoInicial=1;
	    	ventana.getPanel().getPuntos().clear();
	        for (double i = 0; i < Tiempo()+2; i+=0.3) {
	            int x=(int) ((int) velocidad*Math.cos((Math.toRadians(Angulo)))*i);
	            int y = (int) (velocidad*Math.sin(Math.toRadians(Angulo))*i
	                    +(-0.5)*9.8*Math.pow(i, 2));
	            Punto punto;
	            if (puntoInicial==1 ) {
	                  punto=new Punto ((50+x), (550-y));
	                  puntoInicial++;
				}else {
					  punto=new Punto (((50+x)-(int) ((Math.random()*(3-1))+1)), ((550-y)-(int) ((Math.random()*(3-1))+1)));

				}
	           
	          /*  if(punto.getX()>800 || punto.getY()>600){
	                break;
	            }*/
	            ventana.getPanel().getPuntos().add(punto);
	          
	        } 
	        ventana.getPanel().repaint();
	        
	        this.ventana.updateLabel4("");
	        this.ventana.updateLabel4("" + a);
	        a++;
	       
	    }
	    
	    int im = 2;
	    public void impacto(){
	        int margenIx = ventana.getPanel().getGorilas().get(1).getX();
	        int margenFx = ventana.getPanel().getGorilas().get(1).getX()+30;
	        
	        int margenIy = ventana.getPanel().getGorilas().get(1).getY();
	        int margenFy = ventana.getPanel().getGorilas().get(1).getY()+30;
	        
	        Boolean impact=false;
	        for (int i = 0; i < ventana.getPanel().getPuntos().size(); i++) {
	            if(ventana.getPanel().getPuntos().get(i).getX()> margenIx && 
	                    ventana.getPanel().getPuntos().get(i).getX()<margenFx && 
	                    ventana.getPanel().getPuntos().get(i).getY()>margenIy &&
	                    ventana.getPanel().getPuntos().get(i).getY()<margenFy){
	                impact=true;
	            }
	        }
	        
	        if(impact){
	            if(im==2){
	                this.ventana.updateLabel("");
	                this.ventana.updateLabel("I I");
	                im--;
	            }else if(im==1){
	                this.ventana.updateLabel("");
	                this.ventana.updateLabel("I");
	                im--;
	            }else{
	                this.ventana.updateLabel("");
	                this.ventana.updateLabel("Rival derrotado");
	            }
	        }
	        if(ventana.getLabel().equals("Rival derrotado")){
	            JOptionPane.showMessageDialog(null, "El rival ha sido derrotado");
	        }
	    }
	    
	    public void dibujarBola(int i){
	        for (int j = 0; j < ventana.getPanel().getPuntos().size(); j++) {
	            if(j==i){
	                //Punto pt= pu.get(i);
	                //ventana.getPanel().getPuntos().add(pt);
	                Punto p = ventana.getPanel().getPuntos().get(i);
	                ventana.getPanel().repaint(p.getX(),p.getY(),10,10);
	            }
	        }
	    }
	        
	    /**
	    * Retorna datos de la vel max, altura max, distancia max, tiempo
	    * @param angulo
	    * @param velocidad
	    */
	    public void operacionesDatos(double angulo, double velocidad){
	        Angulo = angulo;
	        Velocidadi = velocidad;
	        System.out.println("\nDistancia Recorrida: "+Distancia()+" m");
	        System.out.println("Tiempo Total: "+Tiempo()+" s");
	        System.out.println("Velocidad Maxima: "+Velocidad()+" m/s");
	        System.out.println("Altura Maxima: "+Altura()+" m");
	    }

	    double Distancia(){
	        Distancia = ((Math.pow(Velocidadi,2)*(Math.sin(Math.toRadians(Angulo*2))))/9.8);
	        return Distancia;
	    }
	    double Tiempo(){
	        Tiempo = ((2*Velocidadi)*(Math.sin(Math.toRadians(Angulo))))/9.8;
	        return Tiempo;
	    }
	    double Velocidad(){
	        Velocidadx = (Velocidadi*Math.cos(Math.toRadians(Angulo)));
	        Velocidady = (Velocidadi*Math.sin(Math.toRadians(Angulo)) - 9.8*Tiempo);
	        Velocidadf = (Math.sqrt(Math.pow(Velocidadx,2)+Math.pow(Velocidady,2)));
	        return Velocidadf;
	    }
	    double Altura(){
	        Altura = ((Math.pow(Velocidadi,2)*Math.pow(Math.sin(Math.toRadians(Angulo)),2))/(9.8*2));
	        return Altura;
	    }
	    
	    public void addGorila(){
	        ventana.getPanel().getGorilas().add(new Gorila(50,550));
	        ventana.getPanel().getGorilas().add(new Gorila(750,550));
	        ventana.getPanel().repaint();
	    }
}
