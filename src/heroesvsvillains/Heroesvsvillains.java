/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroesvsvillains;

import Attacks.*;
import Characters.*;
import Weapons.*;
import Models.CharacterModel;
import Subjects.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author alfre
 */
public class Heroesvsvillains {
    private static int numCharacters = 5;
    private static int deadHeroes = 0;
    private static int deadVillains = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int rounds = Integer.parseInt(args[0]);
        
        ArrayList<CharacterModel> Heroes = new ArrayList<CharacterModel>();
        ArrayList<CharacterModel> Villains = new ArrayList<CharacterModel>();
        Pythia Pythia = new Pythia();
        Rhea Rhea = new Rhea();
        
        int currentCharacters = numCharacters;
        
        if(rounds > 0 && rounds < 9){
            for(int x = 0;x < numCharacters; x++){
                Heroes.add(getHeroType(x));
                Villains.add(getVillainType(x));
            }
            
            for(CharacterModel heroe : Heroes){
                Rhea.registerObserver(heroe);
            }
            
            for(CharacterModel villain : Villains){
                Pythia.registerObserver(villain);
            }
            
            Collections.shuffle(Heroes);
            Collections.shuffle(Villains);
            
            for(int round = 0; round < rounds; round ++){
                System.out.println();
                System.out.println("Round " + (round + 1) + ":");
                
                //Pythia.setLoser(Villains);
                //Rhea.setLoser(Heroes);
                
                if(deadHeroes > deadVillains)
                    currentCharacters = numCharacters - deadHeroes;
                else if(deadHeroes < deadVillains)
                    currentCharacters = numCharacters - deadVillains;
                else
                    currentCharacters = numCharacters - deadHeroes;
                
                for(int x = 0;x < currentCharacters; x++){
                    boolean currentHeroState = true;
                    boolean currentVillainState = true;
                    
                    System.out.println();
                    if(Villains.get(x).isAlive() && Heroes.get(x).isAlive()){
                        System.out.println();
                        System.out.println(Heroes.get(x).name() + " vs " + Villains.get(x).name());
                    }
                    System.out.println();
                    if(Heroes.get(x).isAlive()){
                        System.out.print(Heroes.get(x).name());
                        currentHeroState = Heroes.get(x).performAttack(Villains.get(x));
                        if(!currentHeroState){
                            deadHeroes++;
                        }
                    }
                    System.out.println();
                    if(Villains.get(x).isAlive()){
                        System.out.print(Villains.get(x).name());
                        currentVillainState = Villains.get(x).performAttack(Heroes.get(x));
                        if(!currentVillainState){
                            deadVillains++;
                        }
                    }
                    Heroes.get(x).setAlive(currentHeroState);
                    Villains.get(x).setAlive(currentVillainState);
                    
                    if(isGameOver(Heroes,Villains,round,rounds)){
                        x = numCharacters;
                        round = rounds;
                    }
                }
                Heroes = throwBodies(Heroes);
                Villains = throwBodies(Villains);
            }
        }
        else{
            System.out.println("Thats not a valid number of rounds.");
        }
    }
    
    static ArrayList<CharacterModel> throwBodies(ArrayList<CharacterModel> characters){
        ArrayList<CharacterModel> newFrontline = new ArrayList<CharacterModel>();
        for(CharacterModel character: characters){
            if(character.isAlive()){
                newFrontline.add(character);
            }
        }
        return newFrontline;
    }
    
    static boolean isGameOver(ArrayList<CharacterModel> heroes,ArrayList<CharacterModel> villains,int round, int maxRounds){
        if(round == maxRounds - 1){
            for (CharacterModel heroe : heroes) {
                if ((heroe instanceof King) && heroe.isAlive()) {
                    System.out.println();
                    System.out.println("The King survived! Heros win!");
                    return true;
                }
            }
        }
        for (CharacterModel heroe : heroes) {
            if ((heroe instanceof King) && !heroe.isAlive()) {
                System.out.println();
                System.out.println("The King is dead! Villains win...");
                return true;
            }
        }
        
        for (CharacterModel villain : villains) {
            if ((villain instanceof Lilith) && !villain.isAlive()) {
                System.out.println();
                System.out.println("Lilith is dead! Heroes win!");
                return true;
            }
        }
            
        return false;
    }
    
    public static CharacterModel getHeroType(int index){
        switch(index){
            case 0:
                return new King(new KingAttack(), getWeapons(),true);
            case 1:
                return new Queen(new QueenAttack(), getWeapons(),true);
            case 2:
                return new Bishop(new BishopAttack(), getWeapons(),true);
            case 3:
                return new Knight(new KnightAttack(), getWeapons(),true);
            case 4:
                return new Warrior(new WarriorAttack(), getWeapons(),true);
        }
        return null;
    }
    
    public static CharacterModel getVillainType(int index){
        switch(index){
            case 0:
                return new Lilith(new LilithAttack(), getWeapons(),false);
            case 1:
                return new Wizard(new WizardAttack(), getWeapons(),false);
            case 2:
                return new Troll(new TrollAttack(), getWeapons(),false);
            case 3:
                return new Ghoul(new GhoulAttack(), getWeapons(),false);
            case 4:
                return new Spectro(new SpectroAttack(), getWeapons(),false);
        }
        return null;
    }
    
    public static WeaponDecorator getWeapons(){
        WeaponDecorator weapons = getWeapon(new Random().nextInt(5));
        
        weapons = getWeapon(new Random().nextInt(5),weapons);
        
        weapons = getWeapon(new Random().nextInt(5),weapons);
        
        return weapons;
    }
    
    public static WeaponDecorator getWeapon(int index, WeaponDecorator wrapper){
        switch(index){
            case 0:
                return new Knife(wrapper);
            case 1:
                return new Axe(wrapper);
            case 2:
                return new Bow(wrapper);
            case 3:
                return new Sword(wrapper);
            case 4:
                return new Armor(wrapper);
        }
        return null;
    }
    
    public static WeaponDecorator getWeapon(int index){
        switch(index){
            case 0:
                return new Knife();
            case 1:
                return new Axe();
            case 2:
                return new Bow();
            case 3:
                return new Sword();
            case 4:
                return new Armor();
        }
        return null;
    }
}
