package game.enemy;

import edu.monash.fit2099.engine.positions.Location;
import game.enemy.firetype.Slug;
import game.enemy.landtype.LoneWolf;
import game.enemy.undeadtype.HeavySkeletalSwordsman;
import game.enemy.watertype.GiantCrab;

/**
 * South West Enemy Factory class, to spawn the enemies for lower left side of the map.
 *
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 * @see EnemyFactory
 */
public class SouthWestEnemiesFactory implements EnemyFactory{
    /**
     * A factory to create the water type enemies,
     * water type enemies are those enemies that can be spawn in the puddle of water ground type.
     *
     * @param location the location of the ground
     */
    @Override
    public void createWaterType(Location location) {
        location.addActor(new GiantCrab());
    }

    /**
     * A factory to create the land type enemies,
     * land type enemies are those enemies that can be spawn in the gust of wind ground type.
     *
     * @param location the location of the ground
     */
    @Override
    public void createLandType(Location location) {
        location.addActor(new LoneWolf());
    }

    /**
     * A factory to create the undead type enemies,
     * undead type enemies are those enemies that can be spawn in the graveyard ground type.
     *
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
        location.addActor(new Slug());
    }
}
