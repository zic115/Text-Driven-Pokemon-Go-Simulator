///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PokemonGame.java
// File:               Pokeball.java
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

/**
 * A class that inherits from Item.java and represents the pokeball that is
 * used to capture WildPokemons
 *
 * Bugs: NONE
 *
 * @author Ziyue Chen
 */
public class Pokeball extends Item
{
    private int performance;  // This field will do with the catch rate
                              // Higher performance will increase catch rate
                              // more

    /**
     * Call the parent class default constructor and initialize the member
     * variable value to 0
     *
     * @param N/A
     * @return N/A
     */
    public Pokeball()
    {
        super();
        this.performance = 0;
    }

    /**
     * Call the parent class constructor to set the member variable name of the
     * parent class to pokeballName and initialize the member variable
     * performance to the value of the parameter performanceIn
     *
     * @param pokeballName The name of the pokeball
     * @param performanceIn The performance of the pokeball
     * @return N/A
     */
    public Pokeball(String pokeballName, int performanceIn)
    {
        super(pokeballName);
        this.performance = performanceIn;
    }

    /**
     * Return the value of the performance variable
     *
     * @param N/A
     * @return The value of the performance variable
     */
    public int getPerformance()
    {
        return this.performance;
    }

    /**
     * Override the toString method and return a string that represents the name
     * of the pokeball and its performance
     *
     * @param N/A
     * @return A string that represents the name of the pokeball and its
     *         performance
     */
    @Override
    public String toString()
    {
        String outputString;

        outputString = super.getName() + "\n"
                       + "performance: " + this.performance + "\n";
        return outputString;
    }
}
