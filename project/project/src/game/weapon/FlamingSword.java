package game.weapon;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * A weapon used and dropped by fire type enemies.
 * @author Liew Dong Xun
 */
public class FlamingSword extends WeaponItem {

    /**
     * Constructor for the FlamingSword class.
     */
    public FlamingSword() {
        super("Flaming Sword", '9', 100, "slashes", 95);
    }
}
