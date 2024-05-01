package game.enemy.stormveil;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.behaviour.Behaviour;
import game.enemy.Enemy;
import game.utils.EnemiesType;
import game.utils.ResetManager;

import java.util.Map;
import java.util.TreeMap;

/**
 * An enemy named "Dog".
 * @author Liew Dong Xun
 */
public class Dog extends Enemy {

    /**
     * A map of behaviours for Dog.
     */
    private Map<Integer, Behaviour> behaviours = new TreeMap<>();

    /**
     * Constructor
     */
    public Dog() {
        super("Dog", 'a', 104);
        this.addCapability(EnemiesType.STORMVEIL_INHABITANTS);
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Gets the intrinsic weapon of Dog
     * @return the Dog's intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(101, "bites", 93);
    }
}
