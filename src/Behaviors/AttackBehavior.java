/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Behaviors;

import Models.CharacterModel;

/**
 *
 * @author alfre
 */
public interface AttackBehavior {
    public boolean attack(CharacterModel target, WeaponBehavior weapon);
}
