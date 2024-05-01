package game.action;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Ground;
import game.utils.ResetManager;

/**
 * A class that allows item or actor to be reset.
 *
 * @author Lim Jun Yi
 * modified by
 * Joshua  
 * @see Action
 */
public class ResetAction extends Action{
    /**
     * name of the resting place
     */
    private String name;
    /**
     * constructor
     * @param name name being resetted
     */
    public ResetAction(String name){
        this.name = name;
    }
    /**
     * execute the reset action
     * @param actor The actor performing the action.
     * @param map The map the actor is on.
     * @return a string that shows which actor is being reset
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run();
        return "The game has been reset.";
    }
    /**
     * menu description of the action
     * @param actor The actor performing the action.
     * @return a string that shows which actor is being reset
     */
    @Override
    public String menuDescription(Actor actor) {
        return actor + " rest at " + this.name + ".";
    }
    
}
