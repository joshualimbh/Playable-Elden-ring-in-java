package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import game.Ally;
import game.Invader;
import game.playerClass.*;
import game.utils.RandomNumberGenerator;
import game.weapon.Club;

/**
 * A class that allows player to pick up runes on ground.
 * @author Lim Jun Yi
 * @see Action
 */
public class SpawnAction extends Action {

    private String spawn;
    private final PlayerRoleFactory astrologer = new Astrologer() ;
    private final PlayerRoleFactory bandit = new Bandit() ;
    private final PlayerRoleFactory samurai = new Samurai() ;
    private final PlayerRoleFactory wretch = new Wretch() ;

    private boolean spawned = false;

    /**
     * When executed, will spawn an ally or invader at a random exit to the summon sign
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a message notifying that the sale was successful
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        Location here = map.locationOf(actor);
        for (Exit exit : here.getExits()) {
            Location destination = exit.getDestination();
            if (!destination.containsAnActor()) {
                spawned = true;
                if (RandomNumberGenerator.getRandomInt(1,100) <= 50) {
                    // spawn ally
                    int randRole = RandomNumberGenerator.getRandomInt(1,4);
                    switch (randRole){
                        case 1:
                            destination.addActor(astrologer.choseAllyRole());
                            break;
                        case 2:
                            destination.addActor(bandit.choseAllyRole());
                            break;
                        case 3:
                            destination.addActor(samurai.choseAllyRole());
                            break;
                        case 4:
                            destination.addActor(wretch.choseAllyRole());
                            break;
                    }
                    spawn = "Ally";
                    break;
                } else {
                    // spawn invader
                    int randRole = RandomNumberGenerator.getRandomInt(1,4);
                    switch (randRole){
                        case 1:
                            destination.addActor(astrologer.choseInvaderRole());
                            break;
                        case 2:
                            destination.addActor(bandit.choseInvaderRole());
                            break;
                        case 3:
                            destination.addActor(samurai.choseInvaderRole());
                            break;
                        case 4:
                            destination.addActor(wretch.choseInvaderRole());
                            break;
                    }
                    spawn = "Invader";
                    break;
                }
            }
        }
        if (!spawned) {
            return "Unable to spawn: No available exits";
        }
        return "Spawned" + spawn;
    }

    /**
     * Describes whether an ally or an invader has been spawned.
     * @param actor The actor performing the action.
     * @return a description used for the menu UI
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor.toString() + " spawns Ally or Invader";
    }
}
