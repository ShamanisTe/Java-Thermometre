import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTextField;


public class ThermoBouton extends JPanel{

	private Thermometre t;
	private JButton incBut,decBut;
	private JLabel maxLab,minLab,curLab;
	private JPanel affichage,boutton;
	private JTextField saisieText;
	private JScrollBar scrollBar;
	
	public ThermoBouton(){
		t=new Thermometre(1000,0,5);
		maxLab=new JLabel("Maximum : "+t.getMaximum());
		minLab=new JLabel("Minimum : "+t.getMinimum());
		curLab=new JLabel("Current : "+t.getCurrent());
		incBut=new JButton("+");
		decBut=new JButton("-");
		affichage=new JPanel();
		boutton=new JPanel();
		saisieText=new JTextField(""+t.getCurrent());
		scrollBar=new JScrollBar(JScrollBar.HORIZONTAL,(int)t.getCurrent(),10,(int)t.getMinimum(),(int)t.getMaximum()+10);
		
		
		incBut.addActionListener(new ButListener());
		decBut.addActionListener(new ButListener());
		saisieText.addActionListener(new TextListener());
		scrollBar.addAdjustmentListener(new ScrollListener());
		
		this.setLayout(new GridLayout(3,1));
		affichage.setLayout(new GridLayout(1,3));
		affichage.add(minLab);
		affichage.add(curLab);
		affichage.add(maxLab);
		
		boutton.setLayout(new GridLayout(1,3));
		boutton.add(decBut);
		boutton.add(saisieText);
		boutton.add(incBut);
		
		this.add(affichage);
		this.add(boutton);
		this.add(scrollBar);
	}
	public Thermometre getT() {
		return t;
	}
	public void setT(Thermometre t) {
		this.t = t;
	}
	public JLabel getCurLab() {
		return curLab;
	}
	public void setCurLab(JLabel curLab) {
		this.curLab = curLab;
	}
	public JTextField getSaisieText() {
		return saisieText;
	}
	public void setSaisieText(JTextField saisieText) {
		this.saisieText = saisieText;
	}
	public JScrollBar getScrollBar() {
		return scrollBar;
	}
	public void setScrollBar(JScrollBar scrollBar) {
		this.scrollBar = scrollBar;
	}
	
	class TextListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			double valeur=Double.valueOf(saisieText.getText()).doubleValue();
			if(valeur>=t.getMinimum() && valeur<=t.getMaximum()){
				t.setCurrent(valeur);
				curLab.setText("Current : "+t.getCurrent());
				scrollBar.setValue((int)t.getCurrent());
			}
			
		}
		
	}
	class ButListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			JButton button=(JButton)arg0.getSource();
			if(button==incBut){
				if(t.getCurrent()<t.getMaximum()){
					t.increment();
					curLab.setText("Current : "+t.getCurrent());
					saisieText.setText(""+t.getCurrent());
					scrollBar.setValue((int)t.getCurrent());
				}
			}else if (button==decBut){
				if(t.getCurrent()>t.getMinimum()){
					t.decrement();
					curLab.setText("Current : "+t.getCurrent());
					saisieText.setText(""+t.getCurrent());
					scrollBar.setValue((int)t.getCurrent());
				}
			}
		}
		
	}
	class ScrollListener implements AdjustmentListener{

		@Override
		public void adjustmentValueChanged(AdjustmentEvent arg0) {
			// TODO Auto-generated method stub
			int valeur=arg0.getValue();
			t.setCurrent(valeur);
			saisieText.setText(""+t.getCurrent());
			curLab.setText("Current : "+t.getCurrent());
		}
		
	}
	
}
