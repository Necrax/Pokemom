package pokemon;

public abstract class Movimiento {

    private EnumMovimiento tipoMovimiento;
    private int costeEstamina;
    private String nombre;

    Movimiento(String nombreParam) {

        this.nombre = nombreParam;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCosteEstamina() {
        return costeEstamina;
    }

    public void setCosteEstamina(int costeEstamina) {
        this.costeEstamina = costeEstamina;
    }

    public EnumMovimiento getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(EnumMovimiento tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void usarMovimiento(Pokemon pokemon1, Pokemon pokemon2);

    public EnumTabla comparar(EnumTipos tipo1, EnumTipos tipo2) {
        EnumTabla comparacion = EnumTabla.NEUTRO;

        if (tipo1 == tipo2) {

            comparacion = EnumTabla.NEUTRO;
        }

        else if (tipo1 == EnumTipos.AGUA && tipo2 == EnumTipos.FUEGO) {

            comparacion = EnumTabla.VENTAJA;

        }

        else if (tipo1 == EnumTipos.FUEGO && tipo2 == EnumTipos.AGUA) {

            comparacion = EnumTabla.DESVENTAJA;
        }

        else if (tipo1 == EnumTipos.FUEGO && tipo2 == EnumTipos.PLANTA) {

            comparacion = EnumTabla.VENTAJA;
        }

        else if (tipo1 == EnumTipos.PLANTA && tipo2 == EnumTipos.FUEGO) {

            comparacion = EnumTabla.DESVENTAJA;
        }

        else if (tipo1 == EnumTipos.AGUA && tipo2 == EnumTipos.PLANTA) {

            comparacion = EnumTabla.DESVENTAJA;
        }

        else if (tipo1 == EnumTipos.PLANTA && tipo2 == EnumTipos.AGUA) {

            comparacion = EnumTabla.VENTAJA;
        }

        else if (tipo1 == EnumTipos.ELECTRICO && tipo2 == EnumTipos.AGUA) {

            comparacion = EnumTabla.VENTAJA;
        }

        else if (tipo1 == EnumTipos.AGUA && tipo2 == EnumTipos.ELECTRICO) {

            comparacion = EnumTabla.DESVENTAJA;
        }

        else if (tipo1 == EnumTipos.VOLADOR && tipo2 == EnumTipos.PLANTA) {

            comparacion = EnumTabla.VENTAJA;
        }

        else if (tipo1 == EnumTipos.PLANTA && tipo2 == EnumTipos.VOLADOR) {

            comparacion = EnumTabla.DESVENTAJA;
        }

        else if (tipo1 == EnumTipos.VOLADOR && tipo2 == EnumTipos.ELECTRICO) {

            comparacion = EnumTabla.DESVENTAJA;
        }

        else if (tipo1 == EnumTipos.ELECTRICO && tipo2 == EnumTipos.VOLADOR) {

            comparacion = EnumTabla.VENTAJA;
        }

        else {

            comparacion = EnumTabla.NEUTRO;
        }

        return comparacion;
    }
}
