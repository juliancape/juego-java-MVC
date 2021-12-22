package Controlador;

import Modelo.Operacion;
import Vista.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

import javax.swing.JOptionPane;

/**
 *@author Daniel Velasquez y Julian Cardenas
 * @since 12-08-2021
 * @version 1.0
 */
public class Controler implements ActionListener{
	 private Operacion modelo;
	    private Ventana vista;
	    int i= 0;
	    public Controler(Operacion modelo, Ventana v){
	        this.modelo = modelo;
	        this.vista = v;
	        this.vista.setContoler(this);
	    }
	    
	    @Override
	    //Accion al ejecutar el evento
	    public void actionPerformed(ActionEvent e) {
	        if(e.getActionCommand().equals("Iniciar")){
	            while(vista.getPanel().getGorilas().isEmpty()){
	            modelo.addGorila();
	            }
	        }
	        //int i=0;
	        if (e.getActionCommand().equals("Ataque")){
	            if(!vista.getLabel().equals("Rival derrotado")){
	                String n1 = this.vista.getAng().getText();
	                String n2 = this.vista.getVel().getText();
	                int num1= Integer.parseInt(n1);
	                int num2= Integer.parseInt(n2);
	                modelo.operacionesDatos(num1, num2);
	                modelo.operacionPosicionXY(num1, num2);
	                modelo.impacto();
	               // this.vista.getGraphics().clearRect(100, 50, 1200, 2000);;
	                //this.vista.getPanel().repaint(100, 50, 1200, 2000);
	                //vista.getPanel().updateUI();
	                //vista.getPanel().repaint(vista.getPanel().getBounds());
	            }else{
	                JOptionPane.showMessageDialog(null, "El rival ha sido derrotado");
	            }
	            
	           
	        }
	        
	    }
    
}
