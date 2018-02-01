/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Attacks;

import Behaviors.AttackBehavior;
import Behaviors.WeaponBehavior;
import Characters.Lilith;
import Models.CharacterModel;

/**
 *
 * @author Bruno
 */
public class KingAttack implements AttackBehavior{

    @Override
    public boolean attack(CharacterModel target, WeaponBehavior weapon) {
        if(!target.isAlive())
            return true;
        if(target.isVillain()){
            weapon.use();
            return !(target instanceof Lilith);
        }
        else{
            System.out.println("I wont attack an ally...");
            return true;
        }
    }
    
}
