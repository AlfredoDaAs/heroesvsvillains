/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Weapons;

import Behaviors.WeaponBehavior;

/**
 *
 * @author Bruno
 */
public class Sword implements WeaponBehavior{

    @Override
    public void use() {
        System.out.print(" *Swings sword*");
    }
    
}
