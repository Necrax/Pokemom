
import java.util.ArrayList;

public class ArrayPokemons {

    ArrayList<Pokemon> bBDDPokemon = new ArrayList<Pokemon>();

    public ArrayList<Pokemon> getbBDDPokemon() {
        return bBDDPokemon;
    }

    public void setbBDDPokemon(ArrayList<Pokemon> bBDDPokemon) {
        this.bBDDPokemon = bBDDPokemon;
    }

    public void añadirPokemon(Pokemon pokemon) {
        bBDDPokemon.add(pokemon);
    }

}
