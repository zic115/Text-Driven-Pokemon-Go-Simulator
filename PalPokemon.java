///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PokemonGame.java
// File:               PalPokemon.java
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
 * A class that inherits from Pokemon.java and represents the pokemons you
 * caught
 * The pokeball that was used to capture this pokemon would be recorded
 *
 * Bugs: NONE
 *
 * @author Ziyue Chen
 */
public class PalPokemon extends Pokemon
{
    private String pokeballName;  // The name of the ball that caught the
                                  // pokemon

    /**
     * Call the parent class default constructor and initialize the member
     * variable to “undefined”
     *
     * @param N/A
     * @return N/A
     */
    public PalPokemon()
    {
        super();
        this.pokeballName = "undefined";
    }

    /**
     * Call the parent class constructor to set name of the parent class to
     * pokemonName, sound of the parent class to pokemonSound, and type of the
     * parent class to pokemonType and initialize the member variable
     * pokeballName to the value of the parameter pokeballName
     *
     * @param pokemonName The name of the pokemon
     * @param pokemonSound The sound of the pokemon
     * @param pokemonType The type of the pokemon
     * @param pokeballName The name of the pokeball
     * @return N/A
     */
    public PalPokemon(String pokemonName, String pokemonSound,
                      String pokemonType, String pokeballName)
    {
        super(pokemonName, pokemonSound, pokemonType);
        this.pokeballName = pokeballName;
    }

    /**
     * Return the name of the pokeball
     *
     * @param N/A
     * @return The name of the pokeball
     */
    public String getPokeballName()
    {
        return this.pokeballName;
    }

    /**
     * Print this pokeball’s information
     *
     * @param N/A
     * @return N/A
     */
    public void comesOutFromBall()
    {
        System.out.println(super.getName() + " in " + this.pokeballName + ", "
                           + super.getType() + " type pokemon.");
        super.speak();
    }

    /**
     * Override the toString method and return a string that represents the name
     * of the pal pokemon, specify that it’s a pal pokemon, pokeball name and
     * the type of the pokemon
     *
     * @param N/A
     * @return A string that represents the name of the pal pokemon, specify
     *         that it’s a pal pokemon, pokeball name and the type of the
     *         pokemon
     */
    @Override
    public String toString()
    {
        String outputString;

        outputString = super.getName() + ", PalPokemon" + "\n"
                       + "pokeballName: " + this.pokeballName + "\n"
                       + "type: " + super.getType() + "\n";
        return outputString;
    }
}
