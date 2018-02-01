/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;

import Behaviors.AttackBehavior;
import Behaviors.WeaponBehavior;
import Models.CharacterModel;

/**
 *
 * @author alfre
 */
public class Knight extends CharacterModel{

    public Knight(AttackBehavior attackBehavior, WeaponBehavior weaponBehavior,boolean isHero) {
        super(attackBehavior, weaponBehavior,isHero);
    }

    @Override
    public String name() {
        return "Knight";
    }
    
}
