package game.enemy.firetype;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enemy.Enemy;
import game.utils.EnemiesType;
import game.utils.ResetManager;
import game.weapon.FlamingSword;

/**
 * An enemy named "Charizard"
 * @author Liew Dong Xun
 */
public class Charizard extends Enemy {

    /**
     * Constructor for the Charizard class
     */
    public Charizard() {
        super("Charizard", 'V', 850);
        this.addCapability(EnemiesType.IS_FIRE_TYPE);
        this.addWeaponToInventory(new FlamingSword());
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Method to get the intrinsic weapon for Charizard
     * @return a Intrinsic Weapon of Charizard
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(100, "flames", 90);
    }
}
