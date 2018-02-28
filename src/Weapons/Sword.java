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
public class Sword extends WeaponDecorator implements WeaponBehavior{
    
    public Sword(){
        super(4);
    }

    public Sword(WeaponDecorator wrapper) {
        super(wrapper,4);
    }
    
    @Override
    public void use() {
        super.use();
        System.out.print(" *Swings sword* - " + this.WeaponPoints);
    }
    
}
