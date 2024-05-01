package game.playerClass;


import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Ally;
import game.Invader;
import game.Player;
import game.weapon.Club;

/**
 * Wretch has 414 hp.
 * Wretch has a Club as its weapon.
 * Created by:
 * @Author Joshua Lim Boon Hor
 * Modified by: Lim Jun Yi
 * @see Player
 */
public class Wretch implements PlayerRoleFactory {

    /**
     * to choose player role
     * @return Player with its role
     */
    @Override
    public Player chosePlayerRole() {
        return new Player(414, new Club());
    }

    /**
     * to choose Ally role
     * @return Ally with its role
     */
    @Override
    public Ally choseAllyRole() {
        return new Ally(414, new Club());
    }

    /**
     * to choose Invader role
     * @return Invader with its role
     */
    @Override
    public Invader choseInvaderRole() {
        return new Invader(414, new Club());
    }
}
