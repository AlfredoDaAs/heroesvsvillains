/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Attacks;

import Behaviors.AttackBehavior;
import Behaviors.WeaponBehavior;
import Characters.*;
import Models.CharacterModel;
import Weapons.Bow;

/**
 *
 * @author Bruno
 */
public class GhoulAttack implements AttackBehavior{

    @Override
    public boolean attack(CharacterModel target, WeaponBehavior weapon) {
        if(!target.isAlive())
            return true;
        if(target.isHero()){
            weapon.use();
            if((target instanceof Bishop && !(weapon instanceof Bow)) || target instanceof Queen || target instanceof Knight){
                return false;
            }
            else{
                return true;
            }
        }
        else{
            System.out.println("I wont attack an ally...");
            return true;
        }
    }
    
}
