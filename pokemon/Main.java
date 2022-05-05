package pokemon;

public class Main {
        public static void main(String[] args) {
                Pokemon pokemon1 = new Pokemon("jjj", "kkk", 100, 50,
                                60, 10, 10, 20,
                                50, EnumTipos.FUEGO);

                Pokemon pokemon2 = new Pokemon("u", "i", 200, 10,
                                50, 80, 10, 5,
                                8, EnumTipos.AGUA);

                Entrenador entrenador = new Entrenador("kdkkdkd", pokemon2);

                MovimientoAtaque movimiento = new MovimientoAtaque(10,
                                EnumTipos.FUEGO, "h");

                MovimientoEstado movimiento2 = new MovimientoEstado("j",
                                EnumEstados.DORMIDO, 3);

                MovimientoMejora movimiento3 = new MovimientoMejora(10,
                                EnumCarac.ATAQUE, 10, "t");

                
                System.out.println(pokemon2);
                pokemon1.atacar(movimiento, pokemon2);
                System.out.println(pokemon2);
        
        }
}
