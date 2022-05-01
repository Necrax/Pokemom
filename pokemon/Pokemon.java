package pokemon;

import java.util.ArrayList;

public class Pokemon {
    protected String nombre;
    protected String mote;
    protected int vitalidad;
    protected int ataque;
    protected int defensa;
    protected int ataqueEspecial;
    protected int defensaEspecial;
    protected int velocidad;
    protected int estamina;
    protected int nivel = 0;
    private int fertilidad = 5;
    private EnumTipos tipo;
    private EnumEstados estado = EnumEstados.SIN_ESTADO;
    private int experiencia = 0;
    private ArrayList<Movimiento> movimientos = new ArrayList<>(4);
    private int contadorMovimientos;

    Pokemon(String nombreParam, String moteParam, int vitalidadParam, int ataqueParam,
            int defensaParam, int ataqueEspecialParam, int defensaEspecialParam,
            int velocidadParam, int estaminaParam,
            EnumTipos tipoParam) {
        this.nombre = nombreParam;
        this.mote = moteParam;
        this.vitalidad = vitalidadParam;
        this.ataque = ataqueParam;
        this.defensa = defensaParam;
        this.ataqueEspecial = ataqueEspecialParam;
        this.defensaEspecial = defensaEspecialParam;
        this.velocidad = velocidadParam;
        this.estamina = estaminaParam;
        this.tipo = tipoParam;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMote() {
        return mote;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public EnumEstados getEstado() {
        return estado;
    }

    public int getEstamina() {
        return estamina;
    }

    public int getFertilidad() {
        return fertilidad;
    }

    public int getNivel() {
        return nivel;
    }

    public EnumTipos getTipo() {
        return tipo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getVitalidad() {
        return vitalidad;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public ArrayList<Movimiento> getMovimientos() {
        return movimientos;
    }

    public int getContadorMovimientos() {
        return contadorMovimientos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMote(String mote) {
        this.mote = mote;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    public void setAtaqueEspecial(int ataqueEspecial) {
        this.ataqueEspecial = ataqueEspecial;
    }

    public void setDefensaEspecial(int defensaEspecial) {
        this.defensaEspecial = defensaEspecial;
    }

    public void setEstado(EnumEstados estado) {
        this.estado = estado;
    }

    public void setEstamina(int estamina) {
        this.estamina = estamina;
    }

    public void setFertilidad(int fertilidad) {
        this.fertilidad = fertilidad;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setTipo(EnumTipos tipo) {
        this.tipo = tipo;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public void setVitalidad(int vitalidad) {
        this.vitalidad = vitalidad;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public void setMovimientos(Movimiento movimiento) {
        movimientos.add(movimiento);
    }

    public void setContadorMovimientos(int contadorMovimientos) {
        this.contadorMovimientos = contadorMovimientos;
    }

    public void aprenderMOvimiento(Movimiento movimientoAprender) {

        movimientos.add(movimientoAprender);
    }

    public void remplazarMovimiento(Movimiento movimientoOlvidar, Movimiento movimientoAprender) {

        for (int i = 0; i < 3; i++) {
            if (movimientos.get(i) == movimientoOlvidar) {

                movimientos.remove(i);
                movimientos.add(movimientoAprender);
            }
        }

    }

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

    public int atacar(Movimiento movimientoAtaque, Pokemon pokemon) {

        int potenciaTotal = 0;
        EnumTabla comparacion = EnumTabla.NEUTRO;

        if (movimientoAtaque.getElementoMovimiento() == tipo) {

            potenciaTotal = (int) (ataque * 1.5 * movimientoAtaque.getPotencia() - pokemon.getDefensa());
        }

        else if (movimientoAtaque.getElementoMovimiento() != tipo) {

            potenciaTotal = ataque * movimientoAtaque.getPotencia() - pokemon.getDefensa();
        }

        comparacion = comparar(movimientoAtaque.getElementoMovimiento(), pokemon.getTipo());

        if (comparacion == EnumTabla.VENTAJA) {

            potenciaTotal = potenciaTotal * 2;
        }

        else if (comparacion == EnumTabla.DESVENTAJA) {

            potenciaTotal = (int) (ataque * 0.5 * movimientoAtaque.getPotencia() - pokemon.getDefensa());
        }

        setEstamina(estamina - movimientoAtaque.getCosteEstamina());

        return potenciaTotal;
    }

    public void subirNivel() {

        setExperiencia(0);
        setAtaque(getAtaque() + (1 + (int) Math.random() * 5));
        setAtaqueEspecial(getAtaqueEspecial() + (1 + (int) Math.random() * 5));
        setDefensa(getDefensa() + (1 + (int) Math.random() * 5));
        setDefensaEspecial(getDefensaEspecial() + (1 + (int) Math.random() * 5));
        setVitalidad(getVitalidad() + (1 + (int) Math.random() * 5));
        setVelocidad(getVelocidad() + (1 + (int) Math.random() * 5));

        if (nivel % 3 == 0 && contadorMovimientos < 4) {

        }

    }
}
