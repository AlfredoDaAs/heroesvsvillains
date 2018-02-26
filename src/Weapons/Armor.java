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
public class Armor extends WeaponDecorator{
    
    public Armor(){
        super(6);
    }

    public Armor(WeaponDecorator wrapper) {
        super(wrapper,6);
    }
    @Override
    public void use() {
        super.use();
        System.out.print(" *Blocks target* - " + this.WeaponPoints);
    }
}
