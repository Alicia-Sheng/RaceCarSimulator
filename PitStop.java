/* PitStop.java */

//Alicia Sheng
//PA02
//Mar 5th, 2020

/**
 * This class contains a method which let the race car enter the pit stop. The
 * pit stop is located at the 75the unit of the lap.
 */

public class PitStop {

	/**
	 * enterPitStop() prints out the information of race car entering the pit stop,
	 * and change its status of in pit stop to be true.
	 * 
	 * @param raceCar an object in RaceCar class which would be put into the pit
	 *                stop.
	 */

	public static void enterPitStop(RaceCar raceCar) {
		System.out.println("RaceCar " + raceCar.getSpeed() + "/" + raceCar.getStrength() + " has entered the pit stop.");
		raceCar.setInPitStop(true);
	}
}
