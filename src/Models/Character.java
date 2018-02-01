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
public abstract class Character {
    protected boolean alive;
    public AttackBehavior attackBehavior;
    public WeaponBehavior weaponBehavior;
    
    public abstract void display();
}
