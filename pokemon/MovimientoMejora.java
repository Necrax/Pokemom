package pokemon;

public class MovimientoMejora extends Movimiento {

    private EnumCarac mejora;
    private int turnos;
    private int cantidadMejora;

    MovimientoMejora(int turnosParam,
            EnumCarac mejoraParam, int cantidadMejoraParam, String nombreParam) {
        super(nombreParam);

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

    @Override
    public void usarMovimiento(Pokemon pokemon1, Pokemon pokemon2) {

        EnumCarac carac = mejora;

        if (carac == EnumCarac.ATAQUE) {

            pokemon1.setAtaque(cantidadMejora + pokemon1.getAtaque());
        }

        else if (carac == EnumCarac.ATAQUEX) {

            pokemon1.setAtaqueEspecial(cantidadMejora + pokemon1.getAtaqueEspecial());
        }

        else if (carac == EnumCarac.DEFENSA) {

            pokemon1.setDefensa(cantidadMejora + pokemon1.getDefensa());
        }

        else if (carac == EnumCarac.DEFENSAX) {

            pokemon1.setDefensaEspecial(cantidadMejora + pokemon1.getDefensaEspecial());
        }

        else if (carac == EnumCarac.ESTAMINA) {

            pokemon1.setEstamina(cantidadMejora + pokemon1.getEstamina());

        }

        else if (carac == EnumCarac.VELOCIDAD) {

            pokemon1.setVelocidad((cantidadMejora + pokemon1.getVelocidad()));
        }

        else {

            pokemon1.setVitalidad(cantidadMejora + pokemon1.getVitalidad());
        }

    }

}
