import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ThermoDessin extends JPanel{
	private ThermoBouton tB=new ThermoBouton();
	private int i=0;
	private int tailleL, tailleH;
	private int baseThermX, baseThermY;

	public ThermoDessin(){		
		this.setBackground(Color.black);
	}
	
	
	public ThermoBouton getThermoBouton(){
		return tB;
	}
	public int getBaseThermX() {
		return baseThermX;
	}
	
	public void setBaseThermX(int baseThermX) {
		this.baseThermX = baseThermX;
	}
	
	public int getBaseThermY() {
		return baseThermY;
	}
	
	public void setBaseThermY(int baseThermY) {
		this.baseThermY = baseThermY;
	}
	
	public void paint(Graphics g){
		tailleL=this.getWidth();
		tailleH=this.getHeight();
		if(i==0){
			baseThermX=tailleL/2-10;
			baseThermY=tailleH/6;
			i++;
		}

		int tailleThermoL=20;
		int tailleThermoH=195;
		double unite=tailleThermoH/tB.getT().getMaximum();
		int tailleNew=(int)(tailleThermoH-unite*(int)tB.getT().getCurrent());
		
		g.setColor(Color.white);
		g.fillRect(0, 0, tailleL, tailleH);
		
		g.setColor(Color.black);
		g.drawString(""+tB.getT().getCurrent(), baseThermX-50, baseThermY+tailleNew);
		
		//Dessin1 du thermometre
		g.setColor(Color.red);
		g.fillRect(baseThermX, baseThermY, 20, 200);
		//Dessin3 du thermometre
		g.setColor(Color.white);
		g.fillRect(baseThermX, baseThermY, tailleThermoL, tailleNew);
		//limite du Dessin1
		g.setColor(Color.black);
		g.drawRect(baseThermX, baseThermY, 20, 200);
		
		//Dessin2 du thermometre		
		g.setColor(Color.red);
		g.fillOval(baseThermX-10, baseThermY+195, 20+20, 20+20);
		//limite du Dessin2				
		g.setColor(Color.black);
		g.drawOval(baseThermX-10, baseThermY+195, 20+20, 20+20);
	}
}
