
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.sql.*;


public class MainCodigo {
    public static void main(String[] args) throws Exception {
        int opcion = 0;
        Scanner sc = new Scanner(System.in);
        ArrayList<Pokemon> bBDDPokemon = new ArrayList<Pokemon>();
        ArrayList<Movimiento> bBDDMovimientos = new ArrayList<Movimiento>();
        Random random = new Random();

        String login = "root";
        String url = "jdbc:mysql://localhost:3306/pokemon";
        String password = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, login, password);

            System.out.println("Conexion ok");

            System.arraycopy(crearPokemon(connection), 0, bBDDPokemon, 0, crearPokemon(connection).size() - 1);
            System.arraycopy(crearMovimiento(connection), 0, bBDDMovimientos, 0, crearPokemon(connection).size() - 1);

        } catch (SQLException sqle) {

            sqle.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

        }
        Pokemon pokemonCombate1 = new Pokemon("j", "h", 0, 0, 0, 0, 0, 0, 0, EnumTipos.AGUA);
        Pokemon pokemonCombate2 = new Pokemon("j", "h", 0, 0, 0, 0, 0, 0, 0, EnumTipos.AGUA);
        Pokemon pokemonCapturar = new Pokemon("j", "h", 0, 0, 0, 0, 0, 0, 0, EnumTipos.AGUA);
        Entrenador entrenador1 = new Entrenador("Jugador");

        entrenador1.añadirPokemon(bBDDPokemon.get(0));
        entrenador1.añadirPokemon(bBDDPokemon.get(3));
        entrenador1.añadirPokemon(bBDDPokemon.get(0));

        while (opcion != 4) {
            System.out.println("1.Combate\n2.Capturar\n3.PC Pokemon\n4.Salir");

            opcion = sc.nextInt();
            int tuPokemon = 1;
            int suPokemon = 1;

            switch (opcion) {

                case 1: {

                    int numeroTurno = 1;
                    Entrenador rival = new Entrenador("Rival");
                    Combate combate = new Combate(entrenador1, rival);

                    entrenador1.crearEquipoRival(bBDDMovimientos, bBDDPokemon, rival);

                    System.out.println("Has elegido a " + entrenador1.getEquipo().get(tuPokemon).getNombre());
                    System.out.println("Ha elegido a " + rival.getEquipo().get(suPokemon).getNombre());
                    pokemonCombate1 = entrenador1.sacarPokemon(tuPokemon);
                    pokemonCombate2 = rival.sacarPokemon(suPokemon);

                    while (combate.getGanador() != entrenador1 && combate.getGanador() != rival) {

                        if (pokemonCombate1.getVitalidad() == 0) {
                            tuPokemon++;
                            pokemonCombate1 = entrenador1.sacarPokemon(tuPokemon);
                            System.out.println("Has elegido a " + entrenador1.sacarPokemon(tuPokemon));
                        }

                        else if (pokemonCombate2.getVitalidad() == 0) {
                            suPokemon++;
                            pokemonCombate2 = rival.sacarPokemon(suPokemon);
                            System.out.println("Ha elegido a " + rival.sacarPokemon(suPokemon));
                        }

                        int contarMov = 0;
                        for (Movimiento movimiento : pokemonCombate1.getMovimientos()) {

                            System.out.println(contarMov + ". " + movimiento.getNombre());
                        }

                        int ataque = sc.nextInt();
                        int ataqueEnemigo = random.nextInt(4);

                        if (pokemonCombate1.getVelocidad() >= pokemonCombate2.getVelocidad()) {

                            pokemonCombate1.atacar(pokemonCombate1.elegirMovimiento(ataque), pokemonCombate2);
                            pokemonCombate2.atacar(pokemonCombate2.elegirMovimiento(ataqueEnemigo), pokemonCombate1);

                        } else if (pokemonCombate1.getVelocidad() < pokemonCombate2.getVelocidad()) {

                            pokemonCombate2.atacar(pokemonCombate2.elegirMovimiento(ataqueEnemigo), pokemonCombate1);
                            pokemonCombate1.atacar(pokemonCombate1.elegirMovimiento(ataque), pokemonCombate2);

                        }

                        combate.guardarTurno(numeroTurno, pokemonCombate1.elegirMovimiento(ataque),
                                pokemonCombate2.elegirMovimiento(ataqueEnemigo), pokemonCombate1,
                                pokemonCombate2);
                        System.out.println(combate.mostrarTurno(numeroTurno));
                        System.out.println(pokemonCombate1);
                        System.out.println(pokemonCombate2);
                        numeroTurno++;

                        combate.compararKO();
                        pokemonCombate1.ganarExperiencia(pokemonCombate2, bBDDMovimientos);
                        entrenador1.getEquipo().set(tuPokemon, pokemonCombate1);

                    }

                    System.out.println("Ha ganado " + combate.getGanador());
                    combate.escribirCombate();
                    entrenador1.curarEquipo();

                    break;
                }

                case 2: {
                    Boolean captura = false;
                    pokemonCapturar = bBDDPokemon.get((int) Math.random() * (bBDDPokemon.size() - 1));
                    System.out.println("Ha aparecido un " + pokemonCapturar.getNombre());

                    while (entrenador1.getNumeroPokeBalls() > 0) {

                        if (captura == false) {
                            System.out.println("Pulsa c para capturar");

                            String capturar = sc.next();

                            switch (capturar) {

                                case "c":
                                    captura = entrenador1.capturar(pokemonCapturar);
                                    break;
                            }
                        } else {
                            break;
                        }
                    }

                }

                case 3: {
                    System.out.println("1.Equipo\n2.Mochila");
                    int pc = sc.nextInt();
                    int posicion = 1;

                    switch (pc) {

                        case 1: {

                            int eleccionPokemon = 0;

                            for (Pokemon pokemon : entrenador1.getEquipo()) {

                                System.out.println(posicion + "." + pokemon.getNombre());
                                posicion++;
                            }

                            System.out.println("Selecciona un pokemon");

                            eleccionPokemon = sc.nextInt();

                            System.out.println("1.Mover a caja\n2.Entrenar");

                            int entrenarOmover = sc.nextInt();

                            switch (entrenarOmover) {

                                case 1: {

                                    entrenador1.moverACaja(entrenador1.sacarPokemon(eleccionPokemon));

                                    break;

                                }

                                case 2: {

                                    System.out.println(
                                            "1.Entrenamiento Pesado\n2.Entrenamiento Furioso\n3.Entrenamiento Funcional\n4.Entrenamiento Onirico");

                                    int entreamiento = sc.nextInt();

                                    switch (entreamiento) {

                                        case 1: {

                                            entrenador1.entrePesado(entrenador1.sacarPokemon(eleccionPokemon));

                                            break;
                                        }

                                        case 2: {

                                            entrenador1.entreFurioso(entrenador1.sacarPokemon(eleccionPokemon));

                                            break;
                                        }

                                        case 3: {

                                            entrenador1.entreFuncional(entrenador1.sacarPokemon(eleccionPokemon));

                                            break;
                                        }

                                        case 4: {

                                            entrenador1.entreOnirico(entrenador1.sacarPokemon(eleccionPokemon));

                                            break;
                                        }

                                    }

                                    break;
                                }
                            }

                            break;
                        }

                        case 2: {

                            for (Pokemon pokemon : entrenador1.getCaja()) {

                                System.out.println(posicion + "." + pokemon.getNombre());
                                posicion++;
                            }

                            System.out.println("Elige un pokemon para moverlo al equipo");

                            int eleccionPokemon = sc.nextInt();

                            entrenador1.moverAEquipo(entrenador1.getCaja().get(eleccionPokemon));

                            if (entrenador1.getContadorEquipo() >= 4) {

                                for (Pokemon pokemon : entrenador1.getEquipo()) {

                                    System.out.println(posicion + "." + pokemon.getNombre());
                                    posicion++;
                                }

                                System.out.println("Elige un pokemon para mover a la caja");

                                eleccionPokemon = sc.nextInt();

                            }

                            break;

                        }
                    }
                }

            }
        }

        sc.close();
    }

    public static ArrayList<Pokemon> crearPokemon(Connection connection) throws SQLException {

        String consulta = "SELECT * FROM pokedex";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(consulta);
        ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();

        while (rs.next()) {

            Pokemon a = new Pokemon(rs.getString("NOMBRE"), "", rs.getInt("VITALIDAD"), rs.getInt("ATAQUE"),
                    rs.getInt("DEFENSA"), rs.getInt("ATAQUEX"), rs.getInt("DEFENSAX"),
                    rs.getInt("VELOCIDAD"), rs.getInt("ESTAMINA"), EnumTipos.valueOf(rs.getString("TIPO")));

            pokemon.add(a);
        }

        statement.close();

        return pokemon;
    }

    public static ArrayList<Movimiento> crearMovimiento(Connection connection) throws SQLException {

        ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>();

        String consultaAtaque = "SELECT * FROM movimiento WHERE TIPO_MOV='ATAQUE'";
        String consultaEstado = "SELECT * FROM movimiento WHERE TIPO_MOV='ESTADO'";
        String consultaMejora = "SELECT * FROM movimiento WHERE TIPO_MOV='MEJORA'";

        Statement statement = connection.createStatement();

        ResultSet rs = statement.executeQuery(consultaAtaque);

        while (rs.next()) {

            MovimientoAtaque mov = new MovimientoAtaque(rs.getInt("POTENCIA"),
                    EnumTipos.valueOf(rs.getString("ELEM_MOV")),
                    rs.getString("NOM_MOVIMIENTO"));

            movimientos.add(mov);

        }

        rs = statement.executeQuery(consultaEstado);

        while (rs.next()) {

            MovimientoEstado movE = new MovimientoEstado(rs.getString("NOM_MOVIMIENTO"),
                    EnumEstados.valueOf(rs.getString("ESTADO")), rs.getInt("TURNOS"));

            movimientos.add(movE);
        }

        rs = statement.executeQuery(consultaMejora);

        while (rs.next()) {

            MovimientoMejora movM = new MovimientoMejora(rs.getInt("TURNOS"), EnumCarac.valueOf(rs.getString("MEJORA")),
                    rs.getInt("CANT_MEJORA"), "NOM_MOVIMIENTO");

            movimientos.add(movM);
        }

        statement.close();

        return movimientos;
    }

}
