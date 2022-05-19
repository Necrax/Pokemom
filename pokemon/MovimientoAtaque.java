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
        return super.getNombre();
    }

    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public EnumMovimiento getTipoMovimiento() {
        return super.getTipoMovimiento();
    }

    @Override
    public void setTipoMovimiento(EnumMovimiento tipoMovimiento) {
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
        return super.getCosteEstamina();
    }

    @Override
    public void setCosteEstamina(int costeEstamina) {
        super.setCosteEstamina(costeEstamina);
    }

    @Override
    public EnumTabla comparar(EnumTipos tipo1, EnumTipos tipo2) {
        return super.comparar(tipo1, tipo2);
    }

    @Override
    public void usarMovimiento(Pokemon pokemon1, Pokemon pokemon2) {
        float potenciaTotal = 0;
        EnumTabla comparacion = comparar(elementoMovimiento, pokemon2.getTipo());

        if (elementoMovimiento == pokemon1.getTipo()) {

            if (comparacion == EnumTabla.VENTAJA) {

                potenciaTotal = (float) (1.5 * 1.5 * (85 + Math.random() * 100)
                        * ((0.2 * pokemon1.getNivel() + 1) * pokemon1.getAtaque() * getPotencia() / 25
                                * pokemon2.getDefensa()));
            }

            else if (comparacion == EnumTabla.DESVENTAJA) {

                potenciaTotal = (float) (1.5 * 0.5 * (85 + Math.random() * 100)
                        * ((0.2 * pokemon1.getNivel() + 1) * pokemon1.getAtaque() * getPotencia() / 25
                                * pokemon2.getDefensa()));
            }

            else if (comparacion == EnumTabla.NEUTRO) {

                potenciaTotal = (float) (1.5 * (85 + Math.random() * 100)
                        * ((0.2 * pokemon1.getNivel() + 1) * pokemon1.getAtaque() * getPotencia() / 25
                                * pokemon2.getDefensa()));
            }

        }

        else if (elementoMovimiento != pokemon1.getTipo()) {

            if (comparacion == EnumTabla.VENTAJA) {

                potenciaTotal = (float) (1.5 * (85 + Math.random() * 100)
                        * ((0.2 * pokemon1.getNivel() + 1) * pokemon1.getAtaque() * getPotencia() / 25
                                * pokemon2.getDefensa()));
            }

            else if (comparacion == EnumTabla.DESVENTAJA) {

                potenciaTotal = (float) (0.5 * (int) 0.75 * (85 + Math.random() * 100)
                        * ((0.2 * pokemon1.getNivel() + 1) * pokemon1.getAtaque() * getPotencia() / 25
                                * pokemon2.getDefensa()));
            }

            else if (comparacion == EnumTabla.NEUTRO) {

                potenciaTotal = (float) (0.01 * 1 * 1 * (85 + Math.random() * 100)
                        * ((0.2 * pokemon1.getNivel() + 1) * pokemon1.getAtaque() * getPotencia() / 25
                                * pokemon2.getDefensa()));
            }

        }

        pokemon1.setEstamina(pokemon1.getEstamina() - this.getCosteEstamina());

        pokemon2.setVitalidad((int) ((float) pokemon2.getVitalidad() - potenciaTotal));
    }

}
