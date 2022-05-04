package pokemon;

public abstract class Movimiento {

    private EnumMovimiento tipoMovimiento;
    private int costeEstamina;

    Movimiento() {

    }

    public int getCosteEstamina() {
        return costeEstamina;
    }

    public void setCosteEstamina(int costeEstamina) {
        this.costeEstamina = costeEstamina;
    }

    public void usarMovimiento() {

    }
}
