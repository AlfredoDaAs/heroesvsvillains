/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heroesvsvillains;

import Attacks.*;
import Behaviors.WeaponBehavior;
import Characters.*;
import Weapons.*;
import Models.CharacterModel;
import java.util.Random;

/**
 *
 * @author alfre
 */
public class Heroesvsvillains {
    private static int numCharacters = 4;
    private static int deadHeroes = 0;
    private static int deadVillains = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //int rounds = Integer.parseInt(args[0]);
        int rounds = 3;
        CharacterModel[] Heroes = new CharacterModel[numCharacters];
        CharacterModel[] Villains = new CharacterModel[numCharacters];
        int currentCharacters = numCharacters;
        
        if(rounds > 0 && rounds < 9){
            for(int x = 0;x < numCharacters; x++){
                Heroes[x] = getHeroType(x);
                Villains[x] = getVillainType(x);
            }
            shuffleArray(Heroes);
            shuffleArray(Villains);
            
            for(int round = 0; round < rounds; round ++){
                System.out.println();
                System.out.println("Round " + (round + 1) + ":");
                
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
                    if(Villains[x].isAlive() && Heroes[x].isAlive()){
                        System.out.println();
                        System.out.println(Heroes[x].name() + " vs " + Villains[x].name());
                    }
                    System.out.println();
                    if(Heroes[x].isAlive()){
                        System.out.print(Heroes[x].name());
                        currentHeroState = Heroes[x].performAttack(Villains[x]);
                        if(!currentHeroState){
                            deadHeroes++;
                        }
                    }
                    System.out.println();
                    if(Villains[x].isAlive()){
                        System.out.print(Villains[x].name());
                        currentVillainState = Villains[x].performAttack(Heroes[x]);
                        if(!currentVillainState){
                            deadVillains++;
                        }
                    }
                    Heroes[x].setAlive(currentHeroState);
                    Villains[x].setAlive(currentVillainState);
                    
                    if(isGameOver(Heroes,Villains,round,rounds)){
                        x = numCharacters;
                        round = rounds;
                    }
                }
                Heroes = throwBodies(Heroes,numCharacters - deadHeroes);
                Villains = throwBodies(Villains,numCharacters - deadVillains);
                shuffleArray(Heroes);
                shuffleArray(Villains);
            }
        }
        else{
            System.out.println("Thats not a valid number of rounds.");
        }
    }
    
    static CharacterModel[] throwBodies(CharacterModel[] characters,int newSize){
        CharacterModel[] newArray = new CharacterModel[newSize];
        for(int x = 0,y = 0;x<characters.length;x++){
            if(characters[x].isAlive()){
                newArray[y] = characters[x];
                y++;
            }
        }
        return newArray;
    }
    
    static boolean isGameOver(CharacterModel[] heroes,CharacterModel[] villains,int round, int maxRounds){
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
    
    static void shuffleArray(CharacterModel[] array)
    {
        Random rnd = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            CharacterModel aux = array[index];
            array[index] = array[i];
            array[i] = aux;
        }
    }
    
    public static CharacterModel getHeroType(int index){
        switch(index){
            case 0:
                return new King(new KingAttack(), getWeaponBehavior(new Random().nextInt(4)),true);
            case 1:
                return new Queen(new QueenAttack(), getWeaponBehavior(new Random().nextInt(4)),true);
            case 2:
                return new Bishop(new BishopAttack(), getWeaponBehavior(new Random().nextInt(4)),true);
            case 3:
                return new Knight(new KnightAttack(), getWeaponBehavior(new Random().nextInt(4)),true);
        }
        return null;
    }
    
    public static CharacterModel getVillainType(int index){
        switch(index){
            case 0:
                return new Lilith(new LilithAttack(), getWeaponBehavior(new Random().nextInt(4)),false);
            case 1:
                return new Wizard(new WizardAttack(), getWeaponBehavior(new Random().nextInt(4)),false);
            case 2:
                return new Troll(new TrollAttack(), getWeaponBehavior(new Random().nextInt(4)),false);
            case 3:
                return new Ghoul(new GhoulAttack(), getWeaponBehavior(new Random().nextInt(4)),false);
        }
        return null;
    }
    
    public static WeaponBehavior getWeaponBehavior(int index){
        switch(index){
            case 0:
                return new Knife();
            case 1:
                return new Axe();
            case 2:
                return new Bow();
            case 3:
                return new Sword();
        }
        return null;
    }
}
