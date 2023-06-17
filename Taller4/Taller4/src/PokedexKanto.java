import ucn.ArchivoEntrada;
import ucn.Registro;
import ucn.StdIn;
import ucn.StdOut;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Implementación de la interfaz Pokedex para la región de Kanto.
 */
public class PokedexKanto implements Pokedex {
    private ListaNodos listaNodos;
    private LinkedList<Nodo> linkedList;
    private ArrayList<String> arrayList;
    private ArrayList<Integer> arrayListInt;

    /**
     * Crea una instancia de la Pokedex de Kanto.
     */
    public PokedexKanto() {
        listaNodos = new ListaNodos();
        linkedList = new LinkedList<>();
        arrayList = new ArrayList<>();
        arrayListInt = new ArrayList<>();
    }

    /**
     * Lee los archivos de datos de los Pokémon de la región de Kanto.
     *
     * @throws IOException Si ocurre un error al leer los archivos.
     */
    @Override
    public void leerArchivos() throws IOException {
        ArchivoEntrada archivoEntrada = new ArchivoEntrada("kanto.txt");
        Pokemon pokemon;

        while (!archivoEntrada.isEndFile()) {
            Registro registro = archivoEntrada.getRegistro();

            String id = registro.getString().trim();

            while (id.equals("")) {
                registro = archivoEntrada.getRegistro();
                id = registro.getString().trim();
            }

            String nombrePokemon = registro.getString().trim();
            String etapa = registro.getString().trim();

            if (etapa.equalsIgnoreCase("basico")) {
                String evolucionSiguiente;
                String tipo1;
                String tipo2;

                if (nombrePokemon.trim().equalsIgnoreCase("Eevee")) {
                    evolucionSiguiente = "Vaporeon \nJolteon\nFlareon";
                    tipo1 = "normal";
                    tipo2 = "normal";
                } else {
                    evolucionSiguiente = registro.getString();
                    tipo1 = registro.getString();
                    tipo2 = registro.getString();
                }

                pokemon = new Pokemon(Integer.parseInt(id), nombrePokemon, etapa, evolucionSiguiente, "", tipo1, tipo2);
            } else if (etapa.equalsIgnoreCase("Primera Evolucion")) {
                String evolucionPrevia = registro.getString();
                String evolucionSiguiente = registro.getString();
                String tipo1 = registro.getString();
                String tipo2 = registro.getString();

                pokemon = new Pokemon(Integer.parseInt(id), nombrePokemon, etapa, evolucionSiguiente, evolucionPrevia, tipo1, tipo2);
            } else {
                String evolucionSiguiente = registro.getString();
                String tipo1 = registro.getString();
                String tipo2 = registro.getString();

                pokemon = new Pokemon(Integer.parseInt(id), nombrePokemon, etapa, evolucionSiguiente, "", tipo1, tipo2);
            }

            listaNodos.agregarNodoFinal(pokemon);
        }

        archivoEntrada.close();
    }
    /**
     * Realiza el cierre épico de la Pokedex de Kanto.
     * Cierra el programa después de mostrar un mensaje de despedida.
     */
    @Override
    public void cierreEpico() {
        StdOut.println("********************************************************************************");
        StdOut.println("                        ¡Pokedex de Kanto cerrada!");
        StdOut.println("           Has explorado todos los Pokémon de la región de Kanto.");
        StdOut.println("               ¡Esperamos que hayas tenido grandes aventuras!");
        StdOut.println("********************************************************************************");
        System.exit(0); // Cierra el programa
    }
    /**
     * Busca un Pokémon por su ID y muestra su información.
     *
     * @param id El ID del Pokémon a buscar.
     */
    @Override
    public void buscarPorID(int id) {
        Nodo nodo = listaNodos.getContiene(id);

        if (nodo != null) {
            System.out.println(nodo.getDato().getId());
            System.out.println(nodo.getDato().getNombrePokemon().trim());
            System.out.println(nodo.getDato().getEtapa().trim());

            if (!nodo.getDato().getEvolucionPrevia().equalsIgnoreCase("")) {
                System.out.println(nodo.getDato().getEvolucionPrevia().trim());
            }

            if (!nodo.getDato().getEvolucionSiguiente().equals("")) {
                System.out.println(nodo.getDato().getEvolucionSiguiente().trim());
            }

            System.out.println(nodo.getDato().getTipo1().trim());

            if (nodo.getDato().getTipo2() != null) {
                System.out.println(nodo.getDato().getTipo2().trim());
            }

            System.out.println();
        } else {
            System.out.println("No se encontró el Pokémon con ese ID.");
        }
    }

    /**
     * Busca un Pokémon por su nombre y muestra su información.
     *
     * @param nombre El nombre del Pokémon a buscar.
     */
    @Override
    public void buscarPorNombre(String nombre) {
        Nodo nodo = listaNodos.getContiene(nombre);

        if (nodo != null) {
            System.out.println(nodo.getDato().getId());
            System.out.println(nodo.getDato().getNombrePokemon().trim());
            System.out.println(nodo.getDato().getEtapa().trim());

            if (!nodo.getDato().getEvolucionPrevia().equalsIgnoreCase("")) {
                System.out.println(nodo.getDato().getEvolucionPrevia().trim());
            }

            if (!nodo.getDato().getEvolucionSiguiente().equals("")) {
                System.out.println(nodo.getDato().getEvolucionSiguiente().trim());
            }

            System.out.println(nodo.getDato().getTipo1().trim());

            if (nodo.getDato().getTipo2() != null) {
                System.out.println(nodo.getDato().getTipo2().trim());
            }

            System.out.println();
        } else {
            System.out.println("No se encontró el Pokémon con ese nombre.");
        }
    }

    /**
     * Ordena los Pokémon de la Pokedex de Kanto según un criterio dado por el usuario.
     */
    @Override
    public void orden() {
        Nodo aux = listaNodos.getTail();
        for (int i = 0; i < listaNodos.getCantActual(); i++) {
            linkedList.add(aux);
            arrayList.add(aux.getDato().getNombrePokemon());
            arrayListInt.add(aux.getDato().getId());
            aux = aux.getNext();
        }
        arrayList.sort(Comparator.naturalOrder());
        arrayListInt.sort(Comparator.naturalOrder());

        StdOut.println("\n\n\n\n");
        System.out.println("""
                [1] Ordenar alfabéticamente
                [2] Ordenar por ID
                """);
        System.out.print("Escoja una opción de ordenamiento: ");
        String ordenamiento = StdIn.readLine();

        switch (ordenamiento) {
            case "2" -> ordenAlfabetico(linkedList,arrayListInt,listaNodos);
            case "1" -> ordenNumerico(linkedList,arrayListInt,listaNodos);
            default -> System.out.println("Opción no válida, intente nuevamente.");
    }
}

    /**
     * Ordena los Pokémon en orden alfabético y los imprime.
     *
     * @param linkedList  Lista enlazada que contiene los nodos de los Pokémon.
     * @param arrayList   Lista de enteros que contiene los IDs de los Pokémon en el orden deseado.
     * @param listaNodos  Lista de nodos que contiene los Pokémon.
     */
    private void ordenAlfabetico(LinkedList<Nodo> linkedList, ArrayList<Integer> arrayList,
                                 ListaNodos listaNodos) {
        for (int i = 0; i < listaNodos.getCantActual(); i++) {

            Nodo aux1 = listaNodos.getContiene(arrayList.get(i));
            linkedList.indexOf(aux1);

            Nodo nodo= linkedList.get(linkedList.indexOf(aux1));

            StdOut.println(nodo.getDato().getId());
            StdOut.println(nodo.getDato().getNombrePokemon().trim());
            StdOut.println(nodo.getDato().getEtapa().trim());
            if (!nodo.getDato().getEvolucionPrevia().equalsIgnoreCase("")) {
                StdOut.println(nodo.getDato().getEvolucionPrevia().trim());
            }

            if (!nodo.getDato().getEvolucionSiguiente().equals("")) {
                StdOut.println(nodo.getDato().getEvolucionSiguiente().trim());
            }

            StdOut.println(nodo.getDato().getTipo1().trim());

            if (nodo.getDato().getTipo2() != null) {
                StdOut.println(nodo.getDato().getTipo2().trim());
            }
            StdOut.println();
        }
    }
    /**
     * Ordena los Pokémon por ID y los imprime.
     *
     * @param linkedList    Lista enlazada que contiene los nodos de los Pokémon.
     * @param arrayListInt  Lista de enteros que contiene los IDs de los Pokémon en el orden deseado.
     * @param listaNodos    Lista de nodos que contiene los Pokémon.
     */
    private void ordenNumerico(LinkedList<Nodo> linkedList, ArrayList<Integer> arrayListInt,
                               ListaNodos listaNodos) {
        for (int i = 0; i < listaNodos.getCantActual(); i++) {

            Nodo aux1 = listaNodos.getContiene(arrayListInt.get(i));
            linkedList.indexOf(aux1);

            Nodo nodo= linkedList.get(linkedList.indexOf(aux1));

            StdOut.println(nodo.getDato().getId());
            StdOut.println(nodo.getDato().getNombrePokemon().trim());
            StdOut.println(nodo.getDato().getEtapa().trim());
            if (!nodo.getDato().getEvolucionPrevia().equalsIgnoreCase("")) {
                StdOut.println(nodo.getDato().getEvolucionPrevia().trim());
            }

            if (!nodo.getDato().getEvolucionSiguiente().equals("")) {
                StdOut.println(nodo.getDato().getEvolucionSiguiente().trim());
            }

            StdOut.println(nodo.getDato().getTipo1().trim());

            if (nodo.getDato().getTipo2() != null) {
                StdOut.println(nodo.getDato().getTipo2().trim());
            }
            StdOut.println();
        }
    }

    }
