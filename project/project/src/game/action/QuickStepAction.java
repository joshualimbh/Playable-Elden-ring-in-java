package game.action;

import java.util.Random;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actors.ActorLocationsIterator;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * A Special Skill that can be used to attack the enemy.
 * It deals the same damage as the weapon, but it allows you to move to an adjacent location after the attack.
 * Created by:
 * @author Joshua Lim Boon Hor
 * Modified by: Lim Jun Yi
 * @see Action
 *
 */
public class QuickStepAction extends Action {

    /**
     * The Actor that is to be attacked by the actor.
     */
    private Actor target;

    /**
     * The direction of incoming attack.
     */
    private String direction;
    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;

    /**
     * Constructor.
     *
     * @param target the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon the weapon used for the attack
     */
    public QuickStepAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;}


    /**
     * when executed, the chance to hit or miss is determined by the hit rate of the weapon.
     * if the attack hits, the target will be dealt damage and the actor will move to a location around the actor that is not occupied by another actor.
     * if the attack misses, the actor will still move.
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string that shows the result of the action
    **/
    @Override
    public String execute(Actor actor, GameMap map) {
        // We move the player to a location around the player that is not occupied by another actor
        // If there is no such location, we do not move the player
        Location here = map.locationOf(actor);
        Exit exitChoice = null;

        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();

            if (destination.containsAnActor()) {
                continue;}

            else {
                exitChoice = exit;
                map.moveActor(actor, destination);
            }
        }

        if(!(rand.nextInt(100) <= weapon.chanceToHit())){
            return actor + " misses " + target + " and moves " + exitChoice.getName() + ".";
        }

        int damage = weapon.damage();
		String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage and moves " + exitChoice.getName()+".";
		target.hurt(damage);

		if (!target.isConscious()) {
			result += new DeathAction(actor).execute(target, map);
		}

		return result;
	}
    /**
     * Returns a string to be showned in the menu for the action.
     *
     * @param actor The actor performing the action.
     * @return a string that shows the description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " performs Quickstep to "+ target+" at "+direction+" with "+ weapon + ".";
    }

}
