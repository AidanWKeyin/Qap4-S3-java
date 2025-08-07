package entities;

public class Patient {
    private int patientId;
    private String patientFirstName;
    private String patientLastName;
    private String patientDOB;

    public Patient(int patientId, String firstName, String lastName, String dob) {
        this.patientId = patientId;
        this.patientFirstName = firstName;
        this.patientLastName = lastName;
        this.patientDOB = dob;
    }

    @Override
    public String toString() {
        return patientId + " - " + patientFirstName + " " + patientLastName + " - DOB: " + patientDOB;
    }

    public int getPatientId() { return patientId; }
    public String getFirstName() { return patientFirstName; }
    public String getLastName() { return patientLastName; }
    public String getDOB() { return patientDOB; }
}

