package game.enemy;

import edu.monash.fit2099.engine.positions.Location;
import game.enemy.firetype.Dragon;
import game.enemy.landtype.GiantDog;
import game.enemy.undeadtype.SkeletalBandit;
import game.enemy.watertype.GiantCrayfish;

/**
 * North East Enemy Factory class, to spawn the enemies for upper right side of the map.
 *
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 * @see EnemyFactory
 */
public class NorthEastEnemiesFactory implements EnemyFactory {

    /**
     * Used the method to create a Giant Cray fish on the given location.
     *
     * @author Lim Jun Yi
     * @param location the location of the ground
     */
    @Override
    public void createWaterType(Location location) {
        location.addActor(new GiantCrayfish());
    }

    /**
     * Used the method to create a Giant dog on the given location.
     *
     * @author Lim Jun Yi
     * @param location the location of the ground
     */
    @Override
    public void createLandType(Location location) {
        location.addActor(new GiantDog());
    }

    /**
     * Used the method to create a Skeletal Bandit on the given location.
     *
     * @author Lim Jun Yi
     * @param location the location of the ground
     */
    @Override
    public void createUndeadType(Location location) {
        location.addActor(new SkeletalBandit());
    }

    /**
     * A factory to create the fire type enemies,
     * fire type enemies are those enemies that can be spawn in the volcano ground type.
     *
     * @param location the location of the ground
     */
    @Override
    public void createFireType(Location location) {
        location.addActor(new Dragon());
    }
}
