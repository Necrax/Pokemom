package pokemon;

public class MovimientoEstado extends Movimiento {

    private EnumEstados estadoMovimiento;
    private int turnos;

    MovimientoEstado(String nombreParam, EnumEstados estadoMovimientoParam, int turnosParam) {
        super(nombreParam);

        this.estadoMovimiento = estadoMovimientoParam;
        this.turnos = turnosParam;
        setCosteEstamina(turnos * 10);
    }

    public EnumEstados getEstadoMovimiento() {
        return estadoMovimiento;
    }

    public int getTurnos() {
        return turnos;
    }

    @Override
    public int getCosteEstamina() {
        return super.getCosteEstamina();
    }

    @Override
    public void setCosteEstamina(int costeEstamina) {
        super.setCosteEstamina(costeEstamina);
    }

    public void setEstadoMovimiento(EnumEstados estadoMovimiento) {
        this.estadoMovimiento = estadoMovimiento;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    @Override
    public void usarMovimiento(Pokemon pokemon1, Pokemon pokemon2) {

        pokemon2.setEstado(estadoMovimiento);
    }

}
