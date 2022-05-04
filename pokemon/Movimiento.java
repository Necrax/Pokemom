package pokemon;

public class Movimiento {

    private EnumMovimiento tipoMovimiento;
    private int costeEstamina;

    Movimiento(EnumMovimiento tipoMovimientoParam, int costeEstaminaParam) {

        this.tipoMovimiento = tipoMovimientoParam;
        this.costeEstamina = costeEstaminaParam;
    }

    public EnumMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public int getCosteEstamina() {
        return costeEstamina;
    }

    public void setTipoMovimiento(EnumMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setElementoMovimiento(EnumTipos elementoMovimiento) {
        this.elementoMovimiento = elementoMovimiento;
    }

    public void setEstadoMoviento(EnumEstados estadoMoviento) {
        this.estadoMoviento = estadoMoviento;
    }

    public void setTurnos(int turnos) {
        this.turnos = turnos;
    }

    public void setMejora(EnumCarac mejora) {
        this.mejora = mejora;
    }

    public void setCantidadMejora(int cantidadMejora) {
        this.cantidadMejora = cantidadMejora;
    }

    public void setCosteEstamina(int costeEstamina) {
        this.costeEstamina = costeEstamina;
    }

    public void usarMovimiento() {

    }
}
