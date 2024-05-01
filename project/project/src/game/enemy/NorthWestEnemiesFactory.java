package game.enemy;

import edu.monash.fit2099.engine.positions.Location;
import game.enemy.firetype.FireWorm;
import game.enemy.landtype.LoneWolf;
import game.enemy.undeadtype.HeavySkeletalSwordsman;
import game.enemy.watertype.GiantCrab;

/**
 * North West Enemy Factory class, to spawn the enemies for upper left side of the map.
 *
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 * @see EnemyFactory
 */
public class NorthWestEnemiesFactory implements EnemyFactory {

    /**
     * Used the method to create a giant crab on the given location.
     * @param location the location of the ground
     */
    @Override
    public void createWaterType(Location location) {
        location.addActor(new GiantCrab());
    }

    /**
     * Used the method to create a lone wolf on the given location.
     * @param location the location of the ground
     */
    @Override
    public void createLandType(Location location) {
        location.addActor(new LoneWolf());
    }

    /**
     * Used the method to create a Heavy skeletal Swordsman on the given location.
     * @param location the location of the ground
     */
    @Override
    public void createUndeadType(Location location) {
        location.addActor(new HeavySkeletalSwordsman());
    }

    /**
     * A factory to create the fire type enemies,
     * fire type enemies are those enemies that can be spawn in the volcano ground type.
     *
     * @param location the location of the ground
     */
    @Override
    public void createFireType(Location location) {
        location.addActor(new FireWorm());
    }
}
