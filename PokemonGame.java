///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              Test other classes and run the actual Pokemon game
// Files:              Item.java, Pokeball.java, Berry.java, Pokemon.java,
//                     PalPokemon.java, WildPokemon.java, Backpack.java,
//                     Pokedex.java, PokemonGame.java
// Quarter:            CSE 8B Winter 2021
//
// Author:             Ziyue Chen
// Email:              zic115@ucsd.edu
// Instructor's Name:  Christine Alvarado
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//                  CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                  If pair programming is allowed:
//                  1. Read PAIR-PROGRAMMING policy
//                  2. Choose a partner wisely
//                  3. Complete this section for each program file
//
// Pair Partner:        N/A
// Email:               N/A
// Instructors's Name:  N/A
// Lab Section:         N/A
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but roommates, relatives, strangers, etc do.
//
// Persons:          NONE
//
// Online sources:   NONE
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.Scanner;
import java.util.ArrayList;

/**
 * An interactive text game where users can capture Pokemon with Berries
 * and Pokeballs.
 *
 * @author Ziyue Chen, Sachin Deshpande (TA, provided some starter codes)
 */
public class PokemonGame {

    /**
     * Defined variables to use in the game
     * Do not modify any of these
     *
     */
    private static String[] pokeballNames = {"pokeball", "superball",
    "ultraball"};
    private static int[] pokeballPerformance = {0, 10, 30};

    private static String[] berryNames = {"Razz Berry", "Nanap Berry",
    "Golden Razz Berry"};
    private static final int RAZZ_BERRY_PATIENCE_INC = 10;
    private static final int RAZZ_BERRY_SPEED_DEC = 0;
    private static final int NANAP_BERRY_PATIENCE_INC = 0;
    private static final int NANAP_BERRY_SPEED_DEC = 10;
    private static final int GOLDEN_RAZZ_BERRY_PATIENCE_INC = 30;
    private static final int GOLDEN_RAZZ_BERRY_SPEED_DEC = 30;

    private static String[] pokemonNames = {"Pikachu", "Bulbasaur",
    "Charmander", "Squirtle", "Mew"};
    private static String[] pokemonSounds = {"pikapika", "bulb", "char",
    "squir", "mew"};
    private static String[] pokemonTypes = {"electric", "grass", "fire",
    "water", "psychic"};
    private static int[] pokemonPatienceStats = {60, 50, 50, 50, 15};
    private static int[] pokemonSpeedStats = {25, 5, 20, 10, 50};

    // The amount of patience the WildPokemon decreases on escape from a pokeball
    private static final int PATIENCE_DEC_EACH_ESCAPE = 5;
    private static final String PROMPT_MSG_START =
    "You will encounter different pokemons.\n" +
    "You can throw different poke balls to catch them.\n" +
    "You can use Razz Berry or Golden Razz Berry to increase the catch rate.\n" +
    "You can use Nanap Berry to make the ball hit more easily.\n" +
    "Up to one berry per throw. Use the berry before your ball throw.\n";

    private static final String PROMPT_MSG_BERRY =
        "Which berry do you want to use? " +
        "Type skip if you are confident. " +
        "(Razz Berry, Nanap Berry, Golden Razz Berry, skip)";
    private static final String PROMPT_MSG_BERRY_WRONG_INPUT =
        "Your berry input was not recognized. " +
        "Choose one from the following four options: " +
        "Razz Berry, Nanap Berry, Golden Razz Berry, skip";
    private static final String PROMPT_MSG_POKEBALL =
        "Which pokeball do you want to use? (pokeball, superball, ultraball)";
    private static final String PROMPT_MSG_POKEBALL_WRONG_INPUT =
        "Your pokeball input was not recognized. " +
        "Choose one from the following four options: " +
        "pokeball, superball, ultraball";
    private static final String PROMPT_MSG_CHECK_CAUGHT_POKEMONS =
        "Now let's check who're your pals now!\n";

    /**
     * These are the number of Berries and Pokeballs the user starts with
     * The counts can be changed.
     *
     */
    private static final int START_BERRY_COUNT = 2;
    private static final int START_POKEBALL_COUNT = 4;

    private static Backpack myBackpack;
    private static Pokedex myPokedex;

    /**
     * Get a Berry from the user
     *
     * @param myScanner: reference to where user input will come from
     * @return : a Berry object that the user will use later on
     *
     * Side effects: removes a berry from the backpack, if a user uses one.
     * If so, it should also decrement the appropriate berry count.
     *
     */
    public static Berry getUserBerry(Scanner myScanner)
    {
        // Prompt the user to type in what berry they would like to use by using
        // the prompt string in the PROMPT_MSG_BERRY variable
        System.out.println(PROMPT_MSG_BERRY);
        String inputBerry = myScanner.nextLine();

        if (inputBerry.equals("skip"))
        {
            // If the user types “skip”, return a new Berry object with an empty
            // string for the berryName and 0 for both the patienceInc and
            // speedDec
            Berry skipBerry = new Berry("", 0, 0);
            return skipBerry;
        }

        for (int i = 0; i < berryNames.length; i++)
        {
            if (inputBerry.equals(berryNames[i]))
            {
                // Call useBerry to determine whether the Berry exists in the
                // backpack
                Berry findBerry = myBackpack.useBerry(inputBerry, 0);
                if (findBerry == null)
                {
                    // If they do not have that berry in their backpack, print
                    // “You don't have any [Berry type] left!" and recursively
                    // call this method
                    System.out.println("You don't have any " + inputBerry
                                       + " left!\n");
                    return getUserBerry(myScanner);
                }
                else
                {
                    // If they do, return the Berry object from the useBerry
                    // method call
                    return findBerry;
                }
            }
        }

        // If the Berry they have entered is not one of the Berries we
        // recognize, print the error message PROMPT_MSG_BERRY_WRONG_INPUT and
        // recursively call this method
        System.out.println(PROMPT_MSG_BERRY_WRONG_INPUT);
        System.out.println();
        return getUserBerry(myScanner);
    }

    /**
     * Get a Pokeball from the user
     *
     * @param myScanner: reference to where user input will come from
     * @return : a Pokeball object that the user will use later on
     *
     * Side effects: removes a Pokeball from the backpack.
     * Decrement the appropriate pokeball count.
     *
     */
    public static Pokeball getUserPokeball(Scanner myScanner)
    {
        // Prompt the user to type in what pokeball they would like to use by
        // using the prompt string in the PROMPT_MSG_POKEBALL variable
        System.out.println(PROMPT_MSG_POKEBALL);
        String inputPokeball = myScanner.nextLine();

        for (int i = 0; i < pokeballNames.length; i++)
        {
            if (inputPokeball.equals(pokeballNames[i]))
            {
                // Call useBall to determine whether the Pokeball exists in the
                // backpack
                Pokeball findPokeball = myBackpack.useBall(inputPokeball);
                if (findPokeball == null)
                {
                    // If they do not have that pokeball in their backpack,
                    // print “You don't have any [PokeBall type] left!" and
                    // recursively call this method
                    System.out.println("You don't have any " + inputPokeball
                                       + " left!\n");
                    return getUserPokeball(myScanner);
                }
                else
                {
                    // If they do, return the PokeBall object from the useBall
                    // method call
                    return findPokeball;
                }
            }
        }

        // If the Pokeball they have entered is not one of the Pokeballs we
        // recognize, print out PROMPT_MSG_POKEBALL_WRONG_INPUT and recursively
        // call this method
        System.out.println(PROMPT_MSG_POKEBALL_WRONG_INPUT);
        System.out.println();
        return getUserPokeball(myScanner);
    }

    /**
     * Start the Pokemon game
     *
     * @param N/A
     * @return N/A
     */
    public static void startYourJourney() {
        ArrayList <PalPokemon> myPalPokemons = new ArrayList<PalPokemon>();

        myBackpack = new Backpack();
        myPokedex = new Pokedex();

        // The user starts out with some berries and pokeballs of each type
        // Write a for loop to add berries to the backpack object
        // Add START_BERRY_COUNT berries of each type
        for (int index = 0; index < START_BERRY_COUNT; index++)
        {
            for (int i = 0; i < berryNames.length; i++)
            {
                if (berryNames[i].equals("Razz Berry"))
                {
                    Berry newRazzBerry = new Berry(berryNames[i],
                                                   RAZZ_BERRY_PATIENCE_INC,
                                                   RAZZ_BERRY_SPEED_DEC);
                    myBackpack.add(newRazzBerry);
                }
                if (berryNames[i].equals("Nanap Berry"))
                {
                    Berry newNanapBerry = new Berry(berryNames[i],
                                                    NANAP_BERRY_PATIENCE_INC,
                                                    NANAP_BERRY_SPEED_DEC);
                    myBackpack.add(newNanapBerry);
                }
                if (berryNames[i].equals("Golden Razz Berry"))
                {
                    Berry newGoldenRazzBerry = new Berry(berryNames[i],
                                                GOLDEN_RAZZ_BERRY_PATIENCE_INC,
                                                GOLDEN_RAZZ_BERRY_SPEED_DEC);
                    myBackpack.add(newGoldenRazzBerry);
                }
            }
        }

        // Write a for loop to add pokeballs to the backpack object
        // Add START_POKEBALL_COUNT Pokeballs of each type
        for (int index = 0; index < START_POKEBALL_COUNT; index++)
        {
            for (int i = 0; i < pokeballNames.length; i++)
            {
                Pokeball newPokeball = new Pokeball(pokeballNames[i],
                                                    pokeballPerformance[i]);
                myBackpack.add(newPokeball);
            }
        }

        System.out.println("A new adventurer wakes up to start their journey!");
        System.out.println("Their backpack contains the following...");
        myBackpack.display();

        // Start the user-machine interaction
        Scanner myScanner = new Scanner(System.in);  // Create a Scanner object
        System.out.println(PROMPT_MSG_START); // Prompt user
        for (int i = 0; i < pokemonNames.length; i++) {
            WildPokemon wildPokemon = new WildPokemon(pokemonNames[i],
                pokemonSounds[i],
                pokemonTypes[i],
                pokemonPatienceStats[i],
                pokemonSpeedStats[i]);
            wildPokemon.appear();
            myPokedex.add(wildPokemon);

            while (true) {
                Berry userBerry = null;
                Pokeball userPokeball = null;
                // Call getUserBerry and store its result in userBerry
                userBerry = getUserBerry(myScanner);
                // Call getUserPokeball and store its result in userPokeball
                userPokeball = getUserPokeball(myScanner);

                if (wildPokemon.isCaught(userBerry, userPokeball) ){
                    System.out.println(wildPokemon.getName() + " is caught!\n");
                    PalPokemon caughtPokemon = new PalPokemon(wildPokemon.getName(),
                        wildPokemon.getSound(),
                        wildPokemon.getType(),
                        userPokeball.getName());
                    myPalPokemons.add(caughtPokemon);
                    myPokedex.add(caughtPokemon);
                    break;
                }
                // The WildPokemon escaped.
                System.out.println(wildPokemon.getName() + " escapes!");
                System.out.println(wildPokemon.getName() +
                "'s times escaped from ball: " +
                wildPokemon.getTimesEscapedFromBall()+"\n");

                // Decrease its patience
                int patienceDec =
                wildPokemon.getTimesEscapedFromBall() * PATIENCE_DEC_EACH_ESCAPE;
                wildPokemon.setPatience(pokemonPatienceStats[i] - patienceDec);
                wildPokemon.setSpeed(pokemonSpeedStats[i]);

                // Check if the pokemon gets away.  If so, stop trying to
                // catch it.
                if (wildPokemon.disappear()){
                    break;
                }
            }
        }

        System.out.println(PROMPT_MSG_CHECK_CAUGHT_POKEMONS);
        for (PalPokemon pal: myPalPokemons ){
            pal.comesOutFromBall();
        }

        System.out.println("Your pokedex now says:");
        myPokedex.display();

        System.out.println("Items left in Backpack:");
        myBackpack.display();
    }

    /**
    * Test the methods useBerry and isCaught
    * Make tests to ensure that the Pokemon classes work correctly
    *
    * @param: nothing
    * @return: true if all the tests pass, false otherwise
    *
    */
    public static boolean unitTests()
    {
        // Test isCaught method
        System.out.println("\nTest isCaught -------------------------------\n");

        // isCaught Test 1
        WildPokemon wildPokemon1 = new WildPokemon("Pikachu", "pikapika",
                                                   "electric", 60, 25);
        Berry berry1 = new Berry("Razz Berry", 10, 0);
        Pokeball pokeball1 = new Pokeball("Regular Ball", 0);

        if (wildPokemon1.isCaught(berry1, pokeball1))
        {
            System.out.println("isCaught Test 1 passed!");
        }
        else
        {
            return false;
        }

        // isCaught Test 2
        WildPokemon wildPokemon2 = new WildPokemon("Bulbasaur", "bulb", "grass",
                                                   50, 5);
        Berry berry2 = new Berry("Nanap Berry", 0, 10);
        Pokeball pokeball2 = new Pokeball("Great Ball", 10);

        if (wildPokemon1.isCaught(berry2, pokeball2))
        {
            System.out.println("isCaught Test 2 passed!\n");
        }
        else
        {
            return false;
        }

        // Test Backpack class
        System.out.println("\nTest Backpack -------------------------------\n");
        Backpack testBackpack = new Backpack();
        testBackpack.display();

        Berry razzBerry = new Berry("Razz Berry", 10, 0);
        Berry nanapBerry = new Berry("Nanap Berry", 0, 10);
        Pokeball superball = new Pokeball("superball", 10);
        Pokeball ultraball = new Pokeball("ultraball", 30);

        System.out.println("\nAdding 2 pokeballs --------------------------\n");
        testBackpack.add(superball);
        testBackpack.add(ultraball);

        System.out.println("\nAdding 2 berries ----------------------------\n");
        testBackpack.add(razzBerry);
        testBackpack.add(nanapBerry);
        testBackpack.display();

        // useBerry Test 1
        System.out.println("\nRemoving some berries -----------------------\n");
        // Use some berries in the backpack
        testBackpack.useBerry("Razz Berry", 0);
        testBackpack.useBerry("Nanap Berry", 0);
        testBackpack.display();

        // useBall Test 1
        System.out.println("\nRemoving some pokeballs ---------------------\n");
        // Use some pokeballs in the backpack
        testBackpack.useBall("superball");
        testBackpack.useBall("ultraball");
        testBackpack.display();

        // useBerry Test 2
        Berry berry3 = new Berry("Razz Berry", 10, 0);
        Berry berry4 = new Berry("Golden Razz Berry", 30, 0);
        Berry berry5 = new Berry("Razz Berry", 10, 0);

        System.out.println("\nAdding 3 berries ----------------------------\n");
        testBackpack.add(berry3);
        testBackpack.add(berry4);
        testBackpack.add(berry5);
        testBackpack.display();

        System.out.println("\nRemoving some berries -----------------------\n");
        // Use some berries in the backpack
        testBackpack.useBerry("Razz Berry", 1);
        testBackpack.useBerry("Razz Berry", 0);
        testBackpack.useBerry("Golden Razz Berry", 0);
        testBackpack.display();

        // useBerry Test 3
        Berry berry6 = new Berry("Razz Berry", 10, 0);
        Berry berry7 = new Berry("Nanap Berry", 0, 10);
        Berry berry8 = new Berry("Razz Berry", 10, 0);
        Berry berry9 = new Berry("Golden Razz Berry", 30, 0);
        Berry berry10 = new Berry("Nanap Berry", 0, 10);

        System.out.println("\nAdding 5 berries ----------------------------\n");
        testBackpack.add(berry6);
        testBackpack.add(berry7);
        testBackpack.add(berry8);
        testBackpack.add(berry9);
        testBackpack.add(berry10);
        testBackpack.display();

        System.out.println("\nRemoving some berries -----------------------\n");
        // Use some berries in the backpack
        testBackpack.useBerry("Razz Berry", 0);
        testBackpack.useBerry("Nanap Berry", 2);
        testBackpack.useBerry("Razz Berry", 0);
        testBackpack.useBerry("Golden Razz Berry", 0);
        testBackpack.useBerry("Razz Berry", 0);
        testBackpack.display();

        return true;
    }

    public static void main(String[] args) {
        // Perform unitTests first
        if(unitTests()) {
            System.out.println("All unit tests passed.\n");
        } else {
            System.out.println("Failed test.\n");
            return;
        }

        startYourJourney();
        System.out.println("")
    }
}
