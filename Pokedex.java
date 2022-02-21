///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PokemonGame.java
// File:               Pokedex.java
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

import java.util.ArrayList;

/**
 * A class that is a wikipedia for pokemons that you’ve encountered
 * It has one ArrayList for pokemons (PalPokemon and WildPokemon)
 * You can display what’s in the pokedex with display() method
 *
 * Bugs: None known
 *
 * @author Ziyue Chen, Rachel Chung (TA, provided some starter codes)
 */
public class Pokedex
{
    private ArrayList<Pokemon> myPokedex;  // List of Pokemons to store wild
                                           // pokemons and pal pokemons

    /**
     * Initialize a resizable-array ArrayLists which is the member variables of
     * this Pokedex class
     *
     * @param N/A
     * @return N/A
     */
    public Pokedex()
    {
        myPokedex = new ArrayList<Pokemon>();
    }

    /**
     * Take a Pokemon object and add it to myPokedex ArrayList
     *
     * @param item A Pokemon object
     * @return N/A
     */
    public void add(Pokemon pokemon)
    {
        myPokedex.add(pokemon);
    }

    /**
     * Print out all the pokemons in the pokedex
     *
     * @param N/A
     * @return N/A
     */
    public void display()
    {
        System.out.println("Pokemons in the pokedex: ");
        System.out.println();

        if (myPokedex.size() == 0)
        {
            System.out.println("None");
            System.out.println();
        }
        else
        {
            for (int i = 0; i < myPokedex.size(); i++)
            {
                System.out.println(myPokedex.get(i).toString());
            }
        }
    }
}
