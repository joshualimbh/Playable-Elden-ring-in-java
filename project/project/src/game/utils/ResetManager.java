package game.utils;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by: Liew Dong Xun
 *
 */
public class ResetManager {
    /**
     * list of resettables
     */
    private List<Resettable> resettables;
    /**
     * instance of reset manager
     */
    private static ResetManager instance;

    private Location lastVisitedSite;

    private Location lastLocation;

    private List<Actor> actorsList = new ArrayList<>();

    /**
     * private constructor for reset manager meaning only one instance may exist
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }
    /**
     * to get the instance in other classes
     * @return the instance of reset manager
     */
    public static ResetManager getInstance() {
        if (instance == null) {
            instance = new ResetManager();
        }
        return instance;
    }
    /**
     * run function to run reset for resettables and print you died fiunction if player dies
     */
    public void run() {
        for (Resettable resettable : resettables) {
            resettable.reset();
        }
    }
    /**
     * to register resettables
     * @param resettable resettable to be registered
     */
    public void registerResettable(Resettable resettable) {
        this.resettables.add(resettable);
    }
    /**
     * to remove resettables 
     * @param resettable resettable to be removed
     */
    public void removeResettable(Resettable resettable) {
        this.resettables.remove(resettable);
    }

    /**
     * method to save the last visited site of lost grace
     * @param location location of last visited site of lost grace
     */
    public void saveLastVisited(Location location) {
        lastVisitedSite = location;
    }

    /**
     * Method to retrieve location of last visited site of lost grace
     * @return the location of the last visited site of lost grace
     */
    public Location retrieveLastVisited() {
        return lastVisitedSite;
    }

    /**
     * Method to save the immediate last location of actor
     * @param location the current location of actor
     */
    public void saveLastLocation(Location location) {
        lastLocation = location;
    }

    /**
     * Method to retrieve the last location of actor
     * @return the last location of the actor
     */
    public Location retrieveLastLocation() {
        return lastLocation;
    }

    /**
     * Method to add an actor to a list, to be despawned upon player death
     * @param actor the actor to be added to the list
     */
    public void addActor(Actor actor) {
        this.actorsList.add(actor);
    }

    /**
     * Method to remove all actors in the list
     * @param map the map that the actor is in
     */
    public void removeActorList(GameMap map) {
        for (Actor actors: actorsList) {
            map.removeActor(actors);

        }
    }
}

