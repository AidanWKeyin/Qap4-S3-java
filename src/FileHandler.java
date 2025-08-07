import entities.Drug;
import java.io.*;


public class FileHandler {
    private static final String FILE_NAME = "drugs.txt";

    public static void saveDrug(Drug drug) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            bw.write(drug.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error writing to file.");
        }
    }

    public static void readDrugs() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                Drug d = Drug.fromString(line);
                System.out.println(d);
            }
        } catch (IOException e) {
            System.out.println("Error reading file.");
        }
    }
}
