///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PokemonGame.java
// File:               WildPokemon.java
// Quarter:            CSE 8B Winter 2021
//
// Author:             Ziyue Chen, zic115@ucsd.edu
// Instructor's Name:  Christine Alvarado
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// Pair Partner:       N/A
// Email:              N/A
// Instructor's Name:  N/A
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
//
// Persons:          NONE
//
// Online sources:   NONE
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Random;

/**
 * A class that inherits from Pokemon.java and represents a pokemon you
 * encounter at the first time
 * It has no trainers
 * By chance, you can catch it and be the trainer
 * Then they would become PalPokemons
 *
 * Bugs: NONE
 *
 * @author Ziyue Chen
 */
public class WildPokemon extends Pokemon
{
    private int patience;  // The patience of a wild pokemon
    private int speed;  // The move speed of a wild pokemon
    private int timesEscapedFromBall;  // The times that a wild pokemon escapes
                                       // from a pokeball

    /**
     * Call the parent class default constructor and initialize the member
     * variables all to 0
     *
     * @param N/A
     * @return N/A
     */
    public WildPokemon()
    {
        super();
        this.patience = 0;
        this.speed = 0;
        this.timesEscapedFromBall = 0;
    }

    /**
     * Call the parent class constructor to set the name of the parent class to
     * pokemonName, sound of the parent class to pokemonSound, and type of the
     * parent class to pokemonType and initialize the member variables patience
     * as patienceIn, speed as speedIn, and timesEscapedFromBall as 0
     *
     * @param pokemonName The name of the pokemon
     * @param pokemonSound The sound of the pokemon
     * @param pokemonType The type of the pokemon
     * @param patienceIn The patience of the pokemon
     * @param speedIn The speed of the pokemon
     * @return N/A
     */
    public WildPokemon(String pokemonName, String pokemonSound,
                       String pokemonType, int patienceIn, int speedIn)
    {
        super(pokemonName, pokemonSound, pokemonType);
        this.patience = patienceIn;
        this.speed = speedIn;
        this.timesEscapedFromBall = 0;
    }

    /**
     * Return the patience of the pokemon
     *
     * @param N/A
     * @return The patience of the pokemon
     */
    public int getPatience()
    {
        return this.patience;
    }

    /**
     * Return the speed of the pokemon
     *
     * @param N/A
     * @return The speed of the pokemon
     */
    public int getSpeed()
    {
        return this.speed;
    }

    /**
     * Return the number of times escaped from the ball of the pokemon
     *
     * @param N/A
     * @return The number of times escaped from the ball of the pokemon
     */
    public int getTimesEscapedFromBall()
    {
        return this.timesEscapedFromBall;
    }

    /**
     * Set the pokemon patience value to newPatience
     *
     * @param newPatience A new patience value
     * @return N/A
     */
    public void setPatience(int newPatience)
    {
        this.patience = newPatience;
    }

    /**
     * Set the pokemon speed value to newSpeed
     *
     * @param newPatience A new speed value
     * @return N/A
     */
    public void setSpeed(int newSpeed)
    {
        this.speed = newSpeed;
    }

    /**
     * Increment the timesEscapedFromBall by one
     *
     * @param N/A
     * @return N/A
     */
    public void incrementTimeEscapedFromBall()
    {
        this.timesEscapedFromBall += 1;
    }

    /**
     * Print a message that says the user encounters a wild pokemon and use the
     * parent class method speak() to make the pokemon speak
     *
     * @param N/A
     * @return N/A
     */
    public void appear()
    {
        System.out.println("You encounter a wild " + super.getName() + "!");
        super.speak();
    }

    /**
     * Check if the wild pokemon is going to disappear
     *
     * @param N/A
     * @return True if the wild pokemon’s patience is less than or equal to 0,
     *         or the wild pokemon has escaped from a ball for more than three
     *         times
     *         False otherwise
     */
    public boolean disappear()
    {
        if (this.patience <= 0 | this.timesEscapedFromBall > 3)
        {
            System.out.println(super.getName() + " disappears...");
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Will be implemented and used in PA9
     *
     * @param berry The berry used to catch the wild pokemon
     * @param pokeball The pokeball used to catch the wild pokemon
     * @return True
     */
    public boolean isCaught(Berry berry, Pokeball pokeball)
    {
        // The WildPokemon’s speed should decrease by however much the Berry
        // specifies
        this.setSpeed(this.getSpeed() - berry.getSpeedDecrement());
        // The WildPokemon’s patience should increase by however much the Berry
        // specifies
        this.setPatience(this.getPatience() + berry.getPatienceIncrement());

        // Calculate the threshold needed to catch the WildPokemon
        // threshold = speed - patience + [-30, 30], where [-30, 30] represents
        // a random int in the range of -30 to 30
        Random random = new Random();
        int threshold = this.getSpeed() - this.getPatience()
                        + (random.nextInt(61) - 30);

        if (pokeball.getPerformance() > threshold)
        {
            // If the Pokeball’s performance exceeds the threshold, then the
            // WildPokemon is caught
            return true;
        }
        else
        {
            // Otherwise, the Pokemon’s timesEscapedFromBall should be
            // incremented by 1
            this.incrementTimeEscapedFromBall();
            return false;
        }
    }

    /**
     * Override the toString method and return a string that represents the name
     * of the pokemon, specify that it’s a wild pokemon, the type of the
     * pokemon, patience, speed, and timesEscapedFromBall values
     *
     * @param N/A
     * @return A string that represents the name of the pokemon, specify that
     *         it’s a wild pokemon, the type of the pokemon, patience, speed,
     *         and timesEscapedFromBall values
     */
    @Override
    public String toString()
    {
        String outputString;

        outputString = super.getName() + ", WildPokemon" + "\n"
                       + "type: " + super.getType() + "\n"
                       + "patience: " + this.patience + "\n"
                       + "speed: " + this.speed + "\n"
                       + "timeEscapedFromBall: "
                       + this.timesEscapedFromBall + "\n";
        return outputString;
    }
}
