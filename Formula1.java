
public class Formula1 extends Car {
	
	private boolean drsOpen = false;
	private boolean ersEnabled = false;
	
	public Formula1(String newName) {
		super(newName, new Engine(6, 1.6));
	}
	
}
