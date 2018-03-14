package orderedStructures;

public class Fibonacci extends Progression {

	private double prev; 
	private double current; 
	private double temp ; 
	public Fibonacci() { 
		this(1); 
		prev = 0; 
	}
	private Fibonacci(double first) {
		super(first);
	}

	@Override
	public double nextValue() {
		if (!usedFirstValueMethod) 
			throw new IllegalStateException("You must first execute first value method");
		else{	
			temp = current + prev;
			prev = current;
			current = temp;   
		}	
		return current;
	}

	@Override	
	public double firstValue() { 
		double value = super.firstValue(); 
		prev = 0; 
		return value; 
	}

}
