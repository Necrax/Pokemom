package pokemon;

public class MovimientoAtaque extends Movimiento {

    private int potencia;
    private EnumTipos elementoMovimiento;

    MovimientoAtaque(int potenciaParam, EnumTipos elementoMovimientoParam) {
        super();

        this.elementoMovimiento = elementoMovimientoParam;
        this.potencia = potenciaParam;

        setCosteEstamina(potencia / 2);

    }

    public int getPotencia() {
        return potencia;
    }

    public EnumTipos getElementoMovimiento() {
        return elementoMovimiento;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public void setElementoMovimiento(EnumTipos elementoMovimiento) {
        this.elementoMovimiento = elementoMovimiento;
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

}
