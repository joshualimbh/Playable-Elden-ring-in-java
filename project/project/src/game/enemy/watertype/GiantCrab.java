package game.enemy.watertype;

import game.enemy.Enemy;
import game.weapon.GiantCrabPincer;
import game.behaviour.*;
import game.utils.EnemiesType;
import game.utils.ResetManager;

import java.util.Map;
import java.util.TreeMap;

/**
 * Giant Crab class, a type of enemy.
 * Giant Crab is displayed as 'C' in the map.
 * Giant Crab has 407 hp.
 * Giant Crab is a water type enemy.
 * Giant Crab has a Giant Crab Pincer as its weapon.
 * Giant Crab has an Area Attack Behaviour.
 * Giant Crab is resettable.
 * Created by:
 * @author
 * Modified by: Lim Jun Yi
 * @see Enemy
 */
public class GiantCrab extends Enemy {
    /**
     * A map of behaviours for Giant Crab.
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * Constructor for GiantCrab.
     */
    public GiantCrab() {
        super("Giant Crab", 'C', 407);

        this.addCapability(EnemiesType.IS_WATER_TYPE);
        this.addWeaponToInventory(new GiantCrabPincer());
        this.behaviours.put(1, new AreaAttackBehaviour());
        ResetManager.getInstance().registerResettable(this);

    }

}
