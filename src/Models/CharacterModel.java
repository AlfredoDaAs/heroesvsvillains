/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Behaviors.*;
import OPInterfaces.Observer;

/**
 *
 * @author Bruno
 */
public abstract class CharacterModel implements Observer {
    protected boolean alive;
    protected boolean hero;
    public AttackBehavior attackBehavior;
    public WeaponBehavior weaponBehavior;
    public CharacterModel oracleMessage;

    public CharacterModel(AttackBehavior attackBehavior, WeaponBehavior weaponBehavior,boolean isHero) {
        this.attackBehavior = attackBehavior;
        this.weaponBehavior = weaponBehavior;
        this.alive = true;
        this.hero = isHero;
    }
    
    public abstract String name();
    
    public boolean performAttack(CharacterModel target){
        boolean attackResult = false;
        attackResult = attackBehavior.attack(target,this.weaponBehavior);
        if(oracleMessage != null && this.getClass() == oracleMessage.getClass()){
            attackResult =  false;
        }
        return attackResult;
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
    
    @Override
    public void update(CharacterModel looser) {
        this.oracleMessage = looser;
    }
}
