/* FinishLine */

//Alicia Sheng
//PA02
//Mar 5th, 2020

/**
 * This class contains methods related to the finish line where cars that
 * complete 1000 units would enter.
 */

public class FinishLine {

	/**
	 * enterFinishLine() puts a race car into the finish line, and removes it from
	 * the race.
	 * 
	 * @param raceCar an object in RaceCar class which would be put into the final
	 *                line.
	 */

	public static void enterFinishLine(RaceCar raceCar) {
		raceCar.setPrinted(true);
	}

	/**
	 * finished() judges whether all the race is finished, which means cars are in
	 * the finish line.
	 * 
	 * @param raceCars an array with objects in RaceCar class.
	 * @return true if all cars are in the finish line, and false otherwise.
	 */

	public static boolean finished(RaceCar[] raceCars) {
		boolean finished = true;
		for (int i = 0; i < raceCars.length; i++) {
			if (!raceCars[i].getFinished()) {
				finished = false;
			}
		}
		return finished;
	}
}
