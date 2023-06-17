import ucn.StdIn;

import java.io.IOException;
/**
 * Constructor de la clase Main
 */

public class Main {
    /**
     * Método principal que inicia el programa de la Pokédex.
     *
     * @param args los argumentos de línea de comandos (no se utilizan en este caso)
     * @throws IOException si ocurre un error de lectura de archivos
     */
    public static void main(String[] args) throws IOException {
        Pokedex pokedex = new PokedexKanto();
        pokedex.leerArchivos();
        System.out.println("\n\n\n\n");
        String opcion = null;



        while (true) {
            System.out.println("""
                ---- Pokédex Kanto ----
                                     
                [1] Buscar Pokémon por nombre
                [2] Buscar Pokémon por ID
                [3] Mostrar todos los Pokémon ordenados 
                
                                    
                [4] Salir
                """);
            System.out.print("Escoja una opción: ");
            opcion = StdIn.readLine();

            switch (opcion) {
                case "1" -> {
                    System.out.print("Ingrese el nombre del Pokémon: ");
                    String nombre = StdIn.readLine();
                    pokedex.buscarPorNombre(nombre);
                }
                case "2" -> {
                    System.out.print("Ingrese el ID del Pokémon: ");
                    int id = Integer.parseInt(StdIn.readLine());
                    pokedex.buscarPorID(id);
                }
                case "3" -> pokedex.orden();
                case "4" -> pokedex.cierreEpico();
                default -> {
                    System.out.println("Opción no válida, intente nuevamente.");
                }
            }

            System.out.println();
        }
    }
        //listaNodos.mostrarLista();
}
