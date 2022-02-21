///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PokemonGame.java
// File:               Berry.java
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
 * A class that inherits from Item.java and represents the berry that can
 * increase the chance of catching the WildPokemons
 *
 * Bugs: NONE
 *
 * @author Ziyue Chen
 */
public class Berry extends Item
{
    private int patienceIncrement;  // This field will also help the catch rate
                                    // Higher patienceIncrement will increase
                                    // catch rate more
    private int speedDecrement;  // This field will help the catch rate from
                                 // another perspective
                                 // Higher speedDecrement will decrease the
                                 // moving speed of a wild Pokemon to make an
                                 // easier pokeball hit

    /**
     * Call the parent class default constructor and initialize both of the
     * member variable values to 0 as default
     *
     * @param N/A
     * @return N/A
     */
    public Berry()
    {
        super();
        this.patienceIncrement = 0;
        this.speedDecrement = 0;
    }

    /**
     * Call the parent class constructor to set the member variable name of the
     * parent class to berryName and initialize the member variable
     * patienceIncrement to the value of the parameter patienceInc and
     * speedDecrement to speedDec
     *
     * @param berryName The name of the berry
     * @param patienceInc The patience increment
     * @param speedDec The speed decrement
     * @return N/A
     */
    public Berry(String berryName, int patienceInc, int speedDec)
    {
        super(berryName);
        this.patienceIncrement = patienceInc;
        this.speedDecrement = speedDec;
    }

    /**
     * Return the patienceIncrement
     *
     * @param N/A
     * @return The patienceIncrement
     */
    public int getPatienceIncrement()
    {
        return this.patienceIncrement;
    }

    /**
     * Return the speedDecrement
     *
     * @param N/A
     * @return The speedDecrement
     */
    public int getSpeedDecrement()
    {
        return this.speedDecrement;
    }

    /**
     * Override the toString method and return a string that represents the name
     * of the berry, patienceIncrement and speedDecrement
     *
     * @param N/A
     * @return A string that represents the name of the berry, patienceIncrement
     *         and speedDecrement
     */
    @Override
    public String toString()
    {
        String outputString;

        outputString = super.getName() + "\n"
                       + "patienceIncrement: " + this.patienceIncrement + "\n"
                       + "speedDecrement: " + this.speedDecrement + "\n";
        return outputString;
    }
}
