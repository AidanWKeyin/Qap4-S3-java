import entities.Drug;
import entities.Patient;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Application Started Successfully!");
        displayMenu(sc);

        sc.close();
        System.out.println("Application Closed.");
    }

    public static void displayMenu(Scanner sc) {
        System.out.println("\n========= MENU =========");
        System.out.println("1. Save Drug to File");
        System.out.println("2. Read Drugs from File");
        System.out.println("3. Save Patient to DB");
        System.out.println("4. Read Patients from DB");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");

        int choice;
        if (sc.hasNextInt()) {
            choice = sc.nextInt();
            sc.nextLine();
        } else {
            System.out.println("Invalid input. Please enter a number from 1 to 5.");
            return;
        }

        switch (choice) {
            case 1:
                System.out.println("Save Drug to File selected.");

                System.out.print("Enter drug ID: ");
                int drugId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter drug name: ");
                String drugName = sc.nextLine();

                System.out.print("Enter dosage (mg): ");
                int dosage = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter drug cost: ");
                float drugCost = sc.nextFloat();
                sc.nextLine();

                Drug newDrug = new Drug(drugId, drugName, dosage, drugCost);

                // Save drug to file here
                FileHandler.saveDrug(newDrug);

                System.out.println("Drug saved: " + newDrug);
                break;

            case 2:
                System.out.println("Reading Drugs from File...");
                FileHandler.readDrugs();
                break;

            case 3:
                System.out.println("Saving Patient to DB...");

                System.out.print("Enter patient ID: ");
                int patientId = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter patient first name: ");
                String firstName = sc.nextLine();

                System.out.print("Enter patient last name: ");
                String lastName = sc.nextLine();

                System.out.print("Enter patient DOB (YYYY-MM-DD): ");
                String dob = sc.nextLine();

                Patient patient = new Patient(patientId, firstName, lastName, dob);

                DatabaseHandler.insertPatient(patient);

                System.out.println("Patient saved: " + patient);
                break;

            case 4:
                System.out.println("Reading Patients from DB...");
                DatabaseHandler.readPatients();
                break;

            case 5:
                System.out.println("Exiting. Goodbye!");
                break;

            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
}
