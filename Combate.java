import pokemon.Entrenador;

public class Combate {

    private int turnos;
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int entrenador1KO;
    private int entrenador2KO;
    private Entrenador ganador;

    Combate(Entrenador entrandor1param, Entrenador entrenador2param) {

        this.entrenador1 = entrandor1param;
        this.entrenador2 = entrenador2param;

    }

    public void compararKO() {

        if (entrenador1KO == 4) {

            ganador = entrenador1;
        }

        else if (entrenador2KO == 4) {

            ganador = entrenador2;
        }
    }

    public Entrenador getEntrenador1() {
        return entrenador1;
    }

    public Entrenador getEntrenado2() {
        return entrenador2;
    }

    public void setEntrenador1(Entrenador entrenador1) {
        this.entrenador1 = entrenador1;
    }

    public void setEntrenado2(Entrenador entrenado2) {
        this.entrenador2 = entrenado2;
    }

    public int getEntrenador1KO() {
        return entrenador1KO;
    }

    public void setEntrenador1KO(int entrenador1ko) {
        entrenador1KO = entrenador1ko;
    }

    public int getEntrenador2KO() {
        return entrenador2KO;
    }

    public void setEntrenador2KO(int entrenador2ko) {
        entrenador2KO = entrenador2ko;
    }

    public Entrenador getGanador() {
        return ganador;
    }

    public void setGanador(Entrenador ganador) {
        this.ganador = ganador;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public void retirada() {

        ganador = this.entrenador2;
        entrenador2.setDinero(entrenador2.getDinero() + (entrenador1.getDinero() / 3));
    }
}
