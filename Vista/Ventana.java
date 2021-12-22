package Vista;

import Controlador.Controler;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Daniel Velasquez y Julian Cardenas
 * @since 12-08-2021
 * @version 1.0
 */
public class Ventana extends JFrame{
	 private JLabel labelGame = new JLabel ("GORILLA'S");
	    private JLabel labelAng = new JLabel ("Angulo: ");
	    private JLabel labelVel = new JLabel ("Velocidad: ");
	    private JLabel label = new JLabel ("I I I");
	    private JLabel label2 = new JLabel ("VIDA RIVAL:");
	    private JLabel label3 = new JLabel ("N° lanzamientos:");
	    private JLabel label4 = new JLabel ("");
	    private JButton boton1 = new JButton("Iniciar");
	    private JButton boton2 = new JButton("Ataque");
	    private Controler c;
	    private JTextField ang = new JTextField();
	    private JTextField vel = new JTextField();
	    
	    private Panel panel = new Panel();//Se crea panel y se inicializa

	    public JTextField getAng() {
	        return ang;
	    }
	    public JTextField getVel() {
	        return vel;
	    }
	    public void setAng(JTextField ang) {
	        this.ang = ang;
	    }
	    public void setVel(JTextField vel) {
	        this.vel = vel;
	    }
	    public String getLabel() {
	        return label.getText();
	    }
	    public JLabel getLabel4() {
	        return label4;
	    }
	    
	    
	    public Ventana(){
	        //establece el tamaño de la ventana emergente
	        this.setBounds(100, 50, 1200, 2000);
	        //para cerrar la ventana cuando se oprime la x de la ventana
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        this.setLayout(null);
	        //invoca los componentes para aparecer en la pantalla
	        this.initComponents();
	        this.setVisible(true);
	    }
	    
	    private void initComponents(){
	        Font letra1 = new Font("Times New Roman", Font.BOLD, 30);
	        labelGame.setFont (letra1);
	        labelGame.setBounds(10, 10, 180, 20);
	        this.add(labelGame);
	        
	        labelAng.setBounds(10, 80, 50, 20);
	        this.add(labelAng);
	        
	        labelVel.setBounds(10, 120, 80, 20);
	        this.add(labelVel);
	        
	        label.setBounds(90, 220, 200, 50);
	        this.add(label);
	        label2.setBounds(10, 220, 80, 50);
	        this.add(label2);
	        
	        label3.setBounds(10, 260, 120, 50);
	        this.add(label3);
	        label4.setBounds(120, 260, 80, 50);
	        this.add(label4);
	        
	        this.boton1.setBounds(10, 180, 90, 30);
	        this.boton1.setBackground(Color.DARK_GRAY);
	        this.boton1.setForeground(Color.WHITE);
	        this.add(boton1);
	        //this.setBackground(Color.WHITE);
	        
	        this.boton2.setBounds(110, 180, 90, 30);
	        this.boton2.setBackground(Color.RED);
	        this.boton2.setForeground(Color.WHITE);
	        this.add(boton2);
	        
	        this.ang.setBounds(60, 80, 30, 20);
	        this.vel.setBounds(80, 120, 50, 20);
	        this.add(ang);
	        this.add(vel);
	        
	        this.panel.setBounds(250,10,800,600);
	        panel.setVisible(true);
	        this.add(panel);
	    }
	    
	    public void updateLabel(String s){
	        this.label.setText(s);
	    }
	    public void updateLabel2(String s){
	        this.label2.setText(s);
	    }
	    public void updateLabel3(String s){
	        this.label3.setText(s);
	    }
	    public void updateLabel4(String s){
	        this.label4.setText(s);
	    }
	    
	    public void setContoler(Controler cont){
	        this.c=cont;
	        this.boton1.addActionListener(this.c);
	        this.boton2.addActionListener(this.c);
	    }
	    
	    // Permitir al modelo acceder al panel
	    public Panel getPanel(){
	        return panel;
	    }
}