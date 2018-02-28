/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Characters;

import Behaviors.AttackBehavior;
import Behaviors.WeaponBehavior;
import Models.CharacterModel;
import Weapons.WeaponDecorator;
import java.util.ArrayList;

/**
 *
 * @author alfre
 */
public class Ghoul extends CharacterModel{

    public Ghoul(AttackBehavior attackBehavior, WeaponDecorator weapons,boolean isHero) {
        super(attackBehavior, weapons,isHero);
    }
    
    @Override
    public String name() {
        return "Ghoul";
    }
}
