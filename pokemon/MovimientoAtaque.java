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
        int potenciaTotal = 0;
        EnumTabla comparacion = EnumTabla.NEUTRO;

        if (elementoMovimiento == pokemon1.getTipo()) {
            
            if(comparar(elementoMovimiento, pokemon2.getTipo()) == EnumTabla.VENTAJA){

                potenciaTotal = (int) 0.01 * (int) 1.5 * (int) 1.5 * (int) (85 + Math.random() * 100) * (((int) 0.2 * (int) pokemon1.getNivel() + 1) * pokemon1.getAtaque() * this.potencia / 25 * pokemon2.getDefensa());
            }

            else if(comparar(elementoMovimiento, pokemon2.getTipo()) == EnumTabla.DESVENTAJA){

                potenciaTotal = (int) 0.01 * (int) 1.5 * (int) 0.75 * (int) (85 + Math.random() * 100) * (((int) 0.2 * (int) pokemon1.getNivel() + 1) * pokemon1.getAtaque() * this.potencia / 25 * pokemon2.getDefensa());
            }

            else if(comparar(elementoMovimiento, pokemon2.getTipo()) == EnumTabla.NEUTRO){

                potenciaTotal = (int) 0.01 * (int) 1.5 * (int) 1 * (int) (85 + Math.random() * 100) * (((int) 0.2 * (int) pokemon1.getNivel() + 1) * pokemon1.getAtaque() * this.potencia / 25 * pokemon2.getDefensa());
            }

        }

        else if (elementoMovimiento != pokemon1.getTipo()) {

            if(comparar(elementoMovimiento, pokemon2.getTipo()) == EnumTabla.VENTAJA){

                potenciaTotal = (int) 0.01 * (int) 1 * (int) 1.5 * (int) (85 + Math.random() * 100) * (((int) 0.2 * (int) pokemon1.getNivel() + 1) * pokemon1.getAtaque() * this.potencia / 25 * pokemon2.getDefensa());
            }

            else if(comparar(elementoMovimiento, pokemon2.getTipo()) == EnumTabla.DESVENTAJA){

                potenciaTotal = (int) 0.01 * (int) 1 * (int) 0.75 * (int) (85 + Math.random() * 100) * (((int) 0.2 * (int) pokemon1.getNivel() + 1) * pokemon1.getAtaque() * this.potencia / 25 * pokemon2.getDefensa());
            }

            else if(comparar(elementoMovimiento, pokemon2.getTipo()) == EnumTabla.NEUTRO){

                potenciaTotal = (int) 0.01 * (int) 1 * (int) 1 * (int) (85 + Math.random() * 100) * (((int) 0.2 * (int) pokemon1.getNivel() + 1) * pokemon1.getAtaque() * this.potencia / 25 * pokemon2.getDefensa());
            }

        }

        pokemon1.setEstamina(pokemon1.getEstamina() - this.getCosteEstamina());

        pokemon2.setVitalidad(pokemon2.getVitalidad() - potenciaTotal);
    }

}
