package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

import java.util.ArrayList;
import java.util.Random;

/**
 * A class that allows actor to attack around them.
 *
 * @author Lim Jun Yi
 * @see Action
 */
public class AreaAttackAction extends Action {

    /**
     * Random number generator
     */
    private Random rand = new Random();

    /**
     * Weapon used for the attack
     */
    private Weapon weapon;
    /**
     * destination of the actor
     */
    private Location destination;
    private Actor target;


    /**
     * Constructor.
     *
     * @param weapon weapon used for the attack
     */
    public AreaAttackAction(Weapon weapon) {
        this.weapon = weapon;
    }
    /**
     * Constructor.
     */
    public AreaAttackAction(){
    }


    /**
     * Execute the AreaAttackAction allows actor to attack around them.
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return A description of the action suitable for feedback in the UI.
     */

    @Override
    public String execute(Actor actor, GameMap map) {
        if (weapon == null) {
            weapon = actor.getIntrinsicWeapon();
        }

        String result = "";

        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {

            destination = exit.getDestination();
            if (destination.containsAnActor()) {
                if (!(rand.nextInt(100) <= weapon.chanceToHit())) {
                    return actor + " misses " + destination.getActor() + ".";
                }

                result = actor + " " + weapon.verb() + " " + destination.getActor() + " for " + weapon.damage() + " damage(AOE)";

                destination.getActor().hurt(weapon.damage());

                if (!destination.getActor().isConscious()) {
                    result += new DeathAction(actor).execute(destination.getActor(), map);
                }
            }
        }

        return result;
    }

    /**
     * Describes which target the actor is attacking with which weapon
     *
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " attacks " + target  + " with " + weapon + " using spinning attack.";
    }
}
