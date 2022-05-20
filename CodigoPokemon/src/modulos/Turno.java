
public class Turno {

    private int turno;
    private Movimiento movimientoEntrenador1;
    private Movimiento movimientoEntrenador2;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private String turnoEscrito;

    public Turno(int turnoParam, Movimiento movimientoEntrenador1Param, Movimiento movimientoEntrenador2Param,
            Pokemon pokemon1Param, Pokemon pokemon2Param) {

        this.movimientoEntrenador1 = movimientoEntrenador1Param;
        this.movimientoEntrenador2 = movimientoEntrenador2Param;
        this.pokemon1 = pokemon1Param;
        this.pokemon2 = pokemon2Param;
        this.turno = turnoParam;

        turnoEscrito = "Turno: " + getTurno() + "\n" + pokemon1.getNombre() + " usó: " +
                movimientoEntrenador1.getNombre() + "\n" + pokemon2.getNombre() + " usó: "
                + movimientoEntrenador2.getNombre();

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

    public Pokemon getPokemon1() {
        return pokemon1;
    }

    public Pokemon getPokemon2() {
        return pokemon2;
    }

    public String getTurnoEscrito() {
        return turnoEscrito;
    }

    public void setPokemon1(Pokemon pokemon1) {
        this.pokemon1 = pokemon1;
    }

    public void setPokemon2(Pokemon pokemon2) {
        this.pokemon2 = pokemon2;
    }

    public void setTurnoEscrito(String turnoEscrito) {
        this.turnoEscrito = turnoEscrito;
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
        // TODO Auto-generated method stub
        return getTurnoEscrito();
    }
}
