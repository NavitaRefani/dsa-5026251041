import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> side_dishes =  new LinkedList<>();
        LinkedList<String[]> drinks =  new LinkedList<>();
        LinkedList<String[]> success = new LinkedList<>();

        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        Scanner scanner = new Scanner(Main.class.getResourceAsStream("orders.txt"));

        while(scanner.hasNext()){
            String[] order = new String[4];
            String name = scanner.next();
            String side_dish = scanner.next();
            String drink = scanner.next();
            String table = scanner.next();
            orders.add(new String[]{name, side_dish, drink, table});
        }

        scanner.close();

        side_dishes.add(new String[]{"Bakso", "2"});
        side_dishes.add(new String[]{"Sate", "1"});
        side_dishes.add(new String[]{"Soto", "2"});

        drinks.add(new String[]{"EsTeh", "4"});
        drinks.add(new String[]{"EsJeruk", "2"});

        queue.addAll(orders);

        while(!queue.isEmpty()){
            String[] order = queue.poll();
            String side_dish = order[1];
            String drink = order[2];
        }

        String[] foodRecord = null;
            if (!side_dishes.equals("-")){
                for(String[] f : side_dishes) {
                    if (f[0].equals(side_dishes)){
                        foodRecord = f;
                        break;
                    }
                }
            }

        String drinkRecord = null;
            if (!drinks.equals("-")) {
                for (String[] d : drinks) {
                    if (d[0].equals(drinks)) {
                        drinkRecord = d;
                        break;
                    }
                }
            }

        boolean dishConfirm = side_dishes.equals("-") || Integer.parseInt(foodRecord[1]) > 0;
        boolean drinkConfirm = drinks.equals("-") || Integer.parseInt(drinkRecord[1]) > 0;
            if (dishConfirm && drinkConfirm) {
                if (foodRecord != null) {
                    foodRecord[1] = String.valueOf(Integer.parseInt(foodRecord[1]) - 1);
                }
                if (drinkRecord != null) {
                    drinkRecord[1] = String.valueOf(Integer.parseInt(drinkRecord[1]) - 1);
                }

                success.add(order);

                else {
                    failed.push(order);
                }
            }

        System.out.println();
        System.out.println("=== Successfully Processed Orders ===");
        for (String[] order : success){
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }

        System.out.println();
        System.out.println("=== Remaining Food Stock ===");
        for (String[] f : foods) {
            System.out.println(f[0] + " : " + f[1]);
        }

        System.out.println();
        System.out.println("=== Remaining Drink Stock ===");
        for (String[] d : drinks) {
            System.out.println(d[0] + " : " + d[1]);
        }

        System.out.println();
        System.out.println("=== Failed Orders ===");
        while (!failed.isEmpty()) {
            String[] order = failed.pop();
            System.out.println(order[0] + " " + order[1] + " " + order[2] + " " + order[3]);
        }

    }
}
