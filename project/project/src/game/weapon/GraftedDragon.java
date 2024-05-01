package game.weapon;

import edu.monash.fit2099.engine.weapons.WeaponItem;
/**
 * A filler weapon as we are not implementing REQ3A
 * It deals 100 damage with 80% hit rate
 * Created by:
 * @author Joshua Lim Boon Hor
 * Modified by:
 * @see WeaponItem
 */
public class GraftedDragon extends WeaponItem{

    /**
     * Constructor
     */
    public GraftedDragon(){
        super("Grafted Dragon", '^', 100, "slashes", 80);
    }
    
}
