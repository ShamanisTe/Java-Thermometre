
public class Thermometre {
	private double maximum,minimum,current;
	
	public Thermometre(){
		maximum=100;
		minimum=0;
		current=20;
	}
	public Thermometre(double c){
		maximum=100;
		minimum=0;
		current=c;
	}
	public Thermometre(double ma,double mi,double c){
		maximum=ma;
		minimum=mi;
		current=c;
	}
	public double getMaximum() {
		return maximum;
	}
	public void setMaximum(double maximum) {
		this.maximum = maximum;
	}
	public double getMinimum() {
		return minimum;
	}
	public void setMinimum(double minimum) {
		this.minimum = minimum;
	}
	public double getCurrent() {
		return current;
	}
	public void setCurrent(double current) {
		this.current = current;
	}
	
	public void increment(){
		if(current<maximum){
			current++;
		}
	}
	public void decrement(){
		if(current>minimum){
			current--;
		}
	}
	public void increment(double c){
		double a=current+c;
		if(a<=maximum){
			current+=c;
		}
	}
	public void decrement(double c){
		double a=current-c;
		if(a>=minimum){
			current-=c;
		}
	}
}
