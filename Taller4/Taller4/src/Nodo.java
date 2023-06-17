/**
 * Esta clase representa un Nodo
 * Cada nodo tiene un objeto tipo Pokemon
 */
public class Nodo {
    private Nodo next;
    private Nodo prev;
    private Pokemon dato;
    /**
     * Constructor de la clase Nodo.
     * Crea un nuevo nodo con el Pokémon especificado.
     *
     * @param dato el Pokémon asociado al nodo
     */
    public Nodo(Pokemon dato) {
        this.next = null;
        this.prev = null;
        this.dato = dato;
    }
    /**
     * Devuelve el siguiente nodo.
     *
     * @return el siguiente nodo
     */
    public Nodo getNext() {
        return next;
    }
    /**
     * Establece el siguiente nodo.
     *
     * @param next el siguiente nodo a establecer
     */

    public void setNext(Nodo next) {
        this.next = next;
    }
    /**
     * Devuelve el nodo anterior.
     *
     * @return el nodo anterior
     */

    public Nodo getPrev() {
        return prev;
    }
    /**
     * Establece el nodo anterior.
     *
     * @param prev el nodo anterior a establecer
     */
    public void setPrev(Nodo prev) {
        this.prev = prev;
    }
    /**
     * Devuelve el Pokémon almacenado en el nodo.
     *
     * @return el Pokémon almacenado en el nodo
     */
    public Pokemon getDato() {
        return dato;
    }
    /**
     * Establece el Pokémon a almacenar en el nodo.
     *
     * @param dato el Pokémon a establecer
     */
    public void setDato(Pokemon dato) {
        this.dato = dato;
    }
}
