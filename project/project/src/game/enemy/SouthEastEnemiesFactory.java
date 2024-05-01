package game.enemy;

import edu.monash.fit2099.engine.positions.Location;
import game.enemy.firetype.Charizard;
import game.enemy.landtype.GiantDog;
import game.enemy.undeadtype.SkeletalBandit;
import game.enemy.watertype.GiantCrayfish;

/**
 * South East Enemy Factory class, to spawn the enemies for lower right side of the map.
 *
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 * @see EnemyFactory
 */
public class SouthEastEnemiesFactory implements EnemyFactory{
    /**
     * A factory to create the water type enemies,
     * water type enemies are those enemies that can be spawn in the puddle of water ground type.
     *
     * @param location the location of the ground
     */
    @Override
    public void createWaterType(Location location) {
        location.addActor(new GiantCrayfish());
    }

    /**
     * A factory to create the land type enemies,
     * land type enemies are those enemies that can be spawn in the gust of wind ground type.
     *
     * @param location the location of the ground
     */
    @Override
    public void createLandType(Location location) {
        location.addActor(new GiantDog());
    }

    /**
     * A factory to create the undead type enemies,
     * undead type enemies are those enemies that can be spawn in the graveyard ground type.
     *
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
        location.addActor(new Charizard());
    }
}
