# Text-Driven Pokemon Go Simulator

This is one of the programming projects for CSE8B @UCSD.

- `Item.java`: This is a super class. `Berry.java` and `Pokeball.java` are inherited from this Item class.
- `Berry.java`: A class that inherits from `Item.java` and represents the berry that can increase the chance of catching the WildPokemons.
- `Pokeball.java`: A class that inherits from `Item.java` and represents the pokeball that is used to capture WildPokemons.

- `Pokemon.java`: This is a super class. `PalPokemon.java` and `WildPokemon.java` are inherited from this Pokemon class.
- `PalPokemon.java`: A class that inherits from `Pokemon.java` and represents the pokemons you caught. The pokeball that is used to capture this pokemon is recorded.
- `WildPokemon.java`: A class that inherits from `Pokemon.java` and represents a pokemon you encounter at the first time. By chance, you can catch it and be the trainer, then they would become PalPokemons.

- `Backpack.java`: A class that is an inventory for all the items (both Berry and Pokeball).
- `Pokedex.java`: A class that is a wikipedia for pokemons (both PalPokemon and WildPokemon) that you’ve encountered.

- `PokemonGame.java`: This is the main class. Unit tests are done first to make sure the classes functions as expected, then the actual game is called for users to interact using command line arguments.

Thank you :)
