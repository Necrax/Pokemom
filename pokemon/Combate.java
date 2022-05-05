package pokemon;

import java.util.ArrayList;

public class Combate {

    private int numeroTurno = 1;
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private int entrenador1KO;
    private int entrenador2KO;
    private Entrenador ganador;
    private Movimiento movimientoEntrenador1;
    private Movimiento movimientoEntrenador2;
    private ArrayList<Turno> turnos = new ArrayList<Turno>();
    private Pokemon pokemon1;
    private Pokemon pokemon2;

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

    public ArrayList<Turno> getTurnos() {
        return turnos;
    }

    public Entrenador getEntrenador2() {
        return entrenador2;
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

    public int getTurno() {
        return numeroTurno;
    }

    public void setEntrenador2(Entrenador entrenador2) {
        this.entrenador2 = entrenador2;
    }

    public void setTurnos(ArrayList<Turno> turnos) {
        this.turnos = turnos;
    }

    public void setTurno(int turno) {
        this.numeroTurno = turno;
    }

    public void retirada() {

        ganador = this.entrenador2;
        entrenador2.setDinero(entrenador2.getDinero() + (entrenador1.getDinero() / 3));
    }

    public void guardarTurno() {

        Turno turno = new Turno(numeroTurno, movimientoEntrenador1, movimientoEntrenador2);
        turnos.add(turno);
    }

    public void ganarExperiencia() {

        pokemon1.setExperiencia(pokemon1.getExperiencia() + ((pokemon1.getNivel() + (pokemon2.getNivel() * 10)) / 4));
    }
}
