package game.playerClass;

import game.Ally;
import game.Invader;
import game.Player;

import game.weapon.Club;
import game.weapon.Uchigatana;
/**
 * Samurai class, a type of player.
 * Samurai has 414 hp.
 * Samurai has a Uchigatana as its weapon.
 * Created by:
 * @Author Joshua Lim Boon Hor
 * Modified by: Lim Jun Yi
 * @see Player
 */
public class Samurai implements PlayerRoleFactory{

    /**
     * to choose player role
     * @return Player with its role
     */
    @Override
    public Player chosePlayerRole() {
        return new Player(455, new Uchigatana());
    }

    /**
     * to choose Ally role
     * @return Ally with its role
     */
    @Override
    public Ally choseAllyRole() {
        return new Ally(455, new Uchigatana());
    }

    /**
     * to choose Invader role
     * @return Invader with its role
     */
    @Override
    public Invader choseInvaderRole() {
        return new Invader(455, new Uchigatana());
    }
    
}
