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
public class Knife extends WeaponDecorator implements WeaponBehavior{
    
    public Knife(){
        super(1);
        this.WeaponPoints = 1;
    }

    public Knife(WeaponDecorator wrapper) {
        super(wrapper,1);
    }
    @Override
    public void use() {
        super.use();
        System.out.print(" *Stabs target* - " + this.WeaponPoints);
    }
    
}