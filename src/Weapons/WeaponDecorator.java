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
public class WeaponDecorator implements WeaponBehavior {
    public WeaponDecorator otherWeapon;
    public int WeaponPoints;
    
    public WeaponDecorator(int WeaponPoints){
        this.otherWeapon = null;
        this.WeaponPoints = WeaponPoints;
    }
    
    public WeaponDecorator(WeaponDecorator parentWeapon,int WeaponPoints){
        this.otherWeapon = parentWeapon;
        this.WeaponPoints = WeaponPoints;
    }

    @Override
    public void use() {
        if(this.otherWeapon != null){
            this.otherWeapon.use();
        }
    }
    
    public int getPoints(){
        if(this.otherWeapon != null){
            return this.otherWeapon.getPoints() + this.WeaponPoints;
        }
        return this.WeaponPoints;
    }
}
