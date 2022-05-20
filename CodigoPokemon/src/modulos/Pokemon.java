
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Pokemon {
    Scanner sc = new Scanner(System.in);
    Random random = new Random();

    private String nombre;
    private String mote;
    private int vitalidadMax;
    private int vitalidad;
    private int ataque;
    private int defensa;
    private int ataqueEspecial;
    private int defensaEspecial;
    private int velocidad;
    private int estaminaMax;
    private int estamina;
    private int nivel = 1;
    private int fertilidad = 5;
    private EnumTipos tipo;
    private EnumEstados estado = EnumEstados.SIN_ESTADO;
    private int experiencia = 0;
    private ArrayList<Movimiento> movimientos = new ArrayList<Movimiento>(4);
    private int contadorMovimientos;

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

    public int getEstaminaMax() {
        return estaminaMax;
    }

    public int getVitalidadMax() {
        return vitalidadMax;
    }

    public void setEstaminaMax(int estaminaMax) {
        this.estaminaMax = estaminaMax;
    }

    public void setVitalidadMax(int vitalidadMax) {
        this.vitalidadMax = vitalidadMax;
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

        if (estamina < 0) {

            this.estamina = 0;
        }
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

        if (this.vitalidad < 0) {

            this.vitalidad = 0;
        }
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

    public void remplazarMovimiento(int olvidar, Movimiento movimientoAprender) {

        movimientos.remove(olvidar - 1);
        movimientos.add(movimientoAprender);

    }

    public Movimiento elegirMovimiento(int i) {
        i--;
        return movimientos.get(i);
    }

    public void atacar(Movimiento movimiento, Pokemon pokemonRival) {

        if (estamina > movimiento.getCosteEstamina() && vitalidad > 0) {

            movimiento.usarMovimiento(this, pokemonRival);
        }

    }

    public void subirNivelRival(int nivel) {

        Random random = new Random();

        for (int i = 0; i < nivel; i++) {
            this.experiencia = 0;
            this.ataque = this.ataque + random.nextInt(4) + 1;
            this.ataqueEspecial = this.ataqueEspecial + random.nextInt(4) + 1;
            this.defensa = this.defensa + random.nextInt(4) + 1;
            this.defensaEspecial = this.defensaEspecial + random.nextInt(4) + 1;
            this.vitalidadMax = this.vitalidadMax + random.nextInt(4) + 1;
            this.velocidad = this.velocidad + random.nextInt(4) + 1;
        }
    }

    public void subirNivel(ArrayList<Movimiento> baseMovimientos) {

        Random random = new Random();

        if (experiencia == (nivel * 10)) {

            this.experiencia = 0;
            this.ataque = this.ataque + random.nextInt(4) + 1;
            this.ataqueEspecial = this.ataqueEspecial + random.nextInt(4) + 1;
            this.defensa = this.defensa + random.nextInt(4) + 1;
            this.defensaEspecial = this.defensaEspecial + random.nextInt(4) + 1;
            this.vitalidadMax = this.vitalidadMax + random.nextInt(4) + 1;
            this.velocidad = this.velocidad + random.nextInt(4) + 1;

            if (nivel % 3 == 0) {

                int movAprender = random.nextInt(13);

                if (contadorMovimientos < 4) {

                    this.aprenderMovimiento(baseMovimientos.get(movAprender));
                }

                else if (contadorMovimientos == 4) {

                    System.out.println("¿Quieres olvidar un movimiento?\n1.Si\2.No");
                    int yN = sc.nextInt();

                    if (yN == 1) {

                        int enumMovimiento = 0;

                        System.out.println("Selecciona un movimiento que olvidar");

                        for (Movimiento movimiento : movimientos) {

                            System.out.println(enumMovimiento + ". " + movimiento.getNombre());
                        }

                        int movOlvidar = sc.nextInt();

                        this.remplazarMovimiento(movOlvidar, baseMovimientos.get(movAprender));

                    }
                }
            }
        }
    }

    public void descansar() {

        estamina = estaminaMax;
    }

    public void curar() {

        this.setVitalidad(vitalidadMax);
    }

    public void ganarExperiencia(Pokemon pokemon, ArrayList<Movimiento> baseMovimientos) {

        if (pokemon.vitalidad == 0) {

            this.experiencia = experiencia + ((nivel + pokemon.nivel * 10) / 4);

            this.subirNivel(baseMovimientos);
        }
    }

    public void aprender4Movimientos(ArrayList<Movimiento> bMovimientos) {

        for (int e = 0; e < 4; e++) {

            int numMov = random.nextInt(13);

            this.aprenderMovimiento(bMovimientos.get(numMov));
        }
    }

    @Override
    public String toString() {
        return "Nombre:" + nombre + "\nVitalidad:" + vitalidad + "\nEstamina: " + estamina + "\nTipo: " + tipo +
                "\nEstado: " + estado + "\nAtaque: " + ataque;
    }
}
