package pokemon;

public class Turno {

    private int turno;
    private Movimiento movimientoEntrenador1;
    private Movimiento movimientoEntrenador2;

    public Turno(int turnoParam, Movimiento movimientoEntrenador1Param, Movimiento movimientoEntrenador2Param) {

        this.movimientoEntrenador1 = movimientoEntrenador1Param;
        this.movimientoEntrenador2 = movimientoEntrenador2Param;
        this.turno = turnoParam;

    }

    public int getTurno() {
        return turno;
    }

    public Movimiento getMovimientoEntrenador1() {
        return movimientoEntrenador1;
    }

    public Movimiento getMovimientoEntrenador2() {
        return movimientoEntrenador2;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void setMovimientoEntrenador1(Movimiento movimientoEntrenador1) {
        this.movimientoEntrenador1 = movimientoEntrenador1;
    }

    public void setMovimientoEntrenador2(Movimiento movimientoEntrenador2) {
        this.movimientoEntrenador2 = movimientoEntrenador2;
    }

    @Override
    public String toString() {

        return "Turno: " + turno + "\nEntrenador: " + movimientoEntrenador1.getNombre() +
                "\nRival: " + movimientoEntrenador2.getNombre();
    }
}
