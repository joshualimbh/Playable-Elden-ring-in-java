package game.enviorment;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.action.ResetAction;
import game.utils.Status;

/**
 * A class that represent site of lost graces
 * Created by: 
 * @author Lim Jun Yi
 * Modified by:
 * Joshua Lim Boon Hor
 * @see Ground
 */
public class SiteOfLostGrace extends Ground{

    private int counter;    // help us keep track of time
	/**
	 * Site of lost grace constructor.
	 */
    public SiteOfLostGrace() {
        super('U');
        counter = 0 ;
    }
	/**
	 * Site of lost grace cannot be entered by enemies
	 * @param actor The actor that will enter the Ground
	 */
    @Override
	public boolean canActorEnter(Actor actor) {
		return actor.hasCapability(Status.RESTING);
	}

    /**
	 * Site of grace can also experience the joy of time.
	 * @param location The location of the Ground
	 */
	public void tick(Location location) {
		counter += 1;
	}

	public ActionList allowableActions(Actor actor, Location location, String direction){
		ActionList actions = new ActionList();
		if(actor.hasCapability(Status.RESTING)) {
			actions.add(new ResetAction("The First Step"));
		}

		return actions;
	}
}
