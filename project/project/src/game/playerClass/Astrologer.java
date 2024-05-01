package game.playerClass;

import game.Ally;
import game.Invader;
import game.Player;

import game.weapon.Club;
import game.weapon.Uchigatana;
/**
 * Astrologer has 396 hp.
 * Created by:
 * @Author Joshua Lim Boon Hor
 * Modified by: Lim Jun Yi
 * @see Player
 */
public class Astrologer implements PlayerRoleFactory{

    /**
     * to choose player role
     * @return Player with its role
     */
    @Override
    public Player chosePlayerRole() {
        return new Player(396, new Club());
    }

    /**
     * to choose Ally role
     * @return Ally with its role
     */
    @Override
    public Ally choseAllyRole() {
        return new Ally(396, new Club());
    }

    /**
     * to choose Invader role
     * @return Invader with its role
     */
    @Override
    public Invader choseInvaderRole() {
        return new Invader(396, new Club());
    }
    
}
