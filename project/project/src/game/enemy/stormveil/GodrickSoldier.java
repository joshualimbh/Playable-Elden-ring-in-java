package game.enemy.stormveil;

import game.enemy.Enemy;
import game.utils.EnemiesType;
import game.utils.ResetManager;
import game.weapon.Club;

/**
 * An enemy named "Godrick Soldier".
 * @author Liew Dong Xun
 */
public class GodrickSoldier extends Enemy {

    /**
     * Constructor
     */
    public GodrickSoldier() {
        super("Godrick Soldier", 'p', 198);
        this.addCapability(EnemiesType.STORMVEIL_INHABITANTS);
        this.addWeaponToInventory(new Club());
        ResetManager.getInstance().registerResettable(this);
    }
}
