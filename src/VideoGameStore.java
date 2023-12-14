import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class VideoGameStore {
    private Map<String, Double> games;

    public VideoGameStore() {
        this.games = new TreeMap<>();
    }

    public void addGame(String name, double price) {
        if (name != null && !name.trim().isEmpty()) {
            if (!games.containsKey(name)) {
                games.put(name, price);
                System.out.println("Producte '" + name + "' afegit amb èxit.");
            } else {
                System.out.println("Error: El producte ja existeix.");
            }
        } else {
            System.out.println("Error: El nom del videojoc no pot ser nul o buit.");
        }
    }

    public void updatePrice(String name, double newPrice) {
        if (games.containsKey(name)) {
            games.put(name, newPrice);
            System.out.println("Preu del producte '" + name + "' actualitzat amb èxit.");
        } else {
            System.out.println("Error: Producte desconegut.");
        }
    }

    public void deleteGame(String name) {
        if (games.containsKey(name)) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Estàs segur d’esborrar el producte '" + name + "'? (Sí/No): ");
            String confirmation = scanner.nextLine().trim().toLowerCase();

            if (confirmation.equals("si")) {
                games.remove(name);
                System.out.println("Producte '" + name + "' esborrat amb èxit.");
            } else {
                System.out.println("Esborrament cancel·lat.");
            }
        } else {
            System.out.println("Error: Producte desconegut.");
        }
    }

    public void displayGames() {
        if (!games.isEmpty()) {
            System.out.println("\nLlista de videojocs ordenats alfabèticament:");
            for (Map.Entry<String, Double> entry : games.entrySet()) {
                System.out.println(entry.getKey() + " - Preu: " + entry.getValue());
            }
        } else {
            System.out.println("La llista de videojocs està buida.");
        }
    }

    public static void main(String[] args) {
        VideoGameStore store = new VideoGameStore();
        Scanner scanner = new Scanner(System.in);

        boolean salir = false;

        while (!salir) {
            System.out.println("\nMenú:");
            System.out.println("1. Afegir videojoc");
            System.out.println("2. Actualitzar preu");
            System.out.println("3. Esborrar videojoc");
            System.out.println("4. Mostrar videojocs ordenats alfabèticament");
            System.out.println("5. Sortir");
            System.out.print("Escull una opció: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Introdueix el nom del videojoc: ");
                    String name = scanner.nextLine();
                    System.out.print("Introdueix el preu del videojoc: ");
                    double price = scanner.nextDouble();
                    store.addGame(name, price);
                    break;
                case 2:
                    System.out.print("Introdueix el nom del videojoc a actualitzar: ");
                    String gameToUpdate = scanner.nextLine();
                    System.out.print("Introdueix el nou preu del videojoc: ");
                    double newPrice = scanner.nextDouble();
                    store.updatePrice(gameToUpdate, newPrice);
                    break;
                case 3:
                    System.out.print("Introdueix el nom del videojoc a esborrar: ");
                    String gameToDelete = scanner.nextLine();
                    store.deleteGame(gameToDelete);
                    break;
                case 4:
                    store.displayGames();
                    break;
                case 5:
                    System.out.println("Sortint...");
                    salir = true;
                    break;
                default:
                    System.out.println("Opció no vàlida. Torna a provar.");
            }
        }
    }
}