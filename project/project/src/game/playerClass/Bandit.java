package game.playerClass;


import game.Ally;
import game.Invader;
import game.Player;
import game.weapon.GreatKnife;
/**
 * Bandit has 414 hp.
 * Bandit has a Great Knife as its weapon.
 * Created by:
 * @Author Joshua Lim Boon Hor
 * Modified by: Lim Jun Yi
 * @see Player
 */
public class Bandit implements PlayerRoleFactory{

    /**
     * to choose player role
     * @return Player with its role
     */
    @Override
    public Player chosePlayerRole() {
        return new Player(414, new GreatKnife());
    }

    /**
     * to choose Ally role
     * @return Ally with its role
     */
    @Override
    public Ally choseAllyRole() {
        return new Ally(414, new GreatKnife());
    }

    /**
     * to choose Invader role
     * @return Invader with its role
     */
    @Override
    public Invader choseInvaderRole() {
        return new Invader(414, new GreatKnife());
    }
    
}
