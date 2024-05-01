package game.weapon;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.action.AreaAttackAction;
/**
 * A weapon that can be used to attack the enemy.
 * It deals 527 damage with 100% hit rate
 * Created by:
 * @Author Lim Jun Yi
 * @see WeaponItem
 */
public class GiantCrayfishPincer extends WeaponItem {
    /**
     * Constructor
     */
    public GiantCrayfishPincer() {
        super("Giant Crayfish Pincer", '/', 527, "slams", 100);
        this.togglePortability();
    }
    /**
     * Special skill that the weapon can perform
     */
    @Override
    public Action getSkill(Actor target, String direction) {
        return new AreaAttackAction(this);
    }
}
