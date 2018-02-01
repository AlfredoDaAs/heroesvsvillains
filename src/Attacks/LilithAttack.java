/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Attacks;

import Behaviors.AttackBehavior;
import Behaviors.WeaponBehavior;
import Characters.Queen;
import Models.CharacterModel;
import Weapons.Sword;

/**
 *
 * @author Bruno
 */
public class LilithAttack implements AttackBehavior{

    @Override
    public boolean attack(CharacterModel target, WeaponBehavior weapon) {
        if(!target.isAlive())
            return true;
        if(target.isHero()){
            weapon.use();
            if(target instanceof Queen && target.weaponBehavior instanceof Sword && !(weapon instanceof Sword)){
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
