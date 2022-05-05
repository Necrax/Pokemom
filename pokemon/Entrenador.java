package pokemon;

import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.Random;

public class Entrenador {
    private String nombre;
    private Pokemon[] equipo = new Pokemon[4];
    private ArrayList<Pokemon> caja = new ArrayList<Pokemon>();
    private int dinero;
    private int numeroPokeBalls = 4;

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

    public void moverACaja(Pokemon pokemon) {

        for (int i = 0; i < equipo.length; i++) {

            if (equipo[i] == pokemon) {

                caja.add(pokemon);

                equipo[i] = null;

                System.out.println("El pokemon se ha movido correctamente");
                break;

            } else if (equipo[i] != pokemon) {

                System.out.println("No tienes ese pokemon en su equipo");
            }
        }
    }

    public void moverAEquipo(Pokemon pokemon) {

        for (int i = 0; i < caja.size(); i++) {

            if (caja.get(i) == pokemon) {

                caja.remove(pokemon);

                for (int j = 0; j < equipo.length; j++) {

                    if (equipo[j] == null) {

                        equipo[j] = pokemon;

                        System.out.println("El pokemon se añadio al equipo");
                    } else {

                        System.out.println("No tienes espacio en el equipo");
                    }
                }
            } else {
                System.out.println("No tienes ese pokemon en la caja");
            }
        }
    }

    public void entrePesado(Pokemon pokemon) {

        dinero = dinero - 20 * pokemon.getNivel();

        for (int i = 0; i < equipo.length; i++) {

            if (equipo[i] == pokemon) {

                pokemon.setDefensa(pokemon.getDefensa() + 5);

                pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() + 5);

                pokemon.setVitalidad(pokemon.getVitalidad() + 5);

            } else if (equipo[i] != pokemon) {

                System.out.println("No tienes ese pokemon en su equipo");
            }
        }
    }

    public void entreFurioso(Pokemon pokemon) {

        dinero = dinero - 30 * pokemon.getNivel();

        for (int i = 0; i < equipo.length; i++) {

            if (equipo[i] == pokemon) {

                pokemon.setAtaque(pokemon.getAtaque() + 5);

                pokemon.setAtaqueEspecial(pokemon.getAtaqueEspecial() + 5);

                pokemon.setVelocidad(pokemon.getVelocidad() + 5);

            } else if (equipo[i] != pokemon) {

                System.out.println("No tienes ese pokemon en su equipo");
            }
        }
    }

    public void entreFuncional(Pokemon pokemon) {

        dinero = dinero - 40 * pokemon.getNivel();

        for (int i = 0; i < equipo.length; i++) {

            if (equipo[i] == pokemon) {

                pokemon.setDefensa(pokemon.getDefensa() + 5);

                pokemon.setAtaque(pokemon.getDefensaEspecial() + 5);

                pokemon.setVelocidad(pokemon.getVelocidad() + 5);

                pokemon.setVitalidad(pokemon.getVitalidad() + 5);

            } else if (equipo[i] != pokemon) {

                System.out.println("No tienes ese pokemon en su equipo");
            }
        }
    }

    public void entreOnirico(Pokemon pokemon) {

        dinero = dinero - 40 * pokemon.getNivel();

        for (int i = 0; i < equipo.length; i++) {

            if (equipo[i] == pokemon) {

                pokemon.setVelocidad(pokemon.getVelocidad() + 5);
                pokemon.setDefensaEspecial(pokemon.getDefensaEspecial() + 5);
                pokemon.setVitalidad(pokemon.getVitalidad() + 5);
                pokemon.setAtaqueEspecial(pokemon.getAtaqueEspecial() + 5);

            } else if (equipo[i] != pokemon) {

                System.out.println("No tienes ese pokemon en su equipo");
            }
        }
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

    public void capturar() {

        boolean captura = false;

        while (numeroPokeBalls > 0 && captura == false) {

            Pokemon pokemon; // TODO bBDD.get(e)

            int i = (int) Math.random() * 3;

            if (i < 3) {

                // TODO caja.add(pokemon);
            }

            numeroPokeBalls--;
        }
    }
}
