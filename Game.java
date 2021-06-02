import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Game {

	public static void main(String[] args) {
		
		ArrayList<Car> roster = new ArrayList<Car>();
		
		//initialize scanner to take user input
		Scanner names = new Scanner(System.in);
		
		//taking user input to determine race type
		
		boolean doneWithRaceType = false;
		int raceType = 0;
		
		System.out.println("Type the number that corresponds to the type"
				+ " of the desired race -- type \"help\" for the list of race types"
				+ " and corresponding numbers:");
		
		while (!doneWithRaceType) {
			int tempRaceType = 0;
			if (names.hasNextInt()) {
				tempRaceType = names.nextInt();
			}
			switch (tempRaceType) {
			case 1:
				raceType = 1;
				doneWithRaceType = true;
				break;
			case 2:
				raceType = 2;
				doneWithRaceType = true;
				break;
			}
			if (names.nextLine().equalsIgnoreCase("help")) {
				printRaceTypes();
			}
		}
		
		//printing selected race type
		
		if (raceType==1) {
			System.out.println("formula 1 race has been selected\n");
		} else if (raceType==2) {
			System.out.println("stock car race has been selected\n");
		}
		
		//taking user input to name cars
		
		boolean doneWithNames = false;
		
		System.out.println("Type the name of each car and press enter afterwards to add it"
				+ " to the roster\nType \"done\" when done to start the race\n");
		
		while (!doneWithNames) {
			String tempName = names.nextLine();
			if (tempName.equalsIgnoreCase("done")||tempName.equals("")) {
				doneWithNames = true;
			} else {
				if (raceType==1) {
					roster.add(new Formula1(tempName));
				} else if (raceType==2) {
					roster.add(new Stock(tempName));
				}
				System.out.println((roster.get(roster.size()-1)).getName() 
						+ " has been added to the race roster");
			}
		}
		
		//set race distance and start race based on race type
		int raceDistance = 0;
		if (raceType==1) {
			System.out.println("The formula 1 race will begin in 3...");
			raceDistance = 1000;
		} else if (raceType==2) {
			System.out.println("The stock car race will begin in 3...");
			raceDistance = 1500;
		}
		delay(1);
		System.out.println("2...");
		delay(1);
		System.out.println("1...");
		delay(1);
		System.out.println("GO!\n");
		delay(1);
		
		for (int i = 0;getHighestDistance(roster)<raceDistance;i++) {
			delay(1);
			for (Car temp: roster) {
				temp.moveForward();
			}
			if (i%2==0) {
				printDistances(roster);
			}
		}
		
		System.out.println("\nThe race has ended...\n");

		ArrayList<Car> podium = getWinners(roster);
		
		if (podium.size()==1) {
			System.out.println("The winner is " + podium.get(0).getName() + "!");
		} else if (podium.size()>1) {
			System.out.print("The winners are " + podium.get(0).getName());
			for (int i=1;i<podium.size();i++) {
				 System.out.print(", " + podium.get(i).getName());
			}
		}
		
	}
	
	public static int getHighestDistance(ArrayList<Car> raceOrder) {
		int highDist = Integer.MIN_VALUE;
		for (Car temp: raceOrder) {
			if (temp.getDistance()>highDist) {
				highDist = temp.getDistance();
			}
		}
		return highDist;
	}
	
	public static ArrayList<Car> getWinners(ArrayList<Car> raceOrder) {
		ArrayList<Car> winners = new ArrayList<Car>();
		for (Car temp: raceOrder) {
			if (temp.getDistance()>=getHighestDistance(raceOrder)) {
				winners.add(temp);
			}
		}
		return winners;
	}
	
	public static void printDistances(ArrayList<Car> carList) {
		for (Car temp: carList) {
			System.out.print(temp.getName() + " -- " + temp.getDistance() + "  ");
		}
		System.out.println("");
	}
	
	public static void delay(int seconds) {
		try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	public static void printRaceTypes() {
		System.out.println("Number and corresponding race type:\n");
		System.out.println("1 - formula 1");
		System.out.println("2 - nascar");
		System.out.println("");
	}

}
