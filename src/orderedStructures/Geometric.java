package orderedStructures;

public class Geometric extends Progression {

	private double commonFactor; 
	
	public Geometric(double firstValue, double commonFactor) { 
		super(firstValue); 
		this.commonFactor = commonFactor; 
	}
	
	@Override
	public double nextValue() throws IllegalStateException {
		if (!usedFirstValueMethod) 
			 throw new IllegalStateException("You must first execute first value method");
		else{
			
		current = current * commonFactor; 
		return current;
		
		}
		
	}
	
	public String toString(){
		
		return "Geom" + this.firstValue()+"," + commonFactor;
	}
 public double getTerm (int n){
	 
	 return this.firstValue() * Math.pow(commonFactor, n-1);
	 }
 
 public boolean Equals(Object o){
		
		Geometric p2 = (Geometric) o;
		
		return this.firstValue() == p2.firstValue() && this.commonFactor == p2.commonFactor;
	}
 
}
