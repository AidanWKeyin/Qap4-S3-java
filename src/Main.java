import entities.Drug;
import entities.Patient;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\nMenu:\n1. Save Drug to File\n2. Read Drugs from File\n3. Save Patient to DB\n4. Read Patients from DB\n5. Exit");
            int choice = sc.nextInt();
            sc.nextLine();  // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.println("Enter drugId, drugName, drugCost, dosage:");
                    int id = sc.nextInt(); sc.nextLine();
                    String name = sc.nextLine();
                    double cost = sc.nextDouble(); sc.nextLine();
                    String dosage = sc.nextLine();
                    FileHandler.saveDrug(new Drug(id, name, cost, dosage));
                }
                case 2 -> FileHandler.readDrugs();
                case 3 -> {
                    System.out.println("Enter patientId, firstName, lastName, DOB (YYYY-MM-DD):");
                    int id = sc.nextInt(); sc.nextLine();
                    String first = sc.nextLine();
                    String last = sc.nextLine();
                    String dob = sc.nextLine();
                    DatabaseHandler.insertPatient(new Patient(id, first, last, dob));
                }
                case 4 -> DatabaseHandler.readPatients();
                case 5 -> run = false;
                default -> System.out.println("Invalid choice");
            }
        }
        sc.close();
    }
}
