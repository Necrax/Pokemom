
import java.util.ArrayList;
import java.util.Random;

public class Entrenador {
    private String nombre;
    private ArrayList<Pokemon> equipo = new ArrayList<Pokemon>();
    private ArrayList<Pokemon> caja = new ArrayList<Pokemon>();
    private int dinero;
    private int numeroPokeBalls = 4;
    private int contadorEquipo;

    Random random = new Random();

    Entrenador(String nombre) {

        this.nombre = nombre;

        this.dinero = random.nextInt(800, 1000);
    }

    public int getNumeroPokeBalls() {
        return numeroPokeBalls;
    }

    public Pokemon sacarPokemon(int i) {
        i--;
        return equipo.get(i);
    }

    public String getNombre() {

        return nombre;
    }

    public ArrayList<Pokemon> getEquipo() {

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

        equipo.remove(pokemon);
        caja.add(pokemon);
        contadorEquipo--;

    }

    public void moverAEquipo(Pokemon pokemon) {

        if (contadorEquipo < 4) {

            caja.remove(pokemon);

            equipo.add(pokemon);

            contadorEquipo++;
        }

        else {
            System.out.println("No tienes espacio en el equipo");
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

    public void ganarDinero() {

        this.dinero = this.dinero + 100;
    }

    public void setCaja(ArrayList<Pokemon> caja) {
        this.caja = caja;
    }

    public void setEquipo(ArrayList<Pokemon> equipo) {
        this.equipo = equipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void añadirPokemon(Pokemon pokemon) {

        if (contadorEquipo < 4) {

            equipo.add(pokemon);
        }

    }

    public boolean capturar(Pokemon pokemonCapturar) {

        boolean captura = false;
        int i;

        i = (int) Math.random() * 3;

        if (i < 3) {

            caja.add(pokemonCapturar);
            System.out.println("Lo has capturado");
            captura = true;
        }

        numeroPokeBalls--;

        if (numeroPokeBalls == 0) {
            System.out.println("No tienes pokeballs");
            captura = false;

        }

        return captura;
    }

    public void curarEquipo() {

        for (int i = 0; i < 4; i++) {

            this.equipo.get(i).curar();
        }
    }

    public void crearEquipoRival(ArrayList<Movimiento> bMovimientos, ArrayList<Pokemon> bPokemon, Entrenador rival) {

        for (int i = 0; i < 4; i++) {

            int numPokemon = random.nextInt(29);

            Pokemon pokemon = bPokemon.get(numPokemon);

            pokemon.aprender4Movimientos(bMovimientos);

            pokemon.subirNivelRival(this.sacarPokemon(1).getNivel());

            rival.añadirPokemon(pokemon);
        }
    }

}
