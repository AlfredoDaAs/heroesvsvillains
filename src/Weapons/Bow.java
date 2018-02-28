/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Weapons;

import Behaviors.WeaponBehavior;

/**
 *
 * @author User
 */
public class Bow extends WeaponDecorator implements WeaponBehavior{
    
    public Bow(){
        super(3);
    }

    public Bow(WeaponDecorator wrapper) {
        super(wrapper,3);
    }

    @Override
    public void use() {
        super.use();
        System.out.print(" *Shoots arrow* - " + this.WeaponPoints);
    }
    
}