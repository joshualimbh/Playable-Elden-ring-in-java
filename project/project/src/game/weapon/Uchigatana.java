package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.UnsheatheAction;
/**
 * A Weapon that can be used to attack the enemy.
 * It is the starter weapon for the class Samurai.
 * It deals 115 damage with 80% hit rate.
 * Created by:
 * @author Joshua Lim Boon Hor
 * Modified by:
 * @see WeaponItem
 */
public class Uchigatana extends WeaponItem {
    /**
     * Constructor
     */
    public Uchigatana() {
        super("Uchigatana", ')', 115 , "stabs", 80);
    }

    /**
     * Get skill method for Uchigatana
     * @param target The target of the actor
     * @param direction The direction of the actor
     * @return new UnsheatheAction
     * @see UnsheatheAction
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new UnsheatheAction(target, direction, this);
    }
}
    

