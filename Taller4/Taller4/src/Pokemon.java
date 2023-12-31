/**
 * Constructor de la clase pokemon
 */
public class Pokemon {
    private int id;

    private String nombrePokemon;

    private String etapa;

    private String evolucionSiguiente;

    private String evolucionPrevia;

    private String tipo1;

    private String tipo2;

    public Pokemon(int id, String nombrePokemon, String etapa,
                   String evolucionSiguiente, String evolucionPrevia, String tipo1, String tipo2) {
        this.id = id;
        this.nombrePokemon = nombrePokemon;
        this.etapa = etapa;
        this.evolucionSiguiente = evolucionSiguiente;
        this.evolucionPrevia = evolucionPrevia;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public void setNombrePokemon(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }

    public String getEtapa() {
        return etapa;
    }

    public void setEtapa(String etapa) {
        this.etapa = etapa;
    }

    public String getEvolucionSiguiente() {
        return evolucionSiguiente;
    }

    public void setEvolucionSiguiente(String evolucionSiguiente) {
        this.evolucionSiguiente = evolucionSiguiente;
    }

    public String getEvolucionPrevia() {
        return evolucionPrevia;
    }

    public void setEvolucionPrevia(String evolucionPrevia) {
        this.evolucionPrevia = evolucionPrevia;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) {
        this.tipo1 = tipo1;
    }

    public String getTipo2() {
        return tipo2;
    }

    public void setTipo2(String tipo2) {
        this.tipo2 = tipo2;
    }
}
