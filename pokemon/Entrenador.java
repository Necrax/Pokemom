package pokemon;
import java.util.ArrayList;
import java.util.Random;

public class Entrenador {
    private String nombre;
    private Pokemon[] equipo = new Pokemon[4];
    private ArrayList<Pokemon> caja = new ArrayList<Pokemon>();
    private int dinero;

    Random r = new Random();

    Entrenador(String nombre, Pokemon pokemonInicial){
        this.nombre = nombre;
        this.equipo[0] = pokemonInicial;
        this.dinero = r.nextInt(800, 1000);
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

    public void moverACaja(Pokemon pokemon){
        for(int i = 0; i < equipo.length; i++){
            if(equipo[i] == pokemon){
                caja.add(pokemon);
                equipo[i] = null;
                System.out.println("El pokemon se ha movido correctamente");
                break;
            }
            else if(equipo[i] != pokemon){
                System.out.println("No tienes ese pokemon en su equipo");
            }
        }
    }
    public void moverAEquipo(Pokemon pokemon){
        for(int i = 0; i < caja.size(); i++){
            if(caja.get(i) == pokemon){
                caja.remove(pokemon);
                for(int j = 0; j < equipo.length; j++){
                    if(equipo[j] == null){
                        equipo[j] = pokemon;
                        System.out.println("El pokemon se añadio al equipo");
                        break;
                    }
                    else{
                        System.out.println("No tienes espacio en el equipo");
                    }
                }
            }
            else{
                System.out.println("No tienes ese pokemon en la caja");
            }
        }
    }
    public void entrePesado(Pokemon pokemon){
        dinero = dinero - 20 * pokemon.nivel; 
        for(int i = 0; i < equipo.length; i++){
            if(equipo[i] == pokemon){
                pokemon.defensa = pokemon.defensa + 5;
                pokemon.defensaEspecial = pokemon.defensaEspecial + 5;
                pokemon.vitalidad = pokemon.vitalidad + 5;
                break;
            }
            else if(equipo[i] != pokemon){
                System.out.println("No tienes ese pokemon en su equipo");
            }
        }
    }
    public void entreFurioso(Pokemon pokemon){
        dinero = dinero - 30 * pokemon.nivel; 
        for(int i = 0; i < equipo.length; i++){
            if(equipo[i] == pokemon){
                pokemon.ataque = pokemon.ataque + 5;
                pokemon.ataqueEspecial = pokemon.ataqueEspecial + 5;
                pokemon.velocidad = pokemon.velocidad + 5;
                break;
            }
            else if(equipo[i] != pokemon){
                System.out.println("No tienes ese pokemon en su equipo");
            }
        }
    }
    public void entreFuncional(Pokemon pokemon){
        dinero = dinero - 40 * pokemon.nivel; 
        for(int i = 0; i < equipo.length; i++){
            if(equipo[i] == pokemon){
                pokemon.defensa = pokemon.defensa + 5;
                pokemon.ataque = pokemon.defensaEspecial + 5;
                pokemon.velocidad = pokemon.velocidad + 5;
                pokemon.vitalidad = pokemon.vitalidad + 5;
                break;
            }
            else if(equipo[i] != pokemon){
                System.out.println("No tienes ese pokemon en su equipo");
            }
        }
    }
    public void entreOnirico(Pokemon pokemon){
        dinero = dinero - 40 * pokemon.nivel; 
        for(int i = 0; i < equipo.length; i++){
            if(equipo[i] == pokemon){
                pokemon.velocidad = pokemon.velocidad + 5;
                pokemon.defensaEspecial = pokemon.defensaEspecial + 5;
                pokemon.vitalidad = pokemon.vitalidad+ 5;
                pokemon.ataqueEspecial = pokemon.ataqueEspecial +5;
                break;
            }
            else if(equipo[i] != pokemon){
                System.out.println("No tienes ese pokemon en su equipo");
            }
        }
    }
    public void mostrarEquipo(){
        for(int i = 0; i < equipo.length; i++){
            if(equipo[i] != null)
                System.out.println(equipo[i].nombre);
        }
    }
    public void mostrarCaja(){
        for(int i = 0; i < caja.size(); i++){
            System.out.println(caja.get(i).nombre);
        }
    }
}
