package game.enemy.firetype;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enemy.Enemy;
import game.utils.EnemiesType;
import game.utils.ResetManager;
import game.weapon.FlamingSword;

/**
 * An enemy named "Slug"
 * @author Liew Dong Xun
 */
public class Slug extends Enemy {

    /**
     * Constructor for the Slug class
     */
    public Slug() {
        super("Slug", 'l', 20);
        this.addCapability(EnemiesType.IS_FIRE_TYPE);
        this.addWeaponToInventory(new FlamingSword());
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Method to get the intrinsic weapon of slug
     * @return the intrinsic weapon of slug
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(10, "slimes", 100);
    }
}
