import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // problem 1

        List<String> playlist = new ArrayList<>();
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ", 2);
            String operation = parts[0];
            if (operation.equals("ADD")) {
                String song = parts[1];
                playlist.add(song);
            } else if (operation.equals("REMOVE")) {
                String song = parts[1];
                if (playlist.contains(song)) {
                    playlist.remove(song);
                }
            } else if (operation.equals("INSERT")) {
                String[] insertParts = line.split(" ", 3);
                int index = Integer.parseInt(insertParts[1]);
                String song = insertParts[2];
                playlist.add(index, song);
            }
        }

        scanner.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total Songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        // problem 2
        Set<String> participants = new LinkedHashSet<>();
        int registDuplicates = 0;
        scanner = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            if (participants.contains(name)) {
                registDuplicates++;
            } else {
                participants.add(name);
            }
        }

        scanner.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int number = 1;
        for (String name : participants) {
            System.out.println(number + ". " + name);
            number++;
        }
        System.out.println("Duplicate registrations: " + registDuplicates);

        // problem 3
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedsales = 0;
        scanner = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            String type = parts[0];
            String product = parts[1];
            int quantity = Integer.parseInt(parts[2]);

            if (type.equals("ADD")) {
                if (inventory.containsKey(product)) {
                    int current = inventory.get(product);
                    inventory.put(product, current + quantity);
                } else {
                    inventory.put(product, quantity);
                }
            } else if (type.equals("SELL")) {
                if (inventory.containsKey(product)) {
                    int current = inventory.get(product);
                    if (current >= quantity) {
                        inventory.put(product, current - quantity);
                    } else {
                        failedsales++;
                    }
                } else {
                    failedsales++;
                }
            }
        }

        scanner.close();

        System.out.println("===== Problem 3 =====");
        for (String product : inventory.keySet()) {
            System.out.println(product + ": " + inventory.get(product));
        }
        System.out.println("Failed sales: " + failedsales);

    }
}