import entities.Patient;
import java.sql.*;

public class DatabaseHandler {
    private static final String URL = "jdbc:postgresql://localhost:5432/yourdbname";
    private static final String USER = "youruser";
    private static final String PASSWORD = "yourpassword";

    public static void insertPatient(Patient p) {
        String sql = "INSERT INTO patients (id, firstname, lastname, dob) VALUES (?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getPatientId());
            ps.setString(2, p.getFirstName());
            ps.setString(3, p.getLastName());
            ps.setString(4, p.getDOB());
            ps.executeUpdate();
            System.out.println("Patient added to DB.");
        } catch (SQLException e) {
            System.out.println("DB insert error: " + e.getMessage());
        }
    }

    public static void readPatients() {
        String sql = "SELECT * FROM patients";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " +
                                   rs.getString("firstname") + " " +
                                   rs.getString("lastname") + " - DOB: " +
                                   rs.getString("dob"));
            }
        } catch (SQLException e) {
            System.out.println("DB read error: " + e.getMessage());
        }
    }
}
