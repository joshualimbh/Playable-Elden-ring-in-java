package game.playerClass;

import edu.monash.fit2099.engine.weapons.WeaponItem;
import game.Ally;
import game.Invader;
import game.Player;

/**
 * PlayerRoleFactory interface, holds the methods for choosing different classes for different actor.
 * Created by:
 * @Author Lim Jun Yi
 */
public interface PlayerRoleFactory {

    /**
     * to choose player role
     * @return Player with its role
     */
    Player chosePlayerRole();

    /**
     * to choose Ally role
     * @return Ally with its role
     */
    Ally choseAllyRole();

    /**
     * to choose Invader role
     * @return Invader with its role
     */
    Invader choseInvaderRole();
}
