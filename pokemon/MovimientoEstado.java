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
    public String getNombre() {
        // TODO Auto-generated method stub
        return super.getNombre();
    }

    @Override
    public EnumMovimiento getTipoMovimiento() {
        // TODO Auto-generated method stub
        return super.getTipoMovimiento();
    }

    @Override
    public void usarMovimiento(Pokemon pokemon1, Pokemon pokemonRival) {

        pokemonRival.setEstado(this.estadoMovimiento);
        pokemon1.setEstamina(pokemon1.getEstamina() - this.getCosteEstamina());
    }

}
