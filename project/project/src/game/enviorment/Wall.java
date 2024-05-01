package game.enviorment;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;

/**
 * Created by:
 * @author Riordan D. Alfredo
 * Modified by: Joshua Lim Boon Hor
 *
 */
public class Wall extends Ground {
	/**
	 * Wall constructor.
	 */
	public Wall() {
		super('#');
	}
	/**
	 * Wall cannot be entered by anyone.
	 */
	@Override
	public boolean canActorEnter(Actor actor) {
		return false;
	}
	/**
	 * Wall blocks thrown objects.
	 */
	@Override
	public boolean blocksThrownObjects() {
		return true;
	}
}
