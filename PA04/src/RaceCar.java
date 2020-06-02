/* RaceCar.java */

//Alicia Sheng
//PA04A
//Mar 5th, 2020

/**
 * This class defines an object that represents a race car with its speed,
 * strength, present speed, location, and ticks in pit stop. It also records the
 * car's status including whether it's broken, finished, printed, and in pit in
 * pit stop.
 */

public class RaceCar {

	private int speed;
	private int strength;
	private int tempSpeed;
	private int location;
	private int pitTick;
	private boolean broken;
	private boolean finished;
	private boolean printed;
	private boolean inPitStop;

	/**
	 * RaceCar() with two parameters constructs a new race car object and
	 * initializes the fields of the race car with the given speed, given strength,
	 * and default values.
	 * 
	 * @param speed    an integer of speed user enters.
	 * @param strength an integer of strength user enters.
	 */

	public RaceCar(int speed, int strength) {
		this.speed = speed;
		this.tempSpeed = speed;
		this.strength = strength;
		this.location = 0;
		this.pitTick = 0;
		this.broken = false;
		this.finished = false;
		this.printed = false;
		this.inPitStop = false;
	}

	/**
	 * RaceCar() constructs a new race car object and initializes the fields of the
	 * race car with default values.
	 */

	public RaceCar() {
		this.speed = 40;
		this.tempSpeed = 40;
		this.strength = 3;
		this.location = 0;
		this.pitTick = 0;
		this.broken = false;
		this.finished = false;
		this.printed = false;
		this.inPitStop = false;
	}

	/**
	 * getSpeed() gets the speed of the race car.
	 * 
	 * @return an integer of car's speed.
	 */

	public int getSpeed() {
		return this.speed;
	}

	/**
	 * getStrength() gets the strength of the race car.
	 * 
	 * @return an integer of car's strength.
	 */

	public int getStrength() {
		return this.strength;
	}

	/**
	 * getTempSpeed() gets the temporary speed of the race car.
	 * 
	 * @return an integer of car's temporary speed.
	 */

	public int getTempSpeed() {
		return this.tempSpeed;
	}

	/**
	 * setTempSpeed() sets the temporary speed of the race car with the given speed.
	 * 
	 * @param tempSpeed an integer of car's temporary speed.
	 */

	public void setTempSpeed(int tempSpeed) {
		this.tempSpeed = tempSpeed;
	}

	/**
	 * getLocation() gets the location of the race car.
	 * 
	 * @return an integer of car's location.
	 */

	public int getLocation() {
		return this.location;
	}

	/**
	 * setLocation() sets the location of the race car.
	 * 
	 * @param location an integer of car's location.
	 */

	public void setLocation(int location) {
		this.location = location;
	}

	/**
	 * getPitTick() gets the ticks in pit stop of the race car.
	 * 
	 * @return an integer of car's ticks in pit stop.
	 */

	public int getPitTick() {
		return this.pitTick;
	}

	/**
	 * setPitTick() sets the ticks in pit stop of the race car.
	 * 
	 * @param pitTick and integer of car's ticks in pit stop.
	 */

	public void setPitTick(int pitTick) {
		this.pitTick = pitTick;
	}

	/**
	 * getBroken() gets the broken status of the race car.
	 * 
	 * @return a boolean of car's broken status. True for broken, and false
	 *         otherwise.
	 */

	public boolean getBroken() {
		return this.broken;
	}

	/**
	 * setBroken() sets the broken status of the race car.
	 * 
	 * @param broken a boolean of car's broken status.
	 */

	public void setBroken(boolean broken) {
		this.broken = broken;
	}

	/**
	 * getFinished() gets the finished status of the race car.
	 * 
	 * @return a boolean of car's finished status. True for finished, and false
	 *         otherwise.
	 */

	public boolean getFinished() {
		return this.finished;
	}

	/**
	 * setFinished() sets the finished status of the race car.
	 * 
	 * @param finished a boolean of car's finished status.
	 */

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	/**
	 * getPrinted() gets the printed status of the race car.
	 * 
	 * @return a boolean of car's printed status. True for printed, and false
	 *         otherwise.
	 */

	public boolean getPrinted() {
		return this.printed;
	}

	/**
	 * setPrinted() sets the printed status of the race car.
	 * 
	 * @param printed a boolean of car's printed status.
	 */

	public void setPrinted(boolean printed) {
		this.printed = printed;
	}

	/**
	 * getInPitStop() gets the in pit stop status of the race car.
	 * 
	 * @return a boolean of car's in pit stop status. True for in, and false
	 *         otherwise.
	 */

	public boolean getInPitStop() {
		return this.inPitStop;
	}

	/**
	 * setInPitStop() sets the in pit stop status of the race car.
	 * 
	 * @return a boolean of car's in pit stop status.
	 */

	public void setInPitStop(boolean inPitStop) {
		this.inPitStop = inPitStop;
	}

	/**
	 * toString() transformed
	 */

	public String toString() {
		String result = "RaceCar" + this.speed + "/" + this.strength;
		return result;
	}
}