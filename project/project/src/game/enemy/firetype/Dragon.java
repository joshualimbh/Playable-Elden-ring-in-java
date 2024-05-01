package game.enemy.firetype;

import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.enemy.Enemy;
import game.utils.EnemiesType;
import game.utils.ResetManager;
import game.weapon.FlamingSword;

/**
 * An enemy named "Dragon"
 * @author Liew Dong Xun
 */
public class Dragon extends Enemy {

    /**
     * Constructor for the class Dragon.
     */
    public Dragon() {
        super("Dragon", '4', 750);
        this.addCapability(EnemiesType.IS_FIRE_TYPE);
        this.addWeaponToInventory(new FlamingSword());
        ResetManager.getInstance().registerResettable(this);
    }

    /**
     * Method to get an intrinsic weapon of Dragon
     * @return an intrinsic weapon of Dragon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(250, "roars", 60);
    }
}
