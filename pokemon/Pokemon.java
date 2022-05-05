package pokemon;

import java.util.ArrayList;

public class Pokemon {
    protected String nombre;
    protected String mote;
    protected int vitalidadMax;
    protected int vitalidad;
    protected int ataque;
    protected int defensa;
    protected int ataqueEspecial;
    protected int defensaEspecial;
    protected int velocidad;
    protected int estaminaMax;
    protected int estamina;
    protected int nivel = 0;
    protected int fertilidad = 5;
    protected EnumTipos tipo;
    protected EnumEstados estado = EnumEstados.SIN_ESTADO;
    protected int experiencia = 0;
    protected ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>(4);
    protected int contadorMovimientos;

    Pokemon(String nombreParam, String moteParam, int vitalidadMaxParam, int ataqueParam,
            int defensaParam, int ataqueEspecialParam, int defensaEspecialParam,
            int velocidadParam, int estaminaMaxParam,
            EnumTipos tipoParam) {
        this.nombre = nombreParam;
        this.mote = moteParam;
        this.vitalidadMax = vitalidadMaxParam;
        this.vitalidad = vitalidadMaxParam;
        this.ataque = ataqueParam;
        this.defensa = defensaParam;
        this.ataqueEspecial = ataqueEspecialParam;
        this.defensaEspecial = defensaEspecialParam;
        this.velocidad = velocidadParam;
        this.estaminaMax = estaminaMaxParam;
        this.estamina = estaminaMaxParam;
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

    public void aprenderMovimiento(Movimiento movimientoAprender) {

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

    public Movimiento elegirMovimiento(int i) {

        return movimientos.get(i);
    }

    public void atacar(Movimiento movimiento, Pokemon pokemon) {

        movimiento.usarMovimiento(this, pokemon);

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

    public void descansar() {

        estamina = estaminaMax;
    }

}
