package pokemon;

public class Main {
    public static void main(String[] args) {

        Pokemon pokemon = new Pokemon("u", "e", 100,
                20, 30, 20, 10,
                5, 100, EnumTipos.FUEGO);

        Pokemon pokemon2 = new Pokemon("e", "p", 200, 10, 20,
                50, 50, 10, 100, EnumTipos.AGUA);

        Entrenador entrenador = new Entrenador("j", pokemon);

        MovimientoAtaque movimientoAtaque = new MovimientoAtaque(40, EnumTipos.FUEGO, "Fuego");
        MovimientoAtaque movimientoAtaque2 = new MovimientoAtaque(50, EnumTipos.AGUA, "Agua");
        MovimientoEstado movimientoEstado = new MovimientoEstado("Y", EnumEstados.DORMIDO, 3);
        MovimientoMejora movimientoMejora = new MovimientoMejora(3, EnumCarac.ATAQUE, 10, "mejora");

        System.out.println(pokemon);
        System.out.println(pokemon2);

        entrenador.entreFuncional(pokemon);

        pokemon.atacar(movimientoAtaque, pokemon2);
        pokemon.atacar(movimientoEstado, pokemon2);
        pokemon2.atacar(movimientoEstado, pokemon);
        pokemon.atacar(movimientoMejora, pokemon);

        System.out.println(pokemon);
        System.out.println(pokemon2);

        Combate combate = new Combate(entrenador);

        combate.guardarTurno(1, movimientoAtaque, movimientoAtaque2, pokemon, pokemon2);

        System.out.println(combate.mostrarTurno(1));
    }

}
