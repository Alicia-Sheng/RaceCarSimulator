/* RaceTrack.java */

//Alicia Sheng
//PA04A
//Mar 5th, 2020

/**
 * This class holds the race cars and race track conditions.
 */

public class RaceTrack {

	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events in
	 * part B. For more see the assignment PDF / documentation for TrackLoggerA.java
	 */
	// private TrackLoggerA logger;
	private RaceCar[] raceCars;
	private int finishedNum;
	private int finish;

	/**
	 * Racetrack() constructs a new race track object and initialized the fields
	 * with default values.
	 */

	public RaceTrack() {
		// logger = new TrackLoggerA(); // DO NOT REMOVE THIS LINE
		finishedNum = 0;
		finish = 1000;
	}

	/**
	 * setCars() sets the cars that will participate in player's race. If there are
	 * more than 10 cars in the list, only the first 10 cars would participate in
	 * the race.
	 *
	 * @param raceCars the list of race cars player enters.
	 */
	public void setCars(RaceCar[] raceCars) {
		if (raceCars.length > 10) {
			System.out.println(
					"No more than 10 cars will participate in a single race. Only the first 10 cars in your list would be in the race.");
			this.raceCars = new RaceCar[10];
			for (int i = 0; i < 10; i++) {
				this.raceCars[i] = raceCars[i];
			}
		} else {
			this.raceCars = raceCars;
		}
	}

	/**
	 * tick() runs one tick which moves every car a set distance equal to its speed.
	 * It also decides whether the race car should enter the pit stop. If two cars
	 * collide at the pit stop, they would enter the pit stop at the next tick of
	 * collision
	 */

	public void tick() {
		for (int i = 0; i < raceCars.length; i++) {
			if (!raceCars[i].getInPitStop()) {
				int pitStopUnit = raceCars[i].getLocation() / 100 * 100 + 75;
				int location = raceCars[i].getLocation() + raceCars[i].getTempSpeed();
				raceCars[i].setLocation(location);
				if (((raceCars[i].getLocation() - raceCars[i].getTempSpeed() < pitStopUnit
						&& raceCars[i].getLocation() >= pitStopUnit)
						|| raceCars[i].getLocation() - raceCars[i].getTempSpeed() == pitStopUnit)
						&& raceCars[i].getBroken()) {
					PitStop.enterPitStop(raceCars[i]);
					raceCars[i].setLocation(pitStopUnit);
				}
				// System.out.println(raceCars[i].location);
			} else {
				int pitTick = raceCars[i].getPitTick() + 1;
				raceCars[i].setPitTick(pitTick);
				if (raceCars[i].getPitTick() == 2) {
					System.out.println(raceCars[i] + " has exited the pit stop.");
					raceCars[i].setInPitStop(false);
					raceCars[i].setPitTick(0);
					raceCars[i].setTempSpeed(raceCars[i].getSpeed());
					int location = raceCars[i].getLocation() + raceCars[i].getTempSpeed();
					raceCars[i].setLocation(location);
					raceCars[i].setBroken(false);
				}
			}
		}
		checkCollision();
	}

	/**
	 * checkCollision() checks if any of the car in the race car list is damaged by
	 * collision.
	 */

	public void checkCollision() {
		for (int i = 0; i < raceCars.length; i++) {
			for (int j = 0; j < raceCars.length; j++) {
				if (i != j && !raceCars[i].getFinished() && !raceCars[j].getFinished() && !raceCars[i].getInPitStop()
						&& !raceCars[j].getInPitStop()) {
					if (raceCars[i].getLocation() % 100 == raceCars[j].getLocation() % 100) {
						if (!raceCars[i].getBroken()) {
							System.out.println(raceCars[i] + " has been damaged.");
							int tempSpeed = raceCars[i].getTempSpeed() - raceCars[i].getStrength() * 5;
							raceCars[i].setTempSpeed(tempSpeed);
							raceCars[i].setBroken(true);
						}
						if (!raceCars[j].getBroken()) {
							System.out.println(raceCars[j] + " has been damaged.");
							int tempSpeed = raceCars[j].getTempSpeed() - raceCars[j].getStrength() * 5;
							raceCars[j].setTempSpeed(tempSpeed);
							raceCars[j].setBroken(true);
						}
					}
				}
			}
		}
	}

	/**
	 * run() runs the race track.
	 */

	public void run() {
		boolean finished = FinishLine.finished(raceCars);
		int tickNum = 0;
		while (!finished) {
			System.out.println("Tick " + (tickNum + 1));
			tick();
			tickNum += 1;
			for (int i = 0; i < raceCars.length; i++) {
				if (raceCars[i].getLocation() >= this.finish && !raceCars[i].getPrinted()) {
					raceCars[i].setFinished(true);
					this.finishedNum += 1;
					System.out.println(raceCars[i] + " has finished the race in place " + finishedNum + ".");
					FinishLine.enterFinishLine(raceCars[i]);
				}
			}
			finished = FinishLine.finished(raceCars);
		}
		int score = calculateScore(tickNum);
		System.out.println("You scored " + score + " points.");
	}

	/**
	 * calculateScore() calculates the final score of the player.
	 *
	 * @param ticks an integer of total ticks race cars use.
	 * @return an integer of the final score.
	 */

	public int calculateScore(int ticks) {
		int score = 1000 - 20 * ticks + 150 * raceCars.length;
		return score;
	}

	/**
	 * Needed for part B This method returns the logger instance used by this
	 * RaceTrack. You <b>SHOULD NOT</b> be using this method.
	 *
	 * @return logger with this track's events
	 */
	/*
	 * public TrackLoggerA getLogger() { return logger; }
	 */
}
