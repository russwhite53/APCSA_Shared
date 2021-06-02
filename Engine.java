
public class Engine {
	
	private int numCylinders;
	private double displacement;
	private int horsepower;
	private int torque;

	public Engine(int cylinders, double displacement) {
		this.displacement = displacement;
		numCylinders = cylinders;
		torque = (int)(Math.pow(displacement, 2.0)) * numCylinders;
		horsepower = (int) ((double)numCylinders * this.displacement * 12.0);
	}
	
	public int getHorsepower() {
		return horsepower;
	}
	
	public int getTorque() {
		return torque;
	}
	
	public void printInfo() {
		System.out.println("numCylinders: " + numCylinders + "\ndisplacement: "
				+ displacement + "\nhorsepower: " + horsepower + "\ntorque: " + torque);
	}
	
}
