///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PokemonGame.java
// File:               Backpack.java
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
 * A class that is an inventory for all the items
 * It has one ArrayList for items (Berry and Pokeball)
 * You can display what’s in the backpack with display() method
 *
 * Bugs: NONE
 *
 * @author Ziyue Chen, Rachel Chung (TA, provided some starter codes)
 */
public class Backpack
{
    private ArrayList<Item> myItems;  // List of items to store pokeballs and
                                      // berries

    /**
     * Initialize a resizable-array ArrayLists which is the member variables of
     * this Backpack class
     *
     * @param N/A
     * @return N/A
     */
    public Backpack()
    {
        myItems = new ArrayList<Item>();
    }

    /**
     * Take an Item object and add it to myItems ArrayList
     *
     * @param item An Item object
     * @return N/A
     */
    public void add(Item item)
    {
        myItems.add(item);
    }

    /**
     * Print out all the items in the backpack
     *
     * @param N/A
     * @return N/A
     */
    public void display()
    {
        System.out.println("Items in the backpack: ");
        System.out.println();

        if (myItems.size() == 0)
        {
            System.out.println("None");
            System.out.println();
        }
        else
        {
            for (int i = 0; i < myItems.size(); i++)
            {
                System.out.println(myItems.get(i).toString());
            }
        }
    }

    /**
     * Find and remove the Pokeball with the given name from the Backpack, and
     * return it
     *
     * @param ballName The name of the Pokeball
     * @return The Pokeball with the given name
     */
    public Pokeball useBall(String ballName)
    {
        for (int i = 0; i < myItems.size(); i++)
        {
            if (myItems.get(i).getName().equals(ballName))
            {
                Pokeball usedPokeball = (Pokeball)myItems.get(i);
                myItems.remove(i);
                return usedPokeball;
            }
        }

        System.out.print("Pokeball " + ballName);
        System.out.println(" does not exist in the backpack!\n");
        return null;
    }

    /**
     * Find and remove the Berry with the given name from the Backpack, and
     * return it
     *
     * @param ballName The name of the Berry
     * @return The Berry with the given name
     */
    public Berry useBerry(String berryName, int index)
    {
        if (myItems.get(index).getName().equals(berryName))
        {
            // If the Item at a current index in the Backpack’s arraylist is the
            // Berry to be used, the Item at this index should be removed and
            // the method should return the Berry object
            Berry usedBerry = (Berry)myItems.get(index);
            myItems.remove(index);
            return usedBerry;
        }
        if (index + 1 < myItems.size())
        {
            // Otherwise, recursively call this method with an incremented index
            return useBerry(berryName, index + 1);
        }
        else
        {
            // If the method gets to the end of the Backpack and has not found
            // the Berry, return null
            System.out.print("Berry " + berryName);
            System.out.println(" does not exist in the backpack!\n");
            return null;
        }
    }
}
