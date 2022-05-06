package pokemon;

import java.util.ArrayList;
import java.util.Random;

public class Entrenador {
    private String nombre;
    private Pokemon[] equipo = new Pokemon[4];
    private ArrayList<Pokemon> caja = new ArrayList<Pokemon>();
    private int dinero;
    private int numeroPokeBalls = 4;
    private int contadorEquipo;

    Random r = new Random();

    Entrenador(String nombre, Pokemon pokemonInicial) {

        this.nombre = nombre;
        this.equipo[0] = pokemonInicial;
        this.dinero = r.nextInt(800, 1000);
    }

    public int getNumeroPokeBalls() {
        return numeroPokeBalls;
    }

    public String getNombre() {

        return nombre;
    }

    public Pokemon[] getEquipo() {

        return equipo;
    }

    public ArrayList<Pokemon> getCaja() {

        return caja;
    }

    public int getDinero() {

        return dinero;
    }

    public int getContadorEquipo() {
        return contadorEquipo;
    }

    public void setContadorEquipo(int contadorEquipo) {
        this.contadorEquipo = contadorEquipo;
    }

    public void moverACaja(Pokemon pokemon) {

        for (int i = 0; i < equipo.length; i++) {

            if (equipo[i] == pokemon) {

                caja.add(pokemon);

                equipo[i] = null;

            }
        }

    }

    public void moverAEquipo(Pokemon pokemon) {

        if (contadorEquipo < 4) {

            caja.remove(pokemon);

            equipo[4] = pokemon;

            contadorEquipo++;
        }
    }

    public void entrePesado(Pokemon pokemon) {

        dinero = dinero - 20 * pokemon.getNivel();

        pokemon.setDefensa(pokemon.getDefensa() + 5);

        pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() + 5);

        pokemon.setVitalidad(pokemon.getVitalidad() + 5);

    }

    public void entreFurioso(Pokemon pokemon) {

        dinero = dinero - 30 * pokemon.getNivel();

        pokemon.setAtaque(pokemon.getAtaque() + 5);

        pokemon.setAtaqueEspecial(pokemon.getAtaqueEspecial() + 5);

        pokemon.setVelocidad(pokemon.getVelocidad() + 5);

    }

    public void entreFuncional(Pokemon pokemon) {

        dinero = dinero - 40 * pokemon.getNivel();

        pokemon.setDefensa(pokemon.getDefensa() + 5);

        pokemon.setAtaque(pokemon.getDefensaEspecial() + 5);

        pokemon.setVelocidad(pokemon.getVelocidad() + 5);

        pokemon.setVitalidad(pokemon.getVitalidad() + 5);

    }

    public void entreOnirico(Pokemon pokemon) {

        dinero = dinero - 40 * pokemon.getNivel();

        pokemon.setVelocidad(pokemon.getVelocidad() + 5);
        pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() + 5);
        pokemon.setVitalidad(pokemon.getVitalidad() + 5);
        pokemon.setAtaqueEspecial(pokemon.getAtaqueEspecial() + 5);

    }

    public void setNumeroPokeBalls(int numeroPokeBalls) {
        this.numeroPokeBalls = numeroPokeBalls;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void setCaja(ArrayList<Pokemon> caja) {
        this.caja = caja;
    }

    public void setEquipo(Pokemon[] equipo) {
        this.equipo = equipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void añadirPokemon(Pokemon pokemon) {

        for (int i = 0; i < 4; i++) {

            if (equipo[i] == null) {

                equipo[i] = pokemon;
            }
        }

    }

    public void capturar() {

        boolean captura = false;
        Pokemon pokemon; // TODO bBDD.get(e)
        int i;

        while (captura == false) {

            i = (int) Math.random() * 3;

            if (i < 3) {

                // TODO caja.add(pokemon);
            }

            numeroPokeBalls--;
        }
    }
}
