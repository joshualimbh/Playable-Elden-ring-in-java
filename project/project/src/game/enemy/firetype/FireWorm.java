package game.enemy.firetype;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enemy.Enemy;
import game.utils.EnemiesType;
import game.utils.ResetManager;
import game.weapon.FlamingSword;

/**
 * An enemy named "Fire Worm"
 * @author Liew Dong Xun
 */
public class FireWorm extends Enemy {

    /**
     * Construtor for the FireWorm class
     */
    public FireWorm() {
        super("Fire Worm", 'W', 80);
        this.addCapability(EnemiesType.IS_FIRE_TYPE);
        this.addWeaponToInventory(new FlamingSword());
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Method to get an intrinsic weapon for Fire Worm.
     * @return an intrinsic weapon for Fire Worm.
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(15, "burns", 80);
    }
}
