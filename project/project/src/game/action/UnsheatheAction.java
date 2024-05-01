package game.action;

import java.util.Random;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
/**
 * A Special Skill that can be used to attack the enemy.
 * It deals twice the base damage of the weapon with 60% hit rate
 * Created by:
 * @author Joshua Lim Boon Hor
 * Modified by:
 * @see Action
 */
public class UnsheatheAction extends Action{
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
     * constructor 
     * @param target the Actor to attack
     * @param direction the direction where the attack should be performed (only used for display purposes)
     * @param weapon the weapon used for the attack
     */
    public UnsheatheAction(Actor target, String direction, Weapon weapon) {
        this.target = target;
        this.direction = direction;
        this.weapon = weapon;}
    /**
     * executer of the action
     * @param actor the actor that is attacking the target
     * @param map the map where the actor is in
     * @return the result of the action
     * 
     */
    @Override
    public String execute(Actor actor, GameMap map){
        //unsheathe allows a unique skill that deals 2x damage of the weapon with a 60% chance to hit the enemy.
        if (!(rand.nextInt(100)<=60)) {
            return actor + " missed the attack.";
        }
        int damage = weapon.damage()*2;
        String result = actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.";
        target.hurt(damage);
        if (!target.isConscious()) {
            result += new DeathAction(actor).execute(target, map);
        }
    
            return result;
        }

    /**
     * description menu will show
     * @param actor the actor that is attacking the target
     * @return the description of the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " performs unsheathe to " + target + " at " + direction + " with " + weapon;
    }
    
}
