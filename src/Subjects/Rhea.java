/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subjects;

import Models.CharacterModel;
import OPInterfaces.Observer;
import OPInterfaces.Subject;
import java.util.ArrayList;
import java.util.Random;

/**
 *  
 * @author Bruno
 */
public class Rhea implements Subject {
    private ArrayList<Observer> observers;
    
    public Rhea(){
        this.observers = new ArrayList<Observer>();
    }

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        this.observers.remove(o);
    }

    @Override
    public void notifyObservers(CharacterModel loser) {
        for(Observer observer: this.observers){
            observer.update(loser);
        }
    }
    
    public void setLoser(ArrayList<CharacterModel> heroes){
        int rand = new Random().nextInt(heroes.size());
        System.out.println("Rhea says " + heroes.get(rand).name() + " will die...");
        notifyObservers(heroes.get(rand));
    }
    
}
