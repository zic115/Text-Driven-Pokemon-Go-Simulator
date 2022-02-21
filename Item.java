///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PokemonGame.java
// File:               Item.java
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
 * This is a super class. Berry.java and Pokeball.java will be
 * inherited from this Item class.
 *
 * Bugs: None known
 *
 * @author Ziyue Chen, Rachel Chung (TA, provided some starter codes)
 */

public class Item{
	protected String name;

	/**
	 * Creates a new Item with default name "item"
	 *
	 */
	public Item () {
		this.name = "item";
	}

	/**
	 * Creates a new Item with the given itemName
	 *
	 * @param itemName the item name
	 */
	public Item(String itemName) {
		this.name = itemName;
	}

	/**
	 * Gets the name of the item.
	 *
	 * @return name of the item
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns a string representation of this object.
	 *
	 * @return string representation of this object.
	 */
	@Override
	public String toString() {
		String outputString;

		outputString = this.name + "\n";
		return outputString;
	}
}
