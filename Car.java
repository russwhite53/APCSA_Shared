
public abstract class Car {
	
	private static int carNumber = 1;
	
	private String name;
	private int speed;
	private int distance;
	private Engine thisEngine;
	
	public Car (String newName, Engine newEngine) {
		name = newName;
		speed = 0;
		distance = 0;
		thisEngine = newEngine;
		carNumber++;
	}
	
	public void setSpeed(int newSpeed) {
		speed = newSpeed;
	}
	
	public String getName() {
		return name;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void moveForward() {
		if (this.speed<=100) {
			speed+=thisEngine.getTorque();
		} else {
			speed+=thisEngine.getHorsepower();
		}
		distance += (speed - 2 + (int)(Math.random()*5));
	}
	
}
