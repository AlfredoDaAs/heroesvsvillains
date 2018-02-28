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
public class Axe extends WeaponDecorator {
    
    public Axe(){
        super(2);
    }

    public Axe(WeaponDecorator wrapper) {
        super(wrapper,2);

    }

    @Override
    public void use() {
        super.use();
        System.out.print(" *Swings axe* - " + this.WeaponPoints);
    }
    
}