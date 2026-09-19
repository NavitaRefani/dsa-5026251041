import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<PrintJob> jobs = new ArrayList<>();

        try{
            Scanner sc = new Scanner(new File("jobs.txt"));

            while (sc.hasNext()) {
                String type = sc.next();
                String id = sc.next();
                int pages = sc.nextInt();

                if(type.equalsIgnoreCase("MONO")) {
                    jobs.add(new MonoPrint(id, pages));
                } else if (type.equalsIgnoreCase("COLOUR")) {
                    jobs.add(new ColourPrint(id, pages));
                }
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File jobs.txt not found");
            return;
        }

        for (PrintJob job : jobs) {
            System.out.println(job.summary());
        }
    }
}
