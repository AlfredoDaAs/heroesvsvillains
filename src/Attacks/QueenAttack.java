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
import Weapons.Sword;
import Weapons.WeaponDecorator;

/**
 *
 * @author Bruno
 */
public class QueenAttack implements AttackBehavior{

    @Override
    public boolean attack(CharacterModel target, WeaponDecorator weapons) {
        if(!target.isAlive())
            return true;
        if(target.isVillain()){
            System.out.print(" with " + weapons.getPoints() + " attack points... ");
            weapons.use();
            if(target instanceof Lilith){
                return weapons.getPoints() >= target.weapons.getPoints();
            }
            return true;
        }
        else{
            System.out.println("I wont attack an ally...");
            return true;
        }
    }
}
