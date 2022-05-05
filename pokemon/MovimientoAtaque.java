package pokemon;

public class MovimientoAtaque extends Movimiento {

    private int potencia;
    private EnumTipos elementoMovimiento;

    MovimientoAtaque(int potenciaParam, EnumTipos elementoMovimientoParam, String nombreParam) {
        super(nombreParam);

        this.elementoMovimiento = elementoMovimientoParam;
        this.potencia = potenciaParam;

        setCosteEstamina(potencia / 2);

    }

    @Override
    public String getNombre() {
        // TODO Auto-generated method stub
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        // TODO Auto-generated method stub
        super.setNombre(nombre);
    }

    @Override
    public EnumMovimiento getTipoMovimiento() {
        // TODO Auto-generated method stub
        return super.getTipoMovimiento();
    }

    @Override
    public void setTipoMovimiento(EnumMovimiento tipoMovimiento) {
        // TODO Auto-generated method stub
        super.setTipoMovimiento(tipoMovimiento);
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

    @Override
    public EnumTabla comparar(EnumTipos tipo1, EnumTipos tipo2) {
        // TODO Auto-generated method stub
        return super.comparar(tipo1, tipo2);
    }

    @Override
    public void usarMovimiento(Pokemon pokemon1, Pokemon pokemon2) {
        // TODO Auto-generated method stub
        int potenciaTotal = 0;
        EnumTabla comparacion = EnumTabla.NEUTRO;

        if (elementoMovimiento == pokemon1.getTipo()) {

            potenciaTotal = (int) (pokemon1.getAtaque() * 1.5 * potencia - pokemon2.getDefensa());
        }

        else if (elementoMovimiento != pokemon1.getTipo()) {

            potenciaTotal = pokemon1.getAtaque() * potencia - pokemon2.getDefensa();
        }

        comparacion = comparar(elementoMovimiento, pokemon1.getTipo());

        if (comparacion == EnumTabla.VENTAJA) {

            potenciaTotal = potenciaTotal * 2;
        }

        else if (comparacion == EnumTabla.DESVENTAJA) {

            potenciaTotal = (int) (pokemon1.getAtaque() * 0.5 * potencia - pokemon2.getDefensa());
        }

        pokemon1.setEstamina(pokemon1.getEstamina() - this.getCosteEstamina());

        pokemon2.setVitalidad(pokemon2.getVitalidad() - potenciaTotal);
    }

}
