package pokemon;

public class MovimientoMejora extends Movimiento {

    private EnumCarac mejora;
    private int turnos;
    private int cantidadMejora;

    MovimientoMejora(int costeEstaminaParam, int turnosParam,
            EnumCarac mejoraParam, int cantidadMejoraParam) {
        super();

        this.cantidadMejora = cantidadMejoraParam;
        this.mejora = mejoraParam;
        this.turnos = turnosParam;
        setCosteEstamina(turnos * 10);

    }

    @Override
    public int getCosteEstamina() {
        // TODO Auto-generated method stub
        return super.getCosteEstamina();
    }

    @Override
    public void setCosteEstamina(int costeEstamina) {
        // TODO Auto-generated method stub
        super.setCosteEstamina(costeEstamina);
    }

    public int getCantidadMejora() {
        return cantidadMejora;
    }

    public void setCantidadMejora(int cantidadMejora) {
        this.cantidadMejora = cantidadMejora;
    }

    public EnumCarac getMejora() {
        return mejora;
    }

    public void setMejora(EnumCarac mejora) {
        this.mejora = mejora;
    }

    public int getTurnos() {
        return turnos;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

}
