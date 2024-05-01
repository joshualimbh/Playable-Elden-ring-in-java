package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AreaAttackAction;


/**
 * A simple weapon that can be used to attack the enemy.
 * It deals 115 damage with 85% hit rate
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 *
 */
public class Grossmesser extends WeaponItem {

    /**
     * Constructor.
     *
     */
    public Grossmesser() {
        super("Grossmesser", '?', 115, "Slash", 85);
    }

    /**
     * Special skill that the weapon can perform
     * @param target The target of the actor
     * @param direction The direction of the actor
     * @return new AreaAttackAction
     * @see AreaAttackAction
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(this);
    }
}
