/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Behaviors.*;

/**
 *
 * @author Bruno
 */
public abstract class CharacterModel {
    protected boolean alive;
    protected boolean hero;
    public AttackBehavior attackBehavior;
    public WeaponBehavior weaponBehavior;

    public CharacterModel(AttackBehavior attackBehavior, WeaponBehavior weaponBehavior,boolean isHero) {
        this.attackBehavior = attackBehavior;
        this.weaponBehavior = weaponBehavior;
        this.alive = true;
        this.hero = isHero;
    }
    
    public abstract String name();
    
    public boolean performAttack(CharacterModel target){
        return attackBehavior.attack(target,this.weaponBehavior);
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        if(!alive){
            System.out.println();
            System.out.println(this.getClass().getSimpleName()+ " has fallen...");
        }
        this.alive = alive;
    }

    public void setAttackBehavior(AttackBehavior attackBehavior) {
        this.attackBehavior = attackBehavior;
    }

    public void setWeaponBehavior(WeaponBehavior weaponBehavior) {
        this.weaponBehavior = weaponBehavior;
    }

    public boolean isHero() {
        return hero;
    }
    
    public boolean isVillain() {
        return !hero;
    }

    public void setHero(boolean hero) {
        this.hero = hero;
    }
}
