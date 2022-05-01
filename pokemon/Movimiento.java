package pokemon;

public class Movimiento {

    private EnumMovimiento tipoMovimiento;
    private int potencia;
    private EnumTipos elementoMovimiento;
    private EnumEstados estadoMoviento;
    private int turnos;
    private EnumCarac mejora;
    private int cantidadMejora;
    private int costeEstamina;

    Movimiento(EnumMovimiento tipoMovimientoParam, int potenciaParam, EnumTipos elementoMovimientoParam,
            EnumEstados estadoMovimientoParam, int turnosParam, EnumCarac mejoraParam,
            int cantidadMejoraParam, int costeEstaminaParam) {

        this.tipoMovimiento = tipoMovimientoParam;
        this.potencia = potenciaParam;
        this.elementoMovimiento = elementoMovimientoParam;
        this.estadoMoviento = estadoMovimientoParam;
        this.turnos = turnosParam;
        this.mejora = mejoraParam;
        this.cantidadMejora = cantidadMejoraParam;
        this.costeEstamina = costeEstaminaParam;
    }

    public EnumMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public int getPotencia() {
        return potencia;
    }

    public EnumTipos getElementoMovimiento() {
        return elementoMovimiento;
    }

    public EnumEstados getEstadoMoviento() {
        return estadoMoviento;
    }

    public int getTurnos() {
        return turnos;
    }

    public EnumCarac getMejora() {
        return mejora;
    }

    public int getCantidadMejora() {
        return cantidadMejora;
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
