package game.enemy;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Location;
import game.utils.RandomNumberGenerator;

/**
 * Enemy Factory class, to wrap east and west enemy spawning
 *
 * Created by:
 * @author Lim Jun Yi
 * Modified by:
 */
public interface EnemyFactory {

    /**
     * A factory to create the water type enemies,
     *  water type enemies are those enemies that can be spawn in the puddle of water ground type.
     * @param location the location of the ground
     */
    void createWaterType(Location location);

    /**
     * A factory to create the land type enemies,
     *  land type enemies are those enemies that can be spawn in the gust of wind ground type.
     * @param location the location of the ground
     */
    void createLandType(Location location);

    /**
     * A factory to create the undead type enemies,
     *  undead type enemies are those enemies that can be spawn in the graveyard ground type.
     * @param location the location of the ground
     */
    void createUndeadType(Location location);

    /**
     * A factory to create the fire type enemies,
     *  fire type enemies are those enemies that can be spawn in the volcano ground type.
     * @param location the location of the ground
     */
    void createFireType(Location location);

}
