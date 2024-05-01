package game.enviorment;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;

/**
 * A class that represents bare dirt.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * 
 */
public class Dirt extends Ground {

	private int counter;    // help us keep track of time
	/**
	 * Dirt constructor.
	 */
	public Dirt() {
		super('.');
		counter = 0;
	}

	/**
	 * Dirt can also experience the joy of time.
	 * @param location The location of the Ground
	 */
	public void tick(Location location) {
		counter += 1;
	}
}
