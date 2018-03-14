package orderedStructures;

import interfaces.Combinable;

public class Arithmetic extends Progression implements Combinable {
	private double commonDifference; 
	
	public Arithmetic(double firstValue, double commonDifference) { 
		super(firstValue); 
		this.commonDifference = commonDifference; 
	}
	
	@Override
	public double nextValue() {
		
		if (!usedFirstValueMethod) 
			 throw new IllegalStateException("You must first execute first value method");
		
		else {
		current = current + commonDifference; 
		return current;
		
	}
	}
	public String toString(){
		
		return "Arith" + this.firstValue()+"," + commonDifference;
	}
public double getTerm(int n){
	
	
	return this.firstValue() + commonDifference * n-1;
	
	}
public boolean Equals(Object o){
	
	Arithmetic p = (Arithmetic) o;
	
	return this.firstValue() == p.firstValue() && this.commonDifference == p.commonDifference;
}

public Progression add(Progression p){
	
	Arithmetic p2 = (Arithmetic) p;
	
	return new Arithmetic(p2.firstValue() + this.firstValue(),(p2.commonDifference + this.commonDifference));
}

}
