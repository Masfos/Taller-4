import java.io.IOException;
/**
 * Interfaz para una Pokedex que proporciona funcionalidades relacionadas con la gestión de Pokémon.
 */
public interface Pokedex {
    /**
     * Lee los archivos necesarios para cargar los datos de los Pokémon.
     *
     * @throws IOException Si ocurre un error al leer los archivos.
     */
    void leerArchivos() throws IOException;
    /**
     * Realiza un cierre épico de la Pokedex.
     * Realiza una acción especial de cierre que puede variar según la implementación.
     */
    void cierreEpico();
    /**
     * Busca un Pokémon por su ID.
     *
     * @param id El ID del Pokémon a buscar.
     */
    void buscarPorID(int id);
    /**
     * Busca un Pokémon por su nombre.
     *
     * @param nombre El nombre del Pokémon a buscar.
     */

    void buscarPorNombre(String nombre);
    /**
     * Ordena los Pokémon de alguna manera específica.
     * El orden puede variar según la implementación.
     */
    void orden();
}
