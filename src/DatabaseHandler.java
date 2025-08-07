import entities.Patient;
import java.sql.*;

public class DatabaseHandler {

    
    private static final String URL = "jdbc:postgresql://localhost:5432/yourdbname";
    private static final String USER = "user117";
    private static final String PASSWORD = "goodpassword123";

    public static void insertPatient(Patient p) {
        System.out.println("Attempting to save patient to DB...");

        String sql = "INSERT INTO patients (patient_id, first_name, last_name, dob) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, p.getPatientId());
            ps.setString(2, p.getFirstName());
            ps.setString(3, p.getLastName());
            ps.setDate(4, java.sql.Date.valueOf(p.getDOB())); 

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Patient saved successfully: " + p);
            } else {
                System.out.println("Patient save failed.");
            }

        } catch (SQLException e) {
            System.out.println("DB insert error: " + e.getMessage());
        }
    }

    public static void readPatients() {
        System.out.println("Reading patients from database...");

        String sql = "SELECT * FROM patients";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            boolean hasResults = false;

            while (rs.next()) {
                hasResults = true;
                System.out.println("🧾 " + rs.getInt("patient_id") + " - " +
                        rs.getString("first_name") + " " +
                        rs.getString("last_name") + " - DOB: " +
                        rs.getString("dob"));
            }

            if (!hasResults) {
                System.out.println("No patients found in the database.");
            }

        } catch (SQLException e) {
            System.out.println( "DB read error: " + e.getMessage());
        }
    }
}


