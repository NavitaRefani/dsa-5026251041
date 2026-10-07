import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<String> registeredStudent = new LinkedHashSet<>();

        Scanner registeredScanner = new Scanner(Main.class.getResourceAsStream("registrations.txt"));
        while (registeredScanner.hasNextLine()) {
            String studentId = registeredScanner.nextLine();
            registeredStudent.add(studentId);
        }
        registeredScanner.close();

        List<String> checkIns = new ArrayList<>();
        Scanner checkInScanner = new Scanner(Main.class.getResourceAsStream("checkins.txt"));
        while (checkInScanner.hasNextLine()) {
            String studentId = checkInScanner.nextLine();
            checkIns.add(studentId);
        }
        checkInScanner.close();

        List<String> checkedInStudents = new ArrayList<>();
        int successfulCheckIns = 0;
        int rejectedAttempts = 0;
        
        System.out.println("===== Event Check-In Results =====");
        for (int i = 0; i < checkIns.size(); i++) {
            String studentId = checkIns.get(i);
            if (!registeredStudent.contains(studentId)) {
                System.out.println(studentId + ": Rejected (not registered)");
                rejectedAttempts++;
            } else if (checkedInStudents.contains(studentId)) {
                System.out.println(studentId + ": Rejected (already checked in)");
                rejectedAttempts++;
            } else {
                System.out.println(studentId + ": Checked in");
                successfulCheckIns++;
                checkedInStudents.add(studentId);
            }
        }

        int totalRegistered = registeredStudent.size();
        int absentStudents = totalRegistered - successfulCheckIns;

        System.out.println();
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students: " + totalRegistered);
        System.out.println("Successful check-ins: " + successfulCheckIns);
        System.out.println("Absent students: " + absentStudents);
        System.out.println("Rejected attempts: " + rejectedAttempts);
    }
}