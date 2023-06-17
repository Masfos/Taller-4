import ucn.StdOut;

/**
 * Esta clase representa una lista de nodos que contiene Pokémon.
 * Cada nodo en la lista contiene un objeto de tipo Pokemon.
 */
public class ListaNodos {
    private Nodo head;
    private Nodo tail;
    private int cantActual;
    /**
     * Crea una nueva instancia de la clase ListaNodos.
     * Inicializa los atributos de la lista.
     */
    public ListaNodos() {
        this.head = null;
        this.tail = null;
        this.cantActual = 0;
    }

    public Nodo getContiene(int id) {
        Nodo aux = head;

        while (aux != null) {
            if (aux.getDato().getId() == id) {
                return aux;
            }
            aux = aux.getNext();
        }

        return null;
    }
    /**
     * Busca un nodo que contiene un Pokémon con el ID especificado.
     *
     * @param "id" el ID del Pokémon a buscar
     * @return el nodo que contiene el Pokémon con el ID especificado, o null si no se encuentra
     */
    public Nodo getContiene(String nombre) {
        Nodo aux = head;

        while (aux != null) {
            if (aux.getDato().getNombrePokemon().equalsIgnoreCase(nombre)) {
                return aux;
            }
            aux = aux.getNext();
        }

        return null;
    }
    /**
     * Muestra todos los Pokémon en la lista.
     */
    public void mostrarLista (){
        Nodo nodo = this.tail;
        while (nodo.getNext() != this.tail ){
            StdOut.println(nodo.getDato().getId());
            StdOut.println(nodo.getDato().getNombrePokemon().trim());
            StdOut.println(nodo.getDato().getEtapa().trim());
            if (!nodo.getDato().getEvolucionPrevia().equalsIgnoreCase("")){
                StdOut.println(nodo.getDato().getEvolucionPrevia().trim());
            }

            if (!nodo.getDato().getEvolucionSiguiente().equals("")){
                StdOut.println(nodo.getDato().getEvolucionSiguiente().trim());
            }

            StdOut.println(nodo.getDato().getTipo1().trim());

            if (nodo.getDato().getTipo2() != null){
                StdOut.println(nodo.getDato().getTipo2().trim());
            }
            StdOut.println();

            nodo = nodo.getNext();
        }
        StdOut.println(nodo.getDato().getId());
        StdOut.println(nodo.getDato().getNombrePokemon().trim());
        StdOut.println(nodo.getDato().getEtapa().trim());
        if (!nodo.getDato().getEvolucionPrevia().equalsIgnoreCase("")){
            StdOut.println(nodo.getDato().getEvolucionPrevia().trim());
        }

        if (!nodo.getDato().getEvolucionSiguiente().equals("")){
            StdOut.println(nodo.getDato().getEvolucionSiguiente().trim());
        }

        StdOut.println(nodo.getDato().getTipo1().trim());

        if (nodo.getDato().getTipo2() != null){
            StdOut.println(nodo.getDato().getTipo2().trim());
        }

    }

    /**
     * Agrega un nodo al final de la lista.
     *
     * @param pokemon el Pokémon a agregar
     */

    public void agregarNodoFinal(Pokemon pokemon){
        Nodo nodo = new Nodo(pokemon);

        if (this.head == null && this.tail == null){
            this.head = nodo;
            nodo.setNext(nodo);
            this.tail = nodo;
            nodo.setPrev(nodo);
            this.cantActual++;
            return;
        }

        nodo.setPrev(this.head);
        nodo.setNext(this.tail);
        this.head.setNext(nodo);
        this.head=nodo;
        this.cantActual++;

    }

    /**
     * Obtiene el nodo inicial de la lista.
     *
     * @return el nodo inicial de la lista
     */

    public Nodo getHead() {
        return head;
    }
    /**
     * Obtiene el nodo inicial de la lista.
     *
     * @return el nodo inicial de la lista
     */

    public void setHead(Nodo head) {
        this.head = head;
    }
    /**
     * Obtiene el nodo inicial de la lista.
     *
     * @return el nodo inicial de la lista
     */
    public Nodo getTail() {
        return tail;
    }
    /**
     * Establece el nodo final de la lista.
     *
     * @param tail el nodo final a establecer
     */
    public void setTail(Nodo tail) {
        this.tail = tail;
    }
    /**
     * Obtiene la cantidad actual de nodos en la lista.
     *
     * @return la cantidad actual de nodos en la lista
     */

    public int getCantActual() {
        return cantActual;
    }
    /**
     * Establece la cantidad actual de nodos en la lista.
     *
     * @param cantActual la cantidad actual de nodos a establecer
     */

    public void setCantActual(int cantActual) {
        this.cantActual = cantActual;
    }
}
