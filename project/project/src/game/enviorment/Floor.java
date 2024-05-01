package game.enviorment;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.Status;

/**
 * A class that represents the floor inside a building.
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by:
 * @see Ground
 */
public class Floor extends Ground {

	private int counter;    // help us keep track of time
	/**
	 * Floor constructor.
	 */
	public Floor() {
		super('_');
		counter = 0;

	}
	/**
	 * Floor cannot be entered by enemies
	 * @param actor The actor that will enter the Ground
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.HOSTILE_TO_ENEMY);
	}

	/**
	 * Floor can also experience the joy of time.
	 * @param location The location of the Ground
	 */
	public void tick(Location location) {
		counter += 1;
	}
}
