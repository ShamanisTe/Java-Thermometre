import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import javax.swing.JFrame;

public class ThermoSouris extends ThermoDessin {
	private Thermometre t=this.getThermoBouton().getT();
	private ThermoBouton tB=this.getThermoBouton();
	private ThermoDessin tD=this;
	
	public ThermoSouris() {
		super();
		this.addMouseListener(new MouseAdapt());
		this.addMouseWheelListener(new MouseAdapt());
		this.addMouseMotionListener(new MouseAdapt());
		this.addFocusListener(new focusList());
	} 
	
	public static void main(String[]arg){
		ThermoDessin tS1=new ThermoSouris();
		ThermoDessin tS2=new ThermoSouris();
		
		JFrame fenetre1=new JFrame("ThermoBouton");
		fenetre1.setLayout(new GridLayout(2,1));
		fenetre1.add(tS1.getThermoBouton());
		fenetre1.add(tS2.getThermoBouton());
		fenetre1.setBounds(150, 50, 400, 200);
		fenetre1.setVisible(true);
		fenetre1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JFrame fenetre2=new JFrame("ThermoSouris");
		fenetre2.setLayout(new GridLayout(1,2));
		fenetre2.add(tS1);
		fenetre2.add(tS2);
		fenetre2.setLocation(1000, 50);
		fenetre2.setSize(800, 400);
		fenetre2.setVisible(true);
		fenetre2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

		do{
			tS1.repaint();
			tS2.repaint();
			try {
				Thread.sleep(5);
			} 
			catch (InterruptedException e){
				// 	TODO Auto-generated catch block
				e.printStackTrace();
			}
		}while(true);
		
	}
	
	class MouseAdapt extends MouseAdapter {
		
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			requestFocus();
		}

		int xinit,yinit;

		@Override
		public void mouseDragged(MouseEvent a) {
			// TODO Auto-generated method stub
			tD.setBaseThermX(xinit+a.getX());
			tD.setBaseThermY(yinit+a.getY());
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			xinit=arg0.getX();
			yinit=arg0.getY();
			tD.setBaseThermX(xinit);
			tD.setBaseThermY(yinit);
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent arg0) {
			// TODO Auto-generated method stub
			//requestFocus();
			int valeur=arg0.getWheelRotation();
			if(valeur>0){
				t.decrement();
				tB.getSaisieText().setText(""+t.getCurrent());
				tB.getScrollBar().setValue((int)t.getCurrent());
			}else if(valeur<0){
				t.increment();
				tB.getSaisieText().setText(""+t.getCurrent());
				tB.getScrollBar().setValue((int)t.getCurrent());
			}
		}

	}
	class focusList implements FocusListener{

		@Override
		public void focusGained(FocusEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Focus win "+t.getCurrent());
		}

		@Override
		public void focusLost(FocusEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Focus lose "+t.getCurrent());
		}
		
	}
}

