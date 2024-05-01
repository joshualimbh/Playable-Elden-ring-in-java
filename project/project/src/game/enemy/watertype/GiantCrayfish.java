package game.enemy.watertype;

import game.enemy.Enemy;
import game.utils.EnemiesType;
import game.utils.ResetManager;
import game.weapon.GiantCrayfishPincer;
import game.behaviour.*;

import java.util.Map;
import java.util.TreeMap;

/**
 * Giant Crayfish class, a type of enemy.
 * Giant Crayfish is displayed as 'R' in the map.
 * Giant Crayfish has 4803 hp.
 * Giant Crayfish is a water type enemy.
 * Giant Crayfish has a Giant Crayfish Pincer as its weapon.
 * Giant Crayfish has an Area Attack Behaviour.
 * Giant Crayfish is resettable.
 * Created by:
 * @author
 * Modified by: Lim Jun Yi
 * @see Enemy
 */
public class GiantCrayfish extends Enemy {
    /**
     * A map of behaviours for Giant Crayfish.
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();
    /**
     * Constructor for GiantCrayfish.
     */
    public GiantCrayfish() {
        super("Giant Crayfish", 'R', 4803);
        this.addCapability(EnemiesType.IS_WATER_TYPE);
        this.addWeaponToInventory(new GiantCrayfishPincer());
        this.behaviours.put(1, new AreaAttackBehaviour());
        ResetManager.getInstance().registerResettable(this);
    }

}